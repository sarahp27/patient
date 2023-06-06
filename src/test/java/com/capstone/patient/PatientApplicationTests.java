package com.capstone.patient;

import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.AutoConfigureJsonTesters;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.json.JacksonTester;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.capstone.patient.controller.PatientController;
import com.capstone.patient.entity.Patients;
import com.capstone.patient.repository.PatientRepo;
import com.fasterxml.jackson.databind.ObjectMapper;


@AutoConfigureJsonTesters
@AutoConfigureMockMvc
@SpringBootTest
class PatientApplicationTests {

	@Autowired
	private MockMvc mvc;

	@Autowired
	private WebApplicationContext context;

	@Mock
	private PatientRepo patientRepo;

	@InjectMocks
	private PatientController patientController;

	private JacksonTester<Patients> jsonPatient;
	private JacksonTester<List<Patients>> jsonPatients;

	
	@BeforeEach
	public void setUp() {
		JacksonTester.initFields(this, new ObjectMapper());
		mvc = MockMvcBuilders.standaloneSetup(patientController).build();
	}

	@Test
	void contextLoads() {
	}

	// Test # 1 : Add the Patient

	@Test   
	public void canAddPatient() throws Exception{
		Patients patient = new Patients( 1, "0444-3333333");
		
		when(patientRepo.save(patient)).thenReturn(patient);

		mvc.perform(MockMvcRequestBuilders
		.post("/patient/add")
		.contentType(MediaType.APPLICATION_JSON)
		.content(jsonPatient.write(patient).getJson()))
		.andExpect(MockMvcResultMatchers.status().isOk());
	}

	// Test # 2 : Get a list of Patients

	@Test
	public void canGetAllPatients() throws Exception {
		Patients patient1 = new Patients( 1, "0233-8222111");
		Patients patient2 = new Patients( 2, "0345-6332229");
		
		List<Patients> patientList = new ArrayList<>();
		patientList.add(patient1);
		patientList.add(patient2);

		when(patientRepo.findAll()).thenReturn(patientList);

		mvc.perform(MockMvcRequestBuilders
				.get("/patient/list?id=0")
				.contentType(MediaType.APPLICATION_JSON))
				.andExpect(MockMvcResultMatchers.status().isOk())
				.andExpect(MockMvcResultMatchers.content().json(jsonPatients.write(patientList).getJson()));
	}

	// Test # 3 : Get a Patient by Id

	@Test
	public void canGetAPatient() throws Exception {
		Patients patient1 = new Patients( 1L, "0233-8222111");
		
		when(patientRepo.findById(1L)).thenReturn(Optional.of(patient1));

		mvc.perform(MockMvcRequestBuilders.get("/patient/1")
				.contentType(MediaType.APPLICATION_JSON))
				.andExpect(MockMvcResultMatchers.status().isOk())
				.andExpect(MockMvcResultMatchers.content().json(jsonPatient.write(patient1).getJson()));
	}
	
	// Test # 4 : Delete a patient

	@Test
	public void canDeletePatient() throws Exception {
		
		long id = 1;
		doNothing().when(patientRepo).deleteById(id);
		mvc.perform(MockMvcRequestBuilders.delete("/patient/delete/1"))
			.andExpect(MockMvcResultMatchers.status().isOk());
	}

	// Test # 5 : Update a patient

	@Test
	public void canUpdateAPatient() throws Exception{
		Patients patient1 = new Patients(1, "0233-8222111");

		when(patientRepo.save(patient1)).thenReturn(patient1);

		mvc.perform(MockMvcRequestBuilders.post("/patient/update")
			.contentType(MediaType.APPLICATION_JSON)
			.content(jsonPatient.write(patient1).getJson()))
			.andExpect(MockMvcResultMatchers.status().isOk());
			
	}
}
