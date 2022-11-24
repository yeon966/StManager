/*학생 점수 관리 프로그램
 	- 한 학급의 학생 관리
 		1. 사용자에게 여러개의 학급의 인원수를 입력받아(예/학급:2개 학생:3명)
 		2. 학생들의 이름과 점수와 성별 기록
 	- 기능
 		1. 학생목록(이름,점수,성별 )나열 (입력받은 순)
 		2. 학생 점수 수정(몇 번째의 학생인지, 입력받아 수정)
 		3. 총합 / 평균 보기
 		
 	- 관리자 계정관리 프로그램
 		지정된 관리자(아이디,비밀번호,기타정보)계정 5개 존재
 		1.로그인
 		2.비밀번호 바꾸기
 */
import java.util.Arrays;
import java.util.Scanner;
public class QuizTest {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		
		ClassQuiz[][] arr;
		
		System.out.print("학급이 몇개입니까?");
		int numClass =sc.nextInt();
		System.out.print("학생이 몇명입니까?");
		int numStudent =sc.nextInt();
		arr= new ClassQuiz[numClass][numStudent]; //학급과 학생의 배열 만들기
		
		
		for(int i=0;i<arr.length;i++) {  //학급의 길이
			System.out.println((i+1)+"반");
			for(int j=0;j<arr[i].length;j++) {
				System.out.print("이름:");
				String name =sc.next();
				System.out.print("점수:");
				int score =sc.nextInt();
				System.out.print("성별:");
				String sex =sc.next();
				arr[i][j]=new ClassQuiz(name,score,sex);   //학생이름,점수,성별 입력받아 배열넣기
			}
			System.out.println("--------------------");
		}
		
		boolean a =true;
		while(a) {
		System.out.println("1.목록  2.수정  3.총합/평균  0.종료");
		int num =sc.nextInt();
		switch(num) {
			case 1: 
				System.out.println(Arrays.deepToString(arr)); //1번 목록 나열 
				break;
				
			case 2:
				System.out.print("몇반 학생을 수정하시겠습니까?"); //2번 수정
				int changeNumClass = sc.nextInt()-1;
				System.out.print("몇번 학생을 수정하시겠습니까?"); 
				int changeNumStudent = sc.nextInt()-1;
				ClassQuiz q = arr[changeNumClass][changeNumStudent];
				System.out.print("수정 이름: ");
				q.setName(sc.next());
				System.out.print("수정 점수: ");
				q.setScore(sc.nextInt());
				System.out.print("수정 성별: ");
				q.setSex(sc.next());
				System.out.println(Arrays.deepToString(arr));
				break;
				
			case 3:
				int sum=0;
				int count=0;
				for(int i=0;i<arr.length;i++) {   //총합,평균구하기
					for (int j = 0; j < arr[i].length; j++) {
					sum += arr[i][j].getScore();  
					count++;
					}
				}
				System.out.println("총합: "+sum);
				System.out.println("평균: "+(double)sum/count);
				break;
				
			case 0:
				System.out.println("프로그램 종료");
				a=false;
				break;
		}
		}
	}	
	
}			
	

