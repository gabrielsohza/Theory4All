/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import arquivosequencial.ArquivoSequencial;
import entidades.Entidade;
import entidades.Pergunta;
import entidades.Usuario;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.RandomAccessFile;
import java.util.ArrayList;

/**
 *
 * @author Vinicius Francisco da Silva
 */
public class DataBase<T extends Entidade>{
    private String nome;
    private RandomAccessFile randomacessfile; 
    private ArquivoSequencial<T> arquivo;
    
    /**
     * 
     */
    public DataBase(){
        randomacessfile = null;
        arquivo = new ArquivoSequencial<>();
    }// End DataBase

    /**
     * 
     * @return 
     */
    public String getNome(){
        return nome;
    }// End getNome()

    /**
     * 
     * @param nome 
     */
    public void setNome(String nome){
        this.nome = nome;
    }// End setNome()
    
    public ArquivoSequencial<T> getArquivo(){
        return arquivo;
    }// End getArquivo()

    public void setArquivo(ArquivoSequencial<T> arquivo){
        this.arquivo = arquivo;
    }// End setArquivo

    public RandomAccessFile getRandomacessfile(){
        return randomacessfile;
    }// End getRandomacessfile()

    public void setRandomacessfile(RandomAccessFile randomacessfile){
        this.randomacessfile = randomacessfile;
    }// End setRandomacessfile()
    
    /**
     * 
     * @param nome
     * @param format
     * @return 
     */
    public boolean createTable(String nome, String format){
        assert this.randomacessfile != null;
        boolean resp = false;
        setNome(nome);
        try{
            this.randomacessfile = new RandomAccessFile(nome + ".db",format);
            resp = true;
        }catch(Exception e){
            e.printStackTrace();
        }// End catch
        return resp;
    }// End createTable()
}// End DataBase