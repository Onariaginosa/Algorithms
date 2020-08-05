package pathfinder.uninformed;

import static org.junit.Assert.*;
import org.junit.Test;
import java.util.*;

/**
 * Unit tests for Maze Pathfinder. Tests include completeness and
 * optimality.
 */
public class PathfinderTests {

    @Test
    public void testPathfinder_t0() {
        String[] maze = {
            "XXXX",
            "X.IX",
            "XG.X",
            "XXXX"
        };
        MazeProblem prob = new MazeProblem(maze);
        List<String> solution = Pathfinder.solve(prob);
        
        // result will be a 2-tuple (isSolution, cost) where
        // - isSolution = 0 if it is not, 1 if it is
        // - cost = numerical cost of proposed solution
        int[] result = prob.testSolution(solution);
        assertEquals(1, result[0]); // Test that result is a solution
        assertEquals(2, result[1]); // Ensure that the solution is optimal
    }
    
    @Test
    public void testPathfinder_t1() {
        String[] maze = {
            "XXXXXXX",
            "X.....X",
            "XIX.X.X",
            "XX.X..X",
            "XG....X",
            "XXXXXXX"
        };
        MazeProblem prob = new MazeProblem(maze);
        List<String> solution = Pathfinder.solve(prob);
        
        int[] result = prob.testSolution(solution);
        assertEquals(1,  result[0]); // Test that result is a solution
        assertEquals(12, result[1]); // Ensure that the solution is optimal
    }

    @Test
    public void testPathfinder_t2() {
        String[] maze = {
            "XXX",
            "XIX",
            "XGX",
            "XXX"
        };
        MazeProblem prob = new MazeProblem(maze);
        List<String> solution = Pathfinder.solve(prob);
        
        int[] result = prob.testSolution(solution);
        assertEquals(1,  result[0]); // Test that result is a solution
        assertEquals(1, result[1]); // Ensure that the solution is optimal
    }

    @Test
    public void testPathfinder_t3() {
        String[] maze = {
            "XXXXXXXXXXXX",
            "X.........GX",
            "X.XXXXXXXXXX",
            "X..........X",
            "XXXXXXXXXX.X",
            "XI.........X",
            "XXXXXXXXXXXX"
        };
        MazeProblem prob = new MazeProblem(maze);
        List<String> solution = Pathfinder.solve(prob);
        
        int[] result = prob.testSolution(solution);
        assertEquals(1,  result[0]); // Test that result is a solution
        assertEquals(31, result[1]); // Ensure that the solution is optimal
    }

    @Test
    public void testPathfinder_t4() {
        String[] maze = {
            "XXXXXXXXXXXXXXXXXXXX",
            "X..................X",
            "XGX........X.......X",
            "XX........X........X",
            "X...XXXXXXXXXXXXXXXX",
            "X.......XXXXX......X",
            "X..........X....X..X",
            "XXX............X...X",
            "X..............I...X",
            "XXXXXXXXXXXXXXXXXXXX"
        };
        MazeProblem prob = new MazeProblem(maze);
        List<String> solution = Pathfinder.solve(prob);
        
        int[] result = prob.testSolution(solution);
        assertEquals(1,  result[0]); // Test that result is a solution
        assertEquals(22, result[1]); // Ensure that the solution is optimal
    }

    @Test
    public void testPathfinder_t5() {
        String[] maze = {
            "XXXXXXXX",
            "X......X",
            "XIX.X..X",
            "XX.X...X",
            "XX.X...X",
            "XX.X...X",
            "XX.X...X",
            "XG.....X",
            "XXXXXXXX"
        };
        MazeProblem prob = new MazeProblem(maze);
        List<String> solution = Pathfinder.solve(prob);
        
        int[] result = prob.testSolution(solution);
        assertEquals(1,  result[0]); // Test that result is a solution
        assertEquals(15, result[1]); // Ensure that the solution is optimal
    }

    @Test
    public void testPathfinder_t6() {
        String[] maze = {
            "XXXXXXXXXXXXX",
            "X...........X",
            "XIX......X..X",
            "XX...X......X",
            "XX...X......X",
            "XX....X.....X",
            "XX......X...X",
            "XG..........X",
            "XXXXXXXXXXXXX"
        };
        MazeProblem prob = new MazeProblem(maze);
        List<String> solution = Pathfinder.solve(prob);
        
        int[] result = prob.testSolution(solution);
        assertEquals(1,  result[0]); // Test that result is a solution
        assertEquals(11, result[1]); // Ensure that the solution is optimal
    }
}
