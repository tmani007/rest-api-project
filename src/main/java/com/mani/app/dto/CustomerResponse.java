package com.mani.app.dto;


import lombok.*;

import javax.validation.constraints.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CustomerResponse {

    private Long customerId;
    @NotBlank(message = "customerFirstName shouldn't be blank")
    private String customerFirstName;
    @NotBlank(message = "customerLastName shouldn't be blank")
    private String customerLastName;
    @NotBlank(message = "customerGender shouldn't be blank")
    private String customerGender;
    @Pattern(regexp = "^[6-9]\\d{9}$", message = "Invalid Mobile number")
    private String customerMobileNumber;
    @Email(message = "Invalid Email address")
    private String customerEmail;
    @Min(value = 1,message = "Invalid Age entered")
    @Max(value = 100,message = "Invalid Age entered")
    private Integer customerAge;
    @NotBlank(message = "customerNationality shouldn't be blank")
    private String customerNationality;
}
