package Easy;

import java.util.ArrayList;
import java.util.List;

// https://leetcode.com/problems/snake-in-matrix/submissions/1563641976/ [SOLVED]

public class SnakeMatrix {
    public static void main(String[] args) {
        List<String> commands = new ArrayList<>();
        commands.add("DOWN");
        commands.add("RIGHT");
        commands.add("UP");
        System.out.println("Ans: " + finalPositionOfSnake(3, commands));
        
        
    }
    public static int finalPositionOfSnake(int n, List<String> commands) {
        int row = 0;
        int col = 0;

        for (int i = 0; i < commands.size(); i++) {
            switch(commands.get(i)) {
                case "UP": 
                    row -= 1;
                    break;
                case "DOWN": 
                    row += 1;
                    break;
                case "LEFT": 
                    col -= 1;
                    break;
                case "RIGHT": 
                    col += 1;
                    break;
            }
        }
        return (row * n) + col;
    }
    
}
