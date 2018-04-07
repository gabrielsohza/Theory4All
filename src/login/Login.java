/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package login;

import database.DataBase;
import entidades.Usuario;
import java.util.ArrayList;

/**
 *
 * @author Vinicius Francisco da Silva
 */
public class Login{
    DataBase<Usuario> db = new DataBase<>();
    
    /**
     * 
     * @param list 
     */
    public Login(DataBase<Usuario> db){
        this.db = db;
    }// End Login()
    
    /**
     * 
     * @param nome
     * @param senha
     * @return 
     */
    public boolean validaLogin(String nome, String senha){
        boolean resp = false;
        for(int i = 0; i < db.getArrayList().size(); i++){
            if(db.getArrayList().get(i).getLogin().equals(nome)){
                resp = true;
                i = db.getArrayList().size();
            }// End if
        }// End for
        return resp;
    }// End validaLogin()    
}// End Login
