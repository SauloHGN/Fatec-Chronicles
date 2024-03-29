package entidade;

import java.awt.Graphics2D;

import java.awt.Rectangle;
import java.awt.image.BufferedImage;

import main.GamePainel;

public class Entidade 
{

GamePainel gp;

	public Entidade(GamePainel gp) 
	{
		this.gp = gp;
		
	}

// Caracteristicas do PLAYER	
public int worldX, worldY, speed;
// Estado de Imagens do player	
public BufferedImage parado, costas, left1, left2, left3, right1, right2, right3, baixo1, baixo2, cima1, cima2;
public String Direction;
//Tela Menu
public BufferedImage telainicio, botaojogar, botaoopc, botaosair, botaoCarregar, menufundo, ET, win, ponto, menuFundo2;
// inventario 
public BufferedImage inventario;
// itens
public BufferedImage iconeLivro, iconeLivro2, iconeLivro3, iconePotion;
// menu Pausado
public BufferedImage menu2, botaosalvar, botaoteclas, teclas;
// Senha
public BufferedImage senha;
// batalha
public BufferedImage batalhaFundo, botaoLv, botaoPontos, botaoBatalha, Arena,  cerebro, fundo, EnariBoss;
public BufferedImage areaAlerta, barraH, barraV, Bomb, laser, projetilS, raio1, raio2;
// projetil
public BufferedImage projetil;
// Animação
public int spriteCont = 0;
public int spriteNum = 1;
// colisão 
public Rectangle solidArea = new Rectangle(0, 0, 48, 48);
public int solidAreaDefaultX, solidAreaDefaultY;
public boolean colisionOn = false;
// 
public int actionCont = 0;
// dialogos
public String dialogos[][] = new String[20][20];
public int dialogoCont = 0;
public int setDialogo = 0;
// atributos do personagem
public int vidaM;
public int vida;
public int level;
public int posX;
public int posY;
public int moeda;
public int pontos;
// Itens
public Entidade Livro;
public Entidade LivroM;
public Entidade LivroI;
public Entidade Moeda;
//
public String name = null;

public void setAction()
{
		
}

public void olhar()
{
	switch(gp.player.Direction)
	{
	case "cima":
		Direction = "baixo";
		break;
		
	case "baixo":
		Direction = "cima";
		break;	
		
	case "left":
		Direction = "right";
		break;
		
	case "right":
		Direction = "left";
		break;
	}
}

public void fala()
{		
	
}

public void IniciarDialogo(Entidade entidade, int numD)
{
	gp.gameState = gp.dialogoState;
	gp.ui.npc = entidade;
	setDialogo = numD;
}

public void update()
{
	// ação e colisão do npc
	setAction();
	colisionOn = false;
	gp.cColisao.checarTile(this);
	gp.cColisao.cPlayer(this);
		
	if(colisionOn == false)
	{
		switch(Direction)
		{
		case "cima":
		worldY = worldY - speed;
			break;
			
		case "baixo":
		worldY = worldY + speed;
			break;
				
		case "left":
			worldX = worldX - speed;
				break;	
				
		case "right":
			worldX = worldX + speed;
			break;						
		}
	}	
	// looping para animação das pixels arts
	spriteCont++;
	if(spriteCont > 18 )//velocidade
	{
		if(spriteNum == 1)
		{
			spriteNum = 2;
		}
		else if(spriteNum == 2)
		{
			spriteNum = 1;
		}
		spriteCont = 0;
	}
	
}

	public void draw(Graphics2D g2)
	{
		BufferedImage Image = null;
		
		int screenX = worldX - gp.player.worldX + gp.player.screenX;
		int screenY = worldY - gp.player.worldY + gp.player.screenY;
		
		if(worldX + gp.tileSize > gp.player.worldX - gp.player.screenX && 
		   worldX - gp.tileSize < gp.player.worldX + gp.player.screenX &&
		   worldY + gp.tileSize > gp.player.worldY - gp.player.screenY &&
		   worldY - gp.tileSize < gp.player.worldY + gp.player.screenY)
		{
					
			switch (Direction)
			{
			
				case "parado":
				Image = parado;
				break;
			
				case "cima":
				if(spriteNum == 1)
				{
					Image = cima1;
				}
				if(spriteNum == 2)
				{
					Image = cima2;
				}
				break;
				
				case "baixo":
				if(spriteNum == 1)
				{
					Image = baixo1;
				}
				if(spriteNum == 2)
				{
					Image = baixo2;
				}
				break;
				
				case "left":
				if(spriteNum == 1)
				{
					Image = left1;
				}
				if(spriteNum == 2)
				{
					Image = left2;
				}
				
				break;
				
				case "right":
				if(spriteNum == 1)
				{
					Image = right1;
				}
				if(spriteNum == 2)
				{
					Image = right2;
				}
				break;		
			}
			
			g2.drawImage(Image, screenX, screenY, gp.tileSize, gp.tileSize, null);				
		}		
	}
}
