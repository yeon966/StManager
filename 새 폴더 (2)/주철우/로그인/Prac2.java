/*	
 	관리자 계정 관리 프로그램
	지정된 관리자(아이디, 비밀번호, 기타정보) 계정 5개 존재
		1. 로그인
		2. 비밀번호 바꾸기
*/
import java.util.Scanner;

public class Prac2 {
	public static void main(String[] args) {	
		Scanner scan = new Scanner(System.in);
		
		Manager[] managers = new Manager[5];
		managers[0] = new Manager("admin1", "abc012", 911023, "철우", "강아지");
		managers[1] = new Manager("admin2", "abc123", 011111, "진아", "호랑이");
		managers[2] = new Manager("admin3", "abc234", 980403, "포비", "고양이");
		managers[3] = new Manager("admin4", "abc345", 970623, "철수", "곰");
		managers[4] = new Manager("admin5", "abc456", 990121, "영희", "사자");
		
		System.out.println("-----로그인-----");
		
		int count = 0;
		int accessId = 0;
		String userInput;
		int step = 0;
		boolean onOff = true;
		
		while (onOff) {
			
			count = 0;
			
			while (step == 0) {
				if (count >= 5) {
					System.out.printf("존재하지 않는 ID 입니다.(%d회 시도)\n", count);
					System.out.println("너무 많은 시도로 프로그램 종료합니다.");
					onOff = false;
					break;
				} else if (count > 0) {
					System.out.printf("잘못된 입력입니다.(%d회 시도)\n", count);
				}
				System.out.print("ID: ");
				userInput = scan.nextLine();
				for (int i = 0; i < managers.length; i++) {
					if (managers[i].getId().equals(userInput)) {
						accessId = i;
						step = 1;
					}
				}
				count++;
			}
			
			count = 0;
			
			while (step == 1) {
				if (count >= 5) {
					System.out.printf("잘못된 입력입니다.(%d회 시도)\n", count);
					System.out.println("너무 많은 시도입니다.");
					break;
				} else if (count > 0) {
					System.out.printf("잘못된 입력입니다.(%d회 시도)\n", count);
				}
				System.out.print("PW: ");
				userInput = scan.nextLine();
				if (managers[accessId].getPassWord().equals(userInput)) {
					System.out.printf("관리자 %s님 반갑습니다.\n", managers[accessId].getId());
					step = 2;
				}
				count++;
			}
			
			while (step ==1 && count >= 5 && onOff) {
				System.out.println("1. 비밀번호 찾기");
				System.out.println("0. 프로그램 종료");
				System.out.print("선택할 기능: ");
				
				switch (scan.nextInt()) {
				case 1:
					int birth;
					String name;
					String animal;
					System.out.println("생년월일, 이름, 좋아하는 동물을 입력하세요.");
					System.out.print("생년월일(6자리): ");
					birth = scan.nextInt();
					System.out.print("이름: ");
					scan.nextLine();
					name = scan.nextLine();
					System.out.print("좋아하는 동물: ");
					animal = scan.nextLine();
					if (managers[accessId].getBirth() == birth
							&& managers[accessId].getName().equals(name)
							&& managers[accessId].getAnimal().equals(animal)) {
						System.out.println("비밀번호는 " + managers[accessId].getPassWord() + " 입니다.");
						step = 0;
					} else {
						System.out.println("일치하는 관리자가 없습니다.");
					}
					break;
				case 0:
					onOff = false;
					break;
				default :
					System.out.println("잘못된 입력입니다.");
					break;
				}
			}
			
			while (step == 2 && onOff) {
				System.out.println("<관리자 계정 관리 프로그램>");
				System.out.println("1. 비밀번호 변경");
				System.out.println("0. 프로그램 종료");
				System.out.print("선택할 기능: ");
				
				switch (scan.nextInt()) {
				case 1:
					System.out.print("변경할 비밀번호: ");
					scan.nextLine();
					String pw = scan.nextLine();
					managers[accessId].setPassWord(pw);
					System.out.println("로그아웃 됩니다. 다시 로그인 해주세요.");
					step = 0;
					break;
				case 0:
					onOff = false;
					break;
				default :
					System.out.println("잘못된 입력입니다.");
					break;
				}
			}
		}
		

		System.out.println("프로그램 종료");
	}
}
