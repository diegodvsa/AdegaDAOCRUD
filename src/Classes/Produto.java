/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

import java.util.HashSet;

/**
 *
 * @author Diego
 */
public class Produto {
    
    //declaração dos atributos
    private int id_produto;
    private String alcoolico;
    private double teor;
    private String nome;
    private String descricao;
    private double litragem;
    private String unidade;
    private double preco;
    
    //construtor simples
    public Produto(){
        
    }
    
    //construtor para a tabela
    public Produto(int id, String nome, double preco, String alcoolico){
        this.setId_produto(id);
        this.setNome(nome);
        this.setPreco(preco);
        this.setAlcoolico(alcoolico);        
    }
    
    //construtor competo
    public Produto(int id, String alcoolico, double teor, String nome,
            String descricao, double litragem, String unidade, double preco){
        this.setId_produto(id);
        this.setAlcoolico(alcoolico);
        this.setTeor(teor);
        this.setNome(nome);
        this.setDescricao(descricao);
        this.setLitragem(litragem);
        this.setUnidade(unidade);
        this.setPreco(preco);
    }
            
    /*
    *   Acessores
    *   @parametros - servem para atribuir o valor dado à propriedade
    */
    public int getId_produto() {
        return id_produto;
    }

    public void setId_produto(int id_produto) {
        this.id_produto = id_produto;
    }

    public String getAlcoolico() {
        return alcoolico;
    }

    public void setAlcoolico(String alcoolico) {
        this.alcoolico = alcoolico;
    }

    public double getTeor() {
        return teor;
    }

    public void setTeor(double teor) {
        this.teor = teor;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public double getLitragem() {
        return litragem;
    }

    public void setLitragem(double litragem) {
        this.litragem = litragem;
    }

    public String getUnidade() {
        return unidade;
    }

    public void setUnidade(String unidade) {
        this.unidade = unidade;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }
   
    
}
