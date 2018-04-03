/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package theory4all;
import java.io.DataOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author Vinicius Francisco da Silva
 */
public class Theory4All{
    public static short index;
    public static ArrayList<Usuario> usuario;
    public static ArrayList<Unidade> unidade;
    public static ArrayList<Pergunta> pergunta;
    public static Usuario user;
    public static DataOutputStream dataoutputstream;
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args){
        try{    
           dataoutputstream = new DataOutputStream(new FileOutputStream("Theory4All.txt"));
        }catch(Exception e){
            e.printStackTrace();
        }// End catch
        usuario = new ArrayList<>();
        if(usuario.isEmpty()){
            user = new Usuario();
            user.registrarUsuario();
            assert user != null;
            usuario.add(index,user);
            cadastroUsuario(usuario.get(index++));
        }// End if   
    }// End main()

    public static void cadastroUsuario(Usuario usuario){
        assert dataoutputstream != null;
        try{    
            dataoutputstream.writeInt(usuario.getId());
            dataoutputstream.writeInt(usuario.getClassificacaoGeral());
            dataoutputstream.writeUTF(usuario.getNome());
            dataoutputstream.writeUTF(usuario.getLogin());
            dataoutputstream.writeUTF(usuario.getEmail());
            dataoutputstream.writeUTF(usuario.getSenha());
        }catch(Exception e){
            e.printStackTrace();
        }// End catch
    }// End cadastroUsuario()
}// End class Theory4All
