import java.util.Arrays;
import java.util.Scanner;

public class StudentManager {
	static StudentClass[] studentClass;
	
	// 학급 추가하기
	public static StudentClass[] plusClass(StudentClass[] origin, StudentClass newClass) {
		studentClass = Arrays.copyOf(origin, origin.length + 1);
		studentClass[origin.length] = newClass;
		return studentClass;
	}

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		System.out.print("학급 수 입력: ");
		int classNum = scan.nextInt(); // studentClass.length 값과 같음
		studentClass = new StudentClass[classNum]; // studentClass 배열 만들기
		System.out.println();
		
		// 학급별로 학생 정보 입력받기
		for (int j = 0; j < classNum; j++) {
			System.out.println("[class" + (j + 1) + "]");
			System.out.print("학생 수 입력: ");
			int num = scan.nextInt();
			studentClass[j] = new StudentClass(num); // studentClass 만들기
			
			for (int i = 0; i < num; i++) {
				System.out.println((i + 1) + "번 학생");
				System.out.print("-이름: ");
				String name = scan.next();
				System.out.print("-점수: ");
				int score = scan.nextInt();
				System.out.print("-성별(남/여): ");
				String gender = scan.next();
				// 입력받은 값으로 학생 만들기
				studentClass[j].students[i] = new Student((j + 1), name, score, gender); 
			}
			System.out.println();
		}
		
		boolean go = true;
		while(go) {
			System.out.println("-------------------------------------------------------------------------------------");
			System.out.println("1.학생정보 보기(전체) 2.학생정보 보기(개별) 3.점수 변경  4.학생정보 수정  5.총합/평균보기  6.학생추가  7.학급추가  0.종료");
			int input = scan.nextInt();
			
			int classIndex = 0; // classNum(클래스 수)가  2개이상일 경우는 학급선택받고 아닌경우는 클래스인덱스가 0인 클래스로 기능 수행하기
				if (input != 0 && input != 7 && classNum > 1) {
				System.out.print("학급선택: ");
				classIndex = scan.nextInt() - 1;
			}
				
			switch(input) {
			case 1:
				studentClass[classIndex].getInformation();
				break;
			case 2:
				System.out.print("학생 번호 입력: ");
				studentClass[classIndex].getInformationByIndex(scan.nextInt());
				break;
			case 3:
				System.out.print("변경할 학생 번호: ");
				int changeNum1 = scan.nextInt();
				System.out.print("변경할 점수: ");
				int newScore = scan.nextInt();
				studentClass[classIndex].changeScore(changeNum1, newScore);
				break;
			case 4:
				System.out.print("변경할 학생 번호:");
				int changeNum2 = scan.nextInt();
				System.out.print("변경할 이름 입력: ");
				String changeName = scan.next();
				System.out.print("성별(남/여): ");
				String changeGender = scan.next();
				studentClass[classIndex].resetInformation(changeNum2, changeName, changeGender);
				break;
			case 5:
				System.out.println("총합: " + studentClass[classIndex].getSum());
				System.out.println("평균: " + studentClass[classIndex].getAvg());
				break;
			case 6:
				int studentNo = studentClass[classIndex].students.length + 1; // 학생번호
				System.out.println("class" + (classIndex + 1) + " " + studentNo + "번 학생");
				System.out.print("-이름: ");
				String plusName = scan.next();
				System.out.print("-점수: ");
				int plusScore = scan.nextInt();
				System.out.print("-성별(남/여): ");
				String plusGender = scan.next();
				Student newStu = new Student((classIndex + 1), plusName, plusScore, plusGender);
				studentClass[classIndex].plusStudent(studentClass[classIndex].students, newStu);
				break;
			case 7:
				classNum++; // 기존의 학급 수 추가하기(학급 번호가됨)
				System.out.println("class" + classNum + " 학급이 추가됩니다.");
				System.out.println("[class" + classNum + "]");
				System.out.print("학생 수 입력: ");
				int newClassStudent = scan.nextInt();
	
				StudentClass sc = new StudentClass(newClassStudent);
				plusClass(studentClass, sc); // 학생 수를 입력받아 StudentClass 만들기
			
				for (int i = 0; i < newClassStudent; i++) {
					System.out.println((i + 1) + "번 학생");
					System.out.print("-이름: ");
					String name = scan.next();
					System.out.print("-점수: ");
					int score = scan.nextInt();
					System.out.print("-성별(남/여): ");
					String gender = scan.next();
					// 입력받은 학생 정보로 학생 생성 후 studentClass배열에 값을 저장하기 
					studentClass[studentClass.length - 1].students[i] = new Student(classNum, name, score, gender);
				}
				break;
			case 0:
				System.out.println("프로그램 종료");
				go = false;
			}
		}
	}
}