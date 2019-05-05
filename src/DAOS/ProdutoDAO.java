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
    
    /*
        Insere produto no banco, recebe como parametro um objeto produto
        retorna true se efetuado com sucesso, e false se não.
    */
    public boolean inserir(Produto produto)
    {
        String sql = "insert into produto (alcoolico, teor, nome, descricao, litragem, unidade, preco)values (?,?,?,?,?,?,?)";
        
        //try-with para fechar automaticamente a Conexão e o PreparedStatement
        try(Connection con = new Conexao().getConnection(); PreparedStatement stmt = con.prepareStatement(sql);){
        
        //atribuição dos parametros da consulta sql
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
    
     /*
        Edita produto no banco, recebe como parametro um objeto produto
        retorna true se efetuado com sucesso, e false se não.
    */    
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
        
        //try-with para fechar automaticamente a Conexão e o PreparedStatement
        try(Connection con = new Conexao().getConnection();PreparedStatement stmt = con.prepareStatement(sql);)
        {
            
            //atribuição dos parametros da consulta sql
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
    
    /*
        Deleta produto no banco, recebe como parametro um inteiro (id_produto)
        retorna true se efetuado com sucesso, e false se não.
    */
    public boolean delete(int id)
    {
        String sql = "DELETE FROM produto WHERE id_produto = ? ";
        
        //try-with para fechar automaticamente a Conexão e o PreparedStatement
        try(Connection con = new Conexao().getConnection();PreparedStatement stmt = con.prepareStatement(sql);)
        {
            //atribuição dos parametros da consulta sql
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
    
    /*
        retorna uma lista genérica com todos os Produtos no banco, utilizada para preencher
        a tabela
    */
    public List<Produto> selectAll()
    {
        String sql = "SELECT id_produto, nome, preco, alcoolico FROM produto";
        
        //instaancia da lista
        List<Produto> produtos = new ArrayList<>();
        
        //try-with para fechar automaticamente a Conexão e o PreparedStatement
        try(Connection con = new Conexao().getConnection(); PreparedStatement stmt = con.prepareStatement(sql);){
            
            //result set com os resultados da consulta
            ResultSet rs = stmt.executeQuery();
            
            /*
                loop para percorrer todos os registros encontrados e instanciar um 
                produto novo para adicionar à lista
            */
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
    
    
    /*
        retorna um objeto Produto com o id definido no parametro, utilizada para preencher
        os campos
    */
    public Produto select(int id)
    {
        Produto produto = null;
        String sql = "SELECT * FROM produto WHERE id_produto = ?";
        
        
        try(Connection con = new Conexao().getConnection(); PreparedStatement stmt = con.prepareStatement(sql);){
            
            //atribuição dos parametros da consulta sql 
            stmt.setInt(1, id);
            
            //result set com os resultados da consulta
            ResultSet rs = stmt.executeQuery();
            
            //loop para atribuir os valores do cliente buscado a um objeto cliente
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
