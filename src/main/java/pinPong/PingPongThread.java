package pinPong;


import lombok.SneakyThrows;

public class PingPongThread implements Runnable {
    private String name;
    private Object LOCK_OBJECT;

    PingPongThread(Object LOCK_OBJECT, String name) {
        this.LOCK_OBJECT = LOCK_OBJECT;
        this.name = name;

    }

    @Override
    @SneakyThrows
    public void run() {
        synchronized (LOCK_OBJECT) {
            while (true) {
                System.out.println(name);
                Thread.sleep(1000);
                 LOCK_OBJECT.notify();
                 LOCK_OBJECT.wait(1000);
            }
        }
    }
}
