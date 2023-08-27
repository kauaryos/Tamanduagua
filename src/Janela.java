import ML.Agir;
import ML.GifPanel;
import java.awt.*;
import javax.swing.*;

public class Janela extends JFrame {
    private final JTextField caixaTexto;
    private final JLabel totalWaterLabel;
    private final Agir instanciaAgir;

    public Janela() {
        super("Tamanduágua");
        setSize(300, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);

        JButton aboutButton = new JButton("SOBRE");
        Font smallerFont = aboutButton.getFont().deriveFont(10.0f);
        aboutButton.setFont(smallerFont);
        aboutButton.setBounds(45, 255, 40, 70);
        add(aboutButton);


        GifPanel gifPanel = new GifPanel("/home/kaua/IdeaProjects/tamanduagua/src/Icon_img/ele.gif");
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

        aboutButton.addActionListener(e -> {
            exibirInformacoesSobre(); // Chamando o método exibirInformacoesSobre()
        });

        setLayout(null);
    }

    private void updateTotalWaterLabel() {
        int totalWaterConsumed = instanciaAgir.getTotalAguaConsumida();
        totalWaterLabel.setText("Total de água bebida: " + totalWaterConsumed + " ml");
    }

    private void exibirInformacoesSobre() {
        String informacoesSobre = "Desenvolvido por: Kauã Ryos\nVersão: 1.0\nAno: 2023";
        JOptionPane.showMessageDialog(this, informacoesSobre, "Sobre", JOptionPane.INFORMATION_MESSAGE);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            Janela janela = new Janela();
            janela.setVisible(true);
        });
    }
}
