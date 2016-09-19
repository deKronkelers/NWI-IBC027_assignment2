/**
 * A generic Deque that uses an array to store its elements with O(1) for
 * insertion and deletion at both ends.
 */
class ArrayDeque<T> {
    private final T[] elements

    private int start
    private int end

    /**
     * You need to specify a maximum capacity. Insertion begins in the middle
     * of the array and if you insert more items than the Deque can hold it
     * will throw an AssertionException.
     *
     * @param capacity the maximum capacity
     */
    ArrayDeque(int capacity) {
        elements = new T[capacity]
        start = capacity / 2
        end = capacity / 2
    }

    void addStart(T elem) {
        assert start >= 0
        elements[start] = elem
        start--
    }

    void addEnd(T elem) {
        assert end < elements.length - 1
        elements[end + 1] = elem
        end++
    }

    T removeStart() {
        start++
        elements[start]
    }

    T removeEnd() {
        end--
        elements[end + 1]
    }
}
