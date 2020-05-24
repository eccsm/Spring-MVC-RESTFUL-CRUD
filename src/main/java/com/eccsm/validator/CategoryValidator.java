package com.eccsm.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.eccsm.model.Category;

@Component
public class CategoryValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {

		return Category.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {

		Category category = (Category) target;

		if (category.getName() == null) {
			errors.rejectValue("name", "name.required", "Name is Required");
		}


		if (category.getName().length() < 4 || category.getName().length() > 8) {
			errors.rejectValue("name", "name.length", "Please enter Category name within 4 to 8 charaters only");
		}



	}

}
