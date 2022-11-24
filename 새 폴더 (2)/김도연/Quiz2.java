import java.util.Arrays;
import java.util.Scanner;

//관리자 계정 관리 프로그램
///	지정된 관리자(아이디, 비밀번호, 기타정보) 계정 5개 존재
// 	1. 로그인
//	2. 비밀번호 바꾸기
public class Quiz2 {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		
		Quiz2Info[] manager = new Quiz2Info[5];
		manager[0] = new Quiz2Info("dy0218","dy1234","도연");
		manager[1] = new Quiz2Info("ig1001", "ig1234", "인국");
		manager[2] = new Quiz2Info("ou0723", "ou1234", "유정");
		manager[3] = new Quiz2Info("jui0806", "jui1234", "주이");
		manager[4] = new Quiz2Info("ej1018", "ej1234", "은주");
		
		System.out.println(Arrays.toString(manager)); 
		
		
	
		System.out.println("로그인");       //로그인창 
		System.out.println("--------------");
		System.out.print("아이디: ");
		String userId = sc.next();
		System.out.print("비밀번호: "); //여러번 틀리면 안되게 .
		String userPassword = sc.next();
		
		for(int i=0;i<manager.length;i++) {
			if(userId.equals(manager[i].getId())) {
				if(userPassword.equals(manager[i].getPassword())) {
					System.out.println("로그인되었습니다.");
				break;
				}
				else{
					System.out.println("비밀번호를 잘못입력하셨습니다.");
				}
			}
		}
		
		//비밀번호바꾸기- 로그인->변경비밀번호 ->변경비밀번호 한번더 치기 ->변경완료 
		for(int i=0;i<manager.length;i++) {
			if(userId.equals(manager[i].getId()) && userPassword.equals(manager[i].getPassword())) {
				System.out.println("변경할 비밀번호를 입력하세요");
				manager[i].setPassword(sc.next());
				System.out.println(manager[i].getPassword());
			}
		}
	}
}

