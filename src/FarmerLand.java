import java.util.Arrays;

public class FarmerLand {
    public static void main(String[] args) {
        // 2 dimensional array declaration
        int[][] land = new int[5][5];
        // initialize the array with random values 0 or 1
        for (int i = 0; i < land.length; i++) {
            for (int j = 0; j < land[i].length; j++) {
                land[i][j] = (int) (Math.random() * 2);
            }
        }
        // print this array
        System.out.println("Land array I/P:");
        for (int i = 0; i < land.length; i++) {
            for (int j = 0; j < land[i].length; j++) {
                System.out.print(land[i][j] + " ");
            }
            System.out.println();
        }

        // define a array to of same size to store the result initially filled with 0
        int[][] result = new int[5][5];
        for (int i = 0; i < result.length; i++) {
            Arrays.fill(result[i], 0);
        }


        // iterate over the land array and calculate the result array
        for(int i=0; i< land.length;i++) {
            for (int j=0; j< land[i].length; j++) {
                if (land[i][j] == 0)
                    continue;
                if (j-1 >= 0 && land[i][j-1] > 0) {
                    if (i-1 >= 0 && land[i-1][j] > 0) {
                        if(land[i-1][j-1] > 0) {
                            result[i][j] = Math.min(land[i][j-1], Math.min(land[i-1][j], land[i-1][j-1])) + 1;
                        }
                    }
                } else {
                    result[i][j] = 1;
                }
            }
        }

        //print the result
        System.out.println("Land array O/P:");
        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < result[i].length; j++) {
                System.out.print(result[i][j] + " ");
            }
            System.out.println();
        }
    }

    //max area of land
    
}
