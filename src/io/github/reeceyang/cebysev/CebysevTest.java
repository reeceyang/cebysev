package io.github.reeceyang.cebysev;

public class CebysevTest {
    public static void main(String[] args) {
        Polynomial old2 = new Polynomial(new Term(1, 0));
        System.out.println(old2);
        Polynomial old1 = new Polynomial(new Term(1, 1));
        System.out.println(old1);
        for (int i = 2; i < 10; i++) {
            Polynomial current = old1.multiply(new Term(2, 1)).subtract(old2);
            System.out.println(current);
            old2 = old1;
            old1 = current;
        }
    }
}
