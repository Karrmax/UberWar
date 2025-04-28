package Calcul;

import java.util.Arrays;

public class UArray<T> {
    private Object[] elements;
    private int size;

    public UArray() {
        elements = new Object[10]; // default initial capacity
        size = 0;
    }

    public UArray(int initialCapacity) {
        if (initialCapacity < 0) {
            throw new IllegalArgumentException("Capacity must be non-negative");
        }
        elements = new Object[initialCapacity];
        size = 0;
    }

    // Add element to the array
    public void add(T element) {
        ensureCapacity(size + 1);
        elements[size++] = element;
    }

    // Get element at specific index
    @SuppressWarnings("unchecked")
    public T get(int index) {
        checkIndex(index);
        return (T) elements[index];
    }

    // Set element at specific index
    public void set(int index, T element) {
        checkIndex(index);
        elements[index] = element;
    }

    // Get current size
    public int size() {
        return size;
    }

    // Internal method to grow array if needed
    private void ensureCapacity(int minCapacity) {
        if (minCapacity > elements.length) {
            int newCapacity = Math.max(elements.length * 2, minCapacity);
            elements = Arrays.copyOf(elements, newCapacity);
        }
    }

    // Check if index is in bounds
    private void checkIndex(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0; i < size; i++) {
            sb.append(elements[i]);
            if (i < size - 1) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }
}

