import java.util.Scanner;

class TicTacToe {
    static char board[][] = new char[3][3];
    static Scanner sc = new Scanner(System.in);
    static int row, col, counter;
    String name1, name2;
    char symbol = ' ';
    int coin, call, toss;
    boolean chkmove = false;
    char press;

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        TicTacToe ob = new TicTacToe();
        do {
            counter = 0;
            System.out.println("-------------------TIC TAC TOE GAME------------------- " + "\n");


            System.out.print("Enter Player 1 Name: ");
            ob.name1 = input.nextLine();
            System.out.print("\n" + "Enter Player 2 Name: ");
            ob.name2 = input.nextLine();

            ob.toss = ob.toss();

            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    board[i][j] = '-';
                }
            }
            ob.drawBoard();

            L1:
                while (true) {

                    if (ob.toss == 1) {
                        ob.symbol = 'X';
                        System.out.print(ob.name1 + " Enter Row Number from(0-1-2) : ");
                        row = sc.nextInt();
                        System.out.print("\n" + ob.name1 + " Enter col Number from(0-1-2) : ");
                        col = sc.nextInt();
                        ob.chkmove = ob.checkMove(ob.name1, row, col);
                        if (ob.chkmove) {
                            ob.play(ob.symbol);
                            ob.drawBoard();
                        }
                        if (ob.checkWinnerX()) {
                            System.out.println(ob.name1 + " WON !!!!!");
                            break L1;
                        }
                        counter++;

                        if (ob.checkDraw()) {
                            System.out.println(".......Match Draw.......");
                            break L1;
                        }


                        ob.symbol = 'O';
                        System.out.print(ob.name2 + " Enter Row Number from(0-1-2) : ");
                        row = sc.nextInt();
                        System.out.print("\n" + ob.name2 + " Enter col Number from(0-1-2) : ");
                        col = sc.nextInt();
                        ob.chkmove = ob.checkMove(ob.name2, row, col);
                        if (ob.chkmove) {
                            ob.play(ob.symbol);
                            ob.drawBoard();
                        }
                        if (ob.checkWinnerO()) {
                            System.out.println(ob.name2 + " WON !!!!! ");
                            break L1;
                        }
                        counter++;

                        if (ob.checkDraw()) {
                            System.out.println(".......Match Draw.......");
                            break L1;
                        }


                    } else {
                        ob.symbol = 'X';
                        System.out.print("\n" + ob.name2 + " Enter Row Number from(0-1-2) : ");
                        row = sc.nextInt();
                        System.out.print("\n" + ob.name2 + " Enter col Number from(0-1-2) : ");
                        col = sc.nextInt();
                        ob.chkmove = ob.checkMove(ob.name2, row, col);
                        if (ob.chkmove) {
                            ob.play(ob.symbol);
                            ob.drawBoard();
                        }
                        if (ob.checkWinnerX()) {
                            System.out.println(ob.name1 + " WON !!!!!");
                            break L1;
                        }

                        counter++;

                        if (ob.checkDraw()) {
                            System.out.println(".......Match Draw.......");
                            break L1;
                        }

                        ob.symbol = 'O';
                        System.out.print("\n" + ob.name1 + " Enter Row Number from(0-1-2) : ");
                        row = sc.nextInt();
                        System.out.print("\n" + ob.name1 + " Enter col Number from(0-1-2) : ");
                        col = sc.nextInt();
                        ob.chkmove = ob.checkMove(ob.name1, row, col);
                        if (ob.chkmove) {
                            ob.play(ob.symbol);
                            ob.drawBoard();
                        }
                        if (ob.checkWinnerO()) {
                            System.out.println(ob.name2 + " WON !!!!!");
                            break L1;
                        }
                        counter++;

                        if (ob.checkDraw()) {
                            System.out.println(".......Match Draw.......");
                            break L1;
                        }

                    }

                }

            System.out.println("\n" + "Press Y to Play Again. or Press Any Other Key to Exit");
            System.out.print("Press : ");
            ob.press = sc.next().charAt(0);
            System.out.println("------------------------------------------------------" + "\n\n");
        } while (ob.press == 'y' || ob.press == 'Y');

    }


    int toss() {
        System.out.println("\n" + name1 + " Call 1 for Heads and 2 for Tails.");
        System.out.print("CALL: ");
        call = sc.nextInt();
        if (call < 1 || call > 2) {
            while (call < 1 || call > 2) {
                System.out.println("Please choose from 1 OR 2.");
                System.out.print("CALL: ");
                call = sc.nextInt();
            }
        }
        coin = (int)(Math.random() * 2) + 1;
        if (call == coin) {
            System.out.println(name1 + " won the toss." + "\n");
            return 1;
        } else
            System.out.println(name2 + " won the toss." + "\n");
        return 2;
    }


    void drawBoard() {
        System.out.println("---BOARD---" + "\n");
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(board[i][j]);
            }
            System.out.println();
        }
    }


    boolean checkMove(String name, int r, int c) {

        if (r < 0 || r > 2 || c < 0 || c > 2) {
            while (row < 0 || row > 2 || col < 0 || col > 2) {
                System.out.println("Out of Bounds.");
                System.out.print("\n" + name + " Enter Row Number from(0-1-2) : ");
                row = sc.nextInt();
                System.out.print("\n" + name + " Enter Col Number from(0-1-2) : ");
                col = sc.nextInt();
            }
            return true;
        } else if (board[r][c] != '-') {
            while (board[row][col] != '-') {
                System.out.println("That position have been used.");
                System.out.print("\n" + name + " Enter Row Number from(0-1-2) : ");
                row = sc.nextInt();
                System.out.print("\n" + name + " Enter col Number from(0-1-2) : ");
                col = sc.nextInt();
                if (row < 0 || row > 2 || col < 0 || col > 2) {
                    while (row < 0 || row > 2 || col < 0 || col > 2) {
                        System.out.println(" Out of Bounds.");
                        System.out.print("\n" + name + " Enter Row Number from(0-1-2) : ");
                        row = sc.nextInt();
                        System.out.print("\n" + name + " Enter Row Number from(0-1-2) : ");
                        col = sc.nextInt();
                    }
                    return true;
                }
            }

            if (row < 0 || row > 2 || col < 0 || col > 2) {
                while (row < 0 || row > 2 || col < 0 || col > 2) {
                    System.out.println(" Out of Bounds.");
                    System.out.print("\n" + name + " Enter Row Number from(0-1-2) : ");
                    row = sc.nextInt();
                    System.out.print("\n" + name + " Enter Row Number from(0-1-2) : ");
                    col = sc.nextInt();
                }
                return true;
            }
            return true;
        }
        return true;
    }


    void play(char symbol) {
        board[row][col] = symbol;
    }

    boolean checkWinnerX() {
        for (int i = 0; i <= row; i++) {
            if (board[i][0] == 'X' && board[i][1] == 'X' && board[i][2] == 'X') {
                return true;
            }
        }

        for (int j = 0; j <= col; j++) {
            if (board[0][j] == 'X' && board[1][j] == 'X' && board[2][j] == 'X')
                return true;
        }

        if (board[0][0] == 'X' && board[1][1] == 'X' && board[2][2] == 'X')
            return true;
        if (board[0][2] == 'X' && board[1][1] == 'X' && board[2][0] == 'X')
            return true;

        return false;

    }

    boolean checkWinnerO() {
        for (int i = 0; i <= row; i++) {
            if (board[i][0] == 'O' && board[i][1] == 'O' && board[i][2] == 'O') {
                return true;
            }
        }

        for (int j = 0; j <= col; j++) {
            if (board[0][j] == 'O' && board[1][j] == 'O' && board[2][j] == 'O')
                return true;
        }

        if (board[0][0] == 'O' && board[1][1] == 'O' && board[2][2] == 'O')
            return true;
        if (board[0][2] == 'O' && board[1][1] == 'O' && board[2][0] == 'O')
            return true;

        return false;

    }
    boolean checkDraw() {
        if (counter == 9) {
            return true;
        } else
            return false;
    }
}