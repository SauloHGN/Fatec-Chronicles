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
			
			// 15 -  16
			
			tile [15] = new Tile();
			tile[15].Image = ImageIO.read(getClass().getResourceAsStream("/ambiente/escada1teste.png"));
			tile[15].colision = true;
			
			tile [16] = new Tile();
			tile[16].Image = ImageIO.read(getClass().getResourceAsStream("/ambiente/escadaTeste.png"));
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
			
			tile [30] = new Tile();
			tile[30].Image = ImageIO.read(getClass().getResourceAsStream("/ambiente/1.png"));
			tile[30].colision = true;
			
			tile [31] = new Tile();
			tile[31].Image = ImageIO.read(getClass().getResourceAsStream("/ambiente/2.png"));
			tile[31].colision = true;
			
			tile [32] = new Tile();
			tile[32].Image = ImageIO.read(getClass().getResourceAsStream("/ambiente/3.png"));
			tile[32].colision = true;
			
			tile [33] = new Tile();
			tile[33].Image = ImageIO.read(getClass().getResourceAsStream("/ambiente/paredeI.png"));
			tile[33].colision = true;
			
			tile [34] = new Tile();
			tile[34].Image = ImageIO.read(getClass().getResourceAsStream("/ambiente/paredeL.png"));
			tile[34].colision = true;
			
			tile [35] = new Tile();
			tile[35].Image = ImageIO.read(getClass().getResourceAsStream("/ambiente/parede_.png"));
			tile[35].colision = true;
			
			tile [36] = new Tile();
			tile[36].Image = ImageIO.read(getClass().getResourceAsStream("/ambiente/paredeL2.png"));
			tile[36].colision = true;
			
			tile [37] = new Tile();
			tile[37].Image = ImageIO.read(getClass().getResourceAsStream("/ambiente/paredecima2.png"));
			tile[37].colision = true;
			
			tile [38] = new Tile();
			tile[38].Image = ImageIO.read(getClass().getResourceAsStream("/ambiente/paredebaixo2.png"));
			tile[38].colision = true;
			
			tile [39] = new Tile();
			tile[39].Image = ImageIO.read(getClass().getResourceAsStream("/ambiente/portaBcima.png"));
			tile[39].colision = true;
			
			tile [40] = new Tile();
			tile[40].Image = ImageIO.read(getClass().getResourceAsStream("/ambiente/portaBbaixo.png"));
			tile[40].colision = true;
			
			tile [41] = new Tile();
			tile[41].Image = ImageIO.read(getClass().getResourceAsStream("/ambiente/4.png"));
			tile[41].colision = true;
			
			tile [42] = new Tile();
			tile[42].Image = ImageIO.read(getClass().getResourceAsStream("/ambiente/5.png"));
			tile[42].colision = true;
			
			tile [43] = new Tile();
			tile[43].Image = ImageIO.read(getClass().getResourceAsStream("/ambiente/6.png"));
			tile[43].colision = true;
			
			tile [44] = new Tile();
			tile[44].Image = ImageIO.read(getClass().getResourceAsStream("/ambiente/paredeL3.png"));
			tile[44].colision = true;
			
			tile [45] = new Tile();
			tile[45].Image = ImageIO.read(getClass().getResourceAsStream("/ambiente/paredeL4.png"));
			tile[45].colision = true;
			
			tile [46] = new Tile();
			tile[46].Image = ImageIO.read(getClass().getResourceAsStream("/ambiente/q1.png"));
			tile[46].colision = true;
			
			tile [47] = new Tile();
			tile[47].Image = ImageIO.read(getClass().getResourceAsStream("/ambiente/q2.png"));
			tile[47].colision = true;
			
			tile [48] = new Tile();
			tile[48].Image = ImageIO.read(getClass().getResourceAsStream("/ambiente/q3.png"));
			tile[48].colision = true;
			
			tile [49] = new Tile();
			tile[49].Image = ImageIO.read(getClass().getResourceAsStream("/ambiente/portaVBD.png"));
			tile[49].colision = true;
			
			tile [50] = new Tile();
			tile[50].Image = ImageIO.read(getClass().getResourceAsStream("/ambiente/portaVCD.png"));
			tile[50].colision = true;
			
			tile [51] = new Tile();
			tile[51].Image = ImageIO.read(getClass().getResourceAsStream("/ambiente/portaVBE.png"));
			tile[51].colision = true;
			
			tile [52] = new Tile();
			tile[52].Image = ImageIO.read(getClass().getResourceAsStream("/ambiente/portaVCE.png"));
			tile[52].colision = true;
			
			tile [53] = new Tile();
			tile[53].Image = ImageIO.read(getClass().getResourceAsStream("/ambiente/cadeiraM2.png"));
			tile[53].colision = true;
			
			tile [54] = new Tile();
			tile[54].Image = ImageIO.read(getClass().getResourceAsStream("/ambiente/mesa2.png"));
			tile[54].colision = true;
			
			tile [55] = new Tile();
			tile[55].Image = ImageIO.read(getClass().getResourceAsStream("/ambiente/mesa1.png"));
			tile[55].colision = true;
			
			tile [56] = new Tile();
			tile[56].Image = ImageIO.read(getClass().getResourceAsStream("/ambiente/cadeiraM4.png"));
			tile[56].colision = true;
			
			tile [57] = new Tile();
			tile[57].Image = ImageIO.read(getClass().getResourceAsStream("/ambiente/mesa3.png"));
			tile[57].colision = true;
			
			tile [58] = new Tile();
			tile[58].Image = ImageIO.read(getClass().getResourceAsStream("/ambiente/mesa4.png"));
			tile[58].colision = true;
			
			tile [59] = new Tile();
			tile[59].Image = ImageIO.read(getClass().getResourceAsStream("/ambiente/cadeiraM3.png"));
			tile[59].colision = true;
			
			tile [60] = new Tile();
			tile[60].Image = ImageIO.read(getClass().getResourceAsStream("/ambiente/I1.png"));
			tile[60].colision = true;
			
			tile [61] = new Tile();
			tile[61].Image = ImageIO.read(getClass().getResourceAsStream("/ambiente/I2.png"));
			tile[61].colision = true;
			
			tile [62] = new Tile();
			tile[62].Image = ImageIO.read(getClass().getResourceAsStream("/ambiente/I3.png"));
			tile[62].colision = true;
			
			tile [63] = new Tile();
			tile[63].Image = ImageIO.read(getClass().getResourceAsStream("/ambiente/escada1.png"));
			tile[63].colision = true;
			
			tile [64] = new Tile();
			tile[64].Image = ImageIO.read(getClass().getResourceAsStream("/ambiente/escada2.png"));
			tile[64].colision = true;
			
			tile [65] = new Tile();
			tile[65].Image = ImageIO.read(getClass().getResourceAsStream("/ambiente/escada3.png"));
			tile[65].colision = true;
			
			tile [66] = new Tile();
			tile[66].Image = ImageIO.read(getClass().getResourceAsStream("/ambiente/escada4.png"));
			tile[66].colision = true;
			
			tile [67] = new Tile();
			tile[67].Image = ImageIO.read(getClass().getResourceAsStream("/ambiente/escada5.png"));
			tile[67].colision = true;
			
			tile [68] = new Tile();
			tile[68].Image = ImageIO.read(getClass().getResourceAsStream("/ambiente/escada6.png"));
			tile[68].colision = true;
			
			tile [69] = new Tile();
			tile[69].Image = ImageIO.read(getClass().getResourceAsStream("/ambiente/escada7.png"));
			tile[69].colision = true;
			
			tile [70] = new Tile();
			tile[70].Image = ImageIO.read(getClass().getResourceAsStream("/ambiente/escada8.png"));
			tile[70].colision = true;
			
			tile [71] = new Tile();
			tile[71].Image = ImageIO.read(getClass().getResourceAsStream("/ambiente/escada9.png"));
			tile[71].colision = true;
			
			tile [72] = new Tile();
			tile[72].Image = ImageIO.read(getClass().getResourceAsStream("/ambiente/escada10.png"));
			tile[72].colision = true;
			
			tile [73] = new Tile();
			tile[73].Image = ImageIO.read(getClass().getResourceAsStream("/ambiente/escada11.png"));
			tile[73].colision = true;
			
			tile [74] = new Tile();
			tile[74].Image = ImageIO.read(getClass().getResourceAsStream("/ambiente/escada12.png"));
			tile[74].colision = true;
			
			tile [75] = new Tile();
			tile[75].Image = ImageIO.read(getClass().getResourceAsStream("/ambiente/escada13.png"));
			tile[75].colision = true;
			
			tile [76] = new Tile();
			tile[76].Image = ImageIO.read(getClass().getResourceAsStream("/ambiente/escada14.png"));
			tile[76].colision = true;
			
			tile [77] = new Tile();
			tile[77].Image = ImageIO.read(getClass().getResourceAsStream("/ambiente/escada15.png"));
			tile[77].colision = true;
			
			tile [78] = new Tile();
			tile[78].Image = ImageIO.read(getClass().getResourceAsStream("/ambiente/escada16.png"));
			tile[78].colision = true;
			
			tile [79] = new Tile();
			tile[79].Image = ImageIO.read(getClass().getResourceAsStream("/ambiente/escada17.png"));
			tile[79].colision = true;
			
			tile [80] = new Tile();
			tile[80].Image = ImageIO.read(getClass().getResourceAsStream("/ambiente/escada18.png"));
			tile[80].colision = true;
			
			tile [81] = new Tile();
			tile[81].Image = ImageIO.read(getClass().getResourceAsStream("/ambiente/escada19.png"));
			tile[81].colision = true;
			
			tile [82] = new Tile();
			tile[82].Image = ImageIO.read(getClass().getResourceAsStream("/ambiente/escada20.png"));
			tile[82].colision = true;
			
			tile [83] = new Tile();
			tile[83].Image = ImageIO.read(getClass().getResourceAsStream("/ambiente/escada21.png"));
			tile[83].colision = true;
			
			tile [84] = new Tile();
			tile[84].Image = ImageIO.read(getClass().getResourceAsStream("/ambiente/estanteL1.png"));
			tile[84].colision = true;
			
			tile [85] = new Tile();
			tile[85].Image = ImageIO.read(getClass().getResourceAsStream("/ambiente/estanteL2.png"));
			tile[85].colision = true;
			
			tile [86] = new Tile();
			tile[86].Image = ImageIO.read(getClass().getResourceAsStream("/ambiente/estanteL3.png"));
			tile[86].colision = true;
			
			tile [99] = new Tile();
			tile[99].Image = ImageIO.read(getClass().getResourceAsStream("/ambiente/preto.png"));
			tile[99].colision = true;
			
			
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