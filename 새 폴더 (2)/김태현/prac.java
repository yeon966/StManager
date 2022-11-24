package pracice;

import java.util.Arrays;
import java.util.Scanner;

// 박민 : 들여쓰기, 중괄호, 각 연산자 띄어쓰기 신경 써주세요~

/*
 * 학생점수관리 프로그램
 * 한학급관리
 * 1.사용자에게 학급인원수를 입력받아 
 * 2.각학생을 점수도 입력받음
 * 
 * -기능 
 * 1.학생점수 나열(입력받은순)
 * 2.점수나열 오름차순
 * 3.점수수정 (몇번째 학생인지, 새점수는 몇인지 입력받아 수정)
 * 4.총합 평균
 * 
 * 인원수 추가 기능
 * 추가 학급  관리
 * 학급 성별, 이름
 */
public class prac {
	public static void main(String[] args) {
		System.out.println("학급의 인원은 몇명인가요.");
		Scanner scan = new Scanner(System.in);
		int stu = scan.nextInt();
		int[]people = new int [stu];
		String []name = new String[stu];
		String []sex = new String[stu];
		
		
		for (int i = 0; i < people.length; i++) {
			System.out.println(i+1 +  "번째 학생의 이름과 성별, 점수를 입력해주세요");
			Scanner sc = new Scanner(System.in);
			name[i] = sc.next();
			Scanner sc2 = new Scanner(System.in);
			sex[i] = sc2.next();
			Scanner scan2 = new Scanner(System.in);
			int score = scan2.nextInt();
			people[i]=score;
		}
		System.out.print("입력순 : ");
			for (int i = 0; i < name.length; i++) {
				System.out.print(name[i]+"("+sex[i]+")" + " : "+ people[i]+" \n" );
			}
	
		while(true) {
		System.out.println("수정사항이 있다면 1번을 눌러 주세요");
			
		Scanner scan3 = new Scanner(System.in);
		int input = scan3.nextInt();
			if(input==1) {
				System.out.println("몇번째 학생을 바꾸나요?");
				Scanner scan4 = new Scanner(System.in);
				int fix = scan4.nextInt();
				 if(fix<=stu) {
					 
				 }else{
					 System.out.println("잘못된 입력입니다. 다음단계로 넘어갑니다." );
					 break;
				 }
				System.out.println("몇점으로 바꾸나요?");
				Scanner scan5 = new Scanner(System.in);
				int fixScore = scan5.nextInt();
				
				people[fix-1] = fixScore;
				
				System.out.print("입력순 : ");
					for (int i = 0; i < name.length; i++) {
						System.out.print(name[i]+ "("+sex[i]+")" + " : "+ people[i]+" \n" );
					}
			}else {
				break;
			}
		}
			
		
		Arrays.sort(people);
		System.out.println("오름차순 : "+ Arrays.toString(people) );
		
		int sum = 0;
		for (int i = 0; i < people.length; i++) {
			sum = sum + people[i];
		}
		int ave = sum/stu;
		System.out.println("총합 : " +sum);
		System.out.println("평균 : " +ave);
	}
}
