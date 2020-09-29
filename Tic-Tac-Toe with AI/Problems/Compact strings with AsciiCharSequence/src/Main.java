import java.nio.charset.StandardCharsets;
import java.util.*;

class AsciiCharSequence implements CharSequence {

    private final byte[] seq;

    public AsciiCharSequence(byte[] seq) {
        // defensive copying, safeguarding against mutation of orig array passed in
        this.seq = Arrays.copyOf(seq, seq.length);
    }

    @Override
    public int length() {
        return seq.length;
    }

    @Override
    public char charAt(int index) {
        return (char) seq[index];
    }

    @Override
    public CharSequence subSequence(int start, int end) {
        // byte[] subSeq = new byte[end - start];
        // 1
        // for (int i = start, subIndex = 0; i < end; i++, subIndex++) {
        //     subSeq[subIndex] = value[i];
        // }

        // 2
        // System.arraycopy(seq, start, subSeq, 0, end - start); // equivalent to for loop, may be more efficient

        // 3
        byte[] subSeq = Arrays.copyOfRange(seq, start, end);
        return new AsciiCharSequence(subSeq);
    }

    @Override
    public String toString() {
        // return new String(value);    // this works too
        return new String(seq, StandardCharsets.UTF_8);
    }

    public byte[] getSequence() {
        return Arrays.copyOf(seq, seq.length);  // defensive copying, not exposing orig sequence to mutation
    }

    // public static void main(String[] args) {
    //     byte[] arr = new byte[] {'A', 'a', ' ', 'S', 't', 'r', 'i', 'n', 'g', 's', '!'};
    //     AsciiCharSequence seq = new AsciiCharSequence(arr);
    //     System.out.println(Arrays.toString(seq.getSequence()));
    //     System.out.println(seq.toString());
    //     System.out.println(seq.length());
    //     for (int i = 0; i < seq.length(); i++) {
    //         System.out.println(seq.charAt(i));
    //     }
    //     System.out.println(seq.subSequence(3, 11));
    // }
}
/* ref
 * https://stackoverflow.com/questions/17912640/byte-and-char-conversion-in-java/17912706
 * https://www.baeldung.com/java-9-compact-string
 * https://www.programiz.com/java-programming/copy-arrays
 * https://www.baeldung.com/java-char-sequence-string
 * https://www.baeldung.com/java-type-casting
 * https://docs.oracle.com/javase/tutorial/java/nutsandbolts/datatypes.html
 */