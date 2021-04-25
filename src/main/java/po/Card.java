package po;

import java.util.Date;

public class Card {
    private int id;
    private String cardno;
    private Date cardDate;
    private int score;

    @Override
    public String toString() {
        return "Card{" +
                "id=" + id +
                ", cardno='" + cardno + '\'' +
                ", cardDate=" + cardDate +
                ", score=" + score +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCardno() {
        return cardno;
    }

    public void setCardno(String cardno) {
        this.cardno = cardno;
    }

    public Date getCardDate() {
        return cardDate;
    }

    public void setCardDate(Date cardDate) {
        this.cardDate = cardDate;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
}
