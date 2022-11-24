
public class Student {
	private String stName;
	private String stGender;
	private int score;
	
	
	public Student() {

	}


	public Student(String stName, String stGender, int score) {
		this.stName = stName;
		this.stGender = stGender;
		this.score = score;
	}


	@Override
	public String toString() {
		return "학생 정보 : [학생 이름 : " + stName + ", 학생 성별 : " + stGender + ", 학생 점수 : " + score + "]";
	}


	public String getStName() {
		return stName;
	}


	public void setStName(String stName) {
		this.stName = stName;
	}


	public String getStGender() {
		return stGender;
	}


	public void setStGender(String stGender) {
		this.stGender = stGender;
	}


	public int getScore() {
		return score;
	}


	public void setScore(int score) {
		this.score = score;
	}
	
	
	
}