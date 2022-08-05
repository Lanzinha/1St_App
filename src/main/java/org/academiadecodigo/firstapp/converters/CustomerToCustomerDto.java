package org.academiadecodigo.firstapp.converters;

import org.academiadecodigo.firstapp.command.CustomerDto;
import org.academiadecodigo.firstapp.persistence.model.Customer;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

/**
 * A {@link Converter} implementation, responsible for {@link Customer} to {@link CustomerDto} type conversion
 */
@Component
public class CustomerToCustomerDto extends AbstractConverter<Customer, CustomerDto> {

    /**
     * Converts the customer model object into a customer DTO
     *
     * @param customer the customer
     * @return the customer DTO
     */
    @Override
    public CustomerDto convert(Customer customer) {

        CustomerDto customerDto = new CustomerDto();
        customerDto.setId(customer.getId());
        customerDto.setName(customer.getName());
        customerDto.setPass(customer.getPass());
        //customerDto.setEmail(customer.getEmail());
        //customerDto.setPhone(customer.getPhone());

        return customerDto;
    }
}
