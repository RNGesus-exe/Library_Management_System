
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.RoundRectangle2D;
import java.sql.SQLException;
import java.util.ArrayList;

public class BookManagementUI extends JFrame implements ActionListener {

    private final int FRAME_WIDTH = 1200;
    private final int FRAME_HEIGHT = 900;
    private final Font sidebarMenuFont = new Font("Arial", Font.BOLD, 26);
    private final Font textFieldFont = new Font("Arial",Font.PLAIN,18);

    private DefaultListModel<String> listModel = new DefaultListModel<>();
    private JList list = null;

    private ArrayList<Book> books = null;

    private JComboBox cmbx_searchFilter;
    public static String[] filters = {"Search by Title","Search by Author Name","Search by Genre","Search by Year of Release","Search by Rating"};

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
    private JPanel panel_bookLogs;
    private JPanel panel_userInfo;
    private JPanel panel_logout;
    private JLabel lb_topbarTitle;
    private JLabel lb_logo;

    private JButton btn_search;
    private JButton btn_issueBook;

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

    private DefaultTableModel tableModel = new DefaultTableModel();
    private JTable table;
    public ArrayList<User> users = null;

    private Image img;

    public BookManagementUI() {
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
        //new SiderBar().getpanel();
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
        btn_search.setBackground(Color.decode("#32a852"));
        btn_search.setForeground(Color.white);
        btn_search.setFont(new Font("Arial", Font.BOLD, 16));
        btn_search.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        btn_search.addActionListener(this);
        panel_body.add(btn_search);
        btn_search.addMouseListener(new MouseAdapter() {   // Button get highlighted when Cursor hover over Login Button
            public void mouseEntered(MouseEvent e) {
                btn_search.setBackground(Color.decode("#198035"));
            }

            public void mouseExited(MouseEvent e) {
                btn_search.setBackground(Color.decode("#32a852"));
            }
        });

        cmbx_searchFilter = new JComboBox(filters);
        cmbx_searchFilter.setBounds(50, 100, 200, 35);
        cmbx_searchFilter.setFont(new Font("Arial",Font.PLAIN,16));
        panel_body.add(cmbx_searchFilter);


        JButton btn_addBook = new JButton("Add Book");
        btn_addBook.setBounds(730,700,120,35);
        btn_addBook.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        btn_addBook.setBackground(Color.decode("#03a9fc"));
        btn_addBook.setForeground(Color.white);
        btn_addBook.setFont(new Font("Arial", Font.BOLD, 16));
        btn_addBook.setFocusPainted(false);
        panel_body.add(btn_addBook);
        btn_addBook.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                // EditUserUI
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                btn_addBook.setBackground(Color.decode("#0484c4"));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                btn_addBook.setBackground(Color.decode("#03a9fc"));
            }
        });

        JButton btn_deleteBook = new JButton("Delete Book");
        btn_deleteBook.setBounds(570,700,130,35);
        btn_deleteBook.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        btn_deleteBook.setBackground(Color.decode("#ff0000"));
        btn_deleteBook.setForeground(Color.white);
        btn_deleteBook.setFont(new Font("Arial", Font.BOLD, 16));
        btn_deleteBook.setFocusPainted(false);
        panel_body.add(btn_deleteBook);
        btn_deleteBook.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if(table.getSelectedRow()==-1){
                    JOptionPane.showMessageDialog(null,"No user selected! Please select a user from table to delete it","Error",JOptionPane.ERROR_MESSAGE);
                }else{
                    try {

                        Driver.dataAgent.removeUser((Integer) table.getValueAt(table.getSelectedRow(),0));
                        dispose();
                        new BookManagementUI();
                        JOptionPane.showMessageDialog(null,"User deleted successfully","User Deletion",JOptionPane.INFORMATION_MESSAGE);

                    } catch (SQLException throwables) {
                        throwables.printStackTrace();
                    }
                }
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                btn_deleteBook.setBackground(Color.decode("#d10404"));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                btn_deleteBook.setBackground(Color.decode("#ff0000"));
            }
        });


        JButton btn_editBook = new JButton("Edit Book");
        btn_editBook.setBounds(410,700,130,35);
        btn_editBook.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        btn_editBook.setBackground(Color.decode("#32a852"));
        btn_editBook.setForeground(Color.white);
        btn_editBook.setFont(new Font("Arial", Font.BOLD, 16));
        btn_editBook.setFocusPainted(false);
        panel_body.add(btn_editBook);
        btn_editBook.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if(table.getSelectedRow()==-1){
                    JOptionPane.showMessageDialog(null,"No user selected! Please select a user from table to delete it","Error",JOptionPane.ERROR_MESSAGE);
                }else{
                    try {

                        Driver.dataAgent.removeUser((Integer) table.getValueAt(table.getSelectedRow(),0));
                        dispose();
                        new BookManagementUI();
                        JOptionPane.showMessageDialog(null,"User deleted successfully","User Deletion",JOptionPane.INFORMATION_MESSAGE);

                    } catch (SQLException throwables) {
                        throwables.printStackTrace();
                    }
                }
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                btn_editBook.setBackground(Color.decode("#1d8c3b"));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                btn_editBook.setBackground(Color.decode("#32a852"));
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

        img = new ImageIcon("img/users.jpg").getImage().getScaledInstance(50,50,Image.SCALE_SMOOTH);
        JLabel lb_homeIcon = new JLabel(new ImageIcon(img));
        lb_homeIcon.setBounds(0,0,60,60);
        panel_issueBook.add(lb_homeIcon);

        JLabel lb_home = new JLabel("Manage Users");
        lb_home.setBounds(70,0,190, 60);
        lb_home.setFont(sidebarMenuFont);
        panel_issueBook.add(lb_home);

