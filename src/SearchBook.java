import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.RoundRectangle2D;

public class SearchBook extends JFrame implements ActionListener {

    private final int FRAME_WIDTH = 1200;
    private final int FRAME_HEIGHT = 900;
    private final Font sidebarMenuFont = new Font("Arial", Font.BOLD, 26);


    private JPanel panel_titleBar;
    private JPanel panel_sidebar;
    private JPanel panel_body;
    private JPanel panel_dashboard;
    private JPanel panel_search;
    private JPanel panel_userinfo;
    private JPanel panel_setting;
    private JPanel panel_logout;
    private JLabel lb_topbarTitle;
    private JLabel lb_logo;

    private JButton btn_search;

    private JTextField txt_search;


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

        txt_search = new JTextField();
        txt_search.setBounds(50,50,800,35);
        txt_search.setFont(new Font("Arial",Font.PLAIN,20));
        txt_search.setUI(new HintTextFieldUI("Search Book...",true));
        panel_body.add(txt_search);

        btn_search = new JButton("Search");
        btn_search.setBounds(730, 100, 120, 35);
        btn_search.setFocusPainted(false);
        btn_search.setBackground(Color.decode("#1877EB"));
        btn_search.setForeground(Color.white);
        btn_search.setFont(new Font("Arial", Font.BOLD, 16));
        btn_search.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        btn_search.addActionListener(this);
        panel_body.add(btn_search);
        btn_search.addMouseListener(new MouseAdapter() {   // Button get highlighted when Cursor hover over Login Button
            public void mouseEntered(MouseEvent e) {
                btn_search.setBackground(Color.decode("#1262c4"));
            }

            public void mouseExited(MouseEvent e) {
                btn_search.setBackground(Color.decode("#1877EB"));
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
        panel_dashboard = new JPanel();
        panel_dashboard.setBounds(20,260,260,60);
        panel_dashboard.setBackground(sidebarItemColor);
        panel_dashboard.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        panel_dashboard.setLayout(null);
        panel_sidebar.add(panel_dashboard);
        panel_dashboard.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                dispose();
                new Dashboard();
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                panel_dashboard.setBackground(sidebarHoverColor);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                panel_dashboard.setBackground(sidebarItemColor);
            }
        });

        //Home Icon
        img = new ImageIcon("img/dashboard.jpg").getImage().getScaledInstance(50,50,Image.SCALE_SMOOTH);
        JLabel lb_homeIcon = new JLabel(new ImageIcon(img));
        lb_homeIcon.setBounds(0,0,60,60);
        panel_dashboard.add(lb_homeIcon);

        // Home Label
        JLabel lb_home = new JLabel("Dashboard");
        lb_home.setBounds(70,0,190, 60);
        lb_home.setFont(sidebarMenuFont);
        panel_dashboard.add(lb_home);

//<<<<< Menu >>>>>>
        panel_search = new JPanel();
        panel_search.setBounds(20,325,260,60);
        panel_search.setBackground(sidebarHoverColor);
        panel_search.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        panel_search.setLayout(null);
        panel_sidebar.add(panel_search);

        //Menu Icon
        img = new ImageIcon("img/book-search.png").getImage().getScaledInstance(50,50,Image.SCALE_SMOOTH);
        JLabel lb_searchIcon = new JLabel(new ImageIcon(img));
        lb_searchIcon.setBounds(0,0,60,60);
        panel_search.add(lb_searchIcon);

        // Menu Label
        JLabel lb_searchBook = new JLabel("Search Book");
        lb_searchBook.setBounds(70,0,190, 60);
        lb_searchBook.setFont(sidebarMenuFont);
        panel_search.add(lb_searchBook);

//<<<<< User Info >>>>>>
        panel_userinfo = new JPanel();
        panel_userinfo.setBounds(20,390,260,60);
        panel_userinfo.setBackground(sidebarItemColor);
        panel_userinfo.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        panel_userinfo.setLayout(null);
        panel_sidebar.add(panel_userinfo);
        panel_userinfo.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                dispose();
                new UserInfo();
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                panel_userinfo.setBackground(sidebarHoverColor);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                panel_userinfo.setBackground(sidebarItemColor);
            }
        });

        //Home Icon
        img = new ImageIcon("img/user-info.png").getImage().getScaledInstance(50,50,Image.SCALE_SMOOTH);
        JLabel lb_infoIcon = new JLabel(new ImageIcon(img));
        lb_infoIcon.setBounds(0,0,60,60);
        panel_userinfo.add(lb_infoIcon);

        // Home Menu
        JLabel lb_userInfo = new JLabel("User Info");
        lb_userInfo.setBounds(70,0,190, 60);
        lb_userInfo.setFont(sidebarMenuFont);
        panel_userinfo.add(lb_userInfo);

//<<<<< Settings >>>>>>
        panel_setting = new JPanel();
        panel_setting.setBounds(20,455,260,60);
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
        img = new ImageIcon("img/cog.jpg").getImage().getScaledInstance(50,50,Image.SCALE_SMOOTH);
        JLabel lb_settingIcon = new JLabel(new ImageIcon(img));
        lb_settingIcon.setBounds(0,0,60,60);
        panel_setting.add(lb_settingIcon);

        // Home Menu
        JLabel lb_setting = new JLabel("Setting");
        lb_setting.setBounds(70,0,190, 60);
        lb_setting.setFont(sidebarMenuFont);
        panel_setting.add(lb_setting);

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

        lb_topbarTitle = new JLabel("Search Books");
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

