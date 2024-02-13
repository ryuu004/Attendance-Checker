package Start;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.MatteBorder;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Register {

    private JFrame frame;
    public Register(JFrame mainframe) {

        frame = new JFrame("Register");
        frame.setSize(900, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setBackground(new Color(0x201a59));
        frame.setLayout(new BorderLayout());


        JPanel middlePanel = new JPanel();
        middlePanel.setPreferredSize(new Dimension(700, 500));
        middlePanel.setBackground(new Color(0x2f2678));
        middlePanel.setLayout(new BoxLayout(middlePanel, BoxLayout.Y_AXIS));

        JPanel firstlayer = new JPanel();
        firstlayer.setBackground(new Color(0x2f2678));
        firstlayer.setPreferredSize(new Dimension(700, 100));
        middlePanel.add(firstlayer);
        firstlayer.setLayout(new BorderLayout());

        JLabel welcomeLabel = new JLabel("Welcome User");
        welcomeLabel.setForeground(Color.WHITE);
        welcomeLabel.setFont(new Font("Arial", Font.BOLD, 20));
        welcomeLabel.setHorizontalAlignment(SwingConstants.CENTER);
        welcomeLabel.setBorder(new EmptyBorder(20, 20, 20, 20));
        firstlayer.add(welcomeLabel, BorderLayout.NORTH);

        JLabel signInLabel = new JLabel("Register an account");
        signInLabel.setForeground(Color.WHITE);
        signInLabel.setFont(new Font("Arial", Font.BOLD, 14));
        signInLabel.setHorizontalAlignment(SwingConstants.CENTER);
        firstlayer.add(signInLabel, BorderLayout.CENTER);
        firstlayer.setBorder(new MatteBorder(0, 0, 2, 0, Color.WHITE));

        JPanel secondlayer = new JPanel();
        secondlayer.setBackground(new Color(0x2f2678));
        secondlayer.setPreferredSize(new Dimension(700, 350));
        secondlayer.setBorder(new EmptyBorder(20, 0, 0, 0));
        secondlayer.setLayout(new BoxLayout(secondlayer, BoxLayout.Y_AXIS));
        middlePanel.add(secondlayer);

        JPanel firstrow = new JPanel();
        firstrow.setPreferredSize(new Dimension(700, 100));
        firstrow.setBackground(new Color(0x2f2678));
        firstrow.setLayout(new BoxLayout(firstrow, BoxLayout.X_AXIS));
        secondlayer.add(firstrow);

        JPanel NameContainer = new JPanel();
        NameContainer.setBackground(new Color(0x2f2678));
        NameContainer.setLayout(new BoxLayout(NameContainer, BoxLayout.Y_AXIS));
        firstrow.add(NameContainer);

        JPanel fullnameLabel = new JPanel();
        fullnameLabel.setBackground(new Color(0x2f2678));
        NameContainer.add(fullnameLabel);

        JLabel Fullname = new JLabel("FULL NAME");
        Fullname.setFont(new Font("Arial", Font.PLAIN, 12));
        Fullname.setForeground(Color.WHITE);
        Fullname.setBorder(new EmptyBorder(0, 0, 0, 0));
        Fullname.setHorizontalAlignment(SwingConstants.CENTER);
        fullnameLabel.add(Fullname);

        JPanel fnameinputpanel = new JPanel();
        fnameinputpanel.setBackground(new Color(0x2f2678));
        NameContainer.add(fnameinputpanel);

        JTextField FullnameInput = new JTextField();
        FullnameInput.setFont(new Font("Arial", Font.PLAIN, 12));
        FullnameInput.setBorder(new EmptyBorder(0, 10, 0, 0));
        FullnameInput.setPreferredSize(new Dimension(150,25));
        fnameinputpanel.add(FullnameInput);

        JPanel radioPanel = new JPanel();
        radioPanel.setBackground(new Color(0x2f2678));
        radioPanel.setLayout(new BoxLayout(radioPanel, BoxLayout.X_AXIS));

        ImageIcon radio = new ImageIcon("src/Images/radio_unc (1).png");
        JLabel Student = new JLabel(radio);
        radioPanel.add(Student);

        JLabel stdLabel = new JLabel("STUDENT");
        stdLabel.setFont(new Font("Arial", Font.PLAIN, 12));
        stdLabel.setForeground(Color.WHITE);
        stdLabel.setBorder(new EmptyBorder(0, 0, 0, 20));
        radioPanel.add(stdLabel);

        ImageIcon radio1 = new ImageIcon("src/Images/radio_unc (1).png");
        JLabel Teacher = new JLabel(radio);
        radioPanel.add(Teacher);

        Student.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                ImageIcon radio = new ImageIcon("src/Images/radio_ch (3).png");
                Student.setIcon(radio);
                ImageIcon radio1 = new ImageIcon("src/Images/radio_unc (1).png");
                Teacher.setIcon(radio1);
            }
        });

        Teacher.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                ImageIcon radio1 = new ImageIcon("src/Images/radio_ch (3).png");
                Teacher.setIcon(radio1);
                ImageIcon radio = new ImageIcon("src/Images/radio_unc (1).png");
                Student.setIcon(radio);
            }
        });

        JLabel tchLabel = new JLabel("TEACHER");
        tchLabel.setFont(new Font("Arial", Font.PLAIN, 12));
        tchLabel.setForeground(Color.WHITE);
        tchLabel.setBorder(new EmptyBorder(0, 0, 0, 10));
        radioPanel.add(tchLabel);

        firstrow.add(radioPanel);

        JPanel secondrow = new JPanel();
        secondrow.setBackground(new Color(0x2f2678));
        secondrow.setPreferredSize(new Dimension(700, 100));
        secondrow.setBorder(new EmptyBorder(10, 0, 0, 0));
        secondrow.setLayout(new BoxLayout(secondrow, BoxLayout.Y_AXIS));
        secondlayer.add(secondrow);

        JPanel addressLabel = new JPanel();
        addressLabel.setBackground(new Color(0x2f2678));
        secondrow.add(addressLabel);

        JLabel addressname = new JLabel("ADRESS");
        addressname.setFont(new Font("Arial", Font.PLAIN, 12));
        addressname.setForeground(Color.WHITE);
        addressname.setBorder(new EmptyBorder(0, 0, 0, 0));
        addressname.setHorizontalAlignment(SwingConstants.CENTER);
        addressLabel.add(addressname);

        JPanel addressinputpanel = new JPanel();
        addressinputpanel.setBackground(new Color(0x2f2678));
        secondrow.add(addressinputpanel);

        JTextField addressnameInput = new JTextField();
        addressnameInput.setFont(new Font("Arial", Font.PLAIN, 12));
        addressnameInput.setBorder(new EmptyBorder(0, 10, 0, 0));
        addressnameInput.setPreferredSize(new Dimension(220,25));
        addressinputpanel.add(addressnameInput);

        JPanel thirdrow = new JPanel();
        thirdrow.setPreferredSize(new Dimension(700, 100));
        thirdrow.setBorder(new EmptyBorder(10, 0, 0, 0));
        thirdrow.setBackground(new Color(0x2f2678));
        thirdrow.setLayout(new BoxLayout(thirdrow, BoxLayout.X_AXIS));
        secondlayer.add(thirdrow);

        JPanel NameContainer1 = new JPanel();
        NameContainer1.setBackground(new Color(0x2f2678));
        NameContainer1.setLayout(new BoxLayout(NameContainer1, BoxLayout.Y_AXIS));
        thirdrow.add(NameContainer1);

        JPanel bdayLabel = new JPanel();
        bdayLabel.setBackground(new Color(0x2f2678));
        NameContainer1.add(bdayLabel);

        JLabel bday = new JLabel("BIRTHDAY");
        bday.setFont(new Font("Arial", Font.PLAIN, 12));
        bday.setForeground(Color.WHITE);
        bday.setBorder(new EmptyBorder(0, 0, 0, 0));
        bday.setHorizontalAlignment(SwingConstants.CENTER);
        bdayLabel.add(bday);

        JPanel bdayinputpanel = new JPanel();
        bdayinputpanel.setBackground(new Color(0x2f2678));
        NameContainer1.add(bdayinputpanel);

        JTextField bdayInput = new JTextField();
        bdayInput.setFont(new Font("Arial", Font.PLAIN, 12));
        bdayInput.setBorder(new EmptyBorder(0, 10, 0, 0));
        bdayInput.setPreferredSize(new Dimension(150,25));
        bdayinputpanel.add(bdayInput);

        JPanel contactLabel = new JPanel();
        contactLabel.setLayout(new BoxLayout(contactLabel, BoxLayout.Y_AXIS));
        thirdrow.add(contactLabel);

        JPanel contactlabel = new JPanel();
        contactlabel.setBackground(new Color(0x2f2678));
        contactLabel.add(contactlabel);


        JLabel contact = new JLabel("CONTACT");
        contact.setBackground(new Color(0x2f2678));
        contact.setFont(new Font("Arial", Font.PLAIN, 12));
        contact.setForeground(Color.WHITE);
        contact.setBorder(new EmptyBorder(0, 0, 0, 0));
        contact.setHorizontalAlignment(SwingConstants.CENTER);
        contactlabel.add(contact);

        JPanel contactinputpanel = new JPanel();
        contactinputpanel.setBackground(new Color(0x2f2678));
        contactLabel.add(contactinputpanel);

        JTextField contactInput = new JTextField();
        contactInput.setFont(new Font("Arial", Font.PLAIN, 12));
        contactInput.setBorder(new EmptyBorder(0, 10, 0, 0));
        contactInput.setPreferredSize(new Dimension(150,25));
        contactinputpanel.add(contactInput);

        JPanel fourthrow = new JPanel();
        fourthrow.setBackground(new Color(0x2f2678));
        fourthrow.setBorder(new EmptyBorder(10, 0, 0, 0));
        fourthrow.setPreferredSize(new Dimension(700, 100));
        fourthrow.setLayout(new BoxLayout(fourthrow, BoxLayout.Y_AXIS));
        secondlayer.add(fourthrow);

        JPanel emailLabel = new JPanel();
        emailLabel.setBackground(new Color(0x2f2678));
        fourthrow.add(emailLabel);

        JLabel emailname = new JLabel("EMAIL");
        emailname.setFont(new Font("Arial", Font.PLAIN, 12));
        emailname.setForeground(Color.WHITE);
        emailname.setBorder(new EmptyBorder(0, 0, 0, 0));
        emailname.setHorizontalAlignment(SwingConstants.CENTER);
        emailLabel.add(emailname);

        JPanel emailinputpanel = new JPanel();
        emailinputpanel.setBackground(new Color(0x2f2678));
        fourthrow.add(emailinputpanel);

        JTextField emailnameInput = new JTextField();
        emailnameInput.setBorder(new EmptyBorder(0, 10, 0, 0));
        emailnameInput.setFont(new Font("Arial", Font.PLAIN, 12));
        emailnameInput.setPreferredSize(new Dimension(220,25));
        emailinputpanel.add(emailnameInput);

        JPanel fifthrow = new JPanel();
        fifthrow.setPreferredSize(new Dimension(700, 100));
        fifthrow.setBorder(new EmptyBorder(10, 0, 0, 0));
        fifthrow.setBackground(new Color(0x2f2678));
        fifthrow.setLayout(new BoxLayout(fifthrow, BoxLayout.X_AXIS));
        secondlayer.add(fifthrow);

        JPanel NameContainer2 = new JPanel();
        NameContainer2.setBackground(new Color(0x2f2678));
        NameContainer2.setLayout(new BoxLayout(NameContainer2, BoxLayout.Y_AXIS));
        fifthrow.add(NameContainer2);

        JPanel userLabel = new JPanel();
        userLabel.setBackground(new Color(0x2f2678));
        NameContainer2.add(userLabel);

        JLabel user = new JLabel("USERNAME");
        user.setFont(new Font("Arial", Font.PLAIN, 12));
        user.setForeground(Color.WHITE);
        user.setBorder(new EmptyBorder(0, 0, 0, 0));
        user.setHorizontalAlignment(SwingConstants.CENTER);
        userLabel.add(user);

        JPanel userinputpanel = new JPanel();
        userinputpanel.setBackground(new Color(0x2f2678));
        NameContainer2.add(userinputpanel);

        JTextField userInput = new JTextField();
        userInput.setFont(new Font("Arial", Font.PLAIN, 12));
        userInput.setBorder(new EmptyBorder(0, 10, 0, 0));
        userInput.setPreferredSize(new Dimension(150,25));
        userinputpanel.add(userInput);

        JPanel passLabel = new JPanel();
        passLabel.setLayout(new BoxLayout(passLabel, BoxLayout.Y_AXIS));
        fifthrow.add(passLabel);

        JPanel passlabel = new JPanel();
        passlabel.setBackground(new Color(0x2f2678));
        passLabel.add(passlabel);


        JLabel pass = new JLabel("PASSWORD");
        pass.setBackground(Color.black);
        pass.setFont(new Font("Arial", Font.PLAIN, 12));
        pass.setForeground(Color.white);
        pass.setBorder(new EmptyBorder(0, 0, 0, 0));
        pass.setHorizontalAlignment(SwingConstants.CENTER);
        passlabel.add(pass);

        JPanel passinputpanel = new JPanel();
        passinputpanel.setBackground(new Color(0x2f2678));
        passLabel.add(passinputpanel);

        JTextField passInput = new JTextField();
        passInput.setFont(new Font("Arial", Font.PLAIN, 12));
        passInput.setBorder(new EmptyBorder(0, 10, 0, 0));
        passInput.setPreferredSize(new Dimension(150,25));
        passinputpanel.add(passInput);


        JPanel thirdlayer = new JPanel();
        thirdlayer.setBackground(new Color(0x2f2678));
        thirdlayer.setPreferredSize(new Dimension(700, 200));
        middlePanel.add(thirdlayer);
        thirdlayer.setLayout(new BoxLayout(thirdlayer, BoxLayout.X_AXIS));

        JLabel haveacc = new JLabel("Already have an account? Login");
        haveacc.setFont(new Font("Arial", Font.PLAIN, 11));
        haveacc.setForeground(Color.white);
        haveacc.setBorder(new EmptyBorder(10, 0, 0, 80));
        thirdlayer.add(haveacc);

        haveacc.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                haveacc.setForeground(new Color(0xe1cfff));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                haveacc.setForeground(Color.WHITE);
            }

            @Override
            public void mouseClicked(MouseEvent e) {
                frame.dispose();
                mainframe.setVisible(true);
            }
        });


        ImageIcon register = new ImageIcon("src/Images/regButton.png");
        JLabel register1 = new JLabel(register);
        thirdlayer.add(register1);
        thirdlayer.setBorder(new EmptyBorder(30, 0, 0, 0));

        JPanel topPanel = new JPanel();
        topPanel.setBackground(new Color(0x201a59));
        topPanel.setPreferredSize(new Dimension(900, 30));

        JPanel bottomPanel = new JPanel();
        bottomPanel.setBackground(new Color(0x201a59));
        bottomPanel.setPreferredSize(new Dimension(900, 30));

        JPanel rightPanel = new JPanel();
        rightPanel.setBackground(new Color(0x201a59));
        rightPanel.setPreferredSize(new Dimension(200, 600));

        JPanel leftPanel = new JPanel();
        leftPanel.setBackground(new Color(0x201a59));
        leftPanel.setPreferredSize(new Dimension(200, 600));

        frame.add(topPanel, BorderLayout.NORTH);
        frame.add(bottomPanel, BorderLayout.SOUTH);
        frame.add(leftPanel, BorderLayout.WEST);
        frame.add(rightPanel, BorderLayout.EAST);
        frame.add(middlePanel, BorderLayout.CENTER);

        frame.setVisible(true);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
    }
}

