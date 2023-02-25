public class Main {

    /*
         1 2 3 4
         2 3 4 1
         3 4 1 2
         4 1 2 3
    */
    public static void main(String[] args) {
        if(args.length < 1){
            System.err.println("Invalid nr of args!");
        }
        else {
            if(args.length < Integer.parseInt(args[0]) + 1)
                System.err.println("Invalid nr of args!");
        }

        int n = Integer.parseInt(args[0]);
        long startTime = System.currentTimeMillis();
        System.out.println("The integer is: " + n);
        long [][]latinSquare = new long[n][n];
        //initializam primul rand
        for(int j = 0; j < n; j++){
            latinSquare[0][j] = j + 1;
        }
        //continuam cu restul randurilor shiftand randul precedent
        for(int i = 1; i < n; i++) {
            for(int j = 0; j < n; j++){
                latinSquare[i][j] = latinSquare[i-1][(j+1)%n];
            }
        }
        //afisam matricea
        if(n < 30000){
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    System.out.print(latinSquare[i][j] + " ");
                }
                System.out.println();
            }
        }

        //Part 3 - concatenarea simbolurilor de pe fiecare coloana si linie
        for(int i = 0; i < n; i++){
            String row = "";
            for(int j = 0; j < n; j++){
                String s = Long.toString(latinSquare[i][j]);
                row = row + s;
            }
            if(n < 30000) {
                System.out.println("Row number " + i + " has string: " + row);
            }
        }
        for(int j = 0; j < n; j++){
            String column = "";
            for(int i = 0; i < n; i++) {
                String s = Long.toString(latinSquare[i][j]);
                column = column + s;
            }
            if(n < 30000) {
                System.out.println("Column number " + j + " has string: " + column);
            }
        }
        if(n >= 30000) {
            long endTime = System.currentTimeMillis();
            long elapsedTime = endTime - startTime;
            System.out.println("Elapsed time: " + elapsedTime + " milliseconds");
        }

    }
}