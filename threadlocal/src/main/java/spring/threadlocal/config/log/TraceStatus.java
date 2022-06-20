package spring.threadlocal.config.log;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public class TraceStatus {

    private final Trace trace;
    private final Long startTimeMillis;
    private final String message;
}
