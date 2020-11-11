/**
 * Decided to make a Interface for the common operators, instead of having all the logic in the main file.
 */
public interface Operator {
    int evaluate(int x, int y);

    String symbol();
}
