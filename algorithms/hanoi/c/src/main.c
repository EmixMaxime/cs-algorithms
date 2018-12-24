#include <stdio.h>
#include <stdlib.h>

#include "hanoi.h"

int main()
{
  int nbdisques, affichage = 0;
  int depart, arrivee;
  int choix_jeu;

  /**
   * any struct (or array) in C language can be initialized with { 0 }.
   * Any type in C can be initialized with {0}. int x = {0}; is valid C
   * Much cleaner than using memset like 
   * int arr[20];
   * memset(arr, 0, sizeof arr);
   * 
   * Since C99
   * https://stackoverflow.com/a/5636111
   */
  tjeu jeu = {0};

  printf("Tours de Hanoi\n\n");

  do {
    printf("Quel type de jeu ? \n0 : Quitter\n1 : Manuel\n2 : Automatique\n -> Choix : ");
    scanf("%d", &choix_jeu);

    if (choix_jeu == 2 || choix_jeu == 1) {
      do {
        printf("Nombre de disques a deplacer [1-10] : ");
        scanf("%d", &nbdisques);
      } while (nbdisques < 1 || nbdisques > NB_MAX_OF_DISK);

      init(&jeu, nbdisques);

      console_print(jeu);

      switch (choix_jeu) {
        case 1:
          while (!(gagner(&jeu))) {
            do {
              printf("Deplacer le sommet de : ");
              scanf("%d", &depart);
              printf("vers la tour : ");
              scanf("%d", &arrivee);
            } while (depart < 0 || depart > 2 || arrivee < 0 || arrivee > 2);

            deplacer_un_disque(&jeu, depart, arrivee);
          }
          break;

        case 2:
          solve(&jeu);
          console_print(jeu);
          break;
      }
    }
  } while (choix_jeu != 0);

  return 0;
}
