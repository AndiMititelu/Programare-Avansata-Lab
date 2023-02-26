import java.awt.desktop.ScreenSleepEvent;

public class RegularGraph {
    /*  Create the adjacency matrix of a regular graph.
       The number of vertices and the vertex degree are given as arguments
    */
    public static void main(String[] args) {
        if(args.length < 2){
            System.err.println("Invalid nr of arguments!");
        }
        //avem un graph regulat => fiecare nod are acelasi nr de vecini
        int n = Integer.parseInt(args[0]);
        int k = Integer.parseInt(args[1]);
        int[][] matrix = new int[n][n];

        for(int i = 0; i < n; i++) {
            for(int j = 1; j <= k; j++) {
                int neighbor = (i + j) % n;
                matrix[i][neighbor] = 1; //urmatorii k vecini ai nodului i sunt marcati; facem modulo n ca sa ne asiguram ca indexul este in [1, n]
            }
        }
        //verificam daca matricea e valida (sunt cazuri in care nu putem construi un regular graph)
        boolean ok = true;
        for(int i = 0; i < n; i++) {
            int checkDegree = 0;
            for(int j = 0; j < n; j++){
               checkDegree += matrix[i][j];
            }
            if(checkDegree != k) {
                System.err.println("Eroare nu avem regular graph!");
                ok = false;
                break;
            }

        }
        if(ok) {
            for(int i = 0; i < n; i++) {
                for(int j = 0; j < n; j++) {
                    System.out.print(matrix[i][j] + " ");
                }
                System.out.println();
            }
        }
    }
}
