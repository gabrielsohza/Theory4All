/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sort;
import java.util.ArrayList;
import entidades.Usuario;
import entidades.Unidade;
import entidades.Pergunta;
/**
 *
 * @author Vinicius Francisco da Silva
 */
public class Sort{
   
   public static int pesquisaBinariaUsuario(ArrayList<Usuario> usuario, int id){
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
   
   public static int pesquisaBinariaUnidade(ArrayList<Unidade> unidade, int id){
        int esq = 0;
   	int dir = (unidade.size()-1);
   	int meio = -1;
   	while(esq <= dir){
   		meio = (esq+dir)/2;
   		if(id == unidade.get(meio).getId()){
                    esq = unidade.size();
   		}// End if
   		else if(id > unidade.get(meio).getId()){
                    esq = meio+1;
   		}// End else if
   		else{
                    dir = meio-1;
   		}// End if
   	}// End while
   	return meio;
   }// End pesquisaBinaria()
   
   public static int pesquisaBinariaPergunta(ArrayList<Pergunta> pergunta, int id){
        int esq = 0;
   	int dir = (pergunta.size()-1);
   	int meio = -1;
   	while(esq <= dir){
   		meio = (esq+dir)/2;
   		if(id == pergunta.get(meio).getId()){
                    esq = pergunta.size();
   		}// End if
   		else if(id > pergunta.get(meio).getId()){
                    esq = meio+1;
   		}// End else if
   		else{
                    dir = meio-1;
   		}// End if
   	}// End while
   	return meio;
   }// End pesquisaBinaria()
}// End class Sort
