# Algorithme d'Euclide

## Lecture
* [Euclidian algorithm](https://en.wikipedia.org/wiki/Euclidean_algorithm)

## Qu'est-ce ?
Permet de déterminer le PGCD *(plus grand diviseur commun)* de deux entiers efficacement.

## Euclide étendue
Identité de Bézout :

```
PGCD(a,b) = d
=>
au + bv = d
```

Pour deux nombres donné `a` et `b` nous pouvons trouver une combinaison linéraire qui est égal à leur PGCD.

Théorème de Bézout est un cas particulier de l'identité de Bézout :

```
PGCD(a,b) = 1
<=>
au + bv = 1
```

Ainsi, si la combinaison linéaire `au + bv = 1` alors `a` et `b` sont premiers entre eux, la réciproque est vraie.


Ce qui n'est pas le cas pour l'identité de bézout. En effet, je ne peux pas affirmer que la combinaison `au + bv = d` donne en résultat le PGCD.

## Algorithme

### Euclide étendu

```
Entrée : a, b entiers (naturels)
Sortie : r entier (naturel) et  u, v entiers relatifs tels que r = pgcd(a, b) et r = a*u+b*v

Initialisation : r := a, r' := b, u := 1, v := 0, u' := 0, v' := 1
                  q  quotient entier
                  rs, us, vs  variables de stockage intermédiaires

les égalités r = a*u+b*v et r' = a*u'+b*v' sont des invariants de boucle

tant que (r' ≠ 0) faire
    q := r÷r'
    rs := r, us := u, vs := v,
    r := r', u := u', v := v',
    r' := rs - q*r', u' = us - q*u', v' = vs - q*v'
   fait
renvoyer (r, u, v)
```
