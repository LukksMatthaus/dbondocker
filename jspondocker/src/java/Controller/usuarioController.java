/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;
import Model.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author luks
 */
public class usuarioController {
     public static void inserirUser(Usuario u) throws SQLException{
        Connection connie = Banco.getConnie();
        PreparedStatement stmt = null;
        String query = "INSERT INTO usuario VALUES(?,?,?)";
        try{
            stmt = connie.prepareStatement(query);
            stmt.setInt(1, u.getId());
            stmt.setString(2,u.getNome());
            stmt.setString(7, u.getEmail());
            stmt.executeUpdate();
        }
        catch(SQLException ex){
            Logger.getLogger(usuarioController.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally{
            Banco.closeConnie(connie, null, stmt);
        }
    }
    
    public static Collection ListarUser() throws SQLException{
       Connection connie = Banco.getConnie();
       ResultSet rs = null;
       Statement st = null;
       ArrayList<Usuario> list = new ArrayList();
       String query = "SELECT * FROM usuario";
       try{
           st = connie.createStatement();
           rs = st.executeQuery(query);
           while(rs.next()){
              Usuario u = new Usuario(rs.getInt(1),rs.getString(2), rs.getString(3));
              list.add(u);
           } 
       }
       catch(SQLException ex){
              Logger.getLogger(usuarioController.class.getName()).log(Level.SEVERE, null, ex); 
             }
       finally{
           Banco.closeConnie(connie, rs, null);
       }
       return list;
    }
    
}
