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
    protected DataBase<Usuario> db;

    public Cadastro(){
        this.db = new DataBase<Usuario>();
    }// End Cadastro()
     
    public DataBase<Usuario> getDb(){
        return db;
    }// End GetDb

    public void setDb(DataBase<Usuario> db){
        this.db = db;
    }// End setDb()
    
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


