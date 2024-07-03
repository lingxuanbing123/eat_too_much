package com.cbl.backend.controller;


import com.cbl.backend.mapper.AddressMapper;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class AddressControl {

    @Resource
    AddressMapper addressMapper;


}
