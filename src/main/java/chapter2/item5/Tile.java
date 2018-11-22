package chapter2.item5;

public class Tile {
	private String color;

	Tile(String color) {
		this.color = color;
	}

	public String getColor() {
		return color;
	}
}

class RedTile extends Tile {
	RedTile(String color) {
		super(color);
	}
}

class BlackTile extends Tile {
	BlackTile(String color) {
		super(color);
	}
}