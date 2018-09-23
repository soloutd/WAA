package edu.mum.cs545.validator;

import edu.mum.cs545.model.User;
import edu.mum.cs545.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class CustomValidator implements ConstraintValidator<DuplicatedEmail, String> {

	@Autowired
	private UserService userService;

	@Override
	public void initialize(DuplicatedEmail arg0) {
	}

	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
	    User user = null;
		try {
		    user = userService.getByEmail(value);
		} catch (Exception e) {
			System.out.println("Couldn't find user...");
		}
		return user == null ? true : false;
	}

}
