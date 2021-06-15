import java.awt.*;
import java.awt.event.*;
import java.awt.font.*;
import java.awt.geom.*;
import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.*;
import java.util.logging.*;
import javax.swing.*;
import javax.swing.border.*;

public class LoginMenu extends JFrame implements MouseListener {

//-> |-| Private Data Members |-----------------------------------------------------------------------------------| <-\\

    private JButton jButton_signIn;
    private JLabel jLabel_close;
    private JLabel jLabel_forgottenPass;
    private JLabel jLabel_signUp;
    private JLabel jLabel_loginImage;
    private JLabel jLabel_minus;
    private JLabel jLabel_passwordImage;
    private JLabel jLabel_title;
    private JLabel jLabel_usernameImage;
    private JCheckBox jCheckBox_rememberMe;
    private JLabel jLabel_showPass;
    private JPanel jPanel_contents;
    private JPanel jPanel_mainBody;
    private JPanel jPanel_titleBar;
    private JPasswordField jPasswordField_pass;
    private JSeparator jSeparator_password;
    private JSeparator jSeparator_username;
    private JTextField jTextField_username;

//-> |-| Private Helping Data Members |---------------------------------------------------------------------------| <-\\

    @SuppressWarnings("FieldCanBeLocal")
    private FrameDragListener frameDragListener;
    @SuppressWarnings("FieldCanBeLocal")
    private Color color_white;
    @SuppressWarnings("FieldCanBeLocal")
    private Color color_background;
    @SuppressWarnings("FieldCanBeLocal")
    private Color color_buttons;
    @SuppressWarnings("FieldCanBeLocal")
    private Color color_titleBar;
    @SuppressWarnings("FieldCanBeLocal")
    private Color color_textFields;
    @SuppressWarnings("FieldCanBeLocal")
    private Color color_links;
    @SuppressWarnings("FieldCanBeLocal")
    private ImageIcon icon;
    @SuppressWarnings("FieldCanBeLocal")
    private Image img;
    @SuppressWarnings("FieldCanBeLocal")
    private Font font;
    @SuppressWarnings({"rawtypes", "FieldCanBeLocal"})
    private Map attributes;
    private boolean flag = true;

//-> |-| LoginMenu Constructor |----------------------------------------------------------------------------------| <-\\

