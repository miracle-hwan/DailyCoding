package com.miraclehwan.calculator;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CalculatorTest {

    Calculator calculator;

    @Before
    public void setup(){
        calculator = new Calculator();
    }

    @Test
    public void CalculatorTest(){
        //더하기
        assertEquals(4, calculator.add(2,2));
        assertEquals(4, calculator.add(1,3));
        assertEquals(48, calculator.add(19,29));
        assertEquals(10, calculator.add(4,6));

        //빼기
        assertEquals(4, calculator.sub(10,6));
        assertEquals(4, calculator.sub(6,2));
        assertEquals(48, calculator.sub(60,12));
        assertEquals(10, calculator.sub(10,0));

        //곱하기
        assertEquals(60, calculator.multi(10,6));
        assertEquals(12, calculator.multi(6,2));
        assertEquals(720, calculator.multi(60,12));
        assertEquals(0, calculator.multi(10,0));

        //나누기
        assertEquals(1, calculator.dvide(10,6));
        assertEquals(3, calculator.dvide(6,2));
        assertEquals(5, calculator.dvide(60,12));
        assertEquals(2, calculator.dvide(10,4));
    }

}