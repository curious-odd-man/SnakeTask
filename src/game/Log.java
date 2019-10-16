package game;

import java.time.LocalTime;

public final class Log {

    private static boolean isOn = false;

    static void On() {
        isOn = true;
    }

    static void Off() {
        isOn = false;
    }

    private Log() {

    }

    private static String printLineInfo() {
        StackTraceElement[] stackTrace = Thread.currentThread()
                                               .getStackTrace();
        if (stackTrace.length <= 3) {
            return "Stack Trace Error";
        }

        StackTraceElement stackTraceElement = stackTrace[4];
        return stackTraceElement.getMethodName() + "@ .(" + stackTraceElement.getFileName() + ':' + stackTraceElement.getLineNumber() + ')';
    }

    private static String format(Object o) {
        return LocalTime.now() + ": " + printLineInfo() + " : " + o.toString();
    }

    public static void debug(Object o) {
        if (isOn) {
            System.out.println(format(o));
        }
    }

    public static void debug() {
        if (isOn) {
            System.out.println(format(""));
        }
    }
}
