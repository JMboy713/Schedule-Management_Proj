package com.test.testframework.event;

public interface Event {
    void print();
    boolean support(EventType type);
}
