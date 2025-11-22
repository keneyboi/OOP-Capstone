
import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class BackgroundPanel extends JPanel {

    private Image backgroundImage;

    public BackgroundPanel(String imagePath) {
        try {
            backgroundImage = ImageIO.read(new File(imagePath));
        } catch (IOException e) {
            System.err.println("Error loading background image: " + e.getMessage());
            // Handle the error, e.g., set a default background color
            setBackground(Color.LIGHT_GRAY);
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g); // Call super to ensure proper painting of other components
        if (backgroundImage != null) {
            // Draw the image to fill the panel
            g.drawImage(backgroundImage, 0, 0, 500, 1000, this);
        }
    }
}
