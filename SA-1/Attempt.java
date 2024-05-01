public class Attempt {
    public static void main(String[] args) {
        int m, n;
        m = 13;
        n = 6;

        double[][] FindArray = new double[m][n];

        int x;
        for (int i = 0; i < m; i++) {
            for (x = 0; x < n; x++) {
                FindArray[i][x] = 1/(m * n);
            }
        }
        int b;
        for (int a = 0; a < m; a++) {
            System.out.print("[");
            for (b = 0; b < n-1; b++){
                System.out.print(FindArray[a][b] + ", ");
            }
            System.out.println(FindArray[a][b] + "] ");
        }
    }
    public void SetGridProbability(int row, int col, double probability) {

    }
}