    public LoginMenu() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {

//-> |-| Custom Components Definition Code |----------------------------------------------------------------------| <-\\

        icon = new ImageIcon("img/login_icon.png");
        img = icon.getImage();
        img = img.getScaledInstance(150,150,Image.SCALE_SMOOTH);
        icon = new ImageIcon(img);
        font = new Font("Dialog", Font.BOLD | Font.ITALIC, 14);
        attributes = font.getAttributes();
        attributes.put(TextAttribute.UNDERLINE, TextAttribute.UNDERLINE_ON);

//-> |-| JPanel Main Body Components Definition Code |------------------------------------------------------------| <-\\

        jPanel_mainBody = new JPanel();
        jPanel_contents = new JPanel();
        jSeparator_password = new JSeparator();
        jPasswordField_pass = new JPasswordField();
        jTextField_username = new JTextField();
        jCheckBox_rememberMe = new JCheckBox();
        jLabel_showPass = new JLabel();
        jLabel_usernameImage = new JLabel();
        jButton_signIn = new JButton();
        jLabel_loginImage = new JLabel(icon);
        jLabel_passwordImage = new JLabel();
        jLabel_forgottenPass = new JLabel();
        jLabel_signUp = new JLabel();
        jSeparator_username = new JSeparator();
        jPanel_titleBar = new JPanel();
        jLabel_title = new JLabel();
        jLabel_close = new JLabel();
        jLabel_minus = new JLabel();

//-> |-| Custom Variable Initialization Code |--------------------------------------------------------------------| <-\\

        icon = new ImageIcon("img/v_library_logo.png");
        color_background = new Color(0, 51, 102);
        color_white = new Color(255, 255, 255);
        color_buttons = new Color(34, 167, 240);
        color_titleBar = new Color(0, 102, 204);
        color_textFields = new Color(102, 255, 255);
        color_links = new Color(51, 153, 255);

//-> |-| JFrame Code |--------------------------------------------------------------------------------------------| <-\\

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setFocusTraversalPolicyProvider(true);
        setIconImage(icon.getImage());
        setMaximumSize(new Dimension(1200, 640));
        setMinimumSize(new Dimension(1200, 640));
        setUndecorated(true);
        setResizable(false);
        setShape(new RoundRectangle2D.Double(0, 0, 1200, 640, 40, 40));

//-> |-| JPanel Main Body Code |----------------------------------------------------------------------------------| <-\\

        jPanel_mainBody.setBackground(color_background);

//-> |-| JPanel Contents  Code |----------------------------------------------------------------------------------| <-\\

        jPanel_contents.setBackground(color_background);

//-> |-| JPasswordField Pass Code |-------------------------------------------------------------------------------| <-\\

        font = new Font("Dialog", Font.BOLD, 14);

        jPasswordField_pass.setUI(new HintTextFieldUI("Password", false));
        jPasswordField_pass.setBackground(color_background);
        jPasswordField_pass.setFont(font); // NOI18N
        jPasswordField_pass.setForeground(color_white);
        jPasswordField_pass.setBorder(BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jPasswordField_pass.setCaretColor(color_white);
        jPasswordField_pass.setCursor(new Cursor(Cursor.TEXT_CURSOR));
        jPasswordField_pass.setMaximumSize(new Dimension(300, 30));
        jPasswordField_pass.setMinimumSize(new Dimension(300, 30));
        jPasswordField_pass.setPreferredSize(new Dimension(300, 30));
        jPasswordField_pass.setSelectedTextColor(color_textFields);

//-> |-| JTextField Username Code |-------------------------------------------------------------------------------| <-\\

        jTextField_username.setUI(new HintTextFieldUI("Enter Username", false));
        jTextField_username.setBackground(color_background);
        jTextField_username.setFont(font); // NOI18N
        jTextField_username.setForeground(color_white);
        jTextField_username.setBorder(BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jTextField_username.setCaretColor(color_white);
        jTextField_username.setMaximumSize(new Dimension(300, 30));
        jTextField_username.setMinimumSize(new Dimension(300, 30));
        jTextField_username.setPreferredSize(new Dimension(300, 30));
        jTextField_username.setSelectedTextColor(color_textFields);

//-> |-| JCheckBox Remember Me Code |-----------------------------------------------------------------------------| <-\\

        jCheckBox_rememberMe.setBackground(color_background);
        jCheckBox_rememberMe.setForeground(color_white);
        jCheckBox_rememberMe.setFont(new Font("Dialog", Font.BOLD, 12));
        jCheckBox_rememberMe.setText("Remember Me!");
        jCheckBox_rememberMe.setIconTextGap(10);

//-> |-| JLabel Username Image Code |-----------------------------------------------------------------------------| <-\\

        jLabel_usernameImage.setForeground(color_white);
        jLabel_usernameImage.setIcon(new ImageIcon("img/user_icon.png")); // NOI18N

//-> |-| JButton Sign In Code |-----------------------------------------------------------------------------------| <-\\

        jButton_signIn.setBackground(color_buttons);
        jButton_signIn.setFont(font); // NOI18N
        jButton_signIn.setForeground(color_white);
        jButton_signIn.setText("Sign In");
        jButton_signIn.setBorder(new SoftBevelBorder(BevelBorder.RAISED,
                                        color_background, color_background,
                                        color_background, color_background));
        jButton_signIn.setMaximumSize(new Dimension(150, 30));
        jButton_signIn.setMinimumSize(new Dimension(150, 30));
        jButton_signIn.setPreferredSize(new Dimension(150, 30));
        jButton_signIn.addMouseListener(this);

//-> |-| JLabel Login Image Code |--------------------------------------------------------------------------------| <-\\

        jLabel_loginImage.setBounds(500,350,150,150);
        jLabel_loginImage.setBackground(null);
        jLabel_loginImage.setIcon(new ImageIcon("img/login_icon.png")); // NOI18N
        jLabel_loginImage.setIconTextGap(0);
        jLabel_loginImage.setLayout(null);

//-> |-| JLabel Password Image Code |-----------------------------------------------------------------------------| <-\\

        jLabel_passwordImage.setForeground(color_white);
        jLabel_passwordImage.setIcon(new ImageIcon("img/pass_icon.png")); // NOI18N

//-> |-| JLabel Forgotten Password Code |-------------------------------------------------------------------------| <-\\

        jLabel_forgottenPass.setFont(font);
        jLabel_forgottenPass.setForeground(color_links);
        jLabel_forgottenPass.setText("Forgotten Password?");
        jLabel_forgottenPass.setFont(font.deriveFont(attributes));
        jLabel_forgottenPass.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        jLabel_forgottenPass.addMouseListener(this);

//-> |-| JLabel Sign Up Code |------------------------------------------------------------------------------------| <-\\

        jLabel_signUp.setFont(font);
        jLabel_signUp.setForeground(color_links);
        jLabel_signUp.setText("Don't have an account? Sign Up");
        jLabel_signUp.setFont(font.deriveFont(attributes));
        jLabel_signUp.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        jLabel_signUp.addMouseListener(this);

//-> |-| JCheckBox Show Password Code |---------------------------------------------------------------------------| <-\\

        jLabel_showPass.setIcon(new ImageIcon("img/show_pass.png"));
        jLabel_showPass.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        jLabel_showPass.addMouseListener(this);

//-> |-| GroupLayout Main Body Code |-----------------------------------------------------------------------------| <-\\

        setJPanel_contentsLayout();
        setJPanel_mainBodyLayout();

//-> |-| JPanel Title Bar Code |----------------------------------------------------------------------------------| <-\\

        frameDragListener = new FrameDragListener(this);
        jPanel_titleBar.setBackground(color_titleBar);
        jPanel_titleBar.addMouseListener(frameDragListener);
        jPanel_titleBar.addMouseMotionListener(frameDragListener);

//-> |-| JLabel Title Code |--------------------------------------------------------------------------------------| <-\\

        font = new Font("Dialog", Font.BOLD, 24);

        jLabel_title.setFont(font); // NOI18N
        jLabel_title.setForeground(color_white);
        jLabel_title.setIcon(new ImageIcon("img/v_library_logo.png")); // NOI18N
        jLabel_title.setText("Virtual Library");
        jLabel_title.setIconTextGap(15);

//-> |-| JLabel Close Code |--------------------------------------------------------------------------------------| <-\\

        jLabel_close.setFont(font); // NOI18N
        jLabel_close.setForeground(new Color(255, 0, 0));
        jLabel_close.setText("X");
        jLabel_close.setMaximumSize(new Dimension(16, 46));
        jLabel_close.setMinimumSize(new Dimension(16, 46));
        jLabel_close.setPreferredSize(new Dimension(16, 46));
        jLabel_close.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        jLabel_close.addMouseListener(this);

//-> |-| JLabel Minimize Code |-----------------------------------------------------------------------------------| <-\\

        jLabel_minus.setFont(font); // NOI18N
        jLabel_minus.setForeground(new Color(153, 153, 153));
        jLabel_minus.setText("🗕");
        jLabel_minus.setMaximumSize(new Dimension(25, 46));
        jLabel_minus.setMinimumSize(new Dimension(25, 46));
        jLabel_minus.setPreferredSize(new Dimension(25, 46));
        jLabel_minus.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        jLabel_minus.addMouseListener(this);

//-> |-| GroupLayout Title Bar Code |-----------------------------------------------------------------------------| <-\\

        setJPanel_titleBarLayout();
        setJFrame_mainLayout();

//-> |-| JFrame Bounds Code |-------------------------------------------------------------------------------------| <-\\

        setSize(new Dimension(1200, 640));
        setLocationRelativeTo(null);
    }

//-> |-| GroupLayouts Code |--------------------------------------------------------------------------------------| <-\\

    protected void setJPanel_contentsLayout() {
        GroupLayout jPanel_contentLayout = new GroupLayout(jPanel_contents);
        jPanel_contents.setLayout(jPanel_contentLayout);
        jPanel_contentLayout.setHorizontalGroup(
                jPanel_contentLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel_contentLayout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel_contentLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel_contentLayout.createSequentialGroup()
                                                .addGroup(jPanel_contentLayout.createParallelGroup(
                                                        GroupLayout.Alignment.LEADING)
                                                        .addComponent(jLabel_usernameImage)
                                                        .addComponent(jLabel_passwordImage))
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addGroup(jPanel_contentLayout.createParallelGroup(
                                                        GroupLayout.Alignment.TRAILING, false)
                                                        .addGroup(jPanel_contentLayout.createSequentialGroup()
                                                                .addComponent(jCheckBox_rememberMe)
                                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED,
                                                                        GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                .addComponent(jLabel_forgottenPass))
                                                        .addComponent(jTextField_username,
                                                                GroupLayout.Alignment.LEADING,
                                                                GroupLayout.DEFAULT_SIZE,
                                                                GroupLayout.DEFAULT_SIZE,
                                                                Short.MAX_VALUE)
                                                        .addComponent(jPasswordField_pass,
                                                                GroupLayout.Alignment.LEADING,
                                                                GroupLayout.DEFAULT_SIZE,
                                                                GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(jSeparator_username,
                                                                GroupLayout.Alignment.LEADING)
                                                        .addComponent(jSeparator_password,
                                                                GroupLayout.Alignment.LEADING,
                                                                GroupLayout.PREFERRED_SIZE, 300,
                                                                GroupLayout.PREFERRED_SIZE)))
                                        .addGroup(jPanel_contentLayout.createSequentialGroup()
                                                .addGap(110, 110, 110)
                                                .addComponent(jLabel_loginImage,
                                                        GroupLayout.PREFERRED_SIZE, 150,
                                                        GroupLayout.PREFERRED_SIZE))
                                        .addGroup(jPanel_contentLayout.createSequentialGroup()
                                                .addGap(134, 134, 134)
                                                .addComponent(jButton_signIn,
                                                        GroupLayout.PREFERRED_SIZE, 100,
                                                        GroupLayout.PREFERRED_SIZE))
                                        .addGroup(jPanel_contentLayout.createSequentialGroup()
                                                .addGap(94, 94, 94)
                                                .addComponent(jLabel_signUp)))
                                .addGap(0, 0, 0)
                                .addComponent(jLabel_showPass)
                                .addContainerGap())
        );
        jPanel_contentLayout.setVerticalGroup(
                jPanel_contentLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel_contentLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel_loginImage,
                                        GroupLayout.PREFERRED_SIZE, 167,
                                        GroupLayout.PREFERRED_SIZE)
                                .addGap(52, 52, 52)
                                .addGroup(jPanel_contentLayout.createParallelGroup(
                                        GroupLayout.Alignment.BASELINE)
                                        .addComponent(jTextField_username,
                                                GroupLayout.PREFERRED_SIZE,
                                                GroupLayout.DEFAULT_SIZE,
                                                GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel_usernameImage,
                                                GroupLayout.DEFAULT_SIZE,
                                                GroupLayout.DEFAULT_SIZE,
                                                Short.MAX_VALUE))
                                .addGap(0, 0, 0)
                                .addComponent(jSeparator_username,
                                        GroupLayout.PREFERRED_SIZE, 10,
                                        GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addGroup(jPanel_contentLayout.createParallelGroup(
                                        GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel_showPass,
                                                GroupLayout.DEFAULT_SIZE,
                                                GroupLayout.DEFAULT_SIZE,
                                                Short.MAX_VALUE)
                                        .addGroup(jPanel_contentLayout.createParallelGroup(
                                                GroupLayout.Alignment.BASELINE)
                                                .addComponent(jPasswordField_pass,
                                                        GroupLayout.PREFERRED_SIZE, 30,
                                                        GroupLayout.PREFERRED_SIZE)
                                                .addComponent(jLabel_passwordImage,
                                                        GroupLayout.DEFAULT_SIZE,
                                                        GroupLayout.DEFAULT_SIZE,
                                                        Short.MAX_VALUE)))
                                .addGap(0, 0, 0)
                                .addComponent(jSeparator_password,
                                        GroupLayout.PREFERRED_SIZE, 10,
                                        GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel_contentLayout.createParallelGroup(
                                        GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel_forgottenPass)
                                        .addComponent(jCheckBox_rememberMe))
                                .addGap(18, 18, 18)
                                .addComponent(jButton_signIn,
                                        GroupLayout.PREFERRED_SIZE,
                                        GroupLayout.DEFAULT_SIZE,
                                        GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel_signUp)
                                .addContainerGap())
        );
    }
    protected void setJPanel_mainBodyLayout() {
        GroupLayout jPanel_mainBodyLayout = new GroupLayout(jPanel_mainBody);
        jPanel_mainBody.setLayout(jPanel_mainBodyLayout);
        jPanel_mainBodyLayout.setHorizontalGroup(
                jPanel_mainBodyLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel_mainBodyLayout.createSequentialGroup()
                                .addGap(415, 415, 415)
                                .addComponent(jPanel_contents,
                                        GroupLayout.PREFERRED_SIZE,
                                        GroupLayout.DEFAULT_SIZE,
                                        GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(413, Short.MAX_VALUE))
        );
        jPanel_mainBodyLayout.setVerticalGroup(
                jPanel_mainBodyLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel_mainBodyLayout.createSequentialGroup()
                                .addGap(25, 25, 25)
                                .addComponent(jPanel_contents,
                                        GroupLayout.DEFAULT_SIZE,
                                        GroupLayout.DEFAULT_SIZE,
                                        Short.MAX_VALUE)
                                .addGap(120, 120, 120))
        );
    }
    protected void setJPanel_titleBarLayout() {
        GroupLayout jPanel_titleBarLayout = new GroupLayout(jPanel_titleBar);
        jPanel_titleBar.setLayout(jPanel_titleBarLayout);
        jPanel_titleBarLayout.setHorizontalGroup(
                jPanel_titleBarLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel_titleBarLayout.createSequentialGroup()
                                .addGap(24, 24, 24)
                                .addComponent(jLabel_title)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED,
                                        GroupLayout.DEFAULT_SIZE,
                                        Short.MAX_VALUE)
                                .addComponent(jLabel_minus,
                                        GroupLayout.PREFERRED_SIZE,
                                        GroupLayout.DEFAULT_SIZE,
                                        GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel_close,
                                        GroupLayout.PREFERRED_SIZE,
                                        GroupLayout.DEFAULT_SIZE,
                                        GroupLayout.PREFERRED_SIZE)
                                .addGap(24, 24, 24))
        );
        jPanel_titleBarLayout.setVerticalGroup(
                jPanel_titleBarLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(GroupLayout.Alignment.TRAILING, jPanel_titleBarLayout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel_titleBarLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel_minus,
                                                GroupLayout.PREFERRED_SIZE,
                                                GroupLayout.DEFAULT_SIZE,
                                                GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel_close,
                                                GroupLayout.DEFAULT_SIZE,
                                                GroupLayout.DEFAULT_SIZE,
                                                Short.MAX_VALUE)
                                        .addComponent(jLabel_title,
                                                GroupLayout.DEFAULT_SIZE,
                                                GroupLayout.DEFAULT_SIZE,
                                                Short.MAX_VALUE))
                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }
    protected void setJFrame_mainLayout() {
        GroupLayout jFrame_mainLayout = new GroupLayout(getContentPane());
        getContentPane().setLayout(jFrame_mainLayout);
        jFrame_mainLayout.setHorizontalGroup(
                jFrame_mainLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel_titleBar,
                                GroupLayout.DEFAULT_SIZE,
                                GroupLayout.DEFAULT_SIZE,
                                Short.MAX_VALUE)
                        .addComponent(jPanel_mainBody,
                                GroupLayout.DEFAULT_SIZE,
                                GroupLayout.DEFAULT_SIZE,
                                Short.MAX_VALUE)
        );
        jFrame_mainLayout.setVerticalGroup(
                jFrame_mainLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(GroupLayout.Alignment.TRAILING, jFrame_mainLayout.createSequentialGroup()
                                .addComponent(jPanel_titleBar,
                                        GroupLayout.PREFERRED_SIZE,
                                        GroupLayout.DEFAULT_SIZE,
                                        GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, 0)
                                .addComponent(jPanel_mainBody,
                                        GroupLayout.DEFAULT_SIZE,
                                        GroupLayout.DEFAULT_SIZE,
                                        Short.MAX_VALUE))
        );
        setVisible(true);
    }

