import java.awt.*;
import java.awt.event.*;
import java.awt.font.*;
import java.awt.geom.*;
import java.util.*;
import java.util.logging.*;
import javax.swing.*;
import javax.swing.border.*;

public class LoginActivity extends JFrame implements MouseListener {

    private JButton jButton_signUp;
    private JButton jButton_goBack;
    private JLabel jLabel_title;
    private JLabel jLabel_close;
    private JLabel jLabel_forgottenPass;
    private JLabel jLabel_loginImage;
    private JLabel jLabel_minus;
    private JLabel jLabel_passwordImage;
    private JLabel jLabel_usernameImage;
    private JPanel jPanel_titleBar;
    private JPanel jPanel_mainBody;
    private JPanel jPanel_container;
    private JPasswordField jPasswordField_pass;
    private JSeparator jSeparator_password;
    private JSeparator jSeparator_username;
    private JTextField jTextField_username;

    private Font font;
    private Color backGround_color;
    private Color textColor_white;
    private ImageIcon icon;
    private Image img;

    private final short X_COORDS = 1200;
    private final short Z_COORDS = 640;

    public LoginActivity() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultState="collapsed" desc="Generated Code">
    private void initComponents() {

        font = new Font("Dialog", Font.BOLD | Font.ITALIC, 14);
        backGround_color = new Color(0, 51, 102);
        textColor_white = new Color(255, 255, 255);

        jPanel_mainBody = new JPanel();
        jPanel_container = new JPanel();
        icon = new ImageIcon("/images/login_icon.png");

        jLabel_loginImage = new JLabel(icon);
        jTextField_username = new JTextField();
        jPasswordField_pass = new JPasswordField();
        jSeparator_username = new JSeparator();
        jSeparator_password = new JSeparator();
        jLabel_passwordImage = new JLabel();
        jLabel_usernameImage = new JLabel();

        @SuppressWarnings("rawtypes") Map attributes = font.getAttributes();

        attributes.put(TextAttribute.UNDERLINE, TextAttribute.UNDERLINE_ON);
        jLabel_forgottenPass = new JLabel();
        jButton_signUp = new JButton();
        jButton_goBack = new JButton();
        jPanel_titleBar = new JPanel();
        jLabel_title = new JLabel();
        jLabel_close = new JLabel();
        jLabel_minus = new JLabel();

//->|-| Main JFrame |----------------------------------------------------------------------------------------------|<-//

        icon = new ImageIcon("src/images/v_library_logo.png");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setFocusTraversalPolicyProvider(true);
        setIconImage(icon.getImage());
        setMaximumSize(new Dimension(X_COORDS, Z_COORDS));
        setMinimumSize(new Dimension(X_COORDS, Z_COORDS));
        setUndecorated(true);
        setResizable(false);
        setShape(new RoundRectangle2D.Double(0, 0, X_COORDS, Z_COORDS, 40, 40));

        jPanel_mainBody.setBackground(backGround_color);

        jPanel_container.setBackground(backGround_color);

//->|-| JLabel Login Image |---------------------------------------------------------------------------------------|<-//

        icon = new ImageIcon("images/login_icon.png");

        jLabel_loginImage.setBounds(500,350,150,150);
        jLabel_loginImage.setBackground(null);
        jLabel_loginImage.setIcon(icon); // NOI18N
        jLabel_loginImage.setIconTextGap(0);
        jLabel_loginImage.setLayout(null);

//->|-| Font Text Fields |-----------------------------------------------------------------------------------------|<-//

        font = new Font("Dialog", Font.BOLD, 14);

//->|-| JTextField Username |--------------------------------------------------------------------------------------|<-//

        jTextField_username.setUI(new HintTextFieldUI("Enter Username", true));
        jTextField_username.setBackground(backGround_color);
        jTextField_username.setFont(font); // NOI18N
        jTextField_username.setForeground(textColor_white);
        jTextField_username.setBorder(null);
        jTextField_username.setCaretColor(textColor_white);
        jTextField_username.setMaximumSize(new Dimension(300, 30));
        jTextField_username.setMinimumSize(new Dimension(300, 30));
        jTextField_username.setPreferredSize(new Dimension(300, 30));
        jTextField_username.setSelectedTextColor(new Color(102, 255, 255));

//->|-| JPasswordField Password |----------------------------------------------------------------------------------|<-//

        jPasswordField_pass.setUI(new HintTextFieldUI("Password", true));
        jPasswordField_pass.setBackground(backGround_color);
        jPasswordField_pass.setFont(font); // NOI18N
        jPasswordField_pass.setForeground(textColor_white);
        jPasswordField_pass.setBorder(null);
        jPasswordField_pass.setCaretColor(textColor_white);
        jPasswordField_pass.setCursor(new Cursor(Cursor.TEXT_CURSOR));
        jPasswordField_pass.setMaximumSize(new Dimension(300, 30));
        jPasswordField_pass.setMinimumSize(new Dimension(300, 30));
        jPasswordField_pass.setPreferredSize(new Dimension(300, 30));
        jPasswordField_pass.setSelectedTextColor(new Color(102, 255, 255));


//->|-| JLabel Password Image |------------------------------------------------------------------------------------|<-//

        icon = new ImageIcon("images/pass_icon.png");

        jLabel_passwordImage.setForeground(textColor_white);
        jLabel_passwordImage.setIcon(icon); // NOI18N
        jLabel_passwordImage.setLayout(null);

//->|-| JLabel Username Image |------------------------------------------------------------------------------------|<-//

        icon = new ImageIcon("images/user_icon.png");

        jLabel_usernameImage.setForeground(textColor_white);
        jLabel_usernameImage.setIcon(icon); // NOI18N
        jLabel_usernameImage.setLayout(null);

//->|-| JLabel Forgotten Password |--------------------------------------------------------------------------------|<-//

        jLabel_forgottenPass.setFont(font);
        jLabel_forgottenPass.setForeground(new Color(51, 153, 255));
        jLabel_forgottenPass.setText("Forgotten Password?");
        jLabel_forgottenPass.setFont(font.deriveFont(attributes));
        jLabel_forgottenPass.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

//->|-| Font Buttons |---------------------------------------------------------------------------------------------|<-//

        font = new Font("Dialog", Font.BOLD, 14);

//->|-| JButton Sign Up |------------------------------------------------------------------------------------------|<-//

        jButton_signUp.setBackground(new Color(34, 167, 240));
        jButton_signUp.setFont(font); // NOI18N
        jButton_signUp.setForeground(textColor_white);
        jButton_signUp.setText("Sign In");
        jButton_signUp.setBorder(
                                new SoftBevelBorder(
                                        BevelBorder.RAISED,
                                        backGround_color,
                                        backGround_color,
                                        backGround_color,
                                        backGround_color));
        jButton_signUp.setMaximumSize(new Dimension(100, 30));
        jButton_signUp.setMinimumSize(new Dimension(100, 30));
        jButton_signUp.setPreferredSize(new Dimension(100, 30));

//->|-| JButton Go Back |------------------------------------------------------------------------------------------|<-//

        jButton_goBack.setBackground(new Color(34, 167, 240));
        jButton_goBack.setFont(font); // NOI18N
        jButton_goBack.setForeground(textColor_white);
        jButton_goBack.setText("Go Back");
        jButton_goBack.setBorder(
                                new SoftBevelBorder(
                                        BevelBorder.RAISED,
                                        backGround_color,
                                        backGround_color,
                                        backGround_color,
                                        backGround_color));
        jButton_goBack.setMaximumSize(new Dimension(100, 30));
        jButton_goBack.setMinimumSize(new Dimension(100, 30));
        jButton_goBack.setPreferredSize(new Dimension(100, 30));
        jButton_goBack.addMouseListener(this);

        GroupLayout jPanel3Layout = new GroupLayout(jPanel_container);
        jPanel_container.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
                jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel3Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel3Layout.createSequentialGroup()
                                                .addGap(110, 110, 110)
                                                .addComponent(jLabel_loginImage,
                                                        GroupLayout.PREFERRED_SIZE, 150,
                                                        GroupLayout.PREFERRED_SIZE))
                                        .addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                                .addGroup(jPanel3Layout.createSequentialGroup()
                                                        .addGroup(jPanel3Layout.createParallelGroup(
                                                                GroupLayout.Alignment.LEADING)
                                                                        .addComponent(jLabel_usernameImage)
                                                                        .addComponent(jLabel_passwordImage))
                                                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                                        .addGroup(jPanel3Layout.createParallelGroup(
                                                                GroupLayout.Alignment.LEADING, false)
                                                                .addGroup(jPanel3Layout.createSequentialGroup()
                                                                        .addComponent(jButton_goBack,
                                                                                GroupLayout.PREFERRED_SIZE, 100,
                                                                                GroupLayout.PREFERRED_SIZE)
                                                                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED,
                                                                                GroupLayout.DEFAULT_SIZE,
                                                                                Short.MAX_VALUE)
                                                                        .addComponent(jButton_signUp,
                                                                                GroupLayout.PREFERRED_SIZE, 100,
                                                                                GroupLayout.PREFERRED_SIZE)
                                                                        .addGap(13, 13, 13))
                                                                .addComponent(jTextField_username,
                                                                        GroupLayout.DEFAULT_SIZE,
                                                                        GroupLayout.DEFAULT_SIZE,
                                                                        Short.MAX_VALUE)
                                                                .addComponent(jPasswordField_pass,
                                                                        GroupLayout.DEFAULT_SIZE,
                                                                        GroupLayout.DEFAULT_SIZE,
                                                                        Short.MAX_VALUE)
                                                                .addComponent(jSeparator_username)
                                                                .addComponent(jSeparator_password,
                                                                        GroupLayout.PREFERRED_SIZE, 300,
                                                                        GroupLayout.PREFERRED_SIZE)))
                                                .addComponent(jLabel_forgottenPass)))
                                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
                jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel3Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel_loginImage,
                                        GroupLayout.PREFERRED_SIZE, 167,
                                        GroupLayout.PREFERRED_SIZE)
                                .addGap(52, 52, 52)
                                .addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
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
                                .addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(jPasswordField_pass,
                                                GroupLayout.PREFERRED_SIZE, 30,
                                                GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel_passwordImage,
                                                GroupLayout.DEFAULT_SIZE,
                                                GroupLayout.DEFAULT_SIZE,
                                                Short.MAX_VALUE))
                                .addGap(0, 0, 0)
                                .addComponent(jSeparator_password,
                                        GroupLayout.PREFERRED_SIZE, 10,
                                        GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel_forgottenPass)
                                .addGap(31, 31, 31)
                                .addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(jButton_signUp,
                                                GroupLayout.PREFERRED_SIZE,
                                                GroupLayout.DEFAULT_SIZE,
                                                GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jButton_goBack,
                                                GroupLayout.PREFERRED_SIZE,
                                                GroupLayout.DEFAULT_SIZE,
                                                GroupLayout.PREFERRED_SIZE))
                                .addContainerGap())
        );

        GroupLayout jPanel1Layout = new GroupLayout(jPanel_mainBody);
        jPanel_mainBody.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(415, 415, 415)
                                .addComponent(jPanel_container,
                                        GroupLayout.PREFERRED_SIZE,
                                        GroupLayout.DEFAULT_SIZE,
                                        GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(413, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(25, 25, 25)
                                .addComponent(jPanel_container,
                                        GroupLayout.DEFAULT_SIZE,
                                        GroupLayout.DEFAULT_SIZE,
                                        Short.MAX_VALUE)
                                .addGap(120, 120, 120))
        );

        jPanel_titleBar.setBackground(new Color(0, 102, 204));

        font = new Font("Dialog", Font.BOLD, 24);
        icon = new ImageIcon("images/v_library_logo.png");

        jLabel_title.setFont(font); // NOI18N
        jLabel_title.setForeground(textColor_white);
        jLabel_title.setIcon(icon); // NOI18N
        jLabel_title.setText("Virtual Library");
        jLabel_title.setIconTextGap(15);

        jLabel_close.setFont(font); // NOI18N
        jLabel_close.setForeground(new Color(255, 0, 0));
        jLabel_close.setText("X");
        jLabel_close.setMaximumSize(new Dimension(16, 46));
        jLabel_close.setMinimumSize(new Dimension(16, 46));
        jLabel_close.setPreferredSize(new Dimension(16, 46));

        jLabel_minus.setFont(font); // NOI18N
        jLabel_minus.setForeground(new Color(153, 153, 153));
        jLabel_minus.setText("🗕");
        jLabel_minus.setMaximumSize(new Dimension(25, 46));
        jLabel_minus.setMinimumSize(new Dimension(25, 46));
        jLabel_minus.setPreferredSize(new Dimension(25, 46));

        GroupLayout jPanel2Layout = new GroupLayout(jPanel_titleBar);
        jPanel_titleBar.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
                jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
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
        jPanel2Layout.setVerticalGroup(
                jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
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

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel_titleBar,
                                GroupLayout.DEFAULT_SIZE,
                                GroupLayout.DEFAULT_SIZE,
                                Short.MAX_VALUE)
                        .addComponent(jPanel_mainBody,
                                GroupLayout.DEFAULT_SIZE,
                                GroupLayout.DEFAULT_SIZE,
                                Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
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

        setSize(new Dimension(X_COORDS, Z_COORDS));
        setLocationRelativeTo(null);
    }// </editor-fold>

    public static void main(String[] args) {
        try {
            for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException |
                 InstantiationException |
                 IllegalAccessException |
                 UnsupportedLookAndFeelException ex) {

            Logger.getLogger(LoginActivity.class.getName()).log(Level.SEVERE, null, ex);
        }

        EventQueue.invokeLater(() -> new LoginActivity().setVisible(true));
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}