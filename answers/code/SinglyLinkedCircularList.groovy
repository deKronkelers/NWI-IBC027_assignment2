/**
 * A singly linked, circular list.
 */
class SinglyLinkedCircularList<T> {
    ListNode<T> currentNode = new ListNode<>()

    SinglyLinkedCircularList() {
        currentNode.nextNode = currentNode
    }

    /**
     * Insert an element between the current element and the next element.
     *
     * This operation's time complexity is O(1).
     *
     * @param elem the element to insert
     */
    void insert(T elem) {
        assert !elem.is(null)
        if (currentNode.value.is(null)) {
            currentNode.value = elem
        } else {
            ListNode<T> newNode = new ListNode<>()
            newNode.value = elem
            newNode.nextNode = currentNode.nextNode
            currentNode.nextNode = newNode
        }
    }

    /**
     * Delete the current element. This moves the position to the next
     * element.
     *
     * This operation's time complexity is O(n)
     *
     * @return the current element
     */
    T delete() {
        T value = currentNode.value
        if (currentNode.nextNode.is(currentNode)) {
            currentNode.value = null
        } else {
            ListNode<T> before = currentNode
            while (!before.nextNode.is(currentNode)) {
                before = before.nextNode
            }
            before.nextNode = currentNode.nextNode
            currentNode = currentNode.nextNode
        }
        value
    }

    /**
     * Search for an element with a specified value. This sets the position to
     * the element containing the value.
     *
     * This operation has a  best case time complexity of O(1) and a worst
     * case time complexity of O(n).
     *
     * @param value the value to search for
     * @return whether an element with the specified value was found
     */
    boolean search(T value) {
        ListNode<T> startingPoint = currentNode
        while (currentNode.value != value
                && !currentNode.nextNode.is(startingPoint)
        ) {
            currentNode = currentNode.nextNode
        }
        currentNode.value == value
    }

    private class ListNode<T> {
        ListNode<T> nextNode
        T value
    }
}
