Ok so this problem is really good, I solved this problem myself, but took
a lot of time around 3hrs on leetcode.
I came up with n ^ 3 solution to this problem there is an n^2 solution, have to look into that.

It is easy to make a mistake in the solution. I will tell where in the solution.

Approach:
The first part is easy to think of using DP and then coming up with two matrices
1. RowMatrix For every i,j check if i - 1 , j is 1 if yes then RowMatrix[i][j] = 1 + RowMatrix[i - 1][j]
2. Similarly for ColMatrix for every i, j check if the j - 1 is 1 if yes then ColMatrix[i][j] = 1 + ColMatrix[i][j - 1]

Now once you get these two matrices for all i , j.
It is easy to fall into the trap that the area at [i][j] is RowMatrix[i][j] * ColMatrix[i][j]

Which it is not, consider this case
```
[ [0 1] ,
  [1 1] ]
```
 will Generate rowMatrix and colMatrix as

```
rm = [ [0 1] ,
       [1 2] ]
cm = [ [0 1] ,
       [1 2] ]
```
Which gives the area as 4 for [1][1] and that is incorrect.

So here comes the tricky part of the problem.

To get the intuition for this part, stack books on your table of various width.
Now if you want to get the maximum area from lowest book, these books are making considering each book is 1 unit thick.
What you will do is you will start from lets say the lowest book and take it's width as the min width till now area is 1(book) * width
Now you go up if the book above is shorter in width, then you take the min of width of the two books and you get an area of 2 * min width.
You go up till you don't have any book on the top, and you will get the maximum area.

Same approach is applied here, one time going up and the other time going on the left of the element [i][j]

When you are going up j colMatrix is actually giving you number of consecutive 1's above current row, which can think of the width of the book.
So you go till you reach the end of the matrix or you hit a 0 in colMatrix.
And the area would be calculated as K(times you go up) * min(colMatrx[i to i - k])

Similarly you go on left of [i][j], taking the books analogy it is books stack side to side on table and now you are considering length of books.
This is given by the rowMatrix

Area at [i][j] would be maximum of either of these areas.

Now after calculating the area at every [i][j] calculating maximum area for whole matrix is trivial.

Complexity is O(n^3)



