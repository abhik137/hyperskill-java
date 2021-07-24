# Numeral System Converter

- [Numeral System Converter](#numeral-system-converter)
  - [Stage 1/6: For example](#stage-16-for-example)
    - [Description](#description)
    - [Example](#example)
  - [Stage 2/6: Almost an octopus](#stage-26-almost-an-octopus)
    - [Description](#description-1)
    - [Examples](#examples)
  - [Stage 3/6: Convert decimals](#stage-36-convert-decimals)
    - [Description](#description-2)
    - [Examples](#examples-1)
  - [Stage 4/6: Any which radix](#stage-46-any-which-radix)
    - [Description](#description-3)
    - [Algorithm](#algorithm)
    - [Examples](#examples-2)
  - [Stage 5/6: Converting fractions](#stage-56-converting-fractions)
    - [Description](#description-4)
    - [Algorithm](#algorithm-1)
    - [Examples](#examples-3)
  - [Stage 6/6: Error!](#stage-66-error)
    - [Description](#description-5)
    - [Examples](#examples-4)

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

### Examples

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

### Examples

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

In this stage, you should add support for reading the source number in the given base and converting it to another given base.

### Algorithm

As there are 26 Latin letters and 10 digits, the maximum base is 26 + 10 = 36.

To convert a number from the source base to the target base, take the following steps:

- If the given number is not decimal, you can convert it to a decimal using the method `Integer.parseInt(number, sourceBase)` that returns a decimal representation of a number.
- After that, you can use the method `Integer.toString(decimalNumber, newBase)` that takes a decimal number and converts it to the target base.

Note that the minimum radix is 1: the number `N` in radix 1 contains the symbol `1` N times. The methods described above don’t work if `sourceBase` or `newBase` equal to 1. In that case, you should convert the numbers manually.

For instance:

$$111111_1 = 6_{10} \\​	3_{10} = 111_1$$

This stage is auto-graded. The grader will input three lines:

- The source radix;
- The source number;
- The target radix.

Then, it will check that your output contains the correct number representation in the given radix. This time, don't use prefixes now.

### Examples

Example 1:

Input:

```text
10
11
2
```

Output:

```text
1011
```

Example 2:

Input:

```text
1
11111
10
```

Output:

```text
5
```

Example 3:

Input:

```text
10
4
1
```

Output:

```text
1111
```

Example 4:

Input:

```text
10
1001
36
```

Output:

```text
rt
```

## Stage 5/6: Converting fractions

### Description

Fractional numbers can also be converted from one base to another. To convert a fractional number to another base, you should use the algorithm described below.

### Algorithm

As you know from the previous stage, in order to convert a number from one base to another, first, we need to convert it to decimal if it’s not decimal yet, and only then convert it to another base. The same applies to fractional numbers.

Let’s imagine you have a fractional number $ab.cdef$ where $ab$ is the integer part, $cdef$ is the fractional part, and $a,b,c,d,e,f$ are some digits or literals, depending on the base of the number.

In this case, we have 2 digits (letters) in the integer part and 4 digits (literals) in the fractional part. In other cases, the number of digits (literals) in parts can be different.

To convert the number into decimal, we need to:

- Split the number into two parts: integer and fractional;
- Convert the integer part into decimal using the method from the previous stage;
- Convert the fractional part into decimal using the following formula:
$$decimalValue = {c \over base^1} + {d \over base^2} + {e \over base^3} + {f \over base^4}$$

The more digits (literals) in the fractional part, the more addends in the formula. If the fractional part has letters, then you should use their number representation: ‘a’ – 10, ‘b’ – 11, c – ‘12’, and so on.

As a result, you should get a decimal number no greater than 1. If it is greater than 1, you did something wrong.

To see the decimal representation of the source number, you can sum the decimal integer and the decimal fractional parts.

To convert a decimal fractional number into any other base, we need to:

- Split the decimal number into two parts: integer and fractional;
- Convert the integer part into the new base;
- Convert the fractional part from decimal to any other base.

Let’s elaborate on the third step and convert the fractional part of 0.5168 into base 19 as an example.

Multiply the fractional part by the new base: $0.5168∗19=9.8192$. The integer part of the result is the first digit (or letter if the integer part is greater than 9) in the fractional part of a number in the new base. In this case, the first digit in the fractional part is $9$.

Take the fractional part from the result of the multiplication and multiply it by the new base again: $0.8192∗19=15.5648$. For numbers greater than 9, you should use their literal representation: 10 – ‘a’, 11 – ‘b’, 12 – ‘c’, and so on. In this case, the second digit (literal) is **f (15)**.

To calculate the rest of the digits (literals), repeat this action. In this stage, your program should output only 5 digits (literals) in the fractional part:

$$
0.5648 * 19 = 10.7312 \text{ (a)}\\ 0.7312 * 19 = 13.8928 \text{ (d)}\\ 0.8928 * 19 = 16.9632 \text{ (g)}
$$

The final result looks like this: $0.5168_{₁₀} = 0.9fadg_{₁₉}$

Example 1:

$0.234_{10}$ to base 7.

1. $0.234 \cdot 7 = 1.638$: the first fraction symbol is 1.
2. Remove integer part. $0.638 \cdot 7 = 4.466$: the second fraction symbol is 4.
3. Remove integer part. $0.466 \cdot 7 = 3.262$: the third fraction symbol is 3.
4. The same for the next symbols.

So, the number in base 7 is $0.143..._7$

Example 2:

$0.234_{10}$ to base 36.

- $0.234 \cdot 36 = 8.424$: the first fraction symbol is 8.
- $0.424 \cdot 36 = 15.264$: the second fraction symbol is '15' and 'f' in base 36.
- $0.264 \cdot 36 = 9.504$: the third fraction symbol is 9.

So, the number in base 36 is $0.8f9..._{36}$

Example 3:

$0.234_{7}$ to base 36.

- Convert the fractional part to base 10 using the formula above: $2 / 7 + 3 / 49 + 4 / 343 = 0.358..._{10}$
- Convert this number to base 36 like in example 2.

This stage is auto-graded. The grader will input three lines: the source radix, the source number, and the target radix. Then it will check that your output is the correct number representation in the given radix. Don't forget to round up the result to 5 decimal places! If there is no fractional part in the initial number, you don't need to show the fractional part.

Also, numbers in radix 1 cannot have a fractional part so they're tested only as the integer part, like it was in the previous stage.

### Examples

Example 1:

Input:

```10
0.234
7
```

Output:
```
0.14315
```

Example 2:

Input:
```
10
10.234
7
```
Output:
```
13.14315
```

Example 3:

Input:

```35
af.xy
17
```

Output:
```
148.g88a8
```

Example 4:

Input:
```
16
aaaaa.0
24
```

Output:
```
22df2.00000
```

Example 5:

Input:
```
21
4242
6
```

Output:
```
451552
```

Example 6:

Input:
```
1
1111111
10
```

Output:

```
7
```
## Stage 6/6: Error!

### Description

Let's face it: errors happen. What if someone enters a wrong radix? What if the input number is impossible to convert to the given radix? What if the number is not a number at all?

In this final stage, we will make sure the program can handle errors like that. At this point, you can implement this without the try catch construction. Use the following rule of thumb: if you can avoid exception-based logic, avoid it!

So, the goal here is to implement error messages when the input is wrong.

This stage is auto-graded. The grader will input some data. Then it will check that the last line of your program output contains the word "error" if the input is wrong.

If the input is correct, your program should behave as in the previous stage.

### Examples