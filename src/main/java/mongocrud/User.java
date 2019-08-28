package mongocrud;

public class User {
	
	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", role=" + role + ", isEmployee=" + isEmployee + "]";
	}
	public User(int id, String name, String role, boolean isEmployee) {
		super();
		this.id = id;
		this.name = name;
		this.role = role;
		this.isEmployee = isEmployee;
	}
	private int id;
	private String name;
	private String role;
	private boolean isEmployee;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public boolean isEmployee() {
		return isEmployee;
	}
	public void setEmployee(boolean isEmployee) {
		this.isEmployee = isEmployee;
	}
}
