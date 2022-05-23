package spring.mvc.dto.request;

public class ManyPublicAndDefaultConstructorRequest {

    private Long source;
    private Long target;
    private int age;

    public ManyPublicAndDefaultConstructorRequest() {
    }

    public ManyPublicAndDefaultConstructorRequest(final Long source, final Long target, final int age) {
        this.source = source;
        this.target = target;
        this.age = age;
    }

    public Long getSource() {
        return source;
    }

    public void setSource(final Long source) {
        this.source = source;
    }

    public Long getTarget() {
        return target;
    }

    public void setTarget(final Long target) {
        this.target = target;
    }

    public int getAge() {
        return age;
    }

    public void setAge(final int age) {
        this.age = age;
    }
}
