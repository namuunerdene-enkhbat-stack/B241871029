package dataStructures;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class MyChainTest {

	private MyChain chain;

	@Before
	public void setUp() {
		chain = new MyChain();
		chain.add(0, 10);
		chain.add(1, 5);
		chain.add(2, 11);
	}

	@Test
	public void testToArray() {
		Object[] expected = { 10, 5, 11 };
		assertArrayEquals("toArray should return all elements in correct order", expected, chain.toArray());
	}

	@Test
	public void testAddRange() {
		Object[] more = { 20, 30, 40 };
		chain.addRange(more);

		Object[] expected = { 10, 5, 11, 20, 30, 40 };
		assertArrayEquals("addRange should append all elements at the end", expected, chain.toArray());
	}

	@Test
	public void testUnion() {
		MyChain other = new MyChain();
		other.add(0, 9);
		other.add(1, 10);
		other.add(2, 11);

		MyChain unionResult = chain.union(other);

		Object[] expected = { 10, 5, 11, 9, 10, 11 };
		assertArrayEquals("union should combine both chains in order", expected, unionResult.toArray());
	}

	@Test
	public void testUnionWithEmpty() {
		MyChain empty = new MyChain();
		MyChain result = chain.union(empty);

		Object[] expected = { 10, 5, 11 };
		assertArrayEquals("union with empty should return original chain", expected, result.toArray());
	}

	@Test
	public void testAddRangeEmpty() {
		Object[] emptyArr = {};
		chain.addRange(emptyArr);

		Object[] expected = { 10, 5, 11 };
		assertArrayEquals("addRange with empty array should not change chain", expected, chain.toArray());
	}
}