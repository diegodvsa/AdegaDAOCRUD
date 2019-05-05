/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

/**
 *
 * @author Diego
 */
public class Usuario {
    
    //declaração dos atributos
    private String login;
    private String senha;    
    
    //construtor simples
    public Usuario(){
        
    }
    
    //construtor completo
    public Usuario(String login, String senha){
        this.setLogin(login);
        this.setSenha(senha);
    }
    
    
    /*
    *   Acessores
    *   @parametros - servem para atribuir o valor dado à propriedade
    */
    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
    
}
