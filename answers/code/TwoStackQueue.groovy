/**
 * A generic Queue that uses two stacks.
 */
class TwoStackQueue<T> {
    private final Stack<T> inStack = new Stack<>()
    private final Stack<T> outStack = new Stack<>()

    /**
     * Add an element to the Queue.
     */
    void add(T elem) {
        inStack.push elem
    }

    /**
     * Get the oldest element from the Queue.
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
