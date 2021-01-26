import java.util.Collections;
import java.util.List;

public class SubstituionCipher {
    String keySpace;
    String key;

    public SubstituionCipher(String keySpace) {
        this.keySpace = keySpace;
        
        char[] characters = keySpace.toCharArray();
        for (int i = 0; i < characters.length; i++) {
            int randomIndex = (int)(Math.random() * characters.length);
            char temp = characters[i];
            characters[i] = characters[randomIndex];
            characters[randomIndex] = temp;
        }
        
        this.key = String.valueOf(characters);
    }

    public String encrypt(String plaintext) {
        String cipherText = "";
        String plainText = plaintext.toLowerCase();
        
        for (int i = 0; i < plainText.length(); i++){
            for (int j = 0; j < keySpace.length(); j++){
                if (plainText.charAt(i) == keySpace.charAt(j)){
                    cipherText += key.charAt(j);
                }
            }
        }
        
        return cipherText;
    }

    public String decrypt(String ciphertext){
        String plaintext = "";

        return plaintext;
    }

    public String getKey(){
        return key;
    }
}

// abcdefghijklmnopqrstuvwxyz - keySpace
// dwblskmaghcejqyuzxintrpofv - Key

//plaintext - hello
//ciphertext - 