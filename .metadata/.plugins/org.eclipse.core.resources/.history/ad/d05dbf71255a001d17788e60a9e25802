package objetos;

import java.io.IOException;

import javax.imageio.ImageIO;

import main.GamePainel;

public class Livro extends superObjetos
{

	public Livro(GamePainel gp)
	{
		super(gp);
		
		name = "livro";
		try
		{
			baixo1 = ImageIO.read(getClass().getResourceAsStream("/itens/livro.png"));
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}
	
}
