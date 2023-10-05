public class Counter implements AutoCloseable {
    private static int count;

    public Counter() {
        count = 1;
    }

    public void add() {
        count++;
    }

    public static int getCount() {
        return count;
    }

    @Override
    public void close() {
        System.out.println("Counter closed");
    }
}