import java.util.Scanner;

// 박민 : 변수 선언 시 소문자 신경 써주세요~

// 학생 점수 관리 프로그램
//	- 여러개 한급의 여러 학생 관리
//		1) 사용자에게 여러개 학급의 인원수를 입력받음 (ex. 학급 2개, 학생 3명)
//		2) 학생들의 이름, 점수, 성병 기록
//
//	- 기능
//		1) 학생 목록(이름, 점수, 성별) 나열 (입력 받은 순)
//		2) 학생 정보 수정(몇 번째의 학생인지, 입력받아 수정)
//		3) 총합 / 평균 보기
	
public class StudentScoreProgram {
	class Student2 {
		String name;
		String sex;
		int grade;
		
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getSex() {
			return sex;
		}
		public void setSex(String sex) {
			this.sex = sex;
		}
		public int getGrade() {
			return grade;
		}
		public void setGrade(int grade) {
			this.grade = grade;
		}
	}

	class StudentBox2 {
		Student[] students;
		
		public StudentBox2(Student... students) {
			this.students = students;
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int Room = 0;  				// 학급 개수
		int Stu = 0;   				// 학생 수
		String Name;    			// 이름 
		int Score;					// 점수
		String Gender;				// 성별

		StudentBox2[] classRoom;
		Student2[] students;
		
		int[][] School = new int[100][100];
		
		
		System.out.print("생성할 학급 개수 입력 : ");
		Room = sc.nextInt();
		for (int i = 0; i < Room; i++) {
			System.out.print("생성할 학생 수 입력 : ");
			Stu = sc.nextInt();
			
			classRoom = new StudentBox2[Stu];
			students = new Student2[Stu];
			System.out.println((i + 1) + "반");
			
			for (int j = 0; j < Stu; j++) {
				Student s = new Student();
				
				
			}
		}
		
		
		
		for (int i = 0; i < Room; i++) {
			for (int j = 0; j < Stu; j++) {
				School[i][j] = sc.nextInt();
			}
		}
		
		for(int i = 0; i < Room; i++) {
			for( int j = 0; j < Stu; j++) {
				System.out.print(School[i][j] + " ");
			}
			System.out.println();
		}
	}
}
