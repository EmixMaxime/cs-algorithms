package lists;

/**
 * Source of learning: https://en.wikipedia.org/wiki/Circular_buffer
 * 
 * https://embedjournal.com/implementing-circular-buffer-embedded-c/
 * @author mx
 *
 */
class CircularBuffer implements CircularBufferInterface
{
    private int[] buff;
    private final int length;
    private int size;

    private int start = 0;
    private int end = -1;

    public CircularBuffer(int size)
    {
        buff = new int[size];
        this.length = size;
    }

    public CircularBuffer()
    {
        this(DEFAULT_SIZE);
    }

	public void clear()
    {
        buff = new int[length];
    }

	public boolean isEmpty()
    {
        return end == -1;
    }

	public boolean isFull()
    {
        return length == size;
    }

	public int get(int indice)
    {
    	return buff[(start + indice) % length];
    }

	public void add(int data)
    {
        if (isFull()) {
            buff[start] = data;

            // When an element is overwritten, the start
            // index is incremented to the next element
            start = CircularNavigator.increment(start, length);
            end = CircularNavigator.increment(end, length);
        }
        else {
            end = CircularNavigator.increment(end, length);
            buff[end] = data;
            size++;
        }
    }

	public int getSize()
    {
		return size;
	}

	public int getLength()
    {
		return length;
	}
}

