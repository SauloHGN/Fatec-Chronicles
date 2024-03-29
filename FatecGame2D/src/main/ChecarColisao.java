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
		//
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
	// colisão npc
	public int cEntidade(Entidade entidade, Entidade[] target)
	{
		int index = 999;
		
		for(int i = 0; i < target.length; i++)
		{
			if(target[i] != null)
			{
				// indica uma area solida
				entidade.solidArea.x = entidade.worldX + entidade.solidArea.x;
				entidade.solidArea.y = entidade.worldY + entidade.solidArea.y;
				
				// posição da area solida
				target[i].solidArea.x = target[i].worldX + target[i].solidArea.x;
				target[i].solidArea.y = target[i].worldY + target[i].solidArea.y;
				
				switch(entidade.Direction)
				{
				case "cima":
					entidade.solidArea.y = entidade.solidArea.y - entidade.speed;
					if(entidade.solidArea.intersects(target[i].solidArea))
					{								
						entidade.colisionOn = true;																								
						index = i;																						
					}
					break;
					
				case "baixo":
					entidade.solidArea.y = entidade.solidArea.y + entidade.speed;
					if(entidade.solidArea.intersects(target[i].solidArea))
							{																		
						entidade.colisionOn = true;																		
						index = i;																								
					}
					break;
						
						
				case "left":
					entidade.solidArea.x = entidade.solidArea.x - entidade.speed;
					if(entidade.solidArea.intersects(target[i].solidArea))
					{										
						entidade.colisionOn = true;									
						index = i;																												
					}
					break;
							
					case "right":
					entidade.solidArea.x = entidade.solidArea.x + entidade.speed;
					if(entidade.solidArea.intersects(target[i].solidArea))
					{											
						entidade.colisionOn = true;																					
						index = i;																					
					}	
					break;
				}
					
				entidade.solidArea.x = entidade.solidAreaDefaultX;
				entidade.solidArea.y = entidade.solidAreaDefaultY;
				target[i].solidArea.x = target[i].solidAreaDefaultX;
				target[i].solidArea.y = target[i].solidAreaDefaultY;	
			}	
		}
		return index;
	}
	
	// colisão jogador
	public void cPlayer(Entidade entidade)
	{
		// indica uma area solida
		entidade.solidArea.x = entidade.worldX + entidade.solidArea.x;
		entidade.solidArea.y = entidade.worldY + entidade.solidArea.y;
		
		// posição da area solida
		gp.player.solidArea.x = gp.player.worldX + gp.player.solidArea.x;
		gp.player.solidArea.y = gp.player.worldY + gp.player.solidArea.y;
		
		switch(entidade.Direction)
		{
		case "cima":
			entidade.solidArea.y = entidade.solidArea.y - entidade.speed;
			if(entidade.solidArea.intersects(gp.player.solidArea))
			{								
				entidade.colisionOn = true;																								
																										
			}
			break;
			
		case "baixo":
			entidade.solidArea.y = entidade.solidArea.y + entidade.speed;
			if(entidade.solidArea.intersects(gp.player.solidArea))
			{																		
				entidade.colisionOn = true;																																											
			}
			break;
					
			case "left":
				entidade.solidArea.x = entidade.solidArea.x - entidade.speed;
				if(entidade.solidArea.intersects(gp.player.solidArea))
				{										
					entidade.colisionOn = true;									
																																	
				}
				break;
					
				case "right":
				entidade.solidArea.x = entidade.solidArea.x + entidade.speed;
				if(entidade.solidArea.intersects(gp.player.solidArea))
				{											
					entidade.colisionOn = true;																					
																										
				}	
				break;
		}
			
		entidade.solidArea.x = entidade.solidAreaDefaultX;
		entidade.solidArea.y = entidade.solidAreaDefaultY;
		gp.player.solidArea.x = gp.player.solidAreaDefaultX;
		gp.player.solidArea.y = gp.player.solidAreaDefaultY;	
	}
	
	// colisao itens
	public int cItens(Entidade entidade, boolean player)
	{
		int index = 999;
			
		for(int i = 0; i < gp.obj.length; i++)
		{
			if(gp.obj[i] != null)
			{
				// indica uma area solida
				entidade.solidArea.x = entidade.worldX + entidade.solidArea.x;
				entidade.solidArea.y = entidade.worldY + entidade.solidArea.y;
				
				// posição da area solida
				gp.obj[i].solidArea.x = gp.obj[i].worldX + gp.obj[i].solidArea.x;
				gp.obj[i].solidArea.y = gp.obj[i].worldY + gp.obj[i].solidArea.y;
				
				
				switch(entidade.Direction)
				{
				case "cima":
					entidade.solidArea.y = entidade.solidArea.y - entidade.speed;
					if(entidade.solidArea.intersects(gp.obj[i].solidArea))
					{								
						if(gp.obj[i].colision==true)	
						{
							
						}
						if(player == true)
						{
							index = i;
						}
								
						break;
					}
					
					
				case "baixo":
					entidade.solidArea.y = entidade.solidArea.y + entidade.speed;
					if(entidade.solidArea.intersects(gp.obj[i].solidArea))
					{																		
						if(gp.obj[i].colision==true)	
						{
							
						}
						if(player == true)
						{
							index = i;
						}																	
						break;
					}
							
					case "left":
					entidade.solidArea.x = entidade.solidArea.x - entidade.speed;
					if(entidade.solidArea.intersects(gp.obj[i].solidArea))
					{										
						if(gp.obj[i].colision==true)	
						{
								
						}
						if(player == true)
						{
								index = i;
						}								
						break;
					}
											
					case "right":
					entidade.solidArea.x = entidade.solidArea.x + entidade.speed;
					if(entidade.solidArea.intersects(gp.obj[i].solidArea))
					{											
							if(gp.obj[i].colision==true)	
							{
									
							}
							if(player == true)
							{
								index = i;
							}									
							break;
						}	
							
						entidade.solidArea.x = entidade.solidAreaDefaultX;
						entidade.solidArea.y = entidade.solidAreaDefaultY;
						gp.obj[i].solidArea.x = gp.obj[i].solidAreaDefaultX;
						gp.obj[i].solidArea.y = gp.obj[i].solidAreaDefaultY;									
				}		
			}			
		}
		return index;	
	}	
}
