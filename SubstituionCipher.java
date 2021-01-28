public class SubstituionCipher {
    String keySpace;
    String key;

    public SubstituionCipher(String key, String keySpace) {
        this.key = key;
        this.keySpace = keySpace;
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