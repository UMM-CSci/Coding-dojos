import java.util.Hashtable;

public class LRU_Cache<K, V> {
	private Node<K, V> head;
	private Node<K, V> tail;
	private int capacity;
	private Hashtable<K, Node<K, V>> hash = new Hashtable<K, Node<K, V>>();
	
	public LRU_Cache(int capacity) {
		if (capacity <= 0) {
			throw new RuntimeException("Capacity given must be positive.");
		} else {
			this.capacity = capacity;
		}
	}

	public V get(K key) {
		Node<K, V> node = hash.get(key);
		
		if (null == node){
			return null;
		} else {
			refresh(node);
			return node.value;
		}
	}

	public void set(K key, V value) {
		Node<K, V> node = hash.get(key);
		
		if (null == node) { // node is not in Hashtable
			// if over capacity, remove last node
			if (hash.size() >= capacity) {
				removeTail();
			}
			
			add(key, value);
		} else { // node exists, resets value
			refresh(node);
			node.value = value;
		}
	}
	
	public void add(K key, V value) {
		Node<K, V> newNode = new Node<K, V>(key, value);
		hash.put(key, newNode);
		
		if (null == head) {
			head = newNode;
			tail = newNode;
		} else {
			newNode.next = head;
			head.previous = newNode;
			head = newNode;
		}
	}
	
	public void refresh(Node<K, V> node) {	
		if (null != node.previous) { // node is not at front of list
			node.previous.next = node.next;
		}
		
		if (null != node.next){ // node is not in back of list
			node.next.previous = node.previous;
		} else { // node is back of list
			tail = node.previous;
		}
		
		node.next = head;
		head.previous = node;
		node.previous = null;
		head = node;
	}
	
	public void removeTail() {
		hash.remove(tail.key);
		
		if (null != tail.previous){
			tail.previous.next = null;
			tail = tail.previous;
		} else {
			head = null;
			tail = null;
		}
	}
	
	public class Node<X, Y> {
		X key;
		Y value;
		Node<X, Y> previous;
		Node<X, Y> next;
		
		public Node(X key, Y value) {
			this.key = key;
			this.value = value;
		}
	}
}
