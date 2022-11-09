package entidade;

import main.GamePainel;
import java.io.IOException;
import javax.imageio.ImageIO;

public class LigiaNPC extends Entidade
{

	public LigiaNPC(GamePainel gp)
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
				baixo1 = ImageIO.read(getClass().getResourceAsStream("/LigiaNPC/Lteste.png"));
				baixo2 = ImageIO.read(getClass().getResourceAsStream("/LigiaNPC/Lteste.png"));
				cima1 = ImageIO.read(getClass().getResourceAsStream("/LigiaNPC/Lteste.png"));
				cima2 = ImageIO.read(getClass().getResourceAsStream("/LigiaNPC/Lteste.png"));
				costas = ImageIO.read(getClass().getResourceAsStream("/LigiaNPC/Lteste.png"));
				left1 = ImageIO.read(getClass().getResourceAsStream("/LigiaNPC/Lteste.png"));
				left2 = ImageIO.read(getClass().getResourceAsStream("/LigiaNPC/Lteste.png"));
				right1 = ImageIO.read(getClass().getResourceAsStream("/LigiaNPC/Lteste.png"));
				right2 = ImageIO.read(getClass().getResourceAsStream("/LigiaNPC/Lteste.png"));
				parado = ImageIO.read(getClass().getResourceAsStream("/LigiaNPC/Lteste.png"));
				
			}
			
			catch(IOException e) 
			{
				e.printStackTrace();
			}			
		}
		
		
		public void setDialogo()
		{
			dialogos[0] ="Ligia";
		}
		
		
}