package com.mol.documents;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;

@Getter
@Setter
class Recommendation {

    @Id
    private String id;

    private String description;

}
