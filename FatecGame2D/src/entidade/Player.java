package entidade;

import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;

import main.GamePainel;
import main.InputKeys;


public class Player extends Entidade
{
	
	GamePainel gp;
	InputKeys KeyH;
	public final int screenX;
	public final int screenY;
	public ArrayList<Entidade> inventarioL = new ArrayList<>();
	public final int inventarioT = 6;
	
	public Player(GamePainel gp, InputKeys KeyH)
	{
		super(gp);
		
		this.gp = gp;
		this.KeyH = KeyH;
		
		screenX = gp.screenLargura/2;
		screenY = gp.screenAltura/2;
			
		// colisão
		solidArea = new Rectangle();
		solidArea.x = 8;
		solidArea.y = 16;
		solidArea.width = 32;
		solidArea.height = 30;
		solidAreaDefaultX = solidArea.x;
		solidAreaDefaultY = solidArea.y;
		
		setDefaultValues();
		getPlayerImage();
		itensInventario();
		drawTeste();
	}
	
	public void setDefaultValues()
	{
		// player pos
		int posX = 18; // coluna 18
		int posY = 47; // linha 47
		
		speed = 5;
		Direction = "parado";
		vidaM = 5;
		vida = 5;
		level = 0;
		moeda = 0;
		//
		pontos = 100;
		//				
		worldX = (gp.tileSize * posX) - (gp.tileSize/2)+20; // onde o personagem vai spawnar
		worldY = (gp.tileSize * posY) - (gp.tileSize/2); // onde o persongem vai spawnar
	}
	
	public void itensInventario()
	{
		//inventarioL.add(new objetos.Livro(gp));				
	}	
		
	public void getPlayerImage()// tiles das animações do personagem
	{
		try 
		{
			// Sprites do persomagem principal
			baixo1 = ImageIO.read(getClass().getResourceAsStream("/player/personagem baixo1.png"));
			baixo2 = ImageIO.read(getClass().getResourceAsStream("/player/personagem baixo2.png"));
			cima1 = ImageIO.read(getClass().getResourceAsStream("/player/personagem cima1.png"));
			cima2 = ImageIO.read(getClass().getResourceAsStream("/player/personagem cima2.png"));
			costas = ImageIO.read(getClass().getResourceAsStream("/player/personagem costas.png"));
			left1 = ImageIO.read(getClass().getResourceAsStream("/player/personagem left1.png"));
			left2 = ImageIO.read(getClass().getResourceAsStream("/player/personagem left2.png"));
			left3 = ImageIO.read(getClass().getResourceAsStream("/player/personagem left3.png"));
			right1 = ImageIO.read(getClass().getResourceAsStream("/player/personagem right1.png"));
			right2 = ImageIO.read(getClass().getResourceAsStream("/player/personagem right2.png"));
			right3 = ImageIO.read(getClass().getResourceAsStream("/player/personagem right3.png"));
			parado = ImageIO.read(getClass().getResourceAsStream("/player/personagem parado.png"));
			//menu
			botaojogar = ImageIO.read(getClass().getResourceAsStream("/menu/botaojogar.png"));
			botaoopc = ImageIO.read(getClass().getResourceAsStream("/menu/botaoopc.png"));
			botaosair = ImageIO.read(getClass().getResourceAsStream("/menu/botaosair.png"));
			botaoCarregar = ImageIO.read(getClass().getResourceAsStream("/menu/botaoCarregar.png"));
			menufundo = ImageIO.read(getClass().getResourceAsStream("/menu/menufundo.png"));
			menuFundo2 = ImageIO.read(getClass().getResourceAsStream("/menu/MenuFundoP.png"));
			ponto = ImageIO.read(getClass().getResourceAsStream("/menu/ponto.png"));
			//inventario
			inventario = ImageIO.read(getClass().getResourceAsStream("/menu/Inventarioteste.png"));
			//itens
			iconeLivro = ImageIO.read(getClass().getResourceAsStream("/itens/livro.png"));
			iconeLivro2 = ImageIO.read(getClass().getResourceAsStream("/itens/livro2.png"));
			iconeLivro3 = ImageIO.read(getClass().getResourceAsStream("/itens/livro3.png"));
			iconePotion = ImageIO.read(getClass().getResourceAsStream("/itens/Potion.png"));
			//menu Pausado
			menu2 = ImageIO.read(getClass().getResourceAsStream("/menu/menu2.png"));
			botaosalvar = ImageIO.read(getClass().getResourceAsStream("/menu/botaosalvar.png"));
			botaoteclas = ImageIO.read(getClass().getResourceAsStream("/menu/botaoIns.png"));
			//teclas 
			teclas = ImageIO.read(getClass().getResourceAsStream("/menu/TeclaTeste2.png"));
			// senha		
			senha = ImageIO.read(getClass().getResourceAsStream("/menu/senha.png"));
			//batalha		
			batalhaFundo = ImageIO.read(getClass().getResourceAsStream("/Batalha/batalhaFundo.png"));
			raio1 = ImageIO.read(getClass().getResourceAsStream("/Batalha/raio1.png"));
			raio2 = ImageIO.read(getClass().getResourceAsStream("/Batalha/raio2.png"));
			botaoLv = ImageIO.read(getClass().getResourceAsStream("/Batalha/botaoLv.png"));
			botaoBatalha = ImageIO.read(getClass().getResourceAsStream("/Batalha/botaoBatalha.png"));
			botaoPontos = ImageIO.read(getClass().getResourceAsStream("/Batalha/botaoPontos.png"));
			Arena = ImageIO.read(getClass().getResourceAsStream("/Batalha/Arena.png"));
			EnariBoss = ImageIO.read(getClass().getResourceAsStream("/Batalha/EnariNpcBattle.png"));
			//GameOver
			ET = ImageIO.read(getClass().getResourceAsStream("/menu/ET.png"));
			// Win
			win = ImageIO.read(getClass().getResourceAsStream("/menu/win.png"));	
		}	
		catch(IOException e ) 
		{
			e.printStackTrace();
		}
	}
	
