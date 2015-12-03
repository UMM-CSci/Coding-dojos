import java.util.ArrayList;


public class OurSet<T> {
	
	ArrayList<T> data = new ArrayList<T>();

	public boolean isEmpty() {
		return data.size() == 0;
	}
	
	public void clear() {
		data = new ArrayList<T>();
	}

	public int size() {
		return data.size();
	}

	public boolean add(T newElement) {
		if (data.contains(newElement)) {
			return false;
		}
		data.add(newElement);
		return true;
	}

	public boolean contains(T newElement) {
		return data.contains(newElement);
	}

	public boolean remove(T element) {
		return data.remove(element);
	}
	
	public static <T> OurSet<T> union(OurSet<T> s1, OurSet<T> s2){
		OurSet<T> result = new OurSet<T>();
		for (T thing : s1.data) {
			result.add(thing);	
		}
		for (T thing : s2.data) {
			result.add(thing);	
		}
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj instanceof OurSet) {
			OurSet<T> input = (OurSet<T>) obj;
			if (input.size() != data.size()) {
				return false;
			}
			for (int i = 0; i < data.size(); i++) {
				if(!(input.contains(data.get(i)))){ //if we can't find a match for any term
					return false; //throw it out
				}
			}
			return true;
		}
		return false;
	}
}
