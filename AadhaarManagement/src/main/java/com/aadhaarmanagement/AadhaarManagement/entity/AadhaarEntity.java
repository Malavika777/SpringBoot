package com.aadhaarmanagement.AadhaarManagement.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "aadhaar")
public class AadhaarEntity {

    @Id
    @Column(name = "aadhaar_no", length = 12, nullable = false, unique = true)
    private String aadhaarNo;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "gender", nullable = false)
    private String gender;

    @Column(name = "dob", nullable = false)
    private String dob;

    @Column(name = "mobile", length = 15)
    private String mobile;

    @Column(name = "email")
    private String email;

    @Embedded
    private Address address;

    public String getAadhaarNo() {
        return aadhaarNo;
    }

    public void setAadhaarNo(String aadhaarNo) {
        this.aadhaarNo = aadhaarNo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    @Embeddable
    public static class Address {
        @Column(name = "house_no")
        private String houseNo;

        @Column(name = "address_line1")
        private String addressLine1;

        @Column(name = "address_line2")
        private String addressLine2;

        @Column(name = "city")
        private String city;

        @Column(name = "state")
        private String state;

        @Column(name = "pincode")
        private String pinCode;

        public String getHouseNo() {
            return houseNo;
        }

        public void setHouseNo(String houseNo) {
            this.houseNo = houseNo;
        }

        public String getAddressLine1() {
            return addressLine1;
        }

        public void setAddressLine1(String addressLine1) {
            this.addressLine1 = addressLine1;
        }

        public String getAddressLine2() {
            return addressLine2;
        }

        public void setAddressLine2(String addressLine2) {
            this.addressLine2 = addressLine2;
        }

        public String getCity() {
            return city;
        }

        public void setCity(String city) {
            this.city = city;
        }

        public String getState() {
            return state;
        }

        public void setState(String state) {
            this.state = state;
        }

        public String getPinCode() {
            return pinCode;
        }

        public void setPinCode(String pinCode) {
            this.pinCode = pinCode;
        }
    }
}
