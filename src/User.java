public class User {
    private int user_id;
    private String firstName;
    private String lastName;
    private String email;
    private String address;
    private String mobileNumber;
    private String cnic;
    private String password;
    private int securityQuestion;
    private String securityQestionAnswer;

//@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@( Parameterized Constructor )@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@

    public User() {
        this.user_id = -1;
        this.firstName = "";
        this.lastName = "";
        this.email = "";
        this.address = "";
        this.mobileNumber = "";
        this.cnic = "";
        this.password = "";
        this.securityQuestion = -1;
        this.securityQestionAnswer = "";
    }


//@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@( Parameterized Constructor )@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@

    public User(int user_id,String firstName, String lastName, String email, String address, String mobileNumber, String cnic, String password, int securityQuestion, String securityQestionAnswer) {
        this.user_id = user_id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.address = address;
        this.mobileNumber = mobileNumber;
        this.cnic = cnic;
        this.password = password;
        this.securityQuestion = securityQuestion;
        this.securityQestionAnswer = securityQestionAnswer;
    }

//@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@( Setters )@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@


    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public int getSecurityQuestion() {
        return securityQuestion;
    }

    public void setSecurityQuestion(int securityQuestion) {
        this.securityQuestion = securityQuestion;
    }

    public String getSecurityQestionAnswer() {
        return securityQestionAnswer;
    }

    public void setSecurityQestionAnswer(String securityQestionAnswer) {
        this.securityQestionAnswer = securityQestionAnswer;
    }

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


    public int getUser_id() {
        return user_id;
    }

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

    public Object[] getUserObject() {
        Object[] userInfo = {user_id, firstName + " " + lastName, mobileNumber, cnic, email};

        return userInfo;
    }

//@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@( Data String )@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@

    public String toString(){
        return "[ UserID : "+this.user_id +"First Name : "+this.firstName+", Last Name : " +this.lastName +
                ", Mobile No. : "+this.mobileNumber+
                ", CNIC : "+this.cnic+", Email : "+this.email+", Password : "+this.password+" ]";
    }

}
