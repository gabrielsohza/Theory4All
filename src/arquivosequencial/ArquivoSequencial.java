/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arquivosequencial;
import static arquivosequencial.ArquivoSequencial.byteoutputstream;
import cadastro.Cadastro;

import java.io.*;
import java.util.Scanner;

import com.sun.java.util.jar.pack.Package;
import entidades.Usuario;
import getbyte.GetByte;
import search.Search;
import java.util.ArrayList;
import database.DataBase;
import entidades.Entidade;
import entidades.Pergunta;
import entidades.Unidade;

/**
 * @author Vinicius Francisco da Silva
 * @author Stefany Gaspar
 * @param <T>
 */
public class ArquivoSequencial<T extends Entidade>{
    public static Scanner scanner;
    public static final Search search = new Search();
    public static final ByteArrayOutputStream byteoutputstream = new ByteArrayOutputStream();
    public static final DataOutputStream dataoutputstream = new DataOutputStream(byteoutputstream);

    public void cadastro(T valor,DataBase<T> db) throws Exception{
        assert dataoutputstream != null && db.getRandomacessfile() != null;
        switch (db.getNome()){
            case "Usuario":
                try{
                    dataoutputstream.writeUTF(String.valueOf(valor.getId()));
                    dataoutputstream.writeUTF(
                            String.valueOf(valor.getAcess("getClassificacaoGeral")));
                    dataoutputstream.writeUTF(valor.getAcess("getNome"));
                    dataoutputstream.writeUTF(valor.getAcess("getLogin"));
                    dataoutputstream.writeUTF(valor.getAcess("getEmail"));
                    dataoutputstream.writeUTF(valor.getAcess("getSenha"));

                    db.getRandomacessfile().seek(db.getRandomacessfile().length());
                    db.getRandomacessfile().writeShort(dataoutputstream.size());
                    db.getRandomacessfile().write(byteoutputstream.toByteArray());
                }catch(Exception e){
                    e.printStackTrace();
                }// End catch
                break;

            case "Pergunta":
                try{
                    RandomAccessFile arquivo = db.getRandomacessfile();
                    long pontoDeInsercao;
                    FileOutputStream tmp;

                    //Acha o ponto de insercao do registro e o guarda
                    Pergunta perguntaLida = (Pergunta)ler(db);
                    while (arquivo.getFilePointer() < arquivo.length() && perguntaLida.getUnidadeId() < Byte.parseByte(valor.getAcess("getUnidadeId"))) {
                        perguntaLida = (Pergunta)ler(db);
                    }
                    pontoDeInsercao = arquivo.getFilePointer();

                    //Copia os registros que precisam ser movidos para um arquivo temporario
                    if (arquivo.getFilePointer() != arquivo.length()) {
                        tmp = new FileOutputStream(new File("tmp"));
                        tmp.getChannel().transferFrom(arquivo.getChannel(), arquivo.getFilePointer(), arquivo.length() - arquivo.getFilePointer());
                    }

                    //Volta o file pointer para o ponto de insercao e escreve o novo registro
                    arquivo.seek(pontoDeInsercao);
                    dataoutputstream.writeInt(valor.getId());
                    dataoutputstream.writeByte(Byte.parseByte(valor.getAcess("getQuantidadeDeAlternativas")));
                    dataoutputstream.writeByte(Byte.parseByte(valor.getAcess("getAlternativaCorreta")));
                    dataoutputstream.writeUTF(valor.getAcess("getPergunta"));
                    dataoutputstream.writeByte(Byte.parseByte(valor.getAcess("getUnidadeId")));

                    //Escreve os registros movidos de volta
                    if (tmp != null)
                        arquivo.getChannel().transferFrom(tmp.getChannel(), 0, tmp.getChannel().size());

                    db.getRandomacessfile().writeShort(dataoutputstream.size());
                    db.getRandomacessfile().write(byteoutputstream.toByteArray());
                }catch(Exception e){
                    e.printStackTrace();
                }// End catch
                break;
            case "Unidade":
                try{
                    db.getRandomacessfile().seek(db.getRandomacessfile().length());

                    dataoutputstream.writeShort(valor.getId());
                    dataoutputstream.writeByte(Byte.parseByte(valor.getAcess("getClassificacao")));
                    dataoutputstream.writeUTF(valor.getAcess("getNome"));

                    db.getRandomacessfile().writeShort(dataoutputstream.size());
                    db.getRandomacessfile().write(byteoutputstream.toByteArray());
                }catch(Exception e){
                    e.printStackTrace();
                }// End catch
                break;
            default: throw new Exception("erro: "); // End else
        }// End switch
    }// End ler()

