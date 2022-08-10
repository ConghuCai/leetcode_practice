package site.conghucai.leetcode.problem.hard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

// 218. 天际线问题
// 城市的 天际线 是从远处观看该城市中所有建筑物形成的轮廓的外部轮廓。给你所有建筑物的位置和高度，请返回 由这些建筑物形成的 天际线 。

// 每个建筑物的几何信息由数组 buildings 表示，其中三元组 buildings[i] = [lefti, righti, heighti] 表示：

// lefti 是第 i 座建筑物左边缘的 x 坐标。
// righti 是第 i 座建筑物右边缘的 x 坐标。
// heighti 是第 i 座建筑物的高度。
// 你可以假设所有的建筑都是完美的长方形，在高度为 0 的绝对平坦的表面上。

// 天际线 应该表示为由 “关键点” 组成的列表，格式 [[x1,y1],[x2,y2],...] ，并按 x 坐标 进行 排序 。关键点是水平线段的左端点。
// 列表中最后一个点是最右侧建筑物的终点，y 坐标始终为 0 ，仅用于标记天际线的终点。此外，任何两个相邻建筑物之间的地面都应被视为天际线轮廓的一部分。

// 注意：输出天际线中不得有连续的相同高度的水平线。例如 [...[2 3], [4 5], [7 5], [11 5], [12 7]...] 是不正确的答案；
// 三条高度为 5 的线应该在最终输出中合并为一个：[...[2 3], [4 5], [12 7], ...]

// 示例 1：
// 输入：buildings = [[2,9,10],[3,7,15],[5,12,12],[15,20,10],[19,24,8]]
// 输出：[[2,10],[3,15],[7,12],[12,0],[15,10],[20,8],[24,0]]

// 示例 2：
// 输入：buildings = [[0,2,3],[2,5,3]]
// 输出：[[0,3],[5,0]]

// 思路：对于要输出的每个关键点，其横坐标一定符合要求：横坐标x是建筑的边缘横坐标，x要找到leftX <= x < rightX的建筑，这些建筑的最大高度即为x的纵坐标。
// 如果没有找到的这样的建筑，说明这个x肯定是建筑的右边缘坐标，纵坐标直接视为0即可。
// 需要注意的是，这个最高高度找出来之后，有可能和前面的高度是重的，需要去重。

// 因此解决方法：对于每个边界横坐标x，寻找所有符合leftX <= x < rightX的建筑，取这些建筑的最高高度（如果不存在这样的建筑高度为0），作为x的纵坐标。
// 注意可能找到和之前重复的纵坐标，注意去重。
public class S218_SyklineProblem {
    // buildings had been sorted by left side position.
    // O n*logn的方法：增加一个堆，使得每次可以不用遍历所有建筑，也能第一时间得到 符合关键点要求 的最高建筑高度
    public List<List<Integer>> getSkyline(int[][] buildings) {
        int n = buildings.length;
        int[] sides = new int[2 * n];
        int nSides = sides.length;

        for (int i = 0; i < nSides; i += 2) {
            sides[i] = buildings[i / 2][0];
            sides[i + 1] = buildings[i / 2][1];
        }
        Arrays.sort(sides);

        Queue<int[]> pq = new PriorityQueue<>(n, (a, b) -> b[2] - a[2]);

        List<List<Integer>> ans = new ArrayList<>();

        int index = 0;
        for (int i = 0; i < nSides; i++) {
            int sidePos = sides[i];
            // System.out.println(sidePos);

            // 由于buildings已经按照左边界的横坐标排过序了 直接按顺序检查每个建筑是否符合sidePos要求即可。
            while (index < n && buildings[index][0] <= sidePos && buildings[index][1] > sidePos) {
                pq.offer(buildings[index]);
                index++;
            }

            // 堆里可能包含 不符合要求、还没出堆的建筑，发现堆顶不符合要求，则出堆。
            while (!pq.isEmpty() && (pq.peek()[0] > sidePos || pq.peek()[1] <= sidePos)) {
                pq.poll();
            }

            int maxHeight = pq.isEmpty() ? 0 : pq.peek()[2]; // 现在取出的肯定是符合要求的、高度最高的建筑。

            if (ans.isEmpty() || maxHeight != ans.get(ans.size() - 1).get(1)) { // 注意去重
                List<Integer> point = Arrays.asList(sidePos, maxHeight);
                ans.add(point);
            }
        }

        return ans;
    }

    // //On^2的解决方法
    // public List<List<Integer>> getSkyline(int[][] buildings) {
    // int n = buildings.length;
    // int[] sides = new int[2 * n];
    // int nSides = sides.length;

    // for (int i = 0; i < nSides; i += 2) {
    // sides[i] = buildings[i / 2][0];
    // sides[i + 1] = buildings[i / 2][1];
    // }
    // Arrays.sort(sides); //按照横坐标顺序 遍历每一个建筑边界

    // List<List<Integer>> ans = new ArrayList<>();

    // for (int i = 0; i < nSides; i++) {
    // int sidePos = sides[i];

    // int maxHeight = 0; //遍历所有符合要求的建筑 求最大高度 即为此关键点的纵坐标
    // for (int j = 0; j < n; j++) {
    // if (buildings[j][0] <= sidePos && buildings[j][1] > sidePos) {
    // //要求：此边缘的横坐标，落在建筑的左右边缘横坐标范围内，左闭右开，因为右边界并不会决定高度
    // maxHeight = Math.max(maxHeight, buildings[j][2]);
    // }
    // }
    // //这里是为了跳过前面高度相同的关键点坐标。高度相同，由于是按照横坐标顺序遍历，前面的坐标的横坐标一定更靠左。
    // if (ans.isEmpty() || maxHeight != ans.get(ans.size() - 1).get(1)) {
    // List<Integer> point = Arrays.asList(sidePos, maxHeight);
    // ans.add(point);
    // }
    // }

    // return ans;
    // }
}
