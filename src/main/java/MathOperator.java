import java.util.ArrayList;

/**
 * I am sure there are more elegant ways of producing the answer for this exercise but the only thing i could think of was brute force,
 * meaning that to solve this exercise we would have to iterate on all the numbers to use and apply all the possible calculations to reach the answer.
 * <p>
 * There are a few faults with this logic:
 * it does not use all of its given numbers to reach the answer.
 * earlier version i had added random number generator and it was not possible to guarantee the correct output.
 * brute force as we mentioned earlier, looking around for other means to tackle this, i noticed some other developers transformed their numbers into bit's (010101) and have the logic work around that. which thinking about it might not have been too bad.
 * "()" missing from the logic. thought i'd add in the basics first and end up spending too much time on the basics and did not add braces. (agile it!)
 * It will cheat and reuse the symbols to get the correct answer. for example if you have total = 43 and the other four numbers 1,3,4 & 5 the solution printed will display 4 * 3 = 12, 12 * 4 = 48 and 48 - 5 = 43.
 */
public class MathOperator {

    public static void main(String[] args) {
        int[] numbers = {1, 3, 4, 5};
        int total = 16;

        MathOperator calculate = new MathOperator();

        if (calculate.findSolution(numbers, numbers.length, total)) {
            System.out.println("These numbers work and you can get a solution out of it.");
            calculate.printSolution();
        } else {
            System.out.println("You can't get a solution out of these numbers");
        }

    }

    /**
     * We create an object with the various logics(-,+,*) from the interface into our array.
     * We make it static for memory management and we know that the logic will never change.
     * We make it final to protect the values that have been assigned to it.
     * We make it private because we know this is the only class accessing it.
     */
    private static final Operator[] OPERATIONS = {new Add(), new Subtract(), new Multiply()};

    private final ArrayList<String> solution = new ArrayList<>(); //create an array list which will contain the correct/approved solution that we are after.

    /**
     * This is where the real logic starts! the array takes in parameters take in
     *
     * @param t     takes in the numbers to consider in the total calculation target
     * @param nb    the length of the array
     * @param total This is the total target we are trying to reach with the given numbers.
     * @return if the total target equals a number already in the array, it means that we already been through the calculation and returns true
     */
    public boolean findSolution(int[] t, int nb, int total) {
        for (int i = 0; i < nb; i++) {                                                  //Increment i by 1 each time to check the position in the array.
            if (t[i] == total) {                                                        //we compare each value in the array with our total.
                return true;
            }

            for (int j = i + 1; j < nb; j++) {
                for (Operator operation : OPERATIONS) {                                 //Similar process as we done above, but here we are making sure we iterate through the OPERATIONS array which holds our add, multiply & subtract logics.
                    int result = operation.evaluate(t[i], t[j]);                        // We apply each operation and get the result of each operation by using our interface, which will show us "number symbol number"

                    if (result != 0) {                                                  //If the result of the calculation is not 0, we add it to the new list to be used.
                        int saveiToArray = t[i], savejToArray = t[j];
                        t[i] = result;
                        t[j] = t[nb - 1];
                        if (findSolution(t, nb - 1, total)) {                        //We will now use the new numbers we have create above to find the solution
                            solution.add(Math.max(saveiToArray, savejToArray) + " " +    //Returns the greater of two values
                                    operation.symbol() + " " +
                                    Math.min(saveiToArray, savejToArray) + " = " + result);
                            return true;
                        }

                        t[i] = saveiToArray;
                        t[j] = savejToArray;
                    }
                }
            }
        }

        return false; // returning false if the total has not been found yet and carries on with the iteration until it finds.
    }

    /**
     * Here we will read the approved solution from the list and print it, to the console.
     */
    public void printSolution() {
        for (int i = solution.size() - 1; i >= 0; i--) {                                    //Returns the number of elements in this list. We will need to reverse this array for a good format.
            System.out.println(solution.get(i));
        }
    }

}