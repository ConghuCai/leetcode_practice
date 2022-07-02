package site.conghucai.api;

import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

// Dijkstra单源最短路径
public class Dijkstra {

  public int[] dijkstra(int start, List<int[]>[] graph) {
    int V = graph.length; // 节点数
    int[] distTo = new int[V];
    Arrays.fill(distTo, Integer.MAX_VALUE);
    distTo[start] = 0;

    Queue<int[]> pq = new PriorityQueue<>((a, b) -> {
      return a[1] - b[1]; // [0]代表编号 [1]代表距离原点距离
    });

    pq.offer(new int[] { start, 0 });

    // 算法部分
    while (!pq.isEmpty()) {
      int[] curVex = pq.poll();
      int curId = curVex[0], curDist = curVex[1];

      if (curDist > distTo[curId]) { // 已经记录比curId还要短的距离 这是一个重复的节点 忽略
        continue;
      }

      // 检查节点邻接节点
      for (int[] adj : graph[curId]) {
        int nextId = adj[0], weight = adj[1];
        int distToNext = weight + distTo[curId]; // 检查源节点经由当前节点 到下一节点 能否找到更短路径

        if (distToNext < distTo[nextId]) { // 发现更短路径
          distTo[nextId] = distToNext;
          pq.offer(new int[] { nextId, distToNext }); // 这里发现短的就直接入队，有可能后面发现更短的，这个节点就重复入队了

          // 1. 因此之后，出队的时候要检查节点是否>distTo[]表中的最小距离 如果>则说明这是重复入队的节点，忽略掉
          // 2. 不用担心BFS会重复访问造成死循环 因为只有“发现更短路径”才会入队，最短路径是固定的不会无限减少，因此队列迟早为空。
        }
      }
    }

    return distTo;
  }

  // 求单源到某一个点的最小距离
  public int dijkstra(int start, int dest, List<int[]>[] graph) {
    int V = graph.length;
    int[] distTo = new int[V];
    Arrays.fill(distTo, Integer.MAX_VALUE);
    distTo[start] = 0;

    Queue<int[]> pq = new PriorityQueue<>((a, b) -> {
      return a[1] - b[1]; // [0]代表编号 [1]代表距离原点距离
    });
    pq.offer(new int[] { start, 0 });

    while (!pq.isEmpty()) {
      int[] curVex = pq.poll();
      int curId = curVex[0], curDist = curVex[1];

      // 相比求单源到所有点的最短路径 只需要加这一部分
      // 因为使用的是小根堆 因此就算有重复节点，较短的dist也一定会率先出队，因此不用写在后面
      if (curId == dest) {
        return curDist;
      }

      if (curDist > distTo[curId]) {
        continue; // 忽略重复节点
      }

      for (int[] adjVex : graph[curId]) {
        int nextId = adjVex[0], curToNextDist = adjVex[1];
        int distToNext = curToNextDist + distTo[curId];

        if (distToNext < distTo[nextId]) {
          distTo[nextId] = distToNext;
          pq.offer(new int[] { nextId, distToNext });
        }

      }
    }

    return 0;
  }

}
