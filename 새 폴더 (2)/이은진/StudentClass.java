import java.util.Arrays;

/*
- 기능
1. 학생 목록(이름, 점수, 성별) 나열(입력받은 순)
3. 학생 정보 수정 (몇 번째의 학생인지, 입력받아 수정)
4. 총합 / 평균 보기
5. 추가 학급 관리 (각 학급의 인원수가 다르면? ) - 입력: 몇개의 반
6. 학생들의 이름과 점수와 성별 기록 - 입력 / 출력 수정
 */

public class StudentClass {
	Student[] students;
	
	public StudentClass(int num) {
		this.students = new Student[num];
	}
	
	public Student[] getStudents() {
		return students;
	}
	
	public void setStudents(Student[] students) {
		this.students = students;
	}
	
	// 학생 정보(이름, 점수, 성별)보기 (입력받은 순)
	public void getInformation() {
		for (int i = 0; i < students.length; i++) {
			System.out.println((i + 1) + "번 학생 " + students[i].toString());
		}
	}
	
	// 원하는 학생 정보보기
	public void getInformationByIndex(int num) {
		System.out.println(students[num - 1].toString());
	}
	
	// 학생 점수 수정 (몇 번째의 학생인지, 입력받아 수정)
	public Student changeScore(int num, int newScore) {
		students[num - 1].setScore(newScore);
		System.out.println(num + "번 학생 점수가 " + newScore + "점으로 변경되었습니다.");
		return students[num - 1];
	}
	
	// 학생들의 이름과 성별 수정 - 입력 / 출력 
	public Student resetInformation(int num, String newName, String gender) {
		students[num - 1].setName(newName);
		students[num - 1].setGender(gender);
		System.out.println(num + "번 학생 정보가 변경되었습니다.");
		System.out.println("-이름: " + newName);
		System.out.println("-성별: " + gender);
		return students[num - 1];
	}
	
	// 총합 / 평균 보기
	public int getSum() {
		int sum = 0;
		for (int i = 0; i < students.length; i++) {
			sum += students[i].getScore();
		}
		return sum;
	}
	public int getAvg() {
		return (this.getSum() / students.length);
	}
	
	// 학생 추가
	public Student[] plusStudent(Student[] origin, Student newStu) {
		students = Arrays.copyOf(origin, origin.length + 1);
		students[origin.length] = newStu;
		System.out.println("추가완료: " + newStu.toString());
		return students;
	}
}