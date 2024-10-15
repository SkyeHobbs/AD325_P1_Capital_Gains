import org.w3c.dom.Node;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class LinkedDeque<T> implements DequeInterface<T> {
    private DLNode<T> front;
    private DLNode<T> back;
    private int size;

    @Override
    public void addToFront(T newEntry) {
        DLNode<T> newNode = new DLNode<>(newEntry);

        if (isEmpty()) {
            front = back = newNode;
        } else {
            
        }
    }

    @Override
    public void addToBack(T newEntry) {

    }

    @Override
    public T removeFront() {
        return null;
    }

    @Override
    public T removeBack() {
        return null;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public T getFront() {
        return front.getData();
    }

    @Override
    public T getBack() {
        return back.getData();
    }

    @Override
    public void clear() {

    }

    @Override
    public Iterator<T> iterator() {
        return null;
    }

    @Override
    public Iterator<T> getIterator() {
        return null;
    }

    //DLNode class
    private static class DLNode<T> {
        private T data;
        private DLNode<T> next;
        private DLNode<T> previous;

        public DLNode(T data) {
            this.data = data;
            this.next = null;
            this.previous = null;
        }

        public T getData() {
            return data;
        }

        public void setData(T data) {
            this.data = data;
        }

        public DLNode<T> getNextNode() {
            return next;
        }

        public void setNextNode(DLNode<T> next) {
            this.next = next;
        }

        public DLNode<T> getPreviousNode() {
            return previous;
        }

        public void setPreviousNode(DLNode<T> previous) {
            this.previous = previous;
        }
    }

    private class IteratorForLinkedList implements Iterator<T> {
        private DLNode<T> current;

        public IteratorForLinkedList() {
            current = front;
        }

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public T next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            T data = current.getData();
            current = current.getNextNode();
            return data;
        }
    }
}
