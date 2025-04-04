package Bai3_7;

public class TestSoccer {
	public static void main(String[] args) {
        Ball ball = new Ball(10, 10, 0);
        System.out.println("Ball: " + ball);

        Player p1 = new Player(7, "Ronaldo", 5, 5, 0);
        System.out.println("Player 1: " + p1);

        Player p2 = new Player(10, "Messi", 15, 15, 0);
        System.out.println("Player 2: " + p2);

        System.out.println("\nPlayer 1 tries to kick the ball...");
        boolean canKickP1 = p1.kick(ball);
        if (canKickP1) {
            System.out.println("Player 1 can kick the ball (distance < 8).");
        } else {
            System.out.println("Player 1 is too far to kick the ball (distance >= 8).");
        }

        p1.move(3, 3, 0);  
        System.out.println("Player 1 moved to: " + p1);

        System.out.println("Player 1 tries again...");
        canKickP1 = p1.kick(ball);
        if (canKickP1) {
            System.out.println("Player 1 can now kick the ball!");
        } else {
            System.out.println("Still too far!");
        }

        System.out.println("\nPlayer 2 tries to kick the ball...");
        boolean canKickP2 = p2.kick(ball);
        if (canKickP2) {
            System.out.println("Player 2 can kick the ball!");
        } else {
            System.out.println("Player 2 is too far!");
        }
    }
}
