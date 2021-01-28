import java.util.Arrays;

public class PermutationAttack {
    String ciphertext;
    String plaintext;

    public PermutationAttack(String ciphertext, String plaintext){
        this.ciphertext = ciphertext;
        this.plaintext = plaintext;
    }

    public String getPermutationKey(){

        return "";
    }

    public String getPermutationM(){

        return "";
    }

    //Method grabbed from this source: 
    //https://www.geeksforgeeks.org/sort-a-string-in-java-2-different-ways/
    // Method to sort a string alphabetically 
    public static String sortString(String inputString) 
    { 
        // convert input string to char array 
        char tempArray[] = inputString.toCharArray(); 
          
        // sort tempArray 
        Arrays.sort(tempArray); 
          
        // return new sorted string 
        return new String(tempArray); 
    }
}
