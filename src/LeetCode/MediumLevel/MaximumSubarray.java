package LeetCode.MediumLevel;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/*Given an integer array nums, find the subarray
 with the largest sum, and return its sum.*/
public class MaximumSubarray {
    public static void main(String[] args) {

        try {
            File file = new File("C:\\Users\\iwant\\OneDrive\\Рабочий стол\\integers.txt");
            Scanner scanner = new Scanner(file);
            List<Integer> list = new ArrayList<>();
            while (scanner.hasNextInt()){
                list.add(scanner.nextInt());
            }
            scanner.close();

            int[] array = new int[list.size()];
            long start1 = System.currentTimeMillis();
            for (int i = 0; i < list.size(); i++) {
                array[i] = list.get(i);
            }
            long end1 = System.currentTimeMillis();
            System.out.println("Array was copied in: " + (end1-start1));

            long start = System.currentTimeMillis();
            System.out.print("Maximum subarrays: " + maxSubArray(array)); //11081
            System.out.print(", " + maxSubArray(new int[]{-2,-1}));//-1
            System.out.print(", " + maxSubArray(new int[]{-1,1}));//1
            System.out.print (", " + maxSubArray(new int[]{1}));//1
            long end= System.currentTimeMillis();
            System.out.println("Max subarray was found in: " + (end-start));

            System.out.println(array.length);

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public static int maxSubArray(int[] nums) {
        if(nums.length==1) return nums[0];
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i; j < nums.length; j++) {
                int currentMax = Arrays.stream(Arrays.copyOfRange(nums, i, j+1)).sum();
                if (currentMax > max) {
                    max = currentMax;
                }
            }
        }
        return max;
    }
}
