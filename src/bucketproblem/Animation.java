package bucketproblem;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.*;
/**
 *
 * @author berkay
 */
public class Animation {

    private Timer t;
    private int count = 0;
    private int constraint = 100;

    public void paint(Graphics page, int target, int bucket1, int bucket2, ArrayList sequence) {
        if (bucket2 > 4) {
            constraint = 45;
        } else if (bucket2 > 5) {
            constraint = 25;
        } else if (bucket2 > 6) {
            constraint = 15;
        } else if (bucket2 > 7) {
            constraint = 5;
        }
        page.setColor(Color.white);
        page.fillRect(0, 0, 1000, 1000);
        t = new Timer(2000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                FrameBucketProblem.Label_Animation.setText(count + ". step of sequence " + sequence.get(count).toString());
                page.setColor(Color.white);
                page.fillRect(0, 0, 1000, 1000);
                page.setColor(Color.blue);
                if (sequence.size() == count) {
                    page.fillRect(25, 425 - (Integer.parseInt(sequence.get(count).toString().substring(0, 1)) * constraint), 200, Integer.parseInt(sequence.get(count).toString().substring(0, 1)) * constraint);
                    page.fillRect(325, 425 - (Integer.parseInt(sequence.get(count).toString().substring(2, 3)) * constraint), 200, Integer.parseInt(sequence.get(count).toString().substring(2, 3)) * constraint);
                    stop();
                } else {
                    page.fillRect(25, 425 - (Integer.parseInt(sequence.get(count).toString().substring(0, 1)) * constraint), 200, Integer.parseInt(sequence.get(count).toString().substring(0, 1)) * constraint);
                    page.fillRect(325, 425 - (Integer.parseInt(sequence.get(count).toString().substring(2, 3)) * constraint), 200, Integer.parseInt(sequence.get(count).toString().substring(2, 3)) * constraint);
                    count++;
                }
            }
        });
        start();
    }
    public void start() { t.start(); }
    public void stop() { t.stop(); }
    public boolean isTimeToStop() { return true; }
}