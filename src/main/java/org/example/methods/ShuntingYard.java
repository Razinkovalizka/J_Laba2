package org.example.methods;
import org.example.Stack;

import java.util.Map;

/**
 * Класс ShuntingYard представляет собой реализацию метода Маневровой Станции,
 * т.е. превращение выражения из инфиксной формы в постфиксную.
 * Здесь реализованы: '^', '*', '/', '+', '-', 'отрицательное число', 'число с плавающей точкой'.
 *
 * @author Razinkova_Elizaveta
 */
public class ShuntingYard {
    private static final String OPERATORS = "^=*/+-.";

    //Создание ключей для арифметических операций, сортировка операций по значимости
    // '^' - возведение в степень, '=' - обозначение числа с отрицательным знаком
    private static final Map<Character, Integer> PRECEDENCE = Map.of(
            '.',4,
            '^',3,
            '=',3,
            '*', 2,
            '/', 2,
            '+', 1,
            '-', 1
    );

    /**
     * Метод, который превращает инфиксное выражение в постфиксное
     *
     * @param infix инфиксное выражение
     *
     * @return полученное постфиксное выражение
     */
    public static String PostFixForm(String infix) {

        if (infix == null ) {
            NullPointerException e;
            System.out.println("Неправильный ввод выражения");
            return null;
        }

        StringBuilder postfix = new StringBuilder();
        Stack<Character> stack = new Stack<>();

        //Разбиваем выражение на токены
        for (char token : infix.toCharArray()) {

            if (Character.isDigit(token)) {
                postfix.append(token);

            } else if ( OPERATORS.contains(String.valueOf(token)) ) {

                //Расставляем приоритеты и заполняем стек арифметическими операциями
                while (!stack.isEmpty() && stack.peek() != '('
                        && PRECEDENCE.get(token) <= PRECEDENCE.get(stack.peek()))
                {  postfix.append(' ').append(stack.pop());  }

                postfix.append(' ');
                stack.push(token);

            } else if (token == '(') {
                stack.push(token);

                //Здесь идет заполнение стека числами
            } else if (token == ')') {
                while (!stack.isEmpty() && stack.peek() != '(')
                {  postfix.append(' ').append(stack.pop());  }

                stack.pop();
            }
        }
        while (!stack.isEmpty()) {  postfix.append(' ').append(stack.pop());  }

        if (!postfix.isEmpty()) return postfix.toString();
        return null;
    }
}
