/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

/**
 *
 * @author Vinicius Francisco da Silva
 */
public class Unidade{
    private int id;
    private byte classificacao;
    private String nome;

    public Unidade(int id,byte classificacao,String nome){
        setId(id);
        setClassificacao(classificacao);
        setNome(nome);
    }// End Unidade()
    
    public Unidade(){
        setId(-1);
        setClassificacao((byte)-1);
        setNome("");
    }// End Unidade()
    public int getId(){
        return id;
    }// End getId()

    public byte getClassificacao(){
        return classificacao;
    }// End getClassificacao()

    public String getNome(){
        return nome;
    }// End getNome()

    public void setId(int id){
        this.id = id;
    }// End setId

    public void setClassificacao(byte classificacao){
        this.classificacao = classificacao;
    }// End setClassificacao()

    public void setNome(String nome){
        this.nome = nome;
    }// End setNome()
}// End class Unidade
