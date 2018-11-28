import java.util.Arrays;

class EuclidianAlgorithm
{
    public static int[] extended_euclid(int a, int b)
    {
        int q, r;

        int[] aCombinaison = {1,0};
        int[] bCombinaison = {0,1};
        int[] tmp;

        do {
            q = a / b;
            r = a % b;

            a = b;
            b = r;

            if (r > 0) {
                System.out.println("A combinaison");
                System.out.println(Arrays.toString(aCombinaison));
    
                System.out.println("B combinaison");
                System.out.println(Arrays.toString(bCombinaison));
    
                tmp = bCombinaison.clone();
    
                int[] bq = {
                    q * bCombinaison[0],
                    q * bCombinaison[1]
                };
    
                bCombinaison[0] = aCombinaison[0] - bq[0];
                bCombinaison[1] = aCombinaison[1] - bq[1];
                
                aCombinaison = tmp.clone();
            }

        } while(r > 0);

        return bCombinaison;
    }

    public static int gcd(int a, int b)
    {
        int q, r;

        do {
            q = a / b;
            r = a % b;
    
            a = b;
            b = r;
    
        } while(r > 0);

        return a;
    }

    public static int recursiveGcd(int a, int b)
    {
        if (b == 0)
            return a;
 
        return recursiveGcd(b, a % b);
    }
}
