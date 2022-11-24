
public class Student {
	private String name;
	private char gender;
	private int score;
	private int rank;
	
	public Student(String name, char gender, int score) {
		this.name = name;
		this.gender = gender;
		this.score = score;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public char getGender() {
		return gender;
	}
	public void setGender(char gender) {
		this.gender = gender;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	
	public String toString() {
		return "이름: " + name + " || 성별: " + gender + " || 점수: " + score;
	}
}
