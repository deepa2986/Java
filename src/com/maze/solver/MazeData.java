package com.maze.solver;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class MazeData {
    public static ArrayList<Maze> readMazes() throws FileNotFoundException {

        ArrayList<Maze> mazes = new ArrayList<>();
        Scanner in = new Scanner(new File("mazess.txt"));
        while (in.hasNextLine()) {
            Maze m = new Maze();
            int rows = Integer.parseInt(in.nextLine());
            m.maze = new int[rows][];
            for (int i = 0; i < rows; i++) {
                String line = in.nextLine();
                m.maze[i] = Arrays.stream(line.split(", ")).mapToInt(Integer::parseInt).toArray();
            }
            m.start = new Position(Integer.parseInt(in.nextLine()), Integer.parseInt(in.nextLine()));
            in.nextLine();
            mazes.add(m);
        }
        return mazes;
    }
}
