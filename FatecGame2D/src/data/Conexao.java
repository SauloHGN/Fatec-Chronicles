
package data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import java.util.ArrayList;

import entidade.Entidade;

//import com.mysql.cj.protocol.ResultSet;

import main.GamePainel;


public class Conexao 
{
    
    static GamePainel gp;
    
    static ResultSet rs;
    static Connection con;
    static Statement stmt;
    public static Conexao instance = null;
    
    
    
    //
    public ArrayList<String>nomeItens = new ArrayList<>();
    
    
    

    public Conexao(GamePainel gp) 
    {
    	
    	
    	try 
    	{
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Driver Carregado");
            
        } 
    	catch (ClassNotFoundException e) 
    	{
            System.out.println("Nao foi possivel carregar o driver MySQL");
        }
    }
    
   
    public Conexao getInstance(GamePainel gp) 
    {
        if (instance == null) 
        {
            instance = new Conexao(gp);
        }
        return instance;
    }

    public static Connection getConnection(GamePainel gp) 
    {
        try 
        {
            if ((con == null) || (con.isClosed())) 
            {
                con = DriverManager.getConnection("jdbc:mysql://localhost/datagame", "root", "");
                System.out.println("Conectado com sucesso");
                stmt = con.createStatement();
            }
        } 
        catch (SQLException e)
        {
        	System.out.println("Erro na conexao com o banco de dados");
            System.out.println(e.getMessage());
        }
        return con;
    }
    
    
    
    
    public void Salvar(GamePainel gp)
	{
		Connection con = Conexao.getConnection(gp);
		Statement stmt = null;
		
		try 
        {
			
			
			stmt = con.createStatement();
			
			if(con != null)
			{
				
			try {
				
				for(int i = 0; i < gp.player.inventarioL.size(); i++)
				{
					
					nomeItens.add(gp.player.inventarioL.get(i).name);
					
				}
			}
			catch(Exception e)
			{
				
			}
				
			
		    String sql = "INSERT INTO progresso(level,vida,moeda,posLinha,posColuna,lista)"
		    + "VALUES ('"+gp.player.level+"','"+gp.player.vida+"', '"+gp.player.moeda+"', '"+gp.player.worldY+"', '"+gp.player.worldX+"','"+nomeItens+"')";		  
			System.out.println("SQL: " + sql);
		    stmt.executeUpdate(sql);
		    System.out.println("Os dados foram salvos com sucesso");
		    
			}
			
			
           
            
            return;
        } 
        catch (SQLException e)
        {
        	System.out.println("Falha ao salvar dados");
            System.out.println(e.getMessage());
            return;
        } 
		finally
		{
	       try 
	        {
	    	   if(stmt != null)
	    	   {
	    		   stmt.close();
		           con.close();
		           System.out.println("Desconectado com sucesso");
	    	   }
	           
	        }
	        catch (SQLException e)
	        {
	            System.out.println("Erro ao desconectar" + e.getMessage());
	        }
	    }
		
    
	}
    


	public void Load(GamePainel gp)
    {
    	
    	Connection con = Conexao.getConnection(gp);
		Statement stmt = null;
		
		
		try
		{
			stmt = con.createStatement();
			
			
			
			ResultSet rs = stmt.executeQuery("SELECT * FROM progresso");
			
			while(rs.next())
			{
				gp.player.level = rs.getInt("level");
				gp.player.vida = rs.getInt("vida");				
				gp.player.moeda = rs.getInt("moeda");
				gp.player.worldY= rs.getInt("posLinha");
				gp.player.worldX = rs.getInt("posColuna");
				
				gp.player.inventarioL.clear();
				nomeItens.clear();
			
				nomeItens.add(rs.getString("lista"));
				
			}
			
			for(int i = 0; i < nomeItens.size(); i++)
			{
				gp.player.inventarioL.add(getObjeto(nomeItens.get(i)));	
				
			}
			
		}
		catch (SQLException e)
		{
			System.out.println("Nao foi possivel carregar o Save" + e.getMessage());
			
            return;
		}
	
    }
    
    public Entidade getObjeto(String nomeItens)
   	{
   		Entidade obj = null;
   		
   		switch(nomeItens)
   		{
   		case "livro": 
   			obj = new objetos.Livro(gp);
   			//gp.player.inventarioL.add(new objetos.Livro(gp));
   			break;
   			
   		case "moeda":
   			obj = new objetos.Moeda(gp);
   			break;
   			//gp.player.inventarioL.add(new objetos.Moeda(gp));
   			
   		}
   		return obj;
   	}
    
    
    
    

    public void destroy(GamePainel gp) 
    {
        try 
        {
            con.close();
        } 
        catch(SQLException e)
        {
            System.out.println(e.getMessage());
        }
    }

    
}
