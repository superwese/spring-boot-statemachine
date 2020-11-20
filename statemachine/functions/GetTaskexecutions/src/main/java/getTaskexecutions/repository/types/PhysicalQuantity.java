package getTaskexecutions.repository.types;

import java.util.Arrays;

/**
 * Created by micha on 29.09.16.
 */
public enum PhysicalQuantity {
    TEMPERATURE("temperature"),
    DEW_POINT("dew point"),
    RELATIVE_HUMIDITY("relative humidity"),
    ABSOLUTE_HUMIDITY("absolute humidity"),
    MASS("mass"),
    VOLUME("volume"),
    TPM("tpm"),
    PH_VALUE("pH value"),
    AMOUNT("amount"),
    TIME("time");

    private String physicalQuantity;

    PhysicalQuantity(String physicalQuantity) {
        this.physicalQuantity = physicalQuantity;
    }

    public String getDisplayUnit() {
        return this.physicalQuantity;
    }

    public static PhysicalQuantity toEnum(String source) {
        return Arrays.stream(PhysicalQuantity.values())
                .filter(enumVal -> enumVal.getDisplayUnit().equalsIgnoreCase(source))
                .findFirst().orElseThrow(() -> new IllegalArgumentException("Type: " + source + " is not convertable to " + PhysicalQuantity.class.getName()));
    }
}
