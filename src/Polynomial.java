import javax.swing.JTextField;
import java.awt.*;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.util.Set;


public class Polynomial {
    HashMap<Integer, Integer> polynomial;
     static String[]  inputArray ;

    public Polynomial(String s){
        inputArray = new String[100];
        inputArray[0] =s;
        getText();
    }
    public Polynomial(){
        super();
    }


    public  static String getText() {
       inputArray = getText().split("\\s+");
        HashMap<Integer, Integer> polynomial = new HashMap<>();

        for (int i = 0; i < inputArray.length; i++) {
            int coef = Integer.parseInt(inputArray[i]);
            if (coef != 0) {
                polynomial.put(inputArray.length - i - 1, coef);
            }
        }
        return polynomial.toString();
    }
    public String toString() {
        String result = "";
        boolean firstTerm = true;

        for (Map.Entry<Integer, Integer> entry : polynomial.entrySet()) {
            int exponent = entry.getKey();
            int coefficient = entry.getValue();
            if (coefficient != 0) {
                String sign = "";
                String coef = "";
                String exp = "";
                if (!firstTerm) {
                    if (coefficient > 0) {
                        sign = " + ";
                    } else {
                        sign = " - ";
                        coefficient *= -1;
                    }
                } else {
                    if (coefficient < 0) {
                        sign = "-";
                        coefficient = coefficient * -1;
                    }
                }
                if (coefficient != 1 || exponent == 0) {
                    coef = Integer.toString(coefficient);
                }
                if (exponent != 0) {
                    exp = "x";
                    if (exponent != 1) {
                        exp =  exp + "^" + Integer.toString(exponent);
                    }
                }
                if (exponent == 0 && coefficient == 1 && !firstTerm) {
                    result =result + " + 1";
                } else {
                    result = result + sign + coef + exp;
                }
                firstTerm = false;
            }
        }
        if (result.equals("")) {
            result = "0";
        }
        return result;
    }

    public void put(Integer key,Integer i){

        polynomial.put(key,i);
    }


    public Integer entrySet(Integer key, Integer value){
        polynomial.put(key ,value);
        return polynomial.get(key);
    }

    public Set<Integer> keySet(){

        return polynomial.keySet();
    }

    public  Integer get(Integer key){

        return polynomial.get(key);
    }
    public  Integer getV(Integer value){

        return polynomial.get(value);
    }


    public static Polynomial parse(String input) {
        String[] inputArray = input.split("\\s+");
        HashMap<Integer, Integer> polynomial = new HashMap<>();

        for (int i = 0; i < inputArray.length; i++) {
            int coef = Integer.parseInt(inputArray[i]);
            if (coef != 0) {
                polynomial.put(inputArray.length - i - 1, coef);
            }
        }

        Polynomial result = new Polynomial("");
        result.polynomial = polynomial;

        return result;
    }
}
