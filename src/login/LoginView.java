/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package login;

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
    
    public void login(){
        scanner = new Scanner(System.in);
        System.out.println("[ ============ LOGIN ============ ]");
        System.out.println("Nome de Login");
        String login = scanner.nextLine();
        System.out.println("Senha");
        String senha = scanner.nextLine();
        if(this.login.validaLogin(login,senha)){
           System.out.println("Login efetuado com sucesso: ");
        }// End if
        else{
            System.out.println("Nome ou senha inválidos: ");
        }// End else
    }// End login()
    
    public void telaInicial(){
        
    }// End telaInicial()
}// End LoginView
