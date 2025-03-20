package khutyz.block1;

import java.util.List;

public class Task4 {
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
