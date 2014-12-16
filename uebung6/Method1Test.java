
import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * A classe de teste Method1Test.
 *
 * @author  (seu nome)
 * @version (um número de versão ou data)
 */
public class Method1Test
{
    /**
     * Construtor default para a classe de teste Method1Test
     */
    public void Method1Test()
    {
    }

    @Test
    public void calculateArithmeticAverageTest()
    {
        double[] table = {1.0,
                          2.0,
                          3.0,
                          6.0,
                          8.0};
        double wanted = 4.0;
        assertArrayEquals(Method1.calculateArithmeticAverage(table), wanted ,"");
    }

    @Test
    public void calculateArithmeticAverageTest2()
    {
        double[] table = {1.0,
                          -1.0};
        double wanted = 0.0;
        assertArrayEquals(Method1.calculateArithmeticAverage(table), wanted ,"");
    }

    @Test
    public void furthestNumberFromTest()
    {
        double[] table = {1.0,
                          2.0,
                          3.0,
                          6.0,
                          8.0};
        double wanted = 8.0;
        assertArrayEquals(Method1.furthestNumberFrom(table), wanted ,"");
    }

    @Test
    public void closestNumberFromTest()
    {
        double[] table = {1.0,
                          2.0,
                          3.0,
                          6.0,
                          8.0};
        double wanted = 3.0;
        assertArrayEquals(Method1.closestNumberFrom(table), wanted ,"");
    }
    
    /**
     * Define a .
     *
     * Chamado antes de cada método de caso de teste.
     */
    @Before
    public void setUp()
    {
    }

    /**
     * Tears down the test fixture.
     *
     * Chamado após cada método de teste de caso.
     */
    @After
    public void tearDown()
    {
    }
}
