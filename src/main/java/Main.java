
// Práctica 1 Algoritmos Genéticos - 6CM2
// Leyva Martínez Román Esteban
// Serrano Víctor

import java.util.Scanner; // Importamos utilería scanner
import javax.swing.*; // Importamos librerías Swing para GUI
import functions.*;
import plot.graficarM;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in); // Objeto Scanner

        boolean bandera = true; // Bandera para la terminación del programa
        char opcion; // Variable para decision de funcion
        int rango1, rango2, qm; // Rango que determina el usuario

        while (bandera) {
            // Menú
            System.out.println("¿Qué función desea evaluar?");
            System.out.println("-   a) f(x)= x^2");
            System.out.println("-   b) f(x)= ABS |(x-5)/(2+SEN(x))|");
            System.out.println("-   c) f(x)= ABS |(X-SEN(X))/((COS(X)*SEN(X))+4)|");
            System.out.println("-   for exit press 0 and then enter| para salir presione 0 y despues enter");
            opcion = scanner.next().charAt(0);

            if (opcion == '0') break;
            // Input handling for range and option selection
            do {
                System.out.println("¿Dónde inicia el rango a evaluar?");
                rango1 = scanner.nextInt();
                if (rango1 > 100) {
                    System.out.println("Este número está fuera de rango (0-100), vuelve a insertar un número");
                }
            } while (rango1 > 100);

            do {
                System.out.println("¿Dónde termina el rango a evaluar?");
                rango2 = scanner.nextInt();
                if (rango2 > 100) {
                    System.out.println("Este número está fuera de rango (0-100), vuelve a insertar un número");
                }
            } while (rango2 > 100);

            do {
                System.out.println("¿Desea minimizar o maximizar la función?");
                System.out.println("-   0) MIN");
                System.out.println("-   1) MAX");
                qm = scanner.nextInt();
                if (qm != 1 && qm != 0) {
                    System.out.println("Escoge una opción válida (0 o 1)");
                }
            } while (qm != 1 && qm != 0);

            // Create an instance of graficarM for plotting
            graficarM panelGrafico = new graficarM();

            // Function evaluations and calculations
            switch (opcion) {
                case 'a':
                    // Function f(x) = x^2
                    equiscuadrada.plotFunction(panelGrafico, rango1, rango2, qm);
                    break;
                case 'b':
                    // Function f(x) = ABS |(x-5)/(2+SEN(x))|
                    relleno.plotFunction(panelGrafico, rango1, rango2, qm);
                    break;
                case 'c':
                    // Function f(x) = ABS |(X-SEN(X))/((COS(X)*SEN(X))+4)|
                    valorABS.plotFunction(panelGrafico, rango1, rango2, qm);
                    break;
                default:
                    System.out.println("Opción no válida");
            }

            // Display the plot in a JFrame
            JFrame frame = new JFrame("Plotting Function");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.add(panelGrafico);
            frame.setSize(800, 600);
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
        }
    }
}
