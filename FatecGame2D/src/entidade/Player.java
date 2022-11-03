package entidade;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import main.GamePainel;
import main.InputKeys;

public class Player extends Entidade
{
	
	GamePainel gp;
	InputKeys KeyH;
	public final int screenX;
	public final int screenY;
	
	
	public Player(GamePainel gp, InputKeys KeyH)
	{
		this.gp = gp;
		this.KeyH = KeyH;
		
		screenX = gp.screenLargura/2;
		screenY = gp.screenAltura/2;
		
		setDefaultValues();
		getPlayerImage();
			
	}
	
	
	public void setDefaultValues()
	{
		worldX = gp.tileSize * 19 - (gp.tileSize/2); // onde o personagem vai spawnar
		worldY = gp.tileSize * 31 - (gp.tileSize/2); // onde o persongem vai spawnar
		speed = 4;
		Direction = "parado";
	}
	
	
	public void getPlayerImage()// tiles das animações do personagem
	{
		try 
		{
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
			
		}
		
		catch(IOException e ) 
		{
			e.printStackTrace();
		}
	}
	
	
	
	public void Update()
	{
		
		if(KeyH.cima == true || KeyH.baixo == true || KeyH.esquerda == true || KeyH.direita == true)
		{
			
			// movimentação do personagem
			if(KeyH.cima == true)
			{
				Direction = "cima";
				worldY = worldY - speed;
			}
			
			else if(KeyH.baixo == true)
			{
				Direction = "baixo";
				worldY = worldY + speed;
			}
			
			else if(KeyH.esquerda == true)
			{
				Direction = "left";
				worldX = worldX - speed;
			}
			
			else if(KeyH.direita == true)
			{
				Direction = "right";
				worldX = worldX + speed;
			}	
			
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
	
	
	public void Draw(Graphics2D g2)
	{
		
	//	g2.setColor(Color.white);		
	//	g2.fillRect(x, y, gp.tileSize, gp.tileSize); // (x, y, largura, altura)
		
		BufferedImage Image = null;
		
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
