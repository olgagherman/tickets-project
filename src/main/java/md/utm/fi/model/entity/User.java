//package md.utm.fi.model.entity;
//
//import java.util.Date;
//import java.util.List;
//
//import javax.persistence.CascadeType;
//import javax.persistence.Entity;
//import javax.persistence.FetchType;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;
//import javax.persistence.JoinColumn;
//import javax.persistence.JoinTable;
//import javax.persistence.OneToMany;
//import javax.persistence.Temporal;
//import javax.persistence.TemporalType;
//
//@Entity
//public class User extends Person {
//
//	private Integer id;
//	private String email;
//	private String password;
//	private Date createdDate;
//	private boolean admin;
//	private List<Book> uploadedBooks;
//
//	@Id
//	@GeneratedValue(strategy = GenerationType.AUTO)
//	public Integer getId() {
//		return id;
//	}
//
//	public void setId(Integer id) {
//		this.id = id;
//	}
//
//	public String getEmail() {
//		return email;
//	}
//
//	public void setEmail(String email) {
//		this.email = email;
//	}
//
//	public String getPassword() {
//		return password;
//	}
//
//	public void setPassword(String password) {
//		this.password = password;
//	}
//
//	@Temporal(TemporalType.DATE)
//	public Date getCreatedDate() {
//		return createdDate;
//	}
//
//	public void setCreatedDate(Date createdDate) {
//		this.createdDate = createdDate;
//	}
//
//	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
//	@JoinTable(name = "uploaded_books", joinColumns = @JoinColumn(name = "uploader_id"), inverseJoinColumns = @JoinColumn(name = "book_id"))
//	public List<Book> getUploadedBooks() {
//		return uploadedBooks;
//	}
//
//	public void setUploadedBooks(List<Book> uploadedBooks) {
//		this.uploadedBooks = uploadedBooks;
//	}
//
//	public boolean isAdmin() {
//		return admin;
//	}
//
//	public void setAdmin(boolean admin) {
//		this.admin = admin;
//	}
//
//}
