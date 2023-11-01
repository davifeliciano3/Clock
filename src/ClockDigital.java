import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class ClockDigital extends JFrame {
    private JLabel timeLabel;
    private JLabel dataLabel;
    public ClockDigital() {
        setTitle("Relógio Digital");
        setSize(600,300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);

        var painel = new JPanel();
        painel.setBorder(BorderFactory.createEmptyBorder(20,20,20,20));
        painel.setLayout( new BorderLayout());

        timeLabel = new JLabel();
        timeLabel.setFont(new Font("Arial",Font.PLAIN,60));
        timeLabel.setHorizontalAlignment(SwingConstants.CENTER);
        timeLabel.setVerticalAlignment(SwingConstants.CENTER);
        timeLabel.setForeground(Color.red);

        dataLabel = new JLabel();
        dataLabel.setFont(new Font("Arial",Font.PLAIN ,20));
        dataLabel.setHorizontalAlignment(SwingConstants.CENTER);
        dataLabel.setVerticalAlignment(SwingConstants.CENTER);
        dataLabel.setForeground(Color.WHITE);

        painel.add(timeLabel,BorderLayout.CENTER);
        painel.add(dataLabel,BorderLayout.SOUTH);

        painel.setBackground(Color.black);
        add(painel);

        var tempo = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                updateTimeAndDate();
            }

            private void updateTimeAndDate() {
                Calendar calendario = Calendar.getInstance();
                SimpleDateFormat formatacaoTempo = new SimpleDateFormat("HH:mm:ss");
                String temp = formatacaoTempo.format(calendario.getTime());

                SimpleDateFormat dataformatar = new SimpleDateFormat("EEE,MMM dd , yyyy");
                String data = dataformatar.format(calendario.getTime());

                timeLabel.setText(temp);
                dataLabel.setText(data);

            }
        });
        tempo.start();

    };
}
