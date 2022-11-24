
import java.util.Arrays;
import java.util.Scanner;

// 박민 : 컴파일 에러가 발생해요. 중괄호가 빠졌네요.

public class ManagerTest {

	public static void main(String[] args) {

		boolean run = true;

		int scores = 0;
		int scoreArr[] = new int[scores];
		
		
		int studentNo = 0;
		int studentArr[] = new int[studentNo];
		
		int classNo = 0;
		int classArr[] = new int[classNo];
		
		Scanner scanner = new Scanner(System.in);

			while (run == true) {
				
				System.out.println("1. 학급 입력"
						+ " | 2. 점수 입력 | 3. 점수 리스트 | 4. 총합 / 평균 보기 | 5. 종료\n");

				System.out.println("선택 하세요.");

				int selectNo = scanner.nextInt();								// 선택 하는 번호 selectNo

				if (selectNo == 1) {													// 1. 학급 수 이어서 학생 인원
					
					System.out.println("학급의 개수를 입력하세요.");
					
					classNo = scanner.nextInt();								// 입력한 학급 수 studentNo
					
					for (int i = 1; i <= classNo ; i++) {
						
						System.out.println( i + "번째 학급의 학생 수를 입력하세요");
						
						studentNo = scanner.nextInt();
						
					}

				} else if (selectNo == 2) {										// 2. 점수 입력

					 								// 점수 = [학생수들]의

					for ( int i=0; i<studentNo; i++) {

						System.out.println(i+1+" 번째 학생");

						

				} else if (selectNo == 3) {										// 3. 점수 리스트

					for ( int i=0; i<studentNo; i++) {

						System.out.println(i+1+" 번째 학생 " + scoreArr[i]);} // i, studentNo 학생수

				} else if (selectNo == 4) {										// 4. 총합 / 평균 보기

					int sum = 0;

					for ( int i=0; i<studentNo; i++) {

						sum += scoreArr[i];}

					int avg = sum / studentNo;		

					System.out.println("총합: " + sum);

					System.out.println("평균: " + avg);

//				} else if (selectNo == 6) {										// 6. 오름차순 3. 참조해야할듯?
//					
//					
//					for (int j = 0; j < selectNo; j++) {
//					int scores2[] = new int[];
//							
//					Arrays.sort(scores2);
//					
//					for ( int i=0; i<studentNo; i++) {
//
//						System.out.println(i+1+" 번째 학생 " + scores2[i]);}
					

					
				
				
				
				
				
				
				
				} else if (selectNo == 5) { 

						run = false;

						System.out.println("프로그램 종료");}
		}
	}

