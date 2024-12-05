package com.pblgllgs.organizationservice.controller;
/*
 *
 * @author pblgl
 * Created on 03-12-2024
 *
 */

import com.pblgllgs.organizationservice.dto.OrganizationDto;
import com.pblgllgs.organizationservice.service.OrganizationService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.integration.support.management.SubscribableChannelManagement;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/organizations")
@RequiredArgsConstructor
@Tag(
    name = "Organization controller",
        description = "Organization controller exposes REST APIs for organization service"
)
public class OrganizationController {
    private final OrganizationService organizationService;
    private final SubscribableChannelManagement subscribableChannelManagement;

    @Operation(
            summary = "Save organization REST ENDPOINT",
            description = "Save organization REST API is used to save organization object in database"
    )
    @ApiResponse(
            responseCode = "201",
            description = "HttpStatus CREATED"
    )
    @PostMapping
    public ResponseEntity<OrganizationDto> createOrganization(@RequestBody OrganizationDto organizationDto) {
        return new ResponseEntity<>(organizationService.createOrganization(organizationDto), HttpStatus.CREATED);
    }

    @Operation(
            summary = "Get organization by code REST ENDPOINT",
            description = "Get organization by code REST API is used to get organization object by code"
    )
    @ApiResponse(
            responseCode = "200",
            description = "HttpStatus OK"
    )
    @GetMapping("/{organization-code}")
    public ResponseEntity<OrganizationDto> getOrganizationByCode(@PathVariable("organization-code") String organizationCode){
        return new ResponseEntity<>(organizationService.getByOrganizationCode(organizationCode), HttpStatus.OK);
    }

    @Operation(
            summary = "Get all organizations REST ENDPOINT",
            description = "Get all organizations REST API is used to get all organizations in database"
    )
    @ApiResponse(
            responseCode = "200",
            description = "HttpStatus OK"
    )
    @GetMapping
    public ResponseEntity<List<OrganizationDto>> findAll(){
        return new ResponseEntity<>(organizationService.getAllOrganizations(),HttpStatus.OK);
    }
}
