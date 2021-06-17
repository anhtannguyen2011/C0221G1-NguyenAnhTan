package com.practice.model.service;

import com.practice.model.base.LetterElectric;
import com.practice.model.repository.ILetterRepository;

import java.util.List;

public interface ILetterService extends ILetterRepository {
    @Override
    List<String> getListLanguage();

    @Override
    List<Integer> getListPageSize();

}
