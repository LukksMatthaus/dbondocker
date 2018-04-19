/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author luks
 */
public  class Banco {
    public static Connection connie = null;
	public static Connection getConnie() throws SQLException {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connie = DriverManager.getConnection("jdbc:mysql://localhost:3308/holodome?user=root&password=password");
			
		}catch(ClassNotFoundException ex) {
			System.out.println("Erro ao carregar driver");
		}
		catch(SQLException exs) {
			System.out.println("Problemas ao configurar conexão");
		}
		return connie;
	}
	public static void closeConnie(Connection con, ResultSet rs, PreparedStatement st) {
		if(rs != null) {
			try{
                            rs.close();
                           
                        } catch(SQLException ex){
                            System.out.println("Erro de SQL");
                            ex.printStackTrace();
                        }
		}
                if(st != null){
                    try{
                        st.close();
                    }catch(SQLException ex){
                            System.out.println("Erro de SQL");
                            ex.printStackTrace();
                        }
                    
                }
                
                if(con != null){
                    try{ 
                        con.close();
                    }catch(SQLException ex){
                            System.out.println("Erro de SQL");
                            ex.printStackTrace();
                        }
                }
                
		
	}

}
