import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
public class MainFrame extends JFrame{
    private JTextField textField1;
    private JTextField m_totalTf = new JTextField(20);
    private JButton integrateButton;
    private JButton substractionButton;
    private JButton divideButton;
    private JButton multiplyButton;
    private JButton addButton;
    private JLabel mainPanel;
    private JTextField textField2;
    private JButton clearButton;
    public MainFrame(){
        setContentPane(mainPanel);
        addButton.addActionListener (new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JLabel resultLabel = new JLabel();
                if (e.getSource().equals(addButton)) {
                    // Read coefficients of polynomial 1
                    String polynomial1String = Polynomial.getText();
                    String[] polynomial1Array = polynomial1String.split("\\s+");
                    Polynomial polynomial1 =new Polynomial("");
                    for (int i = 0; i < polynomial1Array.length; i++) {
                        polynomial1.put(i, Integer.parseInt(polynomial1Array[i]));
                    }

                    // Read coefficients of polynomial 2
                    String polynomial2String = Polynomial.getText();
                    String[] polynomial2Array = polynomial2String.split("\\s+");
                   Polynomial polynomial2 = new Polynomial("");
                    for (int i = 0; i < polynomial2Array.length; i++) {
                        polynomial2.put(i, Integer.parseInt(polynomial2Array[i]));
                    }

                    // Compute sum of polynomials
                    Polynomial result= new Polynomial("");
                    result =Operations.addition(polynomial1, polynomial2);
                    StringBuilder resultString = new StringBuilder();
                    resultString.append("Sum: ");
                    for (int exponent : result.keySet()) {
                        resultString.append(result.get(exponent) + "x^" + exponent + " + ");
                    }
                    resultString.delete(resultString.length() - 3, resultString.length()); // remove trailing " + "
                    resultLabel.setText(resultString.toString());
                }
            }
        });
        substractionButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JLabel resultLabel = new JLabel();
                if (e.getSource().equals(addButton)) {
                    // Read coefficients of polynomial 1
                    String polynomial1String = Polynomial.getText();
                    String[] polynomial1Array = polynomial1String.split("\\s-");
                   Polynomial polynomial1 = new Polynomial();
                    for (int i = 0; i < polynomial1Array.length; i++) {
                        polynomial1.put(i, Integer.parseInt(polynomial1Array[i]));
                    }

                    // Read coefficients of polynomial 2
                    String polynomial2String = Polynomial.getText();
                    String[] polynomial2Array = polynomial2String.split("\\s-");
                    Polynomial polynomial2 = new Polynomial();
                    for (int i = 0; i < polynomial2Array.length; i++) {
                        polynomial2.put(i, Integer.parseInt(polynomial2Array[i]));
                    }

                    // Compute sum of polynomials
                  Polynomial sub = Operations.substract(polynomial1, polynomial2);
                    StringBuilder resultString = new StringBuilder();
                    resultString.append("Sub: ");
                    for (int exponent : sub.keySet()) {
                        resultString.append(sub.get(exponent) + "x^" + exponent + " - ");
                    }
                    resultString.delete(resultString.length() - 3, resultString.length());
                    resultLabel.setText(resultString.toString());
                }
            }
        });

        multiplyButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JLabel resultLabel = new JLabel();
                if (e.getSource().equals(addButton)) {
                    // Read coefficients of polynomial 1
                    String polynomial1String = Polynomial.getText();
                    String[] polynomial1Array = polynomial1String.split("\\s*");
                   Polynomial polynomial1 = new Polynomial();
                    for (int i = 0; i < polynomial1Array.length; i++) {
                        polynomial1.put(i, Integer.parseInt(polynomial1Array[i]));
                    }

                    // Read coefficients of polynomial 2
                    String polynomial2String = Polynomial.getText();
                    String[] polynomial2Array = polynomial2String.split("\\s*");
                    Polynomial polynomial2 = new Polynomial();
                    for (int i = 0; i < polynomial2Array.length; i++) {
                        polynomial2.put(i, Integer.parseInt(polynomial2Array[i]));
                    }

                    // Compute sum of polynomials
                    Polynomial multy = Operations.multiply(polynomial1, polynomial2);
                    StringBuilder resultString = new StringBuilder();
                    resultString.append("Multiply: ");
                    for (int exponent : multy.keySet()) {
                        resultString.append(multy.get(exponent) + "x^" + exponent + " * ");
                    }
                    resultString.delete(resultString.length() - 3, resultString.length());
                    resultLabel.setText(resultString.toString());
                }

            }
        });
        divideButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        integrateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        textField1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String polinom1String = Polynomial.getText();
            }
        });
    }
}
