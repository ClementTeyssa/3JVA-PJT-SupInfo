package com.supinfo.suppictures.entity;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "pictures")
public class Picture implements Serializable {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    @Column(nullable = false)
    private String name;  
    @Column(nullable = false)
    private String pictureName;
    @Column(nullable = false)
    private String description;
    @Column(nullable = false)
	@Temporal(TemporalType.DATE)
    private Date publishDate;
    @Column(nullable = false)
    private int nbView;
    
    @ManyToOne
    @JoinColumn(name = "category_fk")
    private Category category;

    @ManyToOne
    @JoinColumn(name = "user_fk")
    private User user;

    public Picture() {}
    
	public Picture(String name, String pictureName, String description, Date publishDate, User user, Category category) {
		super();
		this.name = name;
		this.pictureName = pictureName;
		this.description = description;
		this.publishDate = publishDate;
		this.user = user;
		this.nbView = 0;
		this.category = category;
	}

	public int getNbView() {
		return nbView;
	}

	public void setNbView(int nbView) {
		this.nbView = nbView;
	}

	public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPictureName() {
        return pictureName;
    }

    public void setPictureName(String pictureName) {
        this.pictureName = pictureName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(Date publishDate) {
        this.publishDate = publishDate;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
}