//<<<<< Manage Books >>>>>>
        panel_returnBook = new JPanel();
        panel_returnBook.setBounds(20,325,260,60);
        panel_returnBook.setBackground(sidebarHoverColor);
        panel_returnBook.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        panel_returnBook.setLayout(null);
        panel_sidebar.add(panel_returnBook);


        img = new ImageIcon("img/books.jpg").getImage().getScaledInstance(50,50,Image.SCALE_SMOOTH);
        JLabel lb_returnBookIcon = new JLabel(new ImageIcon(img));
        lb_returnBookIcon.setBounds(0,0,60,60);
        panel_returnBook.add(lb_returnBookIcon);

        JLabel lb_returnBook = new JLabel("Manage Books");
        lb_returnBook.setBounds(70,0,190, 60);
        lb_returnBook.setFont(sidebarMenuFont);
        panel_returnBook.add(lb_returnBook);

//<<<<< Log Out >>>>>>
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
                new LoginUI();
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


        img = new ImageIcon("img/logout.jpg").getImage().getScaledInstance(50,50,Image.SCALE_SMOOTH);
        JLabel lb_bookLogsIcon = new JLabel(new ImageIcon(img));
        lb_bookLogsIcon.setBounds(0,0,60,60);
        panel_bookLogs.add(lb_bookLogsIcon);


        JLabel lb_bookLogs = new JLabel("Log Out");
        lb_bookLogs.setBounds(70,0,190, 60);
        lb_bookLogs.setFont(sidebarMenuFont);
        panel_bookLogs.add(lb_bookLogs);


//@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@{ Top Title Bar }@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@

        panel_titleBar = new JPanel();
        panel_titleBar.setLayout(null);
        panel_titleBar.setBounds(0,0,FRAME_WIDTH,70);
        panel_titleBar.setBackground(topbarColor);
        add(panel_titleBar);

//@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@{ Topbar Title }@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@

        lb_topbarTitle = new JLabel("Manage Books");
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
                BookManagementUI.super.setState(JFrame.ICONIFIED);
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
        panel_resultArea.setBounds(50,150,800,500);
        panel_resultArea.setBackground(Color.lightGray);
        panel_body.add(panel_resultArea);

        table = new JTable();
        table.setFont(new Font("Arial",Font.PLAIN,20));
        table.setModel(tableModel);
        table.setRowHeight(30);
        table.getTableHeader().setResizingAllowed(false);
        table.getTableHeader().setFont(new Font("Arial",Font.BOLD,20));

        Object[] columnsNames = {"ISBN","Title","Author","Genre","Rating","Date of Release"};
        tableModel.setColumnIdentifiers(columnsNames);

        /*try{

            users = Driver.dataAgent.getAllUsers();

            if(users!=null){
                for (User user : users){
                    tableModel.addRow(user.getUserObject());
                }
            }


        } catch(SQLException e){
            e.printStackTrace();
        }*/

        panel_resultArea.add(new JScrollPane(table));


//@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@{ Book Information }@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@

        JPanel panel_bookDetails = new JPanel();
        panel_bookDetails.setBounds(50,370,800,420);
        panel_bookDetails.setBackground(dashboardItemColor);
        panel_bookDetails.setLayout(null);
