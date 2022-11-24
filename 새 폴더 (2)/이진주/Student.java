
import java.util.Scanner;

// 박민 : 문자열 값 동등 비교시 == 관계연산자 사용 주의

// 학생관리 프로그램
// - 한학급의 학생 관리
// 1. 사용자에게 학급의 인원수를 입력받아
// 2. 각 학생들의 이름,점수,성별 입력받음
// - 기능 
// 1. 학생 목록(이름, 점수, 성별) 나열
// 3. 학생 점수 수정 (몇 번째의 학생인지, 새 점수는 몇인지 입력받아 수정)
// 4. 총합 / 평균 보기
// 5. 추가 학급 관리 (각 학급의 인원수가 다르다면?) -  입력 : 몇개의 반
// 6. 학생들의 이름과 점수와 성별 기록 - 입력 / 출력 수정

public class Student {
	private String name;
	private int score;
	private String gender;
	
	public Student(String name, int score, String gender) {
		this.name = name;
		this.score = score;
		this.gender = gender;
	}
	
	public Student() {
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}
	

	public String toString() {
		return "Student [name=" + name + ", score=" + score + ", gender=" + gender + "]";
	}

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.print("학생의 인원수를 입력하세요 : ");
		int person = scan.nextInt();
		Student[] student = new Student[person];
		for(int i = 0; i < student.length; i++) {
			student[i] = new Student();
		}
		
		for (int i = 0; i < person; i++) {
			Student st = student[i];
			System.out.print("학생의 이름은 무엇입니까? : ");
			String name = scan.next();
			st.setName(name);
		}
	
		for (int i = 0; i < person; i++) {
			Student st = student[i];
			System.out.print(st.getName() + "학생의 점수는 몇 점입니까? : ");
			int score = scan.nextInt();
			if (score <= 100 && score >= 0) {
				st.setScore(score);
				} else {
					System.out.println("올바른 점수를 입력하세요 ");
					i--;
				}
			}
		
		for (int i = 0; i < person; i++) {
			Student st = student[i];
			System.out.print(st.getName() + "학생의 성별은 무엇입니까? (남/여 중에 선택) : ");
			String gender = scan.next();
			if (gender == "남" && gender == "여") {
				st.setGender(gender);
				} else {
					System.out.println("올바른 성별을 입력하세요 (남/여 중에 선택)");
					i--;
				}
			}
		
		boolean stop = true;
		while (stop) {
			System.out.print("1.총합 2.평균 3.변경 4.학생정보확인 5.종료 : ");
			int input = scan.nextInt();
			switch (input) {
			case 1 :
					int sum = 0;
					for (int i = 0; i < person; i++) {
						Student st = student[i];
						sum += st.getScore();
					}
					System.out.println("학생들의 총 점수는 : " + sum);
					break;
			
			case 2 :
					int sum2 = 0;
					for (int i = 0; i < person; i++) {
						Student st = student[i];
						sum2 += st.getScore();						
					}
					System.out.println("학생들의 평균 점수는 : " + sum2 / person);
					break;
					
			case 3 :
					System.out.println("변경 할 메뉴를 선택해주세요");
					System.out.print("1.학생이름 2.점수 3.성별 4.종료 : ");
					int input2 = scan.nextInt();
					for (int i = 0; i < person; i++) {
						if (input2 == 1) {
							System.out.print("몇번째의 학생을 변경하시겠습니까? : ");
							int inputSt = scan.nextInt();
							Student st = student[inputSt - 1];
							System.out.print("변경 할 학생의 이름을 입력해주세요 : ");
							String inputName = scan.next();
							st.setName(inputName);
							break;
						} if (input2 == 2) {
							System.out.print("몇번째의 학생을 변경하시겠습니까? : ");
							int inputSt = scan.nextInt();
							Student st = student[inputSt - 1];
							System.out.print("변경 할 학생의 점수를 입력해주세요 : ");
							int inputScore = scan.nextInt();
							st.setScore(inputScore);
							break;
						} if (input2 == 3) {
							System.out.print("몇번째의 학생을 변경하시겠습니까? : ");
							int inputSt = scan.nextInt();
							Student st = student[inputSt - 1];
							System.out.print("변경 할 학생의 성별을 입력해주세요 : ");
							String inputGender = scan.next();
							st.setGender(inputGender);
							break;
						} if (input2 == 4) {
							break;
						}
					}
					break;
					
			case 4 :
					for (Student st : student) {
						System.out.println("학생들의 점수" + st.toString());
					}
					break;
					
			case 5 : 
					stop = false;
			}
		}
	}		
}
