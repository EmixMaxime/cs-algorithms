package lists;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class CircularNavigatorTest
{

	@Test
	void testIncrement()
	{
		CircularBufferInterface buffer = new CircularBuffer(2);
		
		assertEquals(0, CircularNavigator.increment(1, buffer.getLength()));
		assertEquals(1, CircularNavigator.increment(0, buffer.getLength()));
	}
	
	@Test
	void testDecrement()
	{
		CircularBufferInterface buffer = new CircularBuffer(2);
		assertEquals(1, CircularNavigator.decrement(0, buffer.getLength()));
		assertEquals(0, CircularNavigator.decrement(1, buffer.getLength()));
	}

}
