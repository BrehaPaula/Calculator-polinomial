package org.example.model;

import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Polynomial {

    public static HashMap<Integer, Double> addPolynomials(String polynomialString1, String polynomialString2) {
        HashMap<Integer, Double> polynomialMap1 = convertToPolynomial(polynomialString1);
        HashMap<Integer, Double> polynomialMap2 = convertToPolynomial(polynomialString2);

        // add the coefficients for each term with the same exponent
        for (int exponent : polynomialMap2.keySet()) {
            double coefficient2 = polynomialMap2.get(exponent);
            if (polynomialMap1.containsKey(exponent)) {
                double coefficient1 = polynomialMap1.get(exponent);
                polynomialMap1.put(exponent, coefficient1 + coefficient2);
            } else {
                polynomialMap1.put(exponent, coefficient2);
            }
        }

        return polynomialMap1;
    }

    public static HashMap<Integer, Double> convertToPolynomial(String polynomialString) {
        HashMap<Integer, Double> polynomialMap = new HashMap<>();

        // define the regex pattern for matching terms in the polynomial
        Pattern termPattern = Pattern.compile("(\\+|-)?(\\d*(\\.\\d+)?)?x(\\^(\\d+))?");

        // find each term in the polynomial string and add it to the map
        Matcher matcher = termPattern.matcher(polynomialString);
        while (matcher.find()) {
            double coefficient = 1;
            int exponent = 1;

            // get the sign of the term, default to positive
            String sign = matcher.group(1);
            if (sign != null && sign.equals("-")) {
                coefficient = -1;
            }

            // get the coefficient of the term, default to 1
            String coefficientString = matcher.group(2);
            if (coefficientString != null && !coefficientString.isEmpty()) {
                coefficient = Double.parseDouble(coefficientString) * coefficient;
            }

            // get the exponent of the term, default to 1
            String exponentString = matcher.group(5);
            if (exponentString != null && !exponentString.isEmpty()) {
                exponent = Integer.parseInt(exponentString);
            }

            // add the term to the polynomial map
            if (polynomialMap.containsKey(exponent)) {
                double oldCoefficient = polynomialMap.get(exponent);
                polynomialMap.put(exponent, oldCoefficient + coefficient);
            } else {
                polynomialMap.put(exponent, coefficient);
            }
        }

        return polynomialMap;
    }

    public static String convertToString(HashMap<Integer, Double> polynomialMap) {
        StringBuilder sb = new StringBuilder();

        // loop through each term in the map
        for (int exponent : polynomialMap.keySet()) {
            double coefficient = polynomialMap.get(exponent);

            if (coefficient == 0) {
                continue;
            }
            // handle the coefficient and sign of the term
            if (coefficient > 0 && sb.length() > 0) {
                sb.append("+");
            } else if (coefficient < 0) {
                sb.append("-");
                coefficient = -coefficient;
            }
            if (coefficient != 1 || exponent == 0) {
                sb.append(coefficient);
            }

            // handle the variable and exponent of the term
            if (exponent > 0) {
                sb.append("x");
                if (exponent > 1) {
                    sb.append("^").append(exponent);
                }
            }
        }

        // handle the case where the polynomial is zero
        if (sb.length() == 0) {
            sb.append("0");
        }

        return sb.toString();
    }

    public static HashMap<Integer, Double> negate(String s) {
        HashMap<Integer, Double> p = convertToPolynomial(s);
        HashMap<Integer, Double> negatedMap = new HashMap<Integer, Double>();

        // loop through each term in the map and negate its coefficient
        for (int exponent : p.keySet()) {
            double coefficient = -p.get(exponent);
            negatedMap.put(exponent, coefficient);
        }

        return negatedMap;
    }

    public static HashMap<Integer, Double> substract(String strP1, String strP2) {

        HashMap<Integer, Double> result = new HashMap<Integer, Double>();
        result = addPolynomials(strP1, convertToString(negate(strP2)));

        return result;
    }

    public static HashMap<Integer, Double> derivative(String p1) {
        HashMap<Integer, Double> polynomialMap = convertToPolynomial(p1);
        HashMap<Integer, Double> derivativeMap = new HashMap<Integer, Double>();

        // loop through each term in the map and calculate its derivative
        for (int exponent : polynomialMap.keySet()) {
            double coefficient = polynomialMap.get(exponent);
            if (exponent > 0) {
                double derivativeCoefficient = coefficient * exponent;
                derivativeMap.put(exponent - 1, derivativeCoefficient);
            }
        }

        return derivativeMap;
    }

    public static HashMap<Integer, Double> integrate(String p) {
        HashMap<Integer, Double> integralMap = new HashMap<Integer, Double>();
        HashMap<Integer, Double> polynomialMap = convertToPolynomial(p);
        // loop through each term in the map and calculate its indefinite integral
        for (int exponent : polynomialMap.keySet()) {
            double coefficient = polynomialMap.get(exponent);
            double integralCoefficient = coefficient / (exponent + 1);
            integralMap.put(exponent + 1, integralCoefficient);
        }

        // add the constant of integration
        integralMap.put(0, 0.0);

        return integralMap;
    }

    public static HashMap<Integer, Double> multiply(String a, String b) {

        HashMap<Integer, Double> p1 = convertToPolynomial(a);
        HashMap<Integer, Double> p2 = convertToPolynomial(b);
        HashMap<Integer, Double> productMap = new HashMap<Integer, Double>();

        // loop through each term in the first polynomial map
        for (int exponent1 : p1.keySet()) {
            double coefficient1 = p1.get(exponent1);

            // loop through each term in the second polynomial map
            for (int exponent2 : p2.keySet()) {
                double coefficient2 = p2.get(exponent2);

                // multiply the two terms and add the result to the product map
                int productExponent = exponent1 + exponent2;
                double productCoefficient = coefficient1 * coefficient2;
                if (productMap.containsKey(productExponent)) {
                    double oldCoefficient = productMap.get(productExponent);
                    productMap.put(productExponent, oldCoefficient + productCoefficient);
                } else {
                    productMap.put(productExponent, productCoefficient);
                }
            }
        }

        return productMap;
    }


    public static void main(String[] args) {
        String polynomialString1 = "-3x^2-2x^1+1x^0";
        String polynomialString2 = "5x^3+2x^1+1x^0";
//        String f1="3x^1+2x^0";
//        String f2="3x^1";

        HashMap<Integer, Double> ea = negate(polynomialString2);
        System.out.println(convertToString(ea));
        HashMap<Integer, Double> el = derivative(polynomialString2);
        System.out.println(convertToString(el));
        HashMap<Integer, Double> ei = integrate(polynomialString2);
        System.out.println(convertToString(ei));
        HashMap<Integer, Double> eu = multiply(polynomialString1, polynomialString2);
        System.out.println(convertToString(eu));
//        HashMap<Integer, Double> noi = multiply(f1,f2);
//        System.out.println(convertToString(noi));
        HashMap<Integer, Double> polynomialMap = addPolynomials(polynomialString1, polynomialString2);
        HashMap<Integer, Double> p = substract(polynomialString1, polynomialString2);
        System.out.println(convertToString(polynomialMap));
        System.out.println(convertToString(p));
    }

    public static void equal(HashMap<Integer, Double> expected, HashMap<Integer, Double> addPolynomials) {
    }
}
