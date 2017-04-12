package com.omereldar;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[][] intArray =
                {{1, 1, 2, 2},
                 {1, 1, 2, 2},
                        {2, 2, 1, 1},
                        {2, 2, 1, 1}};
        int r = intArray.length;
        int c = intArray[0].length;
        int rStretch = 10;
        int cStretch = 10;
        double rFact = factor(r, rStretch);
        double cFact = factor(c, cStretch);
        int[][] stretched = stretch(intArray, rFact, cFact);
        printMat(stretched);
    }

    private static double factor (int f, int s) {
        double x;
        x = (double)s/(double)f;
        return x;
    }

    static void printMat(int[][] mat) {
        for (int[] row : mat) {
            System.out.println(Arrays.toString(row));
        }
    }

    private static int[][] stretch(int[][] ints, double rfactor, double cfactor) {
        double rows = ints.length*rfactor;
        double cols = ints[0].length*cfactor;
        int[][] out  = new int[(int)rows][(int)cols];

        for(int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                double x = r/rfactor;
                double y = c/cfactor;
                out[r][c] = ints[(int)x][(int)y];
            }
        }
        return out;
    }
}

