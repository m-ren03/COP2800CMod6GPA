// PalmerPenguinsM6.java
//Madison Renckert
//06/21/2026
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
        String[] speciesData = readSpeciesData();
    
        
        // TODO 2: Call the initializeSpeciesCount method and store the 
        // result in an int array named speciesCount
      
        int[] speciesCount = initializeSpeciesCount();

        // TODO 3: Use the isDataEmpty method to check if speciesData is empty
        if (isDataEmpty(speciesData)) {
            return;
        }

        // TODO 4: Call the countSpecies method, passing speciesData and 
        // speciesCount as arguments
        countSpecies(speciesData, speciesCount);
    

        // TODO 5: Call the printSpeciesCount method, passing speciesCount 
        // as an argument
        printSpeciesCount(speciesCount);
    }

    /**
     * TODO 1: Create a method named readSpeciesData that calls CSVReader.readFile 
     *         to read column 1 from the CSV file and returns a String array.
     */
    public static String[] readSpeciesData() {
         return CSVReader.readFile(FILE_NAME, 1);
    }


    /**
     * TODO 2: Create a method named initializeSpeciesCount that returns 
     *         a new int array of size NUM_SPECIES.
     */
     public static int[] initializeSpeciesCount() {
         return new int[NUM_SPECIES];
     }


    /**
     * TODO 3: Create a method named isDataEmpty that takes a String[] array 
     *         as a parameter and returns true if its length is 0, otherwise false.
     */
     public static boolean isDataEmpty(String[] data) {
         return data.length == 0;
     }


    /**
     * TODO 4: Create a method named countSpecies that takes a String[] speciesData 
     *         and an int[] speciesCount as parameters. This method should iterate 
     *         through speciesData and update speciesCount accordingly.
     */
     public static void countSpecies(String[] speciesData, int[] speciesCount) {
         for (String species : speciesData) {
               if (species.equalsIgnoreCase(SP_CHINSTRAP)){
                   speciesCount[0]++;
               }
               else if (species.equalsIgnoreCase(SP_GENTOO)){
                   speciesCount[1]++;
               }
               else if (species.equalsIgnoreCase(SP_ADELIE)){
                   speciesCount[2]++;
               }
          }
     }


    /**
     * TODO 5: Create a method named printSpeciesCount that takes an int[] speciesCount 
     *         as a parameter and prints the count of each species.
     */
     public static void printSpeciesCount(int[] speciesCount) {
         System.out.println(SP_CHINSTRAP + "= " + speciesCount[0]);
         System.out.println(SP_GENTOO + "= " + speciesCount[1]);
         System.out.println(SP_ADELIE + "= " + speciesCount[2]);
     }
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
