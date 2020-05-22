package com.rkcodes.elements;

import javafx.util.Pair;

import java.util.Date;
import java.util.List;

public class Room {
    private String owner;
    private List<Pair<String , Double>> items;
    private double total;
    private boolean paid;
    private Date indate;
    private Date outDate;

    public boolean isTaken(){
        if (this.owner == null){
            return false;
        }
        return true;
    }

    public boolean isPaid() {
        return paid;
    }

    public void setPaid(boolean paid) {
        this.paid = paid;
    }

    public Room() {
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public List<Pair<String, Double>> getItems() {
        return items;
    }

    public void setItems(List<Pair<String, Double>> items) {
        this.items = items;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public Date getIndate() {
        return indate;
    }

    public void setIndate(Date indate) {
        this.indate = indate;
    }

    public Date getOutDate() {
        return outDate;
    }

    public void setOutDate(Date outDate) {
        this.outDate = outDate;
    }

    public String toString(int no) {
        return "Room" +no+"|"+ total;
    }
}
