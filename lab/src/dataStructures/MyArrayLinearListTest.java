package dataStructures;



import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class MyArrayLinearListTest {

    MyArrayLinearList list;

    @BeforeEach
    void setUp() {
        list = new MyArrayLinearList();
        list.add(0, 1);
        list.add(1, 2);
        list.add(2, 3);
    }

    @Test
    void testMax() {
        assertEquals(3, list.max());
    }

    @Test
    void testMin() {
        assertEquals(1, list.min());
    }

    @Test
    void testSum() {
        assertEquals(6, list.sum());
    }

    @Test
    void testAverage() {
        assertEquals(2.0, list.average());
    }

  

    

    @Test
    void testSort() {
        list.add(0, 10);
        list.sort();
        assertEquals(1, list.get(0));
        assertEquals(10, list.get(list.size()-1));
    }
}
