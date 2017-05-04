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

    public ArrayList<Term> getTerms() {
        return terms;
    }

    /**
     * Multiplies this by a polynomial.
     *
     * @param polynomial the polynomial to multiply this by.
     * @return the product of this and the polynomial
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
     * Multiplies this by a single term.
     *
     * @param term the term to multiply this by.
     * @return the product of this and the term.
     */
    public Polynomial multiply(Term term) {
        ArrayList<Term> temp = new ArrayList<>();
        temp.add(term);
        Polynomial p = new Polynomial(temp);
        return multiply(p);
    }

    /**
     * Adds this and a polynomial.
     *
     * @param polynomial the polynomial to add to this.
     * @return the sum of this and the polynomial.
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
     * Puts polynomial in standard form.
     */
    private void setStandardForm() {
        addLikeTerms();
        // Sort terms by degree
        terms.sort((o1, o2) -> o1.getDegree() < o2.getDegree() ? 1 : -1);
    }

    /**
     * Adds like terms in polynomial.
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
     * Converts the polynomial to a string.
     *
     * @return this polynomial in string form.
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
