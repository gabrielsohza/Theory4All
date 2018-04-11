/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package getbyte;
/**
 *
 * @author Vinicius Francisco da Silva
 */
public class GetByte{
    public static final int BYTE = (Byte.SIZE / 8);
    public static final int SHORT = (Short.SIZE / 8);
    public static final int INTEGER = (Integer.SIZE / 8);
    public static final int LONG = (Long.SIZE / 8);
    public static final int FLOAT = (Float.SIZE / 8);
    public static final int DOUBLE = (Double.SIZE / 8);
    public static final int CHAR_ASCII = (Character.SIZE / 8); // Valor em Bytes de um caractér sem acentuação. Valor ASCII
    public static final int CHAR = ((Character.SIZE / 8) + 1); // Valor em Bytes de um caractér com acentuação.
}// End class GetByte
