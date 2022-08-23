import java.util.Arrays;
import java.util.Random;

class Skiplist {

    static final double P_FACTOR = 0.25;
    static final int MAX_LEVEL = 32;

    int level;
    SkiplistNode head;
    Random random;

    public Skiplist() {
        this.random = new Random();
        this.head = new SkiplistNode(-1, MAX_LEVEL);
        this.level = 1;
    }

    public boolean search(int target) {
        SkiplistNode curr = this.head;
        for (int i = level - 1; i >= 0; i--) {
             while (curr.forward[i] != null && curr.forward[i].val < target) {
                curr = curr.forward[i];
            }
        }
        curr = curr.forward[0];
         if (curr != null && curr.val == target) {
            return true;
        }
        return false;
    }

    public void add(int num) {
        int lv = randomLevel();
        level = Math.max(level, lv);

        SkiplistNode[] update = new SkiplistNode[level];
        Arrays.fill(update, head);

        SkiplistNode curr = this.head;
        for (int i = level - 1; i >= 0; i--) {
             while (curr.forward[i] != null && curr.forward[i].val < num) {
                curr = curr.forward[i];
            }
            update[i] = curr;
        }

        SkiplistNode newNode = new SkiplistNode(num, lv);
        for (int i = 0; i < lv; i++) {
             newNode.forward[i] = update[i].forward[i];
            update[i].forward[i] = newNode;
        }

    }

    public boolean erase(int num) {

        SkiplistNode[] update = new SkiplistNode[level];
        Arrays.fill(update, head);

        SkiplistNode curr = this.head;
        for (int i = level - 1; i >= 0; i--) {
            while (curr.forward[i] != null && curr.forward[i].val < num) {
                curr = curr.forward[i];
            }
            update[i] = curr;
        }
        curr = curr.forward[0];
        if (curr == null || curr.val != num) return false;

        for (int i = 0; i < level; i++) {
            if (update[i].forward[i] != curr) {
                break;
            }
             update[i].forward[i] = curr.forward[i];
        }

        while (level > 1 && head.forward[level - 1] == null) {
            level--;
        }
        return true;
    }

    class SkiplistNode {
        int val;
        SkiplistNode pre;
        SkiplistNode[] forward;

        public SkiplistNode(int val, int level) {
            this.val = val;
            this.forward = new SkiplistNode[level];
        }


    }

    int randomLevel() {
        int lv = 1;
        while (random.nextDouble() < P_FACTOR && lv < MAX_LEVEL) {
            lv++;
        }
        return lv;
    }

}
