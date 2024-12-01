package com.example.firstresponse;

import java.util.List;

  public class coin_data {
    private String status;
    public data DataObject;


    public String getStatus() {
        return status;
    }

    public data getData() {
        return DataObject;
    }

    // Setter Methods

    public void setStatus(String status) {
        this.status = status;
    }

    public void setData(data dataObject) {
        this.DataObject = dataObject;
    }
}
 class data {
    public String change;
    public List<history> history;

    public String getChange() {
        return change;
    }

    public void setChange(String change) {
        this.change = change;
    }

    public List<history> getHistory() {
        return history;
    }

    public void setHistory(List <history> history) { this.history = history;}
}
 class history {
    public String price;
    public long timestamp;


    // Getter Methods

    public String getPrice() {
        return price;
    }

    public long getTimestamp() {
        return timestamp;
    }

    // Setter Methods

    public void setPrice(String price) {
        this.price = price;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }
}

