
public class BSTIterator {
    int positionForAdd = 0;
    int positionForIterator = 0;
    /*
    Количество узлов в дереве находится в диапазоне [1, 10*5].
    0 = Node.val = 106
    Будет сделано не более 105 вызовов hasNext и next.
    то есть Я ожидаю что элементов в массиве не может быть больше 10 в 5 степене ??
     */
    int[] arr = new int[100000];

    public BSTIterator(TreeNode root) {
        addOrderTreeInArrays(root);
    }

    public void addOrderTreeInArrays(TreeNode root) {
        if (root == null) return;
        addOrderTreeInArrays(root.left); // с начало бежим по левой части
        arr[positionForAdd++] = root.val;  // когда пробежаи по левой части то добаляем корень и бежим по правой
        addOrderTreeInArrays(root.right); // когда пробежали по левой части бежим по правой
        // то есть в итоге мы получаем отсортированный массив значений с дерева
    }

    public int next() {
        return arr[positionForIterator++];
    }

    public boolean hasNext() {

        return positionForIterator < positionForAdd;
    }

//    public class TreeNode {
//        int val;
//        TreeNode left;
//        TreeNode right;
//
//        TreeNode() {
//        }
//
//        TreeNode(int val) {
//            this.val = val;
//        }
//
//        TreeNode(int val, TreeNode left, TreeNode right) {
//            this.val = val;
//            this.left = left;
//            this.right = right;
//        }
//    }
}

/*
Пример 1:

Input
["BSTIterator", "next", "next", "hasNext", "next", "hasNext", "next", "hasNext", "next", "hasNext"]
[[[7, 3, 15, null, null, 9, 20]], [], [], [], [], [], [], [], [], []]
Output
[null, 3, 7, true, 9, true, 15, true, 20, false]

Объяснение
BSTIterator bSTIterator = новый BSTIterator([7, 3, 15, null, null, 9, 20]);
bSTIterator.next(); // вернуть 3
bSTIterator.next(); // вернуть 7
bSTIterator.hasNext(); // вернуть true
bSTIterator.next(); // вернуть 9
bSTIterator.hasNext(); // вернуть true
bSTIterator.next(); // вернуть 15
bSTIterator.hasNext(); // вернуть true
bSTIterator.next(); // вернуть 20
bSTIterator.hasNext(); // вернуть false
 */

