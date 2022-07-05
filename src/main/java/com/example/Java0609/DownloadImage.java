package com.example.Java0609;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class DownloadImage {
  public static void main(String[] args) throws Exception {
    String path = "https://scontent.xx.fbcdn.net/v/t39.30808-6/286802204_5849200871773512_2596775184393517586_n.jpg?_nc_cat=105&ccb=1-7&_nc_sid=8631f5&_nc_ohc=sQ64q9-CdscAX8n_Dal&_nc_ht=scontent.ftpe7-4.fna&oh=00_AT8WADJYk8fZmBBhYX8qYYV6WCgjsCLcL7WK8JrFiutECg&oe=62A6C83F&_nc_fr=ftpe7c04";
    String dest = "./src/main/java/com/example/Java0609/backup/network_image.jpg";
    URL url = new URL(path);
    URLConnection conn = url.openConnection();
    try (InputStream is = conn.getInputStream();
        FileOutputStream fos = new FileOutputStream(dest);) {

      byte[] buffer = new byte[1];
      while (is.read(buffer) != -1) {
        fos.write(buffer);
      }
      System.out.println("下載完畢");
    } catch (Exception e) {
    }
  }
}
