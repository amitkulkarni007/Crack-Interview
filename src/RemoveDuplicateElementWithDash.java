import java.util.Hashtable;

public class RemoveDuplicateElementWithDash {
    public static void main(String[] args){
        int[] nums = {1, 2, 3, 1, 5, 2, 6};
        int len = findAndReplaceDuplicate(nums);
        System.out.println();
        System.out.println("Length of array after removing duplicates: " + len);
    }

    private static int findAndReplaceDuplicate(int[] nums) {
        int n = nums.length;
        int expectednums[] = new int[n];

        Hashtable<Object, Object> ht = new Hashtable<>();
        for (int i = 0, k=0; i < n; i++) {
            if (ht.containsKey(nums[i])) {
                continue;
            } else {
                expectednums[k++] = nums[i];
                ht.put(nums[i], 1);
            }
        }
        //print all elements of ht
        for (Object key : ht.keySet()) {
            System.out.print(" "+key);
        }

        return ht.size();
    }
}
