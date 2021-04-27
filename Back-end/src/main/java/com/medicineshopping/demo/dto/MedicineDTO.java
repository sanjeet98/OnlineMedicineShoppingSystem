package com.medicineshopping.demo.dto;

import java.time.LocalDate;

import javax.validation.constraints.Future;
import javax.validation.constraints.Min;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

/**
 * @author Kaul's
 *
 */
public class MedicineDTO {

	@Pattern(regexp = "[A-Z][a-z]{3,20}")
	private String medicineName;
	@Size(min = 3)
	private String medicineBrand;
	@Min(value = 20, message = "Price must be minimum RS20")
	private double medicineprice;
	private String medicineCategory;
	@Future(message = "Expiry Date must be future date")
	private LocalDate expiryDate;
	private String medicineDescription;

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

	public MedicineDTO() {

	}

}