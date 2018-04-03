/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package theory4all;
import java.util.Scanner;

/**
 *
 * @author Vinicius Francisco da Silva
 */
class Usuario{
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
    
    public void registrarUsuario(){
        final Scanner scanner = new Scanner(System.in);
        System.out.println("[ ============ CADASTRO DE USUÁRIOS ============ ]\n");
        try{
            setId(++id_init);
            setClassificacaoGeral(0);
            
            System.out.print("Nome: \t");
            setNome(scanner.nextLine());
            System.out.println("");
            
            System.out.print("Login: \t");
            setLogin(scanner.nextLine());
            System.out.println("");
            
            System.out.print("Email: \t");
            setEmail(scanner.nextLine());
            System.out.println("");
            
            System.out.print("Senha: \t");
            setSenha(scanner.nextLine());
            System.out.println("");
            
            System.out.println("[ ======= CADASTRO CONCLUÍDO COM SUCESSO ======= ]\n");
        }catch(Exception e){ e.printStackTrace(); }// End catch
    }// End registrarUsuario(
}// End class Usuario
