package com.mol.mainservice;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
class DocumentDTO {

    private String id;

    private String description;

    public static DocumentDTO ofDescription(String description) {
        DocumentDTO documentDTO = new DocumentDTO();
        documentDTO.setDescription(description);
        return documentDTO;
    }
}
