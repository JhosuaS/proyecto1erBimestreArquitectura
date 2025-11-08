package operaciones;

public class Complemento {
    private boolean signo;
    private static final int[] numeroBits = {8, 16, 32
                                            
 public static String complemento1(String numero) {
        if (!Conversion.esValido(numero, 0, 2)) { 
            return "Error: el número ingresado no es binario.";
        }

        String c1 = "";
        for (int i = 0; i < numero.length(); i++) {
            char bit = numero.charAt(i);
            if (bit == '0') {
                c1 += '1';
            } else {
                c1 += '0';
            }
        }
        return c1;
    }
    
    
}
