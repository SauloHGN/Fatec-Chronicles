package main;

import entidade.Entidade;

public class ChecarColisao 
{
	
	GamePainel gp;
	
	public ChecarColisao(GamePainel gp) 
	{
		this.gp = gp;
		
	}

	public void checarTile(Entidade entidade) 
	{
		// indica a coordenada de colisao do personagem
		
		int entidadeLeftWorldX = entidade.worldX + entidade.solidArea.x;
		int entidadeRightWorldX = entidade.worldX + entidade.solidArea.x + entidade.solidArea.width;
		int entidadeTopWorldY = entidade.worldY + entidade.solidArea.y;
		int entidadeDownWorldY = entidade.worldY + entidade.solidArea.y + + entidade.solidArea.height;
		
		
		int entidadeLeftCol = entidadeLeftWorldX/gp.tileSize;
		int entidadeRightCol = entidadeRightWorldX/gp.tileSize;
		int entidadeTopLin = entidadeTopWorldY/gp.tileSize;
		int entidadeDownLin = entidadeDownWorldY/gp.tileSize;
		
		
		int tileN1, tileN2;
		
		switch(entidade.Direction)
		{
		
		case "cima":
			entidadeTopLin = (entidadeTopWorldY - entidade.speed)/gp.tileSize;
			tileN1 = gp.tileM.mapaTileNum[entidadeLeftCol][entidadeTopLin];
			tileN2 = gp.tileM.mapaTileNum[entidadeRightCol][entidadeTopLin];
			
			if(gp.tileM.tile[tileN1].colision == true  || gp.tileM.tile[tileN2].colision == true)
			{
				entidade.colisionOn =  true;
			}
			
			break;
			
		case "baixo":
			entidadeDownLin = (entidadeDownWorldY + entidade.speed)/gp.tileSize;
			tileN1 = gp.tileM.mapaTileNum[entidadeLeftCol][entidadeDownLin];
			tileN2 = gp.tileM.mapaTileNum[entidadeRightCol][entidadeDownLin];
			
			if(gp.tileM.tile[tileN1].colision == true  || gp.tileM.tile[tileN2].colision == true)
			{
				entidade.colisionOn =  true;
			}
			break;
			
		case "left":
			entidadeLeftCol = (entidadeLeftWorldX - entidade.speed)/gp.tileSize;
			tileN1 = gp.tileM.mapaTileNum[entidadeLeftCol][entidadeTopLin];
			tileN2 = gp.tileM.mapaTileNum[entidadeLeftCol][entidadeDownLin];
			
			if(gp.tileM.tile[tileN1].colision == true  || gp.tileM.tile[tileN2].colision == true)
			{
				entidade.colisionOn =  true;
			}
			break;
			
		case "right":
			entidadeRightCol = (entidadeRightWorldX + entidade.speed)/gp.tileSize;
			tileN1 = gp.tileM.mapaTileNum[entidadeRightCol][entidadeTopLin];
			tileN2 = gp.tileM.mapaTileNum[entidadeRightCol][entidadeDownLin];
			
			if(gp.tileM.tile[tileN1].colision == true  || gp.tileM.tile[tileN2].colision == true)
			{
				entidade.colisionOn =  true;
			}
			break;
			
		
		
		
		
		}
		
	}
	
}