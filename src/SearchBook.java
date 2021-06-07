import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.RoundRectangle2D;

public class SearchBook extends JFrame implements ActionListener {

    private final int FRAME_WIDTH = 1200;
    private final int FRAME_HEIGHT = 900;
    private final ImageIcon bgIcon = new ImageIcon("img/bg8.jpg");
    private final Font sidebarMenuFont = new Font("Arial", Font.BOLD, 26);


    private JPanel panel_titleBar;
    private JPanel panel_sidebar;
    private JPanel panel_body;
    private JPanel panel_home;
    private JPanel panel_search;
    private JPanel panel_help;
    private JPanel panel_info;
    private JPanel panel_logout;
    private JLabel lb_topbarTitle;
    private JLabel lb_logo;


    private JButton btn_close;
    private JButton btn_minimize;

    private Color sidebarItemColor = Color.decode("#1568cf");
    private Color sidebarHoverColor = Color.decode("#085dc4");
    private Color sidebarColor = Color.decode("#1877EB");
    private Color tobarColor = Color.decode("#1877EB");
    private Color dashboardItemColor = Color.decode("#e0dcdc");
    private Color topbarColor = Color.decode("#ede2e1");

    private Image img;

    public SearchBook() {
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

        //<<< Row 1 >>>>
        JPanel panel_issueBook = new JPanel();
        panel_issueBook.setBounds(100,230,200,150);
        panel_issueBook.setBackground(dashboardItemColor);
        panel_issueBook.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        panel_issueBook.setLayout(null);
        panel_body.add(panel_issueBook);

        JLabel lb_issueBook = new JLabel("Issue Book");
        lb_issueBook.setBounds(45,120,120,20);
        lb_issueBook.setFont(new Font("Arial", Font.BOLD, 20));
        panel_issueBook.add(lb_issueBook);


        img = new ImageIcon("img/book-exchange.png").getImage().getScaledInstance(80,80,Image.SCALE_SMOOTH);
        JLabel lb_icon1 = new JLabel(new ImageIcon(img));
        lb_icon1.setBounds(60,20,80,80);
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
        panel_returnBook.setBounds(350,230,200,150);
        panel_returnBook.setBackground(dashboardItemColor);
        panel_returnBook.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        panel_returnBook.setLayout(null);
        panel_body.add(panel_returnBook);

        JLabel lb_returnBook = new JLabel("Return Book");
        lb_returnBook.setBounds(40,120,130,20);
        lb_returnBook.setFont(new Font("Arial", Font.BOLD, 20));
        panel_returnBook.add(lb_returnBook);

        img = new ImageIcon("img/book-return.png").getImage().getScaledInstance(80,80,Image.SCALE_SMOOTH);
        JLabel lb_icon2 = new JLabel(new ImageIcon(img));
        lb_icon2.setBounds(60,20,80,80);
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

        //-------------------------------------------------

        JPanel panel_searchBook = new JPanel();
        panel_searchBook.setBounds(600,230,200,150);
        panel_searchBook.setBackground(dashboardItemColor);
        panel_searchBook.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        panel_searchBook.setLayout(null);
        panel_body.add(panel_searchBook);

        img = new ImageIcon("img/book-search.png").getImage().getScaledInstance(80,80,Image.SCALE_SMOOTH);
        JLabel lb_icon3 = new JLabel(new ImageIcon(img));
        lb_icon3.setBounds(60,20,80,80);
        lb_icon3.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        panel_searchBook.add(lb_icon3);

        JLabel lb_searchBook = new JLabel("Search Book");
        lb_searchBook.setBounds(40,120,130,20);
        lb_searchBook.setFont(new Font("Arial", Font.BOLD, 20));
        panel_searchBook.add(lb_searchBook);

        panel_searchBook.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {
                panel_searchBook.setBackground(sidebarColor);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                panel_searchBook.setBackground(dashboardItemColor);
            }
        });

        //<<< Row 2 >>>>
        JPanel panel_issuedBook = new JPanel();
        panel_issuedBook.setBounds(100,500,200,150);
        panel_issuedBook.setBackground(dashboardItemColor);
        panel_issuedBook.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        panel_issuedBook.setLayout(null);
        panel_body.add(panel_issuedBook);

        img = new ImageIcon("img/book-exchange.png").getImage().getScaledInstance(80,80,Image.SCALE_SMOOTH);
        JLabel lb_icon4 = new JLabel(new ImageIcon(img));
        lb_icon4.setBounds(60,20,80,80);
        lb_icon4.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        panel_issuedBook.add(lb_icon4);

        JLabel lb_issuedBook = new JLabel("Issued Book");
        lb_issuedBook.setBounds(40,120,120,20);
        lb_issuedBook.setFont(new Font("Arial", Font.BOLD, 20));
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

        //-------------------------------------------------

        JPanel panel_levelDetail = new JPanel();
        panel_levelDetail.setBounds(350,500,200,150);
        panel_levelDetail.setBackground(dashboardItemColor);
        panel_levelDetail.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        panel_levelDetail.setLayout(null);
        panel_body.add(panel_levelDetail);

        img = new ImageIcon("img/level.png").getImage().getScaledInstance(80,80,Image.SCALE_SMOOTH);
        JLabel lb_icon5 = new JLabel(new ImageIcon(img));
        lb_icon5.setBounds(60,20,80,80);
        lb_icon5.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        panel_levelDetail.add(lb_icon5);

        JLabel lb_levelDetail = new JLabel("Level Details");
        lb_levelDetail.setBounds(40,120,120,20);
        lb_levelDetail.setFont(new Font("Arial", Font.BOLD, 20));
        panel_levelDetail.add(lb_levelDetail);

        panel_levelDetail.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {
                panel_levelDetail.setBackground(sidebarColor);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                panel_levelDetail.setBackground(dashboardItemColor);
            }
        });

        //-------------------------------------------------

        JPanel panel_extra = new JPanel();
        panel_extra.setBounds(600,500,200,150);
        panel_extra.setBackground(dashboardItemColor);
        panel_extra.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        panel_extra.setLayout(null);
        panel_body.add(panel_extra);

        img = new ImageIcon("img/cog.jpg").getImage().getScaledInstance(80,80,Image.SCALE_SMOOTH);
        JLabel lb_icon6 = new JLabel(new ImageIcon(img));
        lb_icon6.setBounds(60,20,80,80);
        lb_icon6.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        panel_extra.add(lb_icon6);

        JLabel lb_extra = new JLabel("Settings");
        lb_extra.setBounds(40,120,120,20);
        lb_extra.setFont(new Font("Arial", Font.BOLD, 20));
        panel_extra.add(lb_extra);

        panel_extra.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {
                panel_extra.setBackground(sidebarColor);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                panel_extra.setBackground(dashboardItemColor);
            }
        });

