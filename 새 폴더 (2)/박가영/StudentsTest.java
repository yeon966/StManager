import java.util.Arrays;
import java.util.Scanner;

// 박민 : 학생 클래스를 배열로 포함하는 그룹 클래스가 존재하는데, 그룹 배열이 2차원으로 생성되었어요.

class Student {
	private String name;
	private int score;
	private String gender;
	public Student(String name, int score, String gender) {
		this.name = name;
		this.score = score;
		this.gender = gender;
	}
	
	public int getScore() {
		return score;
	}
	public void setScore(int scores) {
		score = scores;
	}
	public String toString() {
		return name + "의 점수는 " + score + ", 성별은 " + gender;
	}
}
class Group {
	Student[] student; 
	
	public Group(Student...student) {
		this.student = student;
	}
	public void setScore(int index, int score) {
		student[index - 1].setScore(score);
	}
	public String toString() {
		return Arrays.toString(student);
	}
	public int sum(int index) {
		int sum = 0;
		for (int i = 0; i < student.length; i++) {
			sum += student[index].getScore();
		}
		return sum;
	}
} 
 
public class StudentsTest {
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in); 
		System.out.print("학급의 수를 입력하세요. : ");
		int classNum = scan.nextInt();
		System.out.print("학급당 학생의 수를 입력하세요. : ");
		int studentNum = scan.nextInt();
		
		Group[][] g = new Group[classNum][studentNum];
		
		for (int i = 0 ; i < classNum; i++) {
			for (int j = 0; j < studentNum; j++) {
				
				System.out.print((i + 1) + "반의 " + (j + 1) + "번째 학생의 이름을 입력하세요 : ");
				String name = scan.next();
				System.out.print((i + 1) + "반의 " + (j + 1) + "번째 학생의 점수를 입력하세요 : ");
				int score = scan.nextInt();
				System.out.print((i + 1) + "반의 " + (j + 1) + "번째 학생의 성별를 입력하세요(여,남 중 선택) : ");
				String gender = scan.next();
				
				g[i][j] = new Group(new Student(name, score, gender));
			}
		}
		
		for (int i = 0 ; i < classNum; i++) {
			for (int j = 0; j < studentNum; j++) {
				System.out.println((i + 1) + "반의 " + g[i][j] + " ");
			}
		} System.out.println();
		
		System.out.println("학생의 점수가 바뀌었나요 ? ");
		System.out.print("바뀌었다면 1번을 누르세요. 다른 번호를 누르면 합과 평균을 보여드립니다. : ");
		int user = scan.nextInt();
		if (user == 1) {
			System.out.print("바뀐 학생의  반 입력하세요 : ");
			int whoClass = scan.nextInt();
			System.out.print("바뀐 학생의  입력순서를 입력하세요 : ");
			int who = scan.nextInt();
			System.out.print("바뀐 점수를 입력하세요 : ");
			int whoScore = scan.nextInt();
			g[whoClass - 1][who-1].setScore(who-1, whoScore);
		}
		for (int i = 0 ; i < classNum; i++) {
			for (int j = 0; j < studentNum; j++) {
				System.out.println((i + 1) + "반의 " + g[i][j] + " ");
			}
		} System.out.println();	
		
		for (int i = 0 ; i < classNum; i++) {
			for (int j = 0; j < studentNum; j++) {
				System.out.println((i + 1) + "반의  합은" + g[classNum][studentNum].sum(j) + " ");
			}
		} System.out.println();
		
	}
}
