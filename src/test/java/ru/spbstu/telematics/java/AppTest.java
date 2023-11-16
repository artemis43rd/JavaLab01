package ru.spbstu.telematics.java;

import org.junit.Test;
import static org.junit.Assert.assertArrayEquals;

public class AppTest {

    @Test
    public void testSOE()
    {
        // Cистема линейных уравнений:
        // 2x + 3y - z = 1
        // 4x - y + 2z = -2
        // -x + 2y - 3z = 3
        double[][] coef = {{2, 3, -1}, {4, -1, 2}, {-1, 2, -3}};
        double[] equally = {1, -2, 3};

        double[] exSolution = {0, 0, -1};

        double[] solution = App.SOE(coef, equally);

        // Проверка корректности решения с определенной точностью
        assertArrayEquals(exSolution, solution, 1e-10);
    }
}