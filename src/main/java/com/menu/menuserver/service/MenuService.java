package com.menu.menuserver.service;

import com.menu.menuserver.model.Menu;

import java.util.Optional;

public interface MenuService {
    Menu saveMenu(Menu menu);

    void deleteMenu(Long id);

    Optional<Menu> findById(Long menuId);
}
