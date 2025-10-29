package com.pgAccomodation.entity;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.*;

@Entity
@Table(name = "accommodation")
public class Accommodation {

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    @Column(columnDefinition = "TEXT")
    private String description;

    private Double rent;

    private String roomType;
    private LocalDate availableFrom;

    @ManyToOne
    @JoinColumn(name = "owner_id")
    @JsonBackReference    // 👈 paired with @JsonManagedReference
    private Owner owner;

    @OneToOne
    @JoinColumn(name = "address_id")
    private Address address;

    public Accommodation() {}
    
	public Accommodation(Long id, String title, String description, Double rent, String roomType,
			LocalDate availableFrom, Owner owner, Address address) {
		this.id = id;
		this.title = title;
		this.description = description;
		this.rent = rent;
		this.roomType = roomType;
		this.availableFrom = availableFrom;
		this.owner = owner;
		this.address = address;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Double getRent() {
		return rent;
	}

	public void setRent(Double rent) {
		this.rent = rent;
	}

	public String getRoomType() {
		return roomType;
	}

	public void setRoomType(String roomType) {
		this.roomType = roomType;
	}

	public LocalDate getAvailableFrom() {
		return availableFrom;
	}

	public void setAvailableFrom(LocalDate availableFrom) {
		this.availableFrom = availableFrom;
	}

	public Owner getOwner() {
		return owner;
	}

	public void setOwner(Owner owner) {
		this.owner = owner;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "Accommodation [id=" + id + ", title=" + title + ", description=" + description + ", rent=" + rent
				+ ", roomType=" + roomType + ", availableFrom=" + availableFrom + ", owner=" + owner + ", address="
				+ address + "]";
	}
    
}
