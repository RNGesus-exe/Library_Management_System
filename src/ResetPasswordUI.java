import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.RoundRectangle2D;
import java.sql.SQLException;

public class ResetPasswordUI extends JFrame implements ActionListener {

    private final int FRAME_WIDTH = 1200;
    private final int FRAME_HEIGHT = 900;
    private final Font sidebarMenuFont = new Font("Arial", Font.BOLD, 26);

    private DefaultListModel<String> listModel = new DefaultListModel<>();

    private DefaultTableModel tableModel1 = new DefaultTableModel();
    private DefaultTableModel tableModel2 = new DefaultTableModel();


    private JTextField txt_releaseDate = null;
    private JTextField txt_rating = null;
    private JTextField txt_pages = null;
    private JTextField txt_genre = null;
    private JTextField txt_author = null;
    private JTextField txt_title = null;
    private JTextField txt_oldPassword = null;
    private JTextField txt_newPassword = null;
    private JTextField txt_confirmPassword = null;

    private JPanel panel_titleBar;
    private JPanel panel_sidebar;
    private JPanel panel_body;
    private JPanel panel_issueBook;
    private JPanel panel_returnBook;
    private JPanel panel_bookLogs;
    private JPanel panel_userInfo;
    private JPanel panel_logout;
    private JLabel lb_topbarTitle;
    private JLabel lb_logo;

    private JButton btn_save;


    private JButton btn_close;
    private JButton btn_minimize;

    private Color sidebarItemColor = Color.decode("#1568cf");
    private Color sidebarHoverColor = Color.decode("#0753b0");
    private Color sidebarColor = Color.decode("#1877EB");
    private Color tobarColor = Color.decode("#1877EB");
    private Color dashboardItemColor = Color.decode("#e0dcdc");
    private Color topbarColor = Color.decode("#ede2e1");

    private Font labelFonts = new Font("Arial",Font.BOLD,20);

    private Image img;

    public ResetPasswordUI() {
        init();
    }

    public void init(){

//@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@{ Main Frame }@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setSize(FRAME_WIDTH,FRAME_HEIGHT);
        setLocationRelativeTo(null);
        getContentPane().setBackground(Color.decode("#ede2e1"));
        setUndecorated(true);
        setShape(new RoundRectangle2D.Double(0, 0, FRAME_WIDTH, FRAME_HEIGHT, 40, 40));
        setLayout(null);
        FrameDragListener frameDragListener = new FrameDragListener(this);
        super.addMouseListener(frameDragListener);
        super.addMouseMotionListener(frameDragListener);

//@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@{ Sidebar }@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@

        panel_sidebar = new JPanel();
        panel_sidebar.setLayout(null);
        panel_sidebar.setBackground(sidebarColor);
        panel_sidebar.setBounds(0, 0, 300, 900);
        add(panel_sidebar);

//@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@{ Body }@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@

        panel_body = new JPanel();
        panel_body.setBounds(300,70,900,830);
        panel_body.setLayout(null);
        panel_body.setBackground(Color.decode("#ebebeb"));
        add(panel_body);


//@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@{ Logo }@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@

        img = new ImageIcon("img/books.jpg").getImage().getScaledInstance(200,200,Image.SCALE_SMOOTH);
        lb_logo = new JLabel(new ImageIcon(img));
        lb_logo.setBounds(50,30,200,200);
        lb_logo.setBackground(Color.BLACK);
        lb_logo.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        panel_sidebar.add(lb_logo);

//@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@{ Sidebar Menu Items }@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@

//<<<<< Issue Book >>>>>>
        panel_issueBook = new JPanel();
        panel_issueBook.setBounds(20,260,260,60);
        panel_issueBook.setBackground(sidebarItemColor);
        panel_issueBook.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        panel_issueBook.setLayout(null);
        panel_sidebar.add(panel_issueBook);
        panel_issueBook.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                dispose();
                new IssueBookUI();
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                panel_issueBook.setBackground(sidebarHoverColor);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                panel_issueBook.setBackground(sidebarItemColor);
            }
        });

        img = new ImageIcon("img/book-exchange.png").getImage().getScaledInstance(50,50,Image.SCALE_SMOOTH);
        JLabel lb_issueBookIcon = new JLabel(new ImageIcon(img));
        lb_issueBookIcon.setBounds(0,0,60,60);
        panel_issueBook.add(lb_issueBookIcon);

        JLabel lb_issueBook = new JLabel("Issue Book");
        lb_issueBook.setBounds(70,0,190, 60);
        lb_issueBook.setFont(sidebarMenuFont);
        panel_issueBook.add(lb_issueBook);


