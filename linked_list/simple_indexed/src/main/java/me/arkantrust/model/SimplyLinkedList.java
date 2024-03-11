package me.arkantrust.model;

import java.util.Iterator;
import java.util.ArrayList;

import lombok.Data;
import lombok.AllArgsConstructor;

@Data
@AllArgsConstructor
class Node<E> {
    
    private int index;

    private E data;

    private Node<E> next;
    
    public Node(int index, E data) {
        
        this.index = index;
        this.data = data;
        this.next = null;
        
    }

}

public class SimplyLinkedList<E> implements Iterable<E>, LinkedList<E> {

    private Node<E> head;

    private Node<E> tail;

    private int size;

    public SimplyLinkedList() {

        size = 0;

    }

    @Override
    public E head() {

        return head.getData();

    }

    @Override
    public E tail() {

        return tail.getData();

    }

    @Override
    public boolean isEmpty() {

        return size == 0;

    }

    @Override
    public int size() {

        return size;

    }

    @Override
    public void clear() {

        this.size = 0;
        this.head = null;
        this.tail = null;

    }

    @Override
    public void push(E element) {

        var newNode = new Node<>(size, element);

        if (isEmpty()) {

            this.head = newNode;
            this.tail = newNode;

        } else {

            newNode.setNext(head);
            this.head = newNode;

        }

        size++;

    }

    @Override
    public void append(E element) {

        var newNode = new Node<>(size, element);

        if (isEmpty()) {

            this.head = newNode;
            this.tail = newNode;

        } else {

            this.tail.setNext(newNode);
            this.tail = newNode;

        }

        size++;

    }

    private void checkIndex(int index) {

        if (index < 0 || index > size)
            throw new IndexOutOfBoundsException("Index: %s, Size: %s".formatted(index, size));

    }

    @Override
    public void add(int index, E element) {

        checkIndex(index);

        if (index == 0)
            push(element);

        else if (index == size - 1)
            append(element);

        else {

            var newNode = new Node<>(index, element);

            Node<E> current = this.head;

            for (int i = 0; i < index; i++)
                current = current.getNext();

            newNode.setNext(current.getNext());
            current.setNext(newNode);

            size++;

        }

    }

    @Override
    public E get(int index) {

        checkIndex(index);

        Node<E> current = this.head;

        for (int i = 0; i < index; i++)
            current = current.getNext();

        return current.getData();

    }

    @Override
    public E removeHead() {

        if (isEmpty())
            throw new IndexOutOfBoundsException("Index: 0, Size: 0");

        E data = head.getData();
        head = head.getNext();

        size--;

        return data;

    }

    @Override
    public E removeTail() {

        if (isEmpty())
            throw new IndexOutOfBoundsException("Index: %s, Size: %s".formatted(size - 1, size));

        Node<E> current = this.head;

        // get the one before the last
        for (int i = 0; i < size - 2; i++)
            current = current.getNext();

        E data = tail.getData();

        // set the one that was before the last as the new last
        tail = current;

        // remove the last
        tail.setNext(null);

        size--;

        return data;

    }

    @Override
    public E remove(int index) {

        checkIndex(index);

        if (index == 0)
            return removeHead();

        else if (index == size - 1)
            return removeTail();

        else {

            Node<E> current = this.head;

            for (int i = 0; i < index - 1; i++)
                current = current.getNext();

            E data = current.getNext().getData();
            current.setNext(current.getNext().getNext());

            size--;

            return data;

        }

    }

    @Override
    public Iterator<E> iterator() {

        return new SimplyLinkedListIterator();

    }

    private class SimplyLinkedListIterator implements Iterator<E> {

        private Node<E> current;

        public SimplyLinkedListIterator() {

            this.current = head;

        }

        @Override
        public boolean hasNext() {

            return current != null;

        }

        @Override
        public E next() {

            E data = current.getData();
            current = current.getNext();

            return data;

        }

    }

    @Override
    public void set(int index, E element) {

        throw new UnsupportedOperationException("Unimplemented method 'set'");

    }

    @Override
    public boolean contains(E element) {

        throw new UnsupportedOperationException("Unimplemented method 'contains'");

    }

    @Override
    public int indexOf(E element) {

        throw new UnsupportedOperationException("Unimplemented method 'indexOf'");

    }

    @Override
    @SuppressWarnings("unchecked")
    public E[] toArray() {

        var list = new ArrayList<E>(size);

        for (E item : this)
            list.add(item);

        E[] arr = (E[]) list.toArray();

        // if this list can be sorted, return it sorted, if not, then return it as is
        return list.get(0) instanceof Comparable ? sort(arr) : arr;

    }

    private E[] sort(E[] arr) {

        return sort(arr, 0, arr.length - 1);

    }

    private E[] sort(E[] arr, int start, int end) {

        if (start < end) {

            int pivot = partition(arr, start, end);

            sort(arr, start, pivot - 1);

            sort(arr, pivot + 1, end);

        }

        return arr;

    }

    @SuppressWarnings("unchecked")
    private int partition(E[] arr, int start, int end) {

        E pivot = arr[end];

        int i = start - 1;

        for (int j = start; j <= end - 1; j++) {

            if (((Comparable<E>) arr[j]).compareTo(pivot) < 0) {

                i++;

                E temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;

            }

        }

        i++;

        E temp = arr[i];
        arr[i] = arr[end];
        arr[end] = temp;

        return i;

    }

    public static SimplyLinkedList<?> fromArray(Object[] arr) {

        var list = new SimplyLinkedList<>();

        if (arr.length == 0)
            return list;

        for (Object item : arr)
            list.append(item);

        return list;

    }

    @Override
    public String toString() {

        StringBuilder str = new StringBuilder("[ ");

        for (E item : this)
            str.append(item).append(", ");

        if (str.length() > 1)
            str.delete(str.length() - 2, str.length());

        str.append(" ]");

        return str.toString();

    }

}
