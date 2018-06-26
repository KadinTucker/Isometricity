

/**
 * A datastructure which contains a grid of isometrically projectable squares
 * Handles a coordinate system that acts at an angle and
 * performs necessary calculations
 */
class IsometricSquareGrid {

    IsometricSquare[][] grid; ///The grid of isometric squares
    
    private double collectiveAngle; ///A collective angle to be applied to all squares; changing it causes whole grid to update

    /**
     * Creates a new grid of squares with the given number of rows and columns
     * Squares created have the given length of their diagonals
     * The 'center' refers to the location of (0, 0)
     */
    public IsometricSquareGrid(int nrows, int ncols, int diagonalLength, int centerX, int centerY) {
        grid = new IsometricSquare[nrows][ncols];
        for(int x = 0; x < nrows; x++) {
            for(int y = 0; y < ncols; y++) {
                grid[x][y] = new IsometricSquare(0.0, diagonalLength, centerX + (x + y) * diagonalLength,
                        centerY + x * diagonalLength - y * diagonalLength);
            }
        }
    }

    /**
     * Sets the contained angle to be the given amount, then updates the grid
     */
    public void setAngle(double angle) {
        collectiveAngle = angle;
        updateGrid(angle);
    }

    /**
     * Returns the collective angle of the grid
     */
    public double getAngle() {
        return collectiveAngle;
    }

    /**
     * Updates all items on the grid so that they fit with a new angle
     */
    private void updateGrid(double newAngle) {
        double diagonalMod = (grid[0][0].diagonalLength) * (1.0 - Math.tan((Math.PI / 2 - newAngle) / 2));
        for(int x = 0; x < grid.length; x++) {
            for(int y = 0; y < grid[x].length; y++) {
                grid[x][y].angleFacing = newAngle;
                grid[x][y].centerY = (int) (diagonalMod * (y - x) + grid[0][0].centerY);
            }
        }
    }

}