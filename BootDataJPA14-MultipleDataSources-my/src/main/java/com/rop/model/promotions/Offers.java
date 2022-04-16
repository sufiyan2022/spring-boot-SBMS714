package com.rop.model.promotions;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.sun.istack.NotNull;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Entity
@Table(name="MDS_OFFERS")
@Data
@NoArgsConstructor 
//@RequiredArgsConstructor
public class Offers {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer offerId;
	
	@NotNull
	@Column(length=20)
	private String offerName;
	
	@NotNull
	@Column(length=20)
	private String offerCode;
	
	@NotNull
	@Column(length=20)
	private Double discountPercentage;
	
	@NonNull
	private LocalDateTime expiryDate;
	
}
