package com.graduation.backend.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;
import javax.persistence.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "hotspots")
@JsonInclude(Include.NON_NULL)
public class HotSpots {

    @Id
    @GeneratedValue
    private Long id;

    private String name;
    private String country;
    private String area;
    private String remark;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    Users users;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getCountry() { return country; }
    public void setCountry(String country) { this.country = country; }

    public String getArea() { return area; }
    public void setArea(String area) { this.area = area; }

    public String getRemark() { return remark; }
    public void setRemark(String remark) { this.remark = remark; }

    public Users getUsers() { return users; }
    public void setUsers(Users users) { this.users = users; }
}
