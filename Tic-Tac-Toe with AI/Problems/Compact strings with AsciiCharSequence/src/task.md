Write a class named `AsciiCharSequence` that implements compact storage of ASCII-character sequences. Their codes can be stored in one single byte, unlike Unicode characters. Compared to the standard `String` class, your class will require half the memory (before Java 9).

The class `AsciiCharSequence` should:

implement the interface `java.lang.CharSequence`;
have a constructor that takes a byte array;
define methods `length`, `charAt`, `subSequence`, and `toString`.
You can find the declaration of methods and their behavior in the description of `java.lang.CharSequence` (JavaDoc or sources). Carefully check signatures of abstract methods of `java.lang.CharSequence` interface, especially `subSequence` method. It accepts 2 integers: start index (inclusive) and end index (!exclusive). The method returns an object of a class that implements `java.lang.CharSequence` interface. For example, it can be an instance of `AsciiCharSequence` class.

Note: the testing system will always pass correct input parameters to overridden methods.

P.S. The feature is supported since Java 9 in standard strings. For details, see this [article](https://www.baeldung.com/java-9-compact-string) on compact strings in Java 9.