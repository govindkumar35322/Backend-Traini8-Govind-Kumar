package com.main.Entity;

//import java.time.Instant;
import java.util.List;

//import org.hibernate.validator.constraints.NotEmpty;

import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Table(name="Traning_Centers")
public class TraningCenter {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
 
	private long id;
	
	@NotNull
	@NotBlank(message="Center Name is Required")
	@Size(max=40,message="Center name should be less tahn 40 characters")
	private String centerName;
	
	@Column(unique = true, nullable = false, length = 12)
    @NotBlank(message = "Center Code is required")
    @Pattern(regexp = "^[a-zA-Z0-9]{12}$", message = "Center Code must be exactly 12 alphanumeric characters")
	private String centerCode;
	 
	 @Embedded
	 @Valid
	 @NotNull(message = "Address is required")
	 private Address address;
	 
	 @Positive(message = "Student Capacity must be a positive number")
	 private Integer studentCapacity;
	 
	 @ElementCollection
	 private List<String> coursesOffered;
	 
	 private long createdOn;
	 
	 @Email(message = "Invalid email format")
	 private String contactEmail;
	 
	 @NotBlank(message = "Contact phone is required")
	 @Pattern(regexp = "^\\d{10}$", message = "Phone number must be exactly 10 digits")
     private String contactPhone;


     public void setCreatedOn(long l) {
    this.createdOn = l;
    }


	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}


	public String getCenterName() {
		return centerName;
	}


	public void setCenterName(String centerName) {
		this.centerName = centerName;
	}


	public Address getAddress() {
		return address;
	}


	public void setAddress(Address address) {
		this.address = address;
	}


	public Integer getStudentCapacity() {
		return studentCapacity;
	}


	public void setStudentCapacity(Integer studentCapacity) {
		this.studentCapacity = studentCapacity;
	}


	public List<String> getCoursesOffered() {
		return coursesOffered;
	}


	public void setCoursesOffered(List<String> coursesOffered) {
		this.coursesOffered = coursesOffered;
	}


	public String getContactEmail() {
		return contactEmail;
	}


	public void setContactEmail(String contactEmail) {
		this.contactEmail = contactEmail;
	}


	public String getContactPhone() {
		return contactPhone;
	}


	public void setContactPhone(String contactPhone) {
		this.contactPhone = contactPhone;
	}


	public long getCreatedOn() {
		return createdOn;
	}


	public void setCenterCode(String centerCode) {
		this.centerCode = centerCode;
	}


	public String getCenterCode() {
		// TODO Auto-generated method stub
		return null;
	}


}
