#include <stdio.h>
#include "euclidian-algorithm.h"

int main(void) 
{
    int a, b;

    a = 4539;
    b = 1958;
    int result = gcd(a,b);
    // int result = substract_gcd(a,b);

    printf("gcd(%d, %d) = %d \n", a, b, result);

    a = 30;
	b = 50;

	int x, y, gcd = extended_gcd(a, b, &x, &y);

	printf("%d * %d + %d * %d = %d \n", a,x, b,y);

    return 0;
}
