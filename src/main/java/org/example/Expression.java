package org.example;
import org.example.methods.*;

/**
 * Класс Expression представляет собой реализацию разбора выражения и вычисление его значения
 *
 * @author Razinkova_Elizaveta
 */
public class Expression {
    private final String instance;

    /**
     * Конструктор по умолчанию
     *
     * @example <pre>{@code
     *           Solution<Integer> sol = new Solution<>();
     *      }</pre>
     * */
    public Expression() {
        instance = "";
    }

    /**
     * Конструктор, который принимает выражение
     *
     * @param str  выражение
     *
     * @example <pre>{@code
     *                  String str = "1+2";
     *                  Solution sol = new Solution(str);
     *            }</pre>
     * */
    public Expression(String str) {
        instance = "(" + str + ")";
    }

    /**
     * Метод, в котором разбирается выражение и вычисляется его значения
     *
     * @return answer - полученное значение после разборки и вычисления выражения
     */
    public double Evaluation(){
        String example = FunctionsAndVariables.Replace(instance);
        example = ShuntingYard.PostFixForm(instance);
        return Postfix.Calculation(example);
    }

    /**
     * Метод, в котором проверяется, сбалансированы ли скобки
     *
     * @return true - скобки расположены правильно/ false - скобки расположены неправильно
     */
    public boolean areBracketsBalanced() {
        String expr = instance;
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < expr.length(); i++) {
            char x = expr.charAt(i);
            //System.out.println((i+1) + " shag " + x);
            if (x == '(' || x == '[' || x == '{') {
                stack.push(x);
                continue;
            }
            if (stack.isEmpty())
                return false;
            char check;
            switch (x) {
                case ')':
                    check = stack.pop();
                    if (check == '{' || check == '[')
                        return false;
                    break;
                case '}':
                    check = stack.pop();
                    if (check == '(' || check == '[')
                        return false;
                    break;
                case ']':
                    check = stack.pop();
                    if (check == '(' || check == '{')
                        return false;
                    break;
            }
        }

        return (stack.isEmpty());
    }

    /**
     * Метод проверки выражение на пустоту
     *
     * @return true - выражение пустое / false - выражение непустое
     */
    public boolean isEmpty() {
        return (instance == null || instance.equals("()"));
    }

    /**
     * Перегруженный метод toString класса Object
     *
     * @return возвращает строку с информацией о выражении
     */
    @Override
    public String toString() {
        String str = "";
        str = instance;
        return str;
    }

}