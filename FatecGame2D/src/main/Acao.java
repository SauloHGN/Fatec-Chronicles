package main;

import java.awt.Rectangle;
import entidade.Entidade;

public class Acao
{
	GamePainel gp;
	Rectangle checarAcao;
	int defaultAcaoX, defaultAcaoY;
	Entidade acaoMap;
	public int v[] = new int[3];
	public boolean Pvez = true;
	
	public Acao(GamePainel gp)
	{
		this.gp = gp;
		checarAcao = new Rectangle();
		checarAcao.x = 23;
		checarAcao.y = 23;
		checarAcao.width = 8;
		checarAcao.height = 2;
		acaoMap = new Entidade(gp);
		defaultAcaoX = checarAcao.x;
		defaultAcaoY = checarAcao.y;
	}
	
	public void verificarAcao()
	{
		//Escada
		if(trigger(30,33,"baixo") == true || trigger(31,33,"baixo") == true || trigger(32,33,"baixo") == true || trigger(33,33,"baixo") == true)
		{
			aviso(gp.dialogoState);
		}
		//Senha + entrar na sala
		if(trigger(63,27,"cima") == true)
		{
			gp.gameState = gp.senhaState;
			
			if(gp.KeyH.password == true)
			{
				teleporte(gp.dialogoState);
			}	
		}
		// Sair da sala
		if(trigger(84,47,"baixo") == true)
		{
			voltaSalaBoss(gp.dialogoState);
		}
		// porta de vidro 
		if(trigger(17,17,"cima") == true || trigger(16,17,"cima") == true || trigger(7,17,"cima") == true || trigger(6,17,"cima") == true)
		{
			teleporteLopping();
		}
		// entar na sala do boss
		if(trigger(102,5,"cima") == true || trigger(101,5,"cima") == true)
		{
			teleporteBoss(gp.dialogoState);
		}
		if(trigger(149,77,"baixo") == true || trigger(150,77,"baixo") == true)
		{
			teleporteVolta(gp.dialogoState);
		}
		
		// mensagem na entrada
		if(gp.player.level == 0)
		{
			if(trigger(19,46,"cima") == true || trigger(18,46,"cima") == true || trigger(17,46,"cima") == true) 
			{
				gp.player.level = 1;
				dialogoInicial(gp.dialogoState);
			}
		}
		// Enari
		if(Pvez == true)
		{
			if(trigger(84,12,"cima") == true || trigger(83,11,"right") == true || trigger(84,10,"baixo") == true || trigger(85,11,"left") == true)
			{
				conversaEnari(gp.dialogoState);
				Pvez = false;
			}
	    }
		setDialogo();
	}
	
	public void setDialogo()
	{
		acaoMap.dialogos[0][0] = "Você não tem nível suficiente \n para avançar";
		
		acaoMap.dialogos[1][0] = "Você perdeu 1 ponto de vida";
		acaoMap.dialogos[1][1] = "Enari: Muhahaha, falta pouco \npara você ser REPROVADO! \nVamos ver quantas vezes você \npode me enfrentar!";
		
		acaoMap.dialogos[2][0] = "Você perdeu 1 ponto de vida";
		
		acaoMap.dialogos[3][0] = "Entrou no labirinto";
		
		acaoMap.dialogos[4][0] = "Saiu do labirinto";
		
		acaoMap.dialogos[5][0] = "Entrou na sala";
		
		acaoMap.dialogos[6][0] = "Saiu da sala";
		
		acaoMap.dialogos[7][0] = "Você perdeu 1 ponto de vida\n e subiu +1 nível";
         
        acaoMap.dialogos[8][0] = "Você subiu +1 nível";
        	
		acaoMap.dialogos[9][0] = "Enari: Mas que M@#$%!! \nVocê decifrou todos os meus \nenígmas. ";
		acaoMap.dialogos[9][1] = "Enari: Agora chegou a hora de \nenfrentar meu teste que vale \n200 pontos.";
		acaoMap.dialogos[9][2] = "Enari: Ninguém passa por este \nteste sem danos! Muhaha!";
		
		acaoMap.dialogos[10][0] = "Seja Bem-vindo! \nHoje começa mais um ano letivo \nna Fatec de Cruzeiro."; 
		acaoMap.dialogos[10][1] = "Use as teclas W, A, S, D \npara explorar todos os cantos \nda faculdade.";
		acaoMap.dialogos[10][2] = "A qualquer momento, precione \n\"esc\" para abrir o painel de \nopções.";				
		acaoMap.dialogos[10][3] = "Você também pode verificar os \nitens coletados e nível atual do \npersonagem no seu inventário, \nprecionando a tecla \"i\"";
		acaoMap.dialogos[10][4] = "Para interagir com os \npersongens, aperte a tecla \n\"enter\"";
		acaoMap.dialogos[10][5] = "Descubra os mistérios que aqui \nse encontram!\nBOA SORTE";
		
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
		acaoMap.IniciarDialogo(acaoMap, 0);
	}
	
