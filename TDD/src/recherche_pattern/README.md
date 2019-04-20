# A Fast String Search Algorithm

L'objectif de ce travail est de retrouver en Java et en suivant une démarche TDD (Test Driven Development) l'alogithme de recherche de chaîne de caractères Boyer-Moore tel que présenté par Robert S. Boyer et J. Strother Moore dans [leur publication](https://github.com/KevinDelcourt/ExosJava/blob/master3/TDD/src/recherche_pattern/p762-boyer%20(1).pdf)  dans la revue *Communications of the ACM* en Octobre 1977.

## Démarche adoptée

Afin de saisir le comportement de l'algorithme et trouver les tests nécessaires à son implémentation j'ai mis en place [ce document](https://docs.google.com/spreadsheets/d/1OfKWaikgvrTAu7jdkFHZ7jvELX9LYWJtjClGfXqf4KA/edit#gid=0) comme support de mes recherches. Ensuite, afin de pouvoir tester la performance de l'algorithme, qui est le seul point le différenciant d'un algorithme de recherche classique il m'a fallu d'abord réaliser [Une classe abstraite](https://github.com/KevinDelcourt/ExosJava/blob/master3/TDD/src/recherche_pattern/MesurableRecherchePattern.java) ayant la charge de compter le nombre d'accès à la chaîne dans laquelle s'effectue la recherche. Cela m'a permis de d'écrire des tests vérifiant que mon implémentation respectait les performances décrites dans l'article.

## Conclusion

J'ai ainsi pu reconstituer une implémentation de l'algorithme Boyer-Moore en java respectant les exigences de l'article, en en implémentant les termes clés (delta1, delta2, rightmostPlausibleReoccurence...) sous formes de fonctions testées.

Par ailleurs j'ai pu comparer les performances de cet algorithme avec un algorithme de recherche naif (de complexité quadratique).

Voir ci-dessous un extrait du rapport généré par les tests:

*NaiveRecherchePattern*
Recherche de 'WHICH'(5)
Dans '...WHICH-FINALLY-HALTS.--AT-THAT-POINT...'(41)
8 Itérations

*FastRecherchePattern*
Recherche de 'WHICH'(5)
Dans '...WHICH-FINALLY-HALTS.--AT-THAT-POINT...'(41)
7 Itérations

*NaiveRecherchePattern*
Recherche de 'NT...'(5)
Dans '...WHICH-FINALLY-HALTS.--AT-THAT-POINT...'(41)
42 Itérations

*FastRecherchePattern*
Recherche de 'NT...'(5)
Dans '...WHICH-FINALLY-HALTS.--AT-THAT-POINT...'(41)
15 Itérations

*NaiveRecherchePattern*
Recherche de 'AT-THAT'(7)
Dans '...WHICH-FINALLY-HALTS.--AT-THAT-POINT...'(41)
34 Itérations

*FastRecherchePattern*
Recherche de 'AT-THAT'(7)
Dans '...WHICH-FINALLY-HALTS.--AT-THAT-POINT...'(41)
14 Itérations
