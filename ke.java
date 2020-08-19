import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;

import java.awt.Dimension;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.util.Calendar;
public class ke extends JFrame{

    private final JFrame frame;
    private JTextField textField;
    private JButton send;
    private JButton enter;
    private JLabel appear, friend;
    private JPanel panelOutput;
    private JTextArea textArea;
    private JScrollPane jsp;
    private int count = 0;
    private String comment = "";
    
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
        SentenceListener sentenceListener = new SentenceListener();

        textField = new JTextField();
        textField.addActionListener(sentenceListener);
        frame.getContentPane().add(textField);

        send = new JButton("send");
        frame.getContentPane().add(send);
        //Push the send.
        send.addActionListener(sentenceListener);

        enter = new JButton("enter");
        frame.getContentPane().add(enter);
        //Push the enter.
        enter.addActionListener(sentenceListener);

        // 
        textArea = new JTextArea("Your output will appear here...");
        textArea.setLineWrap(true);
        // textArea.setWrapStyleWord(true);
        
        jsp = new JScrollPane(textArea);

        panelOutput = new JPanel();
        panelOutput.setLayout(null);
        panelOutput.add(jsp);
        frame.getContentPane().add(panelOutput);

        // appear = new JLabel("Your output will appear here...");
        // appear.setOpaque(true);
        // appear.setBackground(Color.WHITE);
        // //Words are displayed from the top.
        // appear.setVerticalAlignment(SwingConstants.TOP);
        // frame.getContentPane().add(appear);

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
        panelOutput.setBounds(10, 10 + height/2, 1000, 600);
        jsp.setBounds(0, 0, 1000, 600);
        // appear.setBounds(10, 10 + height/2, 1000, 600);
        friend.setBounds(1100, 10 + height/2, 400, 700);
    }

    // formatting comment
    private String CommentFormat(String s){
        // get time(local)
        Calendar ca = Calendar.getInstance();
        int hour = ca.get(Calendar.HOUR_OF_DAY);
        int minute = ca.get(Calendar.MINUTE);

        String cf = "";
        cf = hour + ":" + minute + "  User  " + s + "\n";
        return cf;
    }


    // create Listener class and perform
    private class SentenceListener implements ActionListener {
        private int first = 1;
        public void actionPerformed(ActionEvent event) {

                comment = CommentFormat(textField.getText());

                if(first == 0){
                    textArea.append(comment);
                }else{
                    textArea.setText(comment);
                    first = 0;
                }
            }
        }
        
}
