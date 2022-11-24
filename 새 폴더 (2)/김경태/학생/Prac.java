import java.util.Scanner;

public class Prac {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("학급 수를 입력하세요.");	
		int scanClass = scan.nextInt();
		int[] classs = new int[scanClass];
		int count = 0; //studenss[count]
		
		Student[] studentss = new Student[100]; // ????????????
		
		for (int i = 0; i < classs.length; i++) {
			System.out.printf("%d번째 학급 학생수를 입력하세요\n", i+1);
			int scanStudent = scan.nextInt();
			
			for ( int i2 = 0; i2 < scanStudent; i2++) {	
				System.out.printf("%d번째 학생 이름", i2+1);
				String scanName = scan.next();
				
				System.out.printf("%d번째 학생 점수 :", i2+1);
				int scanScore = scan.nextInt();
				
				System.out.printf("%d번째 학생 성별 :", i2+1);
				String scanGender = scan.next();
				
				studentss[count] = new Student(i , i2 , scanName, scanScore, scanGender);
				count++;
				}
			}
		
		while (true) {
			System.out.print("무엇을 하시겠습니까??\n1.목록 보기   2.학생 정보 수정   3.총합/평균 점수");
			int list = scan.nextInt();
			switch (list) {
			case 1 : 
			//1. 학생 목록(이름, 점수, 성별) 나열 (입력 받은 순)
				for ( int i = 0; i < studentss.length; i++) {
					if (studentss[i]!= null) { //studentss 배열이 너무 많아서
						System.out.println(studentss[i]);
					}
				}
				break;
				
			case 2 :
				//2. 학생 정보 수정(몇 번째의 학생인지, 입력받아 수정)
				System.out.print("수정할 학생의 학급을 입력하세요");
				int insertClass = scan.nextInt();
				System.out.print("수정할 학생의 번호를 입력하세요");
				int insertNumber = scan.nextInt();
				System.out.print("무엇을 수정 하시겠습니까\n1.이름   2.점수   3.성별");
				int insert = scan.nextInt();
				switch (insert) {
				case 1 : 
					System.out.print("수정할 학생의 이름를 입력하세요");
					String insertName = scan.next();
					for (int i = 0; i < count; i++) {
						if ( studentss[i].getClasss() == insertClass-1 && // 입력한 번호 == i++로 찾는 studentss
							 studentss[i].getClasssNumber() == insertNumber-1 ) {  //학급과 번호가 맞을때
							studentss[i].setName(insertName);    //setname 으로변경
						}
					}
					break;
					
				case 2 :
					System.out.print("수정할 학생의 점수을 입력하세요");
					int insertScore = scan.nextInt();
					for (int i = 0; i < count; i++) {
						if ( studentss[i].getClasss() == insertClass-1 && 
							 studentss[i].getClasssNumber() == insertNumber-1 ) {
							studentss[i].setScore(insertScore);
						}
					}
					break;
					
				case 3 :
					System.out.print("수정할 학생의 성별을 입력하세요");
					String insertGender = scan.next();
					for (int i = 0; i < count; i++) {
						if ( studentss[i].getClasss() == insertClass-1 && 
							 studentss[i].getClasssNumber() == insertNumber-1 ) {
							studentss[i].setGender(insertGender);
						}
					}
					break;
				}
				break;
				
			case 3 :
				System.out.print("총합/평균 점수를 보고싶은 학급을 입력하세요");
				int lookSum = scan.nextInt();
				int sum = 0;
				int howManySum = 0;
				for (int i = 0; i < count; i++) {
					if ( studentss[i].getClasss() + 1 == lookSum) { // 입력한 학급수 == Class수
						sum += studentss[i].getScore();
						howManySum++;
					}
				}
				System.out.printf("총합은 %d\n", sum);
				System.out.printf("평균은 %d\n", sum/howManySum);
				break;
				
			default:
				System.out.println("잘못된 입력");
				break;
			}
		}
	}
}