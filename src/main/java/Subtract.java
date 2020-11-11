public class Subtract implements Operator {

    /**
     * We need to create the logic for subtracting and implement all of its rules.
     * This logic avoids negative numbers in our calculation.
     * @param x it can't be null, in order to work.
     * @param y it can't be null, in order to work.
     * @return returns the correct subtraction depending on the values.
     */
    @Override
    public int evaluate(int x, int y) {
        if (x < y) {
            return y - x;
        } else {
            return x - y;
        }
    }

    /**
     * Here we will return the symbol used for this calculation
     * @return minus symbol
     */
    @Override
    public String symbol() {
        return "-";
    }

}