/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arquivosequencial;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.util.Scanner;
import entidades.Usuario;
import getbyte.GetByte;
import sort.Sort;
import java.util.ArrayList;
import database.DataBase;

/**
 *
 * @author Vinicius Francisco da Silva
 */
public class ArquivoSequencial<T>{
   public static Scanner scanner;
    public static void cadastroUsuario(Usuario usuario, DataBase db){
        assert db.getDataoutputstream() != null;
        try{
/*
	ByteArrayOutputStream registro = new ByteArrayOutputStream();
	DataOutpuStream saida = new DataOutputStream(registro);
	saida.writeShort(usuario.getId());
	saida.writeShort(usuario.getClassificacaoGeral());
	saida.writeUTF(usuario.getNome());
	saida.writeUTF(usuario.getLogin());
	saida.writeUTF(Usuario.getEmail());
	saida.writeUTF(usuario.getSenha());
*/
            db.getDataoutputstream().writeShort((short)GetByte.getByte(usuario.getNome()) + 
                    (short)GetByte.INTEGER +
                    (short)GetByte.INTEGER +
                    (short)GetByte.getByte(usuario.getLogin()) + 
                    (short)GetByte.getByte(usuario.getEmail()) + 
                    (short)GetByte.getByte(usuario.getSenha()));
            
            db.getDataoutputstream().writeShort((short)GetByte.INTEGER);
            db.getDataoutputstream().writeInt(usuario.getId());
            
            db.getDataoutputstream().writeShort((short)GetByte.INTEGER);
            db.getDataoutputstream().writeInt(usuario.getClassificacaoGeral());
            
            db.getDataoutputstream().writeShort((short)GetByte.getByte(usuario.getNome()));
            db.getDataoutputstream().writeUTF(usuario.getNome());
            
            db.getDataoutputstream().writeShort((short)GetByte.getByte(usuario.getLogin()));
            db.getDataoutputstream().writeUTF(usuario.getLogin());
            
            db.getDataoutputstream().writeShort((short)GetByte.getByte(usuario.getEmail()));
            db.getDataoutputstream().writeUTF(usuario.getEmail());
            
            db.getDataoutputstream().writeShort((short)GetByte.getByte(usuario.getSenha()));
            db.getDataoutputstream().writeUTF(usuario.getSenha());
        }catch(Exception e){
            e.printStackTrace();
        }// End catch 
    }// End cadastroUsuario()
    
    public static void ler(ArquivoSequencial<Usuario> sequencial,DataInputStream datainputstream) throws Exception{
        int ultimoId = datainputstream.readInt();
        int id,classificacao;
        String nome,login,email,senha;
        
        System.out.println("========== LISTA DE USUÁRIOS ==========");
        
        for(int i = 0; i < ultimoId; i++){
            id = datainputstream.readInt();
            classificacao = datainputstream.readInt();
            nome = datainputstream.readUTF();
            //nome = datainputstream.readUTF();
            
            login = datainputstream.readUTF();
            email = datainputstream.readUTF();
            senha = datainputstream.readUTF();
            
            System.out.println(id + " " + classificacao + " " + nome + " " + login + " " + email + " " + senha);
        }// End for        
    }// End ler()
    
    public static void atualizar(ArrayList<Usuario> sequencial){
        System.out.println("========== ATUALIZAR ========== ");
        scanner = new Scanner(System.in);
        System.out.println("Digite o código do usuário");
        int codigo = scanner.nextInt();
        int pos = Sort.pesquisaBinariaUsuario(sequencial,codigo);
        if(pos != -1){
            //clona
            try{
                System.out.print("Nome: \t");
                sequencial.get(pos).setNome(scanner.nextLine());
                System.out.println("");
            
                System.out.print("Login: \t");
                sequencial.get(pos).setLogin(scanner.nextLine());
                System.out.println("");
            
                System.out.print("Email: \t");
                sequencial.get(pos).setEmail(scanner.nextLine());
                System.out.println("");
            
                System.out.print("Senha: \t");
                sequencial.get(pos).setSenha(scanner.nextLine());
                System.out.println("");
            
                System.out.println("[ ======= DESEJA ATUALIZAR? [S] SIM / [N] NÃO ======= ]\n");
                char chr = ' ';
                try{    
                    chr = scanner.next().charAt(0);
                }catch(Exception e){
                    e.printStackTrace();
                }// End catch
                if(chr == 'S' || chr == 's' || chr == 'y' || chr == 'Y'){
                    // Alterar no array list e no arquivo
                }// End if
                else if(chr == 'N' || chr == 'n'){
                    // destroi o clone
                }// End else
            }catch(Exception e){ e.printStackTrace(); }// End catch
        }else{
            System.out.println("Usuário não existe!");
        }// fim else  
    }// End atualizar()
    
    public static void remove(ArrayList <Usuario> sequencial){
        System.out.println("========== REMOVER ========== ");
        scanner = new Scanner(System.in);
        System.out.println("Digite o código do usuário que deseja remover");
        int codigo = scanner.nextInt();
        int pos = Sort.pesquisaBinariaUsuario(sequencial,codigo);
        if(pos != -1){
            sequencial.remove(sequencial.get(pos));
            // remove usando lapide no arquivo
        }else{
            System.out.println("Usuário não existe!");
        }// End else
    }// End remove()
}// End class ArquivoSequencial
