package BO;

public class ConsoleLogger implements ILogger {
    @Override
    public void log(String message) {
        System.out.println("[LOG] " + message);
    }
}