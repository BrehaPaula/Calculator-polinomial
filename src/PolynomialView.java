import java.util.Scanner;
public class PolynomialView implements View {
    private final Scanner scanner;

    public PolynomialView() {
        scanner = new Scanner(System.in);
    }

    @Override
    public void display(String result) {
        System.out.println(result);
    }

    @Override
    public Polynomial getPolynomialInput() {
        System.out.print("Enter the polynomial: ");
        String input = scanner.nextLine();
        return Polynomial.parse(input);
    }
}