package org.jim.core.banner;

import org.jim.core.ImConst;
import org.jim.core.JimVersion;

import java.io.PrintStream;

public class JimBanner implements Banner{

    private static final String BANNER=
            "    _____      _____  ____    ____  \n" +
            "   |_   _|    |_   _||_   \\  /   _| \n" +
            "     | | ______ | |    |   \\/   |   \n" +
            " _   | ||______|| |    | |\\  /| |   \n" +
            "| |__' |       _| |_  _| |_\\/_| |_  \n" +
            "`.____.'      |_____||_____||_____| \n" +
            " ";

    private static final String JIM="::"+ ImConst.JIM+"::";

    @Override
    public void printBanner(PrintStream printStream) {
        printStream.println(BANNER);
        //打印版本号
        String version="("+ JimVersion.version+")";
        printStream.println(JIM+version+"\n");
    }
}
