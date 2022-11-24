/*
 *  학생 점수 관리 프로그램
 *  - 한 학급의 학생 관리
 *  	1. 사용자에게 학급의 인원 수를 입력받아
 *  	2. 학생들의 이름과 점수와 성별 기록
 *  
 *  - 기능
 *  	1. 학생 목록(이름, 점수, 성별) 나열 (입력 받은 순)
 *  	2. 학생 정보 수정 (몇 반 몇 번째의 학생인지, 새점수는 몇인지 입력받아 수정)
 *  	3. 총합 / 평균보기 (전체 , 반별)
 *  
 *  	관리자 계정 관리 프로그램
 *  	지정된 관리자 계정(아이디, 비밀번호, 개인정보) 5개 존재
 *  	1. 로그인
 *  	2. 비밀번호 바꾸기
 *  
 */
import java.util.Arrays;
import java.util.Scanner;

public class ScoreManager {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		System.out.print("학급 : ");
		int num = scan.nextInt();
		System.out.print("학생 : ");
		int studNum = scan.nextInt();
		
		Student[][] students = new Student[num][studNum];
		
		for (int i = 0; i < students.length; i++) {
			for (int j = 0; j < students[i].length; j++) {
				System.out.print("이름 : ");
				String name = scan.next();
				System.out.print("성별 : ");
				String gender = scan.next();
				System.out.print("점수 : ");
				int score = scan.nextInt();
				
				students[i][j] = new Student(name,score,gender);			
			}
		}

		boolean onOff = true;
		while(onOff) {
			System.out.println("\n-기능\n"
					+ "1. 학생 점수 나열(입력 받은 순)\n"
					+ "2. 학생 정보 수정\n"
					+ "3. 총합 /평균보기\n"
					);
			
			int select = scan.nextInt();
			
			
			switch(select) {
				case 1 : 
					list(students);
					break;
				case 2:
					change(students);
					break;
				case 3:
					sumAvg(students);
					break;
				default:
					System.out.println("프로그램이 종료됩니다.");
					onOff = false;
			}
		}
	}
	
	public static void list(Student[][] s) {
		for (int i = 0; i < s.length; i++) {
			System.out.println((i + 1) + "반");
			for (int j = 0; j < s.length; j++) {
				System.out.println(s[i][j]);
			}
		}
	}
	
	public static void change(Student[][] s) {
		Scanner scan = new Scanner(System.in);
		
		System.out.print("몇반 학생? : ");
		int c = scan.nextInt() - 1;
		System.out.print("몇번 학생? : ");
		int n = scan.nextInt() - 1;
			
		System.out.println("\n수정할 정보\n"
				+ "1. 이름\n"
				+ "2. 점수\n"
				+ "3. 성별\n"
				);
					
		int select = scan.nextInt();
		switch(select) {
			case 1 : 
				System.out.print("이름? : ");
				String name = scan.next();
				s[c][n].setName(name);
				break;
			case 2:
				System.out.print("점수? : ");
				int score = scan.nextInt();
				s[c][n].setScore(score);
				break;
			case 3:
				System.out.print("성별? : ");
				String gender = scan.next();
				s[c][n].setGender(gender);
				break;
			default:
				System.out.println("잘못입력하셨습니다.");
				break;
		}
		
	}
	
	public static void sumAvg(Student[][] s) {
		int sum = 0, count = 0;
		int sumN = 0, countN = 0;
		
		for (int i = 0; i < s.length; i++) {
			for (int j = 0; j < s[i].length; j++) {
				sum += s[i][j].getScore();
				count++;
			}
		}
		
		System.out.println("<전체 총합 , 평균>");
		System.out.printf("총합 : %d, 평균 : %d\n\n", sum, sum / count);
		System.out.println("<반별 총합 , 평균>");
		
		for (int i = 0; i < s.length; i++) {
			for (int j = 0; j < s[i].length; j++) {
				sumN += s[i][j].getScore();
				countN++;
			}
			System.out.printf("%d반 총합 : %d, 평균 : %d\n", (i+1) , sumN, (sumN/countN));
			sumN = 0;
			countN = 0;
		}
	}
	
	}
	

