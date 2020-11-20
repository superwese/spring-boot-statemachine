package getTaskexecutions.repository.model;

import org.apache.commons.lang3.StringUtils;

/**
 * Created by andrethierbach on 24.04.17.
 */
public class StringLimiter {

    private StringLimiter() {
    }

    public static String limitComment(String comment) {
        return limit(comment, 1024);
    }

    public static String limitProcessStepInput(String input) {
        return limit(input, 1000);
    }

    private static String limit(String input, int maxLength) {
        return StringUtils.abbreviate(input, "…", maxLength);
    }

}
