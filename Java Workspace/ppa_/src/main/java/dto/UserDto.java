package dto;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

import lombok.Data;

@Data
@Entity
public class UserDto {
	@Id
	@GeneratedValue(generator = "usno")
	@SequenceGenerator(initialValue = 1001, allocationSize = 1, sequenceName = "usno", name = "usno")
	int id;
	String name;
	String email;
	String password;
	long mobile;
	Date dob;
	String gender;
	boolean status;
}
