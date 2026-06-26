import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

/**
 * 강의실 클래스
 */
public class Classroom {

    private final List<Student> students;

    public Classroom() {
        this.students = new ArrayList<>();
    }

    // 전체 학생 목록을 돌려주는 메서드
    public List<Student> getStudents() {
        return new ArrayList<>(this.students);
    }

    // 학생 한 명을 목록에 추가하는 메서드
    public void addStudent(Student student) {
        students.add(student);
    }

    // id가 같은 학생을 찾는 메서드
    public Optional<Student> findById(int id) {
        return this.students.stream()
                .filter(s -> s.getId() == id)
                .findFirst();
    }

    // 합격한 학생만 모아 돌려주는 메서드
    public List<Student> getPassedStudents() {
        return students.stream()
                .filter(s -> s.getPassStatus() == PassStatus.PASSED)
                .toList();
    }

    // 최고 점수 학생을 찾는 메서드
    public Optional<Student> findTopStudent() {
        return this.students.stream()
                .max(Comparator.comparingInt(Student::getScore));
    }

    // 이름에 검색어가 들어간 학생을 찾는 메서드
    public List<Student> searchByName(String keyWord) {
        return this.students.stream()
                .filter(s -> s.getName().contains(keyWord))
                .toList();
    }
}
