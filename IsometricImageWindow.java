import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import java.io.*;
import javax.imageio.*;
import javax.swing.*;

/**
 * A JFrame to show isometric rectangles
 */
class IsometricImageWindow extends JFrame {

    public IsometricSquareGrid squares; ///An isometric square grid object to be drawn
    public BufferedImage tileImage; ///The image of tiles

    private int size; ///The side length of a square grid of tiles

    /**
     * Constructs a new window with the given title and size
     * Number of tiles is size^2
     */
    public IsometricImageWindow(String title, int size) {
        super(title);
        this.setVisible(true);
        this.pack();
        this.setSize(1000, 700);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        try {
            this.tileImage = ImageIO.read(new File("isometricTile.png"));
        } catch (Exception e) {}
        this.size = size;
    } 

    /**
     * Draws all pieces of the window
     * Draws an isometrically shifted square
     */
    public void paint(Graphics g) {
        g.setColor(Color.LIGHT_GRAY);
        g.fillRect(0, 0, 1400, 800);
        for (int x = 0; x < this.size; x++) {
            for (int y = 0; y < this.size; y++) {
                //Angle of observation is tan(0.5); dimensions of image are 48x24
                g.drawImage(this.tileImage, 50 + x * 24 + y * 24, 350 + y * 12 - x * 12, null);
            }
        }
        
    }

    /**
     * Main method; initializes a window
     */
    public static void main(String[] args) {
        IsometricImageWindow display = new IsometricImageWindow("Isometricity Tester", 20);
        display.repaint();
    }
}