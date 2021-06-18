import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.RoundRectangle2D;

public class SignUpUI extends JFrame implements ActionListener {

    private final int FRAME_WIDTH = 1200;
    private final int FRAME_HEIGHT = 900;
    private final ImageIcon bgIcon = new ImageIcon("img/bg8.jpg");
    private final Font textFieldFont = new Font("Arial", Font.PLAIN, 16);
    private final Font labelFont = new Font("Arial", Font.BOLD, 16);

    private JLabel lb_background;
    private JPanel panel_titleBar;
    private JPanel panel_personalInfo;
    private JLabel lb_mainTitle1;
    private JLabel lb_mainTitle2;
    private JLabel lb_topbarTitle;
    private JLabel lb_firstName;
    private JLabel lb_lastName;
    private JLabel lb_email;
    private JLabel lb_address;
    private JLabel lb_mobileNumber;
    private JLabel lb_cnic;
    private JLabel lb_password;
    private JLabel lb_confirmPassword;
    private JLabel lb_alreadyAccount;

    private JTextField txt_firstName;
    private JTextField txt_lastName;
    private JTextField txt_email;
    private JTextArea textArea_address;
    private JTextField txt_mobileNumber;
    private JTextField txt_cnic;
    private JPasswordField txt_password;
    private JPasswordField txt_confirmPassword;
    private JTextField txt_securityQuestionAnswer;

    private JButton btn_signUp;
    private JButton btn_close;
    private JButton btn_minimize;

    JComboBox cmbx_securityQuestion;
    
    public static String[] securityQuestions = {
            "--Select One--",
            "What is your hobby?",
            "What is your favourite color?",
            "Who is your best friend?",
            "What is your lucky number?"
    };
    
    
    
    public SignUpUI() {
        init();
    }

