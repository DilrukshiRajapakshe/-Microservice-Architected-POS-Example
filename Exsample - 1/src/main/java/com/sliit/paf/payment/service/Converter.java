package com.sliit.paf.payment.service;


import com.sliit.paf.payment.dto.CustomerDTO;
import com.sliit.paf.payment.dto.SuperDTO;
import com.sliit.paf.payment.entity.Customer;
import com.sliit.paf.payment.entity.SuperEntity;

import java.util.List;
import java.util.stream.Collectors;

public class Converter {

    public static <T extends SuperDTO> T getDTO(SuperEntity entity) {
        if (entity instanceof Customer) {
            Customer c = (Customer) entity;
            return (T) new CustomerDTO(c.getId(), c.getName(), c.getAddress());
        }else {
            throw new RuntimeException("This entity can't be converted to a DTO");
        }
    }

    public static <T extends SuperEntity> T getEntity(SuperDTO dto) {
        if (dto instanceof CustomerDTO) {
            CustomerDTO c = (CustomerDTO) dto;
            return (T) new Customer(c.getId(), c.getName(), c.getAddress());
        }else {
            throw new RuntimeException("This DTO can't be converted to an entity");
        }
    }

    public static <T extends SuperDTO> List<T> getDTOList(List<? extends SuperEntity> entities) {
        return entities.stream().map(Converter::<T>getDTO).collect(Collectors.toList());
    }

    public static <T extends SuperEntity> List<T> getEntityList(List<? extends SuperDTO> dtos) {
        return dtos.stream().map(Converter::<T>getEntity).collect(Collectors.toList());

    }

//    public static <T extends SuperDTO> List<T> getDTOList(List<CustomEntity> list, Class<T> dtoClass) {
//        return list.stream().map(c -> getDTO(c, dtoClass)).collect(Collectors.toList());
//    }

}
