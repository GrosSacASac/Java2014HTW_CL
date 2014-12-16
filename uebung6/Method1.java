/**First part of the exercise
 * @author LUCIE BECHTOLD / CYRIL WALLE 
 * @version 2.0
 */
 
public class Method1
{
    
     /**
    * Method main
    *
    * @param sizeTable (int), table (double[])
    * @return results to the different methods (String)
    */
    public static String calculateArithmAverAndOthers (double[] table)
    {
        double arithmeticAverage = calculateArithmeticAverage(table);
        double furthestNumber = furthestNumberFrom(table);
        double closestNumber = closestNumberFrom(table);
        return  "Arithmetic average : " + arithmeticAverage + 
                "\nFurthest number from the arithmetic average : " + furthestNumber +
                "\nClosest number from the arithmetic average : " + closestNumber;
    }
    
     /**
    * Method calculateArithmeticAverage
    *
    * @param sizeTable (int), table (double[])
    */
    public static double calculateArithmeticAverage (double[] table)
    {
        double sumTotalTable = 0.0;
        int sizeTable = table.length;
        for (int i = 0; i < sizeTable; i++)
        {
            sumTotalTable += table[i];
        }
        return sumTotalTable / (double)sizeTable;
    }
    
     /**
    * Method furthestNumberFrom
    *
    * @param table (double[])
    * @return maximum (double)
    */
    public static double furthestNumberFrom (double[] table)
    {
        double maximum = 0.0;
        double furthest = table[0];
        double index = 0.0;
        int sizeTable = table.length;
        double average = calculateArithmeticAverage(table);
        for (int i = 0; i < sizeTable; i++)
        {
            index = maximum;
            maximum = maximum(calculateGap(average,table[i]),calculateGap(average,furthest));
            if (maximum != index)
            {
                furthest = table[i];
            }
        }
        return furthest;
    }
    
     /**
    * Method closestNumberFrom
    *
    * @param table (double[])
    * @return minimum (double)
    */
    public static double closestNumberFrom (double[] table)
    {
        double closest = table[0];
        double lastMinimum = 0.0;
        double average = calculateArithmeticAverage(table);
        double minimum = calculateGap(average,closest);
        int sizeTable = table.length;
        for (int i = 0; i < sizeTable; i++)
        {
            lastMinimum = minimum;
            minimum = minimum(calculateGap(average,table[i]),calculateGap(average,closest));
            if (minimum != lastMinimum)
            {
                closest = table[i];
            }
        }
        return closest;
    }
    
     /**
    * Method minimum
    *
    * @param number (double), minimum (double)
    * @return minimum (double)
    */
    public static double minimum (double number, double minimum)
    {
        if (number <= minimum)
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
    public static double maximum (double number, double maximum)
    {
        if (number >= maximum)
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
    public static double calculateGap (double average, double number)
    {
        double gap = average - number;
        if (gap < 0)
        {
            gap = -gap;
        }
        return gap;
    }
}