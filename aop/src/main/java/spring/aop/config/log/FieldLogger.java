package spring.aop.config.log;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class FieldLogger implements Logger {

    private static final String BEGIN_SUFFIX = "-->";
    private static final String END_SUFFIX = "<--";
    private static final String DEPTH = "   |";
    private static final String EXCEPTION_SUFFIX = "<X-";

    private Trace traceHolder;

    @Override
    public TraceStatus begin(final String message) {
        syncTrace();
        final Trace trace = traceHolder;
        final long startTimeMillis = System.currentTimeMillis();

        log.info("[{}] {}{}",
                trace.getId(),
                toLevel(trace.getLevel(), BEGIN_SUFFIX),
                message);
        return new TraceStatus(trace, startTimeMillis, message);
    }

    private void syncTrace() {
        if (traceHolder == null) {
            traceHolder = new Trace();
            return;
        }
        traceHolder = traceHolder.toNext();
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

    private void complete(final TraceStatus traceStatus, final Exception e) {
        final Trace trace = traceStatus.getTrace();
        final long resultTimeMillis = System.currentTimeMillis() - traceStatus.getStartTimeMillis();

        logResponse(traceStatus, e, trace, resultTimeMillis);
        releaseTrace();
    }

    private void logResponse(final TraceStatus traceStatus, final Exception e, final Trace trace,
                             final long resultTimeMillis) {
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

    private void releaseTrace() {
        if (traceHolder.isInitialLevel()) {
            traceHolder = null;
            return;
        }
        traceHolder = traceHolder.toPrevious();
    }

    @Override
    public void exception(final TraceStatus traceStatus, final Exception e) {
        complete(traceStatus, e);
    }
}
