package com.example.json.doctor;



import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

//DAO :Data access object
@Dao
public interface DoctorDao {

    @Query("SELECT * FROM doctor")
    List<Doctor> getAll();

    @Query("SELECT * FROM doctor WHERE id = :id")
    Doctor getStudentByID(Long id);

    @Insert
    Long insertStudent(Doctor student);
}
