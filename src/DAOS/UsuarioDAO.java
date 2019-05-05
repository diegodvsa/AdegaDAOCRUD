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
    
    
    /*
        Verificar login e senha corretos, e retornar verdadeiro    
    */
    public boolean logar(Usuario usuario)
    {
        
        String sql = "SELECT login,senha FROM usuario WHERE login = ? AND senha = ?";
        
        //try-with para fechar automaticamente a Conexão e o PreparedStatement
        try(Connection con = new Conexao().getConnection(); PreparedStatement stmt = con.prepareStatement(sql);){
            
            //atribuição dos parametros da consulta sql
            stmt.setString(1,usuario.getLogin());
            stmt.setString(2,usuario.getSenha());
            
            //result set com os resultados da consulta
            ResultSet rs = stmt.executeQuery();
            
            
            while(rs.next())
            {
                //retorna verdadeiro ou falso se o usuario e senha são os mesmos do objeto passado
                return usuario.getLogin().equals(rs.getString(1)) && usuario.getSenha().equals(rs.getString(2));
            }
        
        }catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao coletar dados: \n" + ex.getMessage(),"ERRO",JOptionPane.ERROR_MESSAGE);
        }
        return false;
    }
}
