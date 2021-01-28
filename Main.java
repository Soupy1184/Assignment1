public class Main {
    public static void main(String[] args){
        String keySpace = "abcdefghijklmnopqrstuvwxyz ,.";
        String key = "zkbvxgrlcpwhsautm.qyo,d jenif";
        //int[] subKey = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28};
        String encryptString;
        String decryptString;

        // //For random key use this code;
        // char[] characters = keySpace.toCharArray();
        // for (int i = 0; i < characters.length; i++) {
        //     int randomIndex = (int)(Math.random() * characters.length);
        //     char temp = characters[i];
        //     characters[i] = characters[randomIndex];
        //     characters[randomIndex] = temp;
        // }
        // key = String.valueOf(characters);

        //Question #1 - Substitution Cipher
        System.out.println("SUBSTITUTION CIPHER");
        SubstituionCipher cipher1 = new SubstituionCipher(key);
        System.out.println("Plaintext: Hello world, what a beautiful day.");

        System.out.printf("Key space: %s\n", keySpace);
        System.out.printf("Key: %s\n", cipher1.getKey());
        encryptString = cipher1.encrypt("Hello world, what a beautiful day.");
        System.out.printf("Encryption: %s\n", encryptString);
        decryptString = cipher1.decrypt(encryptString);
        System.out.printf("Decryption: %s\n", decryptString);
        
        System.out.println();

        //Question #2 - Permutation Cipher
        System.out.println("PERMUTATION CIPHER");

        int[] permKey = {3, 0, 2, 1, 4};

        PermutationCipher cipher2 = new PermutationCipher(permKey, permKey.length);
        System.out.printf("Encryption Key: %s\n", cipher2.getEncKey());
        System.out.printf("Decryption Key: %s\n", cipher2.getDecKey());
        encryptString = cipher2.encrypt("Hello world, what a beautiful day.");
        System.out.println(encryptString);
        decryptString = cipher2.decrypt(encryptString);
        System.out.println(decryptString);

    }
}