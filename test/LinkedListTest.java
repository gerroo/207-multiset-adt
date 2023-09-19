import org.junit.Test;
import static org.junit.Assert.*;

public class LinkedListTest {

    @Test
    public void addContainsTest() {
        LinkedListMultiSet<Integer> llms = new LinkedListMultiSet<Integer>();

        llms.add(5);
        boolean doesItContain = llms.contains(5);

        assertTrue(doesItContain);
    }

    @Test
    public void sizeTest() {
        LinkedListMultiSet<Integer> llms = new LinkedListMultiSet<Integer>();

        llms.add(5);

        assertEquals("Size does not work at all.", 1, llms.size());

        llms.add(2);

        assertEquals("Size doesn't work for multiple elements.", 2, llms.size());

        llms.add(2);

        assertEquals(
                "Size doesn't work if you have multiple elements with the same value.",
                3,
                llms.size()
        );

    }

    @Test
    public void removeTest() {
        LinkedListMultiSet<Integer> llms = new LinkedListMultiSet<Integer>();

        llms.add(10);

        llms.remove(5);

        assertEquals(
                "Remove removes elements that don't equal its argument.",
                1,
                llms.size()
        );

        llms.remove(10);
        assertEquals(
                "Remove doesn't work.",
                0,
                llms.size()
        );

        llms.add(2);
        llms.add(3);
        llms.add(5);
        llms.add(3);
        llms.remove(3);
        assertEquals(
                "Remove doesn't work.",
                3,
                llms.size()
        );
    }

    @Test
    public void isEmptyTest() {
        LinkedListMultiSet<Integer> llms = new LinkedListMultiSet<Integer>();

        assertTrue(
                "Newly initalized multiset is not empty.",
                llms.is_empty()
        );

        llms.add(5);
        assertFalse(
                "A multiset with an item is not supposed to be empty.",
                llms.is_empty()
        );
    }

    @Test
    public void countTest() {
        LinkedListMultiSet<Integer> llms = new LinkedListMultiSet<Integer>();

        llms.add(1);
        llms.add(2);

        assertEquals(
                "Count doesn't work.",
                1,
                llms.count(1)
        );

        llms.add(3);
        llms.add(2);

        assertEquals(
                "Count doesn't work.",
                2,
                llms.count(2)
        );
    }
}
