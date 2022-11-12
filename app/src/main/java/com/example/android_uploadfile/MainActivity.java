package com.example.android_uploadfile;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.Base64;
import com.loopj.android.http.RequestParams;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;

import cz.msebera.android.httpclient.entity.mime.Header;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        try {uploadFile();} catch (FileNotFoundException e) {e.printStackTrace();}
    }
    public void uploadFile() throws FileNotFoundException {

        AsyncHttpClient client=new AsyncHttpClient();
        RequestParams params=new RequestParams();
        String filePath="/data/data/com.example.android_uploadfile/cache/cxk.jpg";
        params.put("data",new File(filePath));
        client.post(this, "http://file.codepowders.com/upload.php", params, new AsyncHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, cz.msebera.android.httpclient.Header[] headers, byte[] responseBody) {
                System.out.println(new String(responseBody));
            }
            @Override
            public void onFailure(int statusCode, cz.msebera.android.httpclient.Header[] headers, byte[] responseBody, Throwable error) {
                System.out.println(new String(responseBody));
            }
        });
    }
}