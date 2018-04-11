/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package theory4all;

import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;
import database.DataBase;
import entidades.Usuario;
import arquivosequencial.ArquivoSequencial;
import cadastro.Cadastro;
import cadastro.CadastroView;
import entidades.Pergunta;
import entidades.Unidade;
import java.util.Scanner;
import login.Login;
import login.LoginView;

/**
 *
 * @author Vinicius Francisco da Silva
 */
public class Theory4All{
    public static Scanner scanner;
    static LoginView lv;
    static CadastroView cv;
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)throws Exception{
        lv = new LoginView(new Login());
        cv = new CadastroView(new Cadastro());
        telaInicial();
    }// End main()
    
    public static void telaInicial() throws Exception{
        System.out.println("[ ======= THEORY4 ALL ======= ]\n");
        System.out.println("Logar digite: [L]");
        System.out.println("Cadastrar digite: [C]");
        scanner = new Scanner(System.in);
        char chr = scanner.nextLine().charAt(0);     
        if(cv.getCadastro().getDb() != null && chr == 'L' || chr == 'l'){
            lv.login(cv.getCadastro());
        }else if(cv.getCadastro().getDb() != null || chr == 'C' || chr == 'C'){
            cv.registrarUsuario();
        }else{
           System.out.print("ERRO");
        }// End else
    }// End telaInicial()
}// End class Theory4All
