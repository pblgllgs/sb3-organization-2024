package com.pblgllgs.organizationservice.controller;
/*
 *
 * @author pblgl
 * Created on 03-12-2024
 *
 */

import com.pblgllgs.organizationservice.dto.OrganizationDto;
import com.pblgllgs.organizationservice.service.OrganizationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/organizations")
@RequiredArgsConstructor
public class OrganizationController {
    private final OrganizationService organizationService;

    @PostMapping
    public ResponseEntity<OrganizationDto> createOrganization(@RequestBody OrganizationDto organizationDto) {
        return new ResponseEntity<>(organizationService.createOrganization(organizationDto), HttpStatus.CREATED);
    }

    @GetMapping("/{organization-code}")
    public ResponseEntity<OrganizationDto> getOrganizationByCode(@PathVariable("organization-code") String organizationCode){
        return new ResponseEntity<>(organizationService.getByOrganizationCode(organizationCode), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<OrganizationDto>> findAll(){
        return new ResponseEntity<>(organizationService.getAllOrganizations(),HttpStatus.OK);
    }
}
