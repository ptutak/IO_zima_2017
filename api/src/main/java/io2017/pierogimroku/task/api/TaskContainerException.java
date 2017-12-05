package io2017.pierogimroku.task.api;

public class TaskContainerException extends RuntimeException{
    public TaskContainerException() {
    }

    public TaskContainerException(String s) {
        super(s);
    }

    public TaskContainerException(String s, Throwable throwable) {
        super(s, throwable);
    }

    public TaskContainerException(Throwable throwable) {
        super(throwable);
    }

    public TaskContainerException(String s, Throwable throwable, boolean b, boolean b1) {
        super(s, throwable, b, b1);
    }
}
