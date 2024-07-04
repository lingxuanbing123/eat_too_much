package com.cbl.backend.controller;


import com.cbl.backend.entity.Address;
import com.cbl.backend.entity.Business;
import com.cbl.backend.entity.User;
import com.cbl.backend.mapper.AddressMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

import static java.sql.DriverManager.println;

@RestController
public class AddressControl {

    @Resource
    AddressMapper addressMapper;

    @PostMapping("/address/save")
    public ResponseEntity<Void> save(@RequestBody Address address, HttpServletRequest request){
        User user = (User) request.getSession().getAttribute("user");
        if(user != null){
            address.setUserid(user.getUserid());
        }else{
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }

        try {
            addressMapper.save(address);
        }catch (Exception e){
            System.err.println(e.getMessage());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
    @GetMapping("/address/info")
    public List<Address> list(HttpServletRequest request){
        User user = (User) request.getSession().getAttribute("user");
        if (addressMapper.getAddressByUId(user.getUserid())!=null) {
            System.out.println(addressMapper.getAddressByUId(user.getUserid()));
            return addressMapper.getAddressByUId(user.getUserid());
        }
        else{
            println("No business");
            return null;
        }
    }

    @DeleteMapping("/address/{id}")
    public ResponseEntity<Void> delete(@PathVariable int id){

        try {
            addressMapper.delete(id);
        }catch (Exception e){
            System.err.println(e.getMessage());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }


}
