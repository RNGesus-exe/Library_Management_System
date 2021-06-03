public class User {
    private String firstName;
    private String lastName;
    private String email;
    private String address;
    private String mobileNumber;
    private String cnic;
    private String password;

//@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@( Parameterized Constructor )@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@

    public User() {
        this.firstName = "";
        this.lastName = "";
        this.email = "";
        this.address = "";
        this.mobileNumber = "";
        this.cnic = "";
        this.password = "";
    }


//@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@( Parameterized Constructor )@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@

    public User(String firstName, String lastName, String email, String address, String mobileNumber, String cnic, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.address = address;
        this.mobileNumber = mobileNumber;
        this.cnic = cnic;
        this.password = password;
    }

//@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@( Setters )@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public void setCnic(String cnic) {
        this.cnic = cnic;
    }

    public void setPassword(String password) {
        this.password = password;
    }

//@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@( Getters )@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public String getAddress() {
        return address;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public String getCnic() {
        return cnic;
    }

    public String getPassword() {
        return password;
    }

//@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@( Data String )@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@

    public String toString(){
        return "[ First Name : "+this.firstName+", Last Name : "+this.lastName+", Mobile No. : "+this.mobileNumber+
                ", CNIC : "+this.cnic+", Email : "+this.email+", Password : "+this.password+" ]";
    }

}
