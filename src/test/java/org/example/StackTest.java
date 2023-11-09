package org.example;
import org.example.Stack;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class StackTest {
    //Проверка, что метод clear работает корректно с пустым стеком
    @Test
    void testClearInEmptyStack() {
        Stack<Integer> list = new Stack<>();
        int size = list.size();

        list.clear();

        assertEquals(size, list.size());
    }

    //Проверка, что метод clear работает корректно с непустым стеком
    @Test
    void testClearInNotEmptyStack() {
        Integer[] i = {1,2,3,4,5};
        Stack<Integer> list = new Stack<>(i);

        int size = list.size();

        list.clear();

        assertEquals(size - 5, list.size());
        assertEquals(0,list.size());
    }

    //Проверка, что isEmpty работает в пустом стеке.
    @Test
    public void testIsEmptyInEmptyStack(){
        Stack<Integer> list = new Stack<>();

        assertTrue(list.isEmpty());
    }

    //Проверка, что isEmpty работает в непустом стеке из одного элемента.
    @Test
    public void testIsEmptyInLonelyStack(){
        Stack<Integer> list = new Stack<>(1);

        assertFalse(list.isEmpty());
    }

    //Проверка, что isEmpty работает в непустом стеке из нескольких элементов.
    @Test
    public void testIsEmptyInNotLonelySTack(){
        Integer[] i = {1,2,3,4,5};
        Stack<Integer> list = new Stack<>(i);

        assertFalse(list.isEmpty());
    }

    //Проверка, что isEmpty работает после удаления всех элементов.
    @Test
    public void testIsEmptyAfterClear() {
        Integer[] i = {1,2,3,4,5};
        Stack<Integer> list = new Stack<>(i);

        list.clear();

        assertTrue(list.isEmpty());
    }

    //Проверка, что метод peek выводит корректно элемент пустого стека
    @Test
    void testPeekInEmptyStack() {
        Stack<Integer> list = new Stack<>();

        assertNull(list.peek());
    }

    //Проверка, что метод peek выводит корректно элемент очищенного стека
    @Test
    void testPeekInClearStack() {
        Integer[] i = {1,2,3,4,5};
        Stack<Integer> list = new Stack<>(i);

        list.clear();

        assertNull(list.peek());
    }

    //Проверка, что метод peek выводит корректно верхний элемент стека до и после добавления элемента
    @Test
    void testPeekAfterPush() {
        Integer[] i = {1,2,3,4,5};
        Stack<Integer> list = new Stack<>(i);

        assertEquals(5, list.peek());

        list.push(6);

        assertEquals( 6, list.peek());
    }

    //Проверка, что метод peek выводит корректно верхний элемент стека после удаления элемента
    @Test
    void testPeekAfterPop() {
        Integer[] i = {1,2,3,4,5};
        Stack<Integer> list = new Stack<>(i);

        int x = list.pop();

        assertEquals(x-1, list.peek());
    }

    //Проверка, что pop удаляет верхнее значение.
    @Test
    public void testPopTrueValue(){
        Integer[] i = {1,2,3,4,5};
        Stack<Integer> list = new Stack<>(i);
        int size = list.size();

        list.pop();

        assertEquals(4, (int) list.peek());
        assertEquals(size - 1, list.size());
    }

    //Проверка на удаление в пустом стеке.
    @Test
    void testPopInEmptyStack() {
        Stack<Integer> list = new Stack<>();

        assertEquals(0, list.size());
        assertNull(list.pop());
    }

    //Проверка, что метод pushBack корректно добавляет элемент в пустой стек.
    @Test
    public void testPushBackInEmptyStack(){
        Stack<Integer> list = new Stack<>();

        list.push(1);

        assertEquals(1,list.size());
        assertEquals(1, (int) list.peek());
        assertFalse(list.isEmpty());
    }

    //Проверка, что метод pushBack корректно добавляет элемент в непустой стек.
    @Test
    public void testPushBackInNotEmptyStack(){
        Integer [] a = {1,2,3,4,5,6,7};
        Stack<Integer> list = new Stack<>(a);

        int size = list.size();

        list.push(8);

        assertEquals(size + 1, list.size());
        assertEquals(8, (int) list.peek());
        assertFalse(list.isEmpty());
    }

    //Проверка, что метод size выводит корректный размер пустого стека
    @Test
    void testSizeInEmptyStack() {
        Stack<Integer> list = new Stack<>();

        assertEquals(0, list.size());
    }

    //Проверка, что метод size выводит корректный размер очищенного стека
    @Test
    void testSizeInClearStack() {
        Integer[] i = {1,2,3,4,5};
        Stack<Integer> list = new Stack<>(i);

        list.clear();

        assertEquals(0, list.size());
    }

    //Проверка, что метод size выводит корректный размер стека после добавления элемента
    @Test
    void testSizeAfterPush() {
        Integer[] i = {1,2,3,4,5};
        Stack<Integer> list = new Stack<>(i);

        int size = list.size();

        assertEquals(size, list.size());

        list.push(6);

        assertEquals(size+1 , list.size());
    }

    //Проверка, что метод size выводит корректный размер стека после удаления элемента
    @Test
    void testSizeAfterPop() {
        Integer[] i = {1,2,3,4,5};
        Stack<Integer> list = new Stack<>(i);

        int size = list.size();

        list.pop();

        assertEquals(size - 1, list.size());
    }

    //Проверка, что метод toString работает с пустым стеком
    @Test
    void testToStringInEmptyStack() {
        Stack<Integer> list = new Stack<>();

        assertEquals("Список:\t", list.toString());
    }

    //Проверка, что метод toString работает с непустым стеком
    @Test
    void testToStringInNotEmptyStack() {
        Integer[] i = {1,2,3,4,5};
        Stack<Integer> list = new Stack<>(i);

        assertEquals("Стек:\t5 <--- 4 <--- 3 <--- 2 <--- 1", list.toString());
    }

}