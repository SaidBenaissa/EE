package com.oatkachenko.controllers.api;

import com.oatkachenko.model.entity.Category;
import com.oatkachenko.services.impl.UtilService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * API контроллер для работы с категориями предоставляемых услуг
 */
@Controller
@RequestMapping(value = "/api/categories/")
public class ApiCategoryController {
    @Autowired
    private UtilService utilService;

    /**
     * @return список всех категорий услуг
     */
    @RequestMapping(value = "/all", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public List<Category> getAllCategories() {
        return utilService.getAllCategiries();
    }
}