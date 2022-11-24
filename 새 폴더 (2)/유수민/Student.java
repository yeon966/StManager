public class Student {
	private String name;
	private int score;
	private String gender;
	
	public Student(String name, int score, String gender) {
		this.name = name;
		this.score = score;
		this.gender = gender;
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
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	@Override
	public String toString() {
		return "학생 이름 : " + name + ", 점수 : " + score + ", 성별 : " + gender;
	}
	
	
	
}
