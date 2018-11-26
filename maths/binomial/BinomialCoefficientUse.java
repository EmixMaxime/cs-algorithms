
class BinomialCoefficientUse
{
    public static void main(String[] args)
    {
        int n = 15,
            k = 11;

        if (k > n) {
            throw new ArithmeticException("k > n");
        }

        // n = 15, k = 11 => 1365
        System.out.printf(
            "Value of C(%d, %d) is %d \n",
            n, k, BinomialCoefficient.binomialCoeff(n, k)
        ); 
    }
}
