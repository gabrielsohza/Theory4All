/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

/**
 * @author Stefany Gaspar
 * @author Vinicius Francisco da Silva
 */
public class Pergunta implements Entidade{
  private int id;
  private byte quantidadeDeAlternativas;
  private byte alternativaCorreta;
  private String pergunta;
  
  
  public int getId(){
       return id;
   }// End getId

   
   public void setId(int id){
       this.id = id;
   }// End setId()
   
   public byte getQuantidadeDeAlternativas(){
        return quantidadeDeAlternativas;
    }// End getQuantidadeDeAlternativas()

    public void setQuantidadeDeAlternativas(byte quantidadeDeAlternativas){
        this.quantidadeDeAlternativas = quantidadeDeAlternativas;
    }// End setQuantidadeDeAlternativas()

    
    public byte getAlternativaCorreta(){
         return alternativaCorreta;
     }// End getAlternativaCorreta()

     
     public void setAltenativaCorreta(byte alternativaCorreta){
         this.alternativaCorreta = alternativaCorreta;
     }// End setAlternativaCorreta()

     
     public String getPergunta(){
          return pergunta;
      }// End getAlternativaCorreta()
     
     
     public void setPergunta(String pergunta){
         this.pergunta = pergunta;
     }// End setAlternativaCorreta()
     
     public String getAcess(String metod){
         String str = null;
         if(metod.equals("getQuantidadeDeAlternativas")){
             str = String.valueOf(getQuantidadeDeAlternativas());
         }else if(metod.equals("getAlternativaCorreta")){
             str = String.valueOf(getAlternativaCorreta());
         }else if(metod.equals("getPergunta")){
             str = getPergunta();
         }// End else if
         return str;
     }// End metod
     
     public String setAcess(String metod,String value){
         String str = null;
         if(metod.equals("setQuantidadeDeAlternativas")){
             setQuantidadeDeAlternativas(Byte.parseByte(value));
         }else if(metod.equals("setAltenativaCorreta")){
             setAltenativaCorreta(Byte.parseByte(value));
         }else if(metod.equals("setPergunta")){
             setPergunta(value);
         }// End else if
         return str;
     }// End metod()
}// End class pergunta
