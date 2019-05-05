/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAOS;

import Classes.Usuario;
import Conexao.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class UsuarioDAO {
    
    
    public boolean logar(Usuario usuario)
    {
        String sql = "SELECT login,senha FROM usuario WHERE login = ? AND senha = ?";
        
        try(Connection con = new Conexao().getConnection(); PreparedStatement stmt = con.prepareStatement(sql);){
            stmt.setString(1,usuario.getLogin());
            stmt.setString(2,usuario.getSenha());
            
            ResultSet rs = stmt.executeQuery();
            
            while(rs.next())
            {
                return usuario.getLogin().equals(rs.getString(1)) && usuario.getSenha().equals(rs.getString(2));
            }
            
            
            
        
        }catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao coletar dados: \n" + ex.getMessage(),"ERRO",JOptionPane.ERROR_MESSAGE);
        }
        return false;
    }
}
