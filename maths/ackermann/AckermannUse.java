class AckermannUse
{
    public static void main(String[] args)
    {
        int m = 3, n = 4;
        int result = Ackermann.ackermann(m, n);
    
        // Should be 125
        System.out.printf("akermann(%d,%d) = %d \n", m, n, result);
    }
}
