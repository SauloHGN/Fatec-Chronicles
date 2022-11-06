package main;

import java.awt.Rectangle;

public class Acao 
{
	GamePainel gp;
	Rectangle checarAcao;
	int defaultAcaoX, defaultAcaoY;
	
	public Acao(GamePainel gp)
	{
		this.gp = gp;
		
		checarAcao = new Rectangle();
		checarAcao.x = 23;
		checarAcao.y = 23;
		checarAcao.width = 2;
		checarAcao.height = 2;
		
		defaultAcaoX = checarAcao.x;
		defaultAcaoY = checarAcao.y;
	}
	
	
	public void verificarAcao()
	{
		if(trigger(38,19,"baixo") == true || trigger(39,19,"baixo") == true || trigger(40,19,"baixo") == true || trigger(41,19,"baixo") == true)
		{
			aviso(gp.dialogoState);
		}
		
		if(trigger(25,13,"cima") == true && gp.player.level >= 2)
		{
			teleporte(gp.dialogoState);
		}
		
		if(trigger(95,21,"baixo") == true)
		{
			teleporteVolta(gp.dialogoState);
		}
		
	}
	
	public boolean trigger(int AcaoColuna, int AcaoLinha, String DirectionAcao)
	{
		boolean trigger = false;
		
		gp.player.solidArea.x = gp.player.worldX + gp.player.solidArea.x;
		gp.player.solidArea.y = gp.player.worldY + gp.player.solidArea.y;
		
		checarAcao.x  = AcaoColuna*gp.tileSize + checarAcao.x;
		checarAcao.y  = AcaoLinha*gp.tileSize + checarAcao.y;
		
		
		if(gp.player.solidArea.intersects(checarAcao))
		{
			if(gp.player.Direction.contentEquals(DirectionAcao) || DirectionAcao.contentEquals("any"))
			{
				trigger = true;
			}
		}
		
		gp.player.solidArea.x = gp.player.solidAreaDefaultX;
		gp.player.solidArea.y = gp.player.solidAreaDefaultY;
		
		checarAcao.x = defaultAcaoX;
		checarAcao.y = defaultAcaoY;
		
		return trigger;
	}
	
	public void aviso(int gameState)
	{
		gp.gameState = gameState;
		gp.ui.conversa = "Você não tem nível suficiente \n para avançar";
		
		
	}
	
	public void teleporte(int gameState)
	{
		gp.gameState = gameState;
		gp.ui.conversa = "Teleporte";
		gp.player.worldX = gp.tileSize*95;
		gp.player.worldY = gp.tileSize*21;
	}
	
	public void teleporteVolta(int gameState)
	{
		gp.gameState = gameState;
		gp.ui.conversa = "Teleporte";
		gp.player.worldX = gp.tileSize*25;
		gp.player.worldY = gp.tileSize*13;
	}
	
}
