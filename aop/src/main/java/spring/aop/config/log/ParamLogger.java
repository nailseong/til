package spring.aop.config.log;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class ParamLogger implements Logger {

    private static final String BEGIN_SUFFIX = "-->";
    private static final String END_SUFFIX = "<--";
    private static final String DEPTH = "   |";
    private static final String EXCEPTION_SUFFIX = "<X-";

    @Override
    public TraceStatus begin(final String message) {
        final Trace trace = new Trace();
        final long startTimeMillis = System.currentTimeMillis();

        log.info("[{}] {}{}",
                trace.getId(),
                toLevel(trace.getLevel(), BEGIN_SUFFIX),
                message);
        return new TraceStatus(trace, startTimeMillis, message);
    }

    private String toLevel(final int level, final String suffix) {
        if (level == 0) {
            return "";
        }
        return "|" + DEPTH.repeat(level - 1) + suffix;
    }

    @Override
    public void end(final TraceStatus traceStatus) {
        complete(traceStatus, null);
    }

    public TraceStatus beginSync(final Trace beforeTrace, final String message) {
        final Trace trace = beforeTrace.toNext();
        final long startTimeMillis = System.currentTimeMillis();

        log.info("[{}] {}{}",
                trace.getId(),
                toLevel(trace.getLevel(), BEGIN_SUFFIX),
                message);
        return new TraceStatus(trace, startTimeMillis, message);
    }

    private void complete(final TraceStatus traceStatus, final Exception e) {
        final Trace trace = traceStatus.getTrace();
        final long resultTimeMillis = System.currentTimeMillis() - traceStatus.getStartTimeMillis();

        if (e == null) {
            log.info("[{}] {}{} time={}ms",
                    trace.getId(),
                    toLevel(trace.getLevel(), END_SUFFIX),
                    traceStatus.getMessage(),
                    resultTimeMillis);
            return;
        }
        log.info("[{}] {}{} time={}ms ex={}",
                trace.getId(),
                toLevel(trace.getLevel(), EXCEPTION_SUFFIX),
                traceStatus.getMessage(),
                resultTimeMillis,
                e.toString());
    }

    @Override
    public void exception(final TraceStatus traceStatus, final Exception e) {
        complete(traceStatus, e);
    }
}
