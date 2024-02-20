package Retos.Utils;


/**
 * Curiosidad1
 */
public class BinaryParser {
    /**
     * Converts the given {@code String} to Binary
     * @param value {@code String} that contains what needs to be converted to Binary.
     * @return {@code String} with the Binary value requested.
     */
    public static String toBinary(String value){
        NumericStringEvaluator evaluator = new NumericStringEvaluator();
        if(evaluator.isANumber(value)){
            if(value.contains(".")){
                int indexPunto, intPart;
                float floatPart;
                indexPunto = value.indexOf(".",0);
                intPart = Integer.parseInt(value.substring(0, indexPunto));
                floatPart = Float.parseFloat(value.substring(indexPunto, value.length()));
                return Convertidor.parseBinary(intPart) + "." + Convertidor.parseBinary(floatPart);
            }else{
                int intPart;
                intPart = Integer.parseInt(value);
                return Convertidor.parseBinary(intPart);
            }
        }else{
            return Convertidor.parseBinary(value);
        }
    }

    /**
     * Handles conversions from numbers to binary values.
     */
    private class Convertidor{
        /**
         * Converts the integer part of a number to a x32 binary value.
         * @param num {@code Int} number to convert.
         * @return {@code String} binary value of the number.
         */
        private static String parseBinary(int num){
            StringBuilder str = new StringBuilder();
            String result = "";
            int tempInd, tempN = num;
            for(int n = 1; n <= 32; n++){
                result += tempN%2;
                tempN /= 2;
            }
            tempInd = result.lastIndexOf("1");
            result = result.substring(0, tempInd + 1);
            str.append(result);
            str.reverse();
            return str.substring(0);
        }
        /**
         * Converts the float part of a number to binary float value.
         * @param num {@code Float} float part of the number
         * @return {@code String binary value for the float part of the number}
         */
        private static String parseBinary(float num){
            String result = "";
            float tempN = num;
            do{
                float op = tempN * 2.0f;
                char tmpString = Float.toString(op).charAt(0);
                result += tmpString;
                if(op > 1.0f){
                    tempN = (op - 1.0f);
                }else{
                    tempN = op;
                }
                if(tempN == 1.0f){
                    break;
                }
            }while(tempN != 1.0f);
            return result;
        }
        private static String parseBinary(String txt){
            
            return "";
        }
    }
}