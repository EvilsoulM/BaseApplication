package com.evilsoulm.baseapplication.utils;

import android.content.Context;
import android.os.Process;
import android.text.TextUtils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * Author by mazixuan
 * Data:2015-12-06 15:03
 * Project:BaseApplication
 * Detail:
 */
public class Utils {

    public static boolean isMainProcess(Context context) {
        String mainProcessName = context.getPackageName();
        String myProcessName = Utils.getProcessName(Process.myPid());
        return TextUtils.equals(mainProcessName, myProcessName);
    }

    public static String getProcessName(int pid) {
        String cmdlinePath = "/proc/" + pid + "/cmdline";
        if (isFileExist(cmdlinePath)) {
            String content = readFile(cmdlinePath);
            if (content != null) {
                return content.split("\u0000")[0];
            }
        }

        return null;
    }

    public static boolean isFileExist(String filePath) {
        try {
            return (new File(filePath)).exists();
        } catch (SecurityException var2) {
            var2.printStackTrace();
        } catch (Exception var3) {
            var3.printStackTrace();
        }

        return false;
    }

    public static String readFile(String filePath) {
        FileReader fileReader = null;
        BufferedReader br = null;
        String content = null;

        try {
            StringBuilder e = new StringBuilder();
            fileReader = new FileReader(filePath);
            br = new BufferedReader(fileReader);
            String s = null;

            while ((s = br.readLine()) != null) {
                e.append(s).append('\n');
            }

            content = e.toString();
        } catch (Exception var14) {
            var14.printStackTrace();
        } finally {
            try {
                if (fileReader != null) {
                    fileReader.close();
                    fileReader = null;
                }

                if (br != null) {
                    br.close();
                    br = null;
                }
            } catch (IOException var13) {
                var13.printStackTrace();
            }

        }

        return content;
    }
}
