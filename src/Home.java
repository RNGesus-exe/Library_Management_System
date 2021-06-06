import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.RoundRectangle2D;

public class Home extends JFrame implements ActionListener {

    private final int FRAME_WIDTH = 1200;
    private final int FRAME_HEIGHT = 900;
    private final ImageIcon bgIcon = new ImageIcon("img/bg8.jpg");
    private final Font sidebarMenuFont = new Font("Arial", Font.BOLD, 26);


    private JPanel panel_titleBar;
    private JPanel panel_sidebar;
    private JPanel panel_home;
    private JPanel panel_menu;
    private JPanel panel_help;
    private JPanel panel_info;
    private JPanel panel_logout;
    private JLabel lb_topbarTitle;
    private JLabel lb_logo;


    private JButton btn_close;
    private JButton btn_minimize;
    public Home() {
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

//@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@{ Sidebar }@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@

        panel_sidebar = new JPanel();
        panel_sidebar.setLayout(null);
        panel_sidebar.setBackground(Color.decode("#1877EB"));
        panel_sidebar.setBounds(0, 0, 300, 900);
        add(panel_sidebar);

//@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@{ Logo }@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@

        lb_logo = new JLabel("Hello");
        lb_logo.setBounds(50,30,200,200);
        lb_logo.setBackground(Color.BLACK);
        lb_logo.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        panel_sidebar.add(lb_logo);

//@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@{ Sidebar Menu Items }@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@

//<<<<< Home >>>>>>
        panel_home = new JPanel();
        panel_home.setBounds(20,260,260,60);
        panel_home.setBackground(Color.BLUE);
        panel_home.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        panel_home.setLayout(null);
        panel_sidebar.add(panel_home);
        panel_home.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
//                super.mouseClicked(e);
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                panel_home.setBackground(Color.RED);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                panel_home.setBackground(Color.BLUE);
            }
        });

        //Home Icon
        JLabel lb_homeIcon = new JLabel("icon");
        lb_homeIcon.setBounds(0,0,60,60);
        lb_homeIcon.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        panel_home.add(lb_homeIcon);

        // Home Label
        JLabel lb_home = new JLabel("Home");
        lb_home.setBounds(70,0,190, 60);
        lb_home.setBorder(BorderFactory.createLineBorder(Color.black));
        lb_home.setFont(sidebarMenuFont);
        panel_home.add(lb_home);

//<<<<< Menu >>>>>>
        panel_menu = new JPanel();
        panel_menu.setBounds(20,325,260,60);
        panel_menu.setBackground(Color.BLUE);
        panel_menu.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        panel_menu.setLayout(null);
        panel_sidebar.add(panel_menu);
        panel_menu.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
//                super.mouseClicked(e);
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                panel_menu.setBackground(Color.RED);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                panel_menu.setBackground(Color.BLUE);
            }
        });

        //Menu Icon
        JLabel lb_menuIcon = new JLabel("icon");
        lb_menuIcon.setBounds(0,0,60,60);
        lb_menuIcon.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        panel_menu.add(lb_menuIcon);

        // Menu Label
        JLabel lb_menu = new JLabel("Menu");
        lb_menu.setBounds(70,0,190, 60);
        lb_menu.setBorder(BorderFactory.createLineBorder(Color.black));
        lb_menu.setFont(sidebarMenuFont);
        panel_menu.add(lb_menu);

//<<<<< Help >>>>>>
        panel_help = new JPanel();
        panel_help.setBounds(20,390,260,60);
        panel_help.setBackground(Color.BLUE);
        panel_help.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        panel_help.setLayout(null);
        panel_sidebar.add(panel_help);
        panel_help.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
//                super.mouseClicked(e);
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                panel_help.setBackground(Color.RED);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                panel_help.setBackground(Color.BLUE);
            }
        });

        //Home Icon
        JLabel lb_helpIcon = new JLabel("icon");
        lb_helpIcon.setBounds(0,0,60,60);
        lb_helpIcon.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        panel_help.add(lb_helpIcon);

        // Home Menu
        JLabel lb_help = new JLabel("Help");
        lb_help.setBounds(70,0,190, 60);
        lb_help.setBorder(BorderFactory.createLineBorder(Color.black));
        lb_help.setFont(sidebarMenuFont);
        panel_help.add(lb_help);

//<<<<< Info >>>>>>
        panel_info = new JPanel();
        panel_info.setBounds(20,455,260,60);
        panel_info.setBackground(Color.BLUE);
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
                panel_info.setBackground(Color.RED);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                panel_info.setBackground(Color.BLUE);
            }
        });

        //Home Icon
        JLabel lb_infoIcon = new JLabel("icon");
        lb_infoIcon.setBounds(0,0,60,60);
        lb_infoIcon.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        panel_info.add(lb_infoIcon);

        // Home Menu
        JLabel lb_info = new JLabel("Info");
        lb_info.setBounds(70,0,190, 60);
        lb_info.setBorder(BorderFactory.createLineBorder(Color.black));
        lb_info.setFont(sidebarMenuFont);
        panel_info.add(lb_info);

//<<<<< Log Out >>>>>>
        panel_logout = new JPanel();
        panel_logout.setBounds(20,520,260,60);
        panel_logout.setBackground(Color.BLUE);
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
                panel_logout.setBackground(Color.RED);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                panel_logout.setBackground(Color.BLUE);
            }
        });

        //Home Icon
        JLabel lb_logoutIcon = new JLabel("icon");
        lb_logoutIcon.setBounds(0,0,60,60);
        lb_logoutIcon.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        panel_logout.add(lb_logoutIcon);

        // Home Menu
        JLabel lb_logout = new JLabel("Log Out");
        lb_logout.setBounds(70,0,190, 60);
        lb_logout.setBorder(BorderFactory.createLineBorder(Color.black));
        lb_logout.setFont(sidebarMenuFont);
        panel_logout.add(lb_logout);

//@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@{ Top Title Bar }@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@

        panel_titleBar = new JPanel();
        panel_titleBar.setLayout(null);
        panel_titleBar.setBounds(0,0,FRAME_WIDTH,70);
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
                Home.super.setState(JFrame.ICONIFIED);
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
        new Home();
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
