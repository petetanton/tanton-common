package tanton.common;

import org.apache.log4j.Logger;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class StreamConsumer extends Thread {

    private static Logger log = Logger.getLogger(StreamConsumer.class);

    private InputStream is;
    private String type;

    public StreamConsumer(InputStream is, String type)
    {
        this.is = is;
        this.type = type;
    }

    public void run()
    {
        try
        {
            InputStreamReader isr = new InputStreamReader(is);
            BufferedReader br = new BufferedReader(isr);
            String line;
            while ( (line = br.readLine()) != null)
                log.info(type + ">" + line);
        } catch (IOException e) {
            log.error("Error whilst consuming stream", e);
        }
    }
}
