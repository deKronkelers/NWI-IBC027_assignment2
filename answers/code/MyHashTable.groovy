/**
 * A hash table supporting insertion, deletion, and searching.
 */
class MyHashTable<T> {
    private final ListNode<T>[] array

    MyHashTable(int slots) {
        array = (1..slots).collect { new ListNode<T>() }
    }

    void insert(T elem) {
        ListNode<T> listNode = array[elem.hashCode() % array.length]
        while (!listNode.value.is(null) && listNode.nextNode) {
            listNode = listNode.nextNode
        }
        if (listNode.value.is(null)) {
            listNode.value = elem
        } else {
            ListNode<T> newNode = new ListNode<>()
            newNode.value = elem
            listNode.nextNode = newNode
        }
    }

    void delete(T elem) {
        ListNode<T> listNode = array[elem.hashCode() % array.length]
        while (listNode.value != elem && listNode.nextNode) {
            listNode = listNode.nextNode
        }
        if (listNode.value == elem) {
            listNode.value = null
        }
    }

    boolean search(T elem) {
        ListNode<T> listNode = array[elem.hashCode() % array.length]
        while (listNode.value != elem && listNode.nextNode) {
            listNode = listNode.nextNode
        }
        listNode.value == elem
    }

    private class ListNode<T> {
        ListNode<T> nextNode
        T value
    }
}
