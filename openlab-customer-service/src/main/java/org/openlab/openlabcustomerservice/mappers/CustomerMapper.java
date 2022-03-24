package org.openlab.openlabcustomerservice.mappers;

import org.mapstruct.Mapper;
import org.openlab.openlabcustomerservice.dto.CustomerRequestDTO;
import org.openlab.openlabcustomerservice.dto.CustomerResponseDTO;
import org.openlab.openlabcustomerservice.entities.Customer;

@Mapper(componentModel ="spring")
public interface CustomerMapper {

    //objectif : le trasfert de données
    CustomerResponseDTO customerToCustomerResponseDTO(Customer customer);
    Customer customerRequestDTO(CustomerRequestDTO customerRequestDTO);

}

