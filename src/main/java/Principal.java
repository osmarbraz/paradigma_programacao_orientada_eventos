
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Principal {

    public static void main(String[] args) {

        // Cria a janela
        JFrame janela = new JFrame("Calculo do Triangulo");

        // Campos para entrada dos lados
        JTextField campoA = new JTextField(8);
        JTextField campoB = new JTextField(8);
        JTextField campoC = new JTextField(8);

        // Botao para realizar o calculo
        JButton botao = new JButton("Calcular");

        // Area para apresentar o resultado
        JLabel resultado = new JLabel("Informe os tres lados.");
        
        // Painel da interface
        JPanel painel = new JPanel(new GridLayout(5, 2, 5, 5));
        painel.add(new JLabel("Lado A:"));
        painel.add(campoA);
        painel.add(new JLabel("Lado B:"));
        painel.add(campoB);
        painel.add(new JLabel("Lado C:"));
        painel.add(campoC);
        painel.add(botao);
        painel.add(resultado);

        // Evento de clique no botao
        botao.addActionListener(e -> {
            try {
                double a = Double.parseDouble(campoA.getText());
                double b = Double.parseDouble(campoB.getText());
                double c = Double.parseDouble(campoC.getText());

                // Verifica se os lados formam um triangulo
                boolean valido
                        = a > 0 && b > 0 && c > 0
                        && a < b + c
                        && b < a + c
                        && c < a + b;
                if (valido) {
                    double p = a + b + c;
                    double s = p / 2;
                    double area = Math.sqrt(s * (s - a) * (s - b) * (s - c));
                    resultado.setText(
                            String.format(
                                    "<html>Perimetro: %.2f<br>Area: %.2f</html>", p, area));
                } else {
                    resultado.setText("Triangulo invalido!");
                }
            } catch (NumberFormatException erro) {
                resultado.setText("Informe valores numericos validos!");
            }
        });
        // Configuracao da janela
        janela.add(painel);
        janela.setSize(400, 220);
        janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        janela.setLocationRelativeTo(null);
        janela.setVisible(true);
    }
}
