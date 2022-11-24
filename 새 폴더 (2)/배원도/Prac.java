///*
//학생 점수 관리 프로그램
//- 한 학급의 학생 관리
//1. 사용자에게 학급의 인원 수를 입력 받아
//2. 각 학생들의 점수도 입력 받음
//- 기능
//1. 학생 점수 나열 (입력 받은 순)
//2. 학생 점수 나열 (오름차순)
//3. 학생 점수 수정 (몇 번째의 학생인지, 새 점수는 몇인지 입력 받아 수정)
//4. 총합 / 평균 보기
//
//- 추가
//1. 학급의 인원 수 추가 기능
//2. 추가 학급 관리 (각 학급의 인원수가 다르다면?)
//3. 학생들의 성별 기록 (이름도 기록해야 한다면?)
//*/
//
//import java.util.Scanner;
//import java.util.Arrays;
//	
//	class Input {
//		Scanner scan = new Scanner(System.in);
//		Class a, b, c;
//		
//		public Input() {
//			a = new Class("a");
//			b = new Class("b");
//			c = new Class("c");
//			
//			while (true) {
//				System.out.println("사용하고자 하는 기능을 입력해주세요: \n1. 점수 나열(입력순) 2. 점수 나열(성적순) 3. 점수 수정"
//						+ "\n4. 총점 및 평균 5. 인원 추가 6. 학급 및 학생 현황");
//				
//				int input = scan.nextInt();
//				switch(input) {
//				case 1:
//					System.out.println("점수 나열(입력순)");
//					System.out.println("a학급: " + Arrays.toString(a.getScore()));
//					System.out.println("b학급: " + Arrays.toString(b.getScore()));
//					System.out.println("c학급: " + Arrays.toString(c.getScore()));
//					break;
//				case 2:			
//					System.out.println("점수 나열(성적순)");
//					scoreHigh(a, "a");
//					scoreHigh(b, "b");
//					scoreHigh(c, "c");
//					break;
//				case 3:
//					System.out.println("점수 변동이 있는 학생의 학급은 무엇입니까?\n1. a / 2. b / 3. c 중 선택");
//					int input2 = scan.nextInt();
//					System.out.println("점수 변경할 학생을 선택하세요.");
//					if (input2 == 1) {
//						System.out.println(Arrays.toString(a.getScore()));
//						input = scan.nextInt();
//						if (0 <= input && input <= 100) {
//							scoreChange(a, "a",input);
//						} else {
//							System.out.println("잘못 입력되었습니다. ");
//						}
//					} else if (input2 == 2) {
//						System.out.println(Arrays.toString(b.getScore()));
//						input = scan.nextInt();
//						if (0 <= input && input <= 100) {
//							scoreChange(b, "b",input);
//						} else {
//							System.out.println("잘못 입력되었습니다. ");
//						}
//					} else if (input2 == 3) {
//						System.out.println(Arrays.toString(c.getScore()));
//						input = scan.nextInt();
//						if (0 <= input && input <= 100) {
//							scoreChange(c, "c",input);
//						} else {
//							System.out.println("잘못 입력되었습니다. ");
//						}
//					}
//					break;
//				case 4:
//					System.out.println("학급별 총점 및 평균 점수");
//					sum(a, "a");
//					sum(b, "b");
//					sum(c, "c");
//					break;
//				case 5:
//					System.out.println("어떤 학급의 인원을 추가하시겠습니까?\n1. a학급 2. b학급 3. c학급");
//					input = scan.nextInt();
//					if (input == 1) {
//						plus(a, "a");
//					} else if (input == 2) {
//						plus(b, "b");
//					} else if (input == 3) {
//						plus(c, "c");
//					} else {
//						System.out.println("잘못 입력되었습니다. ");
//					}
//					break;
//				case 6:
//					outPut(a, "a");
//					outPut(b, "b");
//					outPut(c, "c");
//					break;
//				}
//				
//			}
//		}
//		
//		public void scoreHigh(Class name, String name2) {
//			int reverse = name.getScore()[0];
//			for (int j = 0; j < name.getNumber().length - 1; j++) {
//				for (int i = 0; i < name.getNumber().length - 1; i++) {
//					reverse = name.getScore()[i + 1];
//					name.getScore()[i + 1] = name.getScore()[i];
//					name.getScore()[i] = reverse ;
//				}
//			}
//			System.out.println(name2 + "학급: " + Arrays.toString(name.getScore()));
//		}
//		
//		public void sum(Class name, String name2) {
//			int sum = 0;
//			for (int i = 0; i < name.getNumber().length; i++) {
//				sum += name.getScore()[i];
//			}
//			System.out.print(name2 + "학급의 총점: " + sum + " / 평균: "); 
//			System.out.printf("%.1f\n", sum / name.getNumber().length);
//		}
//		
//		public void scoreChange(Class name, String name2, int name3) {
//			System.out.println("변경된 점수를 입력하세요: ");
//			int input = scan.nextInt();
//			if (0 <= input && input <= 100) {
//				int[] test = Arrays.copyOf(name.getScore(), name.getScore().length);
//				test[name3 - 1] = input;
//				name.setScore(test);
//			}
//			System.out.println("변경 완료");
//		}
//		
//		public void plus(Class name, String name2) {
//			System.out.println(name2 + "학급의 학생을 몇 명 추가하시겠습니까? ");
//			int input = scan.nextInt();
//			if (1 <= input && input <= 10) {
//				int num = name.getNumber().length;
//				name.setNumber(Arrays.copyOf(name.getNumber(), name.getNumber().length + input));
//				name.setStudent(Arrays.copyOf(name.getStudent(), name.getStudent().length + input));
//				name.setScore(Arrays.copyOf(name.getScore(), name.getScore().length + input));
//				for (int i = 0; i < input; i++) {
//					System.out.println("추가한 " + (i + 1) + "번째 학생의 성적을 입력해주세요. ");
//					int input2 = scan.nextInt();
//					if (0 <= input2 && input2 <= 100) {
//						int[] test1 = name.getScore();
//						test1[num + i] = input2;
//						name.setScore(test1);
//					} else {
//						System.out.println("잘못 입력되었습니다. ");
//						i--;
//					}
//					System.out.println("추가한 " + (i + 1) + "번째 학생의 성별을 입력해주세요. ");
//					String st = scan.next();
//					int[] test;
//					if (st.equals("남")) {
//						test = name.getStudent();
//						test[num + i] ++;
//						name.setStudent(test);
//					} else if (st.equals("여")) {
//						test = name.getStudent();
//						test[num + i] += 2;
//						name.setStudent(test);
//					} else {
//						System.out.println("잘못 입력되었습니다. ");
//						i--;
//					}
//					System.out.println(name2 + "학급의 인원 수가" + input + "만큼 증감되었습니다.");
//				}
//			} else {
//				System.out.println("잘못 입력되었습니다. ");
//			}
//		}
//		
//		public void outPut(Class name, String name2) {
//			System.out.println(name2 + "학급의 인원 수: " + name.getNumber().length);
//			for (int i = 0; i < name.getNumber().length; i++) {
//				System.out.print((i + 1) + "번째 학생 점수: " + name.getScore()[i] + "/ 성별: ");
//				if(name.getStudent()[i] == 1) {
//					System.out.println("남");
//				} else if(name.getStudent()[i] == 2) {
//					System.out.println("여");
//				}
//			}
//		}
//		
//	}
//	
//	class Class {
//		private int[] number, score, student;
//		Scanner scan = new Scanner(System.in);
//		
//		public Class(String name) {
//			numberInput(name);
//		}
//		
//		public void numberInput(String name) {
//			while (true) {
//				System.out.println(name + "학급의 학생 수: ");
//				int input = scan.nextInt();
//				if (input > 0 && input < 10) {
//					number = new int[input];
//					student = new int[input];
//					score = new int[input];
//					scoreInput(input, name);
//					break;
//				} else {
//					System.out.println("잘못 입력하였습니다. ");
//					continue;
//				}
//			}
//		}
//		
//		public void scoreInput(int number, String name) { 
//			System.out.println(name + "학급의 학생 성적: ");
//			for (int i = 0; i < number; i++) {
//				System.out.println((i + 1) + "번째 학생의 성적: ");
//				int input = scan.nextInt();
//				if (input >= 0 && input <= 100) {
//					score[i] = input;
//				} else {
//					System.out.println("잘못 입력하였습니다. ");
//					i--; // 잘못된 입력 수 미포함
//				}
//			}
//			studentInput(number, name);
//		}
//		
//		public void studentInput(int number, String name) { 
//			System.out.println(name + "학급의 학생 성별: ");
//			for (int i = 0; i < number; i++) {
//				System.out.println((i + 1) + "번째 학생의 성별: ");
//				String input = scan.next();
//				if (input.equals("남")) {
//					student[i] ++;
//				} else if (input.equals("여")) {
//					student[i] += 2;
//				} else {
//					System.out.println("잘못 입력하였습니다. ");
//					i--; // 잘못된 입력 수 미포함
//				}
//			}
//		}
//
//		public int[] getNumber() {
//			return number;
//		}
//
//		public void setNumber(int[] number) {
//			this.number = number;
//		}
//
//		public int[] getScore() {
//			return score;
//		}
//
//		public void setScore(int[] score) {
//			this.score = score;
//		}
//
//		public int[] getStudent() {
//			return student;
//		}
//
//		public void setStudent(int[] student) {
//			this.student = student;
//		}
//	}
//
//public class Prac {
//	public static void main(String[] args) {
//		Input i = new Input();
//	}
//}