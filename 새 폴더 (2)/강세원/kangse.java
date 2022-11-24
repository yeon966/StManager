import java.util.Arrays;
import java.util.Scanner;
/*
	학생 점수 관리 프로그램
	- 한 학급의 학생 관리
		1. 사용자에게 여러개 학급의 인원 수를 입력받아 (예.학급:2개  학생:3명)
		2. 각 학생들의 이름과 점수와 성별기록
	- 기능
		1. 학생 목록(이름, 점수, 성별) 나열 (입력 받은 순)
		2. 학생 정보 수정(몇 번째의 학생인지, 입력받아 수정)
		3. 총합 / 평균 보기
		
		관리자 계정 관리 프로그램
		지정된 관리자 계정 5개 존재(아이디, 비밀번호, 개.인.정.보.)
		1.로그인 (로그인되면 환영합니다 잘못되면 ㄲㅈ)
		2.비밀번호 힌트/바꾸기(id를 입력하면 힌트를 줘도댐, 바로 바꾸던기회를 줌)
		
*/

// 박민 : 컴파일 에러가 발생해요~~~.
public class Studentt {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int[] sum = new int[Class]; // << 컴파일 에러가 발생하는 지점
		int[][] array = new int[Class][];
		int student = 0;
		for (int i = 1; i <= Class; i++) {
			System.out.println(i + "반 학생수");
			
		
		
		
		//학급수
		System.out.print("학급 수 :");
		int Class = scan.nextInt();
		
		boolean s = true;
		while (s) {
			System.out.println("학생 목록(이름, 점수, 성별)총합,평균");
			int num = scan.nextInt();
			int totalsum1 = 0;
			int totalsum2 = 0;
			switch (num) {
			case 1:
				String name = null;
				String[] name1 = new String [Class];
					for (int j = 1; j <= Class; j++) {
						System.out.println(j + "이름");
						name = scan.next();
						name1[j - 1] = name;
				}
				break;
			case 2:	
				System.out.println("다른 반 학생수");
				student = scan.nextInt();
				array[i - 1] = new int[student];
				for ( int j = 1; j <= student; j++) {
					System.out.println(i + "반" + j + "번의 점수");
					array[i - 1][j - 1] = scan.nextInt();
					
					sum[i - 1] += array[i - 1][j - 1];
					}
				break;
		
			case 3:
				for (int i = 0; i < Class; i++) {
					totalsum1 += sum[i];
				}
				System.out.println("점수 총합" + totalsum1);
				break;
				
			case 4:
				for (int i = 0; i < Class; i++) {
					totalsum2 += sum[i] / array[i].length;
				}
				System.out.printf("점수 평균" + (totalsum1 + totalsum2 / Class));
				break;
			}
		}
		
		
		
		
		
		
		
	
		
	}
}
