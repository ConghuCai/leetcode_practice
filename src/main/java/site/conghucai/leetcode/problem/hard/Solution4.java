package site.conghucai.leetcode.problem.hard;

// 4. 寻找两个正序数组的中位数
// 给定两个大小分别为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。请你找出并返回这两个正序数组的 中位数 。

// 算法的时间复杂度应该为 O(log (m+n)) 。

// 思路：该问题应转换为：两个有序数组中，查找合并后第K个大的数。
// 利用二分法，分别去两个数组中查找第k/2大的数。理论来说，两个数组中第k/2大的数，相比较小的那个数组，前k/2个数一定不在寻找范围内，可以直接排除。
// 就沿着这样的思路，每次通过比较前k/2大的数，排除掉一个数组的前k/2的数，然后再递归查找两个数组中第k-k/2大的数。
// 因为一个数组的k/2个数已经被排除掉了。

// 需要格外注意的就是边界问题。如果一个数组A长度不足k/2，那么也就是说，另一个数组B长度一定大于k/2，也就是说B中第K/2个数一定不是合并后的第K个数。
// 因为在B中都有数比B[k/2]大。B中的前k/2个数就可以排除了。
public class Solution4 {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n1 = nums1.length, n2 = nums2.length;
        return (findKthNumber(nums1, 0, nums2, 0, (n1 + n2 - 1) / 2 + 1)
                + findKthNumber(nums1, 0, nums2, 0, (n1 + n2) / 2 + 1)) / 2.0;
    }

    private int findKthNumber(int[] nums1, int i, int[] nums2, int j, int k) {
        int n1 = nums1.length, n2 = nums2.length;
        if (i >= n1 || j >= n2) {
            return i >= n1 ? nums2[j + k - 1] : nums1[i + k - 1];
        }
        if (k == 1) {
            return Math.min(nums1[i], nums2[j]);
        }

        int v1 = i + k / 2 - 1 < n1 ? nums1[i + k / 2 - 1] : Integer.MAX_VALUE;
        int v2 = j + k / 2 - 1 < n2 ? nums2[j + k / 2 - 1] : Integer.MAX_VALUE;

        return v1 < v2 ? findKthNumber(nums1, i + k / 2, nums2, j, k - k / 2)
                : findKthNumber(nums1, i, nums2, j + k / 2, k - k / 2);
    }
}
