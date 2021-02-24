package com.luxoft.springboot.model;

public class Order {

    private long id;
    private long payeeId;
    private String payeeName;
    private String itemName;

    public Order(){}

    public Order(long id, long payeeId, String payeeName, String itemName) {
        this.id = id;
        this.payeeId = payeeId;
        this.payeeName = payeeName;
        this.itemName = itemName;
    }

    public long getId() {
        return id;
    }

    public String getPayeeName() {
        return payeeName;
    }

    public void setPayeeName(String payeeName) {
        this.payeeName = payeeName;
    }

    public long getPayeeId() {
        return payeeId;
    }

    public void setPayeeId(long payeeId) {
        this.payeeId = payeeId;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", payeeId=" + payeeId +
                ", payeeName='" + payeeName + '\'' +
                ", itemName='" + itemName + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Order order = (Order) o;

        if (id != order.id) return false;
        if (payeeId != order.payeeId) return false;
        if (payeeName != null ? !payeeName.equals(order.payeeName) : order.payeeName != null) return false;
        return itemName != null ? itemName.equals(order.itemName) : order.itemName == null;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (int) (payeeId ^ (payeeId >>> 32));
        result = 31 * result + (payeeName != null ? payeeName.hashCode() : 0);
        result = 31 * result + (itemName != null ? itemName.hashCode() : 0);
        return result;
    }
}
