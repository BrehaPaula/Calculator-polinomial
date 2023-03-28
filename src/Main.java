public class Main {
    public static void main(String[] args) {
        Polynomial polynomial1 = new Polynomial("2");
        Polynomial polynomial2 = new Polynomial("3");
        Operations.addition(  polynomial1,   polynomial2);
        Operations.substract(  polynomial1,  polynomial2);
        Operations.multiply(  polynomial1,  polynomial2);
    }
}