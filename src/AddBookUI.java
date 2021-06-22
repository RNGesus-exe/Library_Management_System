import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.RoundRectangle2D;
import java.io.IOException;
import java.sql.SQLException;

public class AddBookUI extends JFrame implements ActionListener {

    private final int FRAME_WIDTH = 1200;
    private final int FRAME_HEIGHT = 900;
    private final Font sidebarMenuFont = new Font("Arial", Font.BOLD, 26);

    private JTextField txt_releaseDate = null;
    private JTextField txt_rating = null;
    private JTextField txt_pages = null;
    private JTextField txt_genre = null;
    private JTextField txt_author = null;
    private JTextField txt_title = null;


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

    public AddBookUI() {
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

        lb_topbarTitle = new JLabel("Add New Book");
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
                AddBookUI.super.setState(JFrame.ICONIFIED);
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

//@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@{ Book Information }@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@

        JPanel panel_bookDetails = new JPanel();
        panel_bookDetails.setBounds(50,90,800,435);
        panel_bookDetails.setBackground(dashboardItemColor);
        panel_bookDetails.setLayout(null);
        panel_body.add(panel_bookDetails);


        JLabel lb_bookDetail = new JLabel("Book Details");
        lb_bookDetail.setBounds(300,20,200,32);
        lb_bookDetail.setFont(new Font("Arial",Font.BOLD,30));
//        panel_bookDetails.add(lb_bookDetail);

        //<<<<<<( Book Details )>>>>>>>>

        //<<<<<< Book Title >>>>>>>
        JLabel lb_title = new JLabel("Book Title");
        lb_title.setBounds(50,70,150,25);
        lb_title.setFont(labelFonts);
        lb_title.setForeground(Color.red);
        panel_bookDetails.add(lb_title);

        txt_title = new JTextField();
        txt_title.setBounds(270,65,480,30);
        txt_title.setFont(textFieldFont);
        panel_bookDetails.add(txt_title);

        //<<<<<< Author >>>>>>>
        JLabel lb_author = new JLabel("Author Name");
        lb_author.setBounds(50,120,200,25);
        lb_author.setFont(labelFonts);
        lb_author.setForeground(Color.red);
        panel_bookDetails.add(lb_author);

        txt_author = new JTextField();
        txt_author.setBounds(270,115,480,30);
        txt_author.setFont(textFieldFont);
        panel_bookDetails.add(txt_author);


        //<<<<<< Genre >>>>>>>
        JLabel lb_genre = new JLabel("Genre");
        lb_genre.setBounds(50,170,200,25);
        lb_genre.setFont(labelFonts);
        lb_genre.setForeground(Color.red);
        panel_bookDetails.add(lb_genre);

        txt_genre = new JTextField();
        txt_genre.setBounds(270,165,480,30);
        txt_genre.setFont(textFieldFont);
        panel_bookDetails.add(txt_genre);

        //<<<<<< Pages >>>>>>>
        JLabel lb_pages = new JLabel("No. Of Copies");
        lb_pages.setBounds(50,220,200,25);
        lb_pages.setFont(labelFonts);
        lb_pages.setForeground(Color.red);
        panel_bookDetails.add(lb_pages);

        txt_pages = new JTextField();
        txt_pages.setBounds(270,215,480,30);
        txt_pages.setFont(textFieldFont);
        panel_bookDetails.add(txt_pages);

        //<<<<<< Rating >>>>>>>
        JLabel lb_rating = new JLabel("Rating");
        lb_rating.setBounds(50,270,200,25);
        lb_rating.setFont(labelFonts);
        lb_rating.setForeground(Color.red);
        panel_bookDetails.add(lb_rating);

        txt_rating = new JTextField();
        txt_rating.setBounds(270,265,480,30);
        txt_rating.setFont(textFieldFont);
        panel_bookDetails.add(txt_rating);

        //<<<<<< Release Date >>>>>>>
        JLabel lb_releaseDate = new JLabel("Date of Release");
        lb_releaseDate.setBounds(50,320,150,25);
        lb_releaseDate.setFont(labelFonts);
        lb_releaseDate.setForeground(Color.red);
        panel_bookDetails.add(lb_releaseDate);

        txt_releaseDate = new JTextField();
        txt_releaseDate.setBounds(270,315,480,30);
        txt_releaseDate.setFont(textFieldFont);
        panel_bookDetails.add(txt_releaseDate);


        JButton btn_add = new JButton("Add Book");
        btn_add.setBounds(630,385,150,35);
        btn_add.setFocusPainted(false);
        btn_add.setBackground(Color.decode("#31ad50"));
        btn_add.setForeground(Color.white);
        btn_add.setFont(new Font("Arial", Font.BOLD, 16));
        btn_add.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        btn_add.addActionListener(this);
        panel_bookDetails.add(btn_add);
        btn_add.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if(txt_title.getText().isEmpty() || txt_author.getText().isEmpty() || txt_genre.getText().isEmpty() || txt_pages.getText().isEmpty()){
                    JOptionPane.showMessageDialog(null,"Please fill all the fields","Error",JOptionPane.ERROR_MESSAGE);
                }else if(txt_releaseDate.getText().length()>4 || Integer.parseInt(txt_releaseDate.getText())>2021){
                    JOptionPane.showMessageDialog(null,"Invalid Entry! Please enter valid Release Year","Invalid Entry",JOptionPane.ERROR_MESSAGE);
                }else{

                    try {
                        Book book = new Book();
                        book.setTitle(txt_title.getText().trim());
                        book.setAuthor(txt_author.getText().trim());
                        book.setGenre(txt_genre.getText().trim());
                        book.setNoOfCopies(Integer.parseInt(txt_pages.getText().trim()));
                        book.setRating(Float.parseFloat(txt_rating.getText().trim()));
                        book.setDateOfRelease(txt_releaseDate.getText().trim());

                        Driver.dataAgent.addBook(book);
                        dispose();
                        new BookManagementUI();
                        JOptionPane.showMessageDialog(null,"New Book added sucessfully","Information",JOptionPane.INFORMATION_MESSAGE);

                        new BookManagementUI();
                    } catch (IOException throwables) {
                        throwables.printStackTrace();
                    }

                }
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                btn_add.setBackground(Color.decode("#227d39"));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                btn_add.setBackground(Color.decode("#31ad50"));
            }
        });


        JButton btn_cancel = new JButton("Cancel");
        btn_cancel.setBounds(520,385,100,35);
        btn_cancel.setFocusPainted(false);
        btn_cancel.setBackground(Color.decode("#1877EB"));
        btn_cancel.setForeground(Color.white);
        btn_cancel.setFont(new Font("Arial", Font.BOLD, 16));
        btn_cancel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        btn_cancel.addActionListener(this);
        panel_bookDetails.add(btn_cancel);
        btn_cancel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                JOptionPane.showMessageDialog(null,"Attention! Your all entered data will be discarded.","Message",JOptionPane.INFORMATION_MESSAGE);
                dispose();
                new BookManagementUI();
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                btn_cancel.setBackground(Color.decode("#cc0606"));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                btn_cancel.setBackground(Color.decode("#fc0303"));
            }
        });

        setVisible(true);
    }


    @Override
    public void actionPerformed(ActionEvent e) {

    }

    public static void main(String[] args) {
        new AddBookUI();
    }
}
