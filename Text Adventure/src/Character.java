import java.util.ArrayList;

public class Character {
	
	// character stats
	private int hp; // hit points (getting attacked lowers hp; game over when below zero)
	private int strength; // strength defines damage character does
	private int accuracy; // defines chance of landing a hit
	private int perception; // defines chance of finding items
	
	// inventory list
	private ArrayList inventory;
	
	// equipped weapon
	private Weapon myWeapon;
	
	// equipped armor
	private Armor myArmor;

	public Character(int hp, int strength, int accuracy, int perception) {
		this.hp = hp;
		this.strength = strength;
		this.accuracy = accuracy;
		this.perception = perception;
		inventory = new ArrayList();
	}
	
	public void setHp(int hp) {
		this.hp = hp;
	}
	
	public int getHp() {
		return hp;
	}
	
	public void setStrength(int strength) {
		this.strength = strength;
	}
	
	public int getStrength() {
		return strength;
	}
	
	public void setAccuracy(int accuracy) {
		this.accuracy = accuracy;
	}
	
	public int getAccuracy() {
		return accuracy;
	}
	
	public void setPerception(int perception) {
		this.perception = perception;
	}
	
	public int getPerception() {
		return perception;
	}
	
	public void add(Object item) {
		if (item.getClass() == myWeapon.getClass()) {
			
		}
		inventory.add(item);
	}

}
