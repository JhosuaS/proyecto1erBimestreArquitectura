package operaciones;

public class Conversion {
    public static boolean esValido(String cadena, int numero, int base) {
        switch(base) {
            case 2:
                for(int i = 0; i < cadena.length(); i++) {
                    char c = cadena.charAt(i);
                    if(c != '0' && c != '1') {
                        return false;
                    }
                } return true;
            case 8:
                boolean encontradoOct = true;
                char [] octales = {'0','1','2','3','4','5','6','7'};
                for(int i = 0; i < cadena.length(); i++) {
                    for(int j = 0; j < octales.length; j++) {
                        if(cadena.charAt(i) == octales[j]) {
                            encontradoOct = true;
                            break;
                        } else {
                            encontradoOct = false;
                        }
                    }
                    if(!encontradoOct) {
                        break;
                    } 
                }
                return encontradoOct;
            case 10:
                return (numero >= 0);
            case 16:
                char [] hexadecimales = {'0','1','2','3','4','5','6','7','8','9','A','B','C','D','E','F'};
                boolean encontradoHex = true;
                for(int i = 0; i < cadena.length(); i++) {
                    for(int j = 0; j < hexadecimales.length; j++) {
                        if(cadena.charAt(i) == hexadecimales[j]) {
                            encontradoHex = true;
                            break;
                        } else {
                            encontradoHex = false;
                        }
                    }
                    if(!encontradoHex) {
                        break;
                    } 
                }
                return encontradoHex;
            default:
                return false;
        }
    }

    public static String dec2bin(int numero) {
        if(numero == 0) {
            return "0";
        }else if(esValido(null, numero, 10)) {
            String resultado = "";
            while(numero >0) {
                resultado = (numero % 2) + resultado;
                numero = numero / 2;
            }
            return resultado;
        }else {
            return "Número inválido";
        }
    }

    public static String dec2oct(int numero) {
        if(numero == 0) {
            return "0";
        }else if(esValido(null, numero, 10)) {
            String resultado = "";
            while(numero >0) {
                resultado = (numero % 8) + resultado;
                numero = numero / 8;
            }
            return resultado;
        }else {
            return "Número inválido";
        }
    }
    
    public static String dec2hex(int numero) {
        if(numero == 0) {
            return "0";
        }else if (esValido(null, numero, 10)){
            String resultado = "";
            while(numero >0) {
                int residuo = numero % 16;
                if(residuo >= 10) {
                    switch (residuo) {
                        case 10:
                            resultado = "A" + resultado;
                            break;
                        case 11:
                            resultado = "B" + resultado;
                            break;
                        case 12:
                            resultado = "C" + resultado;
                            break;
                        case 13:
                            resultado = "D" + resultado;
                            break;
                        case 14:
                            resultado = "E" + resultado;
                            break;
                        case 15:
                            resultado = "F" + resultado;
                            break;
                        default:
                            continue;
                    }
                }
                resultado = (residuo) + resultado;
                numero = numero / 16;
            }
            return resultado;
        }else {
            return "Número inválido";
        }
    }

    public static int bin2dec(String numero) {
        if(numero.equals("0")) {
            return 0;
        } else if(esValido(numero, 0, 2)) {
            int resultado = 0;
            for(int i = 0; i < numero.length(); i++) {
                char c = numero.charAt(numero.length() - 1 - i);
                if(c == '1') {
                    resultado += Math.pow(2, i);
                }
            }
            return resultado;
        }else {
            return -1;
        }
    }

    public static int oct2dec(String numero) {
        if(numero.equals("0")) {
            return 0;
        } else if(esValido(numero, 0, 8)) {
            int resultado = 0;
            for(int i = 0; i < numero.length(); i++) {
                int c = (int)(numero.charAt(numero.length() - 1 - i)) - 48;
                System.out.println(c);
                resultado += c * Math.pow(8, i);
            }
            return resultado;
        }else {
            return -1;
        }
    }

    public static int hex2dec(String numero) {
        numero = numero.toUpperCase();
        if(numero.equals("0")) {
            return 0;
        } else if(esValido(numero, 0, 16)) {
            int resultado = 0;
            for(int i = 0; i < numero.length(); i++) {
                char c = numero.charAt(numero.length() - 1 - i);
                int valor;
                if(c >= '0' && c <= '9') {
                    valor = (int)c - 48;
                } else {
                    switch(c) {
                        case 'A':
                            valor = 10;
                            break;
                        case 'B':
                            valor = 11;
                            break;
                        case 'C':
                            valor = 12;
                            break;
                        case 'D':
                            valor = 13;
                            break;
                        case 'E':
                            valor = 14;
                            break;
                        case 'F':
                            valor = 15;
                            break;
                        default:
                            valor = 0;
                    }
                }
                resultado += valor * Math.pow(16, i);
            }
            return resultado;
        }else {
            return -1;
        }
    }
}
