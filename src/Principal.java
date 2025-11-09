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
                    System.out.println("\n--- COMPLEMENTOS ---");
                    //TODO: implementar sub menú para conversión de decimal a complemento, y de complemento a decimal
                    //TODO: llamar los métodos Complemento2ADecimal y decimalAComplemento2
                    System.out.print("Ingrese número binario: ");
                    String num = sc.nextLine();

                    System.out.println("Complemento a 1: " + Complemento.complemento1(num));
                    System.out.println("Complemento a 2: " + Complemento.complemento2(num));
                    break;

                case 3:
                    System.out.println("\n--- SUMA Y RESTA BINARIA ---");
                    System.out.print("Ingrese el primer número binario: ");
                    String b1 = sc.nextLine();
                    System.out.print("Ingrese el segundo número binario: ");
                    String b2 = sc.nextLine();
                    //TODO: Descomentar cuando se implementen los métodos en la clase SumaRestaBin
                    //System.out.println("Suma: " + operaciones.suma(b1, b2));
                    //System.out.println("Resta: " + operaciones.resta(b1, b2));
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
