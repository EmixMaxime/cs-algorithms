#include <stdio.h>

/**
 * Using differences
 * Not very efficient:
 *  If one of the given numbers is much bigger
 *  than the other.
 * 
 * In the subtraction-based version which was Euclid's original version,
 * the remainder calculation (b = a mod b) is replaced by
 * repeated subtraction.
 * Contrary to the division-based version, which works with arbitrary integers as input,
 * the subtraction-based version supposes that the input consists of positive integers and stops when a = b.
 */
int substract_gcd(int a, int b)
{
    while (a != b) {
        if (a > b) {
            a -= b;
        } else {
            b -= a;
        }
    }

    // Could returns b since a = b
    return a;
}

/**
 * Replaces the larger of the two numbers
 * by its remainder when divided by the smaller of the two.
 * 
 * Stops when reaching zero remainder and now the algo
 * never requires more steps than five * the number of digits (base 10) of the smaller integer.
 * (see Lamé theorem)
 */
int gcd(int a, int b)
{
    int q, r;

    do {
        q = a / b;
        r = a % b;

        a = b;
        b = r;

    } while(b > 0);

    return a;
}

int recursive_gcd(int a, int b)
{
    if (b == 0)
       return a;

    return recursive_gcd(b, a % b);
}

int extended_gcd(int a, int b, int *x, int *y)
{
	if (a == 0) {
        *x = 0;
		*y = 1;
		return b;
	}

	int _x, _y;
	int gcd = extended_gcd(b % a, a, &_x, &_y);

	*x = _y - (b/a) * _x;
	*y = _x;

	return gcd;
}
