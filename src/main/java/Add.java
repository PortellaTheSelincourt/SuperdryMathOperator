public class Add implements Operator {

    @Override
    public int evaluate(int x, int y) {
        int r = x + y;

        if (r <= x  ||  r <= y) {
            return 0;
        } else {
            return r;
        }
    }

    @Override
    public String symbol() {
        return "+";
    }

}