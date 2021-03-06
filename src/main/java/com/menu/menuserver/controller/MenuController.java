package com.menu.menuserver.controller;

import com.menu.menuserver.model.Menu;
import com.menu.menuserver.security.UserPrincipal;
import com.menu.menuserver.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/menu")
public class MenuController {

    @Autowired
    private MenuService menuService;

    @PostMapping
    public ResponseEntity<?> saveMenu(@RequestBody Menu menu) {
        return new ResponseEntity<>(menuService.saveMenu(menu), HttpStatus.CREATED);
    }

    @DeleteMapping("{menuId}")
    public ResponseEntity<?> deleteMenu(@PathVariable Long menuId) {
        menuService.deleteMenu(menuId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("{menuId}")
    public ResponseEntity<?> getMenu(@PathVariable Long menuId) {
        return new ResponseEntity<>(menuService.findById(menuId), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<?> getAllMenusByUserId(@AuthenticationPrincipal UserPrincipal userPrincipal) {
        return ResponseEntity.ok(menuService.findMenusByUserId(userPrincipal.getId()));
    }

}