	public void drawTeste()
	{
		try
		{
			raio1 = ImageIO.read(getClass().getResourceAsStream("/Batalha/raio1.png"));
			raio2 = ImageIO.read(getClass().getResourceAsStream("/Batalha/raio2.png"));
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	
	
	public void Update()
	{	
		if(KeyH.cima == true || KeyH.baixo == true || KeyH.esquerda == true || KeyH.direita == true || KeyH.pressEnter == true)
		{
			
			// movimentação do personagem
			if(KeyH.cima == true)
			{
				Direction = "cima";	
			}
			
			else if(KeyH.baixo == true)
			{
				Direction = "baixo";			
			}
			
			else if(KeyH.esquerda == true)
			{
				Direction = "left";	
			}
			
			else if(KeyH.direita == true)
			{
				Direction = "right";		
			}	
			
			// Checar a colisão mapa
			colisionOn = false;
			gp.cColisao.checarTile(this);
			
			// colisao com npc
			int npcIndex = gp.cColisao.cEntidade(this, gp.npc);
			interacaoNpc(npcIndex);
			
			// colisao com itens
			 int itensIndex = gp.cColisao.cItens(this, true);
			 pegarItem(itensIndex);
			
			// se não colidir o personagem pode andar
			if(colisionOn == false && KeyH.pressEnter == false)
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
			
			gp.KeyH.pressEnter = false;
				
			// Ação/Eventos de Teleporte e dialogo
			gp.acao.verificarAcao();
		
			// looping para animação das pixels arts
			spriteCont++;
			if(spriteCont > 15 )//velocidade
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
	}
	
	public void interacaoNpc(int i)
	{
		if(i != 999)
		{
			if(gp.KeyH.pressEnter == true)// parar npc no dialogo
			{
				//gp.gameState = gp.dialogoState;
				gp.npc[i].fala();
			}			
		}		
	}
	
	public void pegarItem(int i)
	{
		if(i != 999)
		{
			
			if(inventarioL.size() != inventarioT)
			{
				if(i  <= 2)
				{
					gp.player.moeda++;
					gp.obj[i] = null;
				}
				if(i == 3)
				{
					gp.obj[i] = null;
					if(gp.player.vida < 5)
					{
						gp.player.vida++;
						gp.gameState = gp.dialogoState;
						dialogos[0][0] = "Você recebeu +1 ponto de vida";
						IniciarDialogo(this,0);
					}
					
				}
				if(i == 4)
				{
					gp.gameState = gp.respostaState;
					gp.ui.conversa = "Norio: Enquanto eu bebo meu \nsaquêzinho, me diga:\nQual a fórmula de juros\n compostos?\n\n"
							+ "M = C (1+i)^t\n\n"
							+ "J = C * i * t\n\n"
							+ "J = C!";
					
					inventarioL.add(gp.obj[i]);
					gp.obj[i] = null;
					gp.player.level++;
				}
				if(i == 5)
				{
					gp.gameState = gp.respostaState2;
					gp.ui.conversa = "Marcílio: Achou que seria fácil? \nVeremos:\nQual é a fórmula do Xvértice?\n\n\n"
							+ "a^2 = b^2 + c^2\n\n "
							+ "-b/2*a\n\n"
							+ "P * Δ * T ";
					
					inventarioL.add(gp.obj[i]);
					gp.obj[i] = null;
					gp.player.level++;
				}
				if(i == 6)
				{
					gp.gameState = gp.respostaState;
					gp.ui.conversa = "Maria Claudia: OMG! you have \nfound my book!\nI'm stressed, what should I do?\n\n\n"
							+ "Breath in and breath out\n\n "
							+ "Study as much you can\n\n"
							+ "Go home";
					
					inventarioL.add(gp.obj[i]);
					gp.obj[i] = null;
					gp.player.level++;
				}
				if(i > 6)
				{
					inventarioL.add(gp.obj[i]);
					gp.obj[i] = null;					
				}			
			}
			else
			{
				gp.gameState = gp.dialogoState;
				dialogos[0][0]= "Sua mochila está cheia";	
				IniciarDialogo(this,0);
			}				
		}
	}
	
	public void Draw(Graphics2D g2)
	{	
		BufferedImage Image = null;
		
		switch(Direction)
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
