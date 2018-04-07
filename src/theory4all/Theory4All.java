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
    public static DataBase<Usuario> db;
    public static Scanner scanner;
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)throws Exception{
        System.out.println("[ ======= THEORY4 ALL ======= ]\n");
        System.out.println("Logar digite: [L]");
        System.out.println("Cadastrar digite: [C]");
        scanner = new Scanner(System.in);
        char chr = scanner.nextLine().charAt(0);
        db = new DataBase<>();
        if(!db.createTable("Usuario.db","w")){      
            throw new Exception("erro:");
        }// End if
        if(!db.getArrayList().isEmpty() && chr == 'L' && chr == 'l'){
            LoginView lv = new LoginView(new Login(db));
            lv.login();
        }else if(db.getArrayList().isEmpty() || chr == 'C' && chr == 'C'){
            CadastroView cv = new CadastroView(new Cadastro(db));
            cv.registrarUsuario();
        }else{
           System.out.print("ERRO");
        }// End else
    }// End main()
}// End class Theory4All
