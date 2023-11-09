package org.example;

import org.example.Expression;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ExpressionTest {
    //Проверка, что метод Calculation корректно работает с пустой строкой.
    @Test
    public void testEvaluationInEmptyString(){

        Expression sol = new Expression();
        assertEquals(0,sol.Evaluation());
    }

    //Проверка, что метод Calculation корректно работает с непустой строкой.
    @Test
    public void testEvaluationInNotEmptyString(){

        Expression sol = new Expression("5*8+2^2-0.7");

        assertEquals(43.3,sol.Evaluation());
    }
    //Проверка, что метод AreBracketsBalanced корректно работает с пустой строкой.
    @Test
    public void testAreBracketsBalanced1(){
        Expression sol = new Expression();

        assertTrue(sol.areBracketsBalanced());
    }

    //Проверка, что метод AreBracketsBalanced корректно работает заполненной строкой.
    @Test
    public void testAreBracketsBalanced2(){

        Expression sol1 = new Expression("(123)");
        Expression sol2 = new Expression("({[123]})");
        Expression sol3 = new Expression(")([]}{");
        Expression sol4 = new Expression("()()())");
        Expression sol5 = new Expression("((())(()))");

        assertTrue(sol1.areBracketsBalanced());
        assertTrue(sol2.areBracketsBalanced());
        assertFalse(sol3.areBracketsBalanced());
        assertFalse(sol4.areBracketsBalanced());
        assertTrue(sol5.areBracketsBalanced());
    }


}