package me.arkantrust;

import me.arkantrust.model.SimplyLinkedList;

public class ListApp {
    
    public static void main(String[] args) {
        
        showIntList();

        showPersonList();

    }

    private static void showIntList() {

        System.out.println("# Integer List\n");
        var list = new SimplyLinkedList<Integer>();
        list.append(100);
        list.append(200);
        list.append(300);
        list.append(400);
        list.append(500);
        System.out.println("Size: " + list.size());
        System.out.println("Head: " + list.head());
        System.out.println("Tail: " + list.tail());
        System.out.println("List: " + list + "\n");
        
    }

    private static void showPersonList() {
        
        System.out.println("# Person List\n");
        var list = new SimplyLinkedList<Person>();
        list.append(new Person("John", 30));
        list.append(new Person("Jane", 25));
        list.append(new Person("Joe", 40));
        list.append(new Person("Jill", 35));
        list.append(new Person("Jack", 20));
        System.out.println("Size: " + list.size());
        System.out.println("Head: " + list.head());
        System.out.println("Tail: " + list.tail());
        System.out.println("List: " + list + "\n");
        
    }

    private record Person(String name, int age) {

        @Override
        public String toString() {
        
            return "%s (%d)".formatted(name, age);
        
        }

    }

}
