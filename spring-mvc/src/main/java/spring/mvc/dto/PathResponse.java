package spring.mvc.dto;

import java.util.Objects;

public class PathResponse {

    private final Long source;
    private final Long target;
    private final int age;

    public PathResponse(final Long source, final Long target, final int age) {
        this.source = source;
        this.target = target;
        this.age = age;
    }

    public Long getSource() {
        return source;
    }

    public Long getTarget() {
        return target;
    }

    public int getAge() {
        return age;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        final PathResponse that = (PathResponse) o;
        return age == that.age && Objects.equals(source, that.source) && Objects.equals(target,
                that.target);
    }

    @Override
    public int hashCode() {
        return Objects.hash(source, target, age);
    }
}
