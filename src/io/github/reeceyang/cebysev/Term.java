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
     * Returns the product of this and term.
     *
     * @param term the term to multiply this by.
     * @return the product of term and this.
     */
    public Term multiply(Term term) {
        int newCoefficient = term.getCoefficient() * coefficient;
        int newDegree = term.getDegree() + degree;
        return new Term(newCoefficient, newDegree);
    }

    /**
     * Converts the term to a string [coefficient]x^[degree].
     * If the degree is 0 or the coefficient is 0 the x is omitted.
     * If the degree is 1 the exponent is omited.
     * If the coefficient is 1 or -1 the coefficient is ommitted.
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
     * Checks if an object is equal to this. Two terms are equal
     * if their coefficients and degrees are equal.
     *
     * @param object the object to compare to this.
     * @return true if object is equal to this, false otherwise.
     */
    public boolean equals(Object object) {
        if (object instanceof Term) {
            Term otherTerm = (Term) object;
            if (otherTerm.getCoefficient() == coefficient
                    && otherTerm.getDegree() == degree) {
                return true;
            }
            return false;
        } else {
            return false;
        }
    }
}
