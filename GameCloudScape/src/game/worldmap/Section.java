package game.worldmap;

import game.worldmap.generator.Biome;

public interface Section extends Drawable
{
	public Biome getBiome();
	public Block getBlock(int x, int y, int z);
}
