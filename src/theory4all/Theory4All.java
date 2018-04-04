/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package theory4all;

import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;
import static theory4all.ArquivoSequencial.cadastroUsuario;

/**
 *
 * @author Vinicius Francisco da Silva
 */
public class Theory4All{
    public static int index;
    public static ArrayList<Usuario> usuario;
    public static Usuario user;
    public static DataOutputStream dataoutputstream;
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args){
        index = 0;
        try{    
           dataoutputstream = new DataOutputStream(new FileOutputStream("Usuários.txt"));
        }catch(Exception e){
            e.printStackTrace();
        }// End catch
        usuario = new ArrayList<>();
        if(usuario.isEmpty()){
            while(true){
                user = new Usuario();
                user.registrarUsuario();
                assert user != null;
                usuario.add(index,user);
                cadastroUsuario(usuario.get(index++));
            }// End while
        }// End if   
    }// End main()
}// End class Theory4All


