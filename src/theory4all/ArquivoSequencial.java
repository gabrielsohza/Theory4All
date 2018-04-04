/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package theory4all;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.util.Scanner;

/**
 *
 * @author Vinicius Francisco da Silva
 */
class ArquivoSequencial<T>{
   public static DataOutputStream dataoutputstream;
   public static Scanner scanner;
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
    
    public static void ler(ArquivoSequencial<T> sequencial,DataInputStream datainputstream) throws Exception{
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
    
    public static void atualizar(){
        System.out.println("========== ATUALIZAR ========== ");
        scanner = new Scanner(System.in);
        System.out.println("Digite o código do usuário");
        int codigo = scanner.nextInt();
        int pos = Sort.pesquisaBinaria(ArrayList<Usuario> sequencial,codigo);
        if(pos != -1){
            //clona
            try{
                System.out.print("Nome: \t");
                setNome(scanner.nextLine());
                System.out.println("");
            
                System.out.print("Login: \t");
                setLogin(scanner.nextLine());
                System.out.println("");
            
                System.out.print("Email: \t");
                setEmail(scanner.nextLine());
                System.out.println("");
            
                System.out.print("Senha: \t");
                setSenha(scanner.nextLine());
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
    
    public static void remove(){
        System.out.println("========== REMOVER ========== ");
        scanner = new Scanner(System.in);
        System.out.println("Digite o código do usuário que deseja remover");
        int codigo = scanner.nextInt();
        int pos = Sort.pesquisaBinaria(ArrayList<Usuario> sequencial,codigo);
        if(pos != -1){
            sequencial.remove(sequencial.get(pos));
            // remove usando lapide no arquivo
        }else{
            System.out.println("Usuário não existe!");
        }// End else
    }// End remove()
}// End class ArquivoSequencial
