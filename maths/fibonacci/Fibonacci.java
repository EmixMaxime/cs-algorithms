class Matrix
{
    /**
     * Crappy 2*2 matrix multiplication
     */
    static void multiply(int F[][], int M[][]) 
    {
        int x =  F[0][0]*M[0][0] + F[0][1]*M[1][0];
        int y =  F[0][0]*M[0][1] + F[0][1]*M[1][1];
        int z =  F[1][0]*M[0][0] + F[1][1]*M[1][0];
        int w =  F[1][0]*M[0][1] + F[1][1]*M[1][1];

        F[0][0] = x;
        F[0][1] = y;
        F[1][0] = z;
        F[1][1] = w;
    }

    // https://stackoverflow.com/questions/1374639/how-do-i-create-an-identity-matrix-of-arbitrary-size-in-java
    // https://www.roseindia.net/tutorial/java/core/createIdentityMatrix.html
    public static int[][] getIdentity(int size) {
        int[][] matrix = new int[size][size];

        for(int i = 0; i < size; i++) {
            matrix[i][i] = 1;
        }

        return matrix;
    }

    /* Helper function that calculates F[][] raise to the power n and puts the 
    result in F[][] 
    Note that this function is designed only for fib() and won't work as general 
    power function */
    static void power(int F[][], int n) 
    { 
        int i;
        int identityMatrix[][] = new int[][]{{1,1},{1,0}};

        // n - 1 times multiply the matrix to {{1,0},{0,1}} 
        for (i = 2; i <= n; i++) {
            multiply(F, identityMatrix);
        }
    }

    /**
     * Optimized power of matrix
     */
    static void power(int F[][], int n) 
    {
        if( n == 0 || n == 1) {
            return;
        }

        int M[][] = new int[][]{{1,1},{1,0}};

        power(F, n / 2);
        multiply(F, F);

        if (n % 2 != 0) {
            multiply(F, M);
        }
    }
}

class Fibonacci
{
    public static int count;

    /**
     * Time Complexity: T(n) = T(n-1) + T(n-2) which is exponential.
     * Extra Space: O(n) if we consider the function call stack size, otherwise O(1).
     */
    public static int fibonacci_recursif(int n) 
    {
        count++;

        // if(n == 0) {
        //     return 0;
        // }
        // else if(n == 1) {
        //     return 1;
        // }
        
        // if (n <= 1) return n;

        if (n < 2) return n;

        return fibonacci_recursif(n - 1) + fibonacci_recursif(n - 2);
    }

    /**
     * Time Complexity: O(n)
     * Extra Space: O(n)
     */
    static int fibonacci_dynamic(int n) 
    {
        /* Declare an array to store Fibonacci numbers. */
        int f[] = new int[n+2]; // 1 extra to handle case, n = 0 
        int i; 

        /* 0th and 1st number of the series are 0 and 1*/
        f[0] = 0; 
        f[1] = 1; 
      
        for (i = 2; i <= n; i++) {
            // Add the previous 2 numbers in the series and store it
            f[i] = f[i-1] + f[i-2]; 
        }
       
        return f[n];
    }

    /**
     * We can optimize the space used in method 2
     * by storing the previous two numbers
     * only because that is all we need to get the next Fibonacci number in series.
     * 
     * Time Complexity: O(n)
     * Extra Space: O(1)
     */
    static int fibonacci_iteratif(int n) 
    { 
        int a = 0,
            b = 1,
            c;

        if (n == 0) {
            return a; 
        }

        // begin at i = 2 since fib(0) = fib(1) = fib(2)
        for (int i = 2; i <= n; i++) { 
            c = a + b;
            a = b;
            b = c;
        }

        return b; 
    }

    static int fib(int n) 
    { 
        int F[][] = new int[][]{{1,1},{1,0}};

        if (n == 0) {
            return 0;
        }

        power(F, n-1);

        return F[0][0];
    }

    public static void main(String[] args)
    {
        int r = fibonacci(12);

        System.out.println(r);
        System.out.println(count);

        count = 0;
        int r2 = fibonacci_dynamic(12);
        System.out.println(r2);
        System.out.println(count);
    }
}
