import java.util.*;

class Solution {
    // Find the median in each sliding window of size k
    //
    // For example, for k = 3
    // Input : [1, 3, -1, -3, 5, 3, 6, 7]
    // 1 3 -1 => [-1, 1, 3] => 1
    //   3 -1 -3 => [-3, -1, 3] => -1
    //     -1 -3 5 => [-3, -1, 5] => -1
    //        -3 5 3 => [-3, 3, 5] => 3
    //           5 3 6 => [3, 5, 6] => 5
    //             3 6 7 => [3, 6, 7] => 6
    // Output : [1, -1, -1, 3, 5, 6]
    //
    // Time : O(n - k + 1) * O(k * logk) ~ O(n * k * log k)
    // Space : O(k)
    public static double[] medianSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k <= 0) {
            return new double[0];
        }

        int size = nums.length;
        if (k >= size) {
            return new double[] {findMedian(nums)};
        }

        double[] answer = new double[size - k + 1];
        int[] temp = new int[k];
        for (int i = 0; i < size; i++) {
            temp[i % k] = nums[i];
            if (i >= k - 1) {
                answer[i - k + 1] = findMedian(temp);
            }
        }

        return answer;
    }

    private static double findMedian(int[] nums) {
        int[] copy = nums.clone();
        Arrays.sort(copy);

        int middle = copy.length / 2;
        return copy.length % 2 != 0
                ? (double) copy[middle]
                : ((double) (copy[middle - 1]) + (double) (copy[middle])) / 2
                ;
    }
}
