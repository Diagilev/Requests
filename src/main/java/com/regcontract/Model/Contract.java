package com.regcontract.Model;

import java.util.Date;

/**
 * Created by kabanaus on 18.02.2017.
 */
public class Contract {
    private String id;
    private String companyName = null;
    private String clientName = null;
    private String fileName = null;
    private String status = null;
    private String date = null;
    private String subject = null;


    public Contract(String id, String companyName, String subject, String status, String clientName, String fileName) {
        this.id = id;
        this.companyName = companyName;
        this.subject = subject;
        this.status = status;
        this.clientName = clientName;
        this.fileName = fileName;
    }

    public Contract() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }
}
