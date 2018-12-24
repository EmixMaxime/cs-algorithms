class Hanoi
{
    private final int NB_MAX_OF_DISK = 10;
    private final boolean CONSOLE_PRINT = true;

    private int[] sommets = new int[3];
    private int [][] tours = new int[3][NB_MAX_OF_DISK];

    private int nbOfDisk;

    private int nbDeplacements = 0;

    public Hanoi(int nbOfDisk)
    {
        if (nbOfDisk > NB_MAX_OF_DISK) {
            System.out.println("TODO: throws error");
        }

        this.nbOfDisk = nbOfDisk;
        this.init();
    }

    private void init()
    {
        for (int x = 0; x < this.nbOfDisk; x++) {
            this.tours[0][x] = this.nbOfDisk - x;
        }

        sommets[0] = nbOfDisk -1;
        sommets[1] = -1;
        sommets[2] = -1;
    }

    private void consolePrint()
    {
        int level,
            column,
            i,
            nbUnderscores,
            nbSpaces;

        for (level = nbOfDisk - 1; level >= 0; level--) {

            for (column = 0; column < 3; column++) {
                if (sommets[column] >= level) {

                    nbUnderscores = tours[column][level] * 2 - 1;
                    nbSpaces = (nbOfDisk * 2 - 1 - nbUnderscores) / 2;

                    for (i = 0; i < nbSpaces; i++) {
                        System.out.printf(" ");
                    }

                    for (i = 0; i < nbUnderscores; i++) {
                        System.out.printf("_");
                    }

                    for (i = 0; i < nbSpaces; i++) {
                        System.out.printf(" ");
                    }

                } else {
                    for (i = 0; i < nbOfDisk * 2 - 1; i++) {
                        if (i == nbOfDisk - 1) {
                            System.out.printf("|");
                        } else {
                            System.out.printf(" ");
                        }
                    }
                }
            }

            System.out.printf("\n");
        }
    }

    private boolean isEmptyTower(int towerIndex)
    {
        return sommets[towerIndex] == -1;
    }

    private boolean canMove(int from, int to)
    {
        return tours[from][sommets[from]] < tours[to][sommets[to]];
    }

    private void moveDisk(int from, int to)
    {
        if (!isEmptyTower(from) && from != to) {
            if (isEmptyTower(to) || canMove(from, to)) {

            nbDeplacements++;

            sommets[to] = sommets[to] + 1;

            tours[to][sommets[to]] = tours[from][sommets[from]];
            tours[from][sommets[from]] = 0;
            sommets[from] = sommets[from] - 1;

            if (CONSOLE_PRINT) {
                System.out.printf("Tour n'%d\n", nbDeplacements);
                consolePrint();
            }

            // disque_to < disque_depart || to == from
            } else {
                System.out.printf(
                    "Déplacement impossible... %d -> %d\n",
                    tours[from][sommets[from]],
                    tours[to][sommets[to]]
                );
            }
        }
        else {
            System.out.printf("Pas de disque dans la colonne %d\n", from);
        }
    }

    private void move(int nbRemainDisk, int from, int to)
    {
        int moveDisk;

        // smallests
        if (nbRemainDisk > 1) {
          // fonction de pair impaire
          moveDisk = 3 - to - from;
      
          move(nbRemainDisk - 1, from, moveDisk);
      
          System.out.printf("Déplacement de %d vers %d\n", from, to);
      
          moveDisk(from, to);
      
          move(nbRemainDisk - 1, moveDisk, to);
        }
        // greatest
        else {
            System.out.printf("Déplacement de %d vers %d\n", from, to);
            moveDisk(from, to);
        }
    }

    public boolean hasWin()
    {
        return sommets[2] == (nbOfDisk - 1);
    }

    public void solve()
    {
        move(this.nbOfDisk, 0, 2);
    }
}
