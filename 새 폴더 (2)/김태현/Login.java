package pracice;

import java.util.Scanner;

// 박민 : 들여쓰기 및 중괄호 위치 신경 써주세요~~~~~

//회원정보
class Member{
	private String id, password, other;

	public Member(String id, String password, String other) {
		super();
		this.id = id;
		this.password = password;
		this.other = other;
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

	public String getOther() {
		return other;
	}

	public void setOther(String other) {
		this.other = other;
	}
	
}

class MemberHandler
{
	private Member[] members;
	private int idx;

	public MemberHandler(int num){
		members = new Member[num];
		idx = 0;
	}

	private boolean isUniqueID(String uid){ // 아이디의 중복 여부를 리턴
		if (idx == 0) return true;

		for (int i = 0 ; i < idx ; i ++)
		{
			if (members[i].getId().equals(uid))
			{
				return false;
			}
		}
		return true;
	}



	
//회원가입
public void MemberInsert() {
	String uid, upassword, uother;
	Scanner scan = new Scanner(System.in);
	System.out.print("아이디 :");
	uid = scan.next();
	if(!isUniqueID(uid)) {
		System.out.println("사용중인 아이디");
		return;
	}
	System.out.print("암 호 : "); 
	upassword = scan.next();
	System.out.print("이 름 : "); 
	uother = scan.next();
	
	members[idx] = new Member(uid, upassword, uother);
	idx++;
	System.out.println("가입완료");

}

public void memberLogin(){
	Scanner sc = new Scanner(System.in);
	System.out.print("아이디 : "); String uid = sc.nextLine();
	System.out.print("패스워드 : "); String pwd = sc.nextLine();
	String msg = "존재하지 않는 아이디 입니다.";

	for (int i = 0 ; i < idx ; i++ )
	{
		if (members[i].getId().equals(uid))
		{// members배열에 입력한 아이디가 있으면
			if (members[i].getPassword().equals(pwd))
			{
				msg = "로그인 되었습니다.";
			} else{
				msg = "암호가 잘못되었습니다.";
			}
		}
	}
	System.out.println(msg);
}
public void ChangePassword () {
	Scanner sc = new Scanner(System.in);
	System.out.print("기존 아이디를 입력해주세요 : ");
	String cid = sc.nextLine();
	for (int i = 0; i < members.length; i++) {
		
		if(members[i].getId().equals(cid)) {
			System.out.print("기존 비밀번호를 입력해 주세요 : ");
			String cpwd = sc.nextLine();
			if(members[i].getPassword().equals(cpwd)) {
				System.out.print("변경할 비밀번호를 입력해주세요 : ");
				String pwd = sc.nextLine();
				members[i].setPassword(pwd);
				System.out.println("변경 완료");
				return;
				
			}else {
				System.out.println("잘못 입력하였습니다.");
				return;
				}
		}else {
			System.out.println("잘못 입력하였습니다.");;
			return;
			}
	}
	
}


}




