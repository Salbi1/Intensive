package khutyz.block2;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ForkJoinPool;

public class Task2 {
    public static void main(String[] args) {
        ForkJoinPool pool = new ForkJoinPool();

        List<Integer> list = new ArrayList<>();
        list.add(4);
        list.add(5);
        list.add(6);
        list.add(7);
        list.add(9);
        list.add(1);
        list.add(3);

        CompletableFuture<Long> comp = CompletableFuture.supplyAsync(() -> {
            return list.stream().parallel()
                    .filter(e -> e % 2 == 0).count();
        });

        CompletableFuture<Long> comp2 = CompletableFuture.supplyAsync(() -> {
            return list.stream().parallel()
                    .filter(e -> e % 3 == 0).count();
        }, pool);

        CompletableFuture result = comp.thenCombine(comp2, (e1, e2) -> {
            return e1 + e2;
        }).thenAccept(r -> {
            System.out.println("result = " + r);
        });

        result.join();
    }
}
