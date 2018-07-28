package br.com.hibejix.cms.domains.vo;

import br.com.hibejix.cms.domains.models.Role;
import lombok.Data;

@Data
public class UserRequest {

    private String identity;

    private String name;

    private Role role;

}

