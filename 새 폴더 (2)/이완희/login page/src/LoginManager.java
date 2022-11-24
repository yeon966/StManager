import java.util.Scanner;

public class LoginManager {
	
	Scanner in = new Scanner(System.in);
	
	UserDB userDb = new UserDB();
	
	public void loginStart() {
		
		while(true) {
			printLine();
			System.out.println("관리자 홈페이지");
			printLine();
			System.out.println("1.로그인    2.비밀번호 바꾸기    0.종료");
			int select = in.nextInt();
			printLine();
			
			switch(select) {
				case 1:
					loginPage();
					break;
				case 2:
					changePassword();
					break;
				case 0:
					System.out.println("프로그램을 종료합니다.");
					printLine();
					return;
				default :
					errorMessage();
					continue;
			}
		}
	}
	
	public void loginPage() {
		
		while(true) {
			
			System.out.print("- 아이디\n- ");
			String userId = in.next();
			System.out.print("- 비밀번호\n- ");
			String userPassword = in.next();
			printLine();
			
			boolean pass = loginCheck(userId, userPassword);
			
			if (pass) {
				
				System.out.println(userId + "님 로그인 되었습니다.");
				while(true) {
					
					System.out.println("0. 뒤로가기");
					int select = in.nextInt();
					
					if(select == 0) {
						
						loginStart();
						return;
					} else {
						
						errorMessage();
					}
				}
			} else {
				
				System.out.println("아이디 또는 비밀번호를 잘못 입력하셨습니다.");
				printLine();
			}
		}
	}
	
	public void changePassword() {
		
		while(true) {
			System.out.print("- 현재 아이디\n- ");
			String userId = in.next();
			System.out.print("- 현재 비밀번호\n- ");
			String userPassword = in.next();
			printLine();
			
			boolean pass = loginCheck(userId, userPassword);
			
			if (pass) {
				
				System.out.println("-비밀번호 변경-");
				System.out.print("- 변경할 비밀번호를 입력하세요.\n- ");
				String changePassword = in.next();
				printLine();
				
				changeUserPassword(userId, changePassword);
				loginStart();
				return;
				
			} else {
				
				System.out.println("아이디 또는 비밀번호를 잘못 입력하셨습니다.");
				printLine();
			}
		}
	}
	
	public boolean loginCheck(String userId, String userPassword) {
		
		boolean pass = false;
		
		for(int i = 0; i < userDb.users.length; i++) {
			
			User u = userDb.users[i];
			
			if(u.getId().equals(userId) && u.getPassword().equals(userPassword)) {
				
				pass = true;
				break;
			}
		}
		
		return pass;
	}
	
	public void changeUserPassword(String userId, String changePassword) {
		
		for(int i = 0; i < userDb.users.length; i++) {
			
			User u = userDb.users[i];
			
			if(u.getId().equals(userId)) {
				
				u.setPassword(changePassword);
				System.out.println("비밀번호 변경이 완료되었습니다.");
				break;
			}
		}
	}
	
	public void errorMessage() {
		
		System.out.println("없는 메뉴 입니다.. 다시 선택해 주세요..");
		printLine();
	}
	
	public void printLine() {
		
		System.out.println("--------------------------------------");
	}
}