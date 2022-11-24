public class Quiz2Info {
	private String id;
	private String password;
	private String info;
	
	public Quiz2Info(String id, String password, String info) {
		this.id = id;
		this.password = password;
		this.info = info;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}

	public String toString() {
		return "Quiz2Info [id=" + id + ", password=" + password + ", info=" + info + "]";
	}
}
