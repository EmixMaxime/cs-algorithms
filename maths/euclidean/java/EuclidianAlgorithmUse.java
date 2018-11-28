class EuclidianAlgorithmUse
{
    public static void main(String[] args)
    {
        int a = 4539,
            b = 1958;

        int gcd = EuclidianAlgorithm.gcd(a, b);
        System.out.println(String.format("GCD(%d, %d) = %d", a, b, gcd));

        // a = 2244;
        // b = 780;

        // int[] idBezout = extended_euclid(a, b);
        // System.out.println(Arrays.toString(idBezout));
    }
}
