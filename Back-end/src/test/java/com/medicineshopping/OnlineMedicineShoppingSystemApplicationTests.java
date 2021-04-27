package com.medicineshopping;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.medicineshopping.demo.dao.MedicineRepo;
import com.medicineshopping.demo.entity.Medicine;
import com.medicineshopping.demo.exceptions.MedicineNotFoundException;
import com.medicineshopping.demo.service.MedicineSerImpl;
@SpringBootTest
public class OnlineMedicineShoppingSystemApplicationTests {
    public static Optional<Medicine> optmedicine;
	@MockBean
	private MedicineRepo medicinerepo;
	@Autowired
	private MedicineSerImpl medicineser;
	@BeforeEach public void beforeeach()
	{
		optmedicine =Optional.of(new Medicine());
		Mockito.when(medicinerepo.findById(3)).thenReturn(optmedicine);
		Mockito.when(medicinerepo.findById(100)).thenThrow(MedicineNotFoundException.class); 
	}
	@Test
    public void testMedicineById_01() throws MedicineNotFoundException
    {
		assertNotNull(medicineser.getMedicineById(3));
    }
	@Test
	public void testMedicineById_02()
	{
		assertThrows(MedicineNotFoundException.class, ()->medicineser.getMedicineById(100));
	}

}