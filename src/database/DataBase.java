/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.ArrayList;

/**
 *
 * @author Vinicius Francisco da Silva
 */
public class DataBase{
    private String nome;
    private FileOutputStream fileoutputstream;
    private FileInputStream fileinputstream;
    private DataOutputStream dataoutputstream;
    private DataInputStream datainputstream;
    //public ArrayList<> arrayList;
    
    /**
     * 
     */
    public DataBase(){
        fileoutputstream = null;
        fileoutputstream = null;
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

    /**
     * 
     * @return 
     */
    public FileOutputStream getFileoutputstream(){
        return fileoutputstream;
    }// End getFileoutputstream()

    /**
     * 
     * @param fileoutputstream 
     */
    public void setFileoutputstream(FileOutputStream fileoutputstream){
        this.fileoutputstream = fileoutputstream;
    }// End setFileoutputstream()

    /**
     * 
     * @return 
     */
    public FileInputStream getFileinputstream(){
        return fileinputstream;
    }// End getFileinputstream()

    /**
     * 
     * @param fileinputstream 
     */
    public void setFileinputstream(FileInputStream fileinputstream){
        this.fileinputstream = fileinputstream;
    }// End setFileinputstream()

    public DataOutputStream getDataoutputstream(){
        return dataoutputstream;
    }// End getDataoutputstream()

    public void setDataoutputstream(DataOutputStream dataoutputstream){
        this.dataoutputstream = dataoutputstream;
    }// End setDataoutputstream()

    public DataInputStream getDatainputstream(){
        return datainputstream;
    }// End getDatainputstream()

    public void setDatainputstream(DataInputStream datainputstream) {
        this.datainputstream = datainputstream;
    }// End setDatainputstream()
     
    /**
     * 
     * @param nome
     * @param format
     * @return 
     */
    public boolean createTable(String nome, String format){
        boolean resp = false;
        try{
            if(format.equals("w") && fileoutputstream == null){
                fileoutputstream = new FileOutputStream(nome);
                dataoutputstream = new DataOutputStream(fileoutputstream);
                resp = true;
            }// End
            else if(format.equals("r") && fileoutputstream == null){
                fileinputstream = new FileInputStream(nome);
                datainputstream = new DataInputStream(fileinputstream);
                resp = true;
            }// End else if
            else if(format.equals("rw") || format.equals("wr") && fileoutputstream == null && fileinputstream == null){
                fileoutputstream = new FileOutputStream(nome);
                dataoutputstream = new DataOutputStream(fileoutputstream);
                fileinputstream = new FileInputStream(nome);
                datainputstream = new DataInputStream(fileinputstream);
                resp = true;
            }// End else if
        }catch(Exception e){
            e.printStackTrace();
        }// End catch
        return resp;
    }// End createTable()
}// End DataBase
