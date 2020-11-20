package getTaskexecutions.repository.types;

/**
 * Created by harroharten on 19.08.16.
 * These Enums should be compared/sorted using their #getWeight Methods
 */
public enum ViolationLevelType {

    unknown(-1), none(0), okplusca(50), warning(100), violation(200),;

    ViolationLevelType(Integer weight) {
        this.weight = weight;
    }

    Integer weight;

    public Integer getWeight() {
        return weight;
    }

    public static ViolationLevelType byWeight(Integer weight) {
        for (ViolationLevelType v : values()) {
            if (v.weight.equals(weight))
                return v;
        }
        return null;
    }

    /**
     * @see {@link com.testo.sampledata.analysis.dailyperformance.dto.TenantSummary} line 39
     */
    public static ViolationLevelType atLeastNone(ViolationLevelType foundViolationLevel) {
        return ViolationLevelType.byWeight(Math.max(foundViolationLevel.getWeight(), ViolationLevelType.none.getWeight()));
    }

}
