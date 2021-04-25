package po;

import java.util.Date;
import java.util.List;

public class Customer {
    private int id;
    private String username;
    private String jobs;
    private String phone;
    private int cardId;
    private Card card;
    private List<Orders> orderList;

    public Customer(int id, String username, String jobs, String phone, int cardId, Card card, List<Orders> orderList) {
        this.id = id;
        this.username = username;
        this.jobs = jobs;
        this.phone = phone;
        this.cardId = cardId;
        this.card = card;
        this.orderList = orderList;
    }

    public List<Orders> getOrderList() {
        return orderList;
    }

    public void setOrderList(List<Orders> orderList) {
        this.orderList = orderList;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", jobs='" + jobs + '\'' +
                ", phone='" + phone + '\'' +
                ", cardId=" + cardId +
                ", card=" + card +
                ", orderList=" + orderList +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getJobs() {
        return jobs;
    }

    public void setJobs(String jobs) {
        this.jobs = jobs;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getCardId() {
        return cardId;
    }

    public void setCardId(int cardId) {
        this.cardId = cardId;
    }

    public Card getCard() {
        return card;
    }

    public void setCard(Card card) {
        this.card = card;
    }
}
