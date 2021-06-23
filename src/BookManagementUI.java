
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.RoundRectangle2D;
import java.sql.SQLException;
import java.util.ArrayList;

public class BookManagementUI extends JFrame implements ActionListener{

    private final int FRAME_WIDTH = 1200;
    private final int FRAME_HEIGHT = 900;
    private final Font sidebarMenuFont = new Font("Arial", Font.BOLD, 26);
    private final Font textFieldFont = new Font("Arial",Font.PLAIN,18);

    private DefaultListModel<String> listModel = new DefaultListModel<>();
    private JList list = null;

    private ArrayList<Book> books = null;
    public static Book selectedBook = null;

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

    private DefaultTableModel tableModel = new DefaultTableModel();
    private JTable table;

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
        panel_body.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                table.clearSelection();
            }
        });
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
                dispose();
                new AddBookUI();
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

                        Driver.dataAgent.removeBook(books.get(table.getSelectedRow()).getBook_id());
                        JOptionPane.showMessageDialog(null,"Book deleted successfully","User Deletion",JOptionPane.INFORMATION_MESSAGE);
                        dispose();
                        new BookManagementUI();

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


        JButton btn_editBook = new JButton("Show Book");
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
                    JOptionPane.showMessageDialog(null,"No user selected! Please select a Book from table","Error",JOptionPane.ERROR_MESSAGE);
                }else{
                    selectedBook = new Book();
                    selectedBook.setTitle(books.get(table.getSelectedRow()).getTitle());
                    selectedBook.setAuthor(books.get(table.getSelectedRow()).getAuthor());
                    selectedBook.setGenre(books.get(table.getSelectedRow()).getGenre());
                    selectedBook.setNoOfCopies(books.get(table.getSelectedRow()).getNoOfCopies());
                    selectedBook.setRating(books.get(table.getSelectedRow()).getRating());
                    selectedBook.setDateOfRelease(books.get(table.getSelectedRow()).getDateOfRelease());

                    dispose();
                    new EditBookUI();
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


        Object[] columnsNames = {"Title","Author","Genre","Rating","Copies","Release Year"};
        tableModel.setColumnIdentifiers(columnsNames);

        try{

            books = Driver.dataAgent.getAllBooks();

            if(books!=null){
                for (Book book : books){
                    tableModel.addRow(book.getBookObject());
                }
            }


        } catch(SQLException e){
            e.printStackTrace();
        }

        // Columns Widths
        table.getColumnModel().getColumn(0).setPreferredWidth(100);
        table.getColumnModel().getColumn(1).setPreferredWidth(100);
        table.getColumnModel().getColumn(2).setPreferredWidth(100);
        table.getColumnModel().getColumn(3).setPreferredWidth(5);
        table.getColumnModel().getColumn(4).setPreferredWidth(10);
        table.getColumnModel().getColumn(5).setPreferredWidth(10);



        panel_resultArea.add(new JScrollPane(table));

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if(e.getSource()==btn_search){
            if(txt_search.getText().matches("(?=.*[~!@#$%^&*()_-]).*")) {
                JOptionPane.showMessageDialog(null,"Invalid Keyword Search","Invalid Search",JOptionPane.ERROR_MESSAGE);
            }
            else if(txt_search.getText().trim().isEmpty()){
                JOptionPane.showMessageDialog(null,"No Book Searched! Enter a Keyword to search Book related to that Keyword","Empty Search Field",JOptionPane.ERROR_MESSAGE);
            }
            else
            {
                switch(cmbx_searchFilter.getSelectedIndex()){
                    case(0):
                        this.books = Driver.dataAgent.searchBooksByTitle(txt_search.getText().trim());
                        break;
                    case(1):
                        this.books = Driver.dataAgent.searchBooksByAuthor(txt_search.getText().trim());
                        break;
                    case(2):
                        this.books = Driver.dataAgent.searchBooksByGenre(txt_search.getText().trim());
                        break;
                    case(3):
                        this.books = Driver.dataAgent.searchBooksByYear(Integer.parseInt(txt_search.getText().trim()));
                        break;
                    case(4):
                        this.books = Driver.dataAgent.searchBooksByRating(Float.parseFloat(txt_search.getText().trim()));
                        break;
                }
                if(this.books == null) {
                    JOptionPane.showMessageDialog(null,"No book related to your keyword exists :(",
                            "No result Found!",JOptionPane.ERROR_MESSAGE);
                }
                else {
                    tableModel.setRowCount(0);
                    for (Book book : books) {
                        tableModel.addRow(book.getBookObject());
                    }


                }
            }
        }
    }

    public void searchBooks(){

    }
    public static void main(String[] args) {
        new BookManagementUI();
    }

}
