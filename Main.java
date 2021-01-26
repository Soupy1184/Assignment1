public class Main {
    public static void main(String[] args){
        String keySpace = "abcdefghijklmnopqrstuvwxyz";
        
        SubstituionCipher cipher1 = new SubstituionCipher(keySpace);
        System.out.println("Plaintext = Hello world, what a beautiful day.");

        System.out.println("abcdefghijklmnopqrstuvwxyz");
        System.out.println(cipher1.getKey());
        System.out.println(cipher1.encrypt("Hello"));

        
    }
}