import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import java.io.*;
import javax.imageio.*;
import javax.swing.*;

/**
 * A JFrame to show isometric rectangles
 */
class IsometricImageWindow extends JFrame implements MouseListener {

    public IsometricSquareGrid squares; ///An isometric square grid object to be drawn
    public BufferedImage tileImage; ///The image of tiles
    public BufferedImage hoverImage; ///The image drawn over tiles

    private int size; ///The side length of a square grid of tiles
    private int[] hoveredPoint; ///The coordinates clicked on by the player

    /**
     * Constructs a new window with the given title and size
     * Number of tiles is size^2
     */
    public IsometricImageWindow(String title, int size) {
        super(title);
        this.setVisible(true);
        this.setSize(500, 400);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        try {
            this.tileImage = ImageIO.read(new File("isometricTile.png"));
            this.hoverImage = ImageIO.read(new File("isometricTileHovered.png"));
        } catch (Exception e) {}
        this.size = size;
        this.addMouseListener(this);
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
                //Angle of observation is atan(0.5); dimensions of image are 48x24
                g.drawImage(this.tileImage, x * 24 + y * 24 + 50, y * 12 - x * 12 + 250, null);
            }
        }
    }

    /**
     * Gets the coordinates of the tile over which the mouse is hovering
     * Assumes an angle of atan(0.5) and image height of 24px
     */
    public int[] getHoveredCoordinates(int x, int y) {
        int[] point = new int[2];
        point[1] = -(int)(((double)y - (double)x / 2.0 + (double)this.size) / 24.0);
        point[0] = (int)(((double)y + (double)x / 2.0 - (double)this.size) / 24.0);
        return point;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        this.hoveredPoint = this.getHoveredCoordinates(e.getX() - 50, e.getY() - 262);
        System.out.println("Clicked @ " + this.hoveredPoint[0] + ", " + this.hoveredPoint[1]);
    } 

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }

    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    /**
     * Main method; initializes a window
     */
    public static void main(String[] args) {
        IsometricImageWindow display = new IsometricImageWindow("Isometricity Tester", 6);
        display.repaint();
    }
}