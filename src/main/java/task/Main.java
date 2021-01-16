package task;

public class Main {
    static First first;
    static Second second;
    static Third third;
    public static void main(String[] args) throws InterruptedException {
        Thread.sleep(5000);
        first = new First();
        second = new Second();
        third = new Third();
        Thread fStart = new Thread(first);
        Thread sStart = new Thread(second);
        Thread tStart = new Thread(third);
        fStart.start();
        sStart.start();
        tStart.start();
        System.out.println("Главный поток запущен");
    }
}
