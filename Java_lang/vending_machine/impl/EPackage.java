package JAVA_LANG.vending_machine.impl;

public enum EPackage {
    PLASTIC("пластик"), GLASS("стекло"), POLYETILEN("Полиэтилен");

    private final String material;

    EPackage(String material) {
        this.material = material;
    }

    public String getMaterial() {
        return material;
    }
}
