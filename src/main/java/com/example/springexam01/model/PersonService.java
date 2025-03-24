package com.example.springexam01.model;

import com.example.springexam01.dto.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonService {

    @Autowired
    private PersonDAO personDAO;
    //추가
    public void insert(Person person) {
        personDAO.dao_insert(person);
    }


    //전체보기
    public List<Person> findAll() {
        List<Person> personList =  personDAO.dao_list();
        return personList;
    }

    // 개수
    public int getCount() {
        return personDAO.dao_count();
    }

    //상세보기
    public Person view(String id) {
        Person person = personDAO.dao_view(id);
    return person;
    }

    //삭제
    public void delete(String id){
        personDAO.dao_delete(id);
    }

    // 수정폼
    public Person updateForm(String id) {
        Person person = personDAO.dao_view(id);
        return person;
    }

    //수정
    public void update(Person person) {
        personDAO.dao_update(person);
    }


}
