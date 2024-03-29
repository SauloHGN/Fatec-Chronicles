package entidade;

import main.GamePainel;
import java.io.IOException;
import javax.imageio.ImageIO;

public class ChNPC extends Entidade
{

	public ChNPC(GamePainel gp)
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
				baixo1 = ImageIO.read(getClass().getResourceAsStream("/ChNPC/Cparado.png"));
				baixo2 = ImageIO.read(getClass().getResourceAsStream("/ChNPC/Cparado.png"));
				cima1 = ImageIO.read(getClass().getResourceAsStream("/ChNPC/Cparado.png"));
				cima2 = ImageIO.read(getClass().getResourceAsStream("/ChNPC/Cparado.png"));
				costas = ImageIO.read(getClass().getResourceAsStream("/ChNPC/Cparado.png"));
				left1 = ImageIO.read(getClass().getResourceAsStream("/ChNPC/Cparado.png"));
				left2 = ImageIO.read(getClass().getResourceAsStream("/ChNPC/Cparado.png"));
				right1 = ImageIO.read(getClass().getResourceAsStream("/ChNPC/Cparado.png"));
				right2 = ImageIO.read(getClass().getResourceAsStream("/ChNPC/Cparado.png"));
				parado = ImageIO.read(getClass().getResourceAsStream("/ChNPC/Cparado.png"));		
			}	
			catch(IOException e) 
			{
				e.printStackTrace();
			}			
		}
		
		public void setAction()
		{
			setDialogo();
		}
		
		public void setDialogo()
		{
			if(gp.player.level < 4)
			{
				dialogos[0][0] = "Charles: Estou ocupado agora,\nvolte mais tarde...";
			}
			
			
			if(gp.player.level > 4)
			{
				dialogos[0][0] ="Charles: Caraca, só posso \ndivulgar a senha depois de \nassistir a terceira temporada \nde Cavaleiro da Lua!";
				dialogos[0][1] = "Charles: Até lá, a relatividade do \ninfinito, nos mostra o quão \npequeno ele pode ser.\n";
				dialogos[0][2] = "A faculdade nem sempre está com \nas portas abertas.";
			}
		}
		
		public void fala()
		{
			IniciarDialogo(this, setDialogo);
		}
}
		
		