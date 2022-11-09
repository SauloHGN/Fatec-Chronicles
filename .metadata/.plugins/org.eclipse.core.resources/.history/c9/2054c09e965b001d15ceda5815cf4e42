package main;

import entidade.Enpc;
import objetos.Livro;
import objetos.Moeda;

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
		gp.npc[0].worldX = gp.tileSize*42;
		gp.npc[0].worldY = gp.tileSize*27;
	}	
	
	public void Itens()
	{
		int i = 0;
		
		gp.obj[i] = new Moeda(gp);
		gp.obj[i].worldX = gp.tileSize*4;
		gp.obj[i].worldY = gp.tileSize*27; 
		i++;
		
		gp.obj[i] = new Livro(gp);
		gp.obj[i].worldX = gp.tileSize*8;
		gp.obj[i].worldY = gp.tileSize*27;
		i++;
		
	}
	
	
}
