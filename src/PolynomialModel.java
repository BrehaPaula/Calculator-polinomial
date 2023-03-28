public class PolynomialModel implements Model {
    @Override
    public Polynomial addition(Polynomial p1, Polynomial p2) {

        return Operations.addition(p1, p2);
    }

    @Override
    public Polynomial subtract(Polynomial p1, Polynomial p2) {

        return Operations.substract(p1, p2);
    }

    @Override
    public Polynomial multiply(Polynomial p1, Polynomial p2) {

        return Operations.multiply(p1, p2);
    }
}





