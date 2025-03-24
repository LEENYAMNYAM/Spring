package com.example.springexam01.model;

import com.example.springexam01.dto.AddressDTO;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressServiceImpl implements AddressService{

    @Autowired
    private SqlSession sqlMapper;

    //추가
    @Override
    public void insertAddress(AddressDTO address) {
        sqlMapper.insert("addressInsert",address);
    }
    //전체보기
    @Override
    public List<AddressDTO> findAll() {
        List<AddressDTO> addressList = sqlMapper.selectList("addressList");
        return addressList;
    }
    //상세보기
    @Override
    public AddressDTO viewAddress(int num) {
        AddressDTO address = sqlMapper.selectOne("addressView", num);
        return address;
    }
    //수정
    @Override
    public void updateAddress(AddressDTO addressDTO) {
        sqlMapper.update("addressUpdate",addressDTO);
    }
    //삭제
    @Override
    public void deleteAddress(int num) {
        sqlMapper.delete("addressDelete", num);
    }
    //갯수
    @Override
    public int countAddress() {
        int count = sqlMapper.selectOne("countAddress");
        return count;
    }


}
