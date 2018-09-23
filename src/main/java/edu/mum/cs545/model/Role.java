package edu.mum.cs545.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Role implements Serializable {

    private static final long serialVersionUID = 14334L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "role_name")
    private String roleName;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String role) {
        this.roleName = role;
    }


}
