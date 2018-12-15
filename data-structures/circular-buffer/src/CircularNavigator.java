package lists;

public class CircularNavigator
{
    public static int increment(int index, int length)
    {
        return (index + 1) % length;
    }

    public static int decrement(int index, int length)
    {
    	return (index + length -1) % length;
    }
}