//<<<<< Return Book >>>>>>
        panel_returnBook = new JPanel();
        panel_returnBook.setBounds(20,325,260,60);
        panel_returnBook.setBackground(sidebarItemColor);
        panel_returnBook.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        panel_returnBook.setLayout(null);
        panel_sidebar.add(panel_returnBook);
        panel_returnBook.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                dispose();
                new ReturnBookUI();
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                panel_returnBook.setBackground(sidebarHoverColor);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                panel_returnBook.setBackground(sidebarItemColor);
            }
        });


        img = new ImageIcon("img/book-return.png").getImage().getScaledInstance(50,50,Image.SCALE_SMOOTH);
        JLabel lb_returnBookIcon = new JLabel(new ImageIcon(img));
        lb_returnBookIcon.setBounds(0,0,60,60);
        panel_returnBook.add(lb_returnBookIcon);

        JLabel lb_returnBook = new JLabel("Return Book");
        lb_returnBook.setBounds(70,0,190, 60);
        lb_returnBook.setFont(sidebarMenuFont);
        panel_returnBook.add(lb_returnBook);

        //<<<<< Book Logs >>>>>>
        panel_bookLogs = new JPanel();
        panel_bookLogs.setBounds(20,390,260,60);
        panel_bookLogs.setBackground(sidebarItemColor);
        panel_bookLogs.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        panel_bookLogs.setLayout(null);
        panel_sidebar.add(panel_bookLogs);
        panel_bookLogs.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                dispose();
                new BookLogsUI();
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                panel_bookLogs.setBackground(sidebarHoverColor);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                panel_bookLogs.setBackground(sidebarItemColor);
            }
        });

        img = new ImageIcon("img/book-log.png").getImage().getScaledInstance(50,50,Image.SCALE_SMOOTH);
        JLabel lb_bookLogsIcon = new JLabel(new ImageIcon(img));
        lb_bookLogsIcon.setBounds(0,0,60,60);
        panel_bookLogs.add(lb_bookLogsIcon);

        JLabel lb_bookLogs = new JLabel("Book logs");
        lb_bookLogs.setBounds(70,0,190, 60);
        lb_bookLogs.setFont(sidebarMenuFont);
        panel_bookLogs.add(lb_bookLogs);

//<<<<< User Info >>>>>>
        panel_userInfo = new JPanel();
        panel_userInfo.setBounds(20,455,260,60);
        panel_userInfo.setBackground(sidebarItemColor);
        panel_userInfo.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        panel_userInfo.setLayout(null);
        panel_sidebar.add(panel_userInfo);
        panel_userInfo.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                dispose();
                new UserInfoUI();
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                panel_userInfo.setBackground(sidebarHoverColor);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                panel_userInfo.setBackground(sidebarItemColor);
            }
        });

        img = new ImageIcon("img/user-info.png").getImage().getScaledInstance(50,50,Image.SCALE_SMOOTH);
        JLabel lb_userInfoIcon = new JLabel(new ImageIcon(img));
        lb_userInfoIcon.setBounds(0,0,60,60);
        panel_userInfo.add(lb_userInfoIcon);

        JLabel lb_userInfo = new JLabel("User Info");
        lb_userInfo.setBounds(70,0,190, 60);
        lb_userInfo.setFont(sidebarMenuFont);
        panel_userInfo.add(lb_userInfo);

//<<<<< Log Out >>>>>>
        panel_logout = new JPanel();
        panel_logout.setBounds(20,520,260,60);
        panel_logout.setBackground(sidebarItemColor);
        panel_logout.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        panel_logout.setLayout(null);
        panel_sidebar.add(panel_logout);
        panel_logout.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                new FileManager().deleteSharedPreferences();
                dispose();
                new LoginUI();
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                panel_logout.setBackground(sidebarHoverColor);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                panel_logout.setBackground(sidebarItemColor);
            }
        });

        //Home Icon
        img = new ImageIcon("img/logout.jpg").getImage().getScaledInstance(50,50,Image.SCALE_SMOOTH);
        JLabel lb_logoutIcon = new JLabel(new ImageIcon(img));
        lb_logoutIcon.setBounds(0,0,60,60);
        panel_logout.add(lb_logoutIcon);

        // Home Menu
        JLabel lb_logout = new JLabel("Log Out");
        lb_logout.setBounds(70,0,190, 60);
        lb_logout.setFont(sidebarMenuFont);
        panel_logout.add(lb_logout);

//@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@{ Top Title Bar }@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@

        panel_titleBar = new JPanel();
        panel_titleBar.setLayout(null);
        panel_titleBar.setBounds(0,0,FRAME_WIDTH,70);
        panel_titleBar.setBackground(topbarColor);
        add(panel_titleBar);

