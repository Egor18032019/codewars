import java.util.ArrayList;
import java.util.List;
//  таки и не понял смысл этого задание на лит коде.
// или нельзя что ли было использовать ArrayList и List ?? только int[] ?
public class MyHashSet {


    //    private List<Integer>[] table = null;
    private List<Integer> table = null;

    public MyHashSet() {
        table = new ArrayList<>();
    }

    public void add(int key) {
        for (Integer point : table) {
            if (key == point) return;
        }
        table.add(key);
    }

    public void remove(int key) {
        int index = table.indexOf(key);
        if (index != -1) table.remove(index);
    }

    public boolean contains(int key) {
        return table.contains(key);
    }
}
