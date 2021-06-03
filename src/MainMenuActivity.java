import java.awt.*;
import java.util.logging.*;
import javax.swing.*;

public class MainMenuActivity extends JFrame {

    public MainMenuActivity() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultState = "collapsed" desc="Generated Code">
    private void initComponents() {

        FrameDragListener frameDragListener = new FrameDragListener(this);
        jPanel_title = new JPanel();
        jLabel_close = new JLabel();
        jLabel_minus = new JLabel();
        jLabel_heading = new JLabel();
        jPanel2 = new JPanel();
        jComboBox1 = new JComboBox();
        jPanel3 = new JPanel();
        jButton2 = new JButton();
        jButton3 = new JButton();
        jButton4 = new JButton();
        jButton5 = new JButton();
        jButton6 = new JButton();
        jButton7 = new JButton();
        jButton8 = new JButton();
        jButton9 = new JButton();
        jButton10 = new JButton();
        jComboBox2 = new JComboBox();
        jComboBox3 = new JComboBox();
        jButton1 = new JButton();
        jScrollPane1 = new JScrollPane();
        jList1 = new JList();
        jPanel4 = new JPanel();
        jLabel4 = new JLabel();
        jLabel5 = new JLabel();
        jScrollPane2 = new JScrollPane();
        jList2 = new JList();
        jScrollPane3 = new JScrollPane();
        jList3 = new JList();
        jLabel6 = new JLabel();
        jScrollPane4 = new JScrollPane();
        jList4 = new JList();
        jLabel7 = new JLabel();
        jScrollPane5 = new JScrollPane();
        jList5 = new JList();

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setBackground(null);
        setIconImages(null);
        setMaximumSize(new Dimension(1200, 640));
        setMinimumSize(new Dimension(1200, 640));
        setUndecorated(true);
        setPreferredSize(new Dimension(1200, 640));
        setResizable(false);

        jPanel_title.setBackground(new Color(0, 153, 153));
        jPanel_title.setAlignmentX(0.0F);
        jPanel_title.setAlignmentY(0.0F);
        jPanel_title.setFocusTraversalPolicyProvider(true);
        jPanel_title.setMaximumSize(new Dimension(1200, 50));
        jPanel_title.setMinimumSize(new Dimension(1200, 50));
        jPanel_title.addMouseListener(frameDragListener);
        jPanel_title.addMouseMotionListener(frameDragListener);

        jLabel_close.setFont(new Font("Dialog", Font.BOLD, 20)); // NOI18N
        jLabel_close.setForeground(new Color(255, 0, 0));
        jLabel_close.setText("X");
        jLabel_close.setAlignmentY(0.0F);

        jLabel_minus.setFont(new Font("Dialog", Font.BOLD, 20)); // NOI18N
        jLabel_minus.setText("🗕");
        jLabel_minus.setAlignmentY(0.0F);

        jLabel_heading.setFont(new Font("Dialog", Font.BOLD, 20)); // NOI18N
        jLabel_heading.setForeground(new Color(255, 255, 255));
        jLabel_heading.setText("Virtual Library");
        jLabel_heading.setAlignmentY(0.0F);

        GroupLayout jPanel1Layout = new GroupLayout(jPanel_title);
        jPanel_title.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGap(30, 30, 30)
                                .addComponent(jLabel_heading)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel_minus)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel_close)
                                .addGap(18, 18, 18))
        );
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel_close)
                                        .addComponent(jLabel_minus)
                                        .addComponent(jLabel_heading))
                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setBackground(new Color(255, 255, 255));
        jPanel2.setAlignmentX(0.0F);
        jPanel2.setAlignmentY(0.0F);
        jPanel2.setMaximumSize(new Dimension(1200, 590));
        jPanel2.setMinimumSize(new Dimension(1200, 590));
        jPanel2.setPreferredSize(new Dimension(1200, 590));

        jComboBox1.setModel(new DefaultComboBoxModel(new String[] { "Search by Categories", "Item2", "Item3", "Item4" }));
        jComboBox1.setAlignmentX(0.0F);
        jComboBox1.setAlignmentY(0.0F);
        jComboBox1.setName(""); // NOI18N
        jComboBox1.addActionListener(evt -> { });

        jButton2.setAlignmentY(0.0F);
        jButton2.setLabel("Home");
        jButton2.setMaximumSize(new Dimension(100, 25));
        jButton2.setMinimumSize(new Dimension(100, 25));
        jButton2.setPreferredSize(new Dimension(100, 25));

        jButton3.setText("Books");
        jButton3.setMaximumSize(new Dimension(100, 25));
        jButton3.setMinimumSize(new Dimension(100, 25));
        jButton3.setPreferredSize(new Dimension(100, 25));
        jButton3.addActionListener(evt -> { });

        jButton4.setText("E-Books");
        jButton4.setMaximumSize(new Dimension(100, 25));
        jButton4.setMinimumSize(new Dimension(100, 25));
        jButton4.setPreferredSize(new Dimension(100, 25));

        jButton5.setText("Magazines");
        jButton5.setMaximumSize(new Dimension(100, 25));
        jButton5.setMinimumSize(new Dimension(100, 25));
        jButton5.setPreferredSize(new Dimension(100, 25));

        jButton6.setText("Novels");
        jButton6.setMaximumSize(new Dimension(100, 25));
        jButton6.setMinimumSize(new Dimension(100, 25));
        jButton6.setPreferredSize(new Dimension(100, 25));
        jButton6.addActionListener(evt -> { });

        jButton7.setText("Log Out");
        jButton7.setMaximumSize(new Dimension(85, 25));
        jButton7.setMinimumSize(new Dimension(85, 25));
        jButton7.setPreferredSize(new Dimension(80, 25));
        jButton7.addActionListener(evt -> { });

        jButton8.setText("Settings");
        jButton8.setAlignmentY(0.0F);
        jButton8.setMaximumSize(new Dimension(80, 25));
        jButton8.setMinimumSize(new Dimension(80, 25));
        jButton8.setPreferredSize(new Dimension(85, 25));

        jButton9.setText("About Us");
        jButton9.setMaximumSize(new Dimension(85, 25));
        jButton9.setMinimumSize(new Dimension(85, 25));
        jButton9.setPreferredSize(new Dimension(85, 25));
        jButton9.addActionListener(evt -> { });

        jButton10.setText("Reports");
        jButton10.setMaximumSize(new Dimension(120, 25));
        jButton10.setMinimumSize(new Dimension(120, 25));
        jButton10.setPreferredSize(new Dimension(100, 25));

        GroupLayout jPanel3Layout = new GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
                jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel3Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jButton2, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jButton3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jButton4, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jButton5, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jButton6, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jButton10, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButton9, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jButton8, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jButton7, GroupLayout.PREFERRED_SIZE, 89, GroupLayout.PREFERRED_SIZE)
                                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
                jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel3Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(jButton2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jButton3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jButton4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jButton5, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jButton6, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jButton7, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jButton8, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jButton9, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jButton10, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jComboBox2.setModel(new DefaultComboBoxModel(new String[] { "Search by Title", "Item 2", "Item 3", "Item 4" }));
        jComboBox2.setAlignmentX(0.0F);
        jComboBox2.setAlignmentY(0.0F);

        jComboBox3.setModel(new DefaultComboBoxModel(new String[] { "Search by Author", "Item 2", "Item 3", "Item 4" }));
        jComboBox3.setAlignmentX(0.0F);
        jComboBox3.setAlignmentY(0.0F);

        jButton1.setText("Search");
        jButton1.setMaximumSize(new Dimension(85, 25));
        jButton1.setMinimumSize(new Dimension(85, 25));
        jButton1.setPreferredSize(new Dimension(85, 25));

        jList1.setModel(new AbstractListModel() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        jScrollPane1.setViewportView(jList1);

        jLabel4.setFont(new Font("Dialog", Font.BOLD, 18)); // NOI18N
        jLabel4.setText("Newest");
        jLabel4.setToolTipText("");
        jLabel4.setMaximumSize(new Dimension(100, 25));
        jLabel4.setMinimumSize(new Dimension(100, 25));
        jLabel4.setPreferredSize(new Dimension(100, 25));

        jLabel5.setFont(new Font("Dialog", Font.BOLD, 18)); // NOI18N
        jLabel5.setText("Trending");
        jLabel5.setMaximumSize(new Dimension(100, 25));
        jLabel5.setMinimumSize(new Dimension(100, 25));
        jLabel5.setPreferredSize(new Dimension(100, 25));

        jList2.setModel(new AbstractListModel() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        jScrollPane2.setViewportView(jList2);

        jList3.setModel(new AbstractListModel() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        jScrollPane3.setViewportView(jList3);

        jLabel6.setFont(new Font("Dialog", 1, 18)); // NOI18N
        jLabel6.setText("Most Rated");
        jLabel6.setMaximumSize(new Dimension(100, 25));
        jLabel6.setMinimumSize(new Dimension(100, 25));
        jLabel6.setPreferredSize(new Dimension(100, 25));

        jList4.setModel(new AbstractListModel() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        jScrollPane4.setViewportView(jList4);

        jLabel7.setFont(new Font("Dialog", 1, 18)); // NOI18N
        jLabel7.setText("Liked Books");
        jLabel7.setMaximumSize(new Dimension(100, 25));
        jLabel7.setMinimumSize(new Dimension(100, 25));
        jLabel7.setPreferredSize(new Dimension(100, 25));

        jList5.setModel(new AbstractListModel() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        jScrollPane5.setViewportView(jList5);

        GroupLayout jPanel4Layout = new GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
                jPanel4Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel4Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(jScrollPane2)
                                        .addComponent(jLabel4, GroupLayout.DEFAULT_SIZE, 220, Short.MAX_VALUE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jLabel5, GroupLayout.DEFAULT_SIZE, 220, Short.MAX_VALUE)
                                        .addComponent(jScrollPane3))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jLabel6, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jScrollPane4, GroupLayout.PREFERRED_SIZE, 220, GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jLabel7, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jScrollPane5, GroupLayout.PREFERRED_SIZE, 220, GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(32, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
                jPanel4Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel4Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel4Layout.createSequentialGroup()
                                                .addComponent(jLabel7, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(jScrollPane5))
                                        .addGroup(jPanel4Layout.createSequentialGroup()
                                                .addComponent(jLabel6, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(jScrollPane4))
                                        .addGroup(jPanel4Layout.createSequentialGroup()
                                                .addGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                                        .addComponent(jLabel4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jLabel5, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                                .addGap(18, 18, 18)
                                                .addGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                        .addComponent(jScrollPane2)
                                                        .addComponent(jScrollPane3))))
                                .addContainerGap())
        );

        GroupLayout jPanel2Layout = new GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
                jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addComponent(jPanel3, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(jPanel2Layout.createSequentialGroup()
                                                .addComponent(jPanel4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                .addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                        .addGroup(jPanel2Layout.createSequentialGroup()
                                                                .addGap(18, 18, 18)
                                                                .addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                                                        .addComponent(jComboBox1, 0, 180, Short.MAX_VALUE)
                                                                        .addComponent(jComboBox2, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                        .addComponent(jComboBox3, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                                                .addGap(0, 0, Short.MAX_VALUE))
                                                        .addGroup(GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                .addComponent(jButton1, GroupLayout.PREFERRED_SIZE, 85, GroupLayout.PREFERRED_SIZE))
                                                        .addGroup(jPanel2Layout.createSequentialGroup()
                                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(jScrollPane1)))))
                                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
                jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(15, 15, 15)
                                .addComponent(jPanel3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                        .addGroup(jPanel2Layout.createSequentialGroup()
                                                .addComponent(jComboBox1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(jComboBox2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(jComboBox3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(jButton1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, 305, GroupLayout.PREFERRED_SIZE))
                                        .addComponent(jPanel4, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel_title, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel2, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addComponent(jPanel_title, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, 0)
                                .addComponent(jPanel2, GroupLayout.PREFERRED_SIZE, 578, Short.MAX_VALUE)
                                .addGap(0, 0, 0))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>

    public static void main(String args[]) {
        try {
            for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
            Logger.getLogger(MainMenuActivity.class.getName()).log(Level.SEVERE, null, ex);
        }

        EventQueue.invokeLater(() -> {
            new MainMenuActivity().setVisible(true);
        });
    }

    // Variables declaration - do not modify
    private JButton jButton1;
    private JButton jButton10;
    private JButton jButton2;
    private JButton jButton3;
    private JButton jButton4;
    private JButton jButton5;
    private JButton jButton6;
    private JButton jButton7;
    private JButton jButton8;
    private JButton jButton9;
    private JComboBox jComboBox1;
    private JComboBox jComboBox2;
    private JComboBox jComboBox3;
    private JLabel jLabel_close;
    private JLabel jLabel_minus;
    private JLabel jLabel_heading;
    private JLabel jLabel4;
    private JLabel jLabel5;
    private JLabel jLabel6;
    private JLabel jLabel7;
    private JList jList1;
    private JList jList2;
    private JList jList3;
    private JList jList4;
    private JList jList5;
    private JPanel jPanel_title;
    private JPanel jPanel2;
    private JPanel jPanel3;
    private JPanel jPanel4;
    private JScrollPane jScrollPane1;
    private JScrollPane jScrollPane2;
    private JScrollPane jScrollPane3;
    private JScrollPane jScrollPane4;
    private JScrollPane jScrollPane5;
    // End of variables declaration
}