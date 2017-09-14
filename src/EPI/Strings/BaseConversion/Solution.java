package EPI.Strings.BaseConversion;

/**
 * Created by adib on 6/21/17.
 */
public class Solution {
    public static void main(String[] args) throws Exception{
        String str1 = convertToBase("1010", 2 ,16);
        assert(str1.equals("A"));
        String str2 = convertToBase("615", 7 ,13);
        assert(str2.equals("1A7"));
        String str3 = convertToBase("7FFFFFFF", 16 ,2);
        System.out.println("str3 = " + str3);
    }

    private static String convertToBase(String number, int base, int convertBase) throws Exception{
        if (base < 2 && base > 16 || convertBase < 2 && convertBase > 16) {
            throw new Exception("Unsupported base");
        }
        if ( base == convertBase) {
            return number;
        }
        long decimalBuffer = 0;
        for(int i = 0; i < number.length(); i++ ) {
            int chrVal = 0;
            if((chrVal = validBaseCharacter(number.charAt(i), base)) >= 0 ) {
                decimalBuffer = decimalBuffer * base + chrVal;
                if (decimalBuffer < 0) {
                    throw new Exception("Decimal buffer is too small for this number");
                }
            } else {
                throw new Exception("Characters in " + number + " are not in the base " + base);
            }
        }

        StringBuilder sb = new StringBuilder();
        while (decimalBuffer > 0) {
            sb.append(toBaseChar(decimalBuffer%convertBase));
            decimalBuffer = decimalBuffer/convertBase;
        }
        sb.reverse();
        return sb.toString();
    }

    private static int validBaseCharacter(char baseChar, int base) {
        int baseValue = -1;
        if (baseChar - '0' >= 0 && baseChar - '0' <= 9) {
            baseValue = baseChar - '0';
        }

        if (baseChar - 'A' >= 0 && baseChar - 'A' <= 'F' - 'A') {
            baseValue = baseChar - 'A' + 10;
        }
        if (baseValue < base) {
            return baseValue;
        }
        return -1;
    }

    private static char toBaseChar(long num) {
        if (num >= 0 && num <= 9) {
            return (char)(num + '0');
        }
        return (char)((num - 10) + 'A');
    }
}
