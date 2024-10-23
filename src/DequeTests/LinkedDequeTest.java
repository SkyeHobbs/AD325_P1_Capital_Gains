import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Iterator;

import static org.junit.jupiter.api.Assertions.*;

class LinkedDequeTest {
    private LinkedDeque<Integer> deque;

    @Test
    void addToFront() {
        deque = new LinkedDeque<>();
        deque.addToFront(3);
        deque.addToFront(2);
        deque.addToFront(1);

        assertEquals(1, deque.getFront());
        assertEquals(3, deque.getBack());
    }

    @org.junit.jupiter.api.Test
    void addToBack() {
        deque = new LinkedDeque<>();
        deque.addToBack(1);
        deque.addToBack(2);
        deque.addToBack(3);

        assertEquals(1, deque.getFront());
        assertEquals(3, deque.getBack());
    }

    @org.junit.jupiter.api.Test
    void removeFront() {
        deque = new LinkedDeque<>();
        deque.addToBack(1);
        deque.addToBack(2);
        deque.addToBack(3);

        deque.removeFront();
        assertEquals(2, deque.getFront());
        deque.removeFront();
        assertEquals(3, deque.getFront());
    }

    @org.junit.jupiter.api.Test
    void removeBack() {
        deque = new LinkedDeque<>();
        deque.addToBack(1);
        deque.addToBack(2);
        deque.addToBack(3);

        deque.removeBack();
        assertEquals(2, deque.getBack());
        deque.removeBack();
        assertEquals(1, deque.getBack());
    }

    @org.junit.jupiter.api.Test
    void isEmpty() {
        deque = new LinkedDeque<>();

        assertTrue(deque.isEmpty());
        deque.addToFront(1);
        assertFalse(deque.isEmpty());
    }

    @org.junit.jupiter.api.Test
    void getFront() {
        deque = new LinkedDeque<>();

        deque.addToFront(1);
        assertEquals(1, deque.getFront());
        deque.addToFront(2);
        assertEquals(2, deque.getFront());
    }

    @org.junit.jupiter.api.Test
    void getBack() {
        deque = new LinkedDeque<>();

        deque.addToBack(1);
        assertEquals(1, deque.getBack());
        deque.addToBack(2);
        assertEquals(2, deque.getBack());
    }

    @org.junit.jupiter.api.Test
    void clear() {
        deque = new LinkedDeque<>();
        deque.addToBack(1);
        deque.addToBack(2);

        deque.clear();
        assertTrue(deque.isEmpty());
    }

    @org.junit.jupiter.api.Test
    void iterator() {
        deque = new LinkedDeque<>();
        deque.addToBack(1);
        deque.addToBack(2);
        deque.addToBack(3);

        Iterator<Integer> iterator = deque.iterator();
        assertTrue(iterator.hasNext());
        assertEquals(1, iterator.next());
        assertEquals(2, iterator.next());
        assertEquals(3, iterator.next());
        assertFalse(iterator.hasNext());
    }

    @org.junit.jupiter.api.Test
    void getIterator() {
        deque = new LinkedDeque<>();
        deque.addToBack(1);
        deque.addToBack(2);
        deque.addToBack(3);

        Iterator<Integer> iterator = deque.iterator();
        assertTrue(iterator.hasNext());
        assertEquals(1, iterator.next());
        assertEquals(2, iterator.next());
        assertEquals(3, iterator.next());
        assertFalse(iterator.hasNext());
    }
}