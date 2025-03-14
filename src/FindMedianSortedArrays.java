import java.util.Arrays;

public class FindMedianSortedArrays {
    public static void main(String[] args) {
        int[] nums1 = {1,2};
        int[] nums2 = {3,4};
        double result = findMedianSortedArrays(nums1, nums2);
        System.out.println("Median of the two arrays is: " + result);
    }

    public static double findMedianSortedArrays(int[] num1, int[] num2) {
        double median = 0;
        int length = num1.length + num2.length;
        Arrays.sort(num1);
        Arrays.sort(num2);
        if (num1.length > (length/2)) {
            median = (num1[num1.length-1] + num1[num1.length-2])/2;
        } else if (num2.length > (length/2)) {
            median = (num2[num2.length-1] + num2[num2.length-2])/2;
        } else {
            int[] result = new int[num1.length + num2.length];
            // merge the two sorted arrays and save result in result array
            for (int i =0, j=0, k=0; i<num1.length || j<num2.length;) {
                if ( i < num1.length && j < num2.length) {
                    if (num1[i] < num2[j]) {
                        result[k++] = num1[i];
                        i++;
                    } else {
                        result[k++] = num2[j];
                        j++;
                    }
                } else if (i < num1.length) {
                    result[i+j] = num1[i];
                    i++;
                } else {
                    result[i+j] = num2[j];
                    j++;
                }
            }
            length = result.length;
            median = (result[length/2] + result[(int) Math.floor((length-1)/2)])/2.0;
        }
        return median;
    }
}