//@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@{ Logo }@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@

        img = new ImageIcon("img/books.jpg").getImage().getScaledInstance(200,200,Image.SCALE_SMOOTH);
        lb_logo = new JLabel(new ImageIcon(img));
        lb_logo.setBounds(50,30,200,200);
        lb_logo.setBackground(Color.BLACK);
        lb_logo.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        panel_sidebar.add(lb_logo);

//@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@{ Sidebar Menu Items }@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@

//<<<<< Home >>>>>>
        panel_home = new JPanel();
        panel_home.setBounds(20,260,260,60);
        panel_home.setBackground(sidebarItemColor);
        panel_home.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        panel_home.setLayout(null);
        panel_sidebar.add(panel_home);
        panel_home.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                dispose();
                new Dashboard();
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                panel_home.setBackground(sidebarHoverColor);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                panel_home.setBackground(sidebarItemColor);
            }
        });

        //Home Icon
        img = new ImageIcon("img/dashboard.jpg").getImage().getScaledInstance(50,50,Image.SCALE_SMOOTH);
        JLabel lb_homeIcon = new JLabel(new ImageIcon(img));
        lb_homeIcon.setBounds(0,0,60,60);
        panel_home.add(lb_homeIcon);

        // Home Label
        JLabel lb_home = new JLabel("Dashboard");
        lb_home.setBounds(70,0,190, 60);
        lb_home.setFont(sidebarMenuFont);
        panel_home.add(lb_home);

//<<<<< Menu >>>>>>
        panel_search = new JPanel();
        panel_search.setBounds(20,325,260,60);
        panel_search.setBackground(sidebarItemColor);
        panel_search.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        panel_search.setLayout(null);
        panel_sidebar.add(panel_search);
        panel_search.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
//                super.mouseClicked(e);
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

        //Menu Icon
        img = new ImageIcon("img/menu.png").getImage().getScaledInstance(50,50,Image.SCALE_SMOOTH);
        JLabel lb_menuIcon = new JLabel(new ImageIcon(img));
        lb_menuIcon.setBounds(0,0,60,60);
        panel_search.add(lb_menuIcon);

        // Menu Label
        JLabel lb_menu = new JLabel("Menu");
        lb_menu.setBounds(70,0,190, 60);
        lb_menu.setFont(sidebarMenuFont);
        panel_search.add(lb_menu);

//<<<<< Help >>>>>>
        panel_help = new JPanel();
        panel_help.setBounds(20,390,260,60);
        panel_help.setBackground(sidebarItemColor);
        panel_help.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        panel_help.setLayout(null);
        panel_sidebar.add(panel_help);
        panel_help.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {
                panel_help.setBackground(sidebarHoverColor);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                panel_help.setBackground(sidebarItemColor);
            }
        });

        //Home Icon
        img = new ImageIcon("img/help.jpg").getImage().getScaledInstance(50,50,Image.SCALE_SMOOTH);
        JLabel lb_helpIcon = new JLabel(new ImageIcon(img));
        lb_helpIcon.setBounds(0,0,60,60);
        panel_help.add(lb_helpIcon);

        // Home Menu
        JLabel lb_help = new JLabel("Help");
        lb_help.setBounds(70,0,190, 60);
        lb_help.setFont(sidebarMenuFont);
        panel_help.add(lb_help);

//<<<<< Info >>>>>>
        panel_info = new JPanel();
        panel_info.setBounds(20,455,260,60);
        panel_info.setBackground(sidebarItemColor);
        panel_info.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        panel_info.setLayout(null);
        panel_sidebar.add(panel_info);
        panel_info.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
//                super.mouseClicked(e);
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                panel_info.setBackground(sidebarHoverColor);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                panel_info.setBackground(sidebarItemColor);
            }
        });

        //Home Icon
        img = new ImageIcon("img/info.png").getImage().getScaledInstance(50,50,Image.SCALE_SMOOTH);
        JLabel lb_infoIcon = new JLabel(new ImageIcon(img));
        lb_infoIcon.setBounds(0,0,60,60);
        panel_info.add(lb_infoIcon);

        // Home Menu
        JLabel lb_info = new JLabel("Information");
        lb_info.setBounds(70,0,190, 60);
        lb_info.setFont(sidebarMenuFont);
        panel_info.add(lb_info);

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
//                super.mouseClicked(e);
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

        lb_topbarTitle = new JLabel("Dashboard");
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
                SearchBook.super.setState(JFrame.ICONIFIED);
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

    public static void main(String[] args) {
        new Dashboard();
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
