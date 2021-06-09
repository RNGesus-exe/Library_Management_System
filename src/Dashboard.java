import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.RoundRectangle2D;

public class Dashboard extends JFrame implements ActionListener {

    private final int FRAME_WIDTH = 1200;
    private final int FRAME_HEIGHT = 900;
    private final Font sidebarMenuFont = new Font("Arial", Font.BOLD, 26);


    private JPanel panel_titleBar;
    private JPanel panel_sidebar;
    private JPanel panel_body;
    private JPanel panel_dashboard;
    private JPanel panel_search;
    private JPanel panel_userInfo;
    private JPanel panel_setting;
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

    private Image img;

    public Dashboard() {
        init();
    }

    public void init() {

//@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@{ Main Frame }@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setSize(FRAME_WIDTH, FRAME_HEIGHT);
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
        panel_body.setBounds(300, 70, 900, 830);
        panel_body.setLayout(null);
        panel_body.setBackground(Color.decode("#ebebeb"));
        add(panel_body);

        //<<< Row 1 >>>>
        JPanel panel_issueBook = new JPanel();
        panel_issueBook.setBounds(100, 230, 700, 100);
        panel_issueBook.setBackground(dashboardItemColor);
        panel_issueBook.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        panel_issueBook.setLayout(null);
        panel_body.add(panel_issueBook);

        JLabel lb_issueBook = new JLabel("Issue Book");
        lb_issueBook.setBounds(25, 40, 200, 25);
        lb_issueBook.setFont(new Font("Arial", Font.BOLD, 30));
        panel_issueBook.add(lb_issueBook);


        img = new ImageIcon("img/book-exchange.png").getImage().getScaledInstance(80, 80, Image.SCALE_SMOOTH);
        JLabel lb_icon1 = new JLabel(new ImageIcon(img));
        lb_icon1.setBounds(595, 10, 80, 80);
        lb_icon1.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        panel_issueBook.add(lb_icon1);

        panel_issueBook.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {
                panel_issueBook.setBackground(sidebarColor);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                panel_issueBook.setBackground(dashboardItemColor);
            }
        });

        //-------------------------------------------------

        JPanel panel_returnBook = new JPanel();
        panel_returnBook.setBounds(100, 380, 700, 100);
        panel_returnBook.setBackground(dashboardItemColor);
        panel_returnBook.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        panel_returnBook.setLayout(null);
        panel_body.add(panel_returnBook);

        JLabel lb_returnBook = new JLabel("Return Book");
        lb_returnBook.setBounds(25, 40, 200, 25);
        lb_returnBook.setFont(new Font("Arial", Font.BOLD, 30));
        panel_returnBook.add(lb_returnBook);

        img = new ImageIcon("img/book-return.png").getImage().getScaledInstance(80, 80, Image.SCALE_SMOOTH);
        JLabel lb_icon2 = new JLabel(new ImageIcon(img));
        lb_icon2.setBounds(595, 10, 80, 80);
        lb_icon2.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        panel_returnBook.add(lb_icon2);

        panel_returnBook.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {
                panel_returnBook.setBackground(sidebarColor);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                panel_returnBook.setBackground(dashboardItemColor);
            }
        });


        //<<< Row 2 >>>>
        JPanel panel_issuedBook = new JPanel();
        panel_issuedBook.setBounds(100, 530, 700, 100);
        panel_issuedBook.setBackground(dashboardItemColor);
        panel_issuedBook.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        panel_issuedBook.setLayout(null);
        panel_body.add(panel_issuedBook);

        img = new ImageIcon("img/book-log.png").getImage().getScaledInstance(80, 80, Image.SCALE_SMOOTH);
        JLabel lb_icon4 = new JLabel(new ImageIcon(img));
        lb_icon4.setBounds(595, 10, 80, 80);
        lb_icon4.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        panel_issuedBook.add(lb_icon4);

        JLabel lb_issuedBook = new JLabel("Book Logs");
        lb_issuedBook.setBounds(25, 40, 200, 30);
        lb_issuedBook.setFont(new Font("Arial", Font.BOLD, 30));
        panel_issuedBook.add(lb_issuedBook);

        panel_issuedBook.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {
                panel_issuedBook.setBackground(sidebarColor);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                panel_issuedBook.setBackground(dashboardItemColor);
            }
        });


//@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@{ Logo }@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@

        img = new ImageIcon("img/books.jpg").getImage().getScaledInstance(200, 200, Image.SCALE_SMOOTH);
        lb_logo = new JLabel(new ImageIcon(img));
        lb_logo.setBounds(50, 30, 200, 200);
        lb_logo.setBackground(Color.BLACK);
        lb_logo.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        panel_sidebar.add(lb_logo);

//@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@{ Sidebar Menu Items }@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@

