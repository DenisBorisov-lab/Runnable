package pinPong;

import lombok.SneakyThrows;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class PingPongUsingReentrantCondition {
    private static ReentrantLock lock = new ReentrantLock(true);
    private Condition condition = lock.newCondition();

    public static void main(String[] args) {
        PingPongUsingReentrantCondition pingPong = new PingPongUsingReentrantCondition();
        Thread ping = new Thread(() -> pingPong.pingpong("ping", 5));
        Thread pong = new Thread(() ->pingPong.pingpong("pong", 5) );
        ping.start();
        pong.start();

    }

    public void pingpong(String s, int times){
        int counter = 1;
        while(counter <= times){
            run(s, counter);
            counter++;
        }
    }
    @SneakyThrows
    public void run(String s, int counter){
        lock.lock();
        condition.await(2, TimeUnit.SECONDS);
        System.out.println(s + "(" + counter + ")");
        condition.signal();
        lock.unlock();
    }
}
