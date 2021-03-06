/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;
import java.util.Scanner;

/**
 * 
 * @author Vinicius Francisco da Silva
 */
public class Usuario implements Entidade{
    private int id;
    private int classificacaoGeral;
    private String nome;
    private String login;
    private String email;
    private String senha;
    private static int id_init = 0;
    
    public Usuario(int id,int classificacaoGeral,String nome,String login,String email,String senha){
        setId(id);
        setClassificacaoGeral(classificacaoGeral);
        setNome(nome);
        setLogin(login);
        setEmail(email);
        setSenha(senha);
    }// End Usuario()

    public Usuario(){ 
        setId(-1);
        setNome("");
        setLogin("");
        setEmail("");
        setSenha("");
    }// End usuario()
      
    public int getId(){
        return id;
    }// End getId

    public void setId(int id){
        this.id = id;
    }// End setId()

    public int getClassificacaoGeral(){
        return classificacaoGeral;
    }// End get ClassificacaoGeral()

    public void setClassificacaoGeral(int classificacaoGeral){
        this.classificacaoGeral = classificacaoGeral;
    }// End setClassificacaoGeral()

    
    public String getNome(){
        return nome;
    }// End getNome()

    
    public void setNome(String nome){
        this.nome = nome;
    }// End setNome()

    public String getLogin(){
        return login;
    }// End getLogin()

    public void setLogin(String login){
        this.login = login;
    }// End setLogin()

    public String getEmail(){
        return email;
    }// End setEmail()

    public void setEmail(String email){
        this.email = email;
    }// End setEmail()

    public String getSenha(){
        return senha;
    }// End setSenha()

    public void setSenha(String senha){
        this.senha = senha;
    }// End setSenha()
    
    public String getAcess(String metod){
        String str = null;
        if(metod.equals("getClassificacaoGeral")){
            str = String.valueOf(getClassificacaoGeral());
        }else if(metod.equals("getNome")){
            str = String.valueOf(getNome());
        }else if(metod.equals("getLogin")){
            str = String.valueOf(getLogin());
        }else if(metod.equals("getEmail")){
            str = String.valueOf(getEmail());
        }else if(metod.equals("getSenha")){
            str = String.valueOf(getSenha());
        }// End else if
        return str;
     }// End metod
      
     public String setAcess(String metod,String value){
         String str = null;
        if(metod.equals("setClassificacaoGeral")){
            setClassificacaoGeral(Integer.parseInt(value));
        }else if(metod.equals("setNome")){
            setNome(value);
        }else if(metod.equals("setLogin")){
            setLogin(value);
        }else if(metod.equals("setEmail")){
            setEmail(value);
        }else if(metod.equals("setSenha")){
            setSenha(value);
        }else{
           // throw new Exception("erro");
        }// End else
         return str;
     }// End metod
     
     public static int getIdInit(){
         return ++id_init;
     }// End getIndex()
     
    @Override
    public Object clonar() throws CloneNotSupportedException{
        super.clone();
        return new Usuario(getId(),getClassificacaoGeral(),getNome(),getLogin(),getEmail(),getSenha());
    }// End clone()
}// End class Usuario
