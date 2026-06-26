/**
 * 학생 클래스
 */
public class Student {
    private final int id; // 학생 아이디 (한 번 정하면 바꾸지 않음)
    private final String name; // 학생 이름 (한 번 정하면 바꾸지 않음)
    private int score; // (수정 가능)

    public Student(int id, String name, int score) {
        this.id = id;
        this.name = name;
        this.score = score;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getScore() {
        return score;
    }

    // 새 점수로 수정하는 메서드
    public void updateScore(int targetScore) {
        if(targetScore < 0 || targetScore > 100) {
            throw new IllegalArgumentException("잘못된 점수 입니다.");
        }
        this.score = targetScore;
    }

    // 점수에 따라 합격 상태를 돌려주는 메서드
    public PassStatus getPassStatus() {
        return this.score >= 70 ? PassStatus.PASSED : PassStatus.FAILED;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", score=" + score +
                '}';
    }
}
