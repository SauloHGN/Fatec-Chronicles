package main;

import entidade.ChNPC;
import entidade.EnariNPC;
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
		gp.npc[i].worldX = gp.tileSize*2;
		gp.npc[i].worldY = gp.tileSize*18;
		i++;
		
		gp.npc[i] = new LigiaNPC(gp);
		gp.npc[i].worldX = gp.tileSize*19;
		gp.npc[i].worldY = gp.tileSize*43;
		i++;
		
		gp.npc[i] = new EuNPC(gp);
		gp.npc[i].worldX = gp.tileSize*68;
		gp.npc[i].worldY = gp.tileSize*42;
		i++;
		
		gp.npc[i] = new ChNPC(gp);
		gp.npc[i].worldX = gp.tileSize*44;
		gp.npc[i].worldY = gp.tileSize*18;
		i++;
		
		gp.npc[i] = new FeichasNPC(gp);
		gp.npc[i].worldX = gp.tileSize*57;
		gp.npc[i].worldY = gp.tileSize*9;
		i++;
		
		gp.npc[i] = new EnariNPC(gp);
		gp.npc[i].worldX = gp.tileSize*84;
		gp.npc[i].worldY = gp.tileSize*11;
	}	
	
	public void Itens()
	{
		int i = 0;
		
		gp.obj[i] = new Moeda(gp);
		gp.obj[i].worldX = gp.tileSize*84;
		gp.obj[i].worldY = gp.tileSize*40; 
		i++;
		
		gp.obj[i] = new Moeda(gp);
		gp.obj[i].worldX = gp.tileSize*84;
		gp.obj[i].worldY = gp.tileSize*33; 
		i++;
		
		gp.obj[i] = new Moeda(gp);
		gp.obj[i].worldX = gp.tileSize*84;
		gp.obj[i].worldY = gp.tileSize*28; 
		i++;
		
		gp.obj[i] = new Potion(gp);
		gp.obj[i].worldX = gp.tileSize*84;
		gp.obj[i].worldY = gp.tileSize*22;
		i++;
		
		gp.obj[i] = new Livro(gp);
		gp.obj[i].worldX = gp.tileSize*70;
		gp.obj[i].worldY = gp.tileSize*38;
		i++;
		
		gp.obj[i] = new LivroM(gp);
		gp.obj[i].worldX = gp.tileSize*70;
		gp.obj[i].worldY = gp.tileSize*28;
		i++;
		
		gp.obj[i] = new LivroI(gp);
		gp.obj[i].worldX = gp.tileSize*24;
		gp.obj[i].worldY = gp.tileSize*17;
		i++;						
	}		
}
