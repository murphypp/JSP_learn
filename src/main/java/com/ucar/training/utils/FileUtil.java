package com.ucar.training.utils;

import java.io.File;
import java.util.Set;

public class FileUtil {
    public static void listFile(File f, Set<String> all){
        File[] files = f.listFiles();
        for (File x:files
        ) {
            if (x == null){
                return;
            }
            if (x.isDirectory()){
                listFile(x, all);
            }else {
                String filename = x.getName();
                all.add(filename);
            }
        }
    }
}

