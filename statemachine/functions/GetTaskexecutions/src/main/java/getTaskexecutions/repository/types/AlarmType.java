package getTaskexecutions.repository.types;

import org.apache.commons.lang3.StringUtils;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by harroharten on 10.02.17.
 */
public enum AlarmType {
    sampleLimitAlert,
    probeAlert;

    private static Map<String, AlarmType> alternativeValues = new HashMap<>();
    static {
        for (AlarmType alarmType: AlarmType.values()) {
            alternativeValues.put(alarmType.name().toUpperCase(), alarmType);
        }
    }

    public static AlarmType map(String input) {
        if (StringUtils.isEmpty(input)) return null;

        AlarmType found = alternativeValues.get(input);

        return found == null ? AlarmType.valueOf(input) : found;
    }
}
