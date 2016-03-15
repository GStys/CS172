import java.util.ArrayList;

public class Room {
	
	// Name of the room
	private String name;
	
	// Description of the room
	private String description;
	
	// exits at directions specified
	private ArrayList<String> exits;
	
	// Adjacent rooms at direction of exit.get(same index)
	private ArrayList<Room> neighbors;
	
	// Room's treasure
	private Treasure item;
	
	// Room's monster
	private Monster baddie;
	
	// Room's weapon
	private Weapon excalabur;

	public Room(String name, String description) {
		this.name = name;
		this.description = description;
		neighbors = new ArrayList<Room>();
		exits = new ArrayList<String>();
		item = null;
		baddie = null;
		excalabur = null;
	}
	
	public String getName() {
		return name;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void addNeighbor(String direction, Room neighbor) {
		exits.add(direction);
		neighbors.add(neighbor);
	}
	
	public Room getNeighbor(String direction) {
		for (int i=0; i<exits.size(); i++) {
			if (exits.get(i).equals(direction)) {
				return neighbors.get(i);
			}
		}
		return null;
	}
	
	public String listExits() {
		return exits.toString();
	}

	public Treasure getTreasure() {
		return item;
	}
	
	public void setTreasure(Treasure temp) {
		item = temp;
	}
	
	public Monster getMonster() {
		return baddie;
	}
	
	public void setMonster(Monster temp) {
		baddie = temp;
	}
	
	public Weapon getWeapon() {
		return excalabur;
	}
	
	public void setWeapon(Weapon temp) {
		excalabur = temp;
	}

}
