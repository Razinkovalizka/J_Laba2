package org.example.methods;
import org.example.Stack;
import java.math.BigDecimal;
import java.util.Scanner;
/**
 * Класс Postfix представляет собой реализацию вычисления значения выражения,
 * представленного в постфиксной форме (после использования ShuntingYard)
 *
 * @author Razinkova_Elizaveta
 */
public class Postfix {
    /**
     * Метод, который находит значение постфиксного выражения
     *
     * @param postfix постфиксное выражение, предварительно сделать так:
     *                <pre>{@code
     *                   String postfix = ShuntingYard.PostFixForm(infix);
     *                }</pre>
     * @return вычисленное значение
     */
    public static double Calculation(String postfix) {

        if (postfix == null) {
            NullPointerException e;
            System.out.println("Неправильный ввод выражения!");
            return 0;
        }

        Stack<Double> stack = new Stack<>();
        Scanner scanner = new Scanner(postfix);

        if (!postfix.isEmpty()) {
            while (scanner.hasNext()) {

                if (scanner.hasNextDouble()) {
                    stack.push(scanner.nextDouble());
                } else {

                    if (stack.peek() == null) {
                        NullPointerException e;
                        System.out.println("Выражение записано некорректно!");
                        postfix = null;
                        return 0;
                    }

                    double y = stack.pop();
                    if (!stack.isEmpty()) {

                        double x = stack.pop();
                        char data = scanner.next().charAt(0);

                        switch (data) {
                            //Число с плавающей точкой
                            case '.':
                                BigDecimal num = new BigDecimal(y);
                                int point = (int) Math.log10(num.longValue()) + 1;
                                BigDecimal shift = num.movePointLeft(point);
                                double z = shift.doubleValue();
                                stack.push(x + z);
                                break;
                            //Степень числа
                            case '^':
                                stack.push(Math.pow(x, y));
                                break;
                            //Сожение
                            case '+':
                                stack.push(x + y);
                                break;
                            //Разность
                            case '-':
                                stack.push(x - y);
                                break;
                            //Умножение
                            case '*':
                                stack.push(x * y);
                                break;
                            //Деление
                            case '/':
                                if ((y != 0)) {
                                    stack.push(x / y);
                                } else {
                                    System.out.println("На ноль делить в калькуляторе нельзя!:)");
                                    return 0;
                                }
                                break;
                            //Отрицательные числа обозначены через "="
                            case '=':
                                stack.push(x);
                                stack.push(y * (-1));
                        }
                    } else {
                        char data = scanner.next().charAt(0);
                        if (data == '=') {
                            stack.push(y * (-1));
                        }
                    }
                }
            }
            scanner.close();

            if (!stack.isEmpty()) {
                //Вывод чисел с округлением до десятитысячных
                double answer = stack.pop();
                return Math.floor(answer * 10000) / 10000;

            } else {

                NullPointerException e;
                System.out.println("Ошибка ввода выражения!");
            }
        }
        return 0;
    }
}
