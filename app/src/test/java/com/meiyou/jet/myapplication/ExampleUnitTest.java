package com.meiyou.jet.myapplication;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    @Test
    public void addition_isCorrect() throws Exception {
        assertEquals(4, 2 + 2);
    }
    
    @Test
    public void test() throws Exception{
        int position=7;
//        position = position - ((position+1)/3);
//        System.out.println("position: "+position);
       //纵
        int po = (position) / 3 + 1;
        //横
        int ps = (position) % 3 +1 ;
        System.out.println("po: "+po);
        System.out.println("ps: "+ps);
        assertEquals(4, 2 + 2);
    }
}