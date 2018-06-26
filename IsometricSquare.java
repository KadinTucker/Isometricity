

class IsometricSquare {

    double angleFacing; ///The angle at which the observer is observing
    int diagonalLength; ///The length of the diagonal of the square
    int centerX; ///The x-coordinate of the isometric square
    int centerY; ///the y-coordinate of the isometric square

    public IsometricSquare(double angle, int diagonalLength, int centerX, int centerY) {
        this.angleFacing = angle;
        this.diagonalLength = diagonalLength;
        this.centerX = centerX;
        this.centerY = centerY;
    }

    public int[][] getVertices() {
        int[] verticesX = new int[4];
        int[] verticesY = new int[4];
        verticesX[0] = centerX + diagonalLength;
        verticesX[1] = centerX;
        verticesX[2] = centerX - diagonalLength;
        verticesX[3] = centerX;
        verticesY[0] = centerY;
        verticesY[1] = centerY - (int) (Math.sin(angleFacing) * (double) diagonalLength);
        verticesY[2] = centerY;
        verticesY[3] = centerY + (int) (Math.sin(angleFacing) * (double) diagonalLength);
        int[][] allVertices = {verticesX, verticesY};
        return allVertices;
    }

}