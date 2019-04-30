import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * The {@code Deque} class represents a double-ended queue of generic items. It
 * supports operations: <em>addFirst</em>, <em>addLast</em> and
 * <em>removeFirst</em>, <em>removeLast</em> to add/remove the first and last
 * nodes respectively as well as operations to check if the deque is empty with
 * <em>isEmpty</em>, get the size of the deque with <em>size</em> and
 * <em>iterator</em> which returns an iterator to iterate through the deque.
 * <p>
 * This implementation uses a doubly linked list with a static nested class for
 * linked-list nodes. The <em>addFirst</em>, <em>addLast</em>,
 * <em>removeFirst</em>,<em>removeFirst</em>, <em>size</em> and <em>isEmpty</em>
 * operations all take constant time in the worst case.
 * <p>
 *
 * @author Shailesh Shenoy
 */
public class Deque<Item> implements Iterable<Item>
{
	private Node<Item> sentinel;
	private Node<Item> first;
	private Node<Item> last;
	private int size;
	
	public Deque()
	{
		sentinel = new Node<Item>(null, null, null);
		first = sentinel;
		last = sentinel;
		size = 0;
	}
	
	// Helper Static Linked List Node class
	private static class Node<Item>
	{
		private Item item;
		private Node<Item> previous;
		private Node<Item> next;
		
		public Node(Item item, Node<Item> previous, Node<Item> next)
		{
			this.item = item;
			this.previous = previous;
			this.next = next;
		}
	}
	
	public int size()
	{
		return size;
	}
	
	public boolean isEmpty()
	{
		return (size == 0);
	}
	
	public void addFirst(Item item)
	{
		if (item == null)
			throw new IllegalArgumentException("null values not allowed in deque");
		
		if (size == 0)
		{
			first = new Node<Item>(item, sentinel, sentinel);
			last = first;
		} else
		{
			Node<Item> oldFirst = first;
			first = new Node<Item>(item, sentinel, oldFirst);
			oldFirst.previous = first;
		}
		size++;
	}
	
	public Item removeFirst()
	{
		if (size == 0)
			throw new NoSuchElementException("No element in deque to remove");
		Item item = first.item;
		if (size == 1)
		{
			first = sentinel;
			last = sentinel;
		} else
		{
			first = first.next;
			first.previous = sentinel;
		}
		size--;
		return item;
	}
	
	public void addLast(Item item)
	{
		if (item == null)
			throw new IllegalArgumentException("null values not allowed in deque");
		
		if (size == 0)
		{
			last = new Node<Item>(item, sentinel, sentinel);
			first = last;
		} else
		{
			Node<Item> oldLast = last;
			last = new Node<Item>(item, oldLast, sentinel);
			oldLast.next = last;
		}
		size++;
	}
	
	public Item removeLast()
	{
		if (size == 0)
			throw new NoSuchElementException("No element in deque to remove");
		Item item = last.item;
		if (size == 1)
		{
			first = sentinel;
			last = sentinel;
		} else
		{
			last = last.previous;
			last.next = sentinel;
		}
		size--;
		return item;
	}
	
	@Override
	public Iterator<Item> iterator()
	{
		return new DequeIterator<Item>(first, sentinel);
	}
	
	private class DequeIterator<T> implements Iterator<Item>
	{
		Node<Item> current;
		Node<Item> sentinel;
		
		public DequeIterator(Node<Item> first, Node<Item> sentinel)
		{
			current = first;
			this.sentinel = sentinel;
		}
		
		@Override
		public boolean hasNext()
		{
			return (current != sentinel);
		}
		
		@Override
		public Item next()
		{
			if (!hasNext())
				throw new NoSuchElementException("No element available");
			Item item = current.item;
			current = current.next;
			return item;
		}
		
		@Override
		public void remove()
		{
			throw new UnsupportedOperationException();
		}
	}
	
	public static void main(String[] args)
	{
		Deque<String> deque = new Deque<String>();
		System.out.println(deque);
		System.out.println(deque.size);
		deque.addFirst("first");
		System.out.println(deque.size);
		deque.addLast("last");
		System.out.println(deque.size);
//		System.out.println(deque.removeLast());
		System.out.println(deque.size);
//		System.out.println(deque.removeLast());
		System.out.println(deque.size);
		Iterator dequeIterator = deque.iterator();
		System.out.println(dequeIterator.hasNext());
		System.out.println(dequeIterator.next());
		for (String s : deque)
			System.out.println(s);
		System.out.println(dequeIterator.hasNext());
		System.out.println(dequeIterator.next());
		System.out.println(dequeIterator.next());
	}
}
