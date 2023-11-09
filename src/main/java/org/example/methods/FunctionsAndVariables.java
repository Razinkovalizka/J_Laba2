package org.example.methods;
import java.util.Scanner;
/**
 * Класс FunctionsAndVariables представляет собой реализацию замены переменных и функций
 * в выражении на числовое значение. В методе реализованы некоторые функции пакета MATH:
 * sin, cos, tan, exp, cbrt, log.
 *
 * @author Razinkova_Elizaveta
 */
public class FunctionsAndVariables {
    /**
     * Метод замены переменных и функций в выражении.
     * Используется метод function для нахождения функций пакета MATH.
     * Функции задаются только с переменной, переменные незаглавные, отличные от символов функции, пример:
     *          <pre>{@code
     *                Enter expression:
     *                sin(x) ~Enter
     *                Выражение содержит символы!
     *                Замените символ x на число:
     *                0.5 ~Enter
     *                ...
     *             }</pre>
     *В случае ввода sin(i) получите ошибку!
     *
     * @param expression выражение, которое может содержать переменные и(или) функции
     *
     * @return выражение из цифр и арифметических операций
     */
    public static String Replace (String expression){
        //System.out.println(expression);

        //Если нет символов, то возвращаем выражение без изменения
        if (!expression.matches(".*[a-zA-Z].*")) {
            return expression;

        } else if(expression.contains("error")) {
            return "0";
        } else{
            Scanner scanner = new Scanner(System.in);
            System.out.println("Выражение содержит символы!");

            char var = 'a';
            //Обходим всё выражение и заменяем переменные и функции на вычисленные значения
            do {
                if (expression.contains(String.valueOf(var))
                        && !expression.matches(".*"+var+"[a-zA-Z].*") //проверка на наличие функций
                        && !expression.matches(".*"+ var + "\\(.*" ))
                {
                    System.out.println("Замените символ \"" + var + "\" на число:");
                    String old_var = String.valueOf(var);
                    String new_var = scanner.nextLine();

                    //проверка на ввод числа
                    boolean valid = false;
                    while (!valid){
                        try {
                            Double.parseDouble(new_var);
                            valid = true;
                        } catch (NumberFormatException e){
                            System.out.println("Это не число! Введите снова:");
                            new_var = scanner.nextLine();
                        }
                    }

                    expression = expression.replaceAll(old_var, new_var);
                    expression = function(expression, new_var);
                }
                var = (char) (var + 1);
                if (var >= 'z' + 1) {
                    System.out.println("Ошибка при вводе выражения!");
                    return "error";
                }
            } while (expression.matches(".*[a-zA-Z].*"));
            return expression;
        }
    }

    /**
     * Метод преобразования функций в вычисленные значения.
     *
     * @param exp выражение
     * @param receive число, стоящее внутри функции
     *
     * @return выражение с вычисленной функцией
     */
    private static String function(String exp, String receive){

        double var = Double.parseDouble(receive);

        //Некоторые операции могут дать ответ с минусом, поэтому
        // во избежание ошибки в PostfixCreator "-" меняется на "="
        if (exp.contains("sin")) {
            double ans = Math.sin(var);
            String param;

            if (ans < 0) {
                param = "=" + (ans*(-1));
            }  else {param = "" + ans; }

            exp = exp.replaceAll("sin\\(" + receive + "\\)",param );
        }
        if (exp.contains("cos")) {
            double ans = Math.cos(var);
            String param;

            if (ans < 0) {
                param = "=" + (ans*(-1));
            }  else {param = "" + ans; }

            exp = exp.replaceAll("cos\\(" + receive + "\\)",param );

        }
        if (exp.contains("tan")) {
            double ans = Math.tan(var);
            String param;

            if (ans < 0) {
                param = "=" + (ans*(-1));
            }  else {param = "" + ans; }

            exp = exp.replaceAll("tan\\(" + receive + "\\)",param );

        }
        if (exp.contains("exp")) {
            exp = exp.replaceAll("exp\\(" + receive + "\\)", String.valueOf(Math.exp(var)));

        }
        if (exp.contains("cbrt")) {
            double ans = Math.cbrt(var);
            String param;

            if (ans < 0) {
                param = "=" + (ans*(-1));
            }  else {param = "" + ans; }

            exp = exp.replaceAll("cbrt\\(" + receive + "\\)",param );

        }
        if (exp.contains("log(" + receive + ")")) {
            //В логарифме переменные больше нуля
            if (var <= 0) return "error";
            double ans = Math.log(var);
            String param;

            if (ans < 0) {
                param = "=" + (ans*(-1));
            }  else {param = "" + ans; }

            exp = exp.replaceAll("log\\(" + receive + "\\)",param );
        }

        return exp;
    }
}
