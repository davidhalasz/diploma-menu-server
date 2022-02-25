package com.menu.menuserver.service;

import com.menu.menuserver.model.Menu;
import com.menu.menuserver.repository.projection.MenuItem;

import java.util.List;
import java.util.Optional;

public interface MenuService {
    Menu saveMenu(Menu menu);

    void deleteMenu(Long id);

    Optional<Menu> findById(Long menuId);

    Optional<MenuItem> findMenuById(Long menuId);

    List<MenuItem> findMenusByUserId(Long userId);
}
