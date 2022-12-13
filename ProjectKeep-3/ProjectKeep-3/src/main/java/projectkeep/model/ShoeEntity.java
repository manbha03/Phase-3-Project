package projectkeep.model;

import javax.persistence.*;


@Entity
@Table(name = "shoe_details")
public class ShoeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "shoe_id")
    private int id;
    @Column(name = "shoe_color")
    private String shoeColor;
    @Column(name = "shoe_size")
    private String shoeSize;
    @Column(name = "shoe_category")
    private String shoeCategory;
    @Column(nullable = true, name = "available_in_stock")
    private Integer availableInStock;
    @Column(name = "shoe_price")
    private int shoePrice;

    @Column(name = "date_added")
    private String dateAdded;
    @Transient
    private Integer remainingStocks;

    public ShoeEntity() {
    }

    public ShoeEntity(int id, String shoeColor, String shoeSize, String shoeCategory, Integer availableInStock, int shoePrice, String dateAdded, Integer remainingStocks) {
        this.id = id;
        this.shoeColor = shoeColor;
        this.shoeSize = shoeSize;
        this.shoeCategory = shoeCategory;
        this.availableInStock = availableInStock;
        this.shoePrice = shoePrice;
        this.dateAdded = dateAdded;
        this.remainingStocks = remainingStocks;
    }

    public ShoeEntity(String shoeColor, String shoeSize, String shoeCategory, Integer availableInStock, int shoePrice, String dateAdded, Integer remainingStocks) {
        this.shoeColor = shoeColor;
        this.shoeSize = shoeSize;
        this.shoeCategory = shoeCategory;
        this.availableInStock = availableInStock;
        this.shoePrice = shoePrice;
        this.dateAdded = dateAdded;
        this.remainingStocks = remainingStocks;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getShoeColor() {
        return shoeColor;
    }

    public void setShoeColor(String shoeColor) {
        this.shoeColor = shoeColor;
    }

    public String getShoeSize() {
        return shoeSize;
    }

    public void setShoeSize(String shoeSize) {
        this.shoeSize = shoeSize;
    }

    public String getShoeCategory() {
        return shoeCategory;
    }

    public void setShoeCategory(String shoeCategory) {
        this.shoeCategory = shoeCategory;
    }

    public Integer getAvailableInStock() {
        return availableInStock;
    }

    public void setAvailableInStock(Integer availableInStock) {
        this.availableInStock = availableInStock;
    }

    public int getShoePrice() {
        return shoePrice;
    }

    public void setShoePrice(int shoePrice) {
        this.shoePrice = shoePrice;
    }

    public String getDateAdded() {
        return dateAdded;
    }

    public void setDateAdded(String dateAdded) {
        this.dateAdded = dateAdded;
    }

    public Integer getRemainingStocks() {
        return remainingStocks;
    }

    public void setRemainingStocks(Integer remainingStocks) {
        this.remainingStocks = remainingStocks;
    }

    @Override
    public String toString() {
        return "ShoeEntity{" +
                "id=" + id +
                ", shoeColor='" + shoeColor + '\'' +
                ", shoeSize='" + shoeSize + '\'' +
                ", shoeCategory='" + shoeCategory + '\'' +
                ", availableInStock=" + availableInStock +
                ", shoePrice=" + shoePrice +
                ", dateAdded='" + dateAdded + '\'' +
                ", remainingStocks=" + remainingStocks +
                '}';
    }
}
