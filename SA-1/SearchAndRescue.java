/**
 *  SA-1 provided code
 *  Creates a search grid for a lost fisherman, where each row,col grid location contains the probability
 *  the fisherman is in that particular grid location.
 *
 * @author Ikenna Nwafor, Dartmouth CS10, Spring 2024
 */

public class SearchAndRescue {
    private double[][] searchGrid; //probabilities for each (row, col) grid location
    private int numberOfRows, numberOfCols; //number of rows and cols


    public SearchAndRescue(int rows, int cols) {
        //TODO: your code here

        this.numberOfRows = rows;
        this.numberOfCols = cols;

        searchGrid = new double[rows][cols];

        double totalsquares = rows * cols;

        int x;
        for (int i = 0; i < rows; i++) {
            for (x = 0; x < cols; x++) {
                searchGrid[i][x] = 1/totalsquares;
            }
        }

        //save rows and cols, initialze search grid

    }

    /**
     * Set the probability the person is in the (row, col) grid location.
     * Print error message if row, col location is out of bounds or probability is invalid
     * @param row
     * @param col
     * @param probability probability the fisherman is in this grid (row,col) location
     */

    public void setGridProbability(int row, int col, Double probability) {
        //TODO: your code here

        if (probability < 0 || probability > 1) {
            System.out.println("Invalid probability.");
            return;
        }
        if (row < 0 || row >= numberOfRows) {
            System.out.println("Invalid number of rows.");
            return;
        }

        if (col < 0 || col >= numberOfCols) {
            System.out.println("Invalid number of columns.");
            return;
        }

        searchGrid[row][col] = probability;

    }

    /**
     * Print the best location to search.
     * Break ties as you see fit
     */
    public void printBestLocation() {
        double bestProbability = searchGrid[0][0]; //keep track of best probability
        int bestRow=0, bestCol=0;

        int x;
        for (int i = 0; i < numberOfRows; i++) {
            for (x = 0; x < numberOfCols; x++) {
                if (searchGrid[i][x] > searchGrid[bestRow][bestCol]) {
                    bestRow = i; bestCol = x;
                }
            }
        }

        System.out.println("Most likely location: row=" + bestRow + " col=" + bestCol );
    }


    /**
     * Convert grid to a string representation.
     * @return String representation of the search grid
     */
    public String toString() {
        String s = "\t";
        //create header row
        for (int x = 0; x < numberOfCols; x++) {
            s += x + "\t\t";
        }
        s += "\n";
        //create grid
        for (int row = 0; row < numberOfRows; row++) {
            s += row + "\t";
            for (int col = 0; col < numberOfCols; col++) {
                s += String.format("%.3f", searchGrid[row][col]) + "\t"; //format not required!
            }
            s += "\n";
        }
        return s;
    }

    public static void main(String[] args) {
        SearchAndRescue search = new SearchAndRescue(2,4);
        System.out.println("Initial grid");
        System.out.println(search); //calls toString

        System.out.println("Most likely location");
        search.printBestLocation();

        System.out.println("Update grid locations");
        search.setGridProbability(1, 5, 0.3); //error, invalid location
        search.setGridProbability(1, 1, 0.3);
        search.setGridProbability(-1,-1,-1.0); //error, invalid location
        search.setGridProbability(1,2, 100.0); //error, invalid probability

        System.out.println("After updates");
        System.out.println(search); //calls toString
        System.out.println("New most likely");
        search.printBestLocation();

    }
}
