package model;

public class Counter implements AutoCloseable {
    private int count = 0;
    private boolean isOpen = true;

    public void add() {
        if (!isOpen) {
            throw new IllegalStateException("Counter is closed");
        }
        count++;
    }

    public int getCount() {
        if (!isOpen) {
            throw new IllegalStateException("Counter is closed");
        }
        return count;
    }

    @Override
    public void close() {
        isOpen = false;
    }
}
