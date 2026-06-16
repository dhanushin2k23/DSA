class Solution {
    public int maxArea(int[] height) {
        int max = 0;
        int count = 0;
        int left = 0;
        int right = height.length - 1;

        while (left < right) {
            if (height[left] < height[right]) {
                count = (right - left) * height[left];
                left++;
            } else if (height[left] > height[right]) {
                count = (right - left) * height[right];
                right--;
            } else if (height[left] == height[right]) {
                count = (right - left) * height[right];
                left++;
                right--;
            }

            if (count > max) {
                max = count;
            }
        }
        return max;
    }
}