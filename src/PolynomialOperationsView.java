//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
/*
public interface PolynomialOperationsView {

    //void setAdditionListener(ActionListener listener);
   // void setSubtractionListener(ActionListener listener);
    void setMultiplicationListener(ActionListener listener);

    String getFirstPolynomial();
    String getSecondPolynomial();
    void setResult(String result);

    View getView();

    default void initialize() {
        View view = getView();

        setAdditionListener(e -> {
            String first = getFirstPolynomial();
            String second = getSecondPolynomial();
            Polynomial polynomial1 = new Polynomial();
            Polynomial polynomial2 = new Polynomial();
            Polynomial result = Operations.addition( polynomial1, polynomial2);
            setResult(result.toString());
        });

        setSubtractionListener(e -> {
            String first = getFirstPolynomial();
            String second = getSecondPolynomial();
            Polynomial polynomial1 = new Polynomial();
            Polynomial polynomial2 = new Polynomial();
            Polynomial result = Operations.substract( polynomial1, polynomial2);
            setResult(result.toString());
        });

        setMultiplicationListener(e -> {
            String first = getFirstPolynomial();
            String second = getSecondPolynomial();
            Polynomial polynomial1 = new Polynomial();
            Polynomial polynomial2 = new Polynomial();
            Polynomial result = Operations.multiply( polynomial1, polynomial2);
            setResult(result.toString());
        });

        view.getButton().setText("Add");
        view.getLabel().setText("Result");

        view.getButton().setText("Substract");
        view.getLabel().setText("Result");

        view.getButton().setText("Multiply");
        view.getLabel().setText("Result");
    }

}*/

