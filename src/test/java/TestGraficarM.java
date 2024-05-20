import javax.swing.*;
import plot.graficarM;

public class TestGraficarM {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                crearYMostrarGUI();
            }
        });
    }

    private static void crearYMostrarGUI() {
        JFrame frame = new JFrame("Test graficarM");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Crear la instancia de graficarM
        graficarM panelGrafico = new graficarM();
        frame.add(panelGrafico);

        // Generar datos de prueba
        double[][] datosPrueba = generarDatosDePrueba(-Math.PI, Math.PI, 0.1);
        panelGrafico.grafico(datosPrueba);

        // Configuraciones del frame
        frame.setSize(800, 600);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    private static double[][] generarDatosDePrueba(double inicio, double fin, double incremento) {
        int cantidad = (int) ((fin - inicio) / incremento) + 1;
        double[][] datos = new double[cantidad][2];

        int index = 0;
        for (double x = inicio; x <= fin; x += incremento) {
            datos[index][0] = x;
            datos[index][1] = Math.abs(Math.sin(x)); // Valor absoluto del seno
            index++;
        }
        return datos;
    }
}
