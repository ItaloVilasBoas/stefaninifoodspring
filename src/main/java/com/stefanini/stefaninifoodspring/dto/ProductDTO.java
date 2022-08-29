package com.stefanini.stefaninifoodspring.dto;

public class ProductDTO {
    private Long id;
    
    private byte[] image;
    
    private boolean inStock;
    
    private String name;
    
    private String description;

    private double price;
    
    private Long idVendor;

    public ProductDTO() {
    }

    public ProductDTO(Long id, byte[] image, boolean inStock, String name, String description, double price,
            Long idVendor) {
        this.id = id;
        this.image = image;
        this.inStock = inStock;
        this.name = name;
        this.description = description;
        this.price = price;
        this.idVendor = idVendor;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    public boolean isInStock() {
        return inStock;
    }

    public void setInStock(boolean inStock) {
        this.inStock = inStock;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Long getIdVendor() {
        return idVendor;
    }

    public void setIdVendor(Long idVendor) {
        this.idVendor = idVendor;
    }
}
