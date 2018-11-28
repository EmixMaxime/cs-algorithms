## Fonction d'Ackermann

## Lecture
* [Des nombres grands, TRÈS grands - Micmaths](https://www.youtube.com/watch?v=oqMYAVV-hsA&t=730s)
* [The Most Difficult Program to Compute? - Computerphile](https://www.youtube.com/watch?v=i7sm9dzFtEI)
* [Wikipédia](https://fr.wikipedia.org/wiki/Fonction_d%27Ackermann)

## Qu'est-ce ?
Dans la théorie de la récursivité, la fonction d'Ackermann, est un exemple simple de fonction récursive non récursive primitive, trouvée en 1926 par Wilhelm Ackermann. C'est une fonction aussi simple que fascinante.

## Complexité
Essayez avec `m = 4` ainsi que `n = 1` et admirez ! Votre JVM risque de ne pas apprécier.

Très rapidement le résultat doit être noté en utilisant la [notation des puissances itérées de Knuth](https://fr.wikipedia.org/wiki/Notation_des_puissances_it%C3%A9r%C3%A9es_de_Knuth).

## Algorithme
La fonction Ackermann prend en paramètre deux entiers naturels `m,n` et retourne un entier naturel comme valeur.

```
ackermann(m, n)
    si m = 0 alors
        retourner n+1
    sinon si n = 0 alors
        retourner ackermann(m-1, 1)
    sinon
        retourner ackermann(m-1, ackermann(m, n-1))

```

## Étude de l'arrêt
La condition d'arrêt se fait sur `m == 0`, nous devons donc répondre à la question suivante : est-ce que le paramètre `m` atteind cette valeur ?


Pour répondre à cette question, il faut regarder la nature de `m` et de `n`, ils sont tous deux des entiers naturels. À chaque étape `m` ou `n` se voit soustraire `1`. La valeur 0 sera donc atteinte.

