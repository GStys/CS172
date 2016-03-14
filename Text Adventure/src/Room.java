import java.util.ArrayList;

public class Room {
	
	// Name of the room
	private String name;
	
	// Description of the room
	private String description;
	
	// Adjacent rooms at directions specified
	private ArrayList neighbors = null;

	public Room(String name, String description) {
		this.name = name;
		this.description = description;
	}
	
	public String getName() {
		return name;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void addNeighbor(String direction, Room name) {
		neighbors.add(direction);
		neighbors.add(name);
	}

}
