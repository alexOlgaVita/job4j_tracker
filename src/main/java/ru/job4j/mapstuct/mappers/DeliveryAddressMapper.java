package ru.job4j.mapstuct.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import ru.job4j.mapstuct.dto.DeliveryAddressDto;
import ru.job4j.mapstuct.model.AddressEntity;
import ru.job4j.mapstuct.model.StudentEntity;

@Mapper
public interface DeliveryAddressMapper {
    @Mapping(source = "student.name", target = "name")
    @Mapping(source = "address.houseNo", target = "houseNumber")
    DeliveryAddressDto getDeliveryAddress(StudentEntity student, AddressEntity address);
}
