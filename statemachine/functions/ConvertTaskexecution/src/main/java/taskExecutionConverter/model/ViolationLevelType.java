package taskExecutionConverter.model;

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

}
