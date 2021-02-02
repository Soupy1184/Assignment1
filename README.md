# Assignment1
School assignemnt to encrypt and decrypt text using a Substitution Cipher and a Permutation Cipher written in Java.

Substitution ciphers object receives a key space of letters, and a random permutation of the key space as a key. 

Permutation cipher object receives an integer array and the size of the integer array.

The last section of the assignment is to attack the permutation cipher with a known plaintext and ciphertext attack. 

The attacks first loop sets a potential size of the array (m). It then moves on to splitting the ciphertext and plaintext into a list of strings of size m. It then sorts each string in the list and loops through checking the hamming distance. If a loop makes it all the way through with a hamming distance of 0 then the size m is found and the loops are exited. 

The next step checks the list of strings for any duplicate characters and attempts to find a string within the list of string with no duplicates. 

The last step uses two for loops to place the matching letters into the proper positions in the array to find the decryption key.

Lastly, the attack uses an inverse permutation function using the decryption to find the encryption key. 
