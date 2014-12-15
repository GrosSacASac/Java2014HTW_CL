/**
 * @author LUCIE BECHTOLD / CYRIL WALLE 
 * @version 2.0
 */
public class Method1
{
    final static SIZE_TABLE_MAX = 100;
    double[SIZE_TABLE_MAX] table;
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
    * @param sizeTable (int), table (int[])
    */
    public int calculateArithmeticAverage (int sizeTable, double[] table)
    {
        double sumTotalTable = 0;
        for (int i = 0; i < sizeTable; i++)
        {
            sumTotalTable += table[i];
        }
        double arithmeticAverage = sumTotalTable / sizeTable;
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