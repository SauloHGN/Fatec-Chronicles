package entidade;

import main.GamePainel;
import java.io.IOException;
import javax.imageio.ImageIO;

public class FeichasNPC extends Entidade
{

	public FeichasNPC(GamePainel gp)
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
				baixo1 = ImageIO.read(getClass().getResourceAsStream("/FeichasNPC/Fparado.png"));
				baixo2 = ImageIO.read(getClass().getResourceAsStream("/FeichasNPC/Fparado.png"));
				cima1 = ImageIO.read(getClass().getResourceAsStream("/FeichasNPC/Fcostas.png"));
				cima2 = ImageIO.read(getClass().getResourceAsStream("/FeichasNPC/Fcostas.png"));
				costas = ImageIO.read(getClass().getResourceAsStream("/FeichasNPC/Fcostas.png"));
				left1 = ImageIO.read(getClass().getResourceAsStream("/FeichasNPC/Fleft.png"));
				left2 = ImageIO.read(getClass().getResourceAsStream("/FeichasNPC/Fleft.png"));
				right1 = ImageIO.read(getClass().getResourceAsStream("/FeichasNPC/Fright.png"));
				right2 = ImageIO.read(getClass().getResourceAsStream("/FeichasNPC/Fright.png"));
				parado = ImageIO.read(getClass().getResourceAsStream("/FeichasNPC/Fparado.png"));
				
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
			if(gp.player.level <= 4)
			{
				dialogos[0][0] ="Feichas: Volte mais tarde...";
			}
			
			if(gp.player.level > 4)
			{
				dialogos[0][0] ="Feichas: Me desculpa, mas não \n posso dizer o codigo!\n";
				dialogos[0][1] ="Feichas: Pois no segundo \ninstante está é a pior nota \nque um aluno poderia receber";
				dialogos[0][2] = "Feichas: Ah, e não se engane, \na cor branca nem sempre é da \npaz... ";
			}
			
		}
		
		public void fala()
		{
			IniciarDialogo(this, setDialogo);
			olhar();
		}
		
}