//@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@{ Topbar Title }@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@

        lb_topbarTitle = new JLabel("Reset Password");
        lb_topbarTitle.setBounds(320,20,300,35);
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
//        btn_close.addActionListener(this);
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
        btn_minimize.addActionListener(this);
        panel_titleBar.add(btn_minimize);
        btn_minimize.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                ResetPasswordUI.super.setState(JFrame.ICONIFIED);
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

//@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@{ Reset Password }@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@

        JPanel panel_resetPassword = new JPanel();
        panel_resetPassword.setBounds(50,230,800,300);
        panel_resetPassword.setBackground(dashboardItemColor);
        panel_resetPassword.setLayout(null);
        panel_body.add(panel_resetPassword);


        JLabel lb_bookDetail = new JLabel("Reset Password");
        lb_bookDetail.setBounds(300,20,250,32);
        lb_bookDetail.setFont(new Font("Arial",Font.BOLD,30));
        panel_resetPassword.add(lb_bookDetail);

        //<<<<<<( Book Details )>>>>>>>>

        //<<<<<< Old Password >>>>>>>
        JLabel lb_oldPassword = new JLabel("Old Password");
        lb_oldPassword.setBounds(100,100,200,25);
        lb_oldPassword.setFont(labelFonts);
        lb_oldPassword.setForeground(Color.red);
        panel_resetPassword.add(lb_oldPassword);

        txt_oldPassword = new JTextField();
        txt_oldPassword.setBounds(400,95,300,30);
        panel_resetPassword.add(txt_oldPassword);

        //<<<<<< Author >>>>>>>
        JLabel lb_newPassword = new JLabel("New Password");
        lb_newPassword.setBounds(100,150,200,25);
        lb_newPassword.setFont(labelFonts);
        lb_newPassword.setForeground(Color.red);
        panel_resetPassword.add(lb_newPassword);

        txt_newPassword = new JTextField();
        txt_newPassword.setBounds(400,145,300,30);
        panel_resetPassword.add(txt_newPassword);


        //<<<<<< Genre >>>>>>>
        JLabel lb_confirmPassword = new JLabel("Confirm Password");
        lb_confirmPassword.setBounds(100,200,200,25);
        lb_confirmPassword.setFont(labelFonts);
        lb_confirmPassword.setForeground(Color.red);
        panel_resetPassword.add(lb_confirmPassword);

        txt_confirmPassword = new JTextField();
        txt_confirmPassword.setBounds(400,195,300,30);
        panel_resetPassword.add(txt_confirmPassword);


        //<<<<< Save Button >>>>>

        btn_save = new JButton("Save Changes");
        btn_save.setBounds(635, 250, 150, 35);
        btn_save.setFocusPainted(false);
        btn_save.setBackground(Color.decode("#32a852"));
        btn_save.setForeground(Color.white);
        btn_save.setFont(new Font("Arial", Font.BOLD, 16));
        btn_save.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        btn_save.addActionListener(this);
        panel_resetPassword.add(btn_save);
        btn_save.addMouseListener(new MouseAdapter() {   // Button get highlighted when Cursor hover over Login Button
            public void mouseClicked(MouseEvent e){

                if(txt_oldPassword.getText().trim().isEmpty() ||
                        txt_newPassword.getText().trim().isEmpty() ||
                        txt_confirmPassword.getText().trim().isEmpty()) {
                    JOptionPane.showMessageDialog(null,"Please Fill all the Fields","Incomplete Information",JOptionPane.ERROR_MESSAGE);
                }
                else if(!txt_newPassword.getText().trim().equals(txt_confirmPassword.getText().trim())) {
                    JOptionPane.showMessageDialog(null,"Password and Confirm Password not matched","Password Error",JOptionPane.ERROR_MESSAGE);
                }
                else if(!isPasswordStrong(txt_newPassword.getText().trim())) {
                    JOptionPane.showMessageDialog(null, "Error! Your password must contain Uppercase Lowercase and Special Characters\nFor Example, ABCde12@", "Weak Password!", JOptionPane.ERROR_MESSAGE);
                }
                else{
                    JOptionPane.showMessageDialog(null,"Password changed successfully","Information", JOptionPane.INFORMATION_MESSAGE);
                    try {
                        Driver.dataAgent.resetPassword(txt_newPassword.getText().trim());
                        dispose();
                        new UserInfoUI();
                    } catch (SQLException throwables) {
                        throwables.printStackTrace();
                    }
                }
            }

            public void mouseEntered(MouseEvent e) {
                btn_save.setBackground(Color.decode("#198035"));
            }

            public void mouseExited(MouseEvent e) {
                btn_save.setBackground(Color.decode("#32a852"));
            }
        });








        setVisible(true);
    }

    public boolean isPasswordStrong(String str){
        if(str.matches("(.*)[A-Z](.*)")) // Uppercase Checking
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

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==btn_save){

        }
    }

}
