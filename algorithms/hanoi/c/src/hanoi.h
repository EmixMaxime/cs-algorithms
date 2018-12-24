#ifndef HANOI_H_INCLUDED
#define HANOI_H_INCLUDED

#define NB_MAX_OF_DISK 10
#define CONSOLE_PRINT 1

typedef struct {
  int tours[3][NB_MAX_OF_DISK];
  int sommets[3];
  int nb_disk;
} tjeu;

void init(tjeu *j, int nbdisques);

/**
 * fonction affichant le jeu
 * à l'aide de '|' pour les tours et de numero pour les disques
 */
void afficher(tjeu j);


void solve(tjeu *j);


int gagner(tjeu *j);

void deplacer_un_disque(tjeu *j, int from, int to);

/**
 * Déplacement de `nbdisques_restant` disques de la tour n° `depart`
 * vers la tour n° `arrivee`
 * 
 * 1 seul disque à déplacer ? on call la fonction deplacer_un_disque (easy way)
 * sinon, on utilise cette fonction avec la recursivité (hard way !)
 */
void deplacer(tjeu *j, int nbdisques_restant, int depart, int arrivee);

void console_print(tjeu j);


#endif
