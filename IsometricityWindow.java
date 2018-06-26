import java.awt.*;
import javax.swing.*;

/**
 * A JFrame to show isometric rectangles
 */
class IsometricityWindow extends JFrame {

    public IsometricSquare[] squares; ///An isometric square object to be drawn

    private Color squareColor; ///The color with which to draw the square
    private Color outlineColor; ///The color with which to outline the square

    /**
     * Constructs a new window with the given title
     */
    public IsometricityWindow(String title) {
        super(title);
        this.setVisible(true);
        this.setSize(500, 400);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.squares = new IsometricSquare[5];
        for(int i = 0; i < squares.length; i++) {
            squares[i] = new IsometricSquare(0.0, 25, 75, 50 + 50 * i);
        } 
        this.squareColor = new Color(50, 100, 75);
        this.outlineColor = new Color(10, 40, 25);
    } 

    /**
     * Draws all pieces of the window
     * Draws an isometrically shifted square
     */
    public void paint(Graphics g) {
        g.setColor(Color.LIGHT_GRAY);
        g.fillRect(0, 0, 500, 400);
        for(IsometricSquare square : squares) {
            int[][] vertices = square.getVertices();
            g.setColor(this.squareColor);
            g.fillPolygon(vertices[1], vertices[0], 4);
            g.setColor(this.outlineColor);
            g.drawPolygon(vertices[1], vertices[0], 4);
        }
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
            for(IsometricSquare square : display.squares) {
                square.angleFacing += 0.01;
            }
            display.repaint();
        }
    }
}