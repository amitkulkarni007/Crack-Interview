import java.util.Arrays;

public class FarmerLand {
    public static void main(String[] args) {
        // 2 dimensional array declaration
        int[][] land = new int[10][10];
        // initialize the array with random values 0 or 1
        for (int i = 0; i < land.length; i++) {
            for (int j = 0; j < land[i].length; j++) {
                land[i][j] = (int) (Math.random() * 2);
            }
        }
        // print this array
        System.out.println("Land array I/P:");
        printArray(land);
        int max_area = max_area(land);
        if (max_area > 0)
            System.out.println( "Max length of square will be " + max_area + " X " + max_area);
    }

    //method for max area of land
    public static int max_area(int[][] land) {

        int[][] result;
        int max = -1;

        result = getDefaultResultArray(land);
        // iterate over the land array and calculate the result array
        for (int i = 0; i < land.length; i++) {
            for (int j = 0; j < land[i].length; j++) {
                if (land[i][j] == 0)
                    continue;
                if (j - 1 >= 0 && land[i][j - 1] > 0) {
                    if (i - 1 >= 0 && land[i - 1][j] > 0) {
                        if (land[i - 1][j - 1] > 0) {
                            result[i][j] = Math.min(land[i][j - 1], Math.min(land[i - 1][j], land[i - 1][j - 1])) + 1;
                            max = Math.max(max, result[i][j]);
                        }
                    }
                } else {
                    result[i][j] = 1;
                }
            }
        }

        //print the result
        System.out.println("Land array O/P:");
        printArray(result);
        return max;
    }

    private static int[][] getDefaultResultArray(int[][] land) {
        // define a array to of same size of input array to store the result initially filled with 0
        int[][] result = new int[land.length][land[0].length];
        for (int i = 0; i < result.length; i++) {
            Arrays.fill(result[i], 0);
        }
        return result;
    }

    private static void printArray(int[][] result) {
        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < result[i].length; j++) {
                System.out.print(result[i][j] + " ");
            }
            System.out.println();
        }
    }
}
