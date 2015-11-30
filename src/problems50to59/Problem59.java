package problems50to59;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

// Question -----------------------------------------------------------------------------------------------------------
//  Each character on a computer is assigned a unique code and the preferred standard is ASCII (American Standard Code
//  for Information Interchange). For example, uppercase A = 65, asterisk (*) = 42, and lowercase k = 107.
//
//  A modern encryption method is to take a text file, convert the bytes to ASCII, then XOR each byte with a given
//  value, taken from a secret key. The advantage with the XOR function is that using the same encryption key on the
//  cipher text, restores the plain text; for example, 65 XOR 42 = 107, then 107 XOR 42 = 65.
//
//  For unbreakable encryption, the key is the same length as the plain text message, and the key is made up of random
//  bytes. The user would keep the encrypted message and the encryption key in different locations, and without both
//  "halves", it is impossible to decrypt the message.
//
//  Unfortunately, this method is impractical for most users, so the modified method is to use a password as a key. If
//  the password is shorter than the message, which is likely, the key is repeated cyclically throughout the message.
//  The balance for this method is using a sufficiently long password key for security, but short enough to be memorable.
//
//  Your task has been made easy, as the encryption key consists of three lower case characters. Using cipher.txt
//  (right click and 'Save Link/Target As...'), a file containing the encrypted ASCII codes, and the knowledge that the
//  plain text must contain common English words, decrypt the message and find the sum of the ASCII values in the
//  original text.
// --------------------------------------------------------------------------------------------------------------------
// Solution correct

public class Problem59 {

    public static void main(String[] args) throws IOException {

        // Get encrypted data
        String[] data = new String[]{};
        BufferedReader inputStream = new BufferedReader(new FileReader("Problem59InputFile"));
        try {
            String line;
            while ((line = inputStream.readLine()) != null) {
                data = line.split(",");
            }
        } finally {
            // This finally block making sure that the inputStream closes no matter what
            inputStream.close();
        }

        // Try all possible encryption keys until one of the results contains a few common english words.
        outside:
        for (char i = 'a'; i <= 'z'; i++) {
            for (char j = 'a'; j <= 'z'; j++) {
                for (char k = 'a'; k <= 'z'; k++) {
                    char[] decrypted = decrypt(data, i, j, k);
                    if (hasEnglishWords(decrypted)) {
                        System.out.println(decrypted);              // print message
                        System.out.println(sumOfAscII(decrypted));  // print sum of ASCII values of message
                        break outside;
                    }
                }
            }
        }
    }

    // (char[]) --> int
    // Returns the sum of all the characters in the array (uses ASCII to get each char's value)
    private static int sumOfAscII(char[] decrypted) {
        int total = 0;
        for (int i = 0; i < decrypted.length; i++) {
            total += decrypted[i];
        }
        return total;
    }

    // (char[]) --> boolean
    // Returns true if the char[] has 3 common english words, "the", "and", and "with"
    private static boolean hasEnglishWords(char[] decrypted) {
        String message = new String(decrypted);
        return message.contains("the") &&
                message.contains("and") &&
                message.contains("with");
    }

    // (String[] char char char) --> char[]
    // Goes through the data and decrypts it using XOR with the values i , j , and k. It starts with i and it cycles
    // between i , j , and k. (as mentioned in the problem statement at the top of the file)
    private static char[] decrypt(String[] data, char i, char j, char k) {
        char[] decrypted = new char[data.length];
        int turn = 1;
        for (int index = 0; index < data.length; index++) {
            if (turn == 1) {
                decrypted[index] = (char) (Integer.valueOf(data[index]) ^ i);
                turn++;
            } else if (turn == 2) {
                decrypted[index] = (char) (Integer.valueOf(data[index]) ^ j);
                turn++;
            } else {
                decrypted[index] = (char) (Integer.valueOf(data[index]) ^ k);
                turn = 1;
            }
        }
        return decrypted;
    }
}