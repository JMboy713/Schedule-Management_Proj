package com.test.testframework.filter;

import java.util.List;
import java.util.stream.Collectors;

public class ListFilter {
    public List<Integer> filterBy(List<Integer> target, int from ,int to) {
        if (from >to){
            throw new IllegalArgumentException("from은 to보다 작아야 합니다.");
        }
        return target.stream()
                .filter(each-> from <each && each < to)
                .collect(Collectors.toList());

    }
}
