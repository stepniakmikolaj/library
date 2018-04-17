package com.crud.library.Service;

import com.crud.library.dao.TitleDao;
import com.crud.library.model.Title;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Transactional
@Service
public class TitleService {
    @Autowired
    TitleDao titleDao;

    public Title saveTitle(final Title title) {
        return titleDao.save(title);
    }
}
