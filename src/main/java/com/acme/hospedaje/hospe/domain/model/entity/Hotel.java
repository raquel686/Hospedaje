package com.acme.hospedaje.hospe.domain.model.entity;

import com.acme.hospedaje.shared.domain.model.AuditModel;
import lombok.*;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@Setter
@With
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Hotel")
public class Hotel extends AuditModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @NotBlank
    @Size(max = 100)
    @Column(unique = true)
    private String title;

    @NotNull
    @NotBlank
    @Size(max = 250)
    private String description;

    @NotNull
    @NotBlank
    @Lob
    @Type(type = "org.hibernate.type.TextType")
    private String content;

}
