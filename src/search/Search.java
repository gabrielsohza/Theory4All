/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package search;
import cadastro.Cadastro;
import entidades.Entidade;
/**
 * 
 * @author vinicius
 * @param <T> 
 */
public class Search<T extends Entidade>{
    /**
     * 
     * @param cd
     * @param id
     * @return
     * @throws Exception 
     */
    public long pesquisaSequencial(Cadastro<T> cd,int id) throws Exception{
        cd.getDb().getRandomacessfile().seek(0);
        int codigo;
        short size;
        long pointer;
        int i = 0;            
        while(i < cd.getDb().getRandomacessfile().length()){
            size = cd.getDb().getRandomacessfile().readShort();
            pointer = cd.getDb().getRandomacessfile().getFilePointer();
            codigo = cd.getDb().getRandomacessfile().readInt();
            if(codigo == id){
                return pointer;
            }// End if
            cd.getDb().getRandomacessfile().seek(size);
            i++;
        }// End while 
        return (long)-1;
    }// End pesquisaBinaria()
}// End class Sort
