
public class Weapon {

	// name of weapon
	private String name;
	
	// damage of weapon
	private int damage;
	
	// description of weapon
	private String description;
	
	public Weapon(String name, int damage, String description) {
		this.name = name;
		this.damage = damage;
		this.description = description;
	}
	
	public String getName() {
		return name;
	}
	
	public int getDamage() {
		return damage;
	}
	
	public String getDescription() {
		return description;
	}

}
