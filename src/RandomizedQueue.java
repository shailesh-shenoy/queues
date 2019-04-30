import java.util.Iterator;

import edu.princeton.cs.algs4.StdRandom;

public class RandomizedQueue<Item> implements Iterable<Item>
{
	
	private int size;
	private Item[] queue;
	
	@SuppressWarnings("unchecked")
	public RandomizedQueue()
	{
		queue = (Item[]) new Object[2];
		size = 0;
	}
	
	public int size()
	{
		return this.size;
	}
	
	public boolean isEmpty()
	{
		if (size == 0)
			return true;
		else
			return false;
	}
	
	public void enqueue(Item item)
	{
		if (item == null)
			throw new IllegalArgumentException("null values are not allowed");
		if (size == queue.length)
			this.increaseSize();
		int r = StdRandom.uniform(queue.length);
		while (queue[r] != null)
			r = StdRandom.uniform(queue.length);
		queue[r] = item;
		size++;
	}
	
	public Item dequeue()
	{
		if (this.isEmpty())
			throw new IllegalArgumentException("Queue is empty");
		if (size == (queue.length / 4))
			this.decreaseSize();
		int r = StdRandom.uniform(queue.length);
		while (queue[r] == null)
			r = StdRandom.uniform(queue.length);
		Item item = queue[r];
		queue[r] = null;
		size--;
		return item;
	}
	
	public Item sample()
	{
		if (this.isEmpty())
			throw new IllegalArgumentException("Queue is empty");
		int r = StdRandom.uniform(queue.length);
		while (queue[r] == null)
			r = StdRandom.uniform(queue.length);
		return queue[r];
		
	}
	
	@SuppressWarnings("unchecked")
	private void increaseSize()
	{
		Item[] temp = (Item[]) new Object[queue.length * 2];
		for (int i = 0; i < queue.length; i++)
			temp[i] = queue[i];
		queue = temp;
		StdRandom.shuffle(queue);
	}
	
	@SuppressWarnings("unchecked")
	private void decreaseSize()
	{
		Item[] temp = (Item[]) new Object[queue.length / 2];
		for (int i = 0, count = 0; i < queue.length; i++)
		{
			if (queue[i] != null)
			{
				temp[count] = queue[i];
				count++;
			}
		}
		queue = temp;
		StdRandom.shuffle(queue);
	}
	
	@Override
	public String toString()
	{
		String value = "";
		for (Item item : queue)
			value = value + item + ", ";
		
		return value;
	}
	
	@Override
	public Iterator<Item> iterator()
	{
		// TODO Auto-generated method stub
		return null;
	}
	
	public static void main(String[] args)
	{
		RandomizedQueue<String> rq = new RandomizedQueue<String>();
		System.out.println(rq.isEmpty());
//		System.out.println(rq.dequeue());
		rq.enqueue("ABC");
		rq.enqueue("XYZ");
		rq.enqueue("M");
		rq.enqueue("Y");
		rq.enqueue("L");
		rq.enqueue("O");
		rq.enqueue("V");
		rq.enqueue("E");
		rq.enqueue("T");
		rq.enqueue("H");
		rq.enqueue("a");
		rq.enqueue("t");
		rq.enqueue("S");
		rq.enqueue("R");
		rq.enqueue("I");
		rq.enqueue("G");
		rq.enqueue("H");
		rq.enqueue("Tt");
		rq.enqueue("s");
		rq.enqueue("O");
		rq.enqueue("N");
		System.out.println(rq);
		System.out.println(rq.sample());
		System.out.println(rq.sample());
		System.out.println(rq.sample());
		System.out.println(rq.sample());
		System.out.println(rq.sample());
		System.out.println(rq.sample());
		System.out.println(rq.sample());
		System.out.println(rq.sample());
		System.out.println(rq.size());
		System.out.println(rq.dequeue());
		System.out.println(rq.dequeue());
		System.out.println(rq.dequeue());
		System.out.println(rq.dequeue());
		System.out.println(rq.dequeue());
		System.out.println(rq.dequeue());
		System.out.println(rq.dequeue());
		System.out.println(rq.dequeue());
		System.out.println(rq.dequeue());
		System.out.println(rq.dequeue());
		System.out.println(rq.dequeue());
		System.out.println(rq.dequeue());
		System.out.println(rq.dequeue());
		System.out.println(rq.dequeue());
		System.out.println(rq.dequeue());
		System.out.println(rq.dequeue());
		System.out.println(rq.dequeue());
		System.out.println(rq.dequeue());
		System.out.println(rq.dequeue());
		System.out.println(rq.dequeue());
		System.out.println(rq.dequeue());
		System.out.println(rq.dequeue());
		System.out.println(rq.dequeue());
	}
}
