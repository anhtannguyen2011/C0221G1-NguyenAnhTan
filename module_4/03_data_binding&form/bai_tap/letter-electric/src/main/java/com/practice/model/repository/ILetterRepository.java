package com.practice.model.repository;

import com.practice.model.base.LetterElectric;

import java.util.List;

public interface ILetterRepository {
    List<String> getListLanguage();
    List<Integer> getListPageSize();
    void update(LetterElectric electric);
}
