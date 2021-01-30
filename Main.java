public class Main {
    public static void main(String[] args){
        
        String encryptString;
        String decryptString;
        String plaintext = "Hello world, what a beautiful day.";   

        //Question #1 - Substitution Cipher
        System.out.println("SUBSTITUTION CIPHER");
        String keySpace = "abcdefghijklmnopqrstuvwxyz ,.";
        String substitutionKey = genRandomSubstituionKey(keySpace);
 
        SubstituionCipher cipher1 = new SubstituionCipher(substitutionKey, keySpace);
        System.out.println("Plaintext: Hello world, what a beautiful day.");

        System.out.printf("Key space: %s\n", keySpace);
        System.out.printf("Key: %s\n", cipher1.getKey());
        encryptString = cipher1.encrypt(plaintext);
        System.out.printf("Encryption: %s\n", encryptString);
        decryptString = cipher1.decrypt(encryptString);
        System.out.printf("Decryption: %s\n", decryptString);

        System.out.println();

        // Question #2 - Permutation Cipher
        System.out.println("PERMUTATION CIPHER");
        int m = getRandomNumberInRange(3, 7);
        int[] permKey = new int[m];
        permKey =  genRandomPermutationKey(m);

        PermutationCipher cipher2 = new PermutationCipher(permKey, m);
        System.out.printf("Encryption Key: %s\n", cipher2.getEncryptionKey());
        System.out.printf("Decryption Key: %s\n", cipher2.getDecryptionKey());
        encryptString = cipher2.encrypt(plaintext);
        System.out.println(encryptString);
        decryptString = cipher2.decrypt(encryptString);
        System.out.println(decryptString);

        System.out.println();

        // Question #3 - Permutation Attack
        System.out.println("PERMUTATION ATTACK");
        //String ciphertext = cipher2.encrypt(plaintext);

        PermutationAttack attack1 = new PermutationAttack(encryptString, decryptString);
        System.out.printf("Value of m: %s\n", attack1.getPermutationM());
        System.out.printf("Encryption Key: %s\n", attack1.getPermutationKey());
    }

    public static String genRandomSubstituionKey(String keySpace) {
        char[] c = keySpace.toCharArray();

        for (int i = 0; i < c.length; i++) {
            int rand = (int)(Math.random() * c.length);
            char temp = c[i];
            c[i] = c[rand];
            c[rand] = temp;
        }

        return String.valueOf(c);
    }

    private static int getRandomNumberInRange(int min, int max) {
        int result = (int) ((Math.random() * ((max - min) + 1)) + min);
        return result;
    }

    public static int[] genRandomPermutationKey(int m){
        int[] tempArray = new int[m];

        for (int i = 0; i < m; i++){
            tempArray[i] = i;
        }

        for (int i = 0; i < tempArray.length; i++) {
            int rand = (int)(Math.random() * tempArray.length);
            int temp = tempArray[i];
            tempArray[i] = tempArray[rand];
            tempArray[rand] = temp;
        }
        return tempArray;
    }
    
}