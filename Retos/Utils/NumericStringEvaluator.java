package Retos.Utils;
/**
 * @version 1.0
 */
public class NumericStringEvaluator {
    public static boolean isANumber(String str){
        if(str == null){
            return false;
        }
        try {
            @SuppressWarnings("unused")
            Double n = Double.parseDouble(str);
        } catch (NumberFormatException e) {
            return false;
        }
        return true;
    }
}