    public void init(){

//@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@{ Main Frame }@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setSize(FRAME_WIDTH,FRAME_HEIGHT);
        setLocationRelativeTo(null);
        getContentPane().setBackground(new Color(237, 226, 225));
        setUndecorated(true);
        setShape(new RoundRectangle2D.Double(0, 0, FRAME_WIDTH, FRAME_HEIGHT, 40, 40));
        setLayout(null);
        FrameDragListener frameDragListener = new FrameDragListener(this);
        super.addMouseListener(frameDragListener);
        super.addMouseMotionListener(frameDragListener);

//@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@{ Top Title Bar }@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@

        panel_titleBar = new JPanel();
        panel_titleBar.setLayout(null);
        panel_titleBar.setBounds(0,0,FRAME_WIDTH,70);
//        panel_titleBar.setBackground(Color.red);
        panel_titleBar.setBackground(Color.decode("#1877EB"));
        panel_titleBar.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        add(panel_titleBar);

//@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@{ Topbar Title }@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@

        lb_topbarTitle = new JLabel("Create Account");
        lb_topbarTitle.setBounds(480,20,300,30);
        lb_topbarTitle.setForeground(Color.WHITE);
        lb_topbarTitle.setFont(new Font("Arial", Font.BOLD, 34));
        panel_titleBar.add(lb_topbarTitle);

//@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@{ Topbar Cross Button }@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@

        btn_close = new JButton("X");
        btn_close.setBounds(1150, 25, 20, 20);
        btn_close.setBackground(null);
        btn_close.setForeground(Color.red);
        btn_close.setBorder(BorderFactory.createEmptyBorder(0,0,0,0));
        btn_close.setToolTipText("Close");
        btn_close.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        btn_close.setFocusPainted(false);
        btn_close.setFont(new Font("Arial", Font.BOLD, 20));
        btn_close.addActionListener(this);
        panel_titleBar.add(btn_close);

//@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@{ Topbar Minimize Button }@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@

        btn_minimize = new JButton("-");
        btn_minimize.setBounds(1120, 25, 20, 20);
        btn_minimize.setBackground(null);
        btn_minimize.setForeground(Color.red);
        btn_minimize.setBorder(BorderFactory.createEmptyBorder(0,0,0,0));
        btn_minimize.setToolTipText("Minimize");
        btn_minimize.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        btn_minimize.setFocusPainted(false);
        btn_minimize.setFont(new Font("Arial", Font.BOLD, 20));
        btn_minimize.addActionListener(this);
        panel_titleBar.add(btn_minimize);

//@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@{ Background Image }@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@

        lb_background = new JLabel();
        lb_background.setBounds(0,50,FRAME_WIDTH,FRAME_HEIGHT-50);
        Image bgImg = bgIcon.getImage().getScaledInstance(FRAME_WIDTH,FRAME_HEIGHT-50,Image.SCALE_SMOOTH);
        lb_background.setLayout(null);
        lb_background.setIcon(new ImageIcon(bgImg));
        add(lb_background);

//@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@{  Main Title  }@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@

        lb_mainTitle1 = new JLabel("Welcome to");
        lb_mainTitle1.setFont(new Font("Arial Black", Font.BOLD, 60));
        lb_mainTitle1.setBounds(100,120,500,50);
        lb_mainTitle1.setForeground(Color.red);
        lb_background.add(lb_mainTitle1);

        lb_mainTitle2 = new JLabel("Library");
        lb_mainTitle2.setFont(new Font("Arial Black", Font.BOLD, 60));
        lb_mainTitle2.setBounds(100,160,500,80);
        lb_mainTitle2.setForeground(Color.red);
        lb_background.add(lb_mainTitle2);


//@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@{ Personal Info Panel }@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@

        panel_personalInfo = new JPanel();
        panel_personalInfo.setLayout(null);
        panel_personalInfo.setBackground(Color.white);
        panel_personalInfo.setBounds(650, 35, 500, 800);
        lb_background.add(panel_personalInfo);


//@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@{ First Name Label }@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@

        lb_firstName = new JLabel("First Name");
        lb_firstName.setBounds(60, 30, 180, 30);
        lb_firstName.setFont(labelFont);
        panel_personalInfo.add(lb_firstName);

//@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@{ First Name TextField }@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@

        txt_firstName = new JTextField();
        txt_firstName.setBounds(60,60 , 180, 30);
        txt_firstName.setFont(textFieldFont);
        panel_personalInfo.add(txt_firstName);

//@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@{ Last Name Label }@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@

        lb_lastName = new JLabel("Last Name");
        lb_lastName.setBounds(260, 30, 180, 30);
        lb_lastName.setFont(labelFont);
        panel_personalInfo.add(lb_lastName);


//@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@{ Last Name TextField }@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@

        txt_lastName = new JTextField();
        txt_lastName.setBounds(260, 60, 180, 30);
        txt_lastName.setFont(textFieldFont);
        panel_personalInfo.add(txt_lastName);

//@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@{ Mobile Number Label }@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@

        lb_mobileNumber = new JLabel("Mobile Number");
        lb_mobileNumber.setBounds(60, 100, 380, 30);
        lb_mobileNumber.setFont(labelFont);
        panel_personalInfo.add(lb_mobileNumber);

//@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@{ Mobile Number TextField }@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@

        txt_mobileNumber = new JTextField();
        txt_mobileNumber.setBounds(60, 130, 380, 30);
        txt_mobileNumber.setFont(textFieldFont);
        panel_personalInfo.add(txt_mobileNumber);

//@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@{ Address Label }@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@

        lb_address = new JLabel("Address");
        lb_address.setBounds(60, 170, 200, 30);
        lb_address.setFont(labelFont);
        panel_personalInfo.add(lb_address);

//@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@{ Address TextField }@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@

        textArea_address = new JTextArea();
        textArea_address.setBounds(60, 200, 380, 50);
        textArea_address.setBorder(BorderFactory.createLineBorder(Color.black));
        textArea_address.setLineWrap(true);
        textArea_address.setFont(textFieldFont);
        panel_personalInfo.add(textArea_address);

//@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@{ CNIC Label }@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@

        lb_cnic = new JLabel("CNIC (National Identity)");
        lb_cnic.setBounds(60, 260, 380, 30);
        lb_cnic.setFont(labelFont);
        panel_personalInfo.add(lb_cnic);

//@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@{ CNIC TextField }@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@

        txt_cnic = new JTextField();
        txt_cnic.setBounds(60, 290, 380, 30);
        txt_cnic.setFont(textFieldFont);
        panel_personalInfo.add(txt_cnic);

//@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@{ Email Label }@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@

        lb_email = new JLabel("Email Address");
        lb_email.setBounds(60, 330, 380, 30);
        lb_email.setFont(labelFont);
        panel_personalInfo.add(lb_email);

//@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@{ Email TextField }@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@

        txt_email = new JTextField();
        txt_email.setBounds(60, 360, 380, 30);
        txt_email.setFont(textFieldFont);
        panel_personalInfo.add(txt_email);

//@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@{ Password Label }@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@

        lb_password = new JLabel("Password");
        lb_password.setBounds(60, 400, 380, 30);
        lb_password.setFont(labelFont);
        panel_personalInfo.add(lb_password);

//@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@{ Password TextField }@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@

        txt_password = new JPasswordField();
        txt_password.setBounds(60, 430, 380, 30);
        txt_password.setFont(textFieldFont);
        panel_personalInfo.add(txt_password);

//@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@{ Confirm Password Label }@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@

        lb_confirmPassword = new JLabel("Confirm Password");
        lb_confirmPassword.setBounds(60, 470, 380, 30);
        lb_confirmPassword.setFont(labelFont);
        panel_personalInfo.add(lb_confirmPassword);

//@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@{ Confirm Password TextField }@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@

        txt_confirmPassword = new JPasswordField();
        txt_confirmPassword.setBounds(60, 500, 380, 30);
        txt_confirmPassword.setFont(textFieldFont);
        panel_personalInfo.add(txt_confirmPassword);

        JLabel lb_securityQestion = new JLabel("Security Question");
        lb_securityQestion.setBounds(60,551,150,30);
        lb_securityQestion.setFont(labelFont);
        panel_personalInfo.add(lb_securityQestion);

        cmbx_securityQuestion = new JComboBox(securityQuestions);
        cmbx_securityQuestion.setBounds(220,550,220,30);
        panel_personalInfo.add(cmbx_securityQuestion);

//@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@{ Sign Up Button }@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@

        btn_signUp = new JButton("Sign Up");
        btn_signUp.setBounds(60, 700, 380, 35);
        btn_signUp.setFocusPainted(false);
        btn_signUp.setBackground(Color.decode("#1877EB"));
        btn_signUp.setForeground(Color.white);
        btn_signUp.setFont(new Font("Arial", Font.BOLD, 16));
        btn_signUp.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        panel_personalInfo.add(btn_signUp);
        btn_signUp.addMouseListener(new MouseAdapter() {   // Button get highlighted when Cursor hover over Login Button
            public void mouseEntered(MouseEvent e) {
                btn_signUp.setBackground(Color.decode("#1262c4"));
            }

            public void mouseExited(MouseEvent e) {
                btn_signUp.setBackground(Color.decode("#1877EB"));
            }
        });
        btn_signUp.addActionListener(this);

//@@@@@@@@@@@@@@@@@@@@@@@@@@@@@{ Security Question Field }@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@

        JLabel lb_securityAnswer = new JLabel("Security Question Answer");
        lb_securityAnswer.setBounds(60, 600, 380, 30);
        lb_securityAnswer.setFont(labelFont);
        panel_personalInfo.add(lb_securityAnswer);

        txt_securityQuestionAnswer = new JTextField();
        txt_securityQuestionAnswer.setBounds(60, 630, 380, 30);
        txt_securityQuestionAnswer.setFont(textFieldFont);
        panel_personalInfo.add(txt_securityQuestionAnswer);

//@@@@@@@@@@@@@@@@@@@@@@@@@@@@@{ Sign In link }@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@

        lb_alreadyAccount = new JLabel("Already have an account?");
        lb_alreadyAccount.setBounds(60,740,200,15);
        lb_alreadyAccount.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        lb_alreadyAccount.setFont(new Font("Arial", Font.BOLD, 16));
        lb_alreadyAccount.setForeground(Color.decode("#bf1b1b"));
        panel_personalInfo.add(lb_alreadyAccount);
        lb_alreadyAccount.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseClicked(MouseEvent e){
                dispose();
                new LoginUI();
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                lb_alreadyAccount.setForeground(Color.decode("#f01616"));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                lb_alreadyAccount.setForeground(Color.decode("#bf1b1b"));
            }
        });



        setVisible(true);
    }

    public void clearAllFields(){

        txt_firstName.setText("");
        txt_lastName.setText("");
        txt_mobileNumber.setText("");
        textArea_address.setText("");
        txt_cnic.setText("");
        txt_email.setText("");
        txt_password.setText("");
        txt_confirmPassword.setText("");
    }

    public boolean isUsernameValid(String firstName, String lastName){
        if(firstName.matches("(.*)[0-9](.*)") || lastName.matches("(.*)[0-9](.*)")){
            System.out.println("Yes");
            return false;
        }
        else if(firstName.matches("(?=.*[~!@#$%^&*()_-]).*") || lastName.matches("(?=.*[~!@#$%^&*()_-]).*")){
            return false;
        }
        else if(firstName.length()>30 || lastName.length()>30){
            return false;
        }
        else{
            return true;
        }
    }

    public boolean isMobileNumberValid(String mobileNumber){
        if(mobileNumber.matches("(.*)[A-Z](.*)")
            || mobileNumber.matches("(.*)[a-z](.*)")
            || mobileNumber.matches("(?=.*[~!@#$%^&*()_-]).*")
            || mobileNumber.length()!=11){
            return false;
        }
        else{
            return true;
        }
    }

    public boolean isCnicValid(String cnic){

        if(cnic.matches("(.*)[A-Z](.*)")
            || cnic.matches("(?=.*[~!@#$%^&*()_-]).*")
            || cnic.matches("(.*)[a-z](.*)")
            || cnic.length()!=13) {
            return false;
        }
        else {
            return true;
        }

    }

    public boolean isPasswordStrong(String str){
        if(str.length()<8 || str.length()>30){
            return false;
        }
        else if(str.matches("(.*)[A-Z](.*)")) // Uppercase Checking
        {
            if(str.matches("(.*)[a-z](.*)"))  // Lowercase Checking
            {
                if(str.matches("(.*)[0-9](.*)")) // Numeric Character Checking
                {
                    if(str.matches("(?=.*[~!@#$%^&*()_-]).*")) // Special Character Checking
                    {
                        return true;
                    }
                    else return false;
                }
                else return false;
            }
            else return false;
        }
        else return false;

    }

    public User createUser(){
        // Creation of User Object
        User user = new User();

        // Adding Data in User object from Sign Up Form
        user.setFirstName(txt_firstName.getText().trim());
        user.setLastName(txt_lastName.getText().trim());
        user.setMobileNumber(txt_mobileNumber.getText().trim());
        user.setAddress(textArea_address.getText());
        user.setCnic(txt_cnic.getText().trim());
        user.setEmail(txt_email.getText().trim());
        user.setPassword(txt_password.getText().trim());
        user.setSecurityQuestion(cmbx_securityQuestion.getSelectedIndex());
        user.setSecurityQestionAnswer(txt_securityQuestionAnswer.getText().trim());

        return user;
    }

    public boolean isSignUpValid(){

        if(txt_firstName.getText().trim().isEmpty() ||
                txt_lastName.getText().trim().isEmpty() ||
                txt_mobileNumber.getText().trim().isEmpty() ||
                textArea_address.getText().trim().isEmpty() ||
                txt_cnic.getText().trim().isEmpty() ||
                txt_email.getText().trim().isEmpty() ||
                txt_password.getText().trim().isEmpty() ||
                txt_confirmPassword.getText().trim().isEmpty() ||
                txt_securityQuestionAnswer.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(null,"Please Fill all the Fields","Incomplete Information",JOptionPane.ERROR_MESSAGE);
        }
        else if(!isUsernameValid(txt_firstName.getText().trim(), txt_lastName.getText().trim())){
            JOptionPane.showMessageDialog(null,"Invalid First Name or Last Name. Don't use Spcial Characters or Numbers in Name","Invalid Username",JOptionPane.ERROR_MESSAGE);
        }
        else if(!isMobileNumberValid(txt_mobileNumber.getText().trim())){
            JOptionPane.showMessageDialog(null,"Invalid Mobile Number! Length should be 11 Digits and No Special Characters e.g. \"-\"","Invalid Mobile Number",JOptionPane.ERROR_MESSAGE);
        }
        else if(!isCnicValid(txt_cnic.getText().trim())){
            JOptionPane.showMessageDialog(null,"Your CNIC is not valid. Don't use alphabets or special characters. Enter Valid CNIC\nExample: XXXXXXXXXXXXX","Invalid CNIC",JOptionPane.ERROR_MESSAGE);
        } // Email Validation
        else if(!EmailValidator.isEmailValid(txt_email.getText().trim())){
            JOptionPane.showMessageDialog(null,"Invalid Email Address! Please enter valid Email Address","Invalid Email Address",JOptionPane.ERROR_MESSAGE);
        }
        else if(!txt_password.getText().trim().equals(txt_confirmPassword.getText().trim())) {
            JOptionPane.showMessageDialog(null,"Password and Confirm Password not matched","Password Error",JOptionPane.ERROR_MESSAGE);
        }// Password Strength
        else if(!isPasswordStrong(txt_password.getText().trim())) {
            JOptionPane.showMessageDialog(null, "Error! Your password must contain Uppercase Lowercase and Special Characters\nFor Example, ABCde12@", "Weak Password!", JOptionPane.ERROR_MESSAGE);
        }
        else if(Driver.dataAgent.checkCnicRepetition(txt_cnic.getText().trim())) {
            JOptionPane.showMessageDialog(null,"CNIC already exits","CNIC Duplication",JOptionPane.ERROR_MESSAGE);
        }
        else if(cmbx_securityQuestion.getSelectedIndex()==0){
            JOptionPane.showMessageDialog(null, "Please select your security question for password recovery.", "Incomplete Information", JOptionPane.ERROR_MESSAGE);
        }
        else if(txt_securityQuestionAnswer.getText().length()>30){
            JOptionPane.showMessageDialog(null, "Invalid Answer of Security Question! Your answer must be <30 characters", "Incomplete Information", JOptionPane.ERROR_MESSAGE);
        }
        else
        {
                return true;
        }

        return false;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==btn_close){
            dispose();
        }else if(e.getSource()==btn_minimize){
            super.setState(JFrame.ICONIFIED);
        }else if(e.getSource()==btn_signUp){
            if(isSignUpValid()){
                Driver.dataAgent.addUser(createUser(),txt_securityQuestionAnswer.getText().trim(),cmbx_securityQuestion.getSelectedIndex());
                JOptionPane.showMessageDialog(null,"Sign Up completed successfully","Sign Up Successful",JOptionPane.INFORMATION_MESSAGE);
                dispose();
                new LoginUI();
            }
        }

    }
}
