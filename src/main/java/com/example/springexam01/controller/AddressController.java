package com.example.springexam01.controller;

import com.example.springexam01.dto.AddressDTO;
import com.example.springexam01.model.AddressService;
import com.example.springexam01.model.AddressServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// address 폴더를 타고 들어오도록 하려면
@RequestMapping("/address")

@Controller
public class AddressController {

    @Autowired
    private AddressServiceImpl addressService;

    // 추가폼으로 이동
    @GetMapping("insert")
    public String insert(){
        return "address/insert";
    }

    //추가
    @PostMapping("insert")
    public String insert(@ModelAttribute AddressDTO address) {
        addressService.insertAddress(address);
        return "redirect:list";
    }

    //전체보기
    @GetMapping("list")
    public String list(Model model) {
        List<AddressDTO> addressList = addressService.findAll();
        int count = addressService.countAddress();
        model.addAttribute("alist", addressList);
        model.addAttribute("count", count);
        return "address/list";

    }

    //상세보기
    @GetMapping("view")
    public String view(@RequestParam("num") int num, Model model) {
        AddressDTO address = addressService.viewAddress(num);
        model.addAttribute("address", address);
        return "address/view";
    }

    //수정
    @PostMapping("update")
    public String update(@ModelAttribute AddressDTO address) {
        addressService.updateAddress(address);
        return "redirect:list";
    }

    //삭제
    @GetMapping("delete")
    public String delete(@RequestParam("num") int num, Model model) {
        addressService.deleteAddress(num);
        return "redirect:list";
    }
}
