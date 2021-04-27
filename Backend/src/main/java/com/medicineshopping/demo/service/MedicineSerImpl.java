package com.medicineshopping.demo.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.medicineshopping.demo.constant.MedicineConstant;
import com.medicineshopping.demo.dao.MedicineRepo;
import com.medicineshopping.demo.dto.MedicineDTO;
import com.medicineshopping.demo.entity.Medicine;
import com.medicineshopping.demo.exceptions.MedicineNotFoundException;


@Service("medicineservice") //Contains the actual business logic
@Transactional //Defines scope of a database transcation
public class MedicineSerImpl implements MedicineSer{
	
	@Autowired //Injects the object dependency
	MedicineRepo medicinerepo;

     @Override
	 public int addMedicine(MedicineDTO medicinedto) {  
		Medicine medicine=new Medicine();
		medicine.setMedicineBrand(medicinedto.getMedicineBrand());
		medicine.setMedicineCategory(medicinedto.getMedicineCategory());
		medicine.setMedicineName(medicinedto.getMedicineName());
		medicine.setMedicineDescription(medicinedto.getMedicineDescription());
		medicine.setMedicineStatus(MedicineConstant.AVAILABLE);
		medicine.setMedicineprice(medicinedto.getMedicineprice());
		@SuppressWarnings("unused")//Removes compiler warnings
		LocalDate strexpdate=medicinedto.getExpiryDate();
		//LocalDate ldt=LocalDate.parse(strexpdate,DateTimeFormatter.ofPattern("yyyy-M-d"));
		medicine.setExpiryDate(medicinedto.getExpiryDate());
		Medicine newmedicine=medicinerepo.save(medicine);
		// TODO Auto-generated method stub
		return newmedicine.getMedicineId();
	}
 
    
    @Override
	public void deleteMedicine(int medicineId) throws MedicineNotFoundException 
    {
    	Optional<Medicine> optmedicine=medicinerepo.findById(medicineId);
    	if(optmedicine.isEmpty()) throw new MedicineNotFoundException(MedicineConstant.MEDICINE_NOT_FOUND);
    	Medicine medicine=optmedicine.get();
    	medicinerepo.delete(medicine);
		//medicinerepo.deleteById(medicineId);
	}
	public Medicine getMedicineById(int medicineId) throws MedicineNotFoundException {
		// TODO Auto-generated method stub
		//Optional is a container object that contains not null objects
		Optional <Medicine> optmedicine=medicinerepo.findById(medicineId);
		if(optmedicine.isPresent())
		{
			return optmedicine.get();
		}
		throw new MedicineNotFoundException(MedicineConstant.MEDICINE_NOT_FOUND);
	}

	@Override
	public List<Medicine> getAllMedicine() throws MedicineNotFoundException {
		// TODO Auto-generated method stub
		if(medicinerepo.findAll().isEmpty())
		{
			throw new MedicineNotFoundException(MedicineConstant.MEDICINE_NOT_FOUND);
		}
		else
		{
			return medicinerepo.findAll();
		}
		
	}

	@Override
	public Medicine updateMedicine(Medicine medicine) throws MedicineNotFoundException {
		// TODO Auto-generated method stub
		if(medicine.getMedicineName().isEmpty())
		{
			throw new MedicineNotFoundException(MedicineConstant.MEDICINE_NOT_UPDATED);
		}
		else
		{
		return medicinerepo.save(medicine);
		}
	}


	
}