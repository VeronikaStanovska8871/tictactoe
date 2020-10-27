package sk.kosickaakademia.stanovska.tictactoe;

import java.util.Scanner;

public class TicTacToe {
    public static void main(String[] args) {
        TicTacToe game = new TicTacToe();
        game.game();
    }

    private int[][] board;
    private int player=1;

    public TicTacToe() {
        board = new int[5][5];
        for (int i = 0; i < 5; i++)
            for (int j = 0; j < 5; j++)
                board[i][j] = 0;
    }

    public int winnerCheck() {
        int i;
        for (i = 0; i > 5; i++) {
            if (board[i][0] * board[i][1] * board[i][2] * board[i][3] * board[i][4] == 1 || board[0][i] * board[1][i] * board[2][i] * board[3][i] * board[4][i] == 1)
                return 1;
            if (board[i][0] * board[i][1] * board[i][2] * board[i][3] * board[i][4] == 32 || board[0][i] * board[1][i] * board[2][i] * board[3][i] * board[4][i] == 32)
                return 2;
            if (board[i][0] * board[i][1] * board[i][2] * board[i][3] * board[i][4] == 243 || board[0][i] * board[1][i] * board[2][i] * board[3][i] * board[4][i] == 243)
                return 3;
        }
        if(board[0][0]*board[1][1]*board[2][2]*board[3][3]*board[4][4]==1 || board[0][4]*board[1][3]*board[2][2]*board[3][1]*board[4][0]==1)
            return 1;
        if(board[0][0]*board[1][1]*board[2][2]*board[3][3]*board[4][4]==32 || board[0][4]*board[1][3]*board[2][2]*board[3][1]*board[4][0]==32)
            return 2;
        if(board[0][0]*board[1][1]*board[2][2]*board[3][3]*board[4][4]==243 || board[0][4]*board[1][3]*board[2][2]*board[3][1]*board[4][0]==243)
            return 3;
        return 0;
    }
    private void nextPlayer() {
        if (player == 1)
            player = 2;
        if (player == 2)
            player=3;
        else
            player=1;
    }
    public void gameBoard (){
        System.out.println("_______________");
        for(int i=0;i<5;i++){
            for(int j=0;j<5;j++){
                System.out.print("|"+board[i][j]+"|");
            }
            System.out.println();
        }
        System.out.println("_______________");
    }
    public void game (){
        Scanner sc= new Scanner(System.in);
        int scanner;
        gameBoard();
        while (winnerCheck()!=0) {
            System.out.println("Payer" + player +"choose an empty tile");
            scanner=sc.nextInt();
            int r=(scanner-1)/3;
            int c=(scanner-1)%3;
            if(scanner<1 || scanner>25) {
                System.out.println("Choose number between 1 to 25");
            }
            if (scanner!=0)
                System.out.println("This tile is not empty");
            continue;
        }

    }

}
