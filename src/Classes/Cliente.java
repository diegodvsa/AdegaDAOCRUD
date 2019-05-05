/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

/**
 *
 * @author Diego
 * 
 */
public final class Cliente {

    
    //declaração dos atributos
    private int id;
    private int idade;
    private String nome;
    private String cep;
    private String logradouro;
    private String numero;
    private String bairro;
    private String cidade;
    private String estado;
    
    //construtor simples
    public Cliente() {
        
    }
    
    //construtor para popular a tabela
    public Cliente(int id, String nome, int idade)
    {
        setId(id);
        setIdade(idade);
        setNome(nome);
    }
    
    //construtor completo
    public Cliente(int id, int idade, String nome, 
            String cep, String logradouro, String numero, 
            String bairro, String cidade,String estado)
    {
        setId(id);
        setIdade(idade);
        setNome(nome);
        setCep(cep);
        setLogradouro(logradouro);
        setNumero(numero);
        setBairro(bairro);
        setCidade(cidade);
        setEstado(estado);        
    }
    

    
    /*
    *   Acessores
    *   @parametros - servem para atribuir o valor dado à propriedade
    */
    
    public int getId() {
        return id;
    }

    
    public void setId(int id) {
        this.id = id;
    }

   
    public int getIdade() {
        return idade;
    }

    
    public void setIdade(int idade) {
        this.idade = idade;
    }

    
    public String getNome() {
        return nome;
    }

    
    public void setNome(String nome) {
        this.nome = nome;
    }

    
    public String getCep() {
        return cep;
    }

    
    public void setCep(String cep) {
        this.cep = cep;
    }

    
    public String getLogradouro() {
        return logradouro;
    }

    
    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    
    public String getNumero() {
        return numero;
    }

    
    public void setNumero(String numero) {
        this.numero = numero;
    }

    
    public String getBairro() {
        return bairro;
    }

    
    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    
    public String getCidade() {
        return cidade;
    }

    
    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    
    public String getEstado() {
        return estado;
    }

    
    public void setEstado(String estado) {
        this.estado = estado;
    }
       
}
