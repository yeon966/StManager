package pracice;

import java.util.Scanner;

public class LoginTest {
	public static void main(String[] args) 
	{
		MemberHandler handler = new MemberHandler(100);

		while (true)
		{
			System.out.println("------- 메뉴 선택 -------");
			System.out.println("1. 회원가입");
			System.out.println("2. 로 그 인");
			System.out.println("3. 비밀번호 변경");
			System.out.println("9. 프로그램 종료");

			Scanner sc = new Scanner(System.in);
			int choice = sc.nextInt();

			switch (choice)
			{
			case 1:
				handler.MemberInsert(); break;
			case 2:
				handler.memberLogin(); break;
			case 3:
				handler.ChangePassword(); break;
			case 9:
				System.out.println("프로그램 종료");
				return;
			}

		}
	}

}
