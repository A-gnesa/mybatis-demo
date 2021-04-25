package com.user;

/**
 * @description:
 * @author: 程子涵
 * @time: 2021/3/22 6:14
 */
public class Customer {
    private int id;
    private String username;
    private String jobs;
    private String phone;

    public Customer(String username, String jobs, String phone) {
        this.username = username;
        this.jobs = jobs;
        this.phone = phone;
    }

    public Customer() {
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", jobs='" + jobs + '\'' +
                ", phone='" + phone + '\'' +
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
}
