Ok to solve this problem. Think of LCS problem, the DP follows that pattern.

s = "abc"
p = "ab*c"

So there will a 2D matrix which will store the DP solutions.
Remember to include the "" string for both the string and pattern.
So make the 2D matrix of size dp = int[p.length() + 1][s.length() + 1]

Now first think is initializing this array.

if both s = "" && p = "" then this will be dp[0][0] and it matches so equal to 1
For the all the prefixes in s and p = "" dp[0][i] = 0: As the pattern is empty nothing matches.

Now for the pattern initialization is slightly more tricky.
So if the p = ".\*" || "a\*" it matches with s = "", but if p = "aa*" it doesn't match with s = ""
So ".\*" matches because '\*' can match with zero characters too.
So if p.charAt(i) == '\*' then check if dp[i - 2][0] was 1 then dp[i][0] = 1
else if p.charAt(i) != '\*' then dp[i][0] = 0

After initialization, Match every character with all the characters in the pattern
in the 2D grid. We will got row wise for each character pattern we will iterate over the whole s.

So there can three cases
1. Current character in the pattern matches the last character in the string prefix or character in the pattern is '.'

   Example prefix p = "a" prefix s = "aa" or prefix p = "a." s = "aa"

   In this case as the last characters of the prefix matches, we have to check the rest of the prefix had matched or not.
   So dp[i][j] = dp[i-1][j-1]

2. Current character is an '\*'

   This is more tricky. And it is because of this i had spent so much time on this question.

   So there are two case here.
   1. The last character in the string prefix is a part of the wild character.
   You can check that by matching p.charAt(j - 2) == s.charAt(i - 1) || p.charAt(j - 2) == '.'
   Example prefix p = "a.*" prefix s ="ab" or p ="aa\*" and prefix s = "a"
   Now even though it matched, wild card character still can take zero characters like second example, so we need to put condition for that in this too.
   (This is the part where it was difficult for me.)
   For that reason dp[i][j] = dp[i][j-1] | dp[i - 2][j]
   dp[i][j-1] is for the case when last character in s is part of the wild card but it very possible that characters before that are also part of wild card.
   dp[i - 2][j] is for the case when the last character is not part of the wild card, in that case just look for the solution removing the wild card from the prefix.

   2. The last character didn't match in the wild card.
   In that case last character is not the part of the wild card, so just ignore the wild card for this character.
   So dp[i][j] = dp[i-2][j]

3. Current character in the pattern doesn't match the last character in the string prefix.

   In this case as the characters didn't match
   Example p = "aa" s = "ab"
   So in this case dp[i][j] = 0


At the end solution would be present in the dp[p.length()][s.length()]


