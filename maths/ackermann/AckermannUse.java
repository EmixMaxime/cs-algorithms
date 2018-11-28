class AckermannUse
{
    public static void main(String[] args)
    {
        int m = 3, n = 4;
        int result = Ackermann.ackermann(m, n);

        if (m < 0 || n < 0) {
            throw new ArithmeticException("m and n have to be natural numbers.");
        }
    
        // Should be 125
        System.out.printf("akermann(%d,%d) = %d \n", m, n, result);
    }
}
