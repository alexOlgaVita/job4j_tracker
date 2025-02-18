package ru.job4j.mapstuct;

import org.mapstruct.factory.Mappers;
import ru.job4j.mapstuct.dto.DeliveryAddressDto;
import ru.job4j.mapstuct.dto.StudentDto;
import ru.job4j.mapstuct.mappers.DeliveryAddressMapper;
import ru.job4j.mapstuct.model.AddressEntity;
import ru.job4j.mapstuct.model.StudentEntity;

public class Main {
    public static void main(String[] args) {
        DeliveryAddressMapper deliveryAddressMapper = Mappers.getMapper(DeliveryAddressMapper.class);
        StudentEntity sEntity = new StudentEntity(0, "entity", "junior");
        StudentDto sDto = new StudentDto(11, "dto", "middle");
        AddressEntity address = new AddressEntity(100, "cityGood", "stateNew");
        DeliveryAddressDto deliveryAddressDto = deliveryAddressMapper.getDeliveryAddress(sEntity, address);
        System.out.println("deliveryAddressDto = " + deliveryAddressDto);
    }
}
