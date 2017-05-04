/**
 * This class models a term of the form ax^n in a polynomial,
 * where a and n are integers and n is non-negative.
 *
 * @author Reece Yang
 */

package io.github.reeceyang.cebysev;

public class Term {
    private int coefficient;
    private int degree;

    /**
     * Class constructor that specifies the coefficient and degree of the term.
     * Precondition: aDegree is non-negative.
     *
     * @param aCoefficient the coefficient of the term.
     * @param aDegree      the degree of the term.
     */
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

    /**
     * Returns the product of the current term and the specified term.
     *
     * @param term the term to multiply the current term by.
     * @return the product of the specified term and the current term.
     */
    public Term multiply(Term term) {
        int newCoefficient = term.getCoefficient() * coefficient;
        int newDegree = term.getDegree() + degree;
        return new Term(newCoefficient, newDegree);
    }

    /**
     * Converts the current term to a string [coefficient]x^[degree].
     * If the degree is 0 or the coefficient is 0 the x is omitted,
     * if the degree is 1 the exponent is omitted,
     * and if the coefficient is 1 or -1 the coefficient is omitted.
     *
     * @return the term as a string.
     */
    public String toString() {
        String string = "";
        if (degree == 0) {
            string += coefficient;
        } else {
            if (coefficient != 1) {
                if (coefficient == -1) {
                    string += "-";
                } else {
                    string += coefficient;
                }
            }
            if (coefficient != 0 && degree != 0) {
                string += "x";
            }
            if (degree > 1 && coefficient != 0) {
                string += "^" + degree;
            }
        }
        return string;
    }

    /**
     * Checks if the specified object is equal to the current term.
     * Two terms are equal if their coefficients and degrees are equal,
     * or if their coefficient is 0.
     *
     * @param object the object to compare to the current term.
     * @return true if the object is equal to the current term, false otherwise.
     */
    public boolean equals(Object object) {
        if (object instanceof Term) {
            Term otherTerm = (Term) object;
            if (otherTerm.getCoefficient() == coefficient
                    && otherTerm.getDegree() == degree) {
                return true;
            } else if (otherTerm.getCoefficient() == 0 && coefficient == 0) {
                return true;
            }
            return false;
        } else {
            return false;
        }
    }
}
