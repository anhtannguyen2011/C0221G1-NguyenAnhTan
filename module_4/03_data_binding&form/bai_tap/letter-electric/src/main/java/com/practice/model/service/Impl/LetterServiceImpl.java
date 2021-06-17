package com.practice.model.service.Impl;

import com.practice.model.base.LetterElectric;
import com.practice.model.repository.ILetterRepository;
import com.practice.model.service.ILetterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class LetterServiceImpl implements ILetterService {
    @Qualifier("letterRepositoryImpl")
    @Autowired
    public ILetterRepository iLetterRepository;
    @Override
    public List<String> getListLanguage() {
        return iLetterRepository.getListLanguage();
    }

    @Override
    public List<Integer> getListPageSize() {
        return iLetterRepository.getListPageSize();
    }

    @Override
    public void update(LetterElectric electric) {
        iLetterRepository.update(electric);
    }
}
