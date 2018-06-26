import java.awt.*;
import javax.swing.*;

/**
 * A JFrame to show isometric rectangles
 */
class IsometricityWindow extends JFrame {

    /**
     * Constructs a new window with the given title
     */
    public IsometricityWindow(String title) {
        super(title);
        this.setVisible(true);
        this.setSize(500, 400);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    } 

    /**
     * Draws all pieces of the window
     * Draws a square rotated 45 degrees
     */
    public void paint(Graphics g) {
        g.setColor(Color.LIGHT_GRAY);
        g.fillRect(0, 0, 500, 400);
        g.setColor(Color.BLACK);
        int[] xPoints = {75, 100, 75, 50};
        int[] yPoints = {50, 75, 100, 75};
        g.fillPolygon(xPoints, yPoints, 4);
    }

    /**
     * Main method; initializes a window
     */
    public static void main(String[] args) {
        JFrame display = new IsometricityWindow("Isometricity Tester");
    }

}