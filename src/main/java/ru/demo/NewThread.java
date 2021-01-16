package ru.demo;

public class NewThread implements Runnable{
    Thread t;
    NewThread(){
        //cоздаем новый ворой поток исполнения
        t = new Thread(this, "demoThread");
        System.out.println("дочерний поток создан" + t);
        //запускаем поток исполнения
        t.start();
    }
    @Override
    public void run() {
        for (int i = 5; i > 0; i--){
            System.out.println("дочерний поток " + i);
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                System.out.println("Дочерний поток прерван");
            }
        }
        System.out.println("Дочерний поток завершён");
    }
}
