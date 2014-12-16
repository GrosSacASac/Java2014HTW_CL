public class Method3
{
    
     /**
    * Method insertionSort
    *
    * @param table (double[])
    * @return table (double[])
    */
    public double[] insertionSort (double[] table)
    {
        int length = table.length;
        double pivot = 0;
        int i = 0;
        for(int j = 1; j < length; j++)
        {
            pivot = table[j];
            i = j-1;
            while( i >= 0 && table[i] > pivot)
            {
                table[i+1] = table[i];
                i = i-1;
                table[i+1] = pivot;
            }
        }
        return table;
    }
}