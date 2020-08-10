package main.java;

import java.util.*;
import java.util.stream.Collectors;

public class Analyzer {
    private final int ROW = 600;
    private final int COL = 400;

    boolean[][] visited = new boolean[ROW][COL];

    private void markBarrenLand(int[] boundaries) {
        int x1 = ROW - 1 - boundaries[1];
        int y1 = boundaries[0];
        int x2 = ROW - 1 - boundaries[3];
        int y2 = boundaries[2];

        for (int i = x1; i >= x2; i--) {
            for (int j = y1; j <= y2; j++) {
                visited[i][j] = true;
            }
        }
    }

    private int processFertileLand(int i, int j) {
        int area = 0;
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{i, j});

        while (!queue.isEmpty()) {
            int[] point = queue.poll();
            int x = point[0];
            int y = point[1];

            if (visited[x][y]) {
                continue;
            }

            visited[x][y] = true;
            area++;

            // Go left
            int newY = y - 1;
            if (newY >= 0 && !visited[x][newY]) {
                queue.offer(new int[]{x, newY});
            }

            // Go right
            newY = y + 1;
            if (newY < visited[0].length && !visited[x][newY]) {
                queue.offer(new int[]{x, newY});
            }

            // Go top
            int newX = x - 1;
            if (newX >= 0 && !visited[newX][y]) {
                queue.offer(new int[] {newX, y});
            }

            // Go bottom
            newX = point[0] + 1;
            if (newX < visited.length && !visited[newX][y]) {
                queue.offer(new int[] {newX, y});
            }
        }

        return area;
    }

    private void resetLandAndVisited() {
        visited = new boolean[ROW][COL];
    }

    public String getArea(int[][] barrenLands) {
        resetLandAndVisited();

        for (int[] barrenLand : barrenLands) {
            markBarrenLand(barrenLand);
        }

        List<Integer> areas = new ArrayList<>();
        for (int i = 0 ; i < visited.length; i++) {
            for (int j = 0; j < visited[0].length; j++) {
                if (!visited[i][j]) {
                    areas.add(processFertileLand(i, j));
                }
            }
        }

        if (areas.size() == 0) {
            return "ERROR: All barren land";
        }

        Collections.sort(areas);

        return areas.stream().map(String::valueOf).collect(Collectors.joining(" "));
    }
}