import javax.swing.*;


public class Janela extends JFrame {
    public Janela() {
        super("Tamanduagua"); // Define o título da janela
        setSize(350, 400); // Define o tamanho da janela em pixels (largura x altura)
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Define o comportamento ao clicar no botão de fechar


        // caixa de texto da dor!!
        JTextField caixaTexto = new JTextField();
        caixaTexto.setBounds(30,220,100,40);
        add(caixaTexto);

        // Crie um botão e defina sua posição e tamanho
        JButton botao = new JButton("Clique Aqui!");
        botao.setBounds(30,270,100,80);
        add(botao);


        setLayout(null); // Defina o layout como null (posicionamento manual dos componentes)
    }

    public static void main(String[] args) {
        // Crie uma instância da classe Janela
        Janela janela = new Janela();

        // Torne a janela visível
        janela.setVisible(true);
    }
}
