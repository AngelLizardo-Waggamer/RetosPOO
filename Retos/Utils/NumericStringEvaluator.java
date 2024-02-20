package Retos.Utils;

public class NumericStringEvaluator {
    public boolean isANumber(String str){
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
