/*
 	학생 점수 관리 프로그램
 	- 여러개 학급의 여러 학생 관리
 		1. 사용자에게 여러개 학급의 인원 수를 입력받아 (예.학급:2개, 학생:3명)
 		2. 학생들의 이름과 점수와 성별 기록
 	- 기능
 		1. 학생 목록(이름, 점수, 성별) 나열 (입력 받은 순)
 		2. 학생 정보 수정(몇 번째의 학생인지, 입력받아 수정)
 		3. 총합 / 평균 보기
 	
 	관리자 계정 관리 프로그램
 	지정된 관리자(아이디, 비밀번호, 기타정보) 계정 5개 존재
	 	1. 로그인
	 	2. 비밀번호 바꾸기
 */

public class Student {
	private int classs;
	private int classsNumber;
	private String name;
	private int score;
	private String gender;
	
	public Student(int classs , int classsNumber, String name, int score, String gender) {
		this.classs = classs;
		this.classsNumber = classsNumber;
		this.name = name;
		this.score = score;
		this.gender = gender;
	}
	
	public int getClasssNumber() {
		return classsNumber;
	}

	public void setClasssNumber(int classsNumber) {
		this.classsNumber = classsNumber;
	}

	public int getClasss() {
		return classs;
	}

	public void setClasss(int classs) {
		this.classs = classs;
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
		return  (classs + 1) + "번 학급의  " + (classsNumber + 1) + "번째 학생 \n이름 : " + name + "\n성적 : " + score + "\n성별: " + gender;
	}
	
	
	
	
	

}
