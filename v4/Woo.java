import java.util.Scanner;

public class Woo {
	private static final String acceptedInputs = "wasdWASD";

	public static void main(String[] args) {
		Board game = new Board();
		game.newTile();
		String s;
		String name = "";
    		s = "~~~ 2048 : TERMINAL EDITION ~~~\n";
    		s += "\n How To Play: \n";
    		s += "\n Use your WASD keys and the enter key to move the tiles. Tiles with the same number merge into one when they touch. Add them up to reach 2048! \n";
		s += "\n \n";
    		System.out.print( s );
    		game.printGrid();
    		while (! game.isEnded()){
    			if(moverDoer(inputGet(), game)){
    				game.newTile(); //We only want to generate a new tile if the user made a valid move.
					}
    			game.printGrid();
    		}
	}

	public static String inputGet() {
		Scanner input = new Scanner(System.in);
		System.out.print("Enter your MOVE:");
		String move = input.nextLine();
		while (acceptedInputs.indexOf(move) == -1) {
			Scanner input2 = new Scanner(System.in);
			System.out.print("Your input is invalid, please enter your MOVE again, and make sure to use the WASD keys:");
			move = input.nextLine();
		}
		return move;
	}

	public static boolean moverDoer(String input, Board game){
		if(input.equals("w") || input.equals("W")){
			return game.shiftUp();
		}
		if(input.equals("a") || input.equals("A")){
			return game.shiftLeft();
		}
		if(input.equals("s") || input.equals("S")){
			return game.shiftDown();
		}
		if(input.equals("d") || input.equals("D")){
			return game.shiftRight();
		}
		else{
			return false; //Shouldn't happen
		}
	}
}
