public class Spy {
    public static void main(String[] args) {
        int numOfStudents = 5;
        int numOfScores = 5;
        double[][] scores = new double[numOfStudents][numOfScores];
        scores[0][0] = 2.45;
        scores[1][1] = 3.78;
        scores[2][2] = 4.56;
        scores[3][3] = 5.67;
        scores[4][4] = 3.45;

        //System.out.println(scores);

        int x;
        for (int i = 0; i < numOfStudents; i++) {
            System.out.print("[");
            for(x = 0; x < numOfScores-1; x++) {
                System.out.print(scores[i][x] + ", ");
            }
            System.out.print(scores[i][x]);
            System.out.println("]");
        }
    }
}
