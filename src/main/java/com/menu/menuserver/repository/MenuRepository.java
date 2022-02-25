package com.menu.menuserver.repository;

import com.menu.menuserver.model.Menu;
import com.menu.menuserver.repository.projection.MenuItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface MenuRepository extends JpaRepository<Menu, Long> {
    @Query("select " +
            "m.id as id, m.userId as userId, m.companyName as companyName, " +
            "m.types as types, m.products as products, m.prices as prices " +
            "from Menu m " +
            "where m.userId = :userId")
    List<MenuItem> findAllMenusByUserId(@Param("userId") Long userId);

    @Query("select " +
            "m.id as id, m.userId as userId, m.companyName as companyName, " +
            "m.types as types, m.products as products, m.prices as prices " +
            "from Menu m " +
            "where m.id = :id")
    Optional<MenuItem> findSingleMenuById(@Param("id") Long id);
}
