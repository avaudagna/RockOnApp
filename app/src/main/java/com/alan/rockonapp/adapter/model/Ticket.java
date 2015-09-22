package com.alan.rockonapp.adapter.model;

/**
 * Created by alan on 21/09/15.
 */
public class Ticket {
    private String min_value;
    private String max_value;

    public Ticket setMax_value(String max_value) {
        this.max_value = max_value;
        return this;
    }

    public String getMax_value() {
        return max_value;
    }


    public Ticket setMin_value(String min_value) {
        this.min_value = min_value;
        return this;
    }

    public String getMin_value() {
        return min_value;
    }
}
