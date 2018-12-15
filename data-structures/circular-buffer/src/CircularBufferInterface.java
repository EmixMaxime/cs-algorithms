package lists;

interface CircularBufferInterface
{

	int DEFAULT_SIZE = 10;

	void clear();

	boolean isEmpty();

	boolean isFull();

	int get(int indice);

	void add(int data);

	int getSize();

	int getLength();

}
