package airbnb;
import java.io.*;
import java.util.*;
import static java.util.Arrays.asList;
/**
 * Created by adib on 7/13/17.
 */
public class justifyText {
/*
 * To execute Java, please define "static void main" on a class
 * named Solution.
 *
 * If you need more classes, simply define them inline.
 */
        private static String CORNER_CHAR = "+";
        private static String LINE_SEPARATOR = "-";
        private static String START_END_SEPARATOR = "|";
        private static String PADDING_CHAR = " ";

        static class Article {
            String text;

            Article(String text) {
                this.text = text;
            }

            int getLength() {
                return this.text.length();
            }

            String[] getWords() {
                return String.split(this.text, " ");
            }
        }

        // input
        static List<Article> articles = asList(
                new Article("This is a short article."),
                new Article("Now for a longer article. This one has a lot of text."),
                new Article("Another article with medium length.")
        );

        static int width = 12;

  /*
  +------------+
  |This is a   |
  |short       |
  |article.    |
  +------------+
  |Now for a   |
  |longer      |
  |article.    |
  |This one has|
  |a lot of    |
  |text.       |
  +------------+
  |Another     |
  |article with|
  |medium      |
  |length.     |
  +------------+
  */

        public static void main(String[] args) {
            int maxLength = 0;
            for ( Article article : articles) {
                if (article.getLength() > maxLength) {
                    maxLength = article.getLength();
                }
            }

            StringBuilder sb = new StringBuilder();
            String lineBreak = createLineBreak(maxLength);
            String line = "";
            sb.append(lineBreak);
            for( Article article: articles) {
                String lineFormat = "%s%s%"+(maxLength-article.getLength())+"s%s\n";
                if(maxLength-article.getLength() == 0) {
                    lineFormat = "%s%s%s\n";
                    line = String.format(lineFormat, START_END_SEPARATOR, article.text, START_END_SEPARATOR);
                } else {
                    line = String.format(lineFormat, START_END_SEPARATOR, article.text, PADDING_CHAR, START_END_SEPARATOR);
                }
                sb.append(line);
                sb.append(lineBreak);
            }

            System.out.println(sb.toString());
        }

        private static String createLineBreak(int length) {
            StringBuilder sb = new StringBuilder();
            sb.append(CORNER_CHAR);
            for (int i = 0; i < length; i++) {
                sb.append(LINE_SEPARATOR);
            }
            sb.append(CORNER_CHAR);
            sb.append("\n");
            return sb.toString();
        }

        private static String justifyArticleForPage(Article article, int width) {
            StringBuilder sb = new StringBuilder();
            String[] words = article.getWords();
        }
    }

}
