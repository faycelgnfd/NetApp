package com.openclassrooms.netapp.Controllers.Model;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class MyHttpURLConnection {

    public static String startHttpRequest(String urlString)
    {
        StringBuilder stringBuilder = new StringBuilder();

        try
        {
            //1 établir la connexion avec l'url
            URL url = new URL(urlString);
            HttpURLConnection conn = (HttpURLConnection)url.openConnection();
            conn.connect();

            //2 ouvrir InputStram pour cette connexion
            InputStream in = conn.getInputStream();

            //3 Lire le contenu du InputStream
            BufferedReader reader = new BufferedReader(new InputStreamReader(in));
            String line;
            while((line = reader.readLine()) != null)
            {
                stringBuilder.append(line);
            }
        }
        catch(Exception x)
        {
            x.printStackTrace();
        }

        return stringBuilder.toString();
    }
}
