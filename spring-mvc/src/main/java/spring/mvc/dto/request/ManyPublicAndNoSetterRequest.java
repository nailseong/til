package spring.mvc.dto.request;

public class ManyPublicAndNoSetterRequest {

    private Long source;
    private Long target;
    private int age;

    public ManyPublicAndNoSetterRequest() {
    }

    public ManyPublicAndNoSetterRequest(final Long source, final Long target, final int age) {
        this.source = source;
        this.target = target;
        this.age = age;
    }

    public ManyPublicAndNoSetterRequest(final Long source, final Long target) {
        this(source, target, 0);
    }

    public ManyPublicAndNoSetterRequest(final int age) {
        this(null, null, age);
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
}
