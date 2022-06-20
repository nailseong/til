package spring.threadlocal.config.log;

import java.util.UUID;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class Trace {

    private static final int INITIAL_LEVEL = 0;

    private final String id;
    private final int level;

    public Trace() {
        this(createId(), INITIAL_LEVEL);
    }

    private static String createId() {
        return UUID.randomUUID().toString().substring(24);
    }

    public Trace toNext() {
        return new Trace(id, level + 1);
    }

    public Trace toPrevious() {
        return new Trace(id, level - 1);
    }

    public boolean isInitialLevel() {
        return level == INITIAL_LEVEL;
    }
}
