package com.pjurczen;

import java.util.HashSet;
import java.util.LinkedList;

class TheMaze {

    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        var queue = new LinkedList<Node>();
        var visited = new HashSet<Node>();
        queue.add(new Node(start[0], start[1], 0));
        while (!queue.isEmpty()) {
            var cur = queue.poll();
            if (cur.row == destination[0] && cur.column == destination[1] && cur.direction == 0) {
                return true;
            }
            if (visited.contains(cur)) {
                continue;
            }
            // 1=left, 2=right, 3=up, 4=down
            var direction = cur.direction;
            if (Math.min(cur.row, cur.column) < 0
                    || cur.row == maze.length
                    || cur.column == maze[0].length
                    || maze[cur.row][cur.column] == 1) {
                if (direction == 4) {
                    queue.add(new Node(cur.row - 1, cur.column, 0));
                }
                if (direction == 3) {
                    queue.add(new Node(cur.row + 1, cur.column, 0));
                }
                if (direction == 2) {
                    queue.add(new Node(cur.row, cur.column - 1, 0));
                }
                if (direction == 1) {
                    queue.add(new Node(cur.row, cur.column + 1, 0));
                }
                continue;
            }
            visited.add(cur);
            if (direction == 0 || direction == 4) {
                queue.add(new Node(cur.row + 1, cur.column, 4));
            }
            if (direction == 0 || direction == 3) {
                queue.add(new Node(cur.row - 1, cur.column, 3));
            }
            if (direction == 0 || direction == 2) {
                queue.add(new Node(cur.row, cur.column + 1, 2));
            }
            if (direction == 0 || direction == 1) {
                queue.add(new Node(cur.row, cur.column - 1, 1));
            }
        }
        return false;
    }


    static class Node {
        public int row;
        public int column;
        public int direction;

        public Node(int row, int column, int direction) {
            this.row = row;
            this.column = column;
            this.direction = direction;
        }

        @Override
        public int hashCode() {
            return row + column + direction;
        }

        @Override
        public boolean equals(Object obj) {
            if (obj == null) {
                return false;
            }
            var other = (Node) obj;
            return other.row == this.row && other.column == this.column && other.direction == this.direction;
        }

        @Override
        public String toString() {
            return "Node[row=" + row + ", column=" + column + ", direction=" + direction + "]";
        }
    }
}