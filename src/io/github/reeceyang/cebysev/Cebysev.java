/**
 * This is the driver class for the Cebysev Polynomials project.
 * It constructs the first 10 Cebysev Polynomials, places them
 * in an ArrayList, and prints them to the console.
 * @author Reece Yang
 */

package io.github.reeceyang.cebysev;

import java.util.ArrayList;

public class Cebysev {
    private ArrayList<Polynomial> cebysevPolynomials;

    /**
     * Default class constructor constructs the first 10 Cebysev Polynomials,
     * places them in an ArrayList, and prints them to the console.
     */
    public Cebysev() {
        cebysevPolynomials = new ArrayList<>();

        Polynomial old2 = new Polynomial(new Term(1, 0));
        System.out.println(old2);
        Polynomial old1 = new Polynomial(new Term(1, 1));
        System.out.println(old1);
        for (int i = 2; i < 10; i++) {
            Polynomial current = old1.multiply(new Term(2, 1)).subtract(old2);
            cebysevPolynomials.add(current);
            System.out.println(current);
            old2 = old1;
            old1 = current;
        }
    }

    public static void main(String[] args) {
        Cebysev c = new Cebysev();
    }
}

/*

1
x
2x^2 - 1
4x^3 - 3x
8x^4 - 8x^2 + 1
16x^5 - 20x^3 + 5x
32x^6 - 48x^4 + 18x^2 - 1
64x^7 - 112x^5 + 56x^3 - 7x
128x^8 - 256x^6 + 160x^4 - 32x^2 + 1
256x^9 - 576x^7 + 432x^5 - 120x^3 + 9x

 */