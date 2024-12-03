package com.pblgllgs.organizationservice.dto;
/*
 *
 * @author pblgl
 * Created on 03-12-2024
 *
 */

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class OrganizationDto {
    private Long id;
    private String organizationName;
    private String organizationDescription;
    private String organizationCode;
    private LocalDateTime createdAt;
}
