public class BinarySearch {

    public static void main(String[] args) {
        int[] arr = new int[]{5};

        System.out.println(search(arr, 5));
    }

    public static int search(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;


        int index = -1;

        while (low <= high) {
            int mid = (low + high) / 2;
            if (nums[mid] < target) {
                low = mid + 1;
            } else if (nums[mid] > target) {
                high = mid - 1;
            } else if (nums[mid] == target) {
                index = mid;
                break;
            }
        }
        return index;

    }
}
