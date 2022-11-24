// 관리자 계정 관리 프로그램
// 지정된 관리자(아이디, 비밀번호, 개인정보(자유)) 계정 5개 존재
// 1. 로그인
// 2. 비밀번호 바꾸기
// 목록보기

import java.util.Scanner;
import java.util.Arrays;

class Manager {
	Server[] server;
	Scanner scan;
	int onOff;
	
	public void manager() {
		scan = new Scanner(System.in);
		server = new Server[5];
		server[0] = new Server("id0001", "pw0001", 22);
		server[1] = new Server("id0002", "pw0002", 24);
		server[2] = new Server("id0003", "pw0003", 26);
		server[3] = new Server("id0004", "pw0004", 28);
		server[4] = new Server("id0005", "pw0005", 30);
		boolean sw = true; // 프로그램 종료 버튼
		onOff = 5; // 로그인 여부, 로그인 상태에서 비밀번호 변경시 index 역할
		
		while (sw) {
			if (onOff == 5) {
				System.out.println("사용할 기능 입력: \n1. 로그인 2. 비밀번호 변경 3. 프로그램 종료");
				int input = scan.nextInt();
				switch (input) {
					case 1:
						login(server);
						break;
					case 2:
						 passWordChange(server);
						break;
					case 3:
						System.out.println("프로그램 종료");
						sw = false;
						break;
					default:
						System.out.println("잘못 입력하였습니다. ");
						break;
				}
			} else if (onOff < 5) {
				// 로그인 후 관리자 목록 기능 추가
				System.out.println("사용할 기능 입력: \n1. 로그아웃 2. 비밀번호 변경 3. 관리자 목록 4. 프로그램 종료");
				int input = scan.nextInt();
				switch (input) {
					case 1:
						logOut();
						break;
					case 2:
						loginPassWordChange(server);
						break;
					case 3:
						adminList(server);
						break;
					case 4:
						System.out.println("프로그램 종료");
						sw = false;
						break;
					default:
						System.out.println("잘못 입력하였습니다. ");
						break;
				}
			}
		}
		
	}
	
	// 로그아웃
	public void logOut() {
		onOff = 5;
		System.out.println("로그아웃 완료\n");
	}
	
	// 로그인
	public void login(Server[] name) {
		System.out.println("아이디를 입력해주세요: ");
		String input = scan.next();
		boolean idOnOff = false;
		boolean pwOnOff = false;
		for (int i = 0; i < name.length; i++) {
			if (input.equals(name[i].getId())) {
				idOnOff = true;
			}
		}
		if (idOnOff) {
			System.out.println("비밀번호를 입력해주세요: ");
			input = scan.next();
			for (int i = 0; i < name.length; i++) {
				if (input.equals(name[i].getPassword())) {
					pwOnOff = true;
					System.out.println("로그인 완료\n");
					onOff = i;
				}
			}
		}
		if (idOnOff && !pwOnOff) {
			System.out.println("비밀번호가 틀렸습니다. ");
		} else if (!idOnOff) {
			System.out.println("아이디가 존재하지 않습니다. ");
		}
			
	}
	
	// 로그인 전 비밀번호 변경
	public void passWordChange(Server[] name) {
		boolean idOnOff = false;
		boolean pwOnOff = false;
		System.out.println("비밀번호를 변경할 아이디 입력: ");
		String input = scan.next();
		int num = 0;
		
		for (int i = 0; i < name.length; i++) {
			if (input.equals(name[i].getId())) {
				num = i;
				idOnOff = true;
			}
		}
		if (idOnOff) {
			System.out.println("변경할 비밀번호 입력: ");
			input = scan.next();
			for (int i = 0; i < name.length; i++) {
				if (input.equals(name[i].getPassword())) {
					System.out.println("변경 불가능한 비밀번호입니다. \n");
					pwOnOff = true;
				}
			}
			if (!pwOnOff) {
				name[num].setPassword(input);
				System.out.println("비밀번호가 변경되었습니다. \n");
			}
		} else if (!idOnOff) {
			System.out.println("아이디가 존재하지 않습니다. \n");
		}
		
	}
	
	// 로그인 후 비밀번호 변경
	public void loginPassWordChange(Server[] name) {
		boolean pwOnOff = false;
		System.out.println("변경할 비밀번호 입력: ");
		String input = scan.next();
		for (int i = 0; i < name.length; i++) {
			if (input.equals(name[i].getPassword())) {
				System.out.println("변경 불가능한 비밀번호입니다. \n");
				pwOnOff = true;
			}
		}
		if (!pwOnOff) {
			name[onOff].setPassword(input);
			System.out.println("비밀번호가 변경되었습니다. \n");
		}
	}
	
	// 관리자 목록 보기 기능
	public void adminList(Server[] name) {
		String[] idList = new String[name.length];
		int[] ageList = new int[name.length]; 
		for (int i = 0; i < name.length; i++) {
			idList[i] = name[i].getId();
		}
		System.out.print("ID 현황: " + Arrays.toString(idList) + "\n");
		for (int i = 0; i < name.length; i++) {
			ageList[i] = name[i].getAge();
		}
		System.out.print("나이 현황: " + Arrays.toString(ageList) + "\n\n");
	}
	
}

class Server {
	private String id;
	private String password;
	private int age;
	public Server(String id, String password, int age) {
		this.id = id;
		this.password = password;
		this.age = age;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
}

public class Admin {
	public static void main(String[] args) {
		Manager a = new Manager();
		a.manager();
	}
}
