package com.medicineshopping.demo.service;

import java.util.List;

import com.medicineshopping.demo.dto.MedicineDTO;
import com.medicineshopping.demo.entity.Medicine;
import com.medicineshopping.demo.exceptions.MedicineNotFoundException;

public interface MedicineSer {
	
	int addMedicine(MedicineDTO medicinedto);  //Adds the medicines to datatbase
		
	Medicine updateMedicine(Medicine medicine) throws MedicineNotFoundException ; //Updates the medicine details
	
	void deleteMedicine(int medicineId) throws MedicineNotFoundException; // Deletes medicines by passing the medicineid
	
	List<Medicine> getAllMedicine() throws MedicineNotFoundException; //Gets the detils of all the medicines
	
	Medicine getMedicineById(int medicineId) throws MedicineNotFoundException; //Gets the details of medicine by medicineid
		
	
	
	
	
	

}