import java.io.IOException;
import java.net.URL;
import java.util.Scanner;

public class UrlToTxt
{
    public static void main(String[] args)
    {
        String cntwrd = " ", text = urlToString("http://erdani.com/tdpl/hamlet.txt");
        int pos = 0;
        int count = 0;

        text = text.toLowerCase();

        cntwrd = cntwrd.toLowerCase();

        while(pos != -1)
        {

            pos = text.indexOf(cntwrd,pos);

            if(pos != -1)
            {
                count ++;
                pos += cntwrd.length();
            }
        }

        System.out.print(count);
    }

    /**
     * Retrieve contents from a URL and return them as a string.
     *
     * @param url url to retrieve contents from
     * @return the contents from the url as a string, or an empty string on error
     */
    public static String urlToString(final String url)
    {
        Scanner urlScanner;

        try
        {
            urlScanner = new Scanner(new URL(url).openStream(), "UTF-8");
        }

        catch (IOException e)
        {
            return "";
        }

        String contents = urlScanner.useDelimiter("\\A").next();
        urlScanner.close();
        return contents;
    }
}
