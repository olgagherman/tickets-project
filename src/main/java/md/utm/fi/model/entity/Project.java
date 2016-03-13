package md.utm.fi.model.entity;

import java.util.Date;

import javax.persistence.Entity;

@Entity
public class Project {

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	private Integer id;
	private String name;
	private Date createdDate;

}
