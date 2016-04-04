package com.oatkachenko.validators;

import com.oatkachenko.model.dto.TaskDto;
import com.oatkachenko.services.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

/**
 * Created by Home on 25.03.2016.
 */
@Component
public class TaskValidator implements Validator {
    @Autowired
    TaskService taskService;

    @Override
    public boolean supports(Class<?> aClass) {
        return TaskDto.class.isAssignableFrom(aClass);
    }

    @Override
    public void validate(Object obj, Errors errors) {
        TaskDto dto = (TaskDto) obj;

        if (dto.getCategoryId() == -1) {
            errors.rejectValue("categoryId", "wrong.category.id", "wrong.category.id");
        }
        if (dto.getDescription().length() >= 500) {
            errors.rejectValue("description", "description", "description too long");
        }


    }
}
