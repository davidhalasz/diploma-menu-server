package com.menu.menuserver.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.menu.menuserver.service.MenuService;

@RestController
@RequestMapping("api/show")
public class DisplayMenuController {
    @Autowired
    private MenuService menuService;

    @GetMapping("{menuId}")
    public ResponseEntity<?> getMenu(@PathVariable Long menuId) {
        return new ResponseEntity<>(menuService.findMenuById(menuId), HttpStatus.OK);
    }
}
