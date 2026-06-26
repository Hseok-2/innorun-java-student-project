/**
 * 합격 여부를 나타내는 Enum 클래스
 */
public enum PassStatus {
    PASSED("합격"), FAILED("불합격");

    private final String description;

    PassStatus(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
