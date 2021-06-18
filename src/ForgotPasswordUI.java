import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.RoundRectangle2D;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ForgotPasswordUI extends JFrame {

    private final int FRAME_WIDTH = 1200;
    private final int FRAME_HEIGHT = 700;

    private JPanel panel_titleBar;
    private JLabel lb_topbarTitle;
    private JTextField txt_username;
    private JPasswordField txt_password;
    private JPasswordField txt_confirmPassword;

    private JButton btn_close;
    private JButton btn_minimize;
    private JButton btn_savePassword;
    private JButton btn_generatePassword;

    private Color topbarColor = Color.decode("#1877EB");
    private Color frameColor = Color.decode("#ede2e1");
    private Color buttonHoverColor = Color.decode("#0e65cf");

    private Image img;


    public ForgotPasswordUI() {
        init();
    }

    public void init() {

//@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@{ Main Frame }@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setSize(FRAME_WIDTH, FRAME_HEIGHT);
        setLocationRelativeTo(null);
        getContentPane().setBackground(frameColor);
        setUndecorated(true);
        setShape(new RoundRectangle2D.Double(0, 0, FRAME_WIDTH, FRAME_HEIGHT, 40, 40));
        setLayout(null);
        FrameDragListener frameDragListener = new FrameDragListener(this);
        super.addMouseListener(frameDragListener);
        super.addMouseMotionListener(frameDragListener);


//@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@{ Top Title Bar }@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@

        panel_titleBar = new JPanel();
        panel_titleBar.setLayout(null);
        panel_titleBar.setBounds(0, 0, FRAME_WIDTH, 70);
        panel_titleBar.setBackground(Color.decode("#1877EB"));
        panel_titleBar.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        add(panel_titleBar);

//@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@{ Topbar Title }@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@

        lb_topbarTitle = new JLabel("Password Recovery");
        lb_topbarTitle.setBounds(450, 20, 400, 40);
        lb_topbarTitle.setForeground(Color.WHITE);
        lb_topbarTitle.setFont(new Font("Arial", Font.BOLD, 34));
        panel_titleBar.add(lb_topbarTitle);

//@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@{ Topbar Cross Button }@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@

        btn_close = new JButton("X");
        btn_close.setBounds(1150, 25, 20, 20);
        btn_close.setBackground(null);
        btn_close.setForeground(Color.red);
        btn_close.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
        btn_close.setToolTipText("Close");
        btn_close.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        btn_close.setFocusPainted(false);
        btn_close.setFont(new Font("Arial", Font.BOLD, 20));
        panel_titleBar.add(btn_close);
        btn_close.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                dispose();
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                btn_close.setForeground(Color.decode("#cc0000"));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                btn_close.setForeground(Color.red);
            }
        });

//@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@{ Topbar Minimize Button }@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@

        btn_minimize = new JButton("-");
        btn_minimize.setBounds(1120, 25, 20, 20);
        btn_minimize.setBackground(null);
        btn_minimize.setForeground(Color.red);
        btn_minimize.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
        btn_minimize.setToolTipText("Minimize");
        btn_minimize.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        btn_minimize.setFocusPainted(false);
        btn_minimize.setFont(new Font("Arial", Font.BOLD, 20));
        panel_titleBar.add(btn_minimize);
        btn_minimize.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) { ForgotPasswordUI.super.setState(JFrame.ICONIFIED);
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                btn_minimize.setForeground(Color.decode("#cc0000"));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                btn_minimize.setForeground(Color.red);
            }
        });


//@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@{ User Verification }@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@

        JPanel panel_verification = new JPanel();
        panel_verification.setBounds(133,130,400,500);
        panel_verification.setBackground(Color.decode("#e3dfde"));
        panel_verification.setBorder(BorderFactory.createTitledBorder("User Verification"));
        panel_verification.setLayout(null);
        add(panel_verification);

        JLabel lb_username = new JLabel("Username");
        lb_username.setBounds(50,100,300,20);
        lb_username.setFont(new Font("Arial",Font.PLAIN,20));
        panel_verification.add(lb_username);

        txt_username = new JTextField();
        txt_username.setBounds(50,130,300,30);
        txt_username.setFont(new Font("Arial",Font.PLAIN,20));
        panel_verification.add(txt_username);

        JLabel lb_securityQuestion = new JLabel("Security Question");
        lb_securityQuestion.setBounds(50,200,300,20);
        lb_securityQuestion.setFont(new Font("Arial",Font.PLAIN,20));
        panel_verification.add(lb_securityQuestion);

        JComboBox cmbx_securityQuestion = new JComboBox(SignUpUI.securityQuestions);
        cmbx_securityQuestion.setBounds(50,230,300,30);
        cmbx_securityQuestion.setFont(new Font("Arial",Font.PLAIN,18));
        panel_verification.add(cmbx_securityQuestion);

        JLabel lb_answer = new JLabel("Answer");
        lb_answer.setBounds(50,300,300,20);
        lb_answer.setFont(new Font("Arial",Font.PLAIN,20));
        panel_verification.add(lb_answer);

        JTextField txt_answer = new JTextField();
        txt_answer.setBounds(50,330,300,30);
        txt_answer.setFont(new Font("Arial",Font.PLAIN,20));
        panel_verification.add(txt_answer);

        btn_generatePassword = new JButton("Generate Password");
        btn_generatePassword.setBounds(50,390,300,40);
        btn_generatePassword.setFont(new Font("Arial",Font.BOLD,18));
        btn_generatePassword.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        btn_generatePassword.setBackground(Color.decode("#1877EB"));
        btn_generatePassword.setFocusPainted(false);
        panel_verification.add(btn_generatePassword);
        btn_generatePassword.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if(txt_username.getText().isEmpty()){
                    JOptionPane.showMessageDialog(null,"Please enter your username first","Error",JOptionPane.ERROR_MESSAGE);
                }
                else if(cmbx_securityQuestion.getSelectedIndex()==0){
                    JOptionPane.showMessageDialog(null,"Please select your security question and enter answer to recover your password.","Incomplete Information",JOptionPane.ERROR_MESSAGE);
                }
                else if(txt_answer.getText().isEmpty()){
                    JOptionPane.showMessageDialog(null,"Please  enter answer of security question to recover your password.","Incomplete Information",JOptionPane.ERROR_MESSAGE);
                }
                else{
                    // Here password will be recovered after matching provided data in DB
                    if(true/*recoverPassword(txt_username.getText().trim(),cmbx_securityQuestion.getSelectedIndex(),txt_answer.getText().trim())*/){
                        JOptionPane.showMessageDialog(null,"User verified successfully! Please enter you new Password and save it","Password Recovery",JOptionPane.INFORMATION_MESSAGE);
                        txt_password.setEditable(true);
                        txt_confirmPassword.setEditable(true);
                        btn_savePassword.setEnabled(true);
                        txt_username.setEditable(false);
                        cmbx_securityQuestion.setEditable(false);

                        txt_answer.setEditable(false);
                        btn_generatePassword.setEnabled(false);
                        txt_password.grabFocus();
                    }
                }
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                btn_generatePassword.setBackground(Color.decode("#1262c4"));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                btn_generatePassword.setBackground(Color.decode("#1877EB"));
            }
        });


//@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@{ Reset Password }@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@

        JPanel panel_resetPassword = new JPanel();
        panel_resetPassword.setBounds(666,130,400,500);
        panel_resetPassword.setBackground(Color.decode("#e3dfde"));
        panel_resetPassword.setBorder(BorderFactory.createTitledBorder("Reset Password"));
        panel_resetPassword.setLayout(null);
        add(panel_resetPassword);

        JLabel lb_password = new JLabel("New Password");
        lb_password.setBounds(50,100,300,20);
        lb_password.setFont(new Font("Arial",Font.PLAIN,20));
        panel_resetPassword.add(lb_password);

        txt_password = new JPasswordField();
        txt_password.setBounds(50,130,300,30);
        txt_password.setFont(new Font("Arial",Font.PLAIN,20));
        txt_password.setEditable(false);
        panel_resetPassword.add(txt_password);

        JLabel lb_confirmPassword = new JLabel("Confirm Password");
        lb_confirmPassword.setBounds(50,200,300,20);
        lb_confirmPassword.setFont(new Font("Arial",Font.PLAIN,20));
        panel_resetPassword.add(lb_confirmPassword);

        txt_confirmPassword = new JPasswordField();
        txt_confirmPassword.setBounds(50,230,300,30);
        txt_confirmPassword.setFont(new Font("Arial",Font.PLAIN,18));
        txt_confirmPassword.setEditable(false);
        panel_resetPassword.add(txt_confirmPassword);

        btn_savePassword = new JButton("Save Password");
        btn_savePassword.setBounds(50,310,300,40);
        btn_savePassword.setBackground(Color.decode("#25c455"));
        btn_savePassword.setFont(new Font("Arial",Font.BOLD,18));
        btn_savePassword.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        btn_savePassword.setEnabled(false);
        btn_savePassword.setFocusPainted(false);
        panel_resetPassword.add(btn_savePassword);
        btn_savePassword.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if(txt_password.getText().trim().isEmpty() || txt_confirmPassword.getText().trim().isEmpty()){
                    JOptionPane.showMessageDialog(null,"Please Fill all the Fields","Incomplete Information",JOptionPane.ERROR_MESSAGE);
                }
                else if(!txt_password.getText().trim().equals(txt_confirmPassword.getText().trim())){
                    JOptionPane.showMessageDialog(null,"Password and Confirm Password not matched","Password Error",JOptionPane.ERROR_MESSAGE);
                }
                else if(!isPasswordStrong(txt_password.getText().trim())){
                    JOptionPane.showMessageDialog(null, "Error! Your password must contain Uppercase Lowercase and Special Characters and length should be between 8-30\nFor Example, ABCde12@", "Weak Password!", JOptionPane.ERROR_MESSAGE);
                }
                else{

                   // try {

//                        Driver.dataAgent.resetPassword(txt_password.getText().trim());
                        JOptionPane.showMessageDialog(null,"Password recovered successfully","Password Recovery",JOptionPane.INFORMATION_MESSAGE);
                        dispose();
                        new LoginUI();

                  //  } catch (SQLException throwables) {
                   //     throwables.printStackTrace();
                 //   }

                }
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                btn_savePassword.setBackground(Color.decode("#199e41"));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                btn_savePassword.setBackground(Color.decode("#25c455"));
            }
        });


        JButton btn_back = new JButton("Back");
        btn_back.setBounds(30,650,100,35);
        btn_back.setFont(new Font("Arial",Font.BOLD,18));
        btn_back.setBackground(Color.RED);
        add(btn_back);
        btn_back.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                dispose();
                new LoginUI();
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                btn_back.setBackground(Color.decode("#cc1006"));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                btn_back.setBackground(Color.RED);
            }
        });


        setVisible(true);
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


    public static void main(String[] args) {
        new ForgotPasswordUI();
    }
}