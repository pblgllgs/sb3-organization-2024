package com.pblgllgs.organizationservice.service.impl;
/*
 *
 * @author pblgl
 * Created on 03-12-2024
 *
 */

import com.pblgllgs.organizationservice.dto.OrganizationDto;
import com.pblgllgs.organizationservice.entity.Organization;
import com.pblgllgs.organizationservice.repository.OrganizationRepository;
import com.pblgllgs.organizationservice.service.OrganizationService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class OrganizationServiceImpl implements OrganizationService {
    private final OrganizationRepository organizationRepository;
    private final ModelMapper modelMapper;

    @Override
    public OrganizationDto createOrganization(OrganizationDto organizationDto) {
        Organization organization = new Organization(
                organizationDto.getId(),
                organizationDto.getOrganizationName(),
                organizationDto.getOrganizationDescription(),
                organizationDto.getOrganizationCode(),
                organizationDto.getCreatedAt()
        );
        organizationRepository.save(organization);
        return modelMapper.map(organization, OrganizationDto.class);
    }

    @Override
    public OrganizationDto getByOrganizationCode(String organizationCode) {
        Optional<Organization> organizationOptional = organizationRepository.findByOrganizationCode(organizationCode);
        if (organizationOptional.isEmpty()) {
            throw new RuntimeException("Organization not found");
        }
        return modelMapper.map(organizationOptional.get(), OrganizationDto.class);
    }

    @Override
    public List<OrganizationDto> getAllOrganizations() {
        return organizationRepository.findAll()
                .stream()
                .map(organization -> modelMapper.map(organization, OrganizationDto.class))
                .toList();
    }
}
