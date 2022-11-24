/*
 	학생 점수 관리 프로그램
 	- 여러개 학급의 여러 학생 관리
 		1. 사용자에게 여러개 학급의 인원 수를 입력받아 (예.학급:2개, 학생:3명)
 		2. 학생들의 이름과 점수와 성별 기록
 	- 기능
 		1. 학생 목록(이름, 점수, 성별) 나열 (입력 받은 순)
 		2. 학생 정보 수정(몇 번째의 학생인지, 입력받아 수정)
 		3. 총합 / 평균 보기
 	
 	관리자 계정 관리 프로그램
 	지정된 관리자(아이디, 비밀번호, 기타정보) 계정 5개 존재
	 	1. 로그인
	 	2. 비밀번호 바꾸기
 */


import java.util.Scanner;
	
class Student{
	private String name;
	private int student, score;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getStudent() {
		return student;
	}
	public void setStudent(int student) {
		this.student = student;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	public Student(String name, int student, int score) {
		super();
		this.name = name;
		this.student = student;
		this.score = score;
	}
	private String studentString(int student) {
		if (student == 1) {
			return "남";
		} else if (student == 2) {
			return "여";
		} else {
			return null;
		}
	}
	public String toString() {
		return "[이름=" + name + ", 성별="
					+ studentString(student)
					+ ", 점수=" + score + "]";
	}
}

class Class{
	private Student[] st;
	private String className;
	Scanner scan = new Scanner(System.in);
	
	Class(String className){
		this.className = className;
		System.out.println(className + "의 학생 수: ");
		int input = scan.nextInt();
		st = new Student[input];
		for (int i = 0; i < input; i++) {
			System.out.println((i + 1) + "번째 학생의 이름은?");
			String input2 = scan.next();
			String name = input2;
			
			System.out.println(name + "의 성별은?\n('남' 또는 '여'로 입력)");
			input2 = scan.next();
			int student = 0;
			if (input2.equals("남")) {
				student = 1;
			} else if (input2.equals("여")) {
				student = 2;
			} else {
				System.out.println("잘못 입력하였습니다. ");
				i--; // 잘못된 입력 반복 포함x
				continue;
			}
			
			System.out.println(name + "의 점수는?");
			int input3 = scan.nextInt();
			if (0 <= input  && input <= 100) {
				st[i] = new Student(name, student, input3);
			} else {
				System.out.println("잘못 입력하였습니다. ");
				i--; // 잘못된 입력 반복 포함x
			} 
			
		}
	}

	public Student[] getSt() {
		return st;
	}

	public void setSt(Student[] st) {
		this.st = st;
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}
	
}

class Program{
	private Class[] cl;
	Scanner scan = new Scanner(System.in);
	
	public Program() {
		System.out.println("학급의 수는?");
		int input = scan.nextInt();
		cl = new Class[input];
		for (int i = 0; i < input; i++) {
			cl[i] = new Class((i + 1) + "반");
		}
		
		boolean sw = true;
		while (sw) {
			System.out.println("사용할 기능을 입력해주세요. \n1. 학생 현황 2. 학생 정보 수정 3. 총합 및 평균 보기 4. 프로그램 종료");
			input = scan.nextInt();
			switch (input) {
			case 1:
				studentList();
				break;
			case 2:
				System.out.println("어떤 정보를 수정하시겠습니까? \n1. 학생 이름 수정 2. 학생 점수 수정");
				input = scan.nextInt();
				switch (input) {
				case 1:
					nameChange();
					break;
				case 2:
					scoreChange();
					break;
				default:
					System.out.println("잘못 입력되었습니다. ");
					break;
				}
				break;
			case 3:
				scoreSum();
				break;
			case 4:
				System.out.println("프로그램을 종료하였습니다. ");
				sw = false;
				break;
			default:
				System.out.println("잘못 입력하였습니다. ");
				break;
			}
		}
	}
	
