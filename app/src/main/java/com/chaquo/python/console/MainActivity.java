package com.chaquo.python.console;

import android.app.*;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;

import com.chaquo.python.utils.*;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends PythonConsoleActivity {

    // On API level 31 and higher, pressing Back in a launcher activity sends it to the back by
    // default, but that would make it difficult to restart the activity.
    @Override public void onBackPressed() {
        finish();
    }

    @Override protected Class<? extends Task> getTaskClass() {
        return Task.class;
    }

    public static class Task extends PythonConsoleActivity.Task {
        public static ArrayList<File> files = new ArrayList<File>();

        public Task(Application app) {
            super(app);
        }

        @Override public void run() {
            py.getModule("main").callAttr("main", this);
        }

//        public void setStartButtonAction() {
//            startButton.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                    for (String i : url_list) {
//                        System.out.println("PRINTING URL...");
//                    }
//                }
//            });
//        }

        public void deleteAllFiles() {
            for (File i : files) {
                i.delete();
            }
            files.clear();
        }

        public void addFile(String path) {
            files.add(new File(path));
        }

        public void copyAllFiles() {
            for (File i : files) {
                try {
                    copyFileToDownloads(getApplication().getApplicationContext(), i);
                } catch (IOException e) {
                    System.out.println(e);
                }
            }
        }

        private void copyFileToDownloads(Context context, File downloadedFile) throws IOException {
            ContentResolver resolver = context.getContentResolver();
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
                ContentValues contentVals = new ContentValues();
                contentVals.put(MediaStore.MediaColumns.DISPLAY_NAME, downloadedFile.getName());
                contentVals.put(MediaStore.MediaColumns.MIME_TYPE, Files.probeContentType(downloadedFile.toPath()));
                contentVals.put(MediaStore.MediaColumns.SIZE, downloadedFile.length());
                Uri outputUri = resolver.insert(MediaStore.Downloads.EXTERNAL_CONTENT_URI, contentVals);

                //Begin copying file
                OutputStream output = resolver.openOutputStream(outputUri);
                byte[] brr = new byte[1024];
                long lenLeft = downloadedFile.length();
                BufferedInputStream input = new BufferedInputStream(new FileInputStream(downloadedFile.getAbsoluteFile()));

                while(input.read(brr, 0, brr.length) != -1) {
                    output.write(brr, 0 , lenLeft > brr.length ? brr.length : (int) lenLeft);
                    lenLeft -= brr.length;
                }
                output.flush();
                input.close();
                output.close();
            }
        }
    }
}
