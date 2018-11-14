package com.app.scrolllibrary.tools;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Environment;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * 截图工具类
 */
public class ScreenShotUtils {

    public static final String TAG = "duanc";

    /**
     * 根据window 窗口截图
     *
     * @param activity
     * @return 返回bitmap对象， 根据情况选择 显示保存
     */
    @SuppressLint("NewApi")
    public static Bitmap captureScreen(Activity activity) {

        View view = activity.getWindow().getDecorView();
        view.setDrawingCacheEnabled(true);
        view.buildDrawingCache();

        Bitmap bitmap = view.getDrawingCache();
        if (bitmap == null) {
            return null;
        }

        bitmap.setHasAlpha(false);
        bitmap.prepareToDraw();

//        Log.i(TAG, "captureScreen: ");
        return bitmap;
    }

    /**
     * 保存截图到sd卡
     *
     * @param bit
     */
    public static void SavePic(Context context, Bitmap bit) {
        File file = new File(Environment.getExternalStorageDirectory(), "boot");
        if (!file.exists()) {
            file.mkdirs();
        }

        String filename = System.currentTimeMillis() + ".jpg";
        File cfile = new File(file, filename);

        Log.i(TAG, "SavePic: " + file.getName());
        try {
            FileOutputStream stream = new FileOutputStream(cfile);
            bit.compress(Bitmap.CompressFormat.JPEG, 100, stream);
            stream.flush();
            stream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            MediaStore.Images.Media.insertImage(context.getContentResolver(), cfile.getAbsolutePath(), filename, null);


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        // 最后通知图库更新
        context.sendBroadcast(new Intent(Intent.ACTION_MEDIA_SCANNER_SCAN_FILE, Uri.parse("file://" + cfile)));
    }
}
