import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.RoundRectangle2D;

public class ForgotPasswordUI extends JFrame {

    private final int FRAME_WIDTH = 1200;
    private final int FRAME_HEIGHT = 640;

    private JPanel panel_titleBar;
    private JLabel lb_topbarTitle;
    private JTextField txt_username;

    private JButton btn_close;
    private JButton btn_minimize;

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

        lb_topbarTitle = new JLabel("User Login");
        lb_topbarTitle.setBounds(500, 20, 300, 40);
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


//@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@{ User Icon }@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@

        img = new ImageIcon("img/user.png").getImage().getScaledInstance(200, 200, Image.SCALE_SMOOTH);
        JLabel lb_userIcon = new JLabel(new ImageIcon(img));
        lb_userIcon.setBounds(500, 80, 200, 200);
        add(lb_userIcon);

//@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@{ User Icon }@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@

        img = new ImageIcon("img/user.png").getImage().getScaledInstance(200, 200, Image.SCALE_SMOOTH);
        JLabel lb_emailIcon = new JLabel(new ImageIcon(img));

//@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@{ User Icon }@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@

        JLabel lb_username = new JLabel("Username");
        lb_username.setBounds(450,285,300,20);
        lb_username.setFont(new Font("Arial",Font.PLAIN,20));
        add(lb_username);

        txt_username = new JTextField();
        txt_username.setBounds(450,310,300,30);
        txt_username.setFont(new Font("Arial",Font.PLAIN,20));
//      txt_username.setUI(new HintTextFieldUI("Enter Username",false));
        add(txt_username);

        JLabel lb_securityQuestion = new JLabel("Security Question");
        lb_securityQuestion.setBounds(450,355,300,20);
        lb_securityQuestion.setFont(new Font("Arial",Font.PLAIN,20));
        add(lb_securityQuestion);

        JComboBox cmbx_securityQuestion = new JComboBox(SignUpUI.securityQuestions);
        cmbx_securityQuestion.setBounds(450,380,300,30);
        cmbx_securityQuestion.setFont(new Font("Arial",Font.PLAIN,18));
        add(cmbx_securityQuestion);

        JLabel lb_answer = new JLabel("Answer");
        lb_answer.setBounds(450,425,300,20);
        lb_answer.setFont(new Font("Arial",Font.PLAIN,20));
        add(lb_answer);

        JTextField txt_answer = new JTextField();
        txt_answer.setBounds(450,450,300,30);
        txt_answer.setFont(new Font("Arial",Font.PLAIN,20));
        add(txt_answer);

        JButton btn_generatePassword = new JButton("Generate Password");
        btn_generatePassword.setBounds(450,500,300,40);
        btn_generatePassword.setFont(new Font("Arial",Font.BOLD,18));
        btn_generatePassword.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        btn_generatePassword.setBackground(Color.decode("#25c455"));
        add(btn_generatePassword);
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
//                    String reciveredPass = recoverPassword(txt_username.getText().trim(),cmbx_securityQuestion.getSelectedIndex(),txt_answer.getText().trim());
                    JOptionPane.showMessageDialog(null,"Your Password is : ------","Password Recovery",JOptionPane.INFORMATION_MESSAGE);
                    dispose();
                    new LoginUI();
                }
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                btn_generatePassword.setBackground(Color.decode("#199e41"));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                btn_generatePassword.setBackground(Color.decode("#25c455"));
            }
        });

        setVisible(true);
    }


    public static void main(String[] args) {
        new ForgotPasswordUI();
    }
}