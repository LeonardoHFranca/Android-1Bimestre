package com.example.myapplication;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

//essa classe deve se comunicar com api via HTTP
public class ClienteGeoIP {
    private static String readStream(InputStream in){
        BufferedReader r = new BufferedReader(new InputStreamReader(in));
        StringBuilder total = new StringBuilder();
        String line;
        try{
            while ((line = r.readLine()) != null){
                total.append(line).append('\n');
            }
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return total.toString();
    }
        private static String request(String stringUrl) throws IOException {
        URL url = null;
        HttpURLConnection urlConnection = null;
        try{
            url = new URL(stringUrl);
            urlConnection = (HttpURLConnection) url.openConnection();
            InputStream in = new BufferedInputStream(urlConnection.getInputStream());
            return readStream(in);
        }
        catch (Exception e){
            e.printStackTrace();
        }
        finally {
            urlConnection.disconnect();
        }
        return "";
        }
        public  static Localizacao localizar(String ip) throws JSONException {
            String resposta = null;
            try {
                resposta = request("http://freegeoip.net/json/" + ip);
            } catch (IOException e) {
                e.printStackTrace();
            }
            JSONObject obj = new JSONObject(resposta);
            String code = obj.getString("coutry_code");
            String name = obj.getString("time_zone");
            return new Localizacao(code,name);
        }

}
