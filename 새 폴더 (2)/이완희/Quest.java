// 학생 점수 관리 프로그램
//	- 한 학급의 학생 관리
//		1. 사용자에게 학급의 인원 수를 입력받아 ㅇ
//		2. 각 학생들의 점수도 입력받음 ㅇ
//	- 기능
//		1. 학생 점수 나열 (입력 받은 순) ㅇ
//		3. 학생 점수 수정 (몇 번쨰의 학생인지, 입력 받아 수정) ㅇ
//		4. 총합 / 평균 보기 ㅇ
//		5. 추가 학급 관리 (각 학급의 인원수가 다르다면?) - 입력 : 몇 개의 반
//		6 학생들의 성별 기록 (이름도 기록해야 한다면?) ㅇ
//		* 학급의 인원 수 추가 기능  O
import java.util.Scanner;

public class Quest {
	public static void main(String[] args) {
		
		Administrator admin = new Administrator();

		admin.consol();
	}
}

class Administrator {

	Scanner in = new Scanner(System.in);
	
	ClassRoom[] classRoom;
	Student[] students;
	
	int classNum;
	int[] headCount;
	
	public void consol() {
		
		inputClassInf();
	
		boolean exit = false;
		
		while(!exit) {
			System.out.println("1.학생 점수 나열(입력 받은 순서)    2.학생 점수 수정       3.총합 / 평균 보기");
			System.out.println("0.종료");
			int consolSelect = in.nextInt();
			printLine();
			
			switch(consolSelect) {
			case 0 :
				exit = true;
				break;
			case 1 :
				printClassRoom();
				break;
			case 2 :
				updateStudent();
				break;
			case 3 :
				sumAndAvg();
				break;
			default :
				System.out.println("잘못 입력하셨습니다 다시 입력해 주세요.");
				printLine();
				continue;
			}
		}
	}
	
	public void inputClassInf() {
		
		System.out.print("학급의 수를 입력하시오. : ");
		classNum = in.nextInt();
		headCount = new int[classNum];
		classRoom = new ClassRoom[classNum];
		
		printLine();
		
		for (int i = 0; i < classNum; i++) {
			
			System.out.print("학급의 인원 수를 입력하시오. : ");
			headCount[i] = in.nextInt();
			students = new Student[headCount[i]];
			printLine();
			
			System.out.println((i + 1) + "반");
			System.out.println("-----------");
			
			for(int j = 0; j < headCount[i]; j++) {
				
				Student s = new Student();
				
				System.out.print("학생 이름 : ");
				s.setName(in.next());
				System.out.print("학생 성별 (남, 여) : ");
				s.setSex(in.next());
				System.out.print("학생 점수 : ");
				s.setGrade(in.nextInt());
				
				students[j] = s;
			}
			System.out.println("-----------");
			classRoom[i] = new ClassRoom(students);
		}
		
		printLine();
	}
	
	public void printClassRoom() {
		
		for(int i = 0; i < classNum; i++) {
			System.out.printf("%d반\n", i + 1);
			for (int j = 0; j < headCount[i]; j++) {
				System.out.println((j + 1) + ". " + classRoom[i].students[j].toString());
			}
			printLine();
		}
	}

	public void updateStudent() {
		
		boolean exit = false;
		
		while(!exit) {
			System.out.println("수정할 학생이 속한 반을 입력하시오.");
			int classRoomNum = in.nextInt();
			if(classRoomNum > classNum || classRoomNum < 1) {
				System.out.println("없는 반입니다. 다시 입력하세요.");
				continue;
			}
			
			printLine();
			System.out.println(classRoomNum + "반");
			for (int i = 0; i < classRoom[classRoomNum - 1].students.length; i++) {
				System.out.println((i + 1) + ". " + classRoom[classRoomNum - 1].students[i].toString());
			}
			printLine();
			
			classRoomNum -= 1;
			System.out.println("수정할 학생의 번호를 입력하시오.(학생의 번호는 1.학생 점수 나열(입력 받은 순서)에서 확인 가능)");
			int studentNum = in.nextInt() - 1;
			printLine();
			
			Student s = classRoom[classRoomNum].students[studentNum];
			System.out.printf("이름 : %s\t성별 : %s\t점수 : %d\n", s.getName(), s.getSex(), s.getGrade());
			printLine();		
			
			System.out.println("1.학생 이름 수정\t2.학생 성별 수정\t3.학생 점수 수정");
			int select = in.nextInt();
			printLine();
		
			switch(select) {
			case 1 :
				System.out.print("학생 이름 : ");
				s.setName(in.next());
				break;
			case 2 :
				System.out.print("학생 성별 (남, 여) : ");
				s.setSex(in.next());
				break;
			case 3 :
				System.out.print("학생 점수 : ");
				s.setGrade(in.nextInt());
				break;
			default :
				System.out.println("잘못 입력하셨습니다. 다시 입력해 주십시오");
				continue;
			}
			
			printLine();
		
			while(true) {
				System.out.println("수정을 계속 하시겠습니까?");
				System.out.println("1.Yes\t2.No");
				int continueOrExit = in.nextInt();
				if(continueOrExit == 1) {
					printLine();
					break;
				} else if(continueOrExit == 2){
					printLine();
					exit = true;
					break;
				} else {
					System.out.println("잘못 입력하셨습니다. 다시 입력해 주세요..");
					continue;
				}
			}
		}		
	}
	
	public void sumAndAvg() {
		
		for (int i = 0; i < classNum; i++) {
			
			int sum = 0;
			
			for (int j = 0; j < headCount[i]; j++) {
				
				sum += classRoom[i].students[j].getGrade();
			}
			
			System.out.printf("총합 : %d\n", sum);
			System.out.printf("총합 : %.2f\n", (sum / (double)headCount[i]));
		}
		
		
		printLine();
	}
	
	public void printLine() {
		
		System.out.println("------------------------------------------------------------------------------");
	}
}

class Student {
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

	public String toString() {
		return "이름 : " + name + "    성별 : " + sex + "    점수 : " + grade;
	}
}

class ClassRoom {
	Student[] students;
	
	public ClassRoom(Student... students) {
		this.students = students;
	}
}
