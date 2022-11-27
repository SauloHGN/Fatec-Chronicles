package main;

import entidade.ChNPC;
import entidade.Enpc;
import entidade.LigiaNPC;
import entidade.EuNPC;
import entidade.FeichasNPC;
import objetos.Livro;
import objetos.LivroI;
import objetos.LivroM;
import objetos.Moeda;
import objetos.Potion;

public class setAssets 
{

	GamePainel gp;
	
	public setAssets(GamePainel gp)
	{
		
		this.gp = gp;
		
		
	}
	
	
	
	public void setNpc()
	{
		int i = 0;
		
		gp.npc[i] = new Enpc(gp);
		gp.npc[i].worldX = gp.tileSize*3;
		gp.npc[i].worldY = gp.tileSize*5;
		i++;
		
		gp.npc[i] = new LigiaNPC(gp);
		gp.npc[i].worldX = gp.tileSize*19;
		gp.npc[i].worldY = gp.tileSize*30;
		i++;
		
		gp.npc[i] = new EuNPC(gp);
		gp.npc[i].worldX = gp.tileSize*73;
		gp.npc[i].worldY = gp.tileSize*23;
		i++;
		
		gp.npc[i] = new ChNPC(gp);
		gp.npc[i].worldX = gp.tileSize*17;
		gp.npc[i].worldY = gp.tileSize*30;
		i++;
		
		gp.npc[i] = new FeichasNPC(gp);
		gp.npc[i].worldX = gp.tileSize*15;
		gp.npc[i].worldY = gp.tileSize*30;
		
	}	
	
	public void Itens()
	{
		int i = 0;
		
		gp.obj[i] = new Moeda(gp);
		gp.obj[i].worldX = gp.tileSize*96;
		gp.obj[i].worldY = gp.tileSize*18; 
		i++;
		
		gp.obj[i] = new Moeda(gp);
		gp.obj[i].worldX = gp.tileSize*96;
		gp.obj[i].worldY = gp.tileSize*16; 
		i++;
		
		gp.obj[i] = new Moeda(gp);
		gp.obj[i].worldX = gp.tileSize*96;
		gp.obj[i].worldY = gp.tileSize*14; 
		i++;
		
		gp.obj[i] = new Potion(gp);
		gp.obj[i].worldX = gp.tileSize*96;
		gp.obj[i].worldY = gp.tileSize*19;
		i++;
		
		gp.obj[i] = new Livro(gp);
		gp.obj[i].worldX = gp.tileSize*8;
		gp.obj[i].worldY = gp.tileSize*27;
		i++;
		
		gp.obj[i] = new LivroM(gp);
		gp.obj[i].worldX = gp.tileSize*8;
		gp.obj[i].worldY = gp.tileSize*29;
		i++;
		
		gp.obj[i] = new LivroI(gp);
		gp.obj[i].worldX = gp.tileSize*6;
		gp.obj[i].worldY = gp.tileSize*29;
		i++;
		
		
		
	}
	
	
}
