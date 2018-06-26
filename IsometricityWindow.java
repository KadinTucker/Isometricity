import java.awt.*;
import javax.swing.*;

/**
 * A JFrame to show isometric rectangles
 */
class IsometricityWindow extends JFrame {

    public IsometricSquareGrid squares; ///An isometric square grid object to be drawn

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
        this.squares = new IsometricSquareGrid(4, 4, 25, 100, 200);
        this.squareColor = new Color(50, 100, 75);
        this.outlineColor = new Color(10, 40, 25);
    } 

    /**
     * Draws all pieces of the window
     * Draws an isometrically shifted square
     */
    public void paint(Graphics g) {
        g.setColor(Color.LIGHT_GRAY);
        g.fillRect(0, 0, 1400, 800);
        for(int x = 0; x < squares.grid.length; x++) {
            for(int y = 0; y < squares.grid[x].length; y++) {
                int[][] vertices = squares.grid[x][y].getVertices();
                g.setColor(this.squareColor);
                g.fillPolygon(vertices[0], vertices[1], 4);
                g.setColor(this.outlineColor);
                g.drawPolygon(vertices[0], vertices[1], 4);
                g.drawString("" + x + ", " + y, vertices[0][1], vertices[1][1]);
            }
        }
    }

    /**
     * Main method; initializes a window
     */
    public static void main(String[] args) {
        IsometricityWindow display = new IsometricityWindow("Isometricity Tester");
        while(true) {
            try {
                display.repaint();
                Thread.sleep(17);
            } catch (Exception e) {

            }
            display.squares.setAngle((display.squares.getAngle() + 0.005) % (Math.PI / 2));
            display.repaint();
        }
    }
}