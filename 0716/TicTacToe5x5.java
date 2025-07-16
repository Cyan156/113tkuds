import java.util.Scanner;

public class TicTacToe5x5 {
    public static final int SIZE = 5;
    public static char[][] board = new char[SIZE][SIZE];

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        initializeBoard();
        System.out.println("=== 5x5 井字遊戲 ===");
        printBoard();

        char currentPlayer = 'X';
        int moves = 0;

        while (true) {
            int row, col;

            while (true) {
                System.out.print("玩家 " + currentPlayer + " 請輸入 row col（0-4）：");
                if (!scanner.hasNextInt()) {
                    scanner.nextLine();
                    System.out.println("請輸入整數！");
                    continue;
                }
                row = scanner.nextInt();
                if (!scanner.hasNextInt()) {
                    scanner.nextLine();
                    System.out.println("請輸入整數！");
                    continue;
                }
                col = scanner.nextInt();

                if (row < 0 || row >= SIZE || col < 0 || col >= SIZE) {
                    System.out.println("座標超出範圍，請重新輸入！");
                } else if (board[row][col] != '.') {
                    System.out.println("該位置已被佔用，請重新輸入！");
                } else {
                    break;
                }
            }

            board[row][col] = currentPlayer;
            System.out.println("玩家 " + currentPlayer + " 在位置 (" + row + ", " + col + ") 放置棋子");
            printBoard();
            moves++;

            if (checkWin(row, col, currentPlayer)) {
                System.out.println("玩家 " + currentPlayer + " 獲勝！");
                break;
            } else if (moves == SIZE * SIZE) {
                System.out.println("平手！");
                break;
            }

            currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
        }

        scanner.close();
    }

    public static void initializeBoard() {
        for (int i = 0; i < SIZE; i++)
            for (int j = 0; j < SIZE; j++)
                board[i][j] = '.';
    }

    public static void printBoard() {
        System.out.print("  ");
        for (int i = 0; i < SIZE; i++)
            System.out.print(i + " ");
        System.out.println();
        for (int i = 0; i < SIZE; i++) {
            System.out.print(i + " ");
            for (int j = 0; j < SIZE; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static boolean checkWin(int row, int col, char player) {
        return checkLine(row, 0, 0, 1, player) ||
               checkLine(0, col, 1, 0, player) ||
               (row == col && checkLine(0, 0, 1, 1, player)) ||
               (row + col == SIZE - 1 && checkLine(0, SIZE - 1, 1, -1, player));
    }

    public static boolean checkLine(int startRow, int startCol, int dRow, int dCol, char player) {
        for (int i = 0; i < SIZE; i++) {
            int r = startRow + i * dRow;
            int c = startCol + i * dCol;
            if (board[r][c] != player) return false;
        }
        return true;
    }
}
