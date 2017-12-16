package calculator;

import complex.ComplexNumber;
import token.Token;

<<<<<<< HEAD
import java.util.ArrayList;
import java.util.HashMap;

public class Operand implements ICalculatable{

    private HashMap<String, Object> OperandContent = new HashMap<>();
//    private VectorNd vector = null;
//    private ComplexNumber number = null;
//    private Token OriginalToken = null;

    public Operand(Token a) {
        OperandContent.put(a.getType(), a.getValue());
=======
import java.util.HashMap;

public class Operand implements IOperable {
    private HashMap<String, Object> operand = new HashMap<>();

    public Operand(Token token) {
        if (token != null)
            this.put(token);
>>>>>>> master
    }
//        if (a.getType().equals("vector")) {
//            String coords = a.getText();
//            ArrayList<Integer> coordsList = new ArrayList<>();
//            char[] coordsSplitted = coords.toCharArray();
//            for (int i = 1; i < coordsSplitted.length - 1; i++) {
//                if (coordsSplitted[i] != ',') {
//                    coordsList.add(Integer.parseInt(String.valueOf(coordsSplitted[i])));
//                }
//            }
//            int[] coordsArray = new int[coordsList.size()];
//            for (int i = 0; i < coordsList.size(); i++) {
//                coordsArray[i] = coordsList.get(i);
//            }
////            if (coordsArray.length == 2) {
////                vector = new Vector2d(coordsArray[0], coordsArray[1]);
////            } else if (coordsArray.length == 3) {
////                vector = new Vector3d(coordsArray[0], coordsArray[1], coordsArray[2]);
////            } else {
//            vector = new VectorNd(coordsArray);
////            }
//        }
//        else{
//            number = new ComplexNumber(a.getText());
//        }

<<<<<<< HEAD
    public String GetType() {
//        if (vector != null && number != null) {
//            return "Compound";
//        }
//        if (vector == null) {
//            if (number == null) {
//                return "None";
//            } else {
//                return "Number";
//            }
//        } else {
//            return "Vector";
//        }
        return null;
    }

    public String toString()
    {
//        if (vector != null && number != null) {
//            return vector + number.toString();
//        }
//        if (vector == null) {
//            if (number == null) {
//                return "None";
//            } else {
//                return number.toString();
//            }
//        } else {
//            return vector.toString();
//        }
        return null;
=======
    private void put(Token token){
        if (token.getType().startsWith("vector"))
            operand.put(token.getType(), token.getValue());
        else if (token.getType().equals("complex")){
            ComplexNumber complex = (ComplexNumber) token.getValue();
            if (complex.real() != 0.0) operand.put("real", complex.real());
            if (complex.imaginary() != 0.0) operand.put("imaginary", complex.imaginary());
        }
>>>>>>> master
    }
}



