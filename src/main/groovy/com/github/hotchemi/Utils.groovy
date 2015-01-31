package com.github.hotchemi

import groovy.io.FileType
import groovy.util.logging.Log

class Utils {

    private Utils() {
    }

    static void exit(String message) {
        Log.println(message)
        System.exit(-1)
    }

    static List<String> findProguardPaths() {
        String currentDir = new File(".").getAbsoluteFile().getParent()
        List<String> files = []
        new File(currentDir).eachDirRecurse { dir ->
            dir.eachFileMatch(FileType.FILES, ~/.*\.pro/) {
                files.add(it.path)
            }
        }
        return files
    }

    static String getHttpResponse(String fileName) {
        String url = "https://raw.githubusercontent.com/krschultz/android-proguard-snippets/master/libraries/proguard-${fileName}.pro"
        return new URL(url).text
    }

}