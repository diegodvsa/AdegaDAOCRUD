/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAOS;



import Classes.Produto;
import Conexao.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;



public class ProdutoDAO {
    public boolean inserir(Produto produto)
    {
        String sql = "insert into produto (alcoolico, teor, nome, descricao, litragem, unidade, preco)values (?,?,?,?,?,?,?)";
        try(Connection con = new Conexao().getConnection(); PreparedStatement stmt = con.prepareStatement(sql);){
            
        stmt.setString(1, produto.getAlcoolico());
        stmt.setDouble(2, produto.getTeor());
        stmt.setString(3, produto.getNome());
        stmt.setString(4, produto.getDescricao());
        stmt.setDouble(5, produto.getLitragem());
        stmt.setString(6, produto.getUnidade());
        stmt.setDouble(7, produto.getPreco());       
        
        stmt.execute();
        
        JOptionPane.showMessageDialog(null, "Dados inseridos com sucesso!"); 
        
        return true;
        }
        catch(SQLException ex)
        {
            JOptionPane.showMessageDialog(null, "Erro ao inserir dados: \n" + ex.getMessage(),"ERRO",JOptionPane.ERROR_MESSAGE);            
        }
        return false;
    }
    
    public boolean update(Produto produto)
    {
        String sql = "UPDATE produto " +
                            "SET " +
                            "alcoolico = ?, " +
                            "teor = ?, " +
                            "nome = ?, " +
                            "descricao = ?, " +
                            "litragem = ?, " +
                            "unidade = ?, " +
                            "preco = ? " +                            
                            "WHERE id_produto = ?;";
        
        try(Connection con = new Conexao().getConnection();PreparedStatement stmt = con.prepareStatement(sql);)
        {
            
            
            stmt.setString(1, produto.getAlcoolico());
            stmt.setDouble(2, produto.getTeor());
            stmt.setString(3, produto.getNome());
            stmt.setString(4, produto.getDescricao());
            stmt.setDouble(5, produto.getLitragem());
            stmt.setString(6, produto.getUnidade());
            stmt.setDouble(7, produto.getPreco());  
            stmt.setInt(8, produto.getId_produto());
        
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
        String sql = "DELETE FROM produto WHERE id_produto = ? ";
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
    
    public List<Produto> selectAll()
    {
        String sql = "SELECT id_produto, nome, preco, alcoolico FROM produto";
        List<Produto> produtos = new ArrayList<>();
        try(Connection con = new Conexao().getConnection(); PreparedStatement stmt = con.prepareStatement(sql);){
            
            ResultSet rs = stmt.executeQuery();
            
            while(rs.next())
            {
                Produto produto = new Produto(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getDouble(3),
                        rs.getString(4)                        
                );
                produtos.add(produto);                
            }
            
            rs.close();
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao coletar dados: \n" + ex.getMessage(),"ERRO",JOptionPane.ERROR_MESSAGE);
        }
        return produtos;
    }
    
    public Produto select(int id)
    {
        Produto produto = null;
        String sql = "SELECT * FROM produto WHERE id_produto = ?";
        try(Connection con = new Conexao().getConnection(); PreparedStatement stmt = con.prepareStatement(sql);){
            
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            
            while(rs.next())
            {
                produto = new Produto(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getDouble(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getDouble(6),
                        rs.getString(7),
                        rs.getDouble(8)                        
                );                             
            }
            
            rs.close();
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao coletar dados: \n" + ex.getMessage(),"ERRO",JOptionPane.ERROR_MESSAGE);
        }
        return produto;
    }
}
