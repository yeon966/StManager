/*
 	학생 점수 관리 프로그램
 	- 여러개 학급의 여러 학생 관리
 		1. 사용자에게 여러개 학급의 인원 수를 입력받아 (예. 학급 : 2개, 학생 : 3명)
 		2. 각 학생들의 이름과 점수와 성별 기록
 	- 기능
 		1. 학생 목록 (이름, 점수, 성별) 나열 (입력 받은 순)
 		2. 학생 정보 수정(몇 번째의 학생인지, 입력받아 수정)
 		3. 총합 / 평균 보기(전체, 반 별)
		

 */
import java.util.Scanner;

public class Prac {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
	
		int numOfClasses;
		boolean onOff = true;
		
		System.out.println("<학생 점수 관리 프로그램>");
		System.out.print("관리할 학급의 수: ");
		numOfClasses = scan.nextInt();
		
		Student[][] students = new Student[numOfClasses][];
		
		for (int i = 0; i < numOfClasses; i++) {
			System.out.print((i+1) + "번째 학급의 학생수: ");
			students[i] = new Student[scan.nextInt()];
		}
		
		for (int i = 0; i < numOfClasses; i++) {
			System.out.printf("(%d번째 학급의 학생 정보입력 시작(총 %d명))\n", i + 1, students[i].length);
			for (int j = 0; j < students[i].length; j++) {
				String name;
				char gender;
				int score;
				scan.nextLine();
				System.out.printf("(%d번째 학생)\n", j + 1);
				System.out.print("이름: ");
				name = scan.nextLine();
				System.out.print("성별: ");
				gender = scan.next().charAt(0);
				System.out.print("점수: ");
				score = scan.nextInt();
				students[i][j] = new Student(name, gender, score);
			}
		}
		

		
		while (onOff) {
			System.out.println("<지원하는 기능>");
			System.out.println("======================");
			System.out.println("1. 학생 목록");
			System.out.println("2. 학생 점수 수정");
			System.out.println("3. 총합 & 평균");
			System.out.println("0. 프로그램 종료");
			System.out.println("======================");
			System.out.print("선택할 기능 : ");
			
			switch (scan.nextInt()) {
			case 1:
				for (int i = 0; i < numOfClasses; i++) {
					System.out.printf("-----<%d반>-----\n", i+1);
					for (int j = 0; j < students[i].length; j++) {
						System.out.println(students[i][j].toString());
					}
				}
				break;
			case 2:
				System.out.println("수정할 학생 검색 방법");
				System.out.println("1) 반과 번호");
				System.out.println("2) 이름");
				System.out.print("선택: ");
				switch (scan.nextInt()) {
				case 1:
					int classRoom;
					int number;
					System.out.print("몇 반 인가요?: ");
					classRoom = scan.nextInt() - 1;
					if (classRoom > students.length - 1) {
						System.out.println("존재하지 않는 반 입니다.");
						break;
					}
					System.out.print("몇 번 인가요?: ");				
					number = scan.nextInt() - 1;
					if (number > students[classRoom].length - 1) {
						System.out.println("존재하지 않는 번호 입니다.");
						break;
					}						
					System.out.print("현재 점수: " + students[classRoom][number].getScore());
					System.out.print("수정할 점수: ");
					students[classRoom][number].setScore(scan.nextInt());
					break;
				case 2:
					boolean existence = false;
					String name;
					System.out.print("검색할 이름: ");
					scan.nextLine();
					name = scan.nextLine();
					for (int i = 0; i < numOfClasses; i++) {
						for (int j = 0; j < students[i].length; j++) {
							if (students[i][j].getName().equals(name)) {
								System.out.println("현재 점수: " + students[i][j].getScore());
								System.out.print("수정할 점수: ");
								students[i][j].setScore(scan.nextInt());
								existence = true;
								System.out.println("수정 완료!!");
								break;
							}
						}
					}
					if (!existence) {
						System.out.println("존재하지 않는 이름입니다.");
					}
				}
				break;
			case 3:
				int[] sum = new int[numOfClasses];
				for (int i = 0; i < numOfClasses; i++) {
					sum[i] = 0;
					for (int j = 0; j < students[i].length; j++) {
						sum[i] += students[i][j].getScore();
					}
					System.out.printf("(%d반) 총합: %d || 평균: %d\n", i + 1, sum[i], sum[i] / students[i].length);
				}
				int totalSum = 0;
				int totalNum = 0;
				for (int i = 0; i < numOfClasses; i++) {
					totalSum += sum[i];
					totalNum += students[i].length;
				}
				System.out.printf("(종합) 총합: %d || 평균: %d\n", totalSum, totalSum / totalNum);
				break;
			case 0:
				onOff = false;
				System.out.println("프로그램 종료");
				break;
			default:
				System.out.println("잘못된 입력입니다!");
				break;
			}
		}
		
		
	}
}