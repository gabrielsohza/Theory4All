/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package theory4all;

/**
 *
 * @author Stefany Gaspar
 */
class Pergunta{
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
}// End class pergunta
