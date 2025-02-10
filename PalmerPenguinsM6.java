// PalmerPenguinsM6.java
//
//
// Reads the CSV file and parses data into arrays using user-defined methods

import java.io.*;
import java.util.*;

public class PalmerPenguinsM6 {

    static final String FILE_NAME = "PalmerPenguins.csv";

    // Constants representing species and count
    public static final int NUM_SPECIES = 3;
    public static final String SP_CHINSTRAP = "Chinstrap";
    public static final String SP_GENTOO = "Gentoo";
    public static final String SP_ADELIE = "Adelie";

    public static void main(String[] args) {
        // TODO 1: Call the readSpeciesData method and store the result in a 
        // String array named speciesData
        
        
        // TODO 2: Call the initializeSpeciesCount method and store the 
        // result in an int array named speciesCount
        

        // TODO 3: Use the isDataEmpty method to check if speciesData is empty
        

        // TODO 4: Call the countSpecies method, passing speciesData and 
        // speciesCount as arguments
        

        // TODO 5: Call the printSpeciesCount method, passing speciesCount 
        // as an argument
        
    }

    /**
     * TODO 1: Create a method named readSpeciesData that calls CSVReader.readFile 
     *         to read column 1 from the CSV file and returns a String array.
     */


    /**
     * TODO 2: Create a method named initializeSpeciesCount that returns 
     *         a new int array of size NUM_SPECIES.
     */


    /**
     * TODO 3: Create a method named isDataEmpty that takes a String[] array 
     *         as a parameter and returns true if its length is 0, otherwise false.
     */


    /**
     * TODO 4: Create a method named countSpecies that takes a String[] speciesData 
     *         and an int[] speciesCount as parameters. This method should iterate 
     *         through speciesData and update speciesCount accordingly.
     */


    /**
     * TODO 5: Create a method named printSpeciesCount that takes an int[] speciesCount 
     *         as a parameter and prints the count of each species.
     */

}

class CSVReader {
    /**
     * readFile reads a file line by line, extracts the specified column from each line, 
     * and returns an array containing the extracted values.
     *
     * @param FILE_NAME the file name to read
     * @param column the zero-based index of the column to extract
     * @return an array of extracted column values
     */
    public static String[] readFile(String FILE_NAME, int column) {
        List<String> columnValues = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] tokens = line.split(",");
                if (column >= 0 && column < tokens.length) {
                    columnValues.add(tokens[column]);
                } else {
                    columnValues.add("");
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
            return new String[0];
        }

        return columnValues.toArray(new String[0]);
    }
}
