/**Third part of the exercise
 * @author LUCIE BECHTOLD / CYRIL WALLE 
 * @version 1.0
 */
 
public class Method3
{
    
     /**
    * Method insertionSort
    *
    * @param table (int[])
    * @return table (int[])
    */
    public static int[] insertionSort (int[] table)
    {
        int length = table.length;
        int pivot = 0;
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