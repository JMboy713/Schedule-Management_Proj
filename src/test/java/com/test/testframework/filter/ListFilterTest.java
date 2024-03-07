package com.test.testframework.filter;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ListFilterTest {

    private static ListFilter filter;
    private static List<Integer> target;


    @BeforeAll
    static void setup(){
        filter = new ListFilter();
        target = new ArrayList<>();
        createMockData();
    }

    private static void createMockData() {
        for (int i = 1; i < 101; i++) {
            target.add(i);
        }
    }

    @Test
    @DisplayName("필터링 테스트 1")
    void filterBy(){
        // given
        int from = 5;
        int to = 10;

        List<Integer> expected = List.of(6,7,8,9);
        int expectedSize = to - from - 1;


        // when
        List<Integer> actual =  filter.filterBy(target, from, to);
        // then
//        assertEquals(expected, actual);
         assertEquals(expectedSize, actual.size());

    }
    @Test
    @DisplayName("필터링 예외 처리 테스트")
    void filterByException(){
        // given
        int from = 10;
        int to = 5;


        // when
        // then
        assertThrows(IllegalArgumentException.class, ()-> filter.filterBy(target, from, to));
    }



}