    public T ler(DataBase<T> db) throws IOException{
        int tamanho = db.getRandomacessfile().readShort();
        byte[] array = new byte[tamanho];
        if(db.getRandomacessfile().read(array) != tamanho){
            throw new IOException("erro");
        }// End if
        ByteArrayInputStream registro = new ByteArrayInputStream(array);
        DataInputStream entrada = new DataInputStream(registro);
        int codigo = entrada.readInt();
        switch(db.getNome()){
            case "Usuario":
                int classificacao = entrada.readInt();
                String nome = entrada.readUTF();
                String login = entrada.readUTF();
                String email = entrada.readUTF();
                String senha = entrada.readUTF();
                return (T)new Usuario(codigo,classificacao,nome,login,email,senha);

            case "Pergunta":
                byte quantidadeDeAlternativas = entrada.readByte();
                byte alternativaCorreta = entrada.readByte();
                String pergunta = entrada.readUTF();
                byte unidadeId = entrada.readByte();
                return (T)new Pergunta(codigo,quantidadeDeAlternativas,alternativaCorreta,pergunta);

            case "Unidade":
                byte classificacaogeral = entrada.readByte();
                String nomeunidade = entrada.readUTF();
                return (T)new Unidade(codigo,classificacaogeral,nomeunidade);

            default: return null;
        }// End switch
    }// End ler()

    // Modificar a parte de interação com o usuario
    public boolean atualizar(Cadastro<T> cd,int codigo) throws Exception{
        System.out.println("========== ATUALIZAR ========== ");
        long pointer = -1;
        boolean resp = false;
        switch(cd.getDb().getNome()){
            case "Usuario":
                pointer = search.pesquisaSequencial(cd,codigo);
                if(pointer != -1){
                    try{

                        System.out.println("[ ======= DESEJA ATUALIZAR? [S] SIM / [N] NÃO ======= ]\n");
                        char chr = ' ';
                        try{
                            chr = scanner.next().charAt(0);
                        }catch(Exception e){ e.printStackTrace();}// End catch
                        if(chr == 'S' || chr == 's' || chr == 'y' || chr == 'Y'){
                            // Alterar no arquivo
                            resp = true;
                            System.out.println("Usuário alterado com sucesso!");
                        }// End if
                        else if(chr == 'N' || chr == 'n'){
                            //    clone = null;
                        }// End else
                    }catch(Exception e){ e.printStackTrace(); }// End catch
                }else{
                    System.out.println("Usuário não existe!");
                }// fim else
                break;
            case "Pergunta":


            case "Unidade":

            default: throw new Exception("Erro");
        }// End switch
        return false;
    }// End atualizar()

    // Modificar a parte de interação com o usuario

    /**
     *
     * @param cd
     * @param codigo
     * @throws Exception
     */
    public void remove(Cadastro<T> cd,int codigo) throws Exception{
        System.out.println("========== REMOVER ========== ");
        if(cd.getDb().getNome().equals("Usuario")){
            long pos = search.pesquisaSequencial(cd,codigo);
            if(pos != -1){
                // remove usando lapide no arquivo
                System.out.println("Usuário removido com sucesso");
            }else{
                System.out.println("Usuário não existe!");
            }// End else
        }else if(cd.getDb().getNome().equals("Pergunta")){

        }else if(cd.getDb().getNome().equals("Unidade")){

        }// End else if
    }// End remove()
}// End class ArquivoSequencial
