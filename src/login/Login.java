/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package login;

import cadastro.Cadastro;
import database.DataBase;
import entidades.Usuario;
import java.util.ArrayList;

/**
 *
 * @author Vinicius Francisco da Silva
 */
public class Login{
    
    /**
     * 
     * @param list 
     */
    public Login(){
        //this. = ;
    }// End Login()
 
    /**
     * 
     * @param nome
     * @param senha
     * @return 
     */
    public boolean validaLogin(String nome, String senha, Cadastro cd){
        boolean resp = false;
        for(int i = 0; i < cd.getDb().getArrayList().size(); i++){
            if(cd.getDb().getArrayList().get(i).getLogin().equals(nome) && 
                    cd.getDb().getArrayList().get(i).getSenha().equals(senha)){
                    resp = true;
                i = cd.getDb().getArrayList().size();
            }// End if
        }// End for
        return resp;                     
    }// End validaLogin()    
}// End Login
