/**
 * @author LUCIE BECHTOLD / CYRIL WALLE 
 * @version 2.0
 */
public class Method1
{
    final static SIZE_TABLE_MAX = 100;
    double[SIZE_TABLE_MAX] table;
    double gap;
    //int sizeTable = 0;
    
     /**
    * Constructor Method1 (with all parameters)
    *
    * Creates a new table containing all the numbers to use.
    * 
    * @param  table (double[]), i (double), number (double)
    */
    public Method1 (double[] table, double i, double number)
    {
        this.table[i] = number;
    }
    
     /**
    * Method calculateArithmeticAverage
    *
    * @param sizeTable (int), table (double[])
    */
    public double calculateArithmeticAverage (int sizeTable, double[] table)
    {
        double sumTotalTable = 0.0;
        for (int i = 0; i < sizeTable; i++)
        {
            sumTotalTable += table[i];
        }
        double arithmeticAverage = sumTotalTable / sizeTable;
        return arithmeticAverage;
    }
    
     /**
    * Method furthestNumberFrom
    *
    * @param table (double[])
    * @return maximum (double)
    */
    public double furthestNumberFrom (double[] table)
    {
        double maximum = 0.0;
        double average = calculateArithmeticAverage(sizeTable,table);
        for (int i = 0; i < sizeTable; i++)
        {
            maximum = this.maximum(calculateGap(average,table[i]),calculateGap(average,maximum));
        }
        return maximum;
    }
    
     /**
    * Method closestNumberFrom
    *
    * @param table (double[])
    * @return minimum (double)
    */
    public double closestNumberFrom (double[] table)
    {
        double minimum = 0.0;
        double average = calculateArithmeticAverage(sizeTable,table);
        for (int i = 0; i < sizeTable; i++)
        {
            minimum = this.minimum(calculateGap(average,table[i]),calculateGap(average,minimum));
        }
        return minimum;
    }
    
     /**
    * Method minimum
    *
    * @param number (double), minimum (double)
    * @return minimum (double)
    */
    public double minimum (double number, double minimum)
    {
        if (number < minimum)
        {
            minimum = number;
        }
        return minimum;
    }
    
     /**
    * Method maximum
    *
    * @param number (double), maximum (double)
    * @return maximum (double)
    */
    public double maximum (double number, double maximum)
    {
        if (number > maximum)
        {
            maximum = number;
        }
        return maximum;
    }
    
     /**
    * Method calculateGap
    *
    * @param average (double), number (double)
    * @return gap (double)
    */
    public double calculateGap (double average, double number)
    {
        int gap = average - number;
        return gap;
    }
    
     /**
    * Method check
    *
    * @param condition (boolean), message (String)
    * throws AssertionError if condition false.
    */
    public static void check(boolean condition, String message)
    {
        if (!condition) {
            throw new AssertionError(message);
        }
    }
}