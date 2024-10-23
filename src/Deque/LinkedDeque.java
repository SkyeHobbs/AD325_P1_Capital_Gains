import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Linked deque class that consists of DLNodes with generic data types
 */
public class LinkedDeque<T> implements DequeInterface<T> {
    private DLNode<T> front;
    private DLNode<T> back;

    public LinkedDeque() {
        front = null;
        back = null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void addToFront(T newEntry) {
        DLNode<T> newNode = new DLNode<>(newEntry);

        if (front == null) {
            front = back = newNode;
        } else {
            newNode.next = front;
            front.previous = newNode;
            front = newNode;
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void addToBack(T newEntry) {
        DLNode<T> newNode = new DLNode<>(newEntry);

        if (front == null) {
            front = back = newNode;
        } else {
            DLNode<T> current = front;

            while(current.next != null) {
                current = current.next;
            }
            current.next = newNode;
            newNode.previous = current;
            back = newNode;
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public T removeFront() {
        if (isEmpty()) {
            throw new IllegalStateException("Deque is empty.");
        }

        T data = front.getData();
        front = front.getNextNode();

        if (front != null) {
            front.setPreviousNode(null);
        } else {
            front = null; // Deque is now empty
        }

        return data;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public T removeBack() {
        T backNodeData = getBack();
        assert(back != null);
        back = back.getPreviousNode();

        if (back == null) {
            front = null;
        } else {
            back.setNextNode(null);
        }

        return backNodeData;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean isEmpty() {
        if(front == null) {
            return true;
        }

        return false;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public T getFront() {
        if (front == null) {
            throw new EmptyQueueException();
        }

        return front.getData();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public T getBack() {
        if (front == null) {
            throw new EmptyQueueException();
        }

        return back.getData();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void clear() {
        front = null;
        back = null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Iterator<T> iterator() {
        return new IteratorForLinkedList();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Iterator<T> getIterator() {
        return iterator();
    }


    /**
     * DLNode class with generic data type
     */
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


    /**
     * Iterator for linked list class for DLNodes with generic data types
     */
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
