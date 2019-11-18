package ru.Otus;

import java.util.*;
import java.util.function.UnaryOperator;

public class DIYArrayList<E>implements List<E> {
    private int size=0;
    private int capacity=10;
    private Object[] array=new Object[capacity];
    private int index=0;

    public void printArray(String c){
        System.out.print(c+"[");
        for(int i=0;i<size-1;i++){
            System.out.print(array[i]+", ");
        }
        System.out.println(array[size-1]+"]");
        System.out.println();
    }

    @Override
    public boolean add(E e) {
        if(index==array.length-1){
            growArray();
        }
        array[index]=e;
        index++;
        size++;
        return true;
    }

    private void growArray(){
        E[] newArray = (E[])new Object[array.length * 2];
        System.arraycopy(array, 0, newArray, 0, index );
        array = newArray;
    }

    public boolean addAll(DIYArrayList c, E...elements){
        boolean result=false;
        for(E element:elements)
            result|=c.add(element);
        return result;
    }

    public void copy(DIYArrayList c,DIYArrayList e){
        Object[] a=c.toArray();
        for(int i=0;i<a.length;i++){
            e.add(a[i]);
        }
    }

    public void sort(Comparator<? super E> c) {
        Arrays.sort((E[]) array, 0, size, c);
    }


    @Override
    public void replaceAll(UnaryOperator<E> operator) {
        throw new UnsupportedOperationException();
    }


    @Override
    public Spliterator<E> spliterator() {
        throw new UnsupportedOperationException();
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public boolean isEmpty() {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean contains(Object o) {
        throw new UnsupportedOperationException();
    }

    @Override
    public Iterator<E> iterator() {
        throw new UnsupportedOperationException();
    }

    @Override
    public Object[] toArray() {
        return Arrays.copyOf(array, size);
    }

    @Override
    public <T> T[] toArray(T[] a) {
        if (a.length < size)
            return (T[]) Arrays.copyOf(array, size, a.getClass());
        System.arraycopy(array, 0, a, 0, size);
        if (a.length > size)
            a[size] = null;
        return a;
    }

    @Override
    public boolean remove(Object o) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean addAll(Collection<? extends E> c) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean addAll(int index, Collection<? extends E> c) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void clear() {
        throw new UnsupportedOperationException();
    }

    @Override
    public E get(int index) {
        return (E) array[index];
    }

    @Override
    public E set(int index, E element) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void add(int index, E element) {
        throw new UnsupportedOperationException();
    }

    @Override
    public E remove(int index) {
        throw new UnsupportedOperationException();
    }

    @Override
    public int indexOf(Object o) {
        throw new UnsupportedOperationException();
    }

    @Override
    public int lastIndexOf(Object o) {
        throw new UnsupportedOperationException();
    }

    @Override
    public ListIterator<E> listIterator() {
        throw new UnsupportedOperationException();
    }

    @Override
    public ListIterator<E> listIterator(int index) {
        throw new UnsupportedOperationException();
    }

    @Override
    public List<E> subList(int fromIndex, int toIndex) {
        throw new UnsupportedOperationException();
    }
}

