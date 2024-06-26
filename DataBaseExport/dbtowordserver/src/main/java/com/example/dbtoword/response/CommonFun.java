package com.example.dbtoword.response;

import org.slf4j.Logger;

/**
 *
 * @author hjp
 * @date 2018/7/17
 */
public class CommonFun {
    public static String getExceptionTraceInfo(Exception e) {
        StringBuilder traceInfo = new StringBuilder(e.toString() + "\n 具体堆栈：");
        for (int i = 0; i < e.getStackTrace().length; ++i) {
            String errorItemStr = e.getStackTrace()[i].toString();
            if (errorItemStr.startsWith("sun.") || errorItemStr.startsWith("org.") ||
                    errorItemStr.startsWith("java.") || errorItemStr.startsWith("javax.")){continue;}
            traceInfo.append("\n");
            traceInfo.append(errorItemStr);
        }
        return traceInfo.toString();
    }
    public static void outputException(Exception e, Logger log) {
        e.printStackTrace();
        log.error(CommonFun.getExceptionTraceInfo(e));
    }
}
