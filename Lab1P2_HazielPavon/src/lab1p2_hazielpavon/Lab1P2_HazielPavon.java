package lab1p2_hazielpavon;

import java.util.Scanner;
import javax.swing.JOptionPane;

public class Lab1P2_HazielPavon {

    public static void main(String[] args) {

        Scanner leer = new Scanner(System.in);

        boolean seguir = false;

        JOptionPane.showMessageDialog(null, "Te quiero Nuila");

        while (seguir == false) {

            System.out.println("Ingrese una opcion");
            System.out.println("1. Ejercicio 1");
            System.out.println("2. Ejercicio 2");
            System.out.println("3. salir");
            int opcion = leer.nextInt();

            switch (opcion) {

                case 1:
                    int a = 0;
                    boolean cero = false;

                    while (cero == false) {

                        System.out.println("Ingrese X: (nota: A no puede ser 0) ");
                        a = leer.nextInt();

                        if (a != 0) {
                            cero = true;

                        } else {
                            System.out.println("Ingrese un valor diferente a 0");
                            a = 0;
                        }

                    }

                    System.out.println("Ingrese B: ");
                    int b = leer.nextInt();

                    System.out.println("Ingrese C: ");
                    int c = leer.nextInt();

                    int cont = 0;

                    double ver = -b / (2 * a);
                    double derecha = ver - 200;
                    double izquierda = ver + 200;

                    double respderecha = newton(a, b, c, derecha, cont);

                    double respizquierda = newton(a, b, c, izquierda, cont);

                    System.out.println("La raiz encontrada es de: " + respderecha);

                    System.out.println("La raiz encontrada es de: " + respizquierda);

                    break;

                case 2:

                    System.out.println("Ingrese el valor de n (Sera el limite)");
                    int n = leer.nextInt();

                    System.out.println("Ingrese el a evaluar");
                    int num = leer.nextInt();

                    int contSin = 0;
                    int contCos = 0;

                    double respSin = 0;
                    double respCos = 0;

                    System.out.println("El Seno  de: " + num + " es: " + seno(n, num, respSin, contSin));

                    System.out.println("El Coseno de: " + num + " es: " + coseno(n, num, respCos, contCos));
                    
                     System.out.println("El Tangente de: " + num + " es: " + tangente(n, num, respCos, contCos));
                    break;

                case 3:

                    seguir = true;

                    break;

                default:

                    break;

            }

        }
    }

    public static double newton(int a, int b, int c, double x, int cont) {

        if (cont > 100) {
            return x;

        } else {
            double f = a * (x * x) + (b * x) + c;
            double f1 = 2 * (a * x) + b;
            double div = f / f1;
            x -= div;
            return newton(a, b, c, x, cont + 1);

        }
    }

    public static double seno(int n, int num, double resp, int cont) {

        if (n == cont) {
            return resp;

        } else {

            double ecu = Math.pow(-1.0, cont);
            double ecu2 = (2 * cont + 1);
            double ecu3 = fac(ecu2);
            double ecu4 = ecu / ecu3;
            double ecu5 = 2 * n + 1; 
            double ecu6 = Math.pow(num, ecu5);
            resp += ecu4 * ecu5;

            return seno(n, num, resp, cont + 1);

        }

    }

    public static double fac(double ecu) {
        double x = 1;
        for (int i = 1; i <= ecu; i++) {
            x = i * x;

        }

        return x;
    }

    public static double coseno(int n, int num, double resp, int cont) {

        if (n == cont) {
            return resp;

        } else {

            double ecu = Math.pow(-1.0, cont);
            double ecu2 = 2 * cont;
            double ecu3 = fac(ecu2);
            double ecu4 = ecu / ecu3;
            double ecu5 = 2 * n; 
            double ecu6 = Math.pow(num, ecu5); 
            resp += ecu4 * ecu5;

            return coseno(n, num, resp, cont + 1);

        }

    }

    public static double tangente(int n, int num, double resp, int cont) {
        double vali = 3.1415927;

        if (n == cont) {

            if (vali < resp) {

                return resp;
            }else{
                System.out.println("El valor es mayor a pi sobre dos");
                return 0; 
            }
        } else {

            double ecu = 2 * cont;
            double ecu2 = Math.pow(-4, cont);
            double ecu3 = Math.pow(3, cont);
            double ecu4 = (ecu * ecu3) + (ecu * ecu2);
            double ecu5 = (2 * cont);
            double ecu6 = fac(ecu5);
            double ecu7 = ecu4/ecu6; 
            double ecu8 = (2*n)-1; 
            double ecu9 = Math.pow(num, ecu8);
            resp += ecu9 * ecu7; 

            return tangente(n, num, resp, cont + 1);

        }

    }

}
