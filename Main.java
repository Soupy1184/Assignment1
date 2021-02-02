public class Main {
    public static void main(String[] args){
        
        String encryptString;
        String decryptString;
        //plaintext taken from this source:
        //https://www.economist.com/leaders/2020/10/29/why-it-has-to-be-biden
        String plaintext = "It starts with America’s democratic culture. Tribal politics predated Mr Trump. The" +
        " host of “The Apprentice” exploited it to take himself from the green room to the White House. Yet, whereas" +
        " most recent presidents have seen toxic partisanship as bad for America, Mr Trump made it central to his office. " +
        "He has never sought to represent the majority of Americans who did not vote for him. Faced by an outpouring of " +
        "peaceful protest after the killing of George Floyd, his instinct was not to heal, but to depict it as an orgy of " +
        "looting and left-wing violence—part of a pattern of stoking racial tension. Today, 40% of the electorate believes " +
        "the other side is not just misguided, but evil. The most head-spinning feature of the Trump presidency is his contempt " + 
        "for the truth. All politicians prevaricate, but his administration has given America “alternative facts”. Nothing Mr " +
        "Trump says can be believed—including his claims that Mr Biden is corrupt. His cheerleaders in the Republican Party " +
        "feel obliged to defend him regardless, as they did in an impeachment that, bar one vote, went along party lines. " + 
        "Partisanship and lying undermine norms and institutions. That may sound fussy—Trump voters, after all, like his " +
        "willingness to offend. But America’s system of checks and balances suffers. This president calls for his opponents to " +
        "be locked up; he uses the Department of Justice to conduct vendettas; he commutes the sentences of supporters convicted " +
        "of serious crimes; he gives his family plum jobs in the White House; and he offers foreign governments protection in " +
        "exchange for dirt on a rival. When a president casts doubt on the integrity of an election just because it might help " +
        "him win, he undermines the democracy he has sworn to defend. Partisanship and lying also undermine policy. Look at " +
        "covid-19. Mr Trump had a chance to unite his country around a well organised response—and win re-election on the back " + 
        "of it, as other leaders have. Instead he saw Democratic governors as rivals or scapegoats. He muzzled and belittled " + 
        "America’s world-class institutions, such as the Centres for Disease Control and Prevention. As so often, he sneered at " + 
        "science, including over masks. And, unable to see beyond his own re-election, he has continued to misrepresent the evident " + 
        "truth about the epidemic and its consequences. America has many of the world’s best scientists. It also has one of world’s " + 
        "highest covid-19 fatality rates. Mr Trump has treated America’s allies with the same small-mindedness. Alliances magnify " + 
        "America’s influence in the world. The closest ones were forged during wars and, once unmade, cannot easily be put back " + 
        "together in peacetime. When countries that have fought alongside America look on his leadership, they struggle to " + 
        "recognise the place they admire. That matters. Americans are liable both to over- and to underestimate the influence " + 
        "they have in the world. American military power alone cannot transform foreign countries, as the long wars in Afghanistan " +
        "and Iraq proved. Yet American ideals really do serve as an example to other democracies, and to people who live in states " + 
        "that persecute their citizens. Mr Trump thinks ideals are for suckers. The governments of China and Russia have always seen " +
        "American rhetoric about freedom as cynical cover for the belief that might is right. Tragically, under Mr Trump their " +
        "suspicions have been confirmed. Four more years of a historically bad president like Mr Trump would deepen all these " +
        "harms—and more. In 2016 American voters did not know whom they were getting. Now they do. They would be voting for " + 
        "division and lying. They would be endorsing the trampling of norms and the shrinking of national institutions into " +
        "personal fiefs. They would be ushering in climate change that threatens not only distant lands but Florida, California " +
        "and America’s heartlands. They would be signalling that the champion of freedom and democracy for all should be just " +
        "another big country throwing its weight around. Re-election would put a democratic seal on all the harm Mr Trump has done.";   

        //Question #1 - Substitution Cipher
        System.out.println("SUBSTITUTION CIPHER");
        //Z29 keyspace
        String keySpace = "abcdefghijklmnopqrstuvwxyz ,.";
        //Creates a random permutation of the keyspace
        String substitutionKey = genRandomSubstituionKey(keySpace);
        
        //Creates a new substitution cipher object with the key and the keyspace
        SubstituionCipher cipher1 = new SubstituionCipher(substitutionKey, keySpace);

        //printing results
        System.out.printf("Key space: %s\n", keySpace);
        //getKey method just for the sake of the assignment
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
        //getEncryptionKey and getDecryptionKey for the sake of the assignment
        //so we can see the attack later on find the proper keys
        System.out.printf("Encryption Key: %s\n", cipher2.getEncryptionKey());
        System.out.printf("Decryption Key: %s\n", cipher2.getDecryptionKey());
        //print results
        encryptString = cipher2.encrypt(plaintext);
        System.out.println(encryptString);
        decryptString = cipher2.decrypt(encryptString);
        System.out.println(decryptString);

        System.out.println();

        // Question #3 - Permutation Attack
        System.out.println("PERMUTATION ATTACK");
        //creates a new PermutationAttack object with passing the ciphertext and the plaintext
        PermutationAttack attack1 = new PermutationAttack(encryptString, decryptString);
        //prints the length of the permutation
        System.out.printf("Value of m: %s\n", attack1.getPermutationM());
        //prints the key arrays
        System.out.printf("Encryption Key: %s\n", attack1.getEncryptionKey());
        System.out.printf("Decryption Key: %s\n", attack1.getDecryptionKey());
    }

    //generates the random permutation for the substitution cipher
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

    //gets a random number in a range
    private static int getRandomNumberInRange(int min, int max) {
        int result = (int) ((Math.random() * ((max - min) + 1)) + min);
        return result;
    }

    //generates the random key for the permutation cipher
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