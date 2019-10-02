# Project 3 - CryptoManager
Third project of the semester. All files in this directory were provided by the professor, the only file changed was CryptoManager.java.

Goal was to complete the skeleton class in CryptoManager.java.

# Project Outline
```
    • Implement each of the methods specified in this file.  This version as provided will print error messages in the console, because they are just the skeletons. Remove the line that starts with “throw ….” when you implement each method.
    • Each of the methods are static, so there is no need to create an instance of the CryptoManager class. We will cover static methods later in the course but for now it just means that you can call a method of this class as follows: CryptoManager.stringInBounds() .
    • Document each of your methods with a simple description and document the class with a simple description and your name using in-line comments (//…). (Just a short sentence fragment will suffice for each documentation string.)
    • The methods are described below.
    • public static boolean stringInBounds (String plainText);
	This method determines if a string is within the allowable bounds of ASCII codes according to the LOWER_BOUND and UPPER_BOUND characters.  The parameter plainText is the string to be encrypted.  The method returns true if all characters are within the allowable bounds, false if any character is outside. Refer to Assignment Detail section for more details.
    • public static String encryptCaesar(String plainText, int key); 
This method encrypts a string according to the Caesar Cipher.  The integer key specifies an offset and each character in plainText is replaced by the character the specified distance away from it.  The parameter plainText is an uppercase string to be encrypted. The parameter key is an integer that specifies the offset of each character.  The method returns the encrypted string.
    • public static String decryptCaesar(String encryptedText, int key);
This method decrypts a string according to the Caesar Cipher.  The integer key specifies an offset and each character in encryptedText is replaced by the character "offset" characters before it.  This is the inverse of the encryptCaesar method.  The parameter encryptedText is the encrypted string to be decrypted, and key is the integer used to encrypt the original text.  The method returns the original plain text string.
    • public static String encryptBellaso(String plainText, String bellasoStr);
This method encrypts a string according to the Bellaso Cipher.  Each character in plainText is offset according to the ASCII value of the corresponding character in bellasoStr, which is repeated to correspond to the length of plaintext. The method returns the encrypted string.
    • public static String decryptBellaso(String encryptedText, String bellasoStr);
This method decrypts a string according to the Bellaso Cipher.  Each character in encryptedText is replaced by the character corresponding to the character in bellasoStr, which is repeated to correspond to the length of plainText.  This is the inverse of the encryptBellaso method. The parameter encryptedText is the encrypted string to be decrypted, and bellasoStr is the string used to encrypt the original text.  The method returns the original plain text string.
    • Add additional methods if you wish to make your logic easier to follow.
```

# Notes
If you struggle with running the CryptoManagerTest.java, you will need to import the test utilities into your eclipse project workspace. Everything else should be easy to implement.
