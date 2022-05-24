//package com.graduation.backend.model;
//
//import com.fasterxml.jackson.annotation.JsonInclude;
//import lombok.AllArgsConstructor;
//import lombok.NoArgsConstructor;
//import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.Id;
//import javax.persistence.JoinColumn;
//
//@Entity
//@AllArgsConstructor
//@NoArgsConstructor
//@JsonInclude(JsonInclude.Include.NON_NULL)
//public class Admin extends Users {
//
//    @Id
//    @GeneratedValue
//    @JoinColumn(name = "admin_id")
//    private Long adminId;
//
//    private String adminName;
//    private String adminPassword;
//
//
//
//    public Long getAdminId() { return adminId; }
//    public void setAdminId(Long AdminId) { this.adminId = adminId; }
//
//    public String getAdminName() { return adminName; }
//    public void setAdminName(String adminName) { this.adminName = adminName; }
//
//    public String getAdminPassword() { return adminPassword; }
//    public void setAdminPassword(String adminPassword) { this.adminPassword = adminPassword; }
//
//}
