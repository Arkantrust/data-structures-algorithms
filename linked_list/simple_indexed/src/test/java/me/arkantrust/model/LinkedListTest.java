package me.arkantrust.model;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class LinkedListTest {

    private SimplyLinkedList<Integer> list;

    public void setEmptyList() {

        list = new SimplyLinkedList<Integer>();

    }

    public void setList() {

        list = new SimplyLinkedList<Integer>();
        list.append(100);
        list.append(200);
        list.append(300);
        list.append(400);
        list.append(500);

    }

    @Test
    public void testEmptyList() {

        setEmptyList();
        assertTrue(list.isEmpty());
        assertEquals(0, list.size());

    }

    @Test
    public void testAppendEmpty() {

        setEmptyList();
        list.append(100);
        assertEquals(1, list.size());
        assertEquals(100, list.head());
        assertEquals(100, list.tail());

    }

    @Test
    public void testAppend() {

        setList();
        list.append(600);
        assertEquals(6, list.size());
        assertEquals(600, list.tail());
        assertEquals(600, list.get(5));

    }

    @Test
    public void testPushEmpty() {

        setEmptyList();
        list.push(100);
        assertEquals(1, list.size());
        assertEquals(100, list.head());
        assertEquals(100, list.tail());

    }

    @Test
    public void testPush() {

        setList();
        list.push(50);
        assertEquals(6, list.size());
        assertEquals(50, list.head());
        assertEquals(50, list.get(0));

    }

    @Test
    public void testGet() {

        setList();
        assertEquals(100, list.get(0));
        assertEquals(200, list.get(1));
        assertEquals(300, list.get(2));
        assertEquals(400, list.get(3));
        assertEquals(500, list.get(4));

    }

    @Test
    public void testRemoveHead() {

        setList();
        list.remove(0);
        assertEquals(200, list.head());
        assertEquals(4, list.size());

    }

    @Test
    public void testRemoveTail() {

        setList();
        list.remove(4);
        assertEquals(400, list.tail());
        assertEquals(4, list.size());

    }

    @Test
    public void testRemove() {

        setList();
        list.remove(2);
        assertEquals(4, list.size());
        assertEquals(400, list.get(2));

    }
    
}
