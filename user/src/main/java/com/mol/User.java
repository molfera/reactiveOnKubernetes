package com.mol;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Getter
@Setter
@Table("users")
class User {

    @Id
    private Integer id;

    private String username;
}
