package ML;

import javax.swing.*;
import java.awt.*;

public class GifPanel extends JPanel {
    private Image gifImage;

    public GifPanel(String gifFilePath) {
        // Carregue o GIF usando a classe Toolkit
        gifImage = Toolkit.getDefaultToolkit().createImage(gifFilePath);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        // Desenhe o GIF na área do painel
        g.drawImage(gifImage, 0, 0, this);
    }
}