//@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@{ Search Area }@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@

        JPanel panel_resultArea = new JPanel(new BorderLayout());
        panel_resultArea.setBounds(50,150,800,200);
        panel_resultArea.setBackground(Color.lightGray);
        panel_body.add(panel_resultArea);

        DefaultListModel<String> listModel = new DefaultListModel<>();
        listModel.addElement("Item1");
        listModel.addElement("Item2");
        listModel.addElement("Item3");
        listModel.addElement("Item4");
        listModel.addElement("Item5");
        listModel.addElement("Item1");
        listModel.addElement("Item2");
        listModel.addElement("Item3");
        listModel.addElement("Item4");
        listModel.addElement("Item5");
        listModel.addElement("Item5");
        listModel.addElement("Item1");
        listModel.addElement("Item2");
        listModel.addElement("Item3");
        listModel.addElement("Item4");
        listModel.addElement("Item5");




        JList list = new JList(listModel);
//        list.setFixedCellWidth(100);
        list.setFixedCellHeight(30);
        list.setFont(new Font("Arial",Font.PLAIN,20));
        panel_resultArea.add(new JScrollPane(list));
        list.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                System.out.println(list.getSelectedValue());
                showBookDetail(list.getSelectedValue().toString());
            }
        });



//@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@{ Book Information }@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@

        JPanel panel_bookDetails = new JPanel();
        panel_bookDetails.setBounds(50,380,800,400);
        panel_bookDetails.setBackground(dashboardItemColor);
        panel_bookDetails.setLayout(null);
        panel_body.add(panel_bookDetails);


        JLabel lb_bookDetail = new JLabel("Book Details");
        lb_bookDetail.setBounds(300,20,200,32);
        lb_bookDetail.setFont(new Font("Arial",Font.BOLD,30));
        panel_bookDetails.add(lb_bookDetail);

    //<<<<<< Details >>>>>>>>

        JLabel lb_title = new JLabel("Book Title");
        lb_title.setBounds(100,100,200,25);
        lb_title.setFont(labelFonts);
        lb_title.setForeground(Color.red);
        panel_bookDetails.add(lb_title);

        JLabel lb_author = new JLabel("Author Name");
        lb_author.setBounds(100,150,200,25);
        lb_author.setFont(labelFonts);
        lb_author.setForeground(Color.red);
        panel_bookDetails.add(lb_author);

        JLabel lb_genre = new JLabel("Genre");
        lb_genre.setBounds(100,200,200,25);
        lb_genre.setFont(labelFonts);
        lb_genre.setForeground(Color.red);
        panel_bookDetails.add(lb_genre);

        JLabel lb_pages = new JLabel("No. Of Pages");
        lb_pages.setBounds(100,250,200,25);
        lb_pages.setFont(labelFonts);
        lb_pages.setForeground(Color.red);
        panel_bookDetails.add(lb_pages);

        JLabel lb_rating = new JLabel("Rating");
        lb_rating.setBounds(100,300,200,25);
        lb_rating.setFont(labelFonts);
        lb_rating.setForeground(Color.red);
        panel_bookDetails.add(lb_rating);

        JLabel lb_releaseDate = new JLabel("Book Title");
        lb_releaseDate.setBounds(100,350,200,25);
        lb_releaseDate.setFont(labelFonts);
        lb_releaseDate.setForeground(Color.red);
        panel_bookDetails.add(lb_releaseDate);

    //<<<<<< Data Fetch From Database >>>>>>>>

        JTextField txt_title = new JTextField();
        txt_title.setBounds(400,95,300,30);
        txt_title.setEditable(false);
        panel_bookDetails.add(txt_title);

        JTextField txt_author = new JTextField();
        txt_author.setBounds(400,145,300,30);
        txt_author.setEditable(false);
        panel_bookDetails.add(txt_author);

        JTextField txt_genre = new JTextField();
        txt_genre.setBounds(400,195,300,30);
        txt_genre.setEditable(false);
        panel_bookDetails.add(txt_genre);

        JTextField txt_pages = new JTextField();
        txt_pages.setBounds(400,245,300,30);
        txt_pages.setEditable(false);
        panel_bookDetails.add(txt_pages);

        JTextField txt_rating = new JTextField();
        txt_rating.setBounds(400,295,300,30);
        txt_rating.setEditable(false);
        panel_bookDetails.add(txt_rating);

        JTextField txt_releaseDate = new JTextField();
        txt_releaseDate.setBounds(400,345,300,30);
        txt_releaseDate.setEditable(false);
        panel_bookDetails.add(txt_releaseDate);


//        title,author,genre,pages,rating,releaseDate

        setVisible(true);
    }

    public static void main(String[] args) {
        new SearchBook();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==btn_search){
            if(txt_search.getText().matches("(?=.*[~!@#$%^&*()_-]).*"))
            {
                JOptionPane.showMessageDialog(null,"Invalid Keyword Search","Invalid Search",JOptionPane.ERROR_MESSAGE);
            }
            else
            {
                // Fetch all the Books which matches the searched keyword
            }
        }
    }

    public void showBookDetail(String bookTitle){
        // Selected Book Details from List of search results will be set in TextFields here
    }
}
