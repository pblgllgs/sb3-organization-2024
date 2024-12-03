package com.pblgllgs.organizationservice.service;

import com.pblgllgs.organizationservice.dto.OrganizationDto;

import java.util.List;

public interface OrganizationService {
    OrganizationDto createOrganization(OrganizationDto organizationDto);
    OrganizationDto getByOrganizationCode(String organizationCode);
    List<OrganizationDto> getAllOrganizations();
}
