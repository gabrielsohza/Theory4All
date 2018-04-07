/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cadastro;

import database.DataBase;
import entidades.Usuario;
import java.util.ArrayList;

/**
 *
 * @author Vinicius Francisco da Silva
 */
public class Cadastro{
     DataBase<Usuario> db;

    public Cadastro(DataBase<Usuario> db){
        this.db = db;
    }// End Cadastro()
    
    public boolean exist(String login){
        boolean resp = false;
        for(int i = 0; i < db.getArrayList().size(); i++){
            if(db.getArrayList().get(i).getLogin().equals(login)){
                resp = true;
                i = db.getArrayList().size();
            }// End if
        }// End for
        return resp;
    }// End exist()
}// End class Cadastro


