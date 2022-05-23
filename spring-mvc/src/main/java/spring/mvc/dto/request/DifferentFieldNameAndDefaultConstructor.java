package spring.mvc.dto.request;

public class DifferentFieldNameAndDefaultConstructor {

    private Long sourceStationId;
    private Long targetStationId;
    private int age;

    public DifferentFieldNameAndDefaultConstructor() {
    }

    public Long getSourceStationId() {
        return sourceStationId;
    }

    // 메서드 이름이 setSourceStationId 인 경우 -> 바인딩 실패
    public void setSource(final Long sourceStationId) {
        this.sourceStationId = sourceStationId;
    }

    public Long getTargetStationId() {
        return targetStationId;
    }

    public void setTarget(final Long targetStationId) {
        this.targetStationId = targetStationId;
    }

    public int getAge() {
        return age;
    }

    public void setAge(final int age) {
        this.age = age;
    }
}
