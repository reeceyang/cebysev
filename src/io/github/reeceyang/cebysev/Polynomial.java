package io.github.reeceyang.cebysev;

import java.util.ArrayList;

public class Polynomial {
    private ArrayList<Term> terms;

    /**
     * Class constructor that specifies the terms of the polynomial.
     *
     * @param someTerms the terms of the polynomial.
     */
    public Polynomial(ArrayList<Term> someTerms) {
        terms = someTerms;
        setStandardForm();
    }

    /**
     * Class constructor that constructs a polynomial with the specified term.
     *
     * @param term the single term of the polynomial.
     */
    public Polynomial(Term term) {
        ArrayList<Term> temp = new ArrayList<>();
        temp.add(term);
        terms = temp;
        setStandardForm();
    }

    public ArrayList<Term> getTerms() {
        return terms;
    }

    /**
     * Multiplies the current polynomial by the specified polynomial.
     *
     * @param polynomial the polynomial to multiply this by.
     * @return the product of the current polynomial and the specified polynomial
     */
    public Polynomial multiply(Polynomial polynomial) {
        ArrayList<Term> otherTerms = polynomial.getTerms();
        ArrayList<Term> newTerms = new ArrayList<>();
        for (Term otherTerm : otherTerms) {
            for (Term term : terms) {
                newTerms.add(otherTerm.multiply(term));
            }
        }
        return new Polynomial(newTerms);
    }

    /**
     * Multiplies the current polynomial by the specified term.
     *
     * @param term the term to multiply the current polynomial by.
     * @return the product of the current polynomial and the specified term.
     */
    public Polynomial multiply(Term term) {
        ArrayList<Term> temp = new ArrayList<>();
        temp.add(term);
        Polynomial p = new Polynomial(temp);
        return multiply(p);
    }

    /**
     * Adds the current polynomial and the specified polynomial.
     *
     * @param polynomial the polynomial to add to the current polynomial.
     * @return the sum of the specified polynomial and the current polynomial.
     */
    public Polynomial add(Polynomial polynomial) {
        ArrayList<Term> newTerms = new ArrayList<>();
        for (Term term : terms) {
            newTerms.add(term);
        }
        for (Term term : polynomial.getTerms()) {
            newTerms.add(term);
        }
        return new Polynomial(newTerms);
    }

    /**
     * Subtracts the specified polynomial from the current polynomial.
     *
     * @param polynomial the polynomial to subtract from the current polynomial.
     * @return the difference of the current polynomial and the specified polynomial.
     */
    public Polynomial subtract(Polynomial polynomial) {
        return this.add(polynomial.multiply(new Term(-1, 0)));
    }

    /**
     * Puts the polynomial in standard form. The terms are arranged so that the
     * terms with the greatest degrees are first.
     */
    private void setStandardForm() {
        addLikeTerms();
        // Sort terms by degree
        terms.sort((o1, o2) -> o1.getDegree() < o2.getDegree() ? 1 : -1);
    }

    /**
     * Adds the like terms in the polynomial. Like terms have the same degree.
     */
    private void addLikeTerms() {
        int i = 0;
        while (i < terms.size()) {
            for (int j = i + 1; j < terms.size(); j++) {
                if (terms.get(i).getDegree() == terms.get(j).getDegree()) {
                    terms.add(new Term(terms.get(i).getCoefficient()
                            + terms.get(j).getCoefficient(), terms.get(i).getDegree()));
                    terms.remove(j);
                    terms.remove(i);
                    i--;
                    break;
                }
            }
            i++;
        }
    }

    /**
     * Converts the current polynomial to a string.
     *
     * @return the current polynomial in string form.
     */
    public String toString() {
        String string = "";
        for (Term term : terms) {
            string += term + " + ";
        }
        string = string.replaceAll("\\+ -", "- ");
        string = string.substring(0, string.length() - 2);
        return string;
    }
}
