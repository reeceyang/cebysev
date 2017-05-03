package io.github.reeceyang.cebysev;

public class Term {
    private int coefficient;
    private int degree;

    public Term(int aCoefficient, int aDegree) {
        coefficient = aCoefficient;
        degree = aDegree;
    }

    public int getCoefficient() {
        return coefficient;
    }

    public int getDegree() {
        return degree;
    }

    public Term multiply(Term term) {
        return new Term(term.getCoefficient() * coefficient, term.getDegree() + degree);
    }
}
