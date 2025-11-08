package operaciones;

public class Complemento {
    private boolean signo;
    private static final int[] numeroBits = {8, 16, 32};

    //TODO reemplazar metodo esBinario por Conversion.esValido
    private static boolean esBinario(String numero) {
    for (int i = 0; i < numero.length(); i++) {
        char caracter = numero.charAt(i); 
        if (caracter != '0' && caracter != '1') {
            System.out.println("El número contiene un carácter no binario: '" + caracter + "'");
            return false;
        }
    }
    System.out.println("El número es binario.");
    return true;
}

           //complemento 1 

         public static String complemento1(String numero) {
        if (!esBinario(numero)) {
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
