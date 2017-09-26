package evolution.entity;

public class AnyEntity {
	private String name;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "AnyEntity [name=" + name + "]";
	}
}
