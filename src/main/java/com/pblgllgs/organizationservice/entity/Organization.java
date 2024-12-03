package com.pblgllgs.organizationservice.entity;
/*
 *
 * @author pblgl
 * Created on 03-12-2024
 *
 */

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name= "organizations")
public class Organization {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "organization_name", nullable = false)
    private String organizationName;
    @Column(name = "organization_description", nullable = false)
    private String organizationDescription;
    @Column(name = "organization_code", nullable = false, unique = true)
    private String organizationCode;
    @CreationTimestamp
    @Column(name = "created_at")
    private LocalDateTime createdAt;
}
