package org.example.methods;
import org.example.methods.ShuntingYard;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ShuntingYardTest {

    //Проверка, что метод PostFixForm корректно работает с пустой строкой.
    @Test
    public void testPostFixFormInEmptyString(){

        assertNull(ShuntingYard.PostFixForm(null));
    }

    //Проверка, что метод PostFixForm корректно составляет постфиксную форму выражений.
    @Test
    public void testPostFixFormInNotEmptyString(){
        String str1 = " ";
        String str2 = "1+2";
        String str3 = "4*(2+3)";
        String str4 = "a+b+3";
        String str5 = "abc";

        assertNull(ShuntingYard.PostFixForm(str1));
        assertEquals("1 2 +",ShuntingYard.PostFixForm(str2));
        assertEquals("4 2 3 + *",ShuntingYard.PostFixForm(str3));
        assertEquals("  + 3 +",ShuntingYard.PostFixForm(str4));
        assertNull(ShuntingYard.PostFixForm(str5));
    }

}