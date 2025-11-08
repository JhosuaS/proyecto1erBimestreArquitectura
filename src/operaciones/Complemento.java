package operaciones;

public class Complemento {
    private boolean signo;
    private static final int[] numeroBits = {8, 16, 32
  //complemento 1                                          
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

    //complemento 2

       public static String complemento2(String numero) {
        if (!Conversion.esValido(numero, 0, 2)) {
            return "Error: el número ingresado no es binario.";
        }

        String c2 = "";
        boolean encontrado = false;


        for (int i = numero.length() - 1; i >= 0; i--) {
            char bit = numero.charAt(i);

            if (encontrado) {
  
                if (bit == '0') {
                    c2 = '1' + c2;
                } else {
                    c2 = '0' + c2;
                }
            } else {
                
                c2 = bit + c2;
                if (bit == '1') {
                    encontrado = true; 
                }
            }
        }

        return c2;
    }
    
    //Paso B (Verificación) de complemento 2 a decimal
  public static int ca2ADecimal(String numero) {
        if (!Conversion.esValido(numero, 0, 2)) {
            System.out.println("Error: el número no es binario.");
            return 0;
        }

        boolean esNegativo = numero.charAt(0) == '1'; 

        if (!esNegativo) {
    
            int decimal = 0;
            int potencia = 1;
            for (int i = numero.length() - 1; i >= 0; i--) {
                if (numero.charAt(i) == '1') {
                    decimal += potencia;
                }
                potencia *= 2;
            }
            return decimal;
        } else {

            String c1 = "";
            for (int i = 0; i < numero.length(); i++) {
                char bit = numero.charAt(i);
                if (bit == '0') c1 += '1';
                else c1 += '0';
            }

            // 2. Sumar 1 manualmente
            String c2 = "";
            int suma = 1;
            for (int i = c1.length() - 1; i >= 0; i--) {
                char bit = c1.charAt(i);
                if (bit == '0' && suma == 1) {
                    c2 = '1' + c2;
                    suma = 0;
                } else if (bit == '1' && suma == 1) {
                    c2 = '0' + c2;
                    suma = 1;
                } else {
                    c2 = bit + c2;
                }
            }

            // 3. Convertir el resultado a decimal
            int valor = 0;
            int potencia = 1;
            for (int i = c2.length() - 1; i >= 0; i--) {
                if (c2.charAt(i) == '1') {
                    valor += potencia;
                }
                potencia *= 2;
            }

            return -valor;
        }
    }

    
}