	public void aviso2(int gameState)
	{
		gp.gameState = gameState;
		gp.ui.conversa = "Seja Bem-vindo à Fatec Cruzeiro!\n Temos os melhores cursos de \n graduação da região...";
		acaoMap.IniciarDialogo(acaoMap, 1);
	}
	
	public void perdeuVida(int gameState)
	{
		gp.gameState = gameState;
		gp.ui.conversa = "Você perdeu 1 ponto de vida";
		acaoMap.IniciarDialogo(acaoMap, 2);
	}
	
	public void teleporte(int gameState)
	{
		gp.gameState = gameState;
		gp.ui.conversa = "Entrou no labirinto";
		gp.player.worldX = gp.tileSize*150; //84
		gp.player.worldY = gp.tileSize*76; //47
		acaoMap.IniciarDialogo(acaoMap, 3);
	}
	
	public void teleporteVolta(int gameState)
	{
		gp.gameState = gameState;
		gp.ui.conversa = "Saiu do labirinto";
		gp.player.worldX = gp.tileSize*63;//63
		gp.player.worldY = gp.tileSize*27;//27
		acaoMap.IniciarDialogo(acaoMap, 4);
	}
	
	public void teleporteBoss(int gameState)
	{
		gp.gameState = gameState;
		gp.ui.conversa = "Entrou na sala";
		gp.player.worldX = gp.tileSize*84; //84
		gp.player.worldY = gp.tileSize*47; //47
		acaoMap.IniciarDialogo(acaoMap, 5);
	}
	
	public void voltaSalaBoss(int gameState)
	{
		gp.gameState = gameState;
		gp.ui.conversa = "Saiu da sala";
		gp.player.worldX = gp.tileSize*102; //84
		gp.player.worldY = gp.tileSize*5; //47
		acaoMap.IniciarDialogo(acaoMap, 6);
	}
	
    public void subiuNivel(int gameState)
	{
		gp.gameState = gameState;
		gp.ui.conversa = "Você perdeu 1 ponto de vida\n e subiu +1 nivel";
		acaoMap.IniciarDialogo(acaoMap, 7);
	}
       
    public void subiuNivel2(int gameState)
	{
		gp.gameState = gameState;
		gp.ui.conversa = "Você subiu +1 nivel";
		acaoMap.IniciarDialogo(acaoMap, 8);
	}
    
    public void conversaEnari(int gameState)
    {
    	gp.gameState = gameState;
    	gp.ui.conversa = "";
		acaoMap.IniciarDialogo(acaoMap, 9);
    }
    
    public void dialogoInicial(int gameState)
    {
    	gp.gameState = gameState;
    	gp.ui.conversa = "";
		acaoMap.IniciarDialogo(acaoMap, 10);
    }
    
    public void EnariWin(int gameState)
    {
    	gp.gameState = gameState;
    	gp.ui.conversa = "";
		acaoMap.IniciarDialogo(acaoMap, 1);
    }
	
	public void teleporteLopping()
	{
		gp.player.worldX = gp.tileSize*18;//18
		gp.player.worldY = gp.tileSize*47;//47
	}
}
