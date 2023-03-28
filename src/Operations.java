import java.util.HashMap;
import java.util.Scanner;
import  java.util.Map;
    public class Operations {
        public  static Polynomial addition(Polynomial polynomial1, Polynomial polynomial2) {
            Polynomial result = new Polynomial("");
            for (Integer key : polynomial1.keySet())
                for (Integer key2: polynomial2.keySet()) {
                    if (key.equals(key2)) {
                        result.put(key, polynomial1.get(key) + polynomial2.get(key));
                        System.out.println("Polynomial: " + result.toString() + ", Coefficient: ");
                    }
                }
            return result;
        }

        public  static Polynomial multiply(Polynomial polynomial1, Polynomial polynomial2) {
            Polynomial result = new Polynomial("");
            for (Integer key : polynomial1.keySet())
                for (Integer key2: polynomial2.keySet()) {
                    result.put(key+key2,polynomial1.get(key) * polynomial2.get(key));
                    System.out.println("Polynomial: " + result.toString() + ", Coefficient: " );
                }
            return result;
        }

        public  static Polynomial substract(Polynomial polynomial1, Polynomial polynomial2) {
            Polynomial result = new Polynomial("");
            for (Integer key : polynomial1.keySet())
                for (Integer key2: polynomial2.keySet()) {
                    result.put(key,polynomial1.get(key) + polynomial2.get(key));
                    System.out.println("Polynomial: " + result.toString() + ", Coefficient: " );
                }
            return result;
        }

    }
