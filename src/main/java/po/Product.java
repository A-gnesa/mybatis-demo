package po;


import java.util.List;

public class Product {
    private Integer id;
    private String p_name;
    private Double p_price;
    private List<Orders> orders;
    Product() {}

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", p_name='" + p_name + '\'' +
                ", p_price=" + p_price +
                ", orders=" + orders +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getP_name() {
        return p_name;
    }

    public void setP_name(String p_name) {
        this.p_name = p_name;
    }

    public Double getP_price() {
        return p_price;
    }

    public void setP_price(Double p_price) {
        this.p_price = p_price;
    }

    public List<Orders> getOrders() {
        return orders;
    }

    public void setOrders(List<Orders> orders) {
        this.orders = orders;
    }

    public Product(Integer id, String p_name, Double p_price, List<Orders> orders) {
        this.id = id;
        this.p_name = p_name;
        this.p_price = p_price;
        this.orders = orders;
    }
}

