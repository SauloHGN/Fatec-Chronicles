package main;

import java.awt.Rectangle;

public class ColisaoBattle 
{

	public static int TOPO     = 1;
    public static int ESQUERDO = 2;
    public static int FUNDO    = 4;
    public static int DIREITO  = 8;
		
	public int x1, x2, y1, y2;
	
	public ColisaoBattle(int x1, int y1, int x2, int y2)
	{
		 if(x1 < x2) 
		{
			 this.x1 = x1;
			this.x2 = x2;
		} 
		else 
		{
			this.x1 = x2;
			this.x2 = x1;
		}
		if(y1 < y2)
		{
		    this.y1 = y1;
		    this.y2 = y2;
		} 
		else 
		{
		    this.y1 = y2;
		    this.y2 = y1;
		}	
	}		
	
	 public void move(int x1, int y1, int x2, int y2) 
	 {
	        if(x1 < x2) 
	        {
	            this.x1 = x1;
	            this.x2 = x2;
	        } 
	        else 
	        {
	            this.x1 = x2;
	            this.x2 = x1;
	        }
	        if(y1 < y2) 
	        {
	            this.y1 = y1;
	            this.y2 = y2;
	        } 
	        else 
	        {
	            this.y1 = y2;
	            this.y2 = y1;
	        }
	    }
	    
	    public void move(int dx, int dy) 
	    {
	        x1 += dx;
	        x2 += dx;
	        y1 += dy;
	        y2 += dy;
	    }
	    
	    public int intersecao(ColisaoBattle cb) 
	    {
	        int w = ((x2-x1) + (cb.x2 - cb.x1)) / 2;
	        int h = ((y2-y1) + (cb.y2 - cb.y1)) / 2;
	        int dx = ((x2 + x1) - (cb.x2 + cb.x1)) / 2;
	        int dy = ((y2 + y1) - (cb.y2 + cb.y1)) / 2;
	        
	        if (Math.abs(dx) <= w && Math.abs(dy) <= h) 
	        {
	            int wy = w * dy; int hx = h * dx;
	            	if (wy > hx) 
	            	{
	            		if (wy > -hx) return FUNDO;
	            		else return ESQUERDO;
	            	} 
	            	else 
	            	{
	            		if (wy > -hx) return DIREITO;
	            		else return TOPO;
	            	}
	        	}
	        	return 0;
	    }

		public boolean intersect(Rectangle cerebroColision) 
		{	
			return false;
		}	
}
