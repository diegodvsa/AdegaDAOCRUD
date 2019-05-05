/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAOS;

import Classes.Cliente;
import Conexao.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Diego
 */
public class ClienteDAO {
    
    public boolean inserir(Cliente cliente)
    {
        String sql = "insert into cliente (idade,nome,cep,logradouro,numero, bairro, cidade, estado) values (?,?,?,?,?,?,?,?)";
        try(Connection con = new Conexao().getConnection();PreparedStatement stmt = con.prepareStatement(sql);){       
        
        stmt.setInt(1, cliente.getIdade());
        stmt.setString(2, cliente.getNome());
        stmt.setString(3, cliente.getCep());
        stmt.setString(4, cliente.getLogradouro());
        stmt.setString(5, cliente.getNumero());
        stmt.setString(6, cliente.getBairro());
        stmt.setString(7, cliente.getCidade());
        stmt.setString(8, cliente.getEstado());
        
        stmt.execute();
                
        JOptionPane.showMessageDialog(null, "Dados inseridos com sucesso!"); 
        
        return true;
        }
        catch(SQLException ex)
        {
            JOptionPane.showMessageDialog(null, "Erro ao inserir dados: \n" + ex,"ERRO",JOptionPane.ERROR_MESSAGE);            
        }
        return false;
    }
    
    public boolean update(Classes.Cliente cliente)
    {
        String sql = "UPDATE cliente " +
                            "SET " +
                            "idade = ?, " +
                            "nome = ?, " +
                            "cep = ?, " +
                            "logradouro = ?, " +
                            "numero = ?, " +
                            "bairro = ?, " +
                            "cidade = ?, " +
                            "estado = ? " +
                            "WHERE id_cliente = ?";
        
        
        try(Connection con = new Conexao().getConnection();PreparedStatement stmt = con.prepareStatement(sql);)
        {
            
                      
            stmt.setInt(1, cliente.getIdade());
            stmt.setString(2, cliente.getNome());
            stmt.setString(3, cliente.getCep());
            stmt.setString(4, cliente.getLogradouro());
            stmt.setString(5, cliente.getNumero());
            stmt.setString(6, cliente.getBairro());
            stmt.setString(7, cliente.getCidade());
            stmt.setString(8, cliente.getEstado());
            stmt.setInt(9, cliente.getId());
            
            stmt.execute();
            
            JOptionPane.showMessageDialog(null, "Dados alterados com sucesso!"); 
            return true;
            
        }
        catch(SQLException ex)
        {
            JOptionPane.showMessageDialog(null, "Erro ao alterar dados:  " + ex.getMessage(),"ERRO",JOptionPane.ERROR_MESSAGE);
        }
        return false;
    }
    
    public boolean delete(int id)
    {
        String sql = "DELETE FROM cliente WHERE id_cliente  = ? ";
        try(Connection con = new Conexao().getConnection();PreparedStatement stmt = con.prepareStatement(sql);)
        {
            stmt.setInt(1, id);
            
            stmt.execute();
            
            JOptionPane.showMessageDialog(null, "Dados deletados com sucesso!"); 
            return true;
            
        }
        catch(SQLException ex)
        {
            JOptionPane.showMessageDialog(null, "Erro ao deletar dados: \n" + ex.getMessage(),"ERRO",JOptionPane.ERROR_MESSAGE);
        }
        return false;
    }
    
    public List<Cliente> selectAll()
    {
        String sql = "SELECT id_cliente, nome, idade FROM cliente";
        List<Cliente> clientes = new ArrayList<>();
        try(Connection con = new Conexao().getConnection(); PreparedStatement stmt = con.prepareStatement(sql);){
            
            ResultSet rs = stmt.executeQuery();
            
            while(rs.next())
            {
                Cliente cliente = new Cliente(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getInt(3)                        
                );
                clientes.add(cliente);                
            }
            
            rs.close();
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao coletar dados: \n" + ex.getMessage(),"ERRO",JOptionPane.ERROR_MESSAGE);
        }
        return clientes;
    }
    
    public Cliente select(int id)
    {
        Cliente cliente = null;
        String sql = "SELECT * FROM cliente WHERE id_cliente = ?";
        try(Connection con = new Conexao().getConnection(); PreparedStatement stmt = con.prepareStatement(sql);){
            
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            
            while(rs.next())
            {
                cliente = new Cliente(
                        rs.getInt(1),
                        rs.getInt(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getString(7),
                        rs.getString(8),
                        rs.getString(9)
                );                             
            }
            
            rs.close();
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao coletar dados: \n" + ex, "ERRO",JOptionPane.ERROR_MESSAGE);
        }
        return cliente;
    }
}
