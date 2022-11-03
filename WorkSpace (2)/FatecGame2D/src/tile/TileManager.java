package tile;

import java.awt.Graphics2D;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import javax.imageio.ImageIO;

import main.GamePainel;

public class TileManager 
{

	GamePainel gp;	
	public Tile [] tile;
	public int mapaTileNum[][];
	
	
	public TileManager(GamePainel gp)
	{
		this.gp = gp;
		
		tile = new Tile[100];
		
		mapaTileNum = new int [gp.maxWorldColuna][gp.maxWorldLinha];
		
		getTileImage();
		
		LoadMapa("/mapas/mapa1.txt");
	}
	
	
	public void getTileImage()
	{
		// pixel arts do mapa
		try 
		{
			
			tile [10] = new Tile();
			tile[10].Image = ImageIO.read(getClass().getResourceAsStream("/ambiente/chaoteste2.png"));						
			
			tile [11] = new Tile();
			tile[11].Image = ImageIO.read(getClass().getResourceAsStream("/ambiente/cadeira.png"));	
			tile[11].colision = true;
			
			tile [12] = new Tile();
			tile[12].Image = ImageIO.read(getClass().getResourceAsStream("/ambiente/parede.png"));
			
			tile [13] = new Tile();
			tile[13].Image = ImageIO.read(getClass().getResourceAsStream("/ambiente/paredebaixo.png"));
			tile[13].colision = true;
			
			tile [14] = new Tile();
			tile[14].Image = ImageIO.read(getClass().getResourceAsStream("/ambiente/paredecima.png"));
			tile[14].colision = true;
			
			tile [15] = new Tile();
			tile[15].Image = ImageIO.read(getClass().getResourceAsStream("/ambiente/portaVbaixo.png"));
			tile[15].colision = true;
			
			tile [16] = new Tile();
			tile[16].Image = ImageIO.read(getClass().getResourceAsStream("/ambiente/portaVcima.png"));
			tile[16].colision = true;
			
			tile [17] = new Tile();
			tile[17].Image = ImageIO.read(getClass().getResourceAsStream("/ambiente/ParedeC.png"));
			tile[17].colision = true;
			
			tile [18] = new Tile();
			tile[18].Image = ImageIO.read(getClass().getResourceAsStream("/ambiente/paredeX.png"));
			tile[18].colision = true;
			
			tile [19] = new Tile();
			tile[19].Image = ImageIO.read(getClass().getResourceAsStream("/ambiente/paredechao.png"));
			tile[19].colision = true;
			
			tile [20] = new Tile();
			tile[20].Image = ImageIO.read(getClass().getResourceAsStream("/ambiente/paredeZ.png"));
			tile[20].colision = true;
			
			tile [21] = new Tile();
			tile[21].Image = ImageIO.read(getClass().getResourceAsStream("/ambiente/paredeT.png"));
			tile[21].colision = true;
			
			tile [22] = new Tile();
			tile[22].Image = ImageIO.read(getClass().getResourceAsStream("/ambiente/paredeX2.png"));
			tile[22].colision = true;
			
			tile [23] = new Tile();
			tile[23].Image = ImageIO.read(getClass().getResourceAsStream("/ambiente/paredeC2.png"));
			tile[23].colision = true;
			
			tile [24] = new Tile();
			tile[24].Image = ImageIO.read(getClass().getResourceAsStream("/ambiente/paredechao2.png"));
			tile[24].colision = true;
			
			tile [25] = new Tile();
			tile[25].Image = ImageIO.read(getClass().getResourceAsStream("/ambiente/paredeZ2.png"));
			tile[25].colision = true;
			
			tile [26] = new Tile();
			tile[26].Image = ImageIO.read(getClass().getResourceAsStream("/ambiente/paredeZ3.png"));
			tile[26].colision = true;
			
			tile [27] = new Tile();
			tile[27].Image = ImageIO.read(getClass().getResourceAsStream("/ambiente/paredeZ4.png"));
			tile[27].colision = true;
			
			tile [28] = new Tile();
			tile[28].Image = ImageIO.read(getClass().getResourceAsStream("/ambiente/paredeZ5.png"));
			tile[28].colision = true;
			
			tile [29] = new Tile();
			tile[29].Image = ImageIO.read(getClass().getResourceAsStream("/ambiente/paredeZ6.png"));
			tile[29].colision = true;
			
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
		
	}
	
	
	public void LoadMapa(String filePath) 
	{
		// carregar o mapa do txt
		try 
		{
			InputStream is = getClass().getResourceAsStream(filePath);
			BufferedReader br = new BufferedReader(new InputStreamReader(is));
			
			int coluna = 0;
			int linha = 0;
			
			while(coluna <gp.maxWorldColuna && linha <gp.maxWorldLinha)
			{
				String line = br.readLine();
				
				while(coluna <gp.maxWorldColuna)
				{
					String numbers[] = line.split(" "); // pular os espaços do txt
					
					int num = Integer.parseInt(numbers[coluna]);
					
					mapaTileNum[coluna][linha] = num;
					coluna++;					
				}
				
				if(coluna == gp.maxWorldColuna)
				{
					coluna = 0;
					linha++;
				}
			}
			
			br.close();
		}
		catch(Exception e)
		{
			
		}
		
	}
	
	public void draw(Graphics2D g2)
	{
		// looping para desenhar o mapa
		int coluna = 0;
		int linha = 0;
	
		
		while(coluna < gp.maxWorldColuna && linha < gp.maxWorldLinha)
		{
			
			int tileNum = mapaTileNum[coluna][linha];
			
			int worldX = coluna * gp.tileSize; // world é a posição do mapa
			int worldY = linha * gp.tileSize;
			int screenX = worldX - gp.player.worldX + gp.player.screenX; // screen é onde vai desenhar 
			int screenY = worldY - gp.player.worldY +gp.player.screenY;
			
			// Faz a camera acompanhar o personagem
			if(worldX + gp.tileSize > gp.player.worldX - gp.player.screenX && 
			   worldX - gp.tileSize < gp.player.worldX + gp.player.screenX &&
			   worldY + gp.tileSize > gp.player.worldY - gp.player.screenY &&
			   worldY - gp.tileSize < gp.player.worldY + gp.player.screenY)				
			{
				
				g2.drawImage(tile[tileNum].Image, screenX, screenY, gp.tileSize, gp.tileSize, null);
			}
			
			
			coluna++;
			

			
			if(coluna == gp.maxWorldColuna)
			{
				coluna = 0;
			
				linha++;
				
				
			}
			
		}
		
		
	}
	
}