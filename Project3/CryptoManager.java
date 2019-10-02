

public class CryptoManager {
	
	private static final char LOWER_BOUND = ' ';
	private static final char UPPER_BOUND = '_';
	private static final int RANGE = UPPER_BOUND - LOWER_BOUND + 1;

	/**
	 * This method determines if a string is within the allowable bounds of ASCII codes 
	 * according to the LOWER_BOUND and UPPER_BOUND characters
	 * @param plainText a string to be encrypted, if it is within the allowable bounds
	 * @return true if all characters are within the allowable bounds, false if any character is outside
	 */
	// Author: Alec Mattu
	// Description: Takes a string as input and determines whether the string is capable of being encrypted. 
	public static boolean stringInBounds (String plainText) {
		// Variables
		boolean isValid = true;
		
		// Loops
		for (int i = 0; i < plainText.length(); i++) {
			// Variables
			char c = plainText.charAt(i);
			
			// Checks
			if (c < LOWER_BOUND || c > UPPER_BOUND) {
				isValid = false;
			}
		}
		
		// Return
		return isValid;
	}

	/**
	 * Encrypts a string according to the Caesar Cipher.  The integer key specifies an offset
	 * and each character in plainText is replaced by the character \"offset\" away from it 
	 * @param plainText an uppercase string to be encrypted.
	 * @param key an integer that specifies the offset of each character
	 * @return the encrypted string
	 */
	// Author: Alec Mattu
	// Description: Encrypts a given string using the provided key utilizing Caesar Cipher methods.	
	public static String encryptCaesar(String plainText, int key) {
		// Checks
		if (!stringInBounds(plainText)) { return ""; } // If the string is not in bounds, return a empty string
		//if (plainText.length() <= 0) { return ""; }
		
		// Variables
		String encrypted = ""; // Encrypted string, to be built, char by char
		
		// Loops
		for (int i = 0; i < plainText.length(); i++) {
			// Variables
			char c = plainText.charAt(i); // Decrypted character at index i of string plainText
			int ec = (int)c + key;
			
			// Loops
			while (ec > UPPER_BOUND) { ec -= RANGE; }
			
			// Append to string
			encrypted += (char) ec;
		}
		
		// Return
		return encrypted;
	}
	
	/**
	 * Encrypts a string according the Bellaso Cipher.  Each character in plainText is offset 
	 * according to the ASCII value of the corresponding character in bellasoStr, which is repeated
	 * to correspond to the length of plainText
	 * @param plainText an uppercase string to be encrypted.
	 * @param bellasoStr an uppercase string that specifies the offsets, character by character.
	 * @return the encrypted string
	 */
	// Author: Alec Mattu
	// Description: Encrpyts a given string using Bellaso Cipher methods.
	public static String encryptBellaso(String plainText, String bellasoStr) {
		// Variables
		String encrypted = ""; // Encrypted string, needs to be built character by character
		int bl = bellasoStr.length(); // Belasso string length
		int ub = (int) UPPER_BOUND; // Upper bound character turned into index int
		
		// Loops
		for (int i = 0; i < plainText.length(); i++) {
			// Variables
			char c = plainText.charAt(i);
			int ec = (int)c + (int)bellasoStr.charAt(i % bl);
			
			// Loops
			while (ec > ub) { ec -= RANGE; }
			
			// Append to string
			encrypted += (char) ec;
		}
		
		// Return
		return encrypted;
	}
	
	/**
	 * Decrypts a string according to the Caesar Cipher.  The integer key specifies an offset
	 * and each character in encryptedText is replaced by the character \"offset\" characters before it.
	 * This is the inverse of the encryptCaesar method.
	 * @param encryptedText an encrypted string to be decrypted.
	 * @param key an integer that specifies the offset of each character
	 * @return the plain text string
	 */
	// Author: Alec Mattu
	// Description: Decrypt a given string that was previously encrypted using Caesar methods
	public static String decryptCaesar(String encryptedText, int key) {
		// Variables
		String decrypted = ""; // Decrypted text string, needs to be built character by character
		
		// Loops
		for (int i = 0; i < encryptedText.length(); i++) {
			char c = encryptedText.charAt(i); // Encrypted character at index i of string encryptedText
			int dc = (int)c - key;
			
			// Loops
			while (dc < LOWER_BOUND) { dc += RANGE; }
			
			// Append to string
			decrypted += (char) dc;
		}
		
		// Return
		return decrypted;
	}
	
	/**
	 * Decrypts a string according the Bellaso Cipher.  Each character in encryptedText is replaced by
	 * the character corresponding to the character in bellasoStr, which is repeated
	 * to correspond to the length of plainText.  This is the inverse of the encryptBellaso method.
	 * @param encryptedText an uppercase string to be encrypted.
	 * @param bellasoStr an uppercase string that specifies the offsets, character by character.
	 * @return the decrypted string
	 */
	// Author: Alec Mattu
	// Description: Decrypts a given string that was previously encrypted using Bellaso methods.
	public static String decryptBellaso(String encryptedText, String bellasoStr) {
		// Variables
		String decrypted = ""; // To be built, char by char
		int bl = bellasoStr.length(); // Bellaso string length
		int lb = (int) LOWER_BOUND; // Lower bound converted to index int
		
		// Loops
		for (int i = 0; i < encryptedText.length(); i++) {
			// Variables
			char c = encryptedText.charAt(i); // Decrypt character at index i of string encryptedText
			int dc = (int)c - (int)bellasoStr.charAt(i % bl);
			
			// Loops
			while (dc < lb) { dc += RANGE; }
			
			// Append to string
			decrypted += (char) dc;
		}
		
		// Return
		return decrypted;
	}
}
