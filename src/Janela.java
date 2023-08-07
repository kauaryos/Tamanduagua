import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import ML.Agir;

public class Janela extends JFrame {
    private JTextField caixaTexto;
    private JLabel totalWaterLabel;
    private Agir instanciaAgir;

    public Janela() {
        super("Tamanduagua");
        setSize(350, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        caixaTexto = new JTextField();
        caixaTexto.setBounds(30, 220, 100, 40);
        add(caixaTexto);

        JButton botao = new JButton("Beber Água");
        botao.setBounds(30, 270, 100, 40);
        add(botao);

        totalWaterLabel = new JLabel("Total de água bebida: 0 ml");
        totalWaterLabel.setBounds(30, 320, 300, 40);
        add(totalWaterLabel);

        instanciaAgir = new Agir();

        botao.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int ml = Integer.parseInt(caixaTexto.getText());
                    instanciaAgir.registrarAgua(ml);
                    updateTotalWaterLabel();
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(Janela.this, "Digite um número válido de mls.", "Erro", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        setLayout(null);
    }

    private void updateTotalWaterLabel() {
        int totalWaterConsumed = instanciaAgir.getTotalAguaConsumida();
        totalWaterLabel.setText("Total de água bebida: " + totalWaterConsumed + " ml");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                Janela janela = new Janela();
                janela.setVisible(true);
            }
        });
    }
}
