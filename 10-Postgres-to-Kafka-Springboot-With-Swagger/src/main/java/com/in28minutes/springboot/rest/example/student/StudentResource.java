package com.in28minutes.springboot.rest.example.student;

import com.in28minutes.springboot.rest.example.model.User;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import java.net.URI;
import java.util.List;
import java.util.Optional;
import java.util.Random;
import org.springframework.web.bind.annotation.*;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.sql.*;
import java.util.*;

@RestController
@RequestMapping("kafka")
public class StudentResource {

	@Autowired
	private KafkaTemplate<String, User> kafkaTemplate;

	private static final String TOPIC = "swatiTest2";

	@Autowired
	private StudentRepository studentRepository;

	@GetMapping("/students")
	public List<Student> retrieveAllStudents() {
		return studentRepository.findAll();
	}

	@RequestMapping(method = RequestMethod.GET, value = "/api/helloworld")
	public String sayHello() throws Exception{

		Random rand = new Random();
		int upperbound = 25;
		int int_random1 = rand.nextInt(upperbound);
	  int int_random2 = rand.nextInt(upperbound);
		String generatedString1 = "user" + String.valueOf(int_random1);
    String generatedString2 = "department" + String.valueOf(int_random2);


		Connection conn1 = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "");
		Statement st1 = conn1.createStatement();
		String myquery = "INSERT INTO users(name, department) values ('" + generatedString1 + "', '" + generatedString2 + "')";

    System.out.println(myquery);
    st1.executeUpdate("INSERT INTO users(name, department) values ('" + generatedString1 + "', '" + generatedString2 + "')");

		st1.close();
		conn1.close();

		return "Swagger Hello World - executed " + myquery;
	}

	@RequestMapping(method = RequestMethod.GET, value = "/details")
	public String postTran() throws Exception
	    {

	      Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "");
	      Statement st = conn.createStatement();
	      ResultSet rs = st.executeQuery("SELECT * FROM users");
	      String result = " Contents of DB = ";
				String name = "";
				String department = "";

	      while (rs.next()) {
	              //result = result + rs.getString("name") + " and " + rs.getString("location");
								name = rs.getString("name");
								department = rs.getString("department");
								result = result + name + " and " + department + " and ";
	              System.out.println("my result = " + result);
								kafkaTemplate.send(TOPIC, new User(name, department, 1200L));
	      }

	      rs.close();
	      st.close();
	      conn.close();

				//kafkaTemplate.send(TOPIC, new User(name, department, 12000L));

	      return "Received from postgres successfully sent to kafka =>  " + result + " <= ";

	    }

	@GetMapping("/students/{id}")
	@Operation(summary = "Find student by id, also returns a link to retrieve all students with rel - all-students")
	public EntityModel<Student> retrieveStudent(@PathVariable long id) {
		Optional<Student> student = studentRepository.findById(id);

		if (!student.isPresent())
			throw new StudentNotFoundException("id-" + id);

		EntityModel<Student> resource = EntityModel.of(student.get());

		WebMvcLinkBuilder linkTo = linkTo(methodOn(this.getClass()).retrieveAllStudents());

		resource.add(linkTo.withRel("all-students"));

		return resource;
	}

	@DeleteMapping("/students/{id}")
	public void deleteStudent(@PathVariable long id) {
		studentRepository.deleteById(id);
	}

	@PostMapping("/students")
	public ResponseEntity<Object> createStudent(@RequestBody Student student) {
		Student savedStudent = studentRepository.save(student);

		URI location = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}")
				.buildAndExpand(savedStudent.getId())
				.toUri();

		return ResponseEntity.created(location).build();

	}

	@PutMapping("/students/{id}")
	public ResponseEntity<Object> updateStudent(@RequestBody Student student, @PathVariable long id) {

		Optional<Student> studentOptional = studentRepository.findById(id);

		if (!studentOptional.isPresent())
			return ResponseEntity.notFound().build();

		student.setId(id);

		studentRepository.save(student);

		return ResponseEntity.noContent().build();
	}
}
