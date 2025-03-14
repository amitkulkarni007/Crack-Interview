import java.util.Arrays;

public class TwoSum {
    public static void main(String[] args) {
        int[] nums = {2,7,11,15};
        int target = 9;
        int[] result = twoSum(nums, target);
        System.out.println("[" + result[0] + ", " + result[1] + "]");
    }

    public static int[] twoSum(int[] input, int target) {
        int[] result = new int[2];
        int diff;
        for (int i = 0; i < input.length; i++) {
            diff = target - input[i];
            for (int j = i + 1; j < input.length; j++) {
                if (input[j] == diff) {
                    result[0] = i;
                    result[1] = j;
                    break;
                }
            }
        }
        return result;
    }
}
