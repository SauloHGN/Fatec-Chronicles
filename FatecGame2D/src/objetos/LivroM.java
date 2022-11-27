package objetos;

import java.io.IOException;

import javax.imageio.ImageIO;

import main.GamePainel;

public class LivroM extends superObjetos 
{

	public LivroM(GamePainel gp)
	{
		super(gp);
		
		name = "livro2";
		try
		{
			baixo1 = ImageIO.read(getClass().getResourceAsStream("/itens/livro2.png"));
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}
	
}