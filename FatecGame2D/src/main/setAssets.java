package main;

import entidade.Enpc;

public class setAssets 
{

	GamePainel gp;
	
	public setAssets(GamePainel gp)
	{
		this.gp = gp;
	}
	
	
	
	public void setNpc()
	{
		gp.npc[0] = new Enpc(gp);
		gp.npc[0].worldX = gp.tileSize*21;
		gp.npc[0].worldY = gp.tileSize*21;
	}
	
	
}
