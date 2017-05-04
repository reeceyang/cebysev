package io.github.reeceyang.cebysev;

import java.util.ArrayList;

public class CebysevTest {
    public static void main(String[] args) {
        Term t = new Term(1, 2);
        Term u = new Term(2, 1);
        ArrayList<Term> p = new ArrayList<>();
        p.add(t);
        p.add(u);
        ArrayList<Term> q = new ArrayList<>();
        q.add(t);
        q.add(u);
        Polynomial a = new Polynomial(p);
        Polynomial b = new Polynomial(q);
        System.out.println(a);
        System.out.println(b);
        System.out.println(a.multiply(b));
        System.out.println(b.add(a));
    }
}
