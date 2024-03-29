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
		
		tile = new Tile[999];
		
		mapaTileNum = new int [gp.maxWorldColuna][gp.maxWorldLinha];
		
		getTileImage();
		
		LoadMapa("/mapas/Mapa.txt");
	}
	
	
	public void getTileImage()
	{
		// pixel arts do mapa
		try 
		{
			
						tile[101] = new Tile();	
                        tile[101].Image = ImageIO.read(getClass().getResourceAsStream("/ambiente/101.png"));	
                        tile[101].colision = true;	
                        				
                        tile[102] = new Tile();				
                        tile[102].Image = ImageIO.read(getClass().getResourceAsStream("/ambiente/102.png"));	
				
                        tile[103] = new Tile();	
                        tile[103].Image = ImageIO.read(getClass().getResourceAsStream("/ambiente/103.png"));	
                        tile[103].colision = true;	
                        				
                        tile[104] = new Tile();				
                        tile[104].Image = ImageIO.read(getClass().getResourceAsStream("/ambiente/104.png"));	
                        tile[104].colision = true;	

                        tile[105] = new Tile();				
                        tile[105].Image = ImageIO.read(getClass().getResourceAsStream("/ambiente/105.png"));	
                        tile[105].colision = true;	

                        tile[106] = new Tile();				
                        tile[106].Image = ImageIO.read(getClass().getResourceAsStream("/ambiente/106.png"));	
                        tile[106].colision = true;	

                        tile[107] = new Tile();				
                        tile[107].Image = ImageIO.read(getClass().getResourceAsStream("/ambiente/107.png"));	
                        tile[107].colision = true;	

                        tile[108] = new Tile();				
                        tile[108].Image = ImageIO.read(getClass().getResourceAsStream("/ambiente/108.png"));	
                        tile[108].colision = true;	

                        tile[109] = new Tile();				
                        tile[109].Image = ImageIO.read(getClass().getResourceAsStream("/ambiente/109.png"));	
                        tile[109].colision = true;	

                        tile[110] = new Tile();				
                        tile[110].Image = ImageIO.read(getClass().getResourceAsStream("/ambiente/110.png"));	
                        tile[110].colision = true;	

                        tile[111] = new Tile();				
                        tile[111].Image = ImageIO.read(getClass().getResourceAsStream("/ambiente/111.png"));	
                        tile[111].colision = true;	

                        tile[112] = new Tile();				
                        tile[112].Image = ImageIO.read(getClass().getResourceAsStream("/ambiente/112.png"));	
                        tile[112].colision = true;	

                        tile[113] = new Tile();				
                        tile[113].Image = ImageIO.read(getClass().getResourceAsStream("/ambiente/113.png"));	
                        tile[113].colision = true;	

                        tile[114] = new Tile();				
                        tile[114].Image = ImageIO.read(getClass().getResourceAsStream("/ambiente/114.png"));	
                        tile[114].colision = true;	

                        tile[115] = new Tile();				
                        tile[115].Image = ImageIO.read(getClass().getResourceAsStream("/ambiente/115.png"));	
                        tile[115].colision = true;	

                        tile[116] = new Tile();				
                        tile[116].Image = ImageIO.read(getClass().getResourceAsStream("/ambiente/116.png"));	
                        tile[116].colision = true;	

                        tile[117] = new Tile();				
                        tile[117].Image = ImageIO.read(getClass().getResourceAsStream("/ambiente/117.png"));	
                        tile[117].colision = true;	

                        tile[118] = new Tile();				
                        tile[118].Image = ImageIO.read(getClass().getResourceAsStream("/ambiente/118.png"));	
                        tile[118].colision = true;	

                        tile[119] = new Tile();				
                        tile[119].Image = ImageIO.read(getClass().getResourceAsStream("/ambiente/119.png"));	
                        tile[119].colision = true;	

                        tile[120] = new Tile();				
                        tile[120].Image = ImageIO.read(getClass().getResourceAsStream("/ambiente/120.png"));	
                        tile[120].colision = true;	

                        tile[121] = new Tile();				
                        tile[121].Image = ImageIO.read(getClass().getResourceAsStream("/ambiente/121.png"));	
                        tile[121].colision = true;	

                        tile[122] = new Tile();				
                        tile[122].Image = ImageIO.read(getClass().getResourceAsStream("/ambiente/122.png"));	
                        tile[122].colision = true;

                        tile[123] = new Tile();				
                        tile[123].Image = ImageIO.read(getClass().getResourceAsStream("/ambiente/123.png"));	
                        tile[123].colision = true;

                        tile[124] = new Tile();				
                        tile[124].Image = ImageIO.read(getClass().getResourceAsStream("/ambiente/124.png"));	
                        tile[124].colision = true;

                        tile[125] = new Tile();				
                        tile[125].Image = ImageIO.read(getClass().getResourceAsStream("/ambiente/125.png"));	
                        tile[125].colision = true;

                        tile[126] = new Tile();				
                        tile[126].Image = ImageIO.read(getClass().getResourceAsStream("/ambiente/126.png"));	
                        tile[126].colision = true;

                        tile[127] = new Tile();				
                        tile[127].Image = ImageIO.read(getClass().getResourceAsStream("/ambiente/127.png"));	
                        tile[127].colision = true;

                        tile[128] = new Tile();				
                        tile[128].Image = ImageIO.read(getClass().getResourceAsStream("/ambiente/128.png"));	
                        tile[128].colision = true;

                        tile[129] = new Tile();				
                        tile[129].Image = ImageIO.read(getClass().getResourceAsStream("/ambiente/129.png"));	
                        tile[129].colision = true;

                        tile[130] = new Tile();				
                        tile[130].Image = ImageIO.read(getClass().getResourceAsStream("/ambiente/130.png"));	
                        tile[130].colision = true;

                        tile[131] = new Tile();				
                        tile[131].Image = ImageIO.read(getClass().getResourceAsStream("/ambiente/131.png"));	
                        tile[131].colision = true;

                        tile[132] = new Tile();				
                        tile[132].Image = ImageIO.read(getClass().getResourceAsStream("/ambiente/132.png"));	
                        tile[132].colision = true;

                        tile[133] = new Tile();				
                        tile[133].Image = ImageIO.read(getClass().getResourceAsStream("/ambiente/133.png"));	
                        tile[133].colision = true;

                        tile[134] = new Tile();				
                        tile[134].Image = ImageIO.read(getClass().getResourceAsStream("/ambiente/134.png"));	
                        tile[134].colision = true;

                        tile[135] = new Tile();				
                        tile[135].Image = ImageIO.read(getClass().getResourceAsStream("/ambiente/135.png"));	
                        tile[135].colision = true;

                        tile[136] = new Tile();				
                        tile[136].Image = ImageIO.read(getClass().getResourceAsStream("/ambiente/136.png"));	
                        tile[136].colision = true;

                        tile[137] = new Tile();				
                        tile[137].Image = ImageIO.read(getClass().getResourceAsStream("/ambiente/137.png"));	
                        tile[137].colision = true;

                        tile[138] = new Tile();				
                        tile[138].Image = ImageIO.read(getClass().getResourceAsStream("/ambiente/138.png"));	
                        tile[138].colision = true;

                        tile[139] = new Tile();				
                        tile[139].Image = ImageIO.read(getClass().getResourceAsStream("/ambiente/139.png"));	
                        tile[139].colision = true;

                        tile[140] = new Tile();				
                        tile[140].Image = ImageIO.read(getClass().getResourceAsStream("/ambiente/140.png"));	
                        tile[140].colision = true;	

                        tile[141] = new Tile();				
                        tile[141].Image = ImageIO.read(getClass().getResourceAsStream("/ambiente/141.png"));	
                        tile[141].colision = true;

                        tile[142] = new Tile();				
                        tile[142].Image = ImageIO.read(getClass().getResourceAsStream("/ambiente/142.png"));	
                        tile[142].colision = true;

                        tile[143] = new Tile();				
                        tile[143].Image = ImageIO.read(getClass().getResourceAsStream("/ambiente/143.png"));	
                        tile[143].colision = true;

                        tile[144] = new Tile();				
                        tile[144].Image = ImageIO.read(getClass().getResourceAsStream("/ambiente/144.png"));	
                        tile[144].colision = true;

                        tile[145] = new Tile();				
                        tile[145].Image = ImageIO.read(getClass().getResourceAsStream("/ambiente/145.png"));	
                        tile[145].colision = true;

                        tile[146] = new Tile();				
                        tile[146].Image = ImageIO.read(getClass().getResourceAsStream("/ambiente/146.png"));	
                        tile[146].colision = true;

                        tile[147] = new Tile();				
                        tile[147].Image = ImageIO.read(getClass().getResourceAsStream("/ambiente/147.png"));	
                        tile[147].colision = true;

                        tile[148] = new Tile();				
                        tile[148].Image = ImageIO.read(getClass().getResourceAsStream("/ambiente/148.png"));	
                        tile[148].colision = true;

                        tile[149] = new Tile();				
                        tile[149].Image = ImageIO.read(getClass().getResourceAsStream("/ambiente/149.png"));	
                        tile[149].colision = true;

                        tile[150] = new Tile();				
                        tile[150].Image = ImageIO.read(getClass().getResourceAsStream("/ambiente/150.png"));	
                        tile[150].colision = true;

                        tile[151] = new Tile();				
                        tile[151].Image = ImageIO.read(getClass().getResourceAsStream("/ambiente/151.png"));	
                        tile[151].colision = true;

                        tile[152] = new Tile();				
                        tile[152].Image = ImageIO.read(getClass().getResourceAsStream("/ambiente/152.png"));	
                        tile[152].colision = true;

                        tile[153] = new Tile();				
                        tile[153].Image = ImageIO.read(getClass().getResourceAsStream("/ambiente/153.png"));	
                        tile[153].colision = true;

                        tile[154] = new Tile();				
                        tile[154].Image = ImageIO.read(getClass().getResourceAsStream("/ambiente/154.png"));	
                        tile[154].colision = true;

                        tile[155] = new Tile();				
                        tile[155].Image = ImageIO.read(getClass().getResourceAsStream("/ambiente/155.png"));	
                        tile[155].colision = true;

                        tile[156] = new Tile();				
                        tile[156].Image = ImageIO.read(getClass().getResourceAsStream("/ambiente/156.png"));	
                        tile[156].colision = true;

                        tile[157] = new Tile();				
                        tile[157].Image = ImageIO.read(getClass().getResourceAsStream("/ambiente/157.png"));	
                        tile[157].colision = true;

                        tile[158] = new Tile();				
                        tile[158].Image = ImageIO.read(getClass().getResourceAsStream("/ambiente/158.png"));	
                        tile[158].colision = true;

                        tile[159] = new Tile();				
                        tile[159].Image = ImageIO.read(getClass().getResourceAsStream("/ambiente/159.png"));	
                        tile[159].colision = true;

                        tile[160] = new Tile();				
                        tile[160].Image = ImageIO.read(getClass().getResourceAsStream("/ambiente/160.png"));	
                        tile[160].colision = true;

                        tile[161] = new Tile();				
                        tile[161].Image = ImageIO.read(getClass().getResourceAsStream("/ambiente/161.png"));	
                        tile[161].colision = true;

                        tile[162] = new Tile();				
                        tile[162].Image = ImageIO.read(getClass().getResourceAsStream("/ambiente/162.png"));	
                        tile[162].colision = true;

                        tile[163] = new Tile();				
                        tile[163].Image = ImageIO.read(getClass().getResourceAsStream("/ambiente/163.png"));	
                        tile[163].colision = true;

                        tile[164] = new Tile();				
                        tile[164].Image = ImageIO.read(getClass().getResourceAsStream("/ambiente/164.png"));	
                        tile[164].colision = true;

                        tile[165] = new Tile();				
                        tile[165].Image = ImageIO.read(getClass().getResourceAsStream("/ambiente/165.png"));	
                        tile[165].colision = true;

                        tile[166] = new Tile();				
                        tile[166].Image = ImageIO.read(getClass().getResourceAsStream("/ambiente/166.png"));	
                        tile[166].colision = true;

                        tile[167] = new Tile();				
                        tile[167].Image = ImageIO.read(getClass().getResourceAsStream("/ambiente/167.png"));	
                        tile[167].colision = true;

                        tile[168] = new Tile();				
                        tile[168].Image = ImageIO.read(getClass().getResourceAsStream("/ambiente/168.png"));	
                        tile[168].colision = true;

                        tile[169] = new Tile();				
                        tile[169].Image = ImageIO.read(getClass().getResourceAsStream("/ambiente/169.png"));	
                        tile[169].colision = true;

                        tile[170] = new Tile();				
                        tile[170].Image = ImageIO.read(getClass().getResourceAsStream("/ambiente/170.png"));	
                        tile[170].colision = true;

                        tile[171] = new Tile();				
                        tile[171].Image = ImageIO.read(getClass().getResourceAsStream("/ambiente/171.png"));	
                        tile[171].colision = true;

                        tile[172] = new Tile();				
                        tile[172].Image = ImageIO.read(getClass().getResourceAsStream("/ambiente/172.png"));	
                        tile[172].colision = true;

                        tile[173] = new Tile();				
                        tile[173].Image = ImageIO.read(getClass().getResourceAsStream("/ambiente/173.png"));	
                        tile[173].colision = true;

                        tile[174] = new Tile();				
                        tile[174].Image = ImageIO.read(getClass().getResourceAsStream("/ambiente/174.png"));	
                        tile[174].colision = true;

                        tile[175] = new Tile();				
                        tile[175].Image = ImageIO.read(getClass().getResourceAsStream("/ambiente/175.png"));	
                        tile[175].colision = true;

                        tile[176] = new Tile();				
                        tile[176].Image = ImageIO.read(getClass().getResourceAsStream("/ambiente/176.png"));	
                        tile[176].colision = true;

                        tile[177] = new Tile();				
                        tile[177].Image = ImageIO.read(getClass().getResourceAsStream("/ambiente/177.png"));	
                        tile[177].colision = true;

                        tile[178] = new Tile();				
                        tile[178].Image = ImageIO.read(getClass().getResourceAsStream("/ambiente/178.png"));	
                        tile[178].colision = true;

                        tile[179] = new Tile();				
                        tile[179].Image = ImageIO.read(getClass().getResourceAsStream("/ambiente/179.png"));	
                        tile[179].colision = true;

                        tile[180] = new Tile();				
                        tile[180].Image = ImageIO.read(getClass().getResourceAsStream("/ambiente/180.png"));	
                        tile[180].colision = true;

                        tile[181] = new Tile();				
                        tile[181].Image = ImageIO.read(getClass().getResourceAsStream("/ambiente/181.png"));	
                        tile[181].colision = true;

                        tile[182] = new Tile();				
                        tile[182].Image = ImageIO.read(getClass().getResourceAsStream("/ambiente/182.png"));	
                        tile[182].colision = true;

                        tile[183] = new Tile();				
                        tile[183].Image = ImageIO.read(getClass().getResourceAsStream("/ambiente/183.png"));	
                        tile[183].colision = true;

                        tile[184] = new Tile();				
                        tile[184].Image = ImageIO.read(getClass().getResourceAsStream("/ambiente/184.png"));	
                        tile[184].colision = true;

                        tile[185] = new Tile();				
                        tile[185].Image = ImageIO.read(getClass().getResourceAsStream("/ambiente/185.png"));	
                        tile[185].colision = true;

                        tile[186] = new Tile();				
                        tile[186].Image = ImageIO.read(getClass().getResourceAsStream("/ambiente/186.png"));	
                        tile[186].colision = true;

                        tile[187] = new Tile();				
                        tile[187].Image = ImageIO.read(getClass().getResourceAsStream("/ambiente/187.png"));	
                        tile[187].colision = true;

                        tile[188] = new Tile();				
                        tile[188].Image = ImageIO.read(getClass().getResourceAsStream("/ambiente/188.png"));	
                        tile[188].colision = true;

                        tile[189] = new Tile();				
                        tile[189].Image = ImageIO.read(getClass().getResourceAsStream("/ambiente/189.png"));	
                        tile[189].colision = true;

                        tile[190] = new Tile();				
                        tile[190].Image = ImageIO.read(getClass().getResourceAsStream("/ambiente/190.png"));	
                        tile[190].colision = true;

                        tile[191] = new Tile();				
                        tile[191].Image = ImageIO.read(getClass().getResourceAsStream("/ambiente/191.png"));	
                        tile[191].colision = true;

                        tile[192] = new Tile();				
                        tile[192].Image = ImageIO.read(getClass().getResourceAsStream("/ambiente/192.png"));	
                        tile[192].colision = true;

                        tile[193] = new Tile();				
                        tile[193].Image = ImageIO.read(getClass().getResourceAsStream("/ambiente/193.png"));	
                        tile[193].colision = true;

                        tile[194] = new Tile();				
                        tile[194].Image = ImageIO.read(getClass().getResourceAsStream("/ambiente/194.png"));	
                        tile[194].colision = true;

                        tile[195] = new Tile();				
                        tile[195].Image = ImageIO.read(getClass().getResourceAsStream("/ambiente/195.png"));	
                        tile[195].colision = true;

                        tile[196] = new Tile();				
                        tile[196].Image = ImageIO.read(getClass().getResourceAsStream("/ambiente/196.png"));	
                        tile[196].colision = true;

                        tile[197] = new Tile();				
                        tile[197].Image = ImageIO.read(getClass().getResourceAsStream("/ambiente/197.png"));	
                        tile[197].colision = true;

                        tile[198] = new Tile();				
                        tile[198].Image = ImageIO.read(getClass().getResourceAsStream("/ambiente/198.png"));	
                        tile[198].colision = true;

                        tile[199] = new Tile();				 
                        tile[199].Image = ImageIO.read(getClass().getResourceAsStream("/ambiente/199.png"));	
                        tile[199].colision = true;

                        tile[200] = new Tile();				
                        tile[200].Image = ImageIO.read(getClass().getResourceAsStream("/ambiente/200.png"));	
                        tile[200].colision = true;

                        tile[201] = new Tile();				
                        tile[201].Image = ImageIO.read(getClass().getResourceAsStream("/ambiente/201.png"));	
                        tile[201].colision = true;

                        tile[202] = new Tile();				
                        tile[202].Image = ImageIO.read(getClass().getResourceAsStream("/ambiente/202.png"));	
                        tile[202].colision = true;

                        tile[203] = new Tile();				
                        tile[203].Image = ImageIO.read(getClass().getResourceAsStream("/ambiente/203.png"));	
                        tile[203].colision = true;

                        tile[204] = new Tile();				
                        tile[204].Image = ImageIO.read(getClass().getResourceAsStream("/ambiente/204.png"));	
                        tile[204].colision = true;

                        tile[200] = new Tile();				
                        tile[200].Image = ImageIO.read(getClass().getResourceAsStream("/ambiente/200.png"));	
                        tile[200].colision = true;

                        tile[201] = new Tile();				
                        tile[201].Image = ImageIO.read(getClass().getResourceAsStream("/ambiente/201.png"));	
                        tile[201].colision = true;

                        tile[202] = new Tile();				
                        tile[202].Image = ImageIO.read(getClass().getResourceAsStream("/ambiente/202.png"));	
                        tile[202].colision = true;

                        tile[203] = new Tile();				
                        tile[203].Image = ImageIO.read(getClass().getResourceAsStream("/ambiente/203.png"));	
                        tile[203].colision = true;

                        tile[204] = new Tile();				
                        tile[204].Image = ImageIO.read(getClass().getResourceAsStream("/ambiente/204.png"));	
                        tile[204].colision = true;

                        tile[205] = new Tile();				
                        tile[205].Image = ImageIO.read(getClass().getResourceAsStream("/ambiente/205.png"));	
                        tile[205].colision = true;

                        tile[206] = new Tile();				
                        tile[206].Image = ImageIO.read(getClass().getResourceAsStream("/ambiente/206.png"));	
                        tile[206].colision = true;

                        tile[207] = new Tile();				
                        tile[207].Image = ImageIO.read(getClass().getResourceAsStream("/ambiente/207.png"));	
                        tile[207].colision = true;

                        tile[208] = new Tile();				
                        tile[208].Image = ImageIO.read(getClass().getResourceAsStream("/ambiente/208.png"));	
                        tile[208].colision = true;

                        tile[209] = new Tile();				
                        tile[209].Image = ImageIO.read(getClass().getResourceAsStream("/ambiente/209.png"));	
                        tile[209].colision = true;

                        tile[210] = new Tile();				
                        tile[210].Image = ImageIO.read(getClass().getResourceAsStream("/ambiente/210.png"));	
                        tile[210].colision = true;

                        tile[211] = new Tile();				
                        tile[211].Image = ImageIO.read(getClass().getResourceAsStream("/ambiente/211.png"));	
                        tile[211].colision = true;

                        tile[212] = new Tile();				
                        tile[212].Image = ImageIO.read(getClass().getResourceAsStream("/ambiente/212.png"));	
                        tile[212].colision = true;

                        tile[213] = new Tile();				
                        tile[213].Image = ImageIO.read(getClass().getResourceAsStream("/ambiente/213.png"));	
                        tile[213].colision = true;

                        tile[214] = new Tile();				
                        tile[214].Image = ImageIO.read(getClass().getResourceAsStream("/ambiente/214.png"));	
                        tile[214].colision = true;

                        tile[215] = new Tile();				
                        tile[215].Image = ImageIO.read(getClass().getResourceAsStream("/ambiente/215.png"));	
                        tile[215].colision = true;

                        tile[216] = new Tile();				
                        tile[216].Image = ImageIO.read(getClass().getResourceAsStream("/ambiente/216.png"));	
                        tile[216].colision = true;

                        tile[216] = new Tile();				
                        tile[216].Image = ImageIO.read(getClass().getResourceAsStream("/ambiente/216.png"));	
                        tile[216].colision = true;

                        tile[217] = new Tile();				
                        tile[217].Image = ImageIO.read(getClass().getResourceAsStream("/ambiente/217.png"));	
                        tile[217].colision = true;

                        tile[218] = new Tile();				
                        tile[218].Image = ImageIO.read(getClass().getResourceAsStream("/ambiente/218.png"));	
                        tile[218].colision = true;

                        tile[219] = new Tile();				
                        tile[219].Image = ImageIO.read(getClass().getResourceAsStream("/ambiente/219.png"));	
                        tile[219].colision = true;

                        tile[220] = new Tile();				
                        tile[220].Image = ImageIO.read(getClass().getResourceAsStream("/ambiente/220.png"));	
                        tile[220].colision = true;

                        tile[221] = new Tile();				
                        tile[221].Image = ImageIO.read(getClass().getResourceAsStream("/ambiente/221.png"));	
                        tile[221].colision = true;

                        tile[222] = new Tile();				
                        tile[222].Image = ImageIO.read(getClass().getResourceAsStream("/ambiente/222.png"));	
                        tile[222].colision = true;

                        tile[223] = new Tile();				
                        tile[223].Image = ImageIO.read(getClass().getResourceAsStream("/ambiente/223.png"));	
                        tile[223].colision = true;

                        tile[224] = new Tile();				
                        tile[224].Image = ImageIO.read(getClass().getResourceAsStream("/ambiente/224.png"));	
                        tile[224].colision = true;

                        tile[225] = new Tile();				
                        tile[225].Image = ImageIO.read(getClass().getResourceAsStream("/ambiente/225.png"));	
                        tile[225].colision = true;

                        tile[226] = new Tile();				
                        tile[226].Image = ImageIO.read(getClass().getResourceAsStream("/ambiente/226.png"));	
                        tile[226].colision = true;

                        tile[227] = new Tile();				
                        tile[227].Image = ImageIO.read(getClass().getResourceAsStream("/ambiente/227.png"));	
                        tile[227].colision = true;

                        tile[228] = new Tile();				
                        tile[228].Image = ImageIO.read(getClass().getResourceAsStream("/ambiente/228.png"));	
                        tile[228].colision = true;

                        tile[229] = new Tile();				
                        tile[229].Image = ImageIO.read(getClass().getResourceAsStream("/ambiente/229.png"));	
                        tile[229].colision = true;

                        tile[230] = new Tile();				
                        tile[230].Image = ImageIO.read(getClass().getResourceAsStream("/ambiente/230.png"));	
                        tile[230].colision = true;

                        tile[231] = new Tile();				
                        tile[231].Image = ImageIO.read(getClass().getResourceAsStream("/ambiente/231.png"));	
                        tile[231].colision = true;

                        tile[232] = new Tile();				
                        tile[232].Image = ImageIO.read(getClass().getResourceAsStream("/ambiente/232.png"));	
                        tile[232].colision = true;

                        tile[233] = new Tile();				
                        tile[233].Image = ImageIO.read(getClass().getResourceAsStream("/ambiente/233.png"));	
                        tile[233].colision = true;

                        tile[234] = new Tile();				
                        tile[234].Image = ImageIO.read(getClass().getResourceAsStream("/ambiente/234.png"));	
                        tile[234].colision = true;

                        tile[235] = new Tile();				
                        tile[235].Image = ImageIO.read(getClass().getResourceAsStream("/ambiente/235.png"));	
                        tile[235].colision = true;

                        tile[236] = new Tile();				
                        tile[236].Image = ImageIO.read(getClass().getResourceAsStream("/ambiente/236.png"));	
                        tile[236].colision = true;

                        tile[237] = new Tile();				
                        tile[237].Image = ImageIO.read(getClass().getResourceAsStream("/ambiente/237.png"));	
                        tile[237].colision = true;

                        tile[238] = new Tile();				
                        tile[238].Image = ImageIO.read(getClass().getResourceAsStream("/ambiente/238.png"));	
                        tile[238].colision = true;

                        tile[239] = new Tile();				
                        tile[239].Image = ImageIO.read(getClass().getResourceAsStream("/ambiente/239.png"));	
                        tile[239].colision = true;

                        tile[240] = new Tile();				
                        tile[240].Image = ImageIO.read(getClass().getResourceAsStream("/ambiente/240.png"));	
                        tile[240].colision = true;

                        tile[241] = new Tile();				
                        tile[241].Image = ImageIO.read(getClass().getResourceAsStream("/ambiente/241.png"));	
                        tile[241].colision = true;

                        tile[242] = new Tile();				
                        tile[242].Image = ImageIO.read(getClass().getResourceAsStream("/ambiente/242.png"));	
                        tile[242].colision = true;

                        tile[243] = new Tile();				
                        tile[243].Image = ImageIO.read(getClass().getResourceAsStream("/ambiente/243.png"));	
                        tile[243].colision = true;

                        tile[244] = new Tile();				
                        tile[244].Image = ImageIO.read(getClass().getResourceAsStream("/ambiente/244.png"));	
                        tile[244].colision = true;

                        tile[245] = new Tile();				
                        tile[245].Image = ImageIO.read(getClass().getResourceAsStream("/ambiente/245.png"));	
                        tile[245].colision = true;
                        
                        tile[246] = new Tile();				
                        tile[246].Image = ImageIO.read(getClass().getResourceAsStream("/ambiente/246.png"));	
                        tile[246].colision = true;

                        tile[247] = new Tile();				
                        tile[247].Image = ImageIO.read(getClass().getResourceAsStream("/ambiente/247.png"));	
                        tile[247].colision = true;

                        tile[248] = new Tile();				
                        tile[248].Image = ImageIO.read(getClass().getResourceAsStream("/ambiente/248.png"));	
                        tile[248].colision = true;

                        tile[249] = new Tile();				
                        tile[249].Image = ImageIO.read(getClass().getResourceAsStream("/ambiente/249.png"));	
                        tile[249].colision = true;

                        tile[250] = new Tile();				
                        tile[250].Image = ImageIO.read(getClass().getResourceAsStream("/ambiente/250.png"));	
                        tile[250].colision = true;

                        tile[251] = new Tile();				
                        tile[251].Image = ImageIO.read(getClass().getResourceAsStream("/ambiente/251.png"));	
                        tile[251].colision = true;

                        tile[252] = new Tile();				
                        tile[252].Image = ImageIO.read(getClass().getResourceAsStream("/ambiente/252.png"));	
                        tile[252].colision = true;

                        tile[253] = new Tile();				
                        tile[253].Image = ImageIO.read(getClass().getResourceAsStream("/ambiente/253.png"));	
                        tile[253].colision = true;

                        tile[254] = new Tile();				
                        tile[254].Image = ImageIO.read(getClass().getResourceAsStream("/ambiente/254.png"));	
                        tile[254].colision = true;

                        tile[255] = new Tile();				
                        tile[255].Image = ImageIO.read(getClass().getResourceAsStream("/ambiente/255.png"));	
                        tile[255].colision = true;

                        tile[256] = new Tile();				
                        tile[256].Image = ImageIO.read(getClass().getResourceAsStream("/ambiente/256.png"));	
                        tile[256].colision = true;

                        tile[257] = new Tile();				
                        tile[257].Image = ImageIO.read(getClass().getResourceAsStream("/ambiente/257.png"));	
                        tile[257].colision = true;

                        tile[258] = new Tile();				
                        tile[258].Image = ImageIO.read(getClass().getResourceAsStream("/ambiente/258.png"));	
                        tile[258].colision = true;

                        tile[259] = new Tile();				
                        tile[259].Image = ImageIO.read(getClass().getResourceAsStream("/ambiente/259.png"));	
                        tile[259].colision = true;

                        tile[260] = new Tile();				
                        tile[260].Image = ImageIO.read(getClass().getResourceAsStream("/ambiente/260.png"));	
                        tile[260].colision = true;

                        tile[261] = new Tile();				
                        tile[261].Image = ImageIO.read(getClass().getResourceAsStream("/ambiente/261.png"));	
                        tile[261].colision = true;

                        tile[262] = new Tile();				
                        tile[262].Image = ImageIO.read(getClass().getResourceAsStream("/ambiente/262.png"));	
                        tile[262].colision = true;

                        tile[263] = new Tile();				
                        tile[263].Image = ImageIO.read(getClass().getResourceAsStream("/ambiente/263.png"));	
                        tile[263].colision = true;

                        tile[264] = new Tile();				
                        tile[264].Image = ImageIO.read(getClass().getResourceAsStream("/ambiente/264.png"));	
                        tile[264].colision = true;

                        tile[265] = new Tile();				
                        tile[265].Image = ImageIO.read(getClass().getResourceAsStream("/ambiente/265.png"));	
                        tile[265].colision = true;

                        tile[266] = new Tile();				
                        tile[266].Image = ImageIO.read(getClass().getResourceAsStream("/ambiente/266.png"));	
                        tile[266].colision = true;

                        tile[267] = new Tile();				
                        tile[267].Image = ImageIO.read(getClass().getResourceAsStream("/ambiente/267.png"));	
                        tile[267].colision = true;

                        tile[268] = new Tile();				
                        tile[268].Image = ImageIO.read(getClass().getResourceAsStream("/ambiente/268.png"));	
                        tile[268].colision = true;

                        tile[269] = new Tile();				
                        tile[269].Image = ImageIO.read(getClass().getResourceAsStream("/ambiente/269.png"));	
                        tile[269].colision = true;

                        tile[270] = new Tile();				
                        tile[270].Image = ImageIO.read(getClass().getResourceAsStream("/ambiente/270.png"));	
                        tile[270].colision = true;

                        tile[271] = new Tile();				
                        tile[271].Image = ImageIO.read(getClass().getResourceAsStream("/ambiente/271.png"));	
                        tile[271].colision = true;

                        tile[272] = new Tile();				
                        tile[272].Image = ImageIO.read(getClass().getResourceAsStream("/ambiente/272.png"));	
                        tile[272].colision = true;

                        tile[273] = new Tile();				
                        tile[273].Image = ImageIO.read(getClass().getResourceAsStream("/ambiente/273.png"));	
                        tile[273].colision = true;

                        tile[274] = new Tile();				
                        tile[274].Image = ImageIO.read(getClass().getResourceAsStream("/ambiente/274.png"));	
                        tile[274].colision = true;

                        tile[275] = new Tile();				
                        tile[275].Image = ImageIO.read(getClass().getResourceAsStream("/ambiente/275.png"));	
                        tile[275].colision = true;

                        tile[276] = new Tile();				
                        tile[276].Image = ImageIO.read(getClass().getResourceAsStream("/ambiente/276.png"));	
                        tile[276].colision = true;

                        tile[277] = new Tile();				
                        tile[277].Image = ImageIO.read(getClass().getResourceAsStream("/ambiente/277.png"));	
                        tile[277].colision = true;			
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
