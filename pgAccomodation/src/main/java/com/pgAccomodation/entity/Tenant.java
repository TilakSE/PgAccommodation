package com.pgAccomodation.entity;

import java.util.List;

import jakarta.persistence.*;

@Entity
@Table(name = "tenant")
public class Tenant {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String phone;
    private String employmentPlace;
    private int age;

    @OneToMany(mappedBy = "tenant", cascade = CascadeType.ALL)
    private List<Booking> bookings;
    
    public Tenant() {}

	public Tenant(Long id, String firstName, String lastName, String email, String phone, String employmentPlace,
			int age, List<Booking> bookings) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.phone = phone;
		this.employmentPlace = employmentPlace;
		this.age = age;
		this.bookings = bookings;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmploymentPlace() {
		return employmentPlace;
	}

	public void setEmploymentPlace(String employmentPlace) {
		this.employmentPlace = employmentPlace;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public List<Booking> getBookings() {
		return bookings;
	}

	public void setBookings(List<Booking> bookings) {
		this.bookings = bookings;
	}

	@Override
	public String toString() {
		return "Tenant [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email
				+ ", phone=" + phone + ", employmentPlace=" + employmentPlace + ", age=" + age + ", bookings="
				+ bookings + "]";
	}
    
}
