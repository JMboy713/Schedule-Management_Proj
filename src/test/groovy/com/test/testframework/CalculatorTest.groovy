package com.test.testframework

import spock.lang.Specification

class CalculatorTest1 extends Specification {
    def "sum"() {
        given:

        def calculator = new Calculator()

        when:
        def actual = calculator.sum(a, b)

        then:
        actual == expected

        where:
        a  | b  | expected
        10 | 20 | 30
        20 | 30 | 50
        30 | 40 | 70

        // where 작성시 주의할 점은 where 블록의 변수명과 then 블록의 변수명이 같아야 한다, given 에서 쓴게 있으면 안됨.
    }

    def "exception"() {
        given:
        def calculator = new Calculator()

        when:
        def actual = calculator.sum(a, b)

        then:
        thrown(RuntimeException.class)

        where:
        a | b
        1 | -1


    }

}
