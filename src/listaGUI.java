import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class listaGUI extends JFrame {
    private listaC lista;
    private JTextArea areaResultados;
    private JTextField campoValor;

    // Botones
    private JButton agregarButton;
    private JButton eliminarButton;
    private JButton buscarButton;
    private JButton ordenarButton;

    // Panel para contener los componentes gráficos
    private JPanel pGeneral;

    public listaGUI() {
        lista = new listaC();  // Instancie listaC

        agregarButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    int valor = Integer.parseInt(campoValor.getText());
                    lista.insertar(valor);
                    actualizarResultado();
                    campoValor.setText("");
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Por favor ingrese un número válido.");
                }
            }
        });

        eliminarButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    int valor = Integer.parseInt(campoValor.getText());
                    lista.eliminar(valor);  // Usamos el objeto listaC para eliminar
                    actualizarResultado();
                    campoValor.setText("");
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Por favor ingrese un número válido.");
                }
            }
        });

        buscarButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    int valor = Integer.parseInt(campoValor.getText());
                    Nodo resultado = lista.buscar(valor);  // Usamos el objeto listaC para buscar
                    if (resultado != null) {
                        areaResultados.setText("Elemento encontrado: " + resultado.valor);
                    } else {
                        areaResultados.setText("Elemento no encontrado.");
                    }
                    campoValor.setText("");
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Por favor ingrese un número válido.");
                }
            }
        });

        ordenarButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                lista.ordenar();
                actualizarResultado();
            }
        });
    }



    private void actualizarResultado() {
        areaResultados.setText("Lista: " + lista.mostrar());
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("listaGUI");
        frame.setContentPane(new listaGUI().pGeneral);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
