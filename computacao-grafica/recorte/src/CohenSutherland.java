class CohenSutherland {
    public static Linha clipar(Linha l, double xMin, double xMax, double yMin, double yMax) {
        Ponto p1 = l.getP1();
        Ponto p2 = l.getP2();
        int c1 = p1.calcularCodigo(xMin, xMax, yMin, yMax);
        int c2 = p2.calcularCodigo(xMin, xMax, yMin, yMax);

        while (true) {
            if ((c1 | c2) == 0) {
                return new Linha(p1, p2);
            } else if ((c1 & c2) != 0) {
                return null;
            } else {
                int cFora = (c1 != 0) ? c1 : c2;
                Ponto novoPonto = new Ponto(0, 0);

                if ((cFora & 8) != 0) {
                    novoPonto.setX(p1.getX() + (p2.getX() - p1.getX()) * (yMax - p1.getY()) / (p2.getY() - p1.getY()));
                    novoPonto.setY(yMax);
                } else if ((cFora & 4) != 0) {
                    novoPonto.setX(p1.getX() + (p2.getX() - p1.getX()) * (yMin - p1.getY()) / (p2.getY() - p1.getY()));
                    novoPonto.setY(yMin);
                } else if ((cFora & 2) != 0) {
                    novoPonto.setY(p1.getY() + (p2.getY() - p1.getY()) * (xMax - p1.getX()) / (p2.getX() - p1.getX()));
                    novoPonto.setX(xMax);
                } else {
                    novoPonto.setY(p1.getY() + (p2.getY() - p1.getY()) * (xMin - p1.getX()) / (p2.getX() - p1.getX()));
                    novoPonto.setX(xMin);
                }

                if (cFora == c1) {
                    p1 = novoPonto;
                    c1 = p1.calcularCodigo(xMin, xMax, yMin, yMax);
                } else {
                    p2 = novoPonto;
                    c2 = p2.calcularCodigo(xMin, xMax, yMin, yMax);
                }
            }
        }
    }
}