import java.util.LinkedList;

public class MazeSolver {

    static Maze m = new Maze();

    //0 = wall
    //1 = path
    //2 = destination

    public static void main(String[] args) {

        int[][] maze = {
                {1, 1, 1, 1, 0, 1, 1, 1, 0, 1, 0},
                {0, 0, 1, 1, 1, 1, 0, 0, 0, 1, 0},
                {0, 0, 0, 1, 0, 1, 1, 0, 1, 1, 1},
                {1, 1, 1, 2, 0, 1, 0, 1, 0, 1, 0},
                {0, 0, 0, 1, 0, 0, 0, 0, 0, 1, 0},
                {0, 0, 0, 1, 1, 1, 1, 1, 1, 0, 1}};
        m.maze = maze;
        m.start = new Position(4,8);
        m.path = new LinkedList<Position>();

        if(solveMaze(m.start)){
            System.out.println("you won!");
        }else System.out.println("no path");

    }

    private static boolean solveMaze(Position position) {
        m.path.push(position);

        while (true) {
            int x = m.path.peek().x;
            int y = m.path.peek().y;
            m.maze[x][y] = 0;
            //down
            if (isValid(x + 1, y)) {
                if (m.maze[x + 1][y] == 2) {
                    System.out.println("moved down");
                    return true;
                } else if (m.maze[x + 1][y] == 1) {
                    System.out.println("moved down");
                    m.path.push(new Position(x + 1, y));
                    continue;
                }
            }
            //left
            if (isValid(x, y - 1)) {
                if (m.maze[x][y - 1] == 2) {
                    System.out.println("moved left");
                    return true;
                } else if (m.maze[x][y - 1] == 1) {
                    System.out.println("moved left");
                    m.path.push(new Position(x, y - 1));
                    continue;
                }
            }
            //up
            if (isValid(x - 1, y)) {
                if (m.maze[x - 1][y] == 2) {
                    System.out.println("moved up");
                    return true;
                } else if (m.maze[x - 1][y] == 1) {
                    System.out.println("moved up");
                    m.path.push(new Position(x - 1, y));
                    continue;
                }
            }
            //right
            if (isValid(x, y + 1)) {
                if (m.maze[x][y + 1] == 2) {
                    System.out.println("moved right");
                    return true;
                } else if (m.maze[x][y + 1] == 1) {
                    System.out.println("moved right");
                    m.path.push(new Position(x, y + 1));
                    continue;
                }
            }
            m.path.pop();
            System.out.println("moved back");
            if (m.path.size() <= 0)
            return false;
        }
    }


    public static boolean isValid(int x, int y) {
        if (x < 0 || x >= m.maze.length || y < 0 || y >= m.maze[x].length) {
            return false;
        }
        return true;
    }
}


