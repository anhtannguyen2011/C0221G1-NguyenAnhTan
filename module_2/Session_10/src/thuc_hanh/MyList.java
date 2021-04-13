package thuc_hanh;

import java.util.Arrays;

public class MyList<E> {
    private int size = 0;
    private static final int DEFAULT_CAPACITY = 10;
    private Object elements[];

    public MyList() {

    }
    public MyList(int capacity){
        elements = new Object[DEFAULT_CAPACITY];
    }

    private void ensureCapa() {
        int newSize = elements.length * 2;
        elements = Arrays.copyOf(elements, newSize);
    }

    public void add(E e) {
        if (size == elements.length) {
            ensureCapa();
        }
        elements[size++] = e;
    }

    public E get(int i){
        if (i >= size || i < 0) throw new IndexOutOfBoundsException("Index: " + i + ", Size" + i);
        return (E) elements[i];
    }
    public boolean contains(E e){
        for(int i = 0; i< size; i++){
            if(e.equals(elements[i])){
                return true;
            }
        }
        return false;
    }
    public int indexOf(E e){
        for (int i =0 ; i < size; i++){
            if(e.equals(elements[i])){
                return i;
            }
        }
        return -1;
    }

}
