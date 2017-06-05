package com.lpoo.game.Tests;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;

/**
 * Created by beerzy on 05-06-2017.
 */

@RunWith(MockitoJUnitRunner.class)
public class UnitTesting {
private char chessBoard[][]={
            {'r','k','b','q','a','b','k','r'},
            {'p','p','p','p','p','p','p','p'},
            {' ',' ',' ',' ',' ',' ',' ',' '},
            {' ',' ',' ',' ',' ',' ',' ',' '},
            {' ',' ',' ',' ',' ',' ',' ',' '},
            {' ',' ',' ',' ',' ',' ',' ',' '},
            {'P','P','P','P','P','P','P','P'},
            {'R','K','B','Q','A','B','K','R'}
    };
    @Test
    public void test1(){
        assertEquals(2,2);
    }


}
