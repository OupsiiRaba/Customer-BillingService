package org.openlab.openlabcustomerservice.services;

import org.openlab.openlabcustomerservice.dto.CustomerRequestDTO;
import org.openlab.openlabcustomerservice.dto.CustomerResponseDTO;
import org.openlab.openlabcustomerservice.entities.Customer;
import org.openlab.openlabcustomerservice.mappers.CustomerMapper;
import org.openlab.openlabcustomerservice.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@Transactional

public class CustomerServiceImpl implements CustomerService {

    private CustomerRepository customerRepository;
    private CustomerMapper customerMapper;

    public CustomerServiceImpl(CustomerRepository customerRepository, CustomerMapper customerMapper) {
        this.customerRepository = customerRepository;
        this.customerMapper = customerMapper;
    }

    @Override
    public CustomerResponseDTO save(CustomerRequestDTO customerRequestDTO) {
        //Mapping Objet objet
        //objet metier mapper avec la partie UI
        /*
        Customer customer= new Customer();
        customer.setId(customerRequestDTO.getId());
        customer.setId(UUID.randomUUIS().toString());
        customer.setName(customerRequestDTO.getName());
        customer.setEmail(customer.getEmail());
        //customer.setId(UUID.randomUUID().toString());
        */
        //le transfert de données
        Customer customer=customerMapper.customerRequestDTO(customerRequestDTO);

        Customer saveCustomer= customerRepository.save(customer);

        //CustomerResponseDTO customerResponseDTO= new CustomerResponseDTO();
        //customerResponseDTO.setId(saveCustomer.getId());
        //customerResponseDTO.setName(saveCustomer.getName());
        //customerResponseDTO.setEmail(saveCustomer.getEmail());
        CustomerResponseDTO customerResponseDTO=customerMapper.customerToCustomerResponseDTO(saveCustomer);
        return customerResponseDTO;
    }

    @Override
    public CustomerResponseDTO getCustomer(String id) {
       Customer customer=customerRepository.findById(id).get();

        return customerMapper.customerToCustomerResponseDTO(customer);
    }

    @Override
    public CustomerResponseDTO update(CustomerRequestDTO customerRequestDTO) {
        Customer customer=customerMapper.customerRequestDTO(customerRequestDTO);
        Customer updateCustomer = customerRepository.save(customer);

        return customerMapper.customerToCustomerResponseDTO(updateCustomer);
    }

    @Override
    public List<CustomerResponseDTO> listCustomer() {
        List<Customer> customers=customerRepository.findAll();
        List<CustomerResponseDTO> customerResponseDTOS= customers.stream().
                map(customer -> customerMapper.customerToCustomerResponseDTO(customer))
                .collect(Collectors.toList());
        return customerResponseDTOS;
    }
}
