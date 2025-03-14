public class MostWaterContainer {
    public static void main(String[] args) {
        int[] height = {1,8,6,2,5,4,8,3,7};
        int result = maxArea(height);
        System.out.println("Max area of water container is: " + result);
    }

    private static int maxArea(int[] height) {
        int max = 0;
        int left = 0;
        int right = height.length - 1;
        while (left < right) {
            int area = Math.min(height[left], height[right]) * (right - left);
            max = Math.max(max, area);
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }
        return max;
    }


//    public static int maxArea(int[] arr) {
//        int [][] res = new int[arr.length][arr.length];
//        int max = -1;
//
//        for (int i = 0; i < arr.length; i++) {
//            for (int j = 0; j < arr.length - i - 1; j++) {
//                res[i][j] = Math.min(arr[j], arr[j+i+1]) * (i+1);
//                max = Math.max(max, res[i][j]);
//            }
//        }
//        // print res
//        for (int i = 0; i < arr.length; i++) {
//            for (int j = 0; j < arr.length; j++) {
//                System.out.print(res[i][j] + " ");
//            }
//            System.out.println();
//        }
//
//        return max;
//    }
}
