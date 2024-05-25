import java.util.Scanner;
class TicTacToe{
    static char board[][];

    TicTacToe(){
        board = new char[3][3];
        initBoard();
    }

    public static void initBoard(){
        for(int i = 0; i<board.length; i++){
            for(int j = 0; j<board[i].length; j++){
                board[i][j] = ' ';
            }
        }
    }

    public static void dispBoard(){
        System.out.println("-------------");
        for(int i = 0; i<board.length; i++){
            System.out.print("| ");
            for(int j = 0; j<board[i].length; j++){
                System.out.print(board[i][j] + " | ");
            }
            System.out.println();
            System.out.println("-------------");
        }
    }

    public static void placeMark(int row, int col, char mark){
        if(row >= 0 && row <=2 && col >= 0 && col<=2){
            board[row][col] = mark;
        }
    }

    public static boolean checkColWin(){
        for(int j = 0; j<=2; j++){
            if(board[0][j] != ' ' && board[0][j] == board[1][j] && board[1][j] == board[2][j]){
                return true;
            }
        }
        return false;
    }

    public static boolean checkRowWin(){
        for(int i = 0; i<=2; i++){
            if(board[i][0] != ' ' && board[i][0] == board[i][1] && board[i][1] == board[i][2]){
                return true;
            }
        }
        return false;
    }

    public static boolean checkDiagWin(){
        if(board[0][0] != ' ' && board[0][0] == board[1][1] && board[1][1] == board[2][2]
            || board[0][2] != ' ' && board[0][2] == board[1][1] && board[1][1] == board[2][0]){
            return true;
        }
        return false;
    }

    public static boolean checkDraw(){
        for(int i = 0; i<=2; i++){
            for(int j = 0; j<=2; j++){
                if(board[i][j] == ' '){
                    return false;
                }
            }
        }
        return true;
    }

}

class Player{
    String name;
    char mark;

    Player(String name, char mark){
        this.name = name;
        this.mark = mark;
    }

    public static boolean checkValidMove(int row, int col){
        if(row >= 0 && row <= 2 && col >= 0 && col <= 2 ){
            if(TicTacToe.board[row][col] == ' '){
                return true;
            }
        }
        return false;
    }


    public void makeMove(){
        Scanner sc = new Scanner(System.in);
        int row;
        int col;
        do{
            System.out.println("Enter the row and column: ");
            row = sc.nextInt();
            col = sc.nextInt();
        } while (!checkValidMove(row, col));
        TicTacToe.placeMark(row, col, mark);
    }

}

class MAIN{
    public static void main(String[] args) {
        TicTacToe t = new TicTacToe();
        Player p1 = new Player("Abdullah", 'X');
        Player p2 = new Player("Ibrahim", '0');
        Player cp;
        cp = p1;

        while(true){
            System.out.println(cp.name + "'s turn");
            cp.makeMove();
            TicTacToe.dispBoard();
            if(TicTacToe.checkRowWin() || TicTacToe.checkColWin() || TicTacToe.checkDiagWin()){
                System.out.println(cp.name + " won");
                break;
            }
            else if(TicTacToe.checkDraw()){
                System.out.println("Match drawn");
                break;
            }
            else{
                if(cp == p1){
                    cp = p2;
                }
                else{
                    cp = p1;
                }
            }

        }

    }
}