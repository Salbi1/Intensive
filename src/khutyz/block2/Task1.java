package khutyz.block2;

import java.util.Random;
import java.util.concurrent.ConcurrentSkipListSet;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

public class Task1 {
    public static void main(String[] args) {
        ConcurrentSkipListSet<String> concurrentSet = new ConcurrentSkipListSet<>();
        fill(concurrentSet);
        iteration(concurrentSet);
    }

    private static void iteration(ConcurrentSkipListSet<String> concurrentSet){
        AtomicInteger atomicInteger = new AtomicInteger(0);
        ExecutorService executorService = Executors.newFixedThreadPool(concurrentSet.size());

        for(String name : concurrentSet){
            executorService.submit(() -> {
                while(true) {
                    atomicInteger.incrementAndGet();
                    System.out.println("Работает " + name);
                    if(concurrentSet.contains(name)) {
                        concurrentSet.remove(name);
                        System.out.println(name + " удаление выполнил");
                    }
                    if(!concurrentSet.contains(name)) {
                        break;
                    }
                }
            });
        }

        executorService.shutdown();

        try {
            if (!executorService.awaitTermination(60,
                    java.util.concurrent.TimeUnit.SECONDS)) {
                executorService.shutdownNow();
            }
        } catch (InterruptedException e) {
            executorService.shutdownNow();
            Thread.currentThread().interrupt();
        }
        System.out.println("Количество итераций потоков: " + atomicInteger);
    }

    private static void fill(ConcurrentSkipListSet<String> concurrentSet){
        String CHARACTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
        Random random = new Random();

        for(int i = 0; i < 32; i++){
            StringBuilder stringBuilder = new StringBuilder(5);
            for(int j = 0; j < 5; j++){
                int index = random.nextInt(CHARACTERS.length());
                stringBuilder.append(CHARACTERS.charAt(index));
            }
            concurrentSet.add(stringBuilder.toString());
        }
    }
}
