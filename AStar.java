/*2.  Implement A star Algorithm for any game search problem.*/

import java.util.*;

public class AStar {
    static final int N = 3;

    static class Node {
        Node parent;
        int[][] mat = new int[N][N];
        int x, y;
        int cost;
        int level;
    }

    static void printMatrix(int mat[][]) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++)
                System.out.print(mat[i][j] + " ");
            System.out.println();
        }
    }

    static Node newNode(int[][] mat, int x, int y, int newX, int newY, int level, Node parent) {
        Node node = new Node();
        node.parent = parent;
        for (int i = 0; i < N; i++)
            node.mat[i] = mat[i].clone();
        int temp = node.mat[x][y];
        node.mat[x][y] = node.mat[newX][newY];
        node.mat[newX][newY] = temp;
        node.cost = Integer.MAX_VALUE;
        node.level = level;
        node.x = newX;
        node.y = newY;
        return node;
    }

    static int calculateCost(int initial[][], int finalState[][]) {
        int count = 0;
        for (int i = 0; i < N; i++)
            for (int j = 0; j < N; j++)
                if (initial[i][j] != 0 && initial[i][j] != finalState[i][j])
                    count++;
        return count;
    }

    static boolean isSafe(int x, int y) {
        return (x >= 0 && x < N && y >= 0 && y < N);
    }

    static void printPath(Node root) {
        if (root == null)
            return;
        printPath(root.parent);
        printMatrix(root.mat);
        System.out.println("hscore:" + root.cost + "\ngscore:" + root.level + "\nfscore:" + (root.cost + root.level) + "\n");
    }

    static class comp implements Comparator<Node> {
        public int compare(Node lhs, Node rhs) {
            return Integer.compare((lhs.cost + lhs.level), (rhs.cost + rhs.level));
        }
    }

    static void solve(int initial[][], int x, int y, int finalState[][]) {
        PriorityQueue<Node> pq = new PriorityQueue<>(new comp());
        Node root = newNode(initial, x, y, x, y, 0, null);
        root.cost = calculateCost(initial, finalState);
        pq.add(root);
        while (!pq.isEmpty()) {
            Node min = pq.poll();
            if (min.cost == 0) {
                printPath(min);
                return;
            }
            for (int i = 0; i < 4; i++) {
                if (isSafe(min.x + row[i], min.y + col[i])) {
                    Node child = newNode(min.mat, min.x, min.y, min.x + row[i], min.y + col[i], min.level + 1, min);
                    child.cost = calculateCost(child.mat, finalState);
                    pq.add(child);
                }
            }
        }
    }

    static int row[] = {1, 0, -1, 0};
    static int col[] = {0, -1, 0, 1};

    public static void main(String[] args) {
        int[][] initial = new int[3][3];
        int x = 0, y = 0;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter Initial Block Structure");
        System.out.println("Enter 0 for blank space:");
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print("Row " + (i + 1) + " Column " + (j + 1) + " Element = ");
                initial[i][j] = scanner.nextInt();
                if (initial[i][j] == 0) {
                    x = i;
                    y = j;
                }
            }
        }
        int[][] finalState = new int[3][3];
        System.out.println("\nEnter Final Block Structure");
        System.out.println("Enter 0 for blank space:");
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print("Row " + (i + 1) + " Column " + (j + 1) + " Element = ");
                finalState[i][j] = scanner.nextInt();
            }
        }
        System.out.println("\n\nThis is the solution using A * Algorithm:\n");
        solve(initial, x, y, finalState);
    }
}
