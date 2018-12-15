package lists;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class CircularBufferTest
{

	@Test
	void testIsFull() {
		CircularBufferInterface buffer = new CircularBuffer(2);

		assertEquals(false, buffer.isFull());

		buffer.add(5);
		assertEquals(false, buffer.isFull());
		buffer.add(7);

		assertEquals(true, buffer.isFull());
	}

	@Test
	void testIsEmpty()
	{
		CircularBufferInterface buffer = new CircularBuffer();
		assertEquals(true, buffer.isEmpty());
	}
	
	@Test
	void testGet()
	{
		CircularBufferInterface buffer = new CircularBuffer(2);
		
		buffer.add(6);
		assertEquals(6, buffer.get(0));
		
		buffer.add(12);
		assertEquals(12, buffer.get(1));
	}
	
	@Test
	void testAdd()
	{
		CircularBufferInterface buffer = new CircularBuffer(2);

		assertEquals(0, buffer.getSize());

		buffer.add(5);

		assertEquals(1, buffer.getSize());
		assertEquals(5, buffer.get(0));

		buffer.add(6);

		assertEquals(2, buffer.getSize());
		assertEquals(6, buffer.get(1));

		buffer.add(7);

		assertEquals(6, buffer.get(0));
		assertEquals(7, buffer.get(1));
		
		buffer = new CircularBuffer(3);
		buffer.add(1);
		buffer.add(2);
		buffer.add(3);
		
		buffer.add(4);
		assertEquals(2, buffer.get(0));
		assertEquals(4, buffer.get(2));
	}

}
