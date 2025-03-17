package khutyz.block1;

import java.util.Comparator;
import java.util.List;

public class Task4 {
    public static int getMaxElementOne(List<Integer> list) {
        List<Integer> result = list.stream()
                .sorted(Comparator.reverseOrder())
                .limit(1)
                .toList();
        return result.get(0);
    }

    public static int getMaxElementTwo(List<Integer> list) {
        int max = 0;
        for(Integer elem : list){
            if(max < elem) {
                max = elem;
            }
        }

        return max;
    }
}
