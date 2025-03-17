package khutyz.block2;

import java.util.Scanner;

public class Task3 {
    private volatile Boolean flag = false;

    public static void main(String[] args) {
        while (true) {
            Scanner console = new Scanner(System.in);
            String text = console.next();

            Task3 task3Thread = new Task3();
            task3Thread.testRun(text);
        }
    }

    private void testRun(String text) {
        Thread th1 = new Thread(() -> {
            synchronized (this) {
                while (true) {
                    try {
                        wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    while (flag) {
                        System.out.println("DEAMON START");
                        System.out.println("ОТБОЙ");
                        notify();
                        System.out.println("DEAMON BLOCK");
                        blocking("ОТБОЙ");
                    }
                }
            }
        });

        Thread th2 = new Thread(() -> {
            System.out.println("thread START");
            unlock(text);
            synchronized (this) {
                try {
                    System.out.println("thread BLOCK");
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("thread NOT BLOCK");
        });

        th1.start();
        th2.start();
    }

    private synchronized void blocking(String text) {
        if(text.equalsIgnoreCase("ОТБОЙ")) {
            try {
                flag = false;
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private synchronized void unlock(String text) {
        if(text.equalsIgnoreCase("ПОДЪЕМ")) {
            flag = true;
            notify();
        }
    }
}
