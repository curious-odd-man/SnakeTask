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
        final int STACK_ELEMENT_INDEX = 4;
        Thread currentThread = Thread.currentThread();
        StackTraceElement[] stackTrace = currentThread.getStackTrace();
        if (stackTrace.length < STACK_ELEMENT_INDEX) {
            return "Stack Trace Error";
        }

        StackTraceElement element = stackTrace[STACK_ELEMENT_INDEX];
        return '[' + currentThread.getName() + ':' + currentThread.getId() + "] " + element.getMethodName() + " in .(" + element.getFileName() + ':' + element.getLineNumber() + ')';
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
