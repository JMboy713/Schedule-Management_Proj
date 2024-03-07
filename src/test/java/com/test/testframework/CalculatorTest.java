package com.test.testframework;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {

    /*
     * @Test : 테스트 메서드임을 선언
     * @ParameterizedTest : 파라미터를 받을 수 있는 테스트 메서드임을 선언
     * @RepeatedTest : 반복되는 테스트를 작성할 수 있음.
     * @DisplayName : 테스트 메서드 이름을 직접 정의할 수 있음
     * @BeforeEach : 각 테스트 메서드가 실행되기 전에 실행
     * @AfterEach : 각 테스트 메서드가 실행된 후에 실행
     * @Disabled : 테스트를 무시함
     * */

    @Test
    @DisplayName("더하기 테스트")
    void sum() {
        // given
        Calculator calculator = new Calculator();
        int a = 10;
        int b = 20;
        int expected = 30;

        //when
        int actual = calculator.sum(a, b);


        //then
        assertEquals(expected, actual);
    }


    @ParameterizedTest
    @MethodSource("numberProvider")
    @DisplayName("더하기 테스트2")
    void sum2(int a, int b, int expected) {
        // given
        Calculator calculator = new Calculator();




        //when
        int actual = calculator.sum(a, b);


        //then
        assertEquals(expected, actual);
    }
    @ParameterizedTest
    @MethodSource("numberProviderForException")
    @DisplayName("음수 예외 처리")
    void sum3(int a, int b) {
        // given
        Calculator calculator = new Calculator();

        //when & Then
        assertThrows(RuntimeException.class, () -> calculator.sum(a, b)); // params : (어떤 예외가 터질지, 예외가 터지는 상황)

    }



    static Stream<Arguments> numberProvider() { // 전달해줄 파라미터를 정의
        return Stream.of(
                Arguments.of(1, 2, 3),
                Arguments.of(3, 4, 7),
                Arguments.of(5, 6, 11),
                Arguments.of(7, 8, 15)

        );
    }
    static Stream<Arguments> numberProviderForException() { // 전달해줄 파라미터를 정의
        return Stream.of(
                Arguments.of(-1, 2, 3),
                Arguments.of(-7, 8, 15)

        );
    }
}