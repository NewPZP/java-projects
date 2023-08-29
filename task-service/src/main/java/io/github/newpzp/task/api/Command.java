package io.github.newpzp.task.api;

public interface Command<T> {
    
    T execute();

    String getExecutorName();
}
