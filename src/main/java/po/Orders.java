package po;

import java.util.List;

public class Orders {
    private int id;
    private String number;
    private double total;
    private int cus_id;
    private List<Product> productList;
    public Orders() {
    }

    @Override
    public String toString() {
        return "Orders{" +
                "id=" + id +
                ", number='" + number + '\'' +
                ", total=" + total +
                ", cus_id=" + cus_id +
                ", productList=" + productList +
                ", customer=" + customer +
                '}';
    }

    public Orders(int id, String number, double total, int cus_id, Customer customer) {
        this.id = id;
        this.number = number;
        this.total = total;
        this.cus_id = cus_id;
        this.customer = customer;
    }

    public int getCus_id() {
        return cus_id;
    }

    public void setCus_id(int cus_id) {
        this.cus_id = cus_id;
    }

    private Customer customer;

    public Orders(int id, String number, double total, Customer customer) {
        this.id = id;
        this.number = number;
        this.total = total;
        this.customer = customer;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}
