package BO;


public class ConsoleLogger implements ILogger, Observer {
    private Subject subject;

    public ConsoleLogger(Subject subject) {
        this.subject = subject;
        this.subject.registerObserver(this);
    }

    @Override
    public void log(String message) {
        System.out.println("[LOG] " + message);
    }

    @Override
    public void update(String message) {
        log(message);
    }
}

