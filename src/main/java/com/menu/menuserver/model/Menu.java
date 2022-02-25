package com.menu.menuserver.model;

import com.vladmihalcea.hibernate.type.array.IntArrayType;
import com.vladmihalcea.hibernate.type.array.StringArrayType;
import lombok.Data;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "menus")
@TypeDefs({
        @TypeDef(
                name = "string-array",
                typeClass = StringArrayType.class
        ),
        @TypeDef(
                name = "integer-array",
                typeClass = IntArrayType.class
        )
})
public class Menu {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "userId", nullable = false)
    private Long userId;

    @Column(name = "companyName", nullable = false)
    private String companyName;

    @Type(type = "string-array")
    @Column(
            name = "types",
            columnDefinition = "text[]"
    )
    private String[] types;

    @Type(type = "string-array")
    @Column(
            name = "products",
            columnDefinition = "text[]"
    )
    private String[] products;

    @Type(type = "integer-array")
    @Column(
            name = "prices",
            columnDefinition = "integer[]"
    )
    private Integer[] prices;
}
