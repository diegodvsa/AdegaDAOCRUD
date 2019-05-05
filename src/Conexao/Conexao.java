package Conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;


/**
 *
 * Classe para conexão ao banco de dados
 * 
 */
public class Conexao {  
    
    //retorna a conexão com o banco, em caso de erro retorna null
    public Connection getConnection()
    {
        try{
            Connection conexao = DriverManager.getConnection("jdbc:sqlite:C:\\Users\\Diego\\Documents\\NetBeansProjects\\SistemaAdega\\src\\Conexao\\dbAdega.db");
            return conexao;
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro na conexão com a fonte de dados: \n" + ex.getMessage());
        }
        return null;
    }
    
}
