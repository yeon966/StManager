import java.util.Arrays;
import java.util.Scanner;

public class Class {
	Scanner scan = new Scanner(System.in);
	
	private Student[] students;
	
	public Class(int studentsNum) {
		Student[] arr = new Student[studentsNum];
		this.students = arr;
	}
	
	public Class(Student[] students) {
		this.students = students;
	}
	
	public Student[] getStudents() {
		return students;
	}


	public void setStudents(Student[] students) {
		this.students = students;
	}


	


	@Override
	public String toString() {
		return "Class [students=" + Arrays.toString(students) + "]";
	}

	public void setStArr() {
		for (int i = 0; i < students.length; i++) {
			String stName;
			String stGender;
			int score = 0;
			System.out.println((i + 1) + "번 학생 이름을 입력하세요.");
			stName = scan.next();
			System.out.println((i + 1) + "번 학생 성별(남, 여)를 입력하세요.");
			stGender = scan.next();
			if (stGender.equals("남") == false && stGender.equals("여") == false) {
				i--;
				System.out.println("올바른 값을 입력하세요.");
				continue;
			}
			System.out.println((i + 1) + "번 학생 점수를 입력하세요.");
			score = scan.nextInt();
			if (!(score >= 0 && score <= 100)) {
				i--;
				System.out.println("0 ~ 100사이 정수를 입력하세요.");
				continue;
			}
		
			this.students[i] = new Student(stName, stGender, score);
		}
		
	}
	public void showArr() {
		for (int i = 0; i < students.length; i++) {
			System.out.println(students[i]);
		}
	}
	public void modifyScore() {
		System.out.println("점수 수정을 원하는 학생의 번호를 입력해주세요.");
		for (int i = 0; i < students.length; i++) {
			System.out.print((i + 1) + "번 :" + this.students[i].getStName() + " ");
			System.out.print(this.students[i].getStGender() + " ");
			System.out.print(this.students[i].getScore() + " ");
			System.out.println();
		}//학생정보
		int studentNum = scan.nextInt();
		System.out.println("수정하려는 새 점수를 입력하세요.");
		int studentScore = scan.nextInt();
		this.students[studentNum - 1].setScore(studentScore);
		for (int i = 0; i < students.length; i++) {
			System.out.println((i + 1) + "번 :" + this.students[i].getScore());
		}//마지막은 바뀐 점수 보여주려고 했다
	}
	public int sum() {
		int sum = 0;
		for(int i = 0; i < students.length; i++) {
			sum += this.students[i].getScore();
		}
		return sum;
	}
	public double avg() {
		double avg = sum() / students.length;
		return avg;
	}
	public void plusSt() {
		System.out.println("정보를 추가할 학생 수를 입력하세요.");
		int plus = scan.nextInt();
		if (plus > 0) {
			this.students = Arrays.copyOf(students, students.length + plus);
			String stName;
			String stGender;
			int score = 0;
			for (int i = students.length - plus; i < students.length; i++) {
				
				System.out.println((i + 1) + "번 학생 이름을 입력하세요.");
				stName = scan.next();
				System.out.println((i + 1) + "번 학생 성별(남, 여)을 입력하세요.");
				stGender = scan.next();
				if (stGender.equals("남") == false && stGender.equals("여") == false) {
					i--;
					System.out.println("올바른 값을 입력하세요.");
					continue;
				}
				System.out.println((i + 1) + "번 학생 점수를 입력하세요.");
				score = scan.nextInt();
				if (!(score >= 0 && score <= 100)) {
					i--;
					System.out.println("0 ~ 100사이 정수를 입력하세요.");
					continue;
				}
				this.students[i] = new Student(stName, stGender, score);
			}
		} else {
			System.out.println("학생수는 양수만 입력가능합니다.");
		}
	}
}