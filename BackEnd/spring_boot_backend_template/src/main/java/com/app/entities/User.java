package com.app.entities;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "User")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class User extends BaseEntity {

	@Column(name = "name")
	private String Name;

	@Column(name = "age")
	private int age;

	@Column(name = "email", unique = true)
	private String email;
	
	@ManyToOne(fetch = FetchType.EAGER)
	private BatchEntity batch;
	
	@Column(name = "paymentStatus")
	private String paymentStatus;
	
	@Column(name = "date")
	private LocalDate date;
	
}
