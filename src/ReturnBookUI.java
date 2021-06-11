import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.RoundRectangle2D;
import java.util.ArrayList;

public class ReturnBookUI extends JFrame implements ActionListener {

    private final int FRAME_WIDTH = 1200;
    private final int FRAME_HEIGHT = 900;
    private final Font sidebarMenuFont = new Font("Arial", Font.BOLD, 26);

    private DefaultTableModel tableModel = new DefaultTableModel();
    private JTable table = null;

    private ArrayList<Book> books = null;

    private JTextField txt_releaseDate = null;
    private JTextField txt_rating = null;
    private JTextField txt_pages = null;
    private JTextField txt_genre = null;
    private JTextField txt_author = null;
    private JTextField txt_title = null;

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

    private JButton btn_returnBook;

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

    public ReturnBookUI() {
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

//@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@{ Body Panel }@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@

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
                new DashboardUI();
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

        //<<<<< Search >>>>>>
        panel_search = new JPanel();
        panel_search.setBounds(20,325,260,60);
        panel_search.setBackground(sidebarItemColor);
        panel_search.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        panel_search.setLayout(null);
        panel_sidebar.add(panel_search);
        panel_search.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                dispose();
                new SearchBookUI();
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

        //Search Icon
        img = new ImageIcon("img/book-search.png").getImage().getScaledInstance(50,50,Image.SCALE_SMOOTH);
        JLabel lb_searchIcon = new JLabel(new ImageIcon(img));
        lb_searchIcon.setBounds(0,0,60,60);
        panel_search.add(lb_searchIcon);

        // Search Label
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
                new UserInfoUI();
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
                dispose();
                new ResetPasswordUI();
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

        lb_topbarTitle = new JLabel("Return Books");
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
                ReturnBookUI.super.setState(JFrame.ICONIFIED);
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

//@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@{ Issued Books }@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@

        JPanel panel_issuedBooks = new JPanel(new BorderLayout());
        panel_issuedBooks.setBounds(50,80,800,500);
        panel_issuedBooks.setBackground(Color.lightGray);
        panel_body.add(panel_issuedBooks);

        JLabel lb_issueDetail = new JLabel("Issued Book Details");
        lb_issueDetail.setBounds(50,50,250,20);
        lb_issueDetail.setFont(new Font("Arial",Font.BOLD,24));
        lb_issueDetail.setForeground(Color.RED);
        panel_body.add(lb_issueDetail);

        table = new JTable();
        table.setFont(new Font("Arial",Font.PLAIN,20));
        table.setModel(tableModel);
        table.setRowHeight(30);
        table.getTableHeader().setResizingAllowed(false);
        table.getTableHeader().setFont(new Font("Arial",Font.BOLD,20));

        Object[] columns1 = {"Issue Date","Book Title","Due Date"};
        tableModel.setColumnIdentifiers(columns1);

        Object[] row = {"2021-06-10","Harry Potter","2021-06-15"};
        tableModel.addRow(row);
        tableModel.addRow(row);
        tableModel.addRow(row);
        tableModel.addRow(row);
        tableModel.addRow(row);
        tableModel.addRow(row);
        tableModel.addRow(row);


        panel_issuedBooks.add(new JScrollPane(table));

//@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@{ Issued Books }@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@

        btn_returnBook = new JButton("Return Book");
        btn_returnBook.setBounds(700, 600, 150, 35);
        btn_returnBook.setFocusPainted(false);
        btn_returnBook.setBackground(Color.decode("#1877EB"));
        btn_returnBook.setForeground(Color.white);
        btn_returnBook.setFont(new Font("Arial", Font.BOLD, 16));
        btn_returnBook.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        btn_returnBook.addActionListener(this);
        panel_body.add(btn_returnBook);
        btn_returnBook.addMouseListener(new MouseAdapter() {   // Button get highlighted when Cursor hover over Login Button
            public void mouseEntered(MouseEvent e) {
                btn_returnBook.setBackground(Color.decode("#1262c4"));
            }

            public void mouseExited(MouseEvent e) {
                btn_returnBook.setBackground(Color.decode("#1877EB"));
            }
        });
        

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==btn_returnBook){

            if(table.getSelectedRow()==-1){
                JOptionPane.showMessageDialog(null,"No Book Selected! Please select Book which you want to return","Error",JOptionPane.ERROR_MESSAGE);
            }
            else{

                System.out.println("Issue Date : "+(tableModel.getValueAt(table.getSelectedRow(),0)));
                System.out.println("Book Title : "+(tableModel.getValueAt(table.getSelectedRow(),1)));
                System.out.println("Due Date : "+(tableModel.getValueAt(table.getSelectedRow(),2)));
            }
        }
    }


    public static void main(String[] args) {
        new ReturnBookUI();
    }
}
