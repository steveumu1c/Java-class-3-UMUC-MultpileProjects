package try1;

public abstract class Sequence {

    //Since you are using ints just know your program doesn't work past n = 50
    // If you used Long or some other type you would be able to perform operations past n = 50

    private static int efficiencyTotalRecursive;
    private static int efficiencyTotalIterative;

    public static int performRecursive(int sequenceIndex) {
        //BaseCase
        if (sequenceIndex == 0 || sequenceIndex == 1) {
            efficiencyTotalRecursive++;
            return sequenceIndex;
        }
        return computeRecursive(sequenceIndex-1,0,1);
    }

    private static int computeRecursive(int sequenceIndex, int previousValue, int currentValue) {
        efficiencyTotalRecursive++;
        return (sequenceIndex == 0) ? currentValue :
                computeRecursive(--sequenceIndex, currentValue,previousValue + (currentValue * 2));
    }

    private int performRecursionMethod(int n)
    {
        int theNthTerm;

        efficiencyTotalRecursive++;
        if (n == 0 || n == 1) {
            theNthTerm = n;
            //could return n;

        } else {

            theNthTerm = 2 * performRecursionMethod(n - 1) + performRecursionMethod(n - 2);
            //could just return the above
            // return 2 * performRecursionMethod(n - 1) + performRecursionMethod(n - 2);
        }
        return theNthTerm;
        //would no longer need
    }

    //Yours re-written
    private int performRecursionMethodReWritten(int index) {
        efficiencyTotalRecursive++;
        if (index == 0 || index == 1) {
            return index;
        } else {
         return 2 * performRecursionMethodReWritten(index - 1) + performRecursionMethodReWritten(index - 2);
        }
    }


    public static int performIterativeMethod(int n)
    {
        int theNthTerm = 0;
        if (n == 0 || n == 1) {
            return n;
        } else {
            int twicePriorTerm = 0;

            int otherPriorTerm = 1;

            for (int i = 2; i <= n; i++)
            {
                efficiencyTotalIterative++;
                theNthTerm = 2 * otherPriorTerm + twicePriorTerm;
                twicePriorTerm = otherPriorTerm;
                otherPriorTerm = theNthTerm;
            }
        }
        return theNthTerm;
    }

    public static int getEfficiencyTotalRecursive() {
        int efficiency = efficiencyTotalRecursive;
        efficiencyTotalRecursive = 0;
        return efficiency;
    }

    public static int getEfficiencyTotalIterative() {
        int efficiency = efficiencyTotalIterative;
        efficiencyTotalIterative = 0;
        return efficiency;
    }
}
// Sample file format
// value, iter.effeciency, recur.effecieny