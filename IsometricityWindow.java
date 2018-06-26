import java.awt.*;
import javax.swing.*;

/**
 * A JFrame to show isometric rectangles
 */
class IsometricityWindow extends JFrame {

    public IsometricSquare square; ///An isometric square object to be drawn

    /**
     * Constructs a new window with the given title
     */
    public IsometricityWindow(String title) {
        super(title);
        this.setVisible(true);
        this.setSize(500, 400);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.square = new IsometricSquare(0.52, 25, 75, 75); 
    } 

    /**
     * Draws all pieces of the window
     * Draws an isometrically shifted square
     */
    public void paint(Graphics g) {
        g.setColor(Color.LIGHT_GRAY);
        g.fillRect(0, 0, 500, 400);
        g.setColor(Color.BLACK);
        int[][] vertices = square.getVertices();
        g.fillPolygon(vertices[1], vertices[0], 4);
    }

    /**
     * Main method; initializes a window
     */
    public static void main(String[] args) {
        IsometricityWindow display = new IsometricityWindow("Isometricity Tester");
        while(true) {
            try {
                Thread.sleep(17);
            } catch (Exception e) {

            }
            display.square.angleFacing += 0.01;
            display.repaint();
        }
    }
}