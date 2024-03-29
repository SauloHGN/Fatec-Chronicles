package entidade;

import main.GamePainel;
import java.io.IOException;
import javax.imageio.ImageIO;

public class EnariNPC extends Entidade
{

	public boolean end = false;
	public EnariNPC(GamePainel gp)
	{
		super(gp);	
		Direction = "parado";	
		getImage();	
		setDialogo();		
	}
				
		public void getImage()// tiles das animações do npc
		{
			try 
			{
				baixo1 = ImageIO.read(getClass().getResourceAsStream("/EnariNPC/EnariNPC.png"));
				baixo2 = ImageIO.read(getClass().getResourceAsStream("/EnariNPC/EnariNPC.png"));
				cima1 = ImageIO.read(getClass().getResourceAsStream("/EnariNPC/EnariNPC.png"));
				cima2 = ImageIO.read(getClass().getResourceAsStream("/EnariNPC/EnariNPC.png"));
				costas = ImageIO.read(getClass().getResourceAsStream("/EnariNPC/EnariNPC.png"));
				left1 = ImageIO.read(getClass().getResourceAsStream("/EnariNPC/EnariNPC.png"));
				left2 = ImageIO.read(getClass().getResourceAsStream("/EnariNPC/EnariNPC.png"));
				right1 = ImageIO.read(getClass().getResourceAsStream("/EnariNPC/EnariNPC.png"));
				right2 = ImageIO.read(getClass().getResourceAsStream("/EnariNPC/EnariNPC.png"));
				parado = ImageIO.read(getClass().getResourceAsStream("/EnariNPC/EnariNPC.png"));		
			}
			catch(IOException e) 
			{
				e.printStackTrace();
			}			
		}
		
		public void setAction()
		{
			
		}
			
		public void setDialogo()
		{
		
		}
		
		public void fala()
		{
			super.fala();
			IniciarDialogo(this, setDialogo);
			gp.gameState = gp.battleState;
		}
}
