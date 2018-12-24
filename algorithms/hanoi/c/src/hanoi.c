#include <stdio.h>
#include <stdlib.h>
#include <stdbool.h>

#include "hanoi.h"

int nb_deplacements = 0;

/**
 * Initialisation des 3 tours (piliers)
 * 
 * la premiere tour (n°0) doit contenir les `nb_disk` empilés et le sommet mis à nb_disk-1
 * les autres ont leur sommet mis a -1 : pas de disque
 * 
 */
void init(tjeu *j, int nb_disk)
{
  int x;

  for (x = 0; x < nb_disk; x++) {
    j->tours[0][x] = nb_disk - x;
  }

  j->sommets[0] = nb_disk - 1;
  j->sommets[1] = -1;
  j->sommets[2] = -1;

  j->nb_disk = nb_disk;
}

void afficher(tjeu j)
{
  int niveau;

  // CONSOLE_PRINT niveau par niveau (boucle), tour par tour (manuel !)
  for (niveau = j.nb_disk - 1; niveau >= 0; niveau--) {
    // tour 1
    if (j.sommets[0] < niveau)
      printf(" | ");
    else
      printf(" %d ", j.tours[0][niveau]);
    // tour 1
    if (j.sommets[1] < niveau)
      printf(" | ");
    else
      printf(" %d ", j.tours[1][niveau]);
    // tour 2
    if (j.sommets[2] < niveau)
      printf(" | ");
    else
      printf(" %d ", j.tours[2][niveau]);
    printf("\n");
  }
  printf("\n");
}

void console_print(tjeu j)
{
  int niveau, colonne, i;
  int nb_underscores, nb_spaces;

  for (niveau = j.nb_disk - 1; niveau >= 0; niveau--) {
    for (colonne = 0; colonne < 3; colonne++) {
      if (j.sommets[colonne] >= niveau) {

        nb_underscores = j.tours[colonne][niveau] * 2 - 1;
        nb_spaces = (j.nb_disk * 2 - 1 - nb_underscores) / 2;

        for (i = 0; i < nb_spaces; i++) {
          printf(" ");
        }

        for (i = 0; i < nb_underscores; i++) {
          printf("_");
        }

        for (i = 0; i < nb_spaces; i++) {
          printf(" ");
        }
      } else {
        for (i = 0; i < j.nb_disk * 2 - 1; i++) {
          if (i == j.nb_disk - 1) {
            printf("|");
          } else {
            printf(" ");
          }
        }
      }
    }

    printf("\n");
  }
}

// Si sommets[from] = -1 c'est qu'il n'y a rien sur la colonne
bool is_empty_tower(tjeu j, int towerIndex)
{
  return j.sommets[towerIndex] == -1;
}

bool can_move(tjeu j, int from, int to)
{
  return j.tours[from][j.sommets[from]] < j.tours[to][j.sommets[to]];
}

void deplacer_un_disque(tjeu *j, int from, int to)
{
  if (!is_empty_tower(*j, from) && from != to) {
    if (
      is_empty_tower(*j, to) 
      ||
      can_move(*j, from, to)
    ) {

      nb_deplacements++;

      j->sommets[to] = j->sommets[to] + 1;
  
      j->tours[to][j->sommets[to]] = j->tours[from][j->sommets[from]];
      j->tours[from][j->sommets[from]] = 0;
      j->sommets[from] = j->sommets[from] - 1;

      if (CONSOLE_PRINT == 1) {
        printf("Tour n'%d\n", nb_deplacements);
        console_print(*j);
      }

    // disque_to < disque_depart || to == from
    } else {
      printf("Déplacement impossible... %d -> %d\n", j->tours[from][j->sommets[from]], j->tours[to][j->sommets[to]]);
    }
  }
  else {
    printf("Pas de disque dans la colonne %d\n", from);
  }
}

void deplacer(tjeu *jeu, int nb_remain_disk, int from, int to)
{
  int move_disk;

  // smallests
  if (nb_remain_disk > 1) {
    // fonction de pair impaire
    move_disk = 3 - to - from;

    deplacer(jeu, nb_remain_disk - 1, from, move_disk);

    printf("Déplacement de %d vers %d\n", from, to);

    deplacer_un_disque(jeu, from, to);

    deplacer(jeu, nb_remain_disk - 1, move_disk, to);
  }
  // greatest
  else {
    printf("Déplacement de %d vers %d\n", from, to);
    deplacer_un_disque(jeu, from, to);
  }
}

int gagner(tjeu *j)
{
  return j->sommets[2] == (j->nb_disk - 1);
}

/**
 * Résolution automatique.
 */
void solve(tjeu *j)
{
  // Je fais bouger de la tour 0 à la tour 2, je veux l'CONSOLE_PRINT et le nb de déplacements !
  deplacer(j, j->nb_disk, 0, 2);
  printf("Problème résolu en %d deplacements\n\n", nb_deplacements);
}
