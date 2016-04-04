package com.oatkachenko.services.impl;

import com.oatkachenko.model.dao.impl.UtilDaoImpl;
import com.oatkachenko.model.entity.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Home on 25.03.2016.
 */
@Service
@Transactional
public class UtilService {
    @Autowired
    UtilDaoImpl utilDao;

    public List<Category> getAllCategiries() {
        return utilDao.getAllCategories();
    }
}