//        panel_body.add(panel_bookDetails);


        JLabel lb_bookDetail = new JLabel("Book Details");
        lb_bookDetail.setBounds(300,20,200,32);
        lb_bookDetail.setFont(new Font("Arial",Font.BOLD,30));
        panel_bookDetails.add(lb_bookDetail);

        //<<<<<<( Book Details )>>>>>>>>

        //<<<<<< Book Title >>>>>>>
        JLabel lb_title = new JLabel("Book Title");
        lb_title.setBounds(50,70,150,25);
        lb_title.setFont(labelFonts);
        lb_title.setForeground(Color.red);
        panel_bookDetails.add(lb_title);

        txt_title = new JTextField();
        txt_title.setBounds(270,65,480,30);
        txt_title.setEditable(false);
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
        txt_author.setEditable(false);
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
        txt_genre.setEditable(false);
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
        txt_pages.setEditable(false);
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
        txt_rating.setEditable(false);
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
        txt_releaseDate.setEditable(false);
        txt_releaseDate.setFont(textFieldFont);
        panel_bookDetails.add(txt_releaseDate);


        btn_issueBook = new JButton("Issue Book");
        btn_issueBook.setBounds(665, 375, 120, 35);
        btn_issueBook.setFocusPainted(false);
        btn_issueBook.setBackground(Color.decode("#1877EB"));
        btn_issueBook.setForeground(Color.white);
        btn_issueBook.setFont(new Font("Arial", Font.BOLD, 16));
        btn_issueBook.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        btn_issueBook.addActionListener(this);
        panel_bookDetails.add(btn_issueBook);
        btn_issueBook.addMouseListener(new MouseAdapter() {   // Button get highlighted when Cursor hover over Login Button
            public void mouseClicked(MouseEvent e) {
                if(list.getSelectedIndex()==-1){
                    JOptionPane.showMessageDialog(null,"No Book Selected! Please select Book after Searching to Issue Book","Error",JOptionPane.ERROR_MESSAGE);
                }
                else{
                    try {
                        if(Driver.dataAgent.getIssuedBooksCount(Driver.currentUser.getUser_id())>=Driver.dataAgent.getUserExperience(Driver.currentUser.getUser_id())*2){
                            JOptionPane.showMessageDialog(null,"You can't issue book. You have reached the Issue Book Limit. Please return previous issued books first to issue new books.","Limit Reached",JOptionPane.INFORMATION_MESSAGE);
                        }
                        else if(Driver.dataAgent.isBookIssued(books.get(list.getSelectedIndex()).getBook_id())==0) {
                            Driver.dataAgent.addIssueBookReceipt(Driver.currentUser.getUser_id(), books.get(list.getSelectedIndex()).getBook_id());
                            Driver.dataAgent.decreaseBookCopy(books.get(list.getSelectedIndex()).getBook_id());
                            JOptionPane.showMessageDialog(null,"Book issued successfully","Information",JOptionPane.INFORMATION_MESSAGE);
                            list.clearSelection();
                        }
                        else{
                            JOptionPane.showMessageDialog(null,"You have already issued this book","Book Re-Issue Error",JOptionPane.ERROR_MESSAGE);
                        }
                    }catch(SQLException error){
                        error.printStackTrace();
                    }
                }
            }

            public void mouseEntered(MouseEvent e) {
                btn_issueBook.setBackground(Color.decode("#1262c4"));
            }

            public void mouseExited(MouseEvent e) {
                btn_issueBook.setBackground(Color.decode("#1877EB"));
            }
        });

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        clearAllFields();
        if(e.getSource()==btn_search){
            if(txt_search.getText().matches("(?=.*[~!@#$%^&*()_-]).*")) {
                JOptionPane.showMessageDialog(null,"Invalid Keyword Search","Invalid Search",JOptionPane.ERROR_MESSAGE);
            }
            else if(txt_search.getText().trim().isEmpty()){
                JOptionPane.showMessageDialog(null,"No Book Searched! Enter a Keyword to search Book related to that Keyword","Empty Search Field",JOptionPane.ERROR_MESSAGE);
            }
            else
            {
                this.listModel.clear();
                this.books = Driver.dataAgent.searchBooks(txt_search.getText().trim());
                if(this.books == null) {
                    JOptionPane.showMessageDialog(null,"No book related to your keyword exists ;(",
                            "No result Found!",JOptionPane.ERROR_MESSAGE);
                }
                else {
                    for (Book book : books) {
                        this.listModel.addElement(book.getTitle());
                    }
                }
            }
        }
    }

    public void clearAllFields(){
        txt_title.setText(null);
        txt_author.setText(null);
        txt_genre.setText(null);
        txt_pages.setText(null);
        txt_rating.setText(null);
        txt_releaseDate.setText(null);
    }

    public void showBookDetail(int index){
        this.txt_genre.setText(this.books.get(index).getGenre());
        this.txt_rating.setText(""+this.books.get(index).getRating());
        this.txt_title.setText(this.books.get(index).getTitle());
        this.txt_pages.setText(""+this.books.get(index).getNoOfCopies());
        this.txt_releaseDate.setText(this.books.get(index).getDateOfRelease());
        this.txt_author.setText(this.books.get(index).getAuthor());
    }

    public static void main(String[] args) {
        new BookManagementUI();
    }

}
