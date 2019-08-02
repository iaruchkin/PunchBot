import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

/**
 * Created by igor on 29.11.17.
 */

public class PageAsker {
    public static void main(String args[]){
        String nextLine;
        URL url = null;
        URLConnection urlConn = null;
        InputStreamReader  inStream = null;
        BufferedReader buff = null;
        try{
            // index.html is a default URL's  file name
            url  = new URL("http://rifma-online.ru/rifma/любовь" );
            urlConn = url.openConnection();
            inStream = new InputStreamReader(
                    urlConn.getInputStream());
            buff  = new BufferedReader(inStream);

            // into a String variable
            String theWholePage=null;
            String currentLine;
            while ((currentLine=buff.readLine()) !=null){
                theWholePage+=currentLine;
            }

            String Word=null;
            String str="data-suffix-len";
            int k=theWholePage.indexOf(str)+str.length();
            Word=theWholePage.substring(k,k+40).replaceAll("[^А-Яа-я]","");

            System.out.println(Word);
        } catch(MalformedURLException e){
            System.out.println("Please check the URL:" +
                    e.toString() );
        } catch(IOException  e1){
            System.out.println("Can't read  from the Internet: "+
                    e1.toString() );
        }
    }
}
