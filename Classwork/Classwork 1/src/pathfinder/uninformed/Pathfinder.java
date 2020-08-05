package pathfinder.uninformed;

import java.util.*;

/**
 * Maze Pathfinding algorithm that implements a basic, uninformed, breadth-first tree search.
 */
public class Pathfinder {
    
    /**
     * Given a MazeProblem, which specifies the actions and transitions available in the
     * search, returns a solution to the problem as a sequence of actions that leads from
     * the initial to a goal state.
     * 
     * @param problem A MazeProblem that specifies the maze, actions, transitions.
     * @return A List of Strings representing actions that lead from the initial to
     * the goal state, of the format: ["R", "R", "L", ...]
     */
    public static List<String> solve (MazeProblem problem) {
        Queue<SearchTreeNode> frontier = new LinkedList<SearchTreeNode>();
        List<MazeState> visited = new ArrayList<MazeState>();
        SearchTreeNode current = new SearchTreeNode(problem.INITIAL_STATE, "",null);
        frontier.add(current);
        return solveHelper(current, problem, frontier, visited);
    }
    
    /**
     * Helper Method to recursively do the solve method
     * @param current     SearchTreeNode type that represents the current node we are on
     * @param problem     MazeProblem type that represents the entire maze problem
     * @param frontier    Queue type that represents the nodes to be explored
     * @param visited     List type of MazeStates that keeps track of the nodes visited
     * @return
     */
    private static List<String> solveHelper (SearchTreeNode current, MazeProblem problem, Queue<SearchTreeNode> frontier, List<MazeState> visited) {
    	if(problem.isGoal(current.state)) {
            List<String> result = new ArrayList<String>();
            while(current.parent != null) {
            	result.add(0, current.action);
            	current = current.parent;
            }
    		return result;
    	}
    	if(!visited.contains(current.state)) {
    		Map<String, MazeState> next = problem.getTransitions(current.state);
        	for (String name : next.keySet()) { 
        		frontier.add(new SearchTreeNode(next.get(name), name, current));
       		}	
       		visited.add(current.state);
    	}
    	return solveHelper((SearchTreeNode) frontier.poll(), problem, frontier, visited);  
    	}
	}

/**
 * SearchTreeNode that is used in the Search algorithm to construct the Search
 * tree.
 */
class SearchTreeNode {
    
    MazeState state;
    String action;
    SearchTreeNode parent;
    
    /**
     * Constructs a new SearchTreeNode to be used in the Search Tree.
     * 
     * @param state The MazeState (col, row) that this node represents.
     * @param action The action that *led to* this state / node.
     * @param parent Reference to parent SearchTreeNode in the Search Tree.
     */
    SearchTreeNode (MazeState state, String action, SearchTreeNode parent) {
        this.state = state;
        this.action = action;
        this.parent = parent;
    }
    
}