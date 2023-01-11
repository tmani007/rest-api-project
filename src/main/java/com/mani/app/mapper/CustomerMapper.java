package com.mani.app.mapper;

import com.mani.app.dto.CustomerResponse;
import com.mani.app.entity.Customer;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface CustomerMapper {

    @Mapping(source = "id", target = "customerId")
    @Mapping(source = "firstName", target = "customerFirstName")
    @Mapping(source = "lastName", target = "customerLastName")
    @Mapping(source = "gender", target = "customerGender")
    @Mapping(source = "mobileNumber", target = "customerMobileNumber")
    @Mapping(source = "email", target = "customerEmail")
    @Mapping(source = "age", target = "customerAge")
    @Mapping(source = "nationality", target = "customerNationality")
    CustomerResponse EntityToDto(Customer customer);

    @InheritInverseConfiguration
    Customer DtoToEntity(CustomerResponse customerResponse);
}
