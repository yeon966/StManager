/*학생 점수 관리 프로그램
 	- 한 학급의 학생 관리
 		1. 사용자에게 여러개의 학급의 인원수를 입력받아(예,학급:2개 학생:3명)
 		2. 학생들의 이름과 점수와 성별 기록
 	- 기능
 		1. 학생목록(이름,점수,성별 )나열 (입력받은 순)
 		2. 학생 점수 수정(몇 번째의 학생인지, 입력받아 수정)
 		3. 총합 / 평균 보기
 		
 	- 관리자 계정관리 프로그램
 		지정된 관리자(아이디,비밀번호,기타정보)계정 5개 존재
 		1.로그인
 		2.비밀번호 바꾸기
 */
public class ClassQuiz {
	
	private String name;
	private int score;
	private String sex;
	private int changeScore;
	
	public ClassQuiz(String name, int score, String sex) {
		
		this.name = name;
		this.score = score;
		this.sex = sex;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}
	
	public int getChangeScore() {
		return changeScore;
	}

	public void setChangeScore(int changeScore) {
		this.changeScore = changeScore;
	}

	public String toString() {
		return " 이름=" + name + ", 점수=" + score + ", 성별=" + sex;
	}
	
}