//<<<<< Home >>>>>>
        panel_dashboard = new JPanel();
        panel_dashboard.setBounds(20, 260, 260, 60);
        panel_dashboard.setBackground(sidebarHoverColor);
        panel_dashboard.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        panel_dashboard.setLayout(null);
        panel_sidebar.add(panel_dashboard);

        //Home Icon
        img = new ImageIcon("img/dashboard.jpg").getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH);
        JLabel lb_dashboardIcon = new JLabel(new ImageIcon(img));
        lb_dashboardIcon.setBounds(0, 0, 60, 60);
        panel_dashboard.add(lb_dashboardIcon);

        // Home Label
        JLabel lb_dashboard = new JLabel("Dashboard");
        lb_dashboard.setBounds(70, 0, 190, 60);
        lb_dashboard.setFont(sidebarMenuFont);
        panel_dashboard.add(lb_dashboard);

        //<<<<< Search Book >>>>>>
        panel_search = new JPanel();
        panel_search.setBounds(20, 325, 260, 60);
        panel_search.setBackground(sidebarItemColor);
        panel_search.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        panel_search.setLayout(null);
        panel_sidebar.add(panel_search);
        panel_search.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                dispose();
                new SearchBook();
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                panel_search.setBackground(sidebarHoverColor);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                panel_search.setBackground(sidebarItemColor);
            }
        });

        //Search Book Icon
        img = new ImageIcon("img/book-search.png").getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH);
        JLabel lb_menuIcon = new JLabel(new ImageIcon(img));
        lb_menuIcon.setBounds(0, 0, 60, 60);
        panel_search.add(lb_menuIcon);

        // Search Book Label
        JLabel lb_menu = new JLabel("Search Book");
        lb_menu.setBounds(70, 0, 190, 60);
        lb_menu.setFont(sidebarMenuFont);
        panel_search.add(lb_menu);

        //<<<<< User Info >>>>>>
        panel_userInfo = new JPanel();
        panel_userInfo.setBounds(20, 390, 260, 60);
        panel_userInfo.setBackground(sidebarItemColor);
        panel_userInfo.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        panel_userInfo.setLayout(null);
        panel_sidebar.add(panel_userInfo);
        panel_userInfo.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                dispose();
                new UserInfo();
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

        //User Info Icon
        img = new ImageIcon("img/user-info.png").getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH);
        JLabel lb_userInfoIcon = new JLabel(new ImageIcon(img));
        lb_userInfoIcon.setBounds(0, 0, 60, 60);
        panel_userInfo.add(lb_userInfoIcon);

        // User Info Menu
        JLabel lb_userInfo = new JLabel("User Info");
        lb_userInfo.setBounds(70, 0, 190, 60);
        lb_userInfo.setFont(sidebarMenuFont);
        panel_userInfo.add(lb_userInfo);

        //<<<<< Info >>>>>>
        panel_setting = new JPanel();
        panel_setting.setBounds(20, 455, 260, 60);
        panel_setting.setBackground(sidebarItemColor);
        panel_setting.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        panel_setting.setLayout(null);
        panel_sidebar.add(panel_setting);
        panel_setting.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
//                super.mouseClicked(e);
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                panel_setting.setBackground(sidebarHoverColor);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                panel_setting.setBackground(sidebarItemColor);
            }
        });

        //Home Icon
        img = new ImageIcon("img/cog.jpg").getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH);
        JLabel lb_settingIcon = new JLabel(new ImageIcon(img));
        lb_settingIcon.setBounds(0, 0, 60, 60);
        panel_setting.add(lb_settingIcon);

        // Home Menu
        JLabel lb_setting = new JLabel("Setting");
        lb_setting.setBounds(70, 0, 190, 60);
        lb_setting.setFont(sidebarMenuFont);
        panel_setting.add(lb_setting);

//<<<<< Log Out >>>>>>
        panel_logout = new JPanel();
        panel_logout.setBounds(20, 520, 260, 60);
        panel_logout.setBackground(sidebarItemColor);
        panel_logout.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        panel_logout.setLayout(null);
        panel_sidebar.add(panel_logout);
        panel_logout.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                dispose();
                new LoginMenu();
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
        img = new ImageIcon("img/logout.jpg").getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH);
        JLabel lb_logoutIcon = new JLabel(new ImageIcon(img));
        lb_logoutIcon.setBounds(0, 0, 60, 60);
        panel_logout.add(lb_logoutIcon);

        // Home Menu
        JLabel lb_logout = new JLabel("Log Out");
        lb_logout.setBounds(70, 0, 190, 60);
        lb_logout.setFont(sidebarMenuFont);
        panel_logout.add(lb_logout);

//@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@{ Top Title Bar }@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@

        panel_titleBar = new JPanel();
        panel_titleBar.setLayout(null);
        panel_titleBar.setBounds(0, 0, FRAME_WIDTH, 70);
        panel_titleBar.setBackground(topbarColor);
        add(panel_titleBar);

//@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@{ Topbar Title }@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@

        lb_topbarTitle = new JLabel("Dashboard");
        lb_topbarTitle.setBounds(320, 20, 300, 30);
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
        btn_minimize.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
        btn_minimize.setToolTipText("Minimize");
        btn_minimize.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        btn_minimize.setFocusPainted(false);
        btn_minimize.setFont(new Font("Arial", Font.BOLD, 20));
        btn_minimize.addActionListener(this);
        panel_titleBar.add(btn_minimize);
        btn_minimize.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                Dashboard.super.setState(JFrame.ICONIFIED);
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


        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
