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
import search.Search;
import java.util.ArrayList;
import database.DataBase;
import entidades.Entidade;

/**
 * @author Vinicius Francisco da Silva
 * @author Stefany Gaspar
 * @param <T>
 */
public class ArquivoSequencial<T extends Entidade>{ 
   public static Scanner scanner;
   public Search search = new Search();
   
    public void cadastroUsuario(T valor,int index,DataBase db){
        assert db.getDataoutputstream() != null;
        try{
            db.getDataoutputstream().writeUTF(String.valueOf(
                    GetByte.getByte(valor.getAcess("getNome"))  + 
                    GetByte.getByte(valor.getAcess("getLogin")) + 
                    GetByte.getByte(valor.getAcess("getEmail")) + 
                    GetByte.getByte(valor.getAcess("getSenha")) +
                    GetByte.INTEGER +
                    GetByte.INTEGER));
            
            db.getDataoutputstream().writeUTF((String.valueOf(GetByte.INTEGER)));
            db.getDataoutputstream().writeUTF(String.valueOf(valor.getId()));
            
            db.getDataoutputstream().writeUTF(String.valueOf(GetByte.INTEGER));
            db.getDataoutputstream().writeUTF(String.valueOf(valor.getAcess("getClassificacaoGeral")));
            
            db.getDataoutputstream().writeUTF(String.valueOf(GetByte.getByte(valor.getAcess("getNome"))));
            db.getDataoutputstream().writeUTF(valor.getAcess("getNome"));
            
            db.getDataoutputstream().writeUTF(String.valueOf(GetByte.getByte(valor.getAcess("getLogin"))));
            db.getDataoutputstream().writeUTF(valor.getAcess("getLogin"));
            
            db.getDataoutputstream().writeUTF(String.valueOf(GetByte.getByte(valor.getAcess("getEmail"))));
            db.getDataoutputstream().writeUTF(valor.getAcess("getEmail"));
       
            db.getDataoutputstream().writeUTF(String.valueOf(GetByte.getByte(valor.getAcess("getSenha"))));
            db.getDataoutputstream().writeUTF(valor.getAcess("getSenha"));
        }catch(Exception e){
            e.printStackTrace();
        }// End catch 
    }// End cadastroUsuario()
   
    public static void ler(DataBase db) throws Exception{
        assert db.getDatainputstream() != null;
        int ultimoId = db.getDatainputstream().readInt();
        int id,classificacao;
        String nome,login,email,senha;
        
        System.out.println("========== LISTA DE USUÁRIOS ==========");
        
        for(int i = 0; i < ultimoId; i++){
            id = db.getDatainputstream().readInt();
            classificacao = db.getDatainputstream().readInt();
            nome = db.getDatainputstream().readUTF();
            login = db.getDatainputstream().readUTF();
            email = db.getDatainputstream().readUTF();
            senha = db.getDatainputstream().readUTF();
            
            System.out.println(id + " " + classificacao + " " + nome + " " + login + " " + email + " " + senha);
        }// End for        
    }// End ler()
    
    public void atualizar(DataBase db, T value) throws Exception{
        System.out.println("========== ATUALIZAR ========== ");
        scanner = new Scanner(System.in);
        System.out.println("Digite o código do usuário");
        int codigo = scanner.nextInt();
        int pos = search.pesquisaBinaria(db.getArrayList(),codigo);
        if(pos != -1){
            T clone = (T)value.clonar();
            try{
                System.out.print("Nome: \t");
                clone.setAcess("setNome",scanner.nextLine());
                System.out.println("");
            
                System.out.print("Login: \t");
                clone.setAcess("setLogin",scanner.nextLine());
                System.out.println("");
            
                System.out.print("Email: \t");
                clone.setAcess("setEmail",scanner.nextLine());
                System.out.println("");
            
                System.out.print("Senha: \t");
                clone.setAcess("setSenha",scanner.nextLine());
                System.out.println("");
            
                System.out.println("[ ======= DESEJA ATUALIZAR? [S] SIM / [N] NÃO ======= ]\n");
                char chr = ' ';
                try{    
                    chr = scanner.next().charAt(0);
                }catch(Exception e){
                    e.printStackTrace();
                }// End catch
                if(chr == 'S' || chr == 's' || chr == 'y' || chr == 'Y'){
                    db.getArrayList().add(pos,clone);
                    // Alterar no arquivo
                }// End if
                else if(chr == 'N' || chr == 'n'){
                    clone = null;
                }// End else
            }catch(Exception e){ e.printStackTrace(); }// End catch
        }else{
            System.out.println("Usuário não existe!");
        }// fim else  
    }// End atualizar()
    
    public void remove(ArrayList <T> value){
        System.out.println("========== REMOVER ========== ");
        scanner = new Scanner(System.in);
        System.out.println("Digite o código do usuário que deseja remover");
        int codigo = scanner.nextInt();
        int pos = search.pesquisaBinaria(value,codigo);
        if(pos != -1){
            value.remove(value.get(pos));
            // remove usando lapide no arquivo
        }else{
            System.out.println("Usuário não existe!");
        }// End else
    }// End remove()
}// End class ArquivoSequencial
