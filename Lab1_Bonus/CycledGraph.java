public class CycledGraph {
    public static void main(String[] args) {
        if(args.length < 1) {
            System.err.println("Invalid nr of args!");
        }
        int n = Integer.parseInt(args[0]);
        int[][] A = new int[n][n];
        for(int i = 0; i < n; i++){
            A[i][(i+1)%n] = 1; //avem modulo n fiindca, daca ajungem pe ultimul nod, acesta e adiacent cu primul nod
            A[i][(i+n-1)%n] = 1; //nodul curent a adiacent cu nodul precedent (putem scrie doar i-1 dar nu si cand suntem pe primul nod)
        }
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                System.out.print(A[i][j] + " ");
            }
            System.out.println();
        }

        //Computing A^2, A^3, ..., A^n


    }
}
