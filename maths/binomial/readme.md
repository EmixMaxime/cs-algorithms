# BinomialCoefficient

## Lecture
* [Wikipédia Coefficient binomial](https://fr.wikipedia.org/wiki/Coefficient_binomial)

## Qu'est-ce ?
### Les combinaisons
Les combinaisons ou (p,n) représentent le nombre de parties à p éléments d'un ensemble E à n éléments.


On les utilises dans le cas d'un tirage sans remise et sans ordre *(simultané)*.


Exemple : Dans une promotion nous avons 55 étudiants, on souhaite sélectionner 4 délégués. Combien de choix avons nous au total ? Ça revient choisir **4 étudiants parmis 5**.

## Formules mathématiques
Nous pouvons utiliser plusieurs formules, la plus connue qui fait intervenir des factorielles. Pour des raisons de performances, nous pouvons utiliser la propriété récursive des coefficients binomiaux d'entiers avec la relation de Pascal qui lie ces coefficients.

## Algorithme
```
# Paramètres n,k entiers naturels.
# Condition sur paramètres: k > n

binomialCoeff(n, k)
    si (k = 0 ou k = n) {
        retourner 1
    }

    retourner binomialCoeff(n-1, k-1) + binomialCoeff(n-1, k)
```