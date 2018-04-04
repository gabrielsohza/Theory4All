/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package theory4all;

import java.util.ArrayList;

/**
 *
 * @author vinicius
 */
class Sort{
   
   public int pesquisaBinaria(ArrayList<Usuario> usuario, int id){
        int esq = 0;
   	int dir = (usuario.size()-1);
   	int meio = -1;
   	while(esq <= dir){
   		meio = (esq+dir)/2;
   		if(id == usuario.get(meio).getId()){
                    esq = usuario.size();
   		}// End if
   		else if(id > usuario.get(meio).getId()){
                    esq = meio+1;
   		}// End else if
   		else{
                    dir = meio-1;
   		}// End if
   	}// End while
   	return meio;
   }// End pesquisaBinaria()
}// End class Sort
