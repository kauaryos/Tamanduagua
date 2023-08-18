import ML.Agir;
import ML.GifPanel;

import javax.swing.*;

public class Janela extends JFrame {
    private final JTextField caixaTexto;
    private final JLabel totalWaterLabel;
    private final Agir instanciaAgir;

    public Janela() {
        super("Tamanduagua");
        setSize(300, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        GifPanel gifPanel = new GifPanel("/home/kaua/Documentos/Projetos/tamanduagua-main/src/Icon_img/ele.gif");
        gifPanel.setBounds(52, 10, 200, 200); // Posição e tamanho do quadrado
        add(gifPanel);

        caixaTexto = new JTextField();
        caixaTexto.setBounds(105, 255, 90, 25);
        add(caixaTexto);

        JButton botao = new JButton("Beber");
        botao.setBounds(105, 300, 90, 25);
        add(botao);

        totalWaterLabel = new JLabel("Total de água bebida: 0 ml");
        totalWaterLabel.setBounds(57, 209, 300, 40);
        add(totalWaterLabel);

        instanciaAgir = new Agir();

        botao.addActionListener(e -> {
            try {
                int ml = Integer.parseInt(caixaTexto.getText());
                instanciaAgir.registrarAgua(ml);
                updateTotalWaterLabel();
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(Janela.this, "Digite um número válido de água,\nseu desidratado.", "Erro", JOptionPane.ERROR_MESSAGE);
            }
        });

        setLayout(null);
    }

    private void updateTotalWaterLabel() {
        int totalWaterConsumed = instanciaAgir.getTotalAguaConsumida();
        totalWaterLabel.setText("Total de água bebida: " + totalWaterConsumed + " ml");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            Janela janela = new Janela();
            janela.setVisible(true);
        });
    }
}
