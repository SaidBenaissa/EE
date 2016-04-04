package com.oatkachenko.Transformers;

import com.oatkachenko.model.dto.TaskDto;
import com.oatkachenko.model.dto.UserDto;
import com.oatkachenko.model.entity.Task;
import com.oatkachenko.model.entity.User;

/**
 * Created by Home on 24.03.2016.
 */
public class Transformer {
    public static User userFromDto(UserDto dto) {
        User user = new User();
        user.setUsername(dto.getUsername());
        user.setPassword(dto.getPassword());
        user.setEmail(dto.getEmail());
        return user;
    }

    public static UserDto dtoFromUser(User user) {
        UserDto dto = new UserDto();
        dto.setUsername(user.getUsername());
//        dto.setPassword(user.getPassword());
        dto.setEmail(user.getEmail());
        dto.setJoined(user.getJoined());
        dto.setLastseen(user.getLastseen());
        return dto;
    }

    public static Task taskFromDto(TaskDto dto) {
        Task task = new Task();
        task.setTitle(dto.getTitle());
        task.setDescription(dto.getDescription());
        task.setCategoryId(dto.getCategoryId());
        task.setPrice(dto.getPrice());
        return task;
    }

    public static TaskDto dtoFromTask(Task task) {
        TaskDto dto = new TaskDto();
        dto.setTitle(task.getTitle());
        dto.setDescription(task.getDescription());
        dto.setCategoryId(task.getCategoryId());
        dto.setCustomer(task.getCustomer());
        dto.setPrice(task.getPrice());
        return dto;
    }

}
