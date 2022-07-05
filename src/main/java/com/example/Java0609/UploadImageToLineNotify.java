package com.example.Java0609;

import java.io.File;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;

public class UploadImageToLineNotify {
  public static void main(String[] args) throws Exception {
    // 1. 發送訊息
    String message = "F-18 大黃蜂";
    // 2. 發送檔案
    File file = new File("./src/main/java/com/example/Java0609/F-18.jpg");
    // 3. 設定 token
    String token = "mBzCdQxIbGUwPNdAsTGyE2AzBa1Z14DAvTApzvjXRJ1";
    // 4. 發送位置
    String lineNotifyURL = "https://notify-api.line.me/api/notify";
    // 5. 發送前設定
    // 5.1 標頭檔
    Map<String, String> headers = new LinkedHashMap<>();
    headers.put("Authorization", "Bearer " + token);
    HttpPostMultipart multipart = new HttpPostMultipart(lineNotifyURL, "utf-8", headers);
    // 5.2 POST 參數
    multipart.addFormField("message", message);
    multipart.addFilePart("imageFile", file);
    // 6. 傳送並取得回傳直
    String response = multipart.finish();
    System.out.println(response);
  }
}
