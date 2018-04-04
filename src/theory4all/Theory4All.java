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
            dataoutputstream.writeShort((short)GetByte.getByte(usuario.getNome()) + 
                    (short)GetByte.INTEGER +
                    (short)GetByte.INTEGER +
                    (short)GetByte.getByte(usuario.getLogin()) + 
                    (short)GetByte.getByte(usuario.getEmail()) + 
                    (short)GetByte.getByte(usuario.getSenha()));
            
            dataoutputstream.writeShort((short)GetByte.INTEGER);
            dataoutputstream.writeInt(usuario.getId());
            
            dataoutputstream.writeShort((short)GetByte.INTEGER);
            dataoutputstream.writeInt(usuario.getClassificacaoGeral());
            
            dataoutputstream.writeShort((short)GetByte.getByte(usuario.getNome()));
            dataoutputstream.writeUTF(usuario.getNome());
            
            dataoutputstream.writeShort((short)GetByte.getByte(usuario.getLogin()));
            dataoutputstream.writeUTF(usuario.getLogin());
            
            dataoutputstream.writeShort((short)GetByte.getByte(usuario.getEmail()));
            dataoutputstream.writeUTF(usuario.getEmail());
            
            dataoutputstream.writeShort((short)GetByte.getByte(usuario.getSenha()));
            dataoutputstream.writeUTF(usuario.getSenha());
        }catch(Exception e){
            e.printStackTrace();
        }// End catch
    }// End cadastroUsuario()
}// End class Theory4All
