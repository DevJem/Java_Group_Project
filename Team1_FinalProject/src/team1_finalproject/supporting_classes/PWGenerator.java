package team1_finalproject.supporting_classes;

/**
  *  @Course: SDEV 450 ~ Java Programming III - Enterprise Java
  *  @Author Name: Jeremy DeHay
  *  @Subclass PWGenerator Description: Take options from the UI to form a
  *         password of the required length and complexity. Implementation
  *         for troubleshooting is
  *         PWGenerator gen = new PWGenerator();
  *         gen.generate();
  */
//Imports

//Begin Subclass PWGenerator
public class PWGenerator {
    
    private boolean bUpcase = false;     // get from UI
    private boolean bLowcase = true;    // get from UI
    private boolean bSpecial = true;    // get from UI
    private boolean bNumber = true;     // get from UI
    private int iLength = 15;            // get from UI
    private String sResult;              // send to UI
    private String sOptions = "";
    private char[] cUpcase = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J',
                             'K', 'L', 'M', 'N', '0', 'P', 'Q', 'R', 'S', 'T',
                             'U', 'V', 'W', 'X', 'Y', 'Z'};
    private char[] cLowcase = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j',
                             'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't',
                             'u', 'v', 'w', 'x', 'y', 'z'};
    private char[] cSpecial = {'!', '@', '#', '$', '%', '^', '&', '*', '(', ')',
                               '_', '+', '-', '=', '|', '\\', '/', '.', ',',
                               '<', '>', ';', ':', '"', '\'', '>'};
    private char[] cNumber = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};
    
    // constructor
    public PWGenerator() {
    }
    
    /**
     * This method generates the password of the desired length
     */
    public void generate() {
        
        sOptions = setOptions();  // Defines complexity requirements
        while (true) {
            sResult = "";
            
            // generate password
            for (int i = 0; i < iLength; i++) {
                sResult += random();
            }
            
            // check if password contains required complexity
            if (checkPW(sResult)) {
                break;
            }
        }
        System.out.println("Generated password is: " + sResult);
    }
    
    /**
     * This method returns a random value from the chosen settings.
     * @return 
     */
    private String random() {
        char[] cTransform = sOptions.toCharArray();
        int iSelection = (int)(Math.random() * (cTransform.length));
        
//        System.out.println(iSelection); // for log
        return String.valueOf(cTransform[iSelection]);
    }

    /**
     * Takes the generated password and compares each character to the selected
     * password complexity to ensure it contains at least one character from
     * each selected set.
     * @param sResult
     * @return 
     */
    private boolean checkPW(String sResult) {
        
        if (bUpcase) {
            boolean bContainsUpcase = false;
            for (int i = 0; i < sResult.length(); i++) {
                for (int j = 0; j < cUpcase.length; j++) {
                    if (sResult.charAt(i) == cUpcase[j])
                        bContainsUpcase = true;
                }
            }
            if (!bContainsUpcase) {
                System.out.println("Does not contain required complexity.");
                return false;                
            }
        }
        if (bLowcase) {
            boolean bConctainsLowcase = false;
            for (int i = 0; i < sResult.length(); i++) {
                for (int j = 0; j < cLowcase.length; j++) {
                    if (sResult.charAt(i) == cLowcase[j])
                        bConctainsLowcase = true;
                }
            }
            if (!bConctainsLowcase) {
                System.out.println("Does not contain required complexity.");
                return false;                
            }
        }
        if (bSpecial) {
            boolean bContainsSpecial = false;
            for (int i = 0; i < sResult.length(); i++) {
                for (int j = 0; j < cSpecial.length; j++) {
                    if (sResult.charAt(i) == cSpecial[j])
                        bContainsSpecial = true;
                }
            }
            if (!bContainsSpecial) {
                System.out.println("Does not contain required complexity.");
                return false;                
            }
        }
        if (bNumber) {
            boolean bContainsNumber = false;
            for (int i = 0; i < sResult.length(); i++) {
                for (int j = 0; j < cNumber.length; j++) {
                    if (sResult.charAt(i) == cNumber[j])
                        bContainsNumber = true;
                }
            }
            if (!bContainsNumber) {
                System.out.println("Does not contain required complexity.");
                return false;                
            }
        }
        System.out.println("Contains required complexity.");
        return true;
    }

    /**
     * This method keeps the general settings used by the password generator
     * for the method calls involved in generating and checking the password.
     * @return 
     */
    private String setOptions() {
        String sConcat = "";
        
        if (bLowcase) {
            for (int i = 0; i < cLowcase.length; i++) {
                sConcat += cLowcase[i];
            }
        }
        if (bUpcase) {
            for (int i = 0; i < cUpcase.length; i++) {
                sConcat += cUpcase[i];
            }
        }
        if (bSpecial) {
            for (int i = 0; i < cSpecial.length; i++) {
                sConcat += cSpecial[i];
            }
        }
        if (bNumber) {
            for (int i = 0; i < cNumber.length; i++) {
                sConcat += cNumber[i];
            }
        }
        return sConcat;
    }

} // End Subclass PWGenerator

/*
 (                         *     
 )\ )                    (  `    
(()/(  (   (   (  (  (   )\))(   
 /(_)) )\  )\  )\ )\ )\ ((_)()\  
(_))_ ((_)((_)((_|(_|(_)(_()((_) 
 |   \| __\ \ / / | | __|  \/  | 
 | |) | _| \ V / || | _|| |\/| | 
 |___/|___| \_/ \__/|___|_|  |_| 
      https://is.gd/RGR0UQ                  
*/