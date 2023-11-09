package org.example;

/**
 * Класс Stack представляет собой реализацию стека
 *
 * @param <T> тип данных, использующийся при работе с классом
 *
 * @author Razinkova_Elizaveta
 */
public class Stack<T> {

    /**
     * Node - класс узлов, из которых состоит стек
     */
    private static class Node <T> {
        private final T data;
        private Node<T> next;

        /**
         * Конструктор с параметрами
         *
         * @param data данные, которые будут храниться в узле
         */
        private Node(T data) {
            this.data = data;
            next = null;
        }

        /**
         * Перегруженный метод toString  из класса Object
         *
         * @return Возвращает строку с информацией об элементе узла
         */
        @Override
        public String toString() {
            return data.toString();
        }
    }

    private Node<T> top;
    private int size;

    /**
     * Конструктор по умолчанию
     *
     * @example <pre>{@code
     *           Stack<Integer> stack = new Stack<>();
     *      }</pre>
     * */
    public Stack() {
        top = null;
        size = 0;
    }
    /**
     * Конструктор, принимающий один параметр на вход
     *
     * @param x принимает любой тип данных
     *
     * @example <pre>{@code
     *           Stack<Integer> stack = new Stack<>(5);
     *      }</pre>
     * */
    public Stack(T x){
        if (x!=null) {
            top = new Node<>(x);
            size = 1;
        } else {
            System.err.println("Неверные данные, элемент не может быть null");
            top = null;
            size = 0;
        }
    }

    /**
     * Конструктор, который позволяет преобразовывать массив в стек
     *
     * @param a  массив элементов
     *
     * @example <pre>{@code
     *                  Integer []a=new Integer[]{1,2,3,4,5};
     *                  Stack<Integer> ыефсл=new Stack<>(a);
     *            }</pre>
     * */
    public Stack(T[] a){
        try{
            for(T i: a){
                push(i);
            }
        }catch(NullPointerException e){
            top = null;
            size = 0;
        }

    }

    /**
     * Метод добавления элемента в стек
     *
     * @param data элемент, которые будет добавлен в узел стека
     */
    public void push(T data) {
        if (top == null) {
            top = new Node<>(data);
        } else {
            Node<T> N = new Node<>(data);
            N.next = top;
            top = N;
        }

        ++size;
    }

    /**
     * Метод извлечения "верхнего" элемента в стеке
     *
     * @return x - извлечённая переменная типа T
     */
    public T pop() {
        if (top != null) {
            Node<T> N = top;
            T x = N.data;
            top = N.next;
            --size;
            return x;
        }
        return null;
    }


    /**
     * Метод проверки стека на пустоту
     *
     * @return true - стек пустой / false - стек непустой
     */
    public boolean isEmpty() {
        return (top == null);
    }

    /**
     * Метод получения размерности стека
     * @return размер стека
     */
    public int size() {
        return size;
    }

    /**
     * Метод извлечения первого (верхнего элемента стека) без его удаления
     *
     * @return первый элемент стека
     */
    public T peek(){
        if (!isEmpty()) {
            Node<T> N = top;
            return N.data;
        }
        return null;
    }

    /**
     * Метод очистки стека
     */
    public void clear() {
        top = null;
        size = 0;
    }

    /**
     * Перегруженный метод toString класса Object
     *
     * @return возвращает строку с информацией об элементах стека
     */
    @Override
    public String toString() {
        StringBuilder str = new StringBuilder("Стек:\t");
        Node<T> N = top;

        while (N != null) {
            str.append(N.toString());
            if (N.next != null) {
                str.append(" <--- ");
            }
            N = N.next;
        }

        return str.toString();
    }

}