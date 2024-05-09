import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

class InterfaceGrafica extends JFrame implements ActionListener {
    private JTextField xMinField, xMaxField, yMinField, yMaxField;
    private JButton button;
    private JTextArea resultArea;

    public InterfaceGrafica() {
        setTitle("Cohen-Sutherland");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(5, 2));

        panel.add(new JLabel("xMin:"));
        xMinField = new JTextField();
        panel.add(xMinField);

        panel.add(new JLabel("xMax:"));
        xMaxField = new JTextField();
        panel.add(xMaxField);

        panel.add(new JLabel("yMin:"));
        yMinField = new JTextField();
        panel.add(yMinField);

        panel.add(new JLabel("yMax:"));
        yMaxField = new JTextField();
        panel.add(yMaxField);

        button = new JButton("Recortar");
        button.addActionListener(this);
        panel.add(button);

        resultArea = new JTextArea();
        resultArea.setEditable(false);
        add(panel, BorderLayout.NORTH);
        add(new JScrollPane(resultArea), BorderLayout.CENTER);
    }

    public void actionPerformed(ActionEvent e) {
        double xMin = Double.parseDouble(xMinField.getText());
        double xMax = Double.parseDouble(xMaxField.getText());
        double yMin = Double.parseDouble(yMinField.getText());
        double yMax = Double.parseDouble(yMaxField.getText());

        resultArea.setText("");

        ArrayList<Linha> linhas = new ArrayList<>();
        int numLinhas = Integer.parseInt(JOptionPane.showInputDialog("Informe o número de linhas:"));

        for (int i = 0; i < numLinhas; i++) {
            double x1 = Double.parseDouble(JOptionPane.showInputDialog("Informe x1 para a linha " + (i + 1) + ":"));
            double y1 = Double.parseDouble(JOptionPane.showInputDialog("Informe y1 para a linha " + (i + 1) + ":"));
            double x2 = Double.parseDouble(JOptionPane.showInputDialog("Informe x2 para a linha " + (i + 1) + ":"));
            double y2 = Double.parseDouble(JOptionPane.showInputDialog("Informe y2 para a linha " + (i + 1) + ":"));
            linhas.add(new Linha(new Ponto(x1, y1), new Ponto(x2, y2)));
        }

        resultArea.append("Linhas recortadas:\n");

        for (Linha linha : linhas) {
            Linha linhaRecortada = CohenSutherland.clipar(linha, xMin, xMax, yMin, yMax);
            if (linhaRecortada != null) {
                resultArea.append("Linha (" + linhaRecortada.getP1().getX() + ", " + linhaRecortada.getP1().getY() +
                        ") para (" + linhaRecortada.getP2().getX() + ", " + linhaRecortada.getP2().getY() + ")\n");
            } else
                resultArea.append("Fora do corte\n");
        }
    }

    public static void main(String[] args) {
        InterfaceGrafica gui = new InterfaceGrafica();
        gui.setVisible(true);
    }
}
