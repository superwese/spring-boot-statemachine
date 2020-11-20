package getTaskexecutions.repository.types;

import com.google.common.base.CaseFormat;
import org.apache.commons.lang3.StringUtils;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by micha on 24.11.16.
 */
public enum AlarmLimitType {

    upperViolation,
    upperWarning,
    lowerViolation,
    lowerWarning,
    doorContact,
    powerProblem,
    systemProblem,
    calibrationProblem,
    unknown;

    private final static Map<String, AlarmLimitType> alternativeValues = new HashMap<>();

    static {
        for (AlarmLimitType alarmLimitType: AlarmLimitType.values()) {
            alternativeValues.put(CaseFormat.LOWER_CAMEL.to(CaseFormat.UPPER_UNDERSCORE, alarmLimitType.name()), alarmLimitType);
        }
    }

    public static AlarmLimitType map(String input) {
        if (StringUtils.isEmpty(input)) return null;

        AlarmLimitType found = alternativeValues.get(input);

        return found == null ? AlarmLimitType.valueOf(input) : found;
    }

}
