package com.oyosite.ticon.rawlib.world.loader;

import java.util.HashMap;
import java.util.Map;

import com.oyosite.ticon.rawlib.material.Material;
import com.oyosite.ticon.rawlib.world.generator.OpenSimplexNoise;
import com.oyosite.ticon.rawlib.world.material.MaterialTypeStone;
import com.oyosite.ticon.rawlib.world.material.Mineral;

public class WorldStorage {
	public final long seed;
	public final OpenSimplexNoise noise;
	public WorldStorage(long seed) {
		this.seed = seed;
		this.noise = new OpenSimplexNoise(seed);
	}
	
	public static final Map<String, Object> worldMap = new HashMap<String, Object>();
	
	public void loadArea(long sx, long sy, long sz, long ex, long ey, long ez) {
		for (int i = 0; i<ex-sx; i++) {
			for (int j = 0; j<ez-sz; j++) {
				for (int k = 0; k<ey-sy; k++) {
					loadTile(sx+i, sy+k, sz+k);
				}
			}
		}
	}
	
	public void loadTile(long x, long y, long z) {
		double alt = noise.eval(x+0.54850927d, z+0.54850927d)*100.0d;
		//System.out.println(alt);
		Material mat = getTileMaterial(x, y, z);
		if (y<=alt) {worldMap.put(x+"_"+y+"_"+z+"_0", mat);}
	}
	
	public Object getTileObject(long x, long y, long z) {
		return worldMap.get(x+"_"+y+"_"+z+"_0");
	}
	
	
	public Material getTileMaterial(long x, long y, long z) {
		return new Material(new Mineral(""), new MaterialTypeStone());
	}
	
	public Object[] getAdjacentTiles(long x, long y, long z) {
		Object[] adjcentTiles = new Object[4];
		adjcentTiles[0] = worldMap.get((x+1)+"_"+y+"_"+z+"_0");
		adjcentTiles[1] = worldMap.get(x+"_"+y+"_"+(z-1)+"_0");
		adjcentTiles[2] = worldMap.get((x-1)+"_"+y+"_"+z+"_0");
		adjcentTiles[3] = worldMap.get(x+"_"+y+"_"+(z-1)+"_0");
		return adjcentTiles;
		
	}
	
}
