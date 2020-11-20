package getTaskexecutions.repository.types;

import java.util.Arrays;

/**
 * Created by micha on 29.09.16.
 */
public enum LimitMeasurementDisplayUnit {
    KELVIN("kelvin"),
    CELSIUS("celsius"),
    FAHRENHEIT("fahrenheit"),
    KELVIN_DEW_POINT("kelvin dew point"),
    CELSIUS_DEW_POINT("celsius dew point"),
    FAHRENHEIT_DEW_POINT("fahrenheit dew point"),
    RELATIVE_HUMIDITY("relative humidity"),
    ABSOLUTE_HUMIDITY("absolute humidity"),
    TON("ton"),
    KILOGRAM("kilogram"),
    GRAM("gram"),
    MILLIGRAM("milligram"),
    CUBIC_METER("cubic metre"),
    CUBIC_CENTIMETER("cubic centimetre"),
    LITER("litre"),
    MILLILITER("millilitre"),
    TPM("percent tpm"),
    PH_VALUE("pH value"),
    PIECES("pieces"),
    SECONDS("seconds"),
    MINUTES("minutes"),
    HOURS("hours"),
    DAYS("days");

    private String displayUnit;

    LimitMeasurementDisplayUnit(String displayUnit) {
        this.displayUnit = displayUnit;
    }

    public String getDisplayUnit() {
        return this.displayUnit;
    }

    public static LimitMeasurementDisplayUnit toEnum(String source) {
        return Arrays.stream(LimitMeasurementDisplayUnit.values())
                .filter(enumVal -> enumVal.getDisplayUnit().equalsIgnoreCase(source))
                .findFirst().orElseThrow(() -> new IllegalArgumentException("Type: " + source + " is not convertable to " + LimitMeasurementDisplayUnit.class.getName()));
    }
}
