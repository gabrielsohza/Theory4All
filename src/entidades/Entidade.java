/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

/**
 *
 * @author Vinicius Francisco da Silva
 */
public interface Entidade extends Cloneable{
    public int getId();
    public void setId(int id);
    public String getAcess(String metod);
    public String setAcess(String metod,String value);
}// End Entidade
