import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    List<List<Integer>> result = new ArrayList<>();
    List<Integer> currentSubset = new ArrayList<>();
    int[] nums;

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums); // Sort to handle duplicates easily
        this.nums = nums;
        backtrack(0);
        return result;
    }

    private void backtrack(int start) {
        result.add(new ArrayList<>(currentSubset)); // Add the current subset to the result

        for (int i = start; i < nums.length; i++) {
            // Skip duplicates: if the current element is the same as the previous one
            // and we are not at the beginning of the current recursive call (i > start),
            // then skip it to avoid duplicate subsets.
            if (i > start && nums[i] == nums[i - 1]) {
                continue;
            }

            currentSubset.add(nums[i]); // Include the current element
            backtrack(i + 1);          // Explore further with the next element
            currentSubset.remove(currentSubset.size() - 1); // Backtrack: remove the last added element
        }
    }
}