package ru.spbstu.telematics.java;

public class App
{
    public static double[] SOE(double[][] coef, double[] equally)
    {
        int n = equally.length;

        for (int i = 0; i < n; i++)
        {
            int maxRow = i;
            for (int j = i + 1; j < n; j++) {
                if (Math.abs(coef[j][i]) > Math.abs(coef[maxRow][i]))
                    maxRow = j;
            }

            double[] temp = coef[i];
            coef[i] = coef[maxRow];
            coef[maxRow] = temp;

            double tempConstant = equally[i];
            equally[i] = equally[maxRow];
            equally[maxRow] = tempConstant;

            for (int k = i + 1; k < n; k++)
            {
                double factor = coef[k][i] / coef[i][i];
                equally[k] -= factor * equally[i];
                for (int j = i; j < n; j++)
                    coef[k][j] -= factor * coef[i][j];
            }
        }

        double[] solution = new double[n];
        for (int i = n - 1; i >= 0; i--)
        {
            solution[i] = equally[i] / coef[i][i];
            for (int j = i - 1; j >= 0; j--)
                equally[j] -= coef[j][i] * solution[i];
        }
        return solution;
    }
}