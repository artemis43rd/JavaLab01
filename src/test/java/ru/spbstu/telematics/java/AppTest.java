package ru.spbstu.telematics.java;

import org.junit.Test;
import static org.junit.Assert.assertArrayEquals;

public class AppTest
{
    @Test
    public void testSLS()
    {
        // Cистема линейных уравнений:
        // 2x + 3y - z = 1
        // 4x - y + 2z = -2
        // -x + 2y - 3z = 3
        double[][] coef = {{2, 3, -1}, {4, -1, 2}, {-1, 2, -3}};
        double[] equally = {1, -2, 3};

        double[] expectedSolution = {0, 0, -1};

        double[] solution = App.SLS(coef, equally);

        assertArrayEquals(expectedSolution, solution, 1e-10);
    }

    @Test
    public void test2SLS()
    {
        // Другая система линейных уравнений:
        // x + 2y + 3z = 6
        // 2x + y + z = 4
        // 3x + 3y + 4z = 11
        double[][] coef = {{1, 2, 3}, {2, 1, 1}, {3, 3, 4.5}};
        double[] equally = {6, 4, 11};

        double[] expectedSolution = {1.333333333333333, -0.666666666666667, 2};

        double[] solution = App.SLS(coef, equally);

        assertArrayEquals(expectedSolution, solution, 1e-10);
    }
}