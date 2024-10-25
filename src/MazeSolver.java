import java.util.LinkedList;

public class MazeSolver {

    static int[][] maze = {
            {1, 1, 1, 1, 0, 1, 1, 1, 0, 1, 0},
            {0, 0, 1, 1, 1, 1, 0, 0, 0, 1, 0},
            {0, 0, 0, 1, 0, 1, 1, 0, 1, 1, 1},
            {1, 1, 1, 2, 0, 1, 0, 1, 0, 1, 0},
            {0, 0, 1, 0, 1, 0, 0, 0, 0, 1, 0},
            {0, 0, 0, 1, 0, 0, 1, 0, 0, 0, 1}};

    static LinkedList<Position> path = new LinkedList();


    public static void main(String[] args) {
        Position position = new Position(4, 8);
        path.push(position);

        while (true) {
            int x = path.peek().x;
            int y = path.peek().y;
            maze[x][path.peek().y] = 0;
            //down
            if (isValid(x + 1, y)) {
                if (maze[x + 1][y] == 2) {
                    System.out.println("moved down. you won");
                    return;
                } else if (maze[x + 1][y] == 1) {
                    System.out.println("moved down");
                    path.push(new Position(x + 1, y));
                    continue;
                }
            }
            //left
            if (isValid(x, y - 1)) {
                if (maze[x][y - 1] == 2) {
                    System.out.println("moved left. you won");
                    return;
                } else if (maze[x][y - 1] == 1) {
                    System.out.println("moved left");
                    path.push(new Position(x, y - 1));
                    continue;
                }
            }
            //up
            if (isValid(x - 1, y)) {
                if (maze[x - 1][y] == 2) {
                    System.out.println("moved up. you won");
                    return;
                } else if (maze[x - 1][y] == 1) {
                    System.out.println("moved up");
                    path.push(new Position(x - 1, y));
                    continue;
                }
            }
            //right
            if (isValid(x, y + 1)) {
                if (maze[x][y + 1] == 2) {
                    System.out.println("moved right . you won");
                    return;
                } else if (maze[x][y + 1] == 1) {
                    System.out.println("moved right");
                    path.push(new Position(x, y + 1));
                    continue;
                }
            }
            path.pop();
            System.out.println("moved back");
            if (path.size() <= 0)
                System.out.println("no path");
            return;
        }
    }


    public static boolean isValid(int x, int y) {
        if (x < 0 || x >= maze.length || y < 0 || y >= maze[x].length) {
            return false;
        }
        return true;
    }
}


