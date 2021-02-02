public class SubstituionCipher {
    String keySpace;
    String key;

    public SubstituionCipher(String key, String keySpace) {
        this.key = key;
        this.keySpace = keySpace;
    }

    //encrypts plaintext into ciphertext
    public String encrypt(String plaintext) {
        String cipherText = "";
        String plainText = plaintext.toLowerCase();

        //replaces characters outside the keyspace given in the assignment with a space
        String replaceString = plainText.replace('"', ' ');
        replaceString = replaceString.replace('-', ' ');
        replaceString = replaceString.replace('\'', ' ');
        replaceString = replaceString.replace('%', ' ');
        replaceString = replaceString.replace('1', ' ');
        replaceString = replaceString.replace('2', ' ');
        replaceString = replaceString.replace('3', ' ');
        replaceString = replaceString.replace('4', ' ');
        replaceString = replaceString.replace('5', ' ');
        replaceString = replaceString.replace('6', ' ');
        replaceString = replaceString.replace('7', ' ');
        replaceString = replaceString.replace('8', ' ');
        replaceString = replaceString.replace('9', ' ');
        replaceString = replaceString.replace('0', ' ');
        plainText = replaceString;

        for (int i = 0; i < plainText.length(); i++){
            for (int j = 0; j < keySpace.length(); j++){
                if (plainText.charAt(i) == keySpace.charAt(j)){
                    cipherText += key.charAt(j);
                }
            }
        }
        
        return cipherText;
    }

    //decrypts cipher text into plaintext
    public String decrypt(String ciphertext){
        String plainText = "";
        String cipherText = ciphertext.toLowerCase();

        for (int i = 0; i < cipherText.length(); i++){
            for (int j = 0; j < key.length(); j++){
                if (cipherText.charAt(i) == key.charAt(j)){
                    plainText += keySpace.charAt(j);
                }
            }
        }

        return plainText;
    }

    public String getKey(){
        return key;
    }
}