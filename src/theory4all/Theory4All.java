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

/**
 *
 * @author Vinicius Francisco da Silva
 */
public class Theory4All extends DataBase{
    public static int index;
    public static ArrayList<Usuario> usuario;
    public static Usuario user;
    public static DataOutputStream dataoutputstream;
    public static DataBase db;
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)throws Exception{
        index = 0;
        db = new DataBase();         
        if(usuario == null){
            usuario = new ArrayList<>();
            if(!db.createTable("Usuario.db","w")){      
                throw new Exception("erro:");
            }// End if  
            user = new Usuario();
            user.registrarUsuario();
            assert user != null;
            usuario.add(index,user);
            ArquivoSequencial.cadastroUsuario(usuario.get(index++),db);
        }// End if   
    }// End main()
}// End class Theory4All
