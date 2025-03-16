import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSumToZero {
    public static void main(String args[]) {
        int[] nums = {-1,0,1,2,-1,-4};
        threeSum(nums);
    }

    public static void printList(List<List<Integer>> list) {
        for (List<Integer> arr : list) {
            for (int num : arr) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }

    public static void threeSum(int[] nums) {
        List<List<Integer>> listOfArrays = new ArrayList<>();
        Arrays.sort(nums);
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            if (i > 0 && nums[i] == nums[i-1]) {
                continue;
            }
            int j = i + 1;
            int k = n - 1;
            while (j < k) {
                int sum = nums[i] + nums[j] + nums[k];
                if (sum == 0) {
                    List<Integer> temp = new ArrayList<>();
                    temp.add(nums[i]);
                    temp.add(nums[j]);
                    temp.add(nums[k]);
                    listOfArrays.add(temp);
                    j++;
                    k--;
                    while (j < k && nums[j] == nums[j-1]) {
                        j++;
                    }
                    while (j < k && nums[k] == nums[k+1]) {
                        k--;
                    }
                } else if (sum < 0) {
                    j++;
                } else {
                    k--;
                }
            }
        }
        printList(listOfArrays);
    }
}