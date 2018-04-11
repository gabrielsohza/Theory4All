/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package login;

import arquivosequencial.ArquivoSequencial;
import cadastro.Cadastro;
import database.DataBase;
import java.util.Scanner;

/**
 *
 * @author Vinicius Francisco da Silva
 */
public class LoginView{
    public static Scanner scanner;
    public Login login;
   
    public LoginView(Login login){
        this.login = login;
    }// End LoginView()
    
    public void login(Cadastro cd) throws Exception{
        scanner = new Scanner(System.in);
        System.out.println("[ ============ LOGIN ============ ]");
        System.out.println("Nome de Login");
        String login = scanner.nextLine();
        System.out.println("Senha");
        String senha = scanner.nextLine();
        if(this.login.validaLogin(login,senha,cd)){
           telaInicial(cd);
        }// End if
        else{
            System.out.println("Nome ou senha inválidos: ");
        }// End else
    }// End login()
    
    public void telaInicial(Cadastro cd) throws Exception{
        scanner = new Scanner(System.in);
        int chr;
        int codigo;
        System.out.println("Olá (user)");
        System.out.println("Lista de opções:");
        System.out.println("Atualizar sua conta: [A]");
        System.out.println("Remover sua conta: [R]");
        System.out.println("Acessar unidades: [U]");
        System.out.println("Sair [S]");
        chr = scanner.nextLine().charAt(0);
        if(chr == 'A' || chr == 'a'){
            codigo = scanner.nextInt();
            ArquivoSequencial.atualizar(cd,codigo);     
        }else if(chr == 'R' || chr == 'r'){
            codigo = scanner.nextInt();
            ArquivoSequencial.remove(cd,codigo);
        }else if(chr == 'u' || chr == 'U'){
            // Code
        }else if(chr == 's' || chr == 'S'){
            // Code 
        }// End else if
    }// End telaInicial()
}// End LoginView
