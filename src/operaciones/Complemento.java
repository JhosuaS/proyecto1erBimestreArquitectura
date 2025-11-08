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
            return Conversion.bin2dec(numero);
        } else {
            // Complemento a 1
            String c1 = "";
            for (int i = 0; i < numero.length(); i++) {
                char bit = numero.charAt(i);
                if (bit == '0') {
                    c1 += '1';
                } else {
                    c1 += '0';
                }
            }

           
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

            int valor = Conversion.bin2dec(c2);
            return -valor;
        }
    }

    //Paso A (Representación): Convertir el número decimal a su representación binaria
    public static String decimalACa2(int numero, int bits) {
        // Calcular mínimo y máximo representable
        int minimo = 1;
        for (int i = 1; i < bits; i++) minimo *= 2;
        minimo = -minimo;

        int maximo = 1;
        for (int i = 1; i < bits; i++) maximo *= 2;
        maximo = maximo - 1;

        if (numero < minimo || numero > maximo) {
            return "Error: overflow. No se puede representar " + numero + " en " + bits + " bits.";
        }

        String binario;
        if (numero >= 0) {
            binario = Conversion.dec2bin(numero);
            while (binario.length() < bits) {
                binario = '0' + binario;
            }
            return binario;
        } else {
            int valorAbs = numero;
            if (valorAbs < 0) valorAbs = -valorAbs;

            binario = Conversion.dec2bin(valorAbs);
            while (binario.length() < bits) {
                binario = '0' + binario;
            }

            return complemento2(binario);
        }
    }
    
}
