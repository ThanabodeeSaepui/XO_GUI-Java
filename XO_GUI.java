import javax.swing.*;
import java.awt.Font;
import java.awt.event.*;

public class XO_GUI {
    public static boolean X_turn = true;
    public static JFrame f = new JFrame();
    public static JLabel label = new JLabel();
    public static JButton b[] = new JButton[9];
    public static JButton restart = new JButton("restart");
    public static int count = 0;
    public static int width = 100, height = 100, padding = 20;
    public static void main(String[] args) {
        SetButton();
        SetLabel();
        update();
        int frame_height = (3 * height) + (6 * padding);
        int frame_width = (3 * width) + (5 * padding);
        
        f.setSize(frame_width, frame_height+60);
        f.setLayout(null);
        f.setVisible(true);
    }

    public static void SetButton() {
        for (int i = 0; i < 9; i++) {
            final int x = i;
            b[i] = new JButton(" ");

            int x_axis = padding + (i % 3) * (width + padding);
            int y_axis = padding + (i / 3) * (width + padding);
            b[i].setBounds(x_axis, y_axis, width, height); // x axis, y axis, width, height
            b[i].setFont(new Font("Verdana", Font.PLAIN, 80));
            b[i].addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    if (b[x].getText() == " ") {
                        if (X_turn) {
                            b[x].setText("X");
                        } else {
                            b[x].setText("O");
                        }
                        count++;
                        X_turn = !X_turn;
                        update();
                    }
                }
            });
            f.add(b[i]);
        }
        restart.setVisible(false);
        restart.setText("RESTART");
        restart.setBounds(260, 380, 120, 45); // x axis, y axis, width, height
        restart.setFont(new Font("Verdana", Font.PLAIN, 16));
        restart.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                for (int i = 0;i < 9;i++) {
                    b[i].setEnabled(true);
                    b[i].setText(" ");
                    count = 0;
                }
                restart.setVisible(false);
                X_turn = true;
                label.setText("X turn");
            }
        });
        f.add(restart);
    }

    public static void SetLabel() {
        label.setFont(new Font("Verdana", Font.PLAIN, 26));
        label.setBounds((400-width)/2, 350, 100, width); // x axis, y axis, width, height
        f.add(label);
    }
    public static void update() {
        if (check()[0]){
            for (int i = 0;i < 9;i++) {
                b[i].setEnabled(false);
            }
            restart.setVisible(true);
            if (check()[1]) {
                label.setText("Draw");
                return;
            }
            if (!X_turn) {
                label.setText("X win");
            } else {
                label.setText("O win");
            }
        } else {
            if (X_turn) {
                label.setText("X turn");
            } else {
                label.setText("O turn");
            }
        }
    }
    public static boolean[] check() {
        boolean[] ans = {false, false};
        if (b[0].getText() == b[1].getText() && b[0].getText() == b[2].getText() && b[0].getText() != " ") {
            ans[0] = true;ans[1] = false;
            return ans;
        }
        else if (b[3].getText() == b[4].getText() && b[3].getText() == b[5].getText() && b[3].getText() != " ") {
            ans[0] = true;ans[1] = false;
            return ans;
        }
        else if (b[6].getText() == b[7].getText() && b[6].getText() == b[8].getText() && b[6].getText() != " ") {
            ans[0] = true;ans[1] = false;
            return ans;
        }
        else if (b[0].getText() == b[3].getText() && b[0].getText() == b[6].getText() && b[0].getText() != " ") {
            ans[0] = true;ans[1] = false;
            return ans;
        }
        else if (b[1].getText() == b[4].getText() && b[1].getText() == b[7].getText() && b[1].getText() != " ") {
            ans[0] = true;ans[1] = false;
            return ans;
        }
        else if (b[2].getText() == b[5].getText() && b[2].getText() == b[8].getText() && b[2].getText() != " ") {
            ans[0] = true;ans[1] = false;
            return ans;
        }
        else if (b[0].getText() == b[4].getText() && b[0].getText() == b[8].getText() && b[0].getText() != " ") {
            ans[0] = true;ans[1] = false;
            return ans;
        }
        else if (b[2].getText() == b[4].getText() && b[2].getText() == b[6].getText() && b[2].getText() != " ") {
            ans[0] = true;ans[1] = false;
            return ans;
        } else if (count == 9) {
            ans[0] = true;ans[1] = true;
        }
        return ans;
    }
}
