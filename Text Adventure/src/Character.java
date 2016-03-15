import java.util.ArrayList;

public class Character {
	
	// character stats
	private int hp; // hit points (getting attacked lowers hp; game over when below zero)
	private int strength; // strength defines damage character does
	private int accuracy; // defines chance of landing a hit
	private int perception; // defines chance of finding items
	
	// inventory list
	private ArrayList inventory;

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
	
	public void setStrength(int strength) {
		this.strength = strength;
	}
	
	public void setAccuracy(int accuracy) {
		this.accuracy = accuracy;
	}
	
	public void setPerception(int perception) {
		this.perception = perception;
	}
	
	public void add(Object temp) {
		inventory.add(temp);
	}

}
