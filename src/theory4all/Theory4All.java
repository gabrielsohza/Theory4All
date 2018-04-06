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
import entidades.Pergunta;
import entidades.Unidade;

/**
 *
 * @author Vinicius Francisco da Silva
 */
public class Theory4All{
    public static int index;
    public static Usuario user;
    public static DataBase<Usuario> db;
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)throws Exception{
        index = 0;
        db = new DataBase<>();
        if(!db.createTable("Usuario.db","w")){      
            throw new Exception("erro:");
        }// End if  
        user = new Usuario();
        user.registrarUsuario();
        db.getArrayList().add(index,user); 
        db.getArquivo().cadastroUsuario(db.getArrayList().get(index),index++,db);
    }// End main()
}// End class Theory4All
