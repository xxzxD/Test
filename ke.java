import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.Dimension;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
public class ke extends JFrame implements ActionListener {

    private final JFrame frame;
    private JTextField textField;
    private JButton send;
    private JButton enter;
    private JLabel appear, friend;
    
    public static void main(String[] args) {
        ke gui = new ke();
        gui.frame.setVisible(true);
        gui.frame.setPreferredSize(new Dimension(1125,250));
    }

    public ke() {
        frame = new JFrame();
        frame.setTitle("");
        //The program terminates when exiting the interface.
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //Set the position, width and height of the interface.
        frame.setBounds(300, 10, 1000, 800);
        frame.getContentPane().setLayout(null);
        label();
    }

    private void label() {

        textField = new JTextField();
        frame.getContentPane().add(textField);

        send = new JButton("send");
        frame.getContentPane().add(send);
        //Push the send.
        send.addActionListener(this);

        enter = new JButton("enter");
        frame.getContentPane().add(enter);
        //Push the enter.
        enter.addActionListener(this);

        appear = new JLabel("Your output will appear here...");
        appear.setOpaque(true);
        appear.setBackground(Color.WHITE);
        //Words are displayed from the top.
        appear.setVerticalAlignment(SwingConstants.TOP);
        frame.getContentPane().add(appear);

        friend = new JLabel("Your Friend");
        friend.setOpaque(true);
        friend.setBackground(Color.WHITE);
        //Words are displayed from the top.
        friend.setVerticalAlignment(SwingConstants.TOP);
        frame.getContentPane().add(friend);

        //When the interface is resized.
        frame.addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                resizeFrame();
            }
        });
    }
    public void resizeFrame() {
        //How much the height has changed.
        int height = frame.getHeight() - 800;
        textField.setBounds(100, 675 + height/2, 300, 40);
        send.setBounds(425, 675 + height/2, 100, 40);
        enter.setBounds(700, 675 + height/2, 200, 40);
        appear.setBounds(10, 10 + height/2, 1000, 600);
        friend.setBounds(1100, 10 + height/2, 400, 700);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
    }
}
