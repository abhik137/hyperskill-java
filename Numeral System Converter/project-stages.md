# Numeral System Converter

- [Numeral System Converter](#numeral-system-converter)
  - [Stage 1/6: For example](#stage-16-for-example)
    - [Description](#description)
    - [Example](#example)
  - [Stage 2/6: Almost an octopus](#stage-26-almost-an-octopus)
    - [Description](#description-1)
    - [Example](#example-1)
  - [Stage 3/6: Convert decimals](#stage-36-convert-decimals)
    - [Description](#description-2)
    - [Example](#example-2)
  - [Stage 4/6: Any which radix](#stage-46-any-which-radix)
    - [Description](#description-3)
    - [Example](#example-3)
  - [Stage 5/6:](#stage-56)
    - [Description](#description-4)
    - [Example](#example-4)
  - [Stage 6/6:](#stage-66)
    - [Description](#description-5)
    - [Example](#example-5)

## Stage 1/6: For example

### Description

In this project, you will be creating your own numeral system converter. If you don't know what a numeral system is, or simply need to brush up on the topic, browse through the relevant [Wikipedia](https://en.wikipedia.org/wiki/Numeral_system) page. Also, there is a [great Youtube video](https://www.youtube.com/watch?v=L2zsmYaI5ww) that explains various numeral systems and the relationship between them.

Implement a program that outputs a number in two systems: the first is decimal, and the second one is binary. This must be the same number represented in different systems; feel free to choose any number you like.

This stage is auto-graded. The grader will check that:

- you output a single line;
- there are two numbers;
- the first number is decimal;
- the second number is binary (it starts with 0b and contains only 0 and 1);
- the first number is equal to the second one.

Note that you do not need to enter anything into the program, you should print a line prepared in advance. A single String is expected to be printed.

### Example

Example 1:

```text
10 = 0b1010
```

Example 2:

```text
2 is equal to 0b10
```

## Stage 2/6: Almost an octopus

### Description

Implement a program that calculates **the last digit** of the given number converted to base 8.

This stage is auto-graded. The grader will **input a number** in base 10, and then check that your program **output** matches the correct answer.

### Example

Example 1

Input:
```text
8
```

Output:

```text
0
```

Example 2

Input:
```text
9
```

Output:

```text
1
```

## Stage 3/6: Convert decimals

### Description

Now let's implement a simple converter. It will convert the given decimal number to the given [radix](https://en.wikipedia.org/wiki/Radix). You should support three radices with prefixes:

- binary (`0b`);
- octal (`0`);
- hexadecimal (`0x`).

To get a string with the answer, use the `Long.toString(sourceNumber, destinationRadix)` expression. Note that the expected output is a String, because Java implicitly converts 0/0b/0x concatenated numbers to their decimal representation.

This stage is auto-graded. The grader will **input two lines** (a number and a radix) and check that your output is the correct number representation in the given radix. Don't forget about the prefix!

### Example

Example 1:

Input:

```text
8
16
```

Output:

```text
0x8
```

Example 2:

Input:

```text
101
2
```

Output:

```text
0b1100101
```

Example 3:

Input:

```text
103
8
```

Output:

```text
0147
```

## Stage 4/6: Any which radix

### Description

### Example

## Stage 5/6:

### Description

### Example

## Stage 6/6:

### Description

### Example