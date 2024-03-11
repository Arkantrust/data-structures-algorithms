package me.arkantrust.model;

public interface LinkedList<E> {

    public void add(int index, E element);

    public void push(E element);

    public void append(E element);

    public void clear();

    public boolean contains(E element);

    public E get(int index);

    public E head();

    public E tail();

    public int indexOf(E element);

    public E remove(int index);

    public E removeHead();

    public E removeTail();

    public void set(int index, E element);

    public int size();

    public E[] toArray();

    public boolean isEmpty();

}
