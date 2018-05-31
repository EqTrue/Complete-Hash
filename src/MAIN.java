public class MAIN {
    public static final int BIT_LEN = 1;
    public static void main(String[] args) {
        char[] key = new char[BIT_LEN];
        for (int i = 0; i < BIT_LEN; i++) key[i] = '0';
        while (true) {
            System.out.println(key);
            increment(key);
        }
    }
    private static char[] increment(char[] key) { return increment(key, 0); }
    private static char[] increment(char[] key, int index) {
        key[index] = (char) (++key[index] % 91);
        if (key[index] == 58) key[index] = (char) (key[index] + 7);
        if (key[index] == 0) {
            key[index] = '0';
            increment(key, (++index) % BIT_LEN);)
        }
        return key;
    }
}