	//1. 학생 목록(이름, 점수, 성별) 나열 (입력 받은 순)
	public void studentList() {
		System.out.println("학급 수: " + cl.length);
		for (int i = 0; i < cl.length; i++) {
			System.out.print(cl[i].getClassName() + "의 학생 현황: ");
			System.out.println("학생 수 " + cl[i].getSt().length);
			for (int j = 0; j < cl[i].getSt().length; j++) {
				System.out.println(cl[i].getSt()[j].toString());
			}
		}
	}
	
	//2. 학생 정보 수정(몇 번째의 학생인지, 입력받아 수정)
	public void nameChange() {
		System.out.println("이름을 수정할 학생이 있는 학급을 입력해주세요. ");
		if (cl.length == 1) {
			System.out.println("목록: 1");
		} else {
			System.out.println("목록: 1 ~ " + cl.length);
		}
		
		int input = scan.nextInt();
		if (1 > input || cl.length < input) {
			System.out.println("잘못 입력하였습니다. ");
		} else {
			if (cl[input - 1].getSt().length == 1) {
				System.out.println(cl[input - 1].getSt()[0].getName() + "의 변경할 이름을 입력해주세요. ");
				String name = scan.next();
				cl[input - 1].getSt()[0].setName(name);
				System.out.println("변경 완료");
			} else {
				System.out.println("이름을 수정할 학생의 번호를 입력해주세요. ");
				System.out.println("1 ~ " + cl[input - 1].getSt().length + " 중에 선택");
				int input2 = scan.nextInt();
				
				if (1 > input2 || cl[input - 1].getSt().length < input2) {
					System.out.println("잘못 입력하였습니다. ");
				} else {
					System.out.println(cl[input - 1].getSt()[input2 - 1].getName() + "의 변경할 이름을 입력해주세요. ");
					String name = scan.next();
					cl[input - 1].getSt()[input2 - 1].setName(name);
					System.out.println("변경 완료");
				}
			}
		}
	}
	
	public void scoreChange() {
		System.out.println("점수를 수정할 학생이 있는 학급을 입력해주세요. ");
		if (cl.length == 1) {
			System.out.println("목록: 1");
		} else {
			System.out.println("목록: 1 ~ " + cl.length);
		}
		
		int input = scan.nextInt();
		if (1 > input || cl.length < input) {
			System.out.println("잘못 입력하였습니다. ");
		} else {
			if (cl[input - 1].getSt().length == 1) {
				System.out.println(cl[input - 1].getSt()[0].getName() + "의 변경할 점수를 입력해주세요. ");
				int score = scan.nextInt();
				if (0 <= score && score <= 100) {
					cl[input - 1].getSt()[0].setScore(score);
					System.out.println("변경 완료");
				} else {
					System.out.println("잘못 입력하였습니다. ");
				}
			} else {
				System.out.println("점수를 수정할 학생의 번호를 입력해주세요. ");
				System.out.println("1 ~ " + cl[input - 1].getSt().length + " 중에 선택");
				int input2 = scan.nextInt();
				
				if (1 > input2 || cl[input - 1].getSt().length < input2) {
					System.out.println("잘못 입력하였습니다. ");
				} else {
					System.out.println(cl[input - 1].getSt()[input2 - 1].getName() + "의 변경할 점수를 입력해주세요. ");
					int score = scan.nextInt();
					if (0 <= score && score <= 100) {
						cl[input - 1].getSt()[input2 - 1].setScore(score);
						System.out.println("변경 완료");
					} else {
						System.out.println("잘못 입력하였습니다. ");
					}
				}
			}
		}
	}
	
	
	//3. 총합 / 평균 보기
	public void scoreSum() {
		int sum;
		for (int i = 0; i < cl.length; i++) {
			sum = 0;
			for (int j = 0; j < cl[i].getSt().length; j++) {
				sum += cl[i].getSt()[j].getScore();
			}
			System.out.println((i + 1) + "반의 총점: " + sum + "\n" + (i + 1) + "반의 평균: " + ((double)sum / cl[i].getSt().length));
		}
	}
	
}

public class Prac2 {
	public static void main(String[] args) {
		Program p = new Program();
	}
}