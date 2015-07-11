Number of trailing zeroes in a factorial of a number.

https://leetcode.com/problems/factorial-trailing-zeroes/

In the factorial of a number every factor of 5 will add a zero. Because multiple of 5 with an even number gives a zero.

So for example for 100!

There would be 20 numbers which have a factor 5. 100/5 = 20

But there are other numbers like 25, 75, 50, 100 which have factors of 25 and add another 5.

So another 4 will come which have 25 as factor giving another set of 5. 100/25 = 4

So total number of zeroes is 24.

This can be done in log(base 5) steps.

Just take a exponentials of 5 and divide n till n is smaller than 5^x, where x would be the number of steps.

Note:
-----
Exponential of steps can easily overflow if it is made as an integer and n is close to 2^32 which is close to 4 * 10^9. So make that as an integer.