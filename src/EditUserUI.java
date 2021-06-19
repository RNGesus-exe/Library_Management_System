import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.RoundRectangle2D;
import java.sql.SQLException;

public class EditUserUI extends JFrame implements ActionListener {

    private final int FRAME_WIDTH = 1200;
    private final int FRAME_HEIGHT = 900;
    private final Font sidebarMenuFont = new Font("Arial", Font.BOLD, 26);


    private JPanel panel_titleBar;
    private JPanel panel_sidebar;
    private JPanel panel_body;
    private JPanel panel_issueBook;
    private JPanel panel_returnBook;
    private JPanel panel_booksLogs;
    private JPanel panel_userInfo;
    private JPanel panel_logout;
    private JLabel lb_topbarTitle;
    private JLabel lb_logo;


    private JButton btn_close;
    private JButton btn_minimize;

    private Color sidebarItemColor = Color.decode("#1568cf");
    private Color sidebarHoverColor = Color.decode("#0753b0");
    private Color sidebarColor = Color.decode("#1877EB");
    private Color tobarColor = Color.decode("#1877EB");
    private Color dashboardItemColor = Color.decode("#e0dcdc");
    private Color topbarColor = Color.decode("#ede2e1");

    private Font labelFonts = new Font("Arial",Font.BOLD,20);
    private Font textFieldFont = new Font("Arial",Font.BOLD,18);

    private Image img;

    public EditUserUI() {
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


//@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@{ Logo }@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@

        img = new ImageIcon("img/books.jpg").getImage().getScaledInstance(200,200,Image.SCALE_SMOOTH);
        lb_logo = new JLabel(new ImageIcon(img));
        lb_logo.setBounds(50,30,200,200);
        lb_logo.setBackground(Color.BLACK);
        lb_logo.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        panel_sidebar.add(lb_logo);

//@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@{ Sidebar Menu Items }@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@

//<<<<< Manage Users >>>>>>
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
                new UserManagementUI();
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

        //Icon
        img = new ImageIcon("img/users.jpg").getImage().getScaledInstance(50,50,Image.SCALE_SMOOTH);
        JLabel lb_issueBookIcon = new JLabel(new ImageIcon(img));
        lb_issueBookIcon.setBounds(0,0,60,60);
        panel_issueBook.add(lb_issueBookIcon);

        // Label
        JLabel lb_issueBook = new JLabel("Manage Users");
        lb_issueBook.setBounds(70,0,190, 60);
        lb_issueBook.setFont(sidebarMenuFont);
        panel_issueBook.add(lb_issueBook);

//<<<<< Manage Books >>>>>>
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
                new BookManagementUI();
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

        //Menu Icon
        img = new ImageIcon("img/books.jpg").getImage().getScaledInstance(50,50,Image.SCALE_SMOOTH);
        JLabel lb_returnBookIcon = new JLabel(new ImageIcon(img));
        lb_returnBookIcon.setBounds(0,0,60,60);
        panel_returnBook.add(lb_returnBookIcon);

        // Menu Label
        JLabel lb_returnBook = new JLabel("Manage Books");
        lb_returnBook.setBounds(70,0,190, 60);
        lb_returnBook.setFont(sidebarMenuFont);
        panel_returnBook.add(lb_returnBook);

//<<<<< Log Out >>>>>>
        panel_booksLogs = new JPanel();
        panel_booksLogs.setBounds(20,390,260,60);
        panel_booksLogs.setBackground(sidebarItemColor);
        panel_booksLogs.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        panel_booksLogs.setLayout(null);
        panel_sidebar.add(panel_booksLogs);
        panel_booksLogs.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                dispose();
                new LoginUI();
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                panel_booksLogs.setBackground(sidebarHoverColor);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                panel_booksLogs.setBackground(sidebarItemColor);
            }
        });

        img = new ImageIcon("img/logout.jpg").getImage().getScaledInstance(50,50,Image.SCALE_SMOOTH);
        JLabel lb_bookLogsIcon = new JLabel(new ImageIcon(img));
        lb_bookLogsIcon.setBounds(0,0,60,60);
        panel_booksLogs.add(lb_bookLogsIcon);

        JLabel lb_bookLogs = new JLabel("Log Out");
        lb_bookLogs.setBounds(70,0,190, 60);
        lb_bookLogs.setFont(sidebarMenuFont);
        panel_booksLogs.add(lb_bookLogs);

//@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@{ Top Title Bar }@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@

        panel_titleBar = new JPanel();
        panel_titleBar.setLayout(null);
        panel_titleBar.setBounds(0,0,FRAME_WIDTH,70);
        panel_titleBar.setBackground(topbarColor);
        add(panel_titleBar);

//@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@{ Topbar Title }@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@

        lb_topbarTitle = new JLabel("Edit User");
        lb_topbarTitle.setBounds(320,20,300,30);
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
        btn_minimize.addActionListener(this);
        panel_titleBar.add(btn_minimize);
        btn_minimize.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                EditUserUI.super.setState(JFrame.ICONIFIED);
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

//@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@{ Body }@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@

        panel_body = new JPanel();
        panel_body.setBounds(300,70,900,830);
        panel_body.setLayout(null);
        panel_body.setBackground(Color.decode("#ebebeb"));
        add(panel_body);

//@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@{ User Info }@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@

        JPanel panel_userInfo = new JPanel();
        panel_userInfo.setBounds(50,90,800,660);
        panel_userInfo.setBackground(dashboardItemColor);
        panel_userInfo.setLayout(null);
        panel_body.add(panel_userInfo);


        JLabel lb_bookDetail = new JLabel("User Information");
        lb_bookDetail.setBounds(300,20,250,32);
        lb_bookDetail.setFont(new Font("Arial",Font.BOLD,30));
//        panel_userInfo.add(lb_bookDetail);

//<<<<<< Details >>>>>>>>

        JLabel lb_fname = new JLabel("First Name");
        lb_fname.setBounds(100,50,200,25);
        lb_fname.setFont(labelFonts);
        lb_fname.setForeground(Color.red);
        panel_userInfo.add(lb_fname);

        JTextField txt_fname = new JTextField();
        txt_fname.setBounds(400,45,300,30);
        txt_fname.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        txt_fname.setEditable(false);
        txt_fname.setFont(textFieldFont);
//        txt_fname.setText();
        panel_userInfo.add(txt_fname);

        // Name
        JLabel lb_lname = new JLabel("Last Name");
        lb_lname.setBounds(100,100,200,25);
        lb_lname.setFont(labelFonts);
        lb_lname.setForeground(Color.red);
        panel_userInfo.add(lb_lname);

        JTextField txt_lname = new JTextField();
        txt_lname.setBounds(400,95,300,30);
        txt_lname.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        txt_lname.setEditable(false);
        txt_lname.setFont(textFieldFont);
//        txt_lname.setText(Driver.currentUser.getFirstName()+" "+Driver.currentUser.getLastName());
        panel_userInfo.add(txt_lname);

        // Mobile Number
        JLabel lb_mobileNumber = new JLabel("Mobile Number");
        lb_mobileNumber.setBounds(100,150,200,25);
        lb_mobileNumber.setFont(labelFonts);
        lb_mobileNumber.setForeground(Color.red);
        panel_userInfo.add(lb_mobileNumber);

        JTextField txt_mobileNumber = new JTextField();
        txt_mobileNumber.setBounds(400,145,300,30);
        txt_mobileNumber.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        txt_mobileNumber.setEditable(false);
        txt_mobileNumber.setFont(textFieldFont);
//        txt_mobileNumber.setText(Driver.currentUser.getMobileNumber());
        panel_userInfo.add(txt_mobileNumber);

        // Address
        JLabel lb_address = new JLabel("Address");
        lb_address.setBounds(100,200,200,25);
        lb_address.setFont(labelFonts);
        lb_address.setForeground(Color.red);
        panel_userInfo.add(lb_address);

        JTextArea textArea_address = new JTextArea();
        textArea_address.setBounds(400,195,300,50);
        textArea_address.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        textArea_address.setEditable(false);
        textArea_address.setFont(textFieldFont);
//        textArea_address.setText(Driver.currentUser.getAddress());
        panel_userInfo.add(textArea_address);

        // CNIC
        JLabel lb_cnic = new JLabel("CNIC");
        lb_cnic.setBounds(100,275,200,25);
        lb_cnic.setFont(labelFonts);
        lb_cnic.setForeground(Color.red);
        panel_userInfo.add(lb_cnic);

        JTextField txt_cnic = new JTextField();
        txt_cnic.setBounds(400,270,300,30);
        txt_cnic.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        txt_cnic.setEditable(false);
        txt_cnic.setFont(textFieldFont);
//        txt_cnic.setText(Driver.currentUser.getCnic());
        panel_userInfo.add(txt_cnic);

        // Email
        JLabel lb_email = new JLabel("Email");
        lb_email.setBounds(100,325,200,25);
        lb_email.setFont(labelFonts);
        lb_email.setForeground(Color.red);
        panel_userInfo.add(lb_email);

        JTextField txt_email = new JTextField();
        txt_email.setBounds(400,320,300,30);
        txt_email.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        txt_email.setEditable(false);
        txt_email.setFont(textFieldFont);
//        txt_email.setText(Driver.currentUser.getEmail());
        panel_userInfo.add(txt_email);

        // Password
        JLabel lb_password = new JLabel("Password");
        lb_password.setBounds(100,375,200,25);
        lb_password.setFont(labelFonts);
        lb_password.setForeground(Color.red);
        panel_userInfo.add(lb_password);

        JPasswordField txt_password = new JPasswordField();
        txt_password.setBounds(400,370,300,30);
        txt_password.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        txt_password.setEditable(false);
        txt_password.setFont(textFieldFont);
//        txt_password.setText(Driver.currentUser.getEmail());
        panel_userInfo.add(txt_password);

        // User Rank
        JLabel lb_rank = new JLabel("Rank");
        lb_rank.setBounds(100,435,200,25);
        lb_rank.setFont(labelFonts);
        lb_rank.setForeground(Color.red);
        panel_userInfo.add(lb_rank);

        JTextField txt_rank = new JTextField();
        txt_rank.setBounds(400,440,300,30);
        txt_rank.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        txt_rank.setEditable(false);
        txt_rank.setFont(textFieldFont);
        txt_rank.setText(Driver.levels[(Driver.dataAgent.getUserExperience(UserManagementUI.selectedUser.getUser_id())/2)-1]);
        panel_userInfo.add(txt_rank);

        // Book Issue Limit
        JLabel lb_limit = new JLabel("Book Issue Limit");
        lb_limit.setBounds(100,485,200,25);
        lb_limit.setFont(labelFonts);
        lb_limit.setForeground(Color.red);
        panel_userInfo.add(lb_limit);

        JTextField txt_limit = new JTextField();
        txt_limit.setBounds(400,490,300,30);
        txt_limit.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        txt_limit.setEditable(false);
        txt_limit.setFont(textFieldFont);
        txt_limit.setText(""+Driver.dataAgent.getUserExperience(UserManagementUI.selectedUser.getUser_id())*2);
        panel_userInfo.add(txt_limit);


        // Current Issued Books
        JLabel lb_NoOfIssuedBooks = new JLabel("Current Issued Books");
        lb_NoOfIssuedBooks.setBounds(100,535,250,25);
        lb_NoOfIssuedBooks.setFont(labelFonts);
        lb_NoOfIssuedBooks.setForeground(Color.red);
        panel_userInfo.add(lb_NoOfIssuedBooks);

        JTextField txt_NoOfIssuedBooks = new JTextField();
        txt_NoOfIssuedBooks.setBounds(400,540,300,30);
        txt_NoOfIssuedBooks.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        txt_NoOfIssuedBooks.setEditable(false);
        txt_NoOfIssuedBooks.setFont(textFieldFont);
        txt_NoOfIssuedBooks.setText(""+Driver.dataAgent.getIssuedBooksCount(UserManagementUI.selectedUser.getUser_id()));
        panel_userInfo.add(txt_NoOfIssuedBooks);


        JButton btn_save = new JButton("Save Changes");
        btn_save.setBounds(630,600,150,35);
        btn_save.setBackground(Color.decode("#31ad50"));
        btn_save.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        btn_save.setFont(new Font("Arial", Font.BOLD, 16));
        btn_save.setFocusPainted(false);
        btn_save.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if(isUsernameValid(txt_fname.getText(),txt_lname.getText())){
//                    try {

//                        Driver.dataAgent.updateUser(UserManagementUI.selectedUser.getUser_id(),txt_fname.getText(),txt_lname.getText(),textArea_address.getText());
                        JOptionPane.showMessageDialog(null,"User updated sucessfully","Updation",JOptionPane.INFORMATION_MESSAGE);
                        dispose();
                        new UserManagementUI();
//                    } catch (SQLException throwables) {
//                        throwables.printStackTrace();
//                    }
                }else{
                    JOptionPane.showMessageDialog(null,"Invalid Username! Please enter valid username without numbers and special characters and length<=20","Error",JOptionPane.ERROR_MESSAGE);
                }
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                btn_save.setBackground(Color.decode("#227d39"));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                btn_save.setBackground(Color.decode("#31ad50"));
            }
        });




        setVisible(true);
    }

    public boolean isUsernameValid(String firstName, String lastName){
        if(firstName.matches("(.*)[0-9](.*)") || lastName.matches("(.*)[0-9](.*)")){
            System.out.println("Yes");
            return false;
        }
        else if(firstName.matches("(?=.*[~!@#$%^&*()_-]).*") || lastName.matches("(?=.*[~!@#$%^&*()_-]).*")){
            return false;
        }
        else if(firstName.length()>20 || lastName.length()>20){
            return false;
        }
        else{
            return true;
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

    public static void main(String[] args) {
        new EditUserUI();
    }
}
