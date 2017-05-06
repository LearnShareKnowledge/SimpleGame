package com.learnshare.simplegame.utils;

import android.content.Context;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class TextResourceReader {

    public static String readTextFromResource (Context context , int resId)
    {
        StringBuilder builder = new StringBuilder();

        InputStream is = context.getResources().openRawResource(resId);

        InputStreamReader isr = new InputStreamReader(is);

        BufferedReader br = new BufferedReader(isr);

        String nextLine ;

        try {
            while ((nextLine = br.readLine()) !=null)
            {
                builder.append(nextLine);

                builder.append("\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    return builder.toString();
    }
}
