package com.maze.solver;

import java.io.FileNotFoundException;
import java.util.ArrayList;

public class MazeMain {
    //0 = wall
    //1 = path
    //2 = destination

    public static void main(String[] args) throws FileNotFoundException {
        ArrayList<Maze> mazes = MazeData.readMazes();
        int i = 0;
        while(i < mazes.size()) {
            if(MazeSolver.solveMaze(mazes.get(i))){
                System.out.println("you won!");
            }else System.out.println("no path");
            i++;
        }
    }
}
