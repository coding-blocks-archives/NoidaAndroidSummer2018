package com.example.dhirajchhabraeng.whatsappchatpage;

import android.app.ProgressDialog;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.ImageView;

import java.io.InputStream;
import java.net.URL;

class DownloadFileTask extends AsyncTask<URL, Void, Bitmap> {
    de.hdodenhof.circleimageview.CircleImageView bmImage;
    Context context;

    public DownloadFileTask(de.hdodenhof.circleimageview.CircleImageView bmImage, Context ctx) {
        this.bmImage = bmImage;
        this.context = ctx;
    }


    protected Bitmap doInBackground(URL... urls) {
        URL url = urls[0];
        Bitmap bmp = null;
        try {
            InputStream in = url.openStream();
            bmp = BitmapFactory.decodeStream(in);
        } catch (Exception e) {
            Log.e("Error", e.getMessage());
            e.printStackTrace();
        }
        return bmp;
    }

    protected void onPostExecute(Bitmap result) {
        bmImage.setImageBitmap(result);
    }
}
