package com.medicineshopping.demo.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author Kaul's
 *
 */
@Entity
@Table(name = "medicine_details")
public class Medicine {
	@Id
	@GeneratedValue
	@Column(name = "medicine_id")
	private int medicineId;
	private String medicineName;
	private String medicineBrand;
	private double medicineprice;
	private String medicineStatus;
	private String medicineStock;
	private String medicineCategory;
	private LocalDate expiryDate;
	private String medicineDescription;

	public int getMedicineId() {
		return medicineId;
	}

	public void setMedicineId(int medicineId) {
		this.medicineId = medicineId;
	}

	public String getMedicineName() {
		return medicineName;
	}

	public void setMedicineName(String medicineName) {
		this.medicineName = medicineName;
	}

	public String getMedicineBrand() {
		return medicineBrand;
	}

	public void setMedicineBrand(String medicineBrand) {
		this.medicineBrand = medicineBrand;
	}

	public double getMedicineprice() {
		return medicineprice;
	}

	public void setMedicineprice(double medicineprice) {
		this.medicineprice = medicineprice;
	}

	public String getMedicineStatus() {
		return medicineStatus;
	}

	public void setMedicineStatus(String medicineStatus) {
		this.medicineStatus = medicineStatus;
	}

	public String getMedicineStock() {
		return medicineStock;
	}

	public void setMedicineStock(String medicineStock) {
		this.medicineStock = medicineStock;
	}

	public String getMedicineCategory() {
		return medicineCategory;
	}

	public void setMedicineCategory(String medicineCategory) {
		this.medicineCategory = medicineCategory;
	}

	public LocalDate getExpiryDate() {
		return expiryDate;
	}

	public void setExpiryDate(LocalDate expiryDate) {
		this.expiryDate = expiryDate;
	}

	public String getMedicineDescription() {
		return medicineDescription;
	}

	public void setMedicineDescription(String medicineDescription) {
		this.medicineDescription = medicineDescription;
	}

	public Medicine() {

	}
}