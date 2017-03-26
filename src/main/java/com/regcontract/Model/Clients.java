package com.regcontract.Model;

/**
 * Created by kabanaus on 26.02.2017.
 */
public class Clients {
    private String clientName = null;

    public Clients() {
    }

    public Clients(String clientName){
        this.clientName = clientName;
    }


    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }
}
