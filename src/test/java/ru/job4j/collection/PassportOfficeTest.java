package ru.job4j.collection;


import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class PassportOfficeTest {
    @Test
    public void whenTestAddMethod() {
        Citizen citizen = new Citizen("2f44a", "Petr Arsentev");
        PassportOffice office = new PassportOffice();
        office.add(citizen);
        assertThat(office.get(citizen.getPassport())).isEqualTo(citizen);
    }

    @Test
    public void whenTestNotAddMethod() {
        Citizen citizen = new Citizen("2f44a", "Petr Arsentev");
        PassportOffice office = new PassportOffice();
        office.add(citizen);
        citizen = new Citizen("12wow", "Nikolay Ilyin");
        assertThat(office.add(citizen)).isTrue();
        citizen = new Citizen("12wow", "Sveta Ilyina");
        assertThat(office.add(citizen)).isFalse();
    }
}