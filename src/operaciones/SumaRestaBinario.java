package operaciones;

public class SumaRestaBinario {
    public static String[] igualarLongitud(String a, String b) {
        int max = Math.max(a.length(), b.length());

        while (a.length() < max) a = "0" + a;
        while (b.length() < max) b = "0" + b;

        return new String[]{a, b};
    }

   
    public static String sumar(String n1, String n2) {

        
        String iguales[] = igualarLongitud(n1, n2);
        n1 = iguales[0];
        n2 = iguales[1];

        String resultado = "";
        int carry = 0;

       
        for (int i = n1.length() - 1; i >= 0; i--) {

            int bit1 = n1.charAt(i) - '0';
            int bit2 = n2.charAt(i) - '0';

            int suma = bit1 + bit2 + carry;

            resultado = (suma % 2) + resultado;
            carry = suma / 2;
        }

        if (carry == 1)
            resultado = "1" + resultado;

        return resultado;
    }

    
    public static String restar(String n1, String n2) {

        
        String comp2 = Complemento.complemento2(n2);

        return sumar(n1, comp2);
    }

    
    public static String operar(String num1, String num2, char operacion) {

        boolean negativo1 = num1.startsWith("-");
        boolean negativo2 = num2.startsWith("-");

       
        if (negativo1) num1 = num1.substring(1);
        if (negativo2) num2 = num2.substring(1);

       
        if (!num1.matches("[01]+") || !num2.matches("[01]+")) {
            return "Error: números no binarios.";
        }

        String resultado = "";


        if (operacion == '+') {

            if (!negativo1 && !negativo2) {
                
                resultado = sumar(num1, num2);

            } else if (negativo1 && negativo2) {
                
                resultado = "-" + sumar(num1, num2);

            } else if (negativo1 && !negativo2) {
                
                resultado = restar(num2, num1);

            } else { 
                
                resultado = restar(num1, num2);
            }
        }

        if (operacion == '-') {

            if (!negativo1 && !negativo2) {
                
                resultado = restar(num1, num2);

            } else if (negativo1 && negativo2) {
                
                resultado = restar(num2, num1);

            } else if (negativo1 && !negativo2) {
                
                resultado = "-" + sumar(num1, num2);

            } else {
                
                resultado = sumar(num1, num2);
            }
        }

        return resultado;
    }
}
