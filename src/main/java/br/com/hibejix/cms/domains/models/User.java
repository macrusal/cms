package br.com.hibejix.cms.domains.models;

import lombok.Data;

@Data
public class User {

    private String id;

    private String identity;

    private String name;

    private Role role;
}
