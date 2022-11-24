import java.util.Arrays;
import java.util.Scanner;

// 박민 : 변수 이름이 약자인데 서로 너무 비슷해서 혼란이 오네요. 좀 더 의미있는 이름을 사용해보세요~

public class Prac2 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int score;
		
		
		System.out.print("학급수를 입력하세요: ");
		int classNum = scan.nextInt();
		int[] cN = new int[classNum];
		
		
		System.out.print("학생 수를 입력하세요: ");
		int studentNum = scan.nextInt();
		int[] sN = new int[studentNum];
		int[] sc = new int[studentNum];
		String[] sn = new String[studentNum];
		String[] se = new String[studentNum];
		
		for (int i = 0; i < sN.length; i++) {
			Scanner info = new Scanner(System.in);
			System.out.printf("%d번째 학생", i + 1);
			System.out.print("이름: ");
			String studentName = scan.next();
			sn[i] = studentName;
			
			System.out.print("점수: ");
			score = scan.nextInt();
			sc[i] = score;
			
			System.out.print("성별: ");
			String sex = scan.next();
			se[i] = sex;
			
		}
		
		
		System.out.println("입력 받은 순");
		for (int i = 0; i < sN.length; i++) {
			
			System.out.println("\n이름: " + sn[i] + "\n점수: " + sc[i] + "\n성별: " + se[i]);
		}

		System.out.print("\n입력한 정보를 수정하려면 1번을 입력하세요. \n수정하지 않고 진행하시려면 1번을 제외한 아무숫자나 입력하세요. ");
		Scanner info = new Scanner(System.in);
		int fix = info.nextInt();
		
		if (fix == 1) {
			System.out.print("\n몇번째 학생의 점수를 변경하시겠습니까? ");
			int fix1 = info.nextInt();
			
			
			System.out.print("변경하실 점수를 입력하세요: ");
			int fix2 = info.nextInt();
			
			sc[fix1 - 1] = fix2;
		} else if (fix != 1){
			
		}
		for (int i = 0; i < sN.length; i++) {
			
			System.out.println("\n이름: " + sn[i] + "\n점수: " + sc[i] + "\n성별: " + se[i]);
		}
		
		int sum = 0;
		for (int i = 0; i < sN.length; i++) {
			sum = sum + sc[i];
		}
		System.out.println("\n총합: " + sum);
		System.out.println("평균: " + sum / studentNum);
	}
}