package Retos.Utils;

/**
 * NumberCurrencyFormatter
 */
public class NumberCurrencyFormatter {
    /**
     * Le da formato de moneda al numero que se le entregue.
     * @param num Numero al que se le dará formato de moneda
     * @param moneda {@code String} de 3 caracteres con la moneda deseada. Ejemplo: MXN, EUR, GBP, USD, CAD, ...
     * @return {@code String} de la siguiente forma: {@code <moneda>$<num>}
     */
    public static String format(double num, String moneda){
        return moneda + "$" + Double.toString(num);
    }
}