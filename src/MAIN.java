/*
Warning, even super spec'd Gaming PC's will take a long time to loop an 8-bit HASH. Try it out, then imagine 256.
 */
public class MAIN {

    public static final int BIT_LEN = 1; // Change this value to your liking

    /*
    MAIN
     */
    public static void main(String[] args) {
        char[] key = new char[BIT_LEN];
        for (int i = 0; i < BIT_LEN; i++) key[i] = '0'; // Initialize

        /*
        Will continue from 00...0 after ZZ...Z is reached
         */
        while (true) {
            System.out.println(key);
            increment(key);
        }

    }

    /*
    Wrapper, so to allow passing of index with recursive call
     */
    private static char[] increment(char[] key) {
        return increment(key, 0);
    }

    /*
    Increments value at certain index. Values are from 0-Z, base 36 counting.
    it is set up to go from 001... to 101... rather than 002...
     */
    private static char[] increment(char[] key, int index) {
        key[index] = (char) (++key[index] % 91); // Initial Increment

        /* CASE 1
        There are 7 characters in between char 0 and A that are not part of the HASH value.
        These values are: : ; < = > ? `
         */
        if (key[index] == 58) key[index] = (char) (key[index] + 7);

        /* CASE 2
        If the char at index has been looped
         */
        if (key[index] == 0) {
            key[index] = '0';
            increment(key, (++index) % BIT_LEN); // Increment next bit (RECURSIVE)
        }

        return key; // To be printed
    }

}
