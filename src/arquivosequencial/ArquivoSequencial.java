/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arquivosequencial;
import static arquivosequencial.ArquivoSequencial.byteoutputstream;
import cadastro.Cadastro;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.util.Scanner;
import entidades.Usuario;
import getbyte.GetByte;
import search.Search;
import java.util.ArrayList;
import database.DataBase;
import entidades.Entidade;
import java.io.ByteArrayOutputStream;

/**
 * @author Vinicius Francisco da Silva
 * @author Stefany Gaspar
 * @param <T>
 */
public class ArquivoSequencial<T extends Entidade>{ 
   public static Scanner scanner;
   public final Search search = new Search();
   public static final ByteArrayOutputStream byteoutputstream = new ByteArrayOutputStream();
   public static final DataOutputStream dataoutputstream = new DataOutputStream(byteoutputstream);
   
    private void cadastroUsuario(T valor,DataBase db) throws Exception{
        assert dataoutputstream != null;     
        try{
            dataoutputstream.writeShort(valor.getId());           
            dataoutputstream.writeInt(Integer.parseInt(String.valueOf(valor.getAcess("getClassificacaoGeral"))));
            dataoutputstream.writeUTF(valor.getAcess("getNome")); 
            dataoutputstream.writeUTF(valor.getAcess("getLogin"));         
            dataoutputstream.writeUTF(valor.getAcess("getEmail"));
            dataoutputstream.writeUTF(valor.getAcess("getSenha"));
            db.getDataoutputstream().write(byteoutputstream.toByteArray());
        }catch(Exception e){
            e.printStackTrace();
        }// End catch     
    }// End ler()
    
    
    // Modificar a parte de interação com o usuario
    public static void atualizar(Cadastro cd,int codigo) throws Exception{
        System.out.println("========== ATUALIZAR ========== ");
        int pos = search.pesquisaBinaria(cd,codigo);
        if(pos != -1){
           // T clone = (T)value.clonar();
            try{
                System.out.print("Nome: \t");
            //    clone.setAcess("setNome",scanner.nextLine());
                System.out.println("");
            
                System.out.print("Login: \t");
           //     clone.setAcess("setLogin",scanner.nextLine());
                System.out.println("");
            
                System.out.print("Email: \t");
           //     clone.setAcess("setEmail",scanner.nextLine());
                System.out.println("");
            
                System.out.print("Senha: \t");
            //    clone.setAcess("setSenha",scanner.nextLine());
                System.out.println("");
            
                System.out.println("[ ======= DESEJA ATUALIZAR? [S] SIM / [N] NÃO ======= ]\n");
                char chr = ' ';
                try{    
                    chr = scanner.next().charAt(0);
                }catch(Exception e){
                    e.printStackTrace();
                }// End catch
                if(chr == 'S' || chr == 's' || chr == 'y' || chr == 'Y'){
                    // Alterar no arquivo
                }// End if
                else if(chr == 'N' || chr == 'n'){
                //    clone = null;
                }// End else
            }catch(Exception e){ e.printStackTrace(); }// End catch
        }else{
            System.out.println("Usuário não existe!");
        }// fim else  
    }// End atualizar()
    
    // Modificar a parte de interação com o usuario
    public static void remove(Cadastro cd,int codigo){
        System.out.println("========== REMOVER ========== ");
        search.setName(cd.getDb().getNome());
        int pos = search.pesquisaBinaria(cd,codigo);
        if(pos != -1){
            // remove usando lapide no arquivo
        }else{
            System.out.println("Usuário não existe!");
        }// End else
    }// End remove()
}// End class ArquivoSequencial
