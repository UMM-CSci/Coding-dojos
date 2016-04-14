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

	public void set(K key, V value) {
		Node<K, V> node = hash.get(key);
		
		if (null == node) { // node does not exist yet
			if (hash.size() >= capacity) {
				hash.remove(tail.key);
				remove(tail);
			}
		
			Node<K, V> newNode = new Node<K, V>(key, value);
			hash.put(key, newNode);
			add(newNode);
		} else { // node exists, resets value
			moveToFront(node);
			node.value = value;
		}
	}

	public V get(K key) {
		Node<K, V> node = hash.get(key);
		
		if (null == node){
			return null;
		} else {
			moveToFront(node);
			return node.value;
		}
	}
	
	private void moveToFront(Node<K, V> node) {
		remove(node);
		add(node);
	}

	private void add(Node<K, V> node) {
		if (null == tail) { // nothing in list
			tail = node;
		} else {
			head.previous = node;
		}
		
		node.previous = null;
		node.next = head;
		head = node;
	}
	
	private void remove(Node<K, V> node) {
		if (null == node.previous) { // node is head		
			head = node.next;
		} else {
			node.previous.next = node.next;
		}
		
		if (null == node.next) { // node is tail
			tail = node.previous;
		} else {
			node.next.previous = node.previous;
		}
		
		node.next = null;
		node.previous = null;
	}
	
	public String toString() {
		Node<K, V> indexNode = head;
		String listString = "";
		
		while (indexNode != tail) {
			listString += indexNode.key;
			listString += ", ";
			indexNode = indexNode.next;
		}
		
		listString += tail.key;
		
		return "Hash: " + hash.keySet().toString() + ", List: [" + listString + "]";
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
