package khutyz.block1;

import java.util.List;

public class Task3 {
    public static List<Integer> duplicates(List<Integer> list){
        return list.stream()
                .distinct()
                .toList();
    }
}
