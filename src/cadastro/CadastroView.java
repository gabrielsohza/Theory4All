/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cadastro;

import entidades.Unidade;
import entidades.Usuario;
import java.util.ArrayList;
import java.util.Scanner;
import theory4all.Theory4All;
/**
 *
 * @author Vinicius Francisco da Silva
 */
public class CadastroView{
    public static int index;
    public static Scanner scanner;
    private Cadastro<Usuario> cadastro;

    public CadastroView(Cadastro<Usuario> cadastro){
        index = 0;
        this.cadastro = cadastro;
    }// End CadastroView()
    
    public static int getIndex(){
        return index;
    }// End getIndex()

    public static void setIndex(int index){
        CadastroView.index = index;
    }// End setIndex()

    public Cadastro<Usuario> getCadastro(){
        return cadastro;
    }// End getCadastro()

    public void setCadastro(Cadastro cadastro){
        this.cadastro = cadastro;
    }// End setCadastro()
    
    public void registrarUsuario() throws Exception{
        if(cadastro.getDb().createTable("Usuario","rw")){
            scanner = new Scanner(System.in);
            if(index == 0) System.out.println("Não existe usuários cadastrados: Faça o cadastro!");
            System.out.println("[ ============ CADASTRO DE USUÁRIOS ============ ]\n");
        
            System.out.print("Nome: \t");
            String str_nome = scanner.nextLine();
            System.out.println(" ");
        
            System.out.print("Login: \t");
            String str_login = scanner.nextLine();
            System.out.println(" ");
        
            System.out.print("Email: \t");
            String str_email = scanner.nextLine();
            System.out.println(" ");
        
            System.out.print("Senha: \t");
            String str_senha = scanner.nextLine();
            System.out.println(" ");
        
      //      if(!cadastro.exist(str_login)){
                try{
                    cadastro.getDb().getArquivo().cadastro(new Usuario(index++,0,str_nome,str_login,str_email,str_senha),cadastro.getDb());
                    System.out.println("[ ======= CADASTRO CONCLUÍDO COM SUCESSO ======= ]\n");
                    Theory4All.telaInicial();
                }catch(Exception e){ e.printStackTrace(); }// End catch
            }// End if
            else{
                System.out.println(" LOGIN JÁ EXISTE ");
            }// End else
     //   }// End if
       // else{
         //   throw new Exception("erro");
      //  }// End else
    }// End registrarUsuario()
}// End CadastroView()
