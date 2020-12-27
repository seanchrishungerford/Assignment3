package com.product;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "EMPLOYEE", uniqueConstraints = {
        @UniqueConstraint(columnNames = "ID")
         })
public class Product implements Serializable{

	private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID", unique = true, nullable = false, length = 255)
	private String id;
    @Column(name = "NAME", unique = false, nullable = false, length = 255)
	private String name;

    public Product(String string, String string2) {
        this.id = string;
        this.name = string2;
    }
	public Product() {
		// TODO Auto-generated constructor stub
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
}
