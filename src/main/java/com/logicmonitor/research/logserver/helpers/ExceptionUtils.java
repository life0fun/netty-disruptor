package com.logicmonitor.research.logserver.helpers;

import java.net.UnknownHostException;

public class ExceptionUtils {

    public static Throwable getRootCause(Throwable t) {
        if (t == null) {
            return null;
        }
        Throwable rootCause = t;
        Throwable cause = rootCause.getCause();
        while (cause != null && cause != rootCause) {
            rootCause = cause;
            cause = cause.getCause();
        }
        return rootCause;
    }

    public static String formatMessageCause(Throwable t) {
        if (t == null) {
            return "Unknown cause";
        }
        final StringBuilder causeMessage = new StringBuilder();

        // UnknownHostException has only the hostname as error message, we need to add some
        // information before showing the error message to the user.
        if (t.getClass() == UnknownHostException.class) {
            causeMessage.append("Unknown host '");
            causeMessage.append(t.getMessage());
            causeMessage.append("'");
        } else {
            causeMessage.append(t.getMessage());
        }

        if (!t.getMessage().endsWith(".")) {
            causeMessage.append(".");
        }

        return causeMessage.toString();
    }

    public static String getRootCauseMessage(Throwable t) {
        return formatMessageCause(getRootCause(t));
    }
}