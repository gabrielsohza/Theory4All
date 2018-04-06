/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package search;
import entidades.Entidade;
import java.util.ArrayList;
import entidades.Usuario;
import entidades.Unidade;
import entidades.Pergunta;
/**
 * @author Stefany Gaspar
 * @author Vinicius Francisco da Silva
 * @param <T>
 * @param <Unidade>
 * @param <Pergunta>
 */
public class Search<T extends Entidade>{
    /**
     *
     * @param value
     * @param id
     * @return
     */
    public int pesquisaBinaria(ArrayList<T> value,int id){
        int esq = 0;
   	int dir = (value.size()-1);
   	int meio = -1;
   	while(esq <= dir){
   		meio = (esq+dir)/2;
   		if(id == value.get(meio).getId()){
                    esq = value.size();
   		}// End if
   		else if(id > value.get(meio).getId()){
                    esq = meio+1;
   		}// End else if
   		else{
                    dir = meio-1;
   		}// End if
   	}// End while
   	return meio;
   }// End pesquisaBinaria()
}// End class Sort