//-> |-| Input Validations Code |---------------------------------------------------------------------------------| <-\\

    protected int isDataValid() {
        return Driver.dataAgent.getId(jTextField_username.getText().trim().toLowerCase(),jPasswordField_pass.getText().trim());
    }

//-> |-| Override Methods Code |----------------------------------------------------------------------------------| <-\\

    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getSource () == jLabel_minus) {
            LoginMenu.super.setState (JFrame.ICONIFIED);
        } else if (e.getSource () == jLabel_close) {
            dispose();
        } else if (e.getSource () == jButton_signIn) {
            int userId = isDataValid();
            if (userId != -1) {
                try {
                    Driver.currentUser = Driver.dataAgent.loadUserInfoFromDataBase(userId);
                } catch (SQLException ioException) {
                    ioException.printStackTrace();
                }
                if(jCheckBox_rememberMe.isSelected()){
                    try {
                        new FileManager().writeUserId(userId);
                    } catch (IOException ioException) {
                        ioException.printStackTrace();
                    }
                }
                if(Driver.dataAgent.isBookTableEmpty()){
                    Driver.dataAgent.uploadBooksToDatabase();
                }
                dispose();
                new DashboardUI();
            } else {
                JOptionPane.showMessageDialog(this,
                                              "Invalid Username or Password Entered!",
                                              "Error!", JOptionPane.ERROR_MESSAGE);
            }
        } else if (e.getSource() == jLabel_forgottenPass) {
            dispose();
            //TODO invoke ForgottenPassMenu();
        } else if (e.getSource() == jLabel_signUp) {
            dispose();
            new SignUpUI();
        }
        if (e.getSource() == jLabel_showPass && flag) {
            jPasswordField_pass.setEchoChar((char) 0);
            flag = false;
        }
        else {
            jPasswordField_pass.setEchoChar('*');
            flag = true;
        }
        SwingUtilities.updateComponentTreeUI(this);
    }
    @Override
    public void mousePressed(MouseEvent e) { }
    @Override
    public void mouseReleased(MouseEvent e) { }
    @Override
    public void mouseEntered(MouseEvent e) { }
    @Override
    public void mouseExited(MouseEvent e) { }
}