package spring.mvc.dto.request;

public class ManyPublicAndNoDefaultConstructorRequest {

    private Long source;
    private Long target;
    private int age;

    public ManyPublicAndNoDefaultConstructorRequest(final Long source, final Long target, final int age) {
        this.source = source;
        this.target = target;
        this.age = age;
    }

    public ManyPublicAndNoDefaultConstructorRequest(final Long source, final Long target) {
        this.source = source;
        this.target = target;
    }

    public ManyPublicAndNoDefaultConstructorRequest(final int age) {
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

    public void setSource(final Long source) {
        this.source = source;
    }

    public void setTarget(final Long target) {
        this.target = target;
    }

    public void setAge(final int age) {
        this.age = age;
    }
}
