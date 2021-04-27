package com.medicineshopping.demo.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.medicineshopping.demo.constant.MedicineConstant;
import com.medicineshopping.demo.dto.MedicineDTO;
import com.medicineshopping.demo.dto.SuccessMessageDTO;
import com.medicineshopping.demo.entity.Medicine;
import com.medicineshopping.demo.exceptions.MedicineNotFoundException;
import com.medicineshopping.demo.exceptions.ValidateException;
import com.medicineshopping.demo.service.MedicineSer;

/**
 * @author Kaul's
 *
 */
@CrossOrigin(origins = "http://localhost:3000")
@RestController // Maps web requests
@RequestMapping("/api/v1/")
public class MedicineController {

	@Autowired // injects object dependencies
	MedicineSer medicineser;

	@PostMapping("/medicines") // Maps the HTTP POST requests on the specific handler method
	public SuccessMessageDTO addMedicine(@Valid @RequestBody MedicineDTO medicinedto, BindingResult br)
			throws ValidateException {
		if (br.hasErrors())
			throw new ValidateException(br.getFieldErrors());
		// Medicine id=medicineser.addMedicine(medicinedto);
		int id = medicineser.addMedicine(medicinedto);
		return new SuccessMessageDTO(MedicineConstant.MEDICINE_ADDED + id);
	}

	@PutMapping("/medicines") // Maps the HTTP PUT requests on the specific handler method
	public Medicine updateMedicine(@RequestBody Medicine medicine) throws MedicineNotFoundException {
//		Medicine med=medicineser.updateMedicine(medicine);
//    	return new SuccessMessageDTO(MedicineConstant.MEDICINE_EDITED);		
		return medicineser.updateMedicine(medicine);
	}

	@DeleteMapping("/medicines/{medicineId}") // Maps the HTTP DELETE requests on the specific handler method
	public SuccessMessageDTO deletemedicineById(@PathVariable("medicineId") int medicineId)
			throws MedicineNotFoundException {
		medicineser.deleteMedicine(medicineId);
		return new SuccessMessageDTO(MedicineConstant.MEDICINE_DELETE + medicineId);
	}

	@GetMapping("/medicines/{medicineId}") // Maps the HTTP GET requests on the specific handler method
	public Medicine getmedicinebyId(@PathVariable("medicineId") int medicineId) throws MedicineNotFoundException {
		return medicineser.getMedicineById(medicineId);
		// return new SuccessMessageDTO(MedicineConstant.MEDICINE_GET);
	}

	@SuppressWarnings("rawtypes")
	@GetMapping("/medicines") // Maps the HTTP GET requests on the specific handler method
	public List getAllMedicines() throws MedicineNotFoundException {
		return medicineser.getAllMedicine();
	}

}