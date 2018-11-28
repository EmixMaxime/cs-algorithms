class BinomialCoefficient
{

    static int binomialCoeff(int n, int k)  
    {
        if (k == 0 || k == n) {
            return 1;
        }

        return binomialCoeff(n-1, k-1) + binomialCoeff(n-1, k);
    }

    /**
     * O(k) time complexity.
     */
    static int binomialCoeffOpti(int n, int k) {
        if(k == 0) {
            return 1;
        }

        if(k > n/2) {
            return binomialCoeffOpti(n, n-k);
        }

        return n * binomialCoeffOpti(n-1, k-1) / k;
    }

}
