package pinPong;

public class Main {


    public static void main(String[] args) {
        Object LOCK_OBJECT = new Object();
        Thread ping = new Thread(new PingPongThread(LOCK_OBJECT, "ping"));
        Thread pong = new Thread(new PingPongThread(LOCK_OBJECT, "pong"));
        ping.start();
        pong.start();
    }
}
