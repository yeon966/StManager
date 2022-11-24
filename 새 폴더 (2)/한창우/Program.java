import java.util.Arrays;
import java.util.Scanner;

/*
 	학생 점수 관리 프로그램
 	- 한 학급의 학생 관리
 		1. 사용자에게 여러개 학급의 인원 수를 입력받아 ( ex) 학급 : 2개 학생 : 3명)
 		2. 각 학생들의 점수도 입력받음
 	- 기능
 		1. 학생 목록(이름, 점수, 성별) 나열 (입력 받은 순)
 		2. 학생 정보 수정(몇 번째의 학생인지, 입력받아 수정)
 		3. 총합 / 평균 보기 (반별, 전체)
 		4. 추가 학급 관리 (각 학급의 인원수가 다르다면?) - 입력 : 몇 개의 반
 		5. 학생들의 (이름과 점수와 성별) 기록 - 입력 / 출력 도 달라져야된다 (수정하기)
 		
 	관리자 계정 관리 프로그램
 	지정된 관리자(아이디, 비밀번호, 정보) 계정 5개 존재
	 	1. 로그인
	 	2. 비밀번호 바꾸기 (힌트 / 바로 바꿀 기회)	
 */

public class Program {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
//		1. 사용자에게 여러개 학급의 인원 수를 입력받아 ( ex) 학급 : 2개 학생 : 3명)
		System.out.print("학급수를 입력해주세요");
		int Class = scan.nextInt();
		int[] sum = new int[Class];
		int person = 0;
		int [] person1 = new int[Class];
		String name = null;
		String[] name1 = new String[Class];
		//2. 학생 수 학생이름입력 입력받음
		for (int i = 1; i <= Class; i++) {
			System.out.println(i + "반 학생수");
			person = scan.nextInt();
			person1[i - 1] = person;
			for (int j = 1; j <= person; j++) {
				System.out.println(j + "학생 이름");
				name = scan.next();
				name1[i - 1] = name;
				
				System.out.println(i + "반" + j + "번" + "점수 :");
				int scores = scan.nextInt();
				sum[i - 1] += scores;
			}
			System.out.println();
		}
		
//		1. 학생 목록(이름, 점수, 성별) 나열 (입력 받은 순)
		boolean stop = true;
		while(stop) {
			System.out.println("1.학생 목록 2.총합/평균 3.학생정보 수정");
			int num = scan.nextInt();
			switch(num) {
			case 1:
				System.out.println(Arrays.toString(name1));
				System.out.println(Arrays.toString(sum));
				break;
			case 2:
				int totalsum = 0;
				int totalavg = 0;
				for (int i = 0; i < Class; i++) {
					totalsum += sum[i];
					totalavg += sum[i] / person1[i];
				}
				for (int i = 0; i < Class; i++) {
					System.out.println((i + 1) + "총합 : " + totalsum + "평균 : " + totalavg);
				}
				break;
			case 3:
				
				
			}
		}
//		2. 학생 정보 수정(몇 번째의 학생인지, 입력받아 수정)
		
	}
}
