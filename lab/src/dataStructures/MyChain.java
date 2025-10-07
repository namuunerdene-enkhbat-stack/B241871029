package dataStructures;

public class MyChain extends Chain {
	public Object[] toArray() {
		Object arr[] = new Object[size()];

		for (int i = 0; i < size(); i++) {
			arr[i] = this.get(i);

		}
		return arr;
	}

	public void addRange(Object[] elements) {
		for (int i = 0; i < elements.length; i++) {
			this.add(size(), elements[i]);
		}
	}

	public MyChain union(MyChain other) {
		MyChain result = new MyChain();
		for (int i = 0; i < this.size(); i++) {
			result.add(result.size(), this.get(i));
		}
		for (int i = 0; i < other.size(); i++) {
			result.add(result.size(), other.get(i));
		}
		return result;
	}

	public MyChain intersection(MyChain other) {
		MyChain result = new MyChain();
		for (int i = 0; i < this.size(); i++) {
			Object element = this.get(i);
			for (int j = 0; j < other.size(); j++) {
				if (element.equals(other.get(j))) {
					result.add(result.size(), element);
					break;
				}
			}
		}
		return result;
	}

	public static void main(String args[]) {
		MyChain mc = new MyChain();
		mc.add(0, 10);
		mc.add(1, 5);
		mc.add(2, 11);

		Object a[];
		a = mc.toArray();
		for (int i = 0; i < a.length; i++)
			System.out.println(" " + (int) a[i]);

		mc.addRange(a);
		System.out.println("addRange:" + mc);

		MyChain second = new MyChain();
		second.add(0, 9);
		second.add(1, 10);
		second.add(2, 11);

		MyChain third = mc.union(second);
		System.out.println("Union:" + third);
		MyChain inter = mc.intersection(second);
		System.out.println("Intersection:" + inter);
	}

}
