import java.util.Scanner;
public class LoginTest {
   public static void main(String[] args) {
      Scanner scan = new Scanner(System.in);
      Login[] login = new Login[5];
      login[0] = new Login("아이디1", "비번1", "카리나");
      login[1] = new Login("아이디22", "비번22", "윈터");
      login[2] = new Login("아이디333", "비번333", "지젤");
      login[3] = new Login("아이디4444", "비번4444", "닝닝");
      login[4] = new Login("아이디55555", "비번55555", "나비스");
      
      Login[] loginKwangya = new Login[1];    // 접속한 Login값을 담을 박스
      
      boolean falseLogin = true;      //비밀번호 3번이상 틀리면 false가 되어서 반복종료
      boolean trueLogin = false;     //로그인이 되면 true가 되어서 비밀번호 변경을 물어봄
      
      int falsePW = 0;            //비밀번호 틀린것 카운트
      int count = 0;               //비밀번호 맞춘것 카운트.
      
      while (falseLogin) {
         System.out.print("ID : ");
         String idJoin = scan.next();
         System.out.print("Passward : ");
         String passwardJoin = scan.next();
               
         for (int i = 0; i < login.length; i++) {
            if (login[i].getId().equals(idJoin)    //입력한 아이디와 login[i] 아이디가 같고, 
                  && login[i].getPassword().equals(passwardJoin)) { //비밀번호도 같으면
               loginKwangya[0] = login[i];            //밖에있는 loginOk박스에 
               count++;                     //로그인된 아이디비밀번호닉네임값을 넣고 카운트
            }
         }
               
         if (count >= 1) { // 로그인이 되면 닉네임과 함께 환영메세지.
            System.out.printf("로그인 되었습니다.\n%s님 반갑습니다!\n\n", loginKwangya[0].getNickname());
            trueLogin = true;
         } else {
            falsePW++; //안되면 카운트
            System.out.println("로그인에 실패하였습니다.");
         }      
         if (falsePW >= 3) {
            System.out.println("로그인 3회 실패\n프로그램 종료"); 
            falseLogin = false; //3회 실패하면 카운트 종료
         } 
         
         //로그인에 성공할 경우
         if (trueLogin) {
            System.out.println("비밀번호를 변경하시겠습니까? Y/N");
            String yesOrNo = scan.next();
            System.out.println();
            
            switch(yesOrNo) {
            case "Y" :
               System.out.println("새로운 비밀 번호를 입력하세요.");
               String newPass = scan.next();
               loginKwangya[0].setPassword(newPass); // 비밀번호 변경후에 while로 돌아가서 확인.
            case "N" :
               System.out.println("프로그램 종료");
               falseLogin = false;
               break;
            }
         }
      }
   }
}