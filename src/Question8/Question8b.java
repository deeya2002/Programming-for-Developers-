package Question8;
//Question 8 b)
public class Question8b {

    // This method finds the kth missing even number in the given array nums
    public static int findKthMissingEvenNumber(int[] nums, int k) {
        int n = nums.length;

        // Calculate the total number of missing even numbers between nums[0] and nums[n-1]
        int missingCount = (nums[n-1] - nums[0] + 2) / 2 - n;

        // If k is greater than the total number of missing even numbers, then the kth missing even number
        // is simply the last even number in the range plus 2 times the number of additional missing even numbers
        // beyond the end of the array
        if (k > missingCount) {
            return nums[n-1] + 2 * (k - missingCount);
        }

        // Perform binary search to find the index of the kth missing even number in the array
        int left = 0, right = n - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            int missing = (nums[mid] - nums[0]) / 2 - mid;

            // If the number of missing even numbers to the left of mid is greater than or equal to k, then
            // the kth missing even number must be in the left half of the array
            if (missing >= k) {
                right = mid;
            } else {
                // Otherwise, subtract the number of missing even numbers to the left of mid from k and
                // search in the right half of the array
                k -= missing;
                left = mid + 1;
            }
        }

        // Once the index of the kth missing even number is found, compute and return the value of the kth missing even number
        return nums[left-1] + 2 * k;
    }

    public static void main(String[] args) {
        // Example usage
        System.out.println(findKthMissingEvenNumber(new int[]{0,2,6,18,22},6));
    }
}

