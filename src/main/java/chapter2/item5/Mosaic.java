package chapter2.item5;

import java.util.function.Supplier;

public class Mosaic {
	static Mosaic create(Supplier<? extends Tile> tileFactory) {
		return new Mosaic(tileFactory.get());
	}

	Mosaic(Tile tile) {
		this.tile = tile;
	}

	private Tile tile;

	public String asText() {
		return "this is " + tile.getColor() + " color mosaic";
	}

	public static void main(String[] args) {
		// Tile의 하위 클래스
		Supplier<RedTile> redTileFactory = () -> new RedTile("RED");
		Supplier<BlackTile> blueTileFactory = () -> new BlackTile("BLACK");

		Mosaic redMosaic = Mosaic.create(redTileFactory);
		Mosaic blueMosaic = Mosaic.create(blueTileFactory);

		System.out.println(redMosaic.asText());
		System.out.println(blueMosaic.asText());
	}
}