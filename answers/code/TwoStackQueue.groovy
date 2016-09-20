/**
 * A generic Queue that uses two stacks.
 */
class TwoStackQueue<T> {
    private final Stack<T> inStack = new Stack<>()
    private final Stack<T> outStack = new Stack<>()

    /**
     * Add an element to the Queue.
     *
     * This operation's time complexity is O(1).
     */
    void add(T elem) {
        inStack.push elem
    }

    /**
     * Get the oldest element from the Queue.
     *
     * This operation's best case (the out stack is NOT empty) time complexity
     * is O(1). The worst case (the out stack is empty) takes O(n) time where
     * n is the size of the in stack.
     *
     * @return the oldest element on the Queue
     */
    T get() {
        if (outStack.empty()) {
            for (int i in 1..inStack.size()) {
                outStack.push inStack.pop()
            }
        }
        outStack.pop()
    }
}
