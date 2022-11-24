
public class Manager {
	private String id;
	private String passWord;
	private int birth;
	private String name;
	private String animal;
	
	public Manager(String id, String passWord, int birth, String name, String animal) {
		this.id = id;
		this.passWord = passWord;
		this.birth = birth;
		this.name = name;
		this.animal = animal;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPassWord() {
		return passWord;
	}
	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}
	public int getBirth() {
		return birth;
	}
	public void setBirth(int birth) {
		this.birth = birth;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAnimal() {
		return animal;
	}
	public void setAnimal(String animal) {
		this.animal = animal;
	}
}
