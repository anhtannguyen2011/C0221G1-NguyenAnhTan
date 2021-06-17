package com.practice.model.repository.Impl;

import com.practice.model.base.LetterElectric;
import com.practice.model.repository.ILetterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
@Repository
public class LetterRepositoryImpl implements ILetterRepository {

    static List<String> listLanguage;
    static List<Integer> listPageSize;
    static List<LetterElectric> electricList;

    static {
        listLanguage = new ArrayList<>();
        listPageSize = new ArrayList<>();
        electricList = new ArrayList<>();


        listLanguage.add("English");
        listLanguage.add("Vietnamese");
        listLanguage.add("Japanese");
        listLanguage.add("Chinese");

        listPageSize.add(5);
        listPageSize.add(10);
        listPageSize.add(15);
        listPageSize.add(25);
        listPageSize.add(50);
        listPageSize.add(100);


    }

    @Override
    public List<String> getListLanguage() {
        return listLanguage;
    }

    @Override
    public List<Integer> getListPageSize() {
        return listPageSize;
    }

    @Override
    public void update(LetterElectric electric) {
        electricList.add(electric);
    }
}
