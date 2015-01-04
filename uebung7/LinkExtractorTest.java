

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class Method3Test.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class Method3Test
{
    /**
     * Default constructor for test class Method3Test
     */
    public Method3Test()
    {
    }

    @Test
    public void insertionSortTest()
    {
        int[] unsorted = {99,3,2,1,45};
        int[] wanted = {1,2,3,45,99};
        assertArrayEquals(Method3.insertionSort(unsorted), wanted);
    }
    
    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @Before
    public void setUp()
    {
    }

    /**
     * Tears down the test fixture.
     *
     * Called after every test case method.
     */
    @After
    public void tearDown()
    {
    }
}
