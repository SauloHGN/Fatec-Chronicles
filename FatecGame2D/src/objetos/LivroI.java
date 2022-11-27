package objetos;

import java.io.IOException;

import javax.imageio.ImageIO;

import main.GamePainel;

public class LivroI extends superObjetos 
{

	public LivroI(GamePainel gp)
	{
		super(gp);
		
		name = "livro3";
		try
		{
			baixo1 = ImageIO.read(getClass().getResourceAsStream("/itens/livro3.png"));
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}
	
}