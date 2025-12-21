package com.api.models.request;

public class UpdateProfileRequest {

    private String firstName;
    private String lastName;
    private String mobileNumber;

    public String getFirstName() {
        return firstName;
    }

    @Override
    public String toString() {
        return "UpdateProfileRequest{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", mobileNumber='" + mobileNumber + '\'' +
                ", email='" + email + '\'' +
                '}';
    }

    public UpdateProfileRequest(String firstName, String lastName, String mobileNumber, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.mobileNumber = mobileNumber;
        this.email = email;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    private String email;

    public static class Builder{

        private String firstName;
        private String lastName;
        private String mobileNumber;
        private String email;

        public Builder firstName(String firstName){
            this.firstName = firstName;
            return this;
        }
        public Builder lasyName(String lastName){
            this.lastName = lastName;
            return this;
        }
        public Builder email(String email){
            this.email = email;
            return this;
        }
        public Builder mobileNumber(String mobileNumber){
            this.mobileNumber = mobileNumber;
            return this;
        }

        public UpdateProfileRequest build(){

            UpdateProfileRequest updateProfileRequest = new UpdateProfileRequest(firstName, lastName, mobileNumber, email);
             return updateProfileRequest;
        }
    }
}
