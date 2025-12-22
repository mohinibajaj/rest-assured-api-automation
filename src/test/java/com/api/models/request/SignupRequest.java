package com.api.models.request;

public class SignupRequest {
    private String username;
    private String password;
    private String email;
    private String firstName;
    private String lastName;
    private String mobileNumber;

    public SignupRequest(String username, String password, String email, String firstName, String lastName, String mobileNumber) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.mobileNumber = mobileNumber;
    }

    @Override
    public String toString() {
        return "SignupRequest{" +
                "username='" + this.username + '\'' +
                ", password='" + this.password + '\'' +
                ", email='" + this.email + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", mobileNumber='" + mobileNumber + '\'' +
                '}';
    }

    public String getUsername() { return username; }
    public String getPassword() { return password; }
    public String getEmail() { return email; }
    public String getFirstName() { return firstName; }
    public String getLastName() { return lastName; }
    public String getMobileNumber() { return mobileNumber; }


    public static class Builder{
        private String username;
        private String password;
        private String  email;
        private String  firstName;
        private String  lastName;
        private String  mobileNumber;


//        public Builder username(String username){
//            this.username = username;
//            Builder x = new Builder();
            // Builder x = this;
//
//            return x;
//        }
        // new  keyword is to create an object, but we want to refer the current object
        // Current object can be referred by this keyword hence line 96 is correct

        public Builder username(String username){
            this.username = username;
            return this;  //return current object
        }
        public Builder password(String password){
            this.password = password;
            return this;
        }
        public Builder email(String email){
            this.email = email;
            return this;
        }
        public Builder firstName(String firstName){
            this.firstName = firstName;
            return this;
        }
        public Builder lastName(String lastName){
            this.lastName = lastName;
            return this;
        }
        public Builder mobileNumber(String mobileNumber){
            this.mobileNumber = mobileNumber;
            return this;
        }

        public SignupRequest build(){
            SignupRequest signupRequest = new SignupRequest(username, password, email, firstName, lastName, mobileNumber);
        return signupRequest;

        }
    }

}
