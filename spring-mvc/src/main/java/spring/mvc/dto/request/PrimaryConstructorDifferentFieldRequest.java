package spring.mvc.dto.request;

public class PrimaryConstructorDifferentFieldRequest {

    private final Long sourceStationId;
    private final Long targetStationId;
    private final int age;

    public PrimaryConstructorDifferentFieldRequest(final Long source, final Long target, final int age) {
        this.sourceStationId = source;
        this.targetStationId = target;
        this.age = age;
    }

    public Long getSourceStationId() {
        return sourceStationId;
    }

    public Long getTargetStationId() {
        return targetStationId;
    }

    public int getAge() {
        return age;
    }
}
