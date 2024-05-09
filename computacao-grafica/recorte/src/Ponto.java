class Ponto {
    private double x, y;

    public Ponto(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public void setX(double x) {
        this.x = x;
    }

    public void setY(double y) {
        this.y = y;
    }

    public int calcularCodigo(double xMin, double xMax, double yMin, double yMax) {
        int c = 0;
        if (x < xMin) c |= 1;
        if (x > xMax) c |= 2;
        if (y < yMin) c |= 4;
        if (y > yMax) c |= 8;
        return c;
    }
}
