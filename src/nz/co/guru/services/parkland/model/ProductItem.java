package nz.co.guru.services.parkland.model;

import java.io.Serializable;
import java.math.BigDecimal;

public class ProductItem implements Serializable {

    /**
     * db id
     */
    private long id;

    private String inventoryId;

    private String description;

    private BigDecimal price;

    private int quantity;

    private boolean isSpecial;

    private int productBrandLogoResourceId;

    public ProductItem() {
    }

    public ProductItem(final long id, final String inventoryId, final String description, final BigDecimal price) {
        this.id = id;
        this.inventoryId = inventoryId;
        this.description = description;
        this.price = price;
    }

    public String getInventoryId() {
        return inventoryId;
    }

    public void setInventoryId(final String inventoryId) {
        this.inventoryId = inventoryId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(final String description) {
        this.description = description;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(final BigDecimal price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(final int quantity) {
        this.quantity = quantity;
    }

    public boolean isSpecial() {
        return isSpecial;
    }

    public void setSpecial(final boolean isSpecial) {
        this.isSpecial = isSpecial;
    }

    public long getId() {
        return id;
    }

    public void setId(final long id) {
        this.id = id;
    }

    public String getProductItemOtherInfo() {
        return inventoryId + " $" + price.toString();
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + (int) (id ^ id >>> 32);
        return result;
    }

    @Override
    public boolean equals(final Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (!(obj instanceof ProductItem)) {
            return false;
        }
        final ProductItem other = (ProductItem) obj;
        if (id != other.id) {
            return false;
        }
        return true;
    }

    public int getProductBrandLogoResourceId() {
        return productBrandLogoResourceId;
    }

    public void setProductBrandLogoResourceId(final int productBrandLogoResourceId) {
        this.productBrandLogoResourceId = productBrandLogoResourceId;
    }

}
