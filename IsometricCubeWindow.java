import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 * A JFrame to show isometric rectangles
 */
class IsometricCubeWindow extends JFrame implements KeyListener {

    double horizAngle;
    double vertAngle;

    private Color squareColorOne; ///The colors with which to draw the square
    private Color outlineColorOne; ///The colors with which to outline the square
    private Color squareColorTwo; 
    private Color outlineColorTwo;

    /**
     * Constructs a new window with the given title
     */
    public IsometricCubeWindow(String title) {
        super(title);
        this.setVisible(true);
        this.pack();
        this.setSize(500, 400);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.horizAngle = 0;
        this.squareColorOne = new Color(50, 100, 75);
        this.squareColorTwo = new Color(100, 75, 50);
        this.addKeyListener(this);
    } 

    /**
     * Implement key listener methods
     */
    @Override
    public void keyTyped(KeyEvent e) {
    }

    /**
     * Up and down arrow keys modify angle of view
     */
    @Override
    public void keyPressed(KeyEvent e) {
        if(e.getKeyCode() == KeyEvent.VK_RIGHT) {
            this.horizAngle = (this.horizAngle + 0.01);
        } else if(e.getKeyCode() == KeyEvent.VK_LEFT) {
            if(this.horizAngle > 0.01) this.horizAngle = (this.horizAngle - 0.01);
        }
        fixAngle();
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }

    /**
     * Draws all pieces of the window
     * Draws an isometrically shifted square
     */
    public void paint(Graphics g) {
        g.setColor(Color.LIGHT_GRAY);
        g.fillRect(0, 0, 1400, 800);
        int[][] firstVertices = getVerticesOfFirst();
        g.setColor(this.squareColorOne);
        g.fillPolygon(firstVertices[0], firstVertices[1], 4);
        int[][] secondVertices = getVerticesOfSecond();
        g.setColor(this.squareColorTwo);
        g.fillPolygon(secondVertices[0], secondVertices[1], 4);
    }

    private int[][] getVerticesOfFirst() {
        int[] verticesX = new int[4];
        int[] verticesY = new int[4];
        verticesX[0] = 50;
        verticesX[1] = 50 + (int) (Math.sin(horizAngle) * (double) 50);;
        verticesX[2] = 50 + (int) (Math.sin(horizAngle) * (double) 50);;
        verticesX[3] = 50;
        verticesY[0] = 50;
        verticesY[1] = 50;
        verticesY[2] = 100;
        verticesY[3] = 100;
        int[][] allVertices = {verticesX, verticesY};
        return allVertices;
    }

    private int[][] getVerticesOfSecond() {
        int[][] verticesOfFirst = getVerticesOfFirst();
        int[] verticesX = new int[4];
        int[] verticesY = new int[4];
        verticesX[0] = verticesOfFirst[0][1];
        verticesX[1] = verticesOfFirst[0][1] + (int) (Math.cos(horizAngle) * (double) 50);;
        verticesX[2] = verticesOfFirst[0][1] + (int) (Math.cos(horizAngle) * (double) 50);;
        verticesX[3] = verticesOfFirst[0][1];
        verticesY[0] = 50;
        verticesY[1] = 50;
        verticesY[2] = 100;
        verticesY[3] = 100;
        int[][] allVertices = {verticesX, verticesY};
        return allVertices;
    }

    private void fixAngle() {
        if(this.horizAngle % Math.PI / 2 == 0) {
            Color tempColor = this.squareColorOne;
            this.squareColorOne = this.squareColorTwo;
            this.squareColorTwo = tempColor;
        }
        this.horizAngle %= 2 * Math.PI;
    }

    /**
     * Main method; initializes a window
     */
    public static void main(String[] args) {
        IsometricCubeWindow display = new IsometricCubeWindow("Isometricity Tester");
        while(true) {
            try {
                Thread.sleep(17);
            } catch (Exception e) {

            }
            display.repaint();
        }
    }
}