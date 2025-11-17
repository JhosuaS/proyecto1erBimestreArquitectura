import operaciones.*;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        SumaRestaBin operaciones = new SumaRestaBin();

        int opcion;

        do {
            System.out.println("\n===== MENÚ DE OPERACIONES =====");
            System.out.println("1. Conversiones de bases");
            System.out.println("2. Complementos binarios");
            System.out.println("3. Suma y Resta Binaria");
            System.out.println("0. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = sc.nextInt();
            sc.nextLine();
            switch (opcion) {
                case 1:
                    System.out.println("\n--- CONVERSIONES ---");
                    System.out.println("1. Decimal a otras bases");
                    System.out.println("2. Binario / Octal / Hexadecimal a Decimal");
                    System.out.print("Seleccione una opción: ");
                    int sub = sc.nextInt();
                    sc.nextLine();

                    if (sub == 1) {
                        System.out.print("Ingrese un número decimal: ");
                        int numero = sc.nextInt();

                        System.out.println("Binario: " + Conversion.dec2bin(numero));
                        System.out.println("Octal: " + Conversion.dec2oct(numero));
                        System.out.println("Hexadecimal: " + Conversion.dec2hex(numero));
                    } else if (sub == 2) {
                        System.out.println("1. Binario a Decimal");
                        System.out.println("2. Octal a Decimal");
                        System.out.println("3. Hexadecimal a Decimal");
                        System.out.print("Seleccione una opción: ");
                        int sub2 = sc.nextInt();
                        sc.nextLine();

                        switch (sub2) {
                            case 1:
                                System.out.print("Ingrese número binario: ");
                                String bin = sc.nextLine();
                                System.out.println("Decimal: " + Conversion.bin2dec(bin));
                                break;
                            case 2:
                                System.out.print("Ingrese número octal: ");
                                String oct = sc.nextLine();
                                System.out.println("Decimal: " + Conversion.oct2dec(oct));
                                break;
                            case 3:
                                System.out.print("Ingrese número hexadecimal: ");
                                String hex = sc.nextLine();
                                System.out.println("Decimal: " + Conversion.hex2dec(hex));
                                break;
                        }
                    }
                    break;
      case 2:
       System.out.println("\n--- COMPLEMENTOS BINARIOS ---");
       System.out.println("1. Decimal a complemento a 2");
       System.out.println("2. Binario (complemento a 2) a Decimal");
       System.out.println("3. Binario a Complemento 1 y 2 ");
       System.out.print("Seleccione una opción: ");
       int subComp = sc.nextInt();
       sc.nextLine();

         switch (subComp) {
                  case 1:
                        System.out.print("Ingrese un número decimal : ");
                        int numero = sc.nextInt();
                        System.out.print("Ingrese la cantidad de bits (8, 16 o 32): ");
                        int bits = sc.nextInt();

                        String resultado = Complemento.decimalAComplemento2(numero, bits);
                        System.out.println("Representación en complemento a 2: " + resultado);
                        break;
                  case 2:
                        System.out.print("Ingrese el número binario en complemento a 2: ");
                        String bin = sc.nextLine();

                        int dec = Complemento.Complemento2ADecimal(bin);
                        System.out.println("Equivalente decimal: " + dec);
                        break;
                 case 3
                        System.out.print("Ingrese número binario: ");
                        String num = sc.nextLine();

                        System.out.println("Complemento a 1: " + Complemento.complemento1(num));
                        System.out.println("Complemento a 2: " + Complemento.complemento2(num));
                        break;
        default:
            System.out.println("Opción no válida en el menú de complementos.");
    }
    break;

            case 3:
    System.out.println("\n--- SUMA Y RESTA BINARIA (Complemento a 2) ---");
    System.out.println("1. Sumar binarios");
    System.out.println("2. Restar binarios");
    System.out.print("Seleccione una opción: ");
    int opBin = sc.nextInt();
    sc.nextLine();

    System.out.print("Ingrese el primer número binario: ");
    String bin1 = sc.nextLine();

    System.out.print("Ingrese el segundo número binario: ");
    String bin2 = sc.nextLine();

    if (!bin1.matches("[01]+") || !bin2.matches("[01]+")) {
        System.out.println(" Error: ingrese solo números binarios.");
        break;
    }
                    
    String[] iguales = SumaRestaBinario.igualarLongitud(bin1, bin2);
    bin1 = iguales[0];
    bin2 = iguales[1];

    String resultado = "";

    if (opBin == 1) {
        resultado = SumaRestaBinario.sumar(bin1, bin2);
    } else {
        resultado = SumaRestaBinario.restar(bin1, bin2);
    }
                    
    if (resultado.length() > bin1.length()) {
        resultado = resultado.substring(1);
        System.out.println(" Overflow detectado (se descartó bit extra).");
    }

    System.out.println("\nResultado en complemento a 2: " + resultado);
                    
    break;



                case 0:
                    System.out.println("Saliendo del programa...");
                    break;

                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
            }

        } while (opcion != 0);

        sc.close();
    }
}
