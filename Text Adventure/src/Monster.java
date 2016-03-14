
public class Monster {
	
	// Name of the monster
	private String name;
	
	// Armor value of monster
	private int armor;
	
	// Description of the monster
	private String description;

	public Monster(String name, int hp, String description) {
		this.name = name;
		this.armor = hp;
		this.description = description;
	}

	public String getName() {
		return name;
	}
	
	public String getDescription() {
		return description;
	}
	
	public int getArmor() {
		return armor;
	}

}
