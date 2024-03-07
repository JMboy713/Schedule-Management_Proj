package com.test.testframework.filter

import spock.lang.Specification

class ListFilterTestSpock extends Specification {
    def "filterBySpock"() {
        given:
        def filter = new ListFilter()
        def target = []
        for (int i = 1; i < 101; i++) {
            target.add(i)
        }

        def from = 10
        def to = 20
        def expectedSize =9

        when:
        def actual = filter.filterBy(target, from, to)


        then:
        actual.size() == expectedSize
    }

    def "exception"(){
        given:
        def filter = new ListFilter()
        def target = []
        for (int i = 1; i < 101; i++) {
            target.add(i)
        }

        def from = 20
        def to = 10

        when:
        def actual = filter.filterBy(target, from,to)

        then:
        def error = thrown(IllegalArgumentException.class)
        error.message == "from은 to보다 작아야 합니다."
    }
}
