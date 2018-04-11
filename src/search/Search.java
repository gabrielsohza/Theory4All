/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package search;
import cadastro.Cadastro;
import entidades.Entidade;
import java.util.ArrayList;
import entidades.Usuario;
import entidades.Unidade;
import entidades.Pergunta;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
/**
 * @author Stefany Gaspar
 * @author Vinicius Francisco da Silva
 * @param <T>
 * @param <Unidade>
 * @param <Pergunta>
 */
public class Search<T extends Entidade>{
    private RandomAccessFile randomacessfile;
    
    /**
     *
     * @param value
     * @param id
     * @return
     */
    public T pesquisaSequencial(Cadastro cd,int id) throws Exception{
        randomacessfile = new RandomAccessFile(cd.getDb().getNome(),"rw");
        randomacessfile.seek(0);
        int codigo;
        while(true){    
            codigo = randomacessfile.readInt();
            if(codigo == id){
                
            }// End if    
        }// End while
        //return null;
    }// End pesquisaBinaria()
}// End class Sort
