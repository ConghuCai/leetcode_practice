package site.conghucai.leetcode.problem.middle;

// 33. 搜索旋转排序数组
// 整数数组 nums 按升序排列，数组中的值 互不相同 。

// 在传递给函数之前，nums 在预先未知的某个下标 k（0 <= k < nums.length）上进行了 旋转，
// 使数组变为 [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]]（下标 从 0 开始 计数）。
// 例如， [0,1,2,4,5,6,7] 在下标 3 处经旋转后可能变为 [4,5,6,7,0,1,2] 。

// 给你 旋转后 的数组 nums 和一个整数 target ，如果 nums 中存在这个目标值 target ，则返回它的下标，否则返回 -1 。

// 你必须设计一个时间复杂度为 O(log n) 的算法解决此问题。
public class Solution33 {
    public int search(int[] nums, int target) {
        // 对于这种中间点逆转的数组，l、r、m只会存在3种情况：
        // 1. l < m < r 有序的，直接二分查找即可
        // 2. l > r > m 逆转点在l和m之间
        // 3. m > l > r 逆转点在m和r之间

        int n = nums.length;
        int low = 0, high = n - 1;
        int mid;

        while (low <= high) {
            mid = (low + high) / 2;

            if (nums[mid] == target) {
                return mid;
            }

            if (nums[low] < nums[high]) { // 有序的，情况1
                if (nums[mid] > target) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }

            } else if (nums[low] > nums[high]) { // 逆转点在中间
                if (nums[mid] < nums[high]) { // 情况2
                    if (target <= nums[mid] || target >= nums[low]) {
                        high = mid - 1;
                    } else {
                        low = mid + 1;
                    }

                } else if (nums[mid] > nums[low]) { // 情况3
                    if (target >= nums[mid] || target <= nums[high]) {
                        low = mid + 1;
                    } else {
                        high = mid - 1;
                    }

                } else { // 特殊情况处理：进入到这里说明nums[mid] = nums[low] or nums[high]
                         // 只剩下两个数了，其中low未命中，一定不是，那只能进一步判断high了
                    low = mid + 1;
                }

            } else { // 特殊情况处理：进入到这里说明nums[low] == nums[high]，但是题目明确数字互不相同，因此low =
                     // high，target未命中，说明不存在
                return -1;
            }
        }

        return -1;
    }
}
