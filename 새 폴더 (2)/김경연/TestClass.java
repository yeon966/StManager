import java.util.Scanner;

public class TestClass {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
			
		System.out.println("학급의 학생 수를 입력하세요.");
		int studentsNum = scan.nextInt();
		Class c1 = new Class(studentsNum);
		c1.setStArr();
		boolean onOff = true;
		while(onOff) {
			System.out.println("0번을 누르면 메뉴창이 보입니다.");
			if (scan.nextInt() != 0) {
				continue;
			}
			System.out.println("번호를 선택하세요.\n"
					+ "1번 : 학급의 학생명/성별/성적 보기\n"
					+ "2번 : 학생 점수 수정\n"
					+ "3번 : 해당 학급 성적 총합 및 평균 보기\n"
					+ "4번 : 학생 정보 추가하기.\n"
					+ "5번 : 프로그램 종료.");
			int button = scan.nextInt();
			if(button > 0 && button <= 6) {
				switch(button) {
				case 1:
					c1.showArr();
					break;
				case 2:
					c1.modifyScore();
					break;
				case 3:
					System.out.println("학급의 총합 : " + c1.sum() + "점");
					System.out.println("학급의 평균 : " + c1.avg() + "점");
					break;
				case 4:
					c1.plusSt();
					break;
				case 5:
					onOff = false;
					break;
				} 
			} else {
				System.out.println("1 ~ 6사이 정수를 입력하세요.");
			}
		}
	}
}
