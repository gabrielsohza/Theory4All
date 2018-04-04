/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package theory4all;
/**
 *
 * @author Vinicius Francisco da Silva
 */
class GetByte{
    public static final int BYTE = (Byte.SIZE / 8);
    public static final int SHORT = (Short.SIZE / 8);
    public static final int INTEGER = (Integer.SIZE / 8);
    public static final int LONG = (Long.SIZE / 8);
    public static final int FLOAT = (Float.SIZE / 8);
    public static final int DOUBLE = (Double.SIZE / 8);
    public static final int CHAR_ASCII = (Character.SIZE / 8); // Valor em Bytes de um caractér sem acentuação. Valor ASCII
    public static final int CHAR = ((Character.SIZE / 8) + 1); // Valor em Bytes de um caractér com acentuação.

    /**
     * 
     * @param str
     * @return 
     */
    public static int getByte(String str){
        int valor = 0;
        for(int i = 0; i < str.length(); i++){
            if((int)str.charAt(i) >= 32 && (int)str.charAt(i) <= 126){
                valor += CHAR_ASCII;
            }// End if
            else{
                valor += CHAR;
            }// End else if
        }// End for
        return valor;
    }// End getByte()
}// End class GetByte
