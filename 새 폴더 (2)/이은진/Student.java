public class Student {
	private int classNum;
	private String name;
	private int score;
	private String gender; 
	
	public Student() {
	}
	public Student(int classNum, String name, int score, String gender) {
		this.classNum = classNum;
		this.name = name;
		this.score = score;
		this.gender = gender;
	}
	
	public int getClassNum() {
		return classNum;
	}
	public void setClassNum(int classNum) {
		this.classNum = classNum;
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
	public String toString() {
		return "Student [classNum=" + classNum + ", name=" + name + ", score=" + score + ", gender=" + gender + "]";
	}
}