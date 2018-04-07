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
import static theory4all.Theory4All.db;

/**
 *
 * @author Vinicius Francisco da Silva
 */
public class CadastroView{
    public static int index;
    public static Scanner scanner;
    Cadastro cadastro;
    
    public CadastroView(Cadastro cadastro){
        index = 0;
        this.cadastro = cadastro;
    }// End CadastroView()
    
    public void registrarUsuario(){
        scanner = new Scanner(System.in);
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
        
        if(!cadastro.exist(str_login)){
            try{
                cadastro.db.getArrayList().add(index,new Usuario(Usuario.getIdInit(),0,str_nome,str_login,str_email,str_senha));
                db.getArquivo().cadastroUsuario(cadastro.db.getArrayList().get(index),index++,cadastro.db);
                System.out.println("[ ======= CADASTRO CONCLUÍDO COM SUCESSO ======= ]\n");
            }catch(Exception e){ e.printStackTrace(); }// End catch
        }// End if
        else{
            System.out.println(" LOGIN JÁ EXISTE ");
        }// End else
    }// End registrarUsuario()
}// End CadastroView()
