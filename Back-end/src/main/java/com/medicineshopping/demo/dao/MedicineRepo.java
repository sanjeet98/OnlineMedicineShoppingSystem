package com.medicineshopping.demo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.medicineshopping.demo.entity.Medicine;

/**
 * @author Kaul's
 *
 */
@SuppressWarnings("unused")
@Repository
public interface MedicineRepo extends JpaRepository<Medicine, Integer> {

}