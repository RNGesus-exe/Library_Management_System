import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.RoundRectangle2D;
import java.io.IOException;
import java.sql.SQLException;

public class LoginUI extends JFrame {

    private final int FRAME_WIDTH = 1200;
    private final int FRAME_HEIGHT = 640;

    private JPanel panel_titleBar;
    private JLabel lb_topbarTitle;

    private JButton btn_close;
    private JButton btn_minimize;

    private JTextField txt_username;
    private JPasswordField txt_password;

    private JCheckBox chkbx_showPassword;
    private JCheckBox chkbx_rememberMe;

    private Color topbarColor = Color.decode("#1877EB");
    private Color frameColor = Color.decode("#ede2e1");
    private Color buttonHoverColor = Color.decode("#0e65cf");

    private Image img;



    public LoginUI(){
        init();
    }

    public void init(){

//@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@{ Main Frame }@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setSize(FRAME_WIDTH,FRAME_HEIGHT);
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
        panel_titleBar.setBounds(0,0,FRAME_WIDTH,70);
        panel_titleBar.setBackground(Color.decode("#1877EB"));
        panel_titleBar.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        add(panel_titleBar);

//@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@{ Topbar Title }@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@

        lb_topbarTitle = new JLabel("User Login");
        lb_topbarTitle.setBounds(500,20,300,40);
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
        btn_minimize.setBorder(BorderFactory.createEmptyBorder(0,0,0,0));
        btn_minimize.setToolTipText("Minimize");
        btn_minimize.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        btn_minimize.setFocusPainted(false);
        btn_minimize.setFont(new Font("Arial", Font.BOLD, 20));
        panel_titleBar.add(btn_minimize);
        btn_minimize.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                LoginUI.super.setState(JFrame.ICONIFIED);
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


//@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@{ User Icon }@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@

        img = new ImageIcon("img/user.png").getImage().getScaledInstance(200,200,Image.SCALE_SMOOTH);
        JLabel lb_userIcon = new JLabel(new ImageIcon(img));
        lb_userIcon.setBounds(500,80,200,200);
        add(lb_userIcon);

//@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@{ User Icon }@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@

        img = new ImageIcon("img/user.png").getImage().getScaledInstance(200,200,Image.SCALE_SMOOTH);
        JLabel lb_emailIcon = new JLabel(new ImageIcon(img));

//@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@{ User Login }@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@

        //<<<<<< Username >>>>>>>
        img = new ImageIcon("img/user.png").getImage().getScaledInstance(40,40,Image.SCALE_SMOOTH);
        JLabel lb_usernameIcon = new JLabel(new ImageIcon(img));
        lb_usernameIcon.setBounds(400,300,40,40);
        lb_usernameIcon.setForeground(Color.red);
        add(lb_usernameIcon);

        txt_username = new JTextField();
        txt_username.setBounds(450,300,300,40);
        txt_username.setFont(new Font("Arial",Font.PLAIN,16));
//        txt_username.setUI(new HintTextFieldUI("Enter Username",false));
        add(txt_username);

        //<<<<<< Password >>>>>>>
        img = new ImageIcon("img/key.png").getImage().getScaledInstance(40,40,Image.SCALE_SMOOTH);
        JLabel lb_passwordIcon = new JLabel(new ImageIcon(img));
        lb_passwordIcon.setBounds(400,370,40,40);
        lb_passwordIcon.setForeground(Color.red);
        add(lb_passwordIcon);

        txt_password = new JPasswordField();
        txt_password.setBounds(450,370,300,40);
        txt_password.setFont(new Font("Arial",Font.PLAIN,16));
//        txt_password.setUI(new HintTextFieldUI("Enter Password",false));
        add(txt_password);

        chkbx_rememberMe = new JCheckBox();
        chkbx_rememberMe.setBounds(450,420,20,20);
        add(chkbx_rememberMe);

        JLabel lb_rememberMe = new JLabel("Remember me");
        lb_rememberMe.setBounds(470,420,100,20);
        add(lb_rememberMe);

        chkbx_showPassword = new JCheckBox();
        chkbx_showPassword.setBounds(630,420,20,20);
        add(chkbx_showPassword);
        chkbx_showPassword.addActionListener(ae -> {
            JCheckBox c = (JCheckBox) ae.getSource();
            txt_password.setEchoChar(c.isSelected() ? '\u0000' :(Character)UIManager.get("PasswordField.echoChar"));
        });

        JLabel lb_showPassword = new JLabel("Show Password");
        lb_showPassword.setBounds(650,420,100,20);
        add(lb_showPassword);

//@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@{ Login Button }@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@

        JButton btn_login = new JButton("Login");
        btn_login.setBounds(450,470,300,40);
        btn_login.setBackground(topbarColor);
        btn_login.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        btn_login.setFont(new Font("Arial",Font.BOLD,16));
        btn_login.setFocusPainted(false);
        add(btn_login);
        btn_login.addMouseListener(new MouseAdapter() {
            int userID = -1;
            @Override
            public void mouseClicked(MouseEvent e) {
                if(txt_username.getText().isEmpty() || txt_password.getText().isEmpty()){
                    JOptionPane.showMessageDialog(null,"Please fill all the fields","Empty Fields",JOptionPane.ERROR_MESSAGE);
                }else if((userID=Driver.dataAgent.getId(txt_username.getText().trim(),txt_password.getText().trim()))==-1){
                    JOptionPane.showMessageDialog(null,"Invalid Username or Password","Error",JOptionPane.ERROR_MESSAGE);
                }else{

                    // Uploading Books to DB
                    if(Driver.dataAgent.isBookTableEmpty()){
                        Driver.dataAgent.uploadBooksToDatabase();
                    }

                    if(chkbx_rememberMe.isSelected())
                    {

                        try {
                            // Remembering User and Loading Data from DB
                            new FileManager().writeUserId(userID);
                            Driver.currentUser = Driver.dataAgent.loadUserInfoFromDataBase(userID);

                        } catch (IOException ioException) {
                            ioException.printStackTrace();
                        } catch (SQLException throwables) {
                            throwables.printStackTrace();
                        }
                    }

                    dispose();
                    new IssueBookUI();

                }
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                btn_login.setBackground(buttonHoverColor);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                btn_login.setBackground(topbarColor);
            }
        });

//@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@{ Login Button }@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@

        JLabel lb_forgotPassword = new JLabel("Forgot Password?");
        lb_forgotPassword.setBounds(450,520,200,20);
        lb_forgotPassword.setForeground(Color.decode("#bf1b1b"));
        lb_forgotPassword.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        lb_forgotPassword.setFont(new Font("Arial",Font.BOLD,16));
        add(lb_forgotPassword);
        lb_forgotPassword.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                // Forgot Password Code
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                lb_forgotPassword.setForeground(Color.decode("#f01616"));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                lb_forgotPassword.setForeground(Color.decode("#bf1b1b"));
            }
        });

        JLabel lb_signUp = new JLabel("Don't have an account?");
        lb_signUp.setBounds(450,550,200,20);
        lb_signUp.setFont(new Font("Arial",Font.BOLD,16));
        lb_signUp.setForeground(Color.decode("#bf1b1b"));
        lb_signUp.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        add(lb_signUp);
        lb_signUp.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                dispose();
                new SignUpUI();
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                lb_signUp.setForeground(Color.decode("#f01616"));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                lb_signUp.setForeground(Color.decode("#bf1b1b"));
            }
        });




        setVisible(true);

    }

}
