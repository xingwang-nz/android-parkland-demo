package nz.co.guru.services.parkland.search;

public enum ProductFieldFilter {
    ALL("All"),
    INVENTORY_ID("Inventory ID"),
    NAME("Name");

    private final String description;

    private ProductFieldFilter(final String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

}
