package com.ngh.domain.embed;

import com.ngh.domain.Home;

import javax.persistence.*;
import java.util.Objects;

@Embeddable
public class Address {

    @Column(name = "COUNTRY") // DB 컬럼명 정의 가능
    private String country;
    private String city;

    @ManyToOne
    private Home home;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "date", column = @Column(name = "address_date")),
            @AttributeOverride(name = "timestamp", column = @Column(name = "address_timestamp")),
            @AttributeOverride(name = "time", column = @Column(name = "address_time"))
    })
    private Period period;

    public Address(String country, String city, Home home, Period period) {
        this.country = country;
        this.city = city;
        this.home = home;
        this.period = period;
    }

    public Address() {
    }

    public String getCountry() {
        return country;
    }

    public String getCity() {
        return city;
    }

    /* 값 타입은 불변 객체로 만들어야함
    public void setCountry(String country) {
             this.country = country;
    }

    public void setCity(String city) {
        this.city = city;
    }

     public void setHome(Home home) {
        this.home = home;
    }

    public void setPeriod(Period period) {
        this.period = period;
    }
     */

    public Home getHome() {
        return home;
    }


    public Period getPeriod() {
        return period;
    }

    // 값 타입은 equals, hashCode 를 정의해야한다.
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Address address = (Address) o;
        return Objects.equals(country, address.country) && Objects.equals(city, address.city) && Objects.equals(home, address.home) && Objects.equals(period, address.period);
    }

    @Override
    public int hashCode() {
        return Objects.hash(country, city, home, period);
    }
}
