import java.util.List;
import java.util.Optional;
import java.util.Scanner;

/**
 * `Main`의 기본 구조입니다.
 *
 * - `Scanner` 필드를 가진다.
 * - 생성자에서 `Scanner` 객체를 만든다.
 * - `main`에서는 `Main` 객체를 만든 뒤 `run()`을 호출한다.
 * - `run()`에서 실습 흐름을 실행한다.
 * - 여러 학생 출력은 별도 메서드로 분리한다.
 * - 최고 점수 학생 출력도 별도 메서드로 분리한다.
 * - 숫자 입력은 별도 메서드에서 처리한다.
 */
public class Main {

    public static void main(String[] args) {
        Main main = new Main();
        main.run();
    }

    Scanner sc;
    Classroom classroom = new Classroom();

    public Main() {
        this.sc = new Scanner(System.in);
        classroom.addStudent(new Student(1, "김하나", 87));
        classroom.addStudent(new Student(2, "이도윤", 92));
        classroom.addStudent(new Student(3, "박서준", 58));
        classroom.addStudent(new Student(4, "정다은", 75));
    }

    // 실습 흐름 메서드
    private void run() {
        // 전체 학생을 출력한다.
        printStudents(classroom.getStudents());

        // 수정할 학생 id를 입력받는다
        System.out.print("수정할 학생 id 입력: ");
        int targetId = inputNumber();

        // 새 점수를 입력받는다.
        System.out.print("새 점수를 입력: ");
        int newScore = inputNumber();

        // id로 학생을 찾는다
        Optional<Student> findStudent = classroom.findById(targetId);
        if(findStudent.isEmpty()) {
            System.out.println("해당 id를 가진 학생은 없습니다.");
            return;
        }

        // 학생이 있으면 점수를 수정한다.
        // 점수가 잘못되면 예외 메시지를 보여주고 종료한다.
        Student student = findStudent.get();
        try {
            student.updateScore(newScore);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return;
        }

        // 합격자 목록을 출력한다.
        System.out.println("===== 합격자 목록 =====");
        List<Student> list = classroom.getPassedStudents();
        printStudents(list);

        // 최고 점수 학생을 출력한다.
        System.out.println("===== 최고 점수 학생 =====");
        Optional<Student> topStudent = classroom.findTopStudent();
        if(topStudent.isPresent()) {
            printTopStudent(topStudent.get());
        }

        System.out.println("===== 해당 검색어가 포함된 이름 출력 =====");
        System.out.print("검색어를 입력하세요: ");
        String keyWord = sc.nextLine();
        printStudents(classroom.searchByName(keyWord));
    }

    // 여러 학생 출력하는 메서드
    private void printStudents(List<Student> list) {
        StringBuilder sb = new StringBuilder();
        for (Student student : list) {
            sb.append(student).append("\n");
        }
        System.out.println(sb);
    }

    // 최고 점수 학생 출력하는 메서드
    private void printTopStudent(Student topStudent) {
        System.out.println(topStudent);
    }

    // 숫자 입력하는 메서드
    private int inputNumber() {
        try {
            int num = this.sc.nextInt();
            this.sc.nextLine();
            return num;
        } catch (Exception e) {
            // 실패한 경우
            this.sc.nextLine();
            return -1;
        }
    }
}
