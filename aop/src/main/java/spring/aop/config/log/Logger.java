package spring.aop.config.log;

public interface Logger {

    TraceStatus begin(String message);

    void end(TraceStatus traceStatus);

    void exception(TraceStatus traceStatus, Exception e);
}
