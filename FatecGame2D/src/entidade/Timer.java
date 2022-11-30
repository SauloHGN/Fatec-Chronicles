package entidade;

import main.GamePainel;

public class Timer 
{

	GamePainel gp;
	double tempo;
	double limite;
	Action action;
	boolean repete;
	boolean fim;
	
	public Timer(double limite, boolean repete, Action action)
	{
		this.limite = limite;
		this.repete = repete;
		this.action = action;
	}
	
	public void Update()
	{
		if(fim) return;
		tempo = tempo + 0.015;
		
		if(tempo > limite)
		{
			action.executa();
		
			if(repete)
			{
			tempo = tempo - limite;
			}
		
			else
			{
			fim = true;
			}	
		}
	}
}
