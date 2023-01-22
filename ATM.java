import javax.swing.*;
import java.awt.*;
import java.util.Objects;

public class ATM {
    public static void main(String[] args){
        start obj = new start();
    }
    private static final JTextField new_pin = new JTextField(),
            acc_name = new JTextField(),
            acc_pin = new JTextField(),
            reg_name = new JTextField(),
            deposit_amt = new JTextField(),
            withdraw_amt = new JTextField();
    private static final String initial_pin = "0000";
    private static String pin3,regd_name;
    private static int new_money = 0 ;

    static class start extends JFrame{
        public start(){
            JButton enter = new JButton("Login"), enter2 = new JButton("Register");
            enter.addActionListener(e -> {
                new login();
                dispose();
            });

            enter2.addActionListener(e -> {
                new register();
                dispose();
            });
            setTitle("Welcome!");
            JPanel panel1 = new JPanel();
            JLabel welcome = new JLabel("WELCOME!");
            add(panel1);
            setVisible(true);
            panel1.setLayout(null);
            setResizable(false);
            setLocationRelativeTo(null);
            setSize(300, 300);
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            panel1.add(welcome);
            welcome.setBounds(110,10,120,30);
            panel1.add(enter);
            enter.setBounds(90,40,100,20);
            panel1.add(enter2);
            enter2.setBounds(90,80,100,20);
        }
    }
    static class main_gui extends JFrame{
        public main_gui(){
            JPanel panel4 = new JPanel();
            JButton balance = new JButton("Check Balance"), wthdrw = new JButton("Withdraw"), depo = new JButton("Deposit"), chng_pin = new JButton("Change Pin"), out = new JButton("Logout");
            wthdrw.addActionListener(e -> {
                new withdraw();
                dispose();
            });
            depo.addActionListener(e -> {
                new deposit();
                dispose();
            });
            chng_pin.addActionListener(e -> {
                new change_pin();
                dispose();
            });
            balance.addActionListener(e -> {
                new check_balance();
                dispose();
            });
            out.addActionListener(e -> {
                new start();
                dispose();
            });
            add(panel4);
            setTitle(regd_name + "'s bank account");
            setVisible(true);
            setSize(300, 300);
            setResizable(false);
            setLocationRelativeTo(null);
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            panel4.setLayout(null);
            panel4.add(balance);
            balance.setBounds(70,20,150,20);
            panel4.add(wthdrw);
            wthdrw.setBounds(95,60,100,20);
            panel4.add(depo);
            depo.setBounds(95,100,100,20);
            panel4.add(chng_pin);
            chng_pin.setBounds(95,140,100,20);
            panel4.add(out);
            out.setBounds(95,180,100,20);
        }
    }
    static class register extends JFrame{
        public register(){
            JPanel panel3 = new JPanel();
            JLabel ent_reg_nm = new JLabel("Name:");
            JButton submit4 = new JButton("Submit");
            submit4.addActionListener(e -> {
                String slot = reg_name.getText();
                if (slot == null) {
                    JOptionPane.showMessageDialog(null,"Invalid Input!");
                } else {
                    regd_name = slot;
                    reg_name.setText("");
                    new start();
                    dispose();
                    JOptionPane.showMessageDialog(null, "Registered Successfully! Your Partial Pin is 0000");
                }
            });
            JButton cancel = new JButton("Cancel");
            cancel.addActionListener(e -> {
                dispose();
                new start();
                reg_name.setText("");
            });
            add(panel3);
            setSize(300, 300);
            setResizable(false);
            setTitle("Register");
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            setVisible(true);
            setLocationRelativeTo(null);
            panel3.setLayout(null);
            reg_name.setPreferredSize(new Dimension(100,40));
            panel3.add(ent_reg_nm);
            ent_reg_nm.setBounds(10,80,120,30);
            panel3.add(reg_name);
            reg_name.setBounds(80,80,120,30);
            panel3.add(submit4);
            submit4.setBounds(75,120,100,20);
            panel3.add(cancel);
            cancel.setBounds(75,150,100,20);
        }
    }
    static class deposit extends JFrame {
        public deposit(){
            JPanel panel5 = new JPanel();
            JButton submit4 = new JButton("Confirm Deposit");
            JLabel depo_amt = new JLabel("Enter Deposit Amount:");
            submit4.addActionListener(e -> {
                int money = Integer.parseInt(deposit_amt.getText());
            if ( money > 0 ){
                    new main_gui();
                    deposit_amt.setText("");
                    dispose();
                    new_money = new_money + money;
                    JOptionPane.showMessageDialog(null,"Success");
                }else{
                JOptionPane.showMessageDialog(null,"Invalid Deposit");
                }
            });
            JButton cancel = new JButton("Cancel");
            cancel.addActionListener(e -> {
                dispose();
                new main_gui();
                deposit_amt.setText("");
            });
            add(panel5);
            setVisible(true);
            setSize(350, 300);
            setTitle("Deposit");
            setResizable(false);
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            setLocationRelativeTo(null);
            panel5.setLayout(null);
            panel5.add(depo_amt);
            depo_amt.setBounds(10,80,140,20);
            panel5.add(deposit_amt);
            deposit_amt.setBounds(150,80,140,20);
            panel5.add(submit4);
            submit4.setBounds(80,120,130,20);
            panel5.add(cancel);
            cancel.setBounds(95,150,100,20);
        }
    }
    static class withdraw extends JFrame{
        public withdraw(){
            JPanel panel6 = new JPanel();
            JLabel wth_amt = new JLabel("Enter Withdrawal Amount:");
            JButton submit2 = new JButton("Confirm Withdraw");
            submit2.addActionListener(e -> {
                int money_out = Integer.parseInt(withdraw_amt.getText());
                if (money_out < new_money){
                    new_money = new_money - money_out;
                    JOptionPane.showMessageDialog(null,"Success!");
                    withdraw_amt.setText("");
                }else if(money_out > new_money){
                    JOptionPane.showMessageDialog(null,"Insufficient Balance");
                }
            });
            JButton cancel = new JButton("Cancel");
            cancel.addActionListener(e -> {
                withdraw_amt.setText("");
                dispose();
                new main_gui();
            });
            add(panel6);
            setVisible(true);
            setSize(400, 300);
            setResizable(false);
            setTitle("Withdraw");
            setLocationRelativeTo(null);
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            panel6.setLayout(null);
            panel6.add(wth_amt);
            wth_amt.setBounds(10,80,150,20);
            panel6.add(withdraw_amt);
            withdraw_amt.setBounds(180,80,150,20);
            panel6.add(submit2);
            submit2.setBounds(120,110,150,20);
            panel6.add(cancel);
            cancel.setBounds(140,140,100,20);
        }
    }
    static class check_balance extends JFrame{
        public check_balance(){
            JPanel panel7 = new JPanel();
            JLabel bal = new JLabel("Your balance is: "+new_money);
            JButton retrn = new JButton("Return");
            retrn.addActionListener(e -> {
                new main_gui();
                dispose();
            });
            add(panel7);
            setVisible(true);
            setResizable(false);
            setTitle("Check Balance");
            setSize(300, 300);
            setLocationRelativeTo(null);
            panel7.setLayout(null);
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            panel7.add(bal);
            bal.setBounds(80,50,100,20);
            panel7.add(retrn);
            retrn.setBounds(80,90,120,20);
        }
    }
    static class change_pin extends JFrame{
        public change_pin(){
            JPanel panel8 = new JPanel();
            JLabel nw_pn = new JLabel("Enter New Pin:");
            JButton chng_pin = new JButton("Change Pin");
            String pin = new_pin.getText();
            chng_pin.addActionListener(e -> {
                if(!Objects.equals(pin, initial_pin)){
                    pin3 = pin;
                    dispose();
                    new main_gui();
                    new_pin.setText("");
                    JOptionPane.showMessageDialog(null,"Successfully Changed");
                }else{
                    JOptionPane.showMessageDialog(null, "Pin is Used");
                }
            });
            JButton cancel = new JButton("Return");
            cancel.addActionListener(e -> {
                new main_gui();
                new_pin.setText("");
                dispose();
            });
            add(panel8);
            setVisible(true);
            setSize(300, 300);
            setResizable(false);
            setTitle("Change Pin");
            setLocationRelativeTo(null);
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            new_pin.setPreferredSize(new Dimension(100,20));
            panel8.add(nw_pn);
            panel8.add(new_pin);
            panel8.add(chng_pin);
            panel8.add(cancel);
        }
    }
    static class login extends JFrame   {
        public login (){
            JButton submit = new JButton("Login"), back = new JButton("Back");
            JLabel ent_nm = new JLabel("Enter Name:"), ent_pin = new JLabel("Enter Pin:");
            JPanel panel2 = new JPanel();
            add(panel2);
            submit.addActionListener(e -> {
                String name = acc_name.getText();
                String pin = acc_pin.getText();
                if (pin.equals(initial_pin)&& Objects.equals(regd_name, name)) {
                    new main_gui();
                    acc_pin.setText("");
                    acc_name.setText("");
                    dispose();
                    JOptionPane.showMessageDialog(null, "Login Success!");
                } else if (pin.equals(pin3) && Objects.equals(regd_name, name)) {
                    new main_gui();
                    acc_pin.setText("");
                    acc_name.setText("");
                    dispose();
                    JOptionPane.showMessageDialog(null, "Login Success!");
                } else {
                    JOptionPane.showMessageDialog(null, "Wrong Account Name/Pin");
                }
            });
            back.addActionListener(e -> {
                dispose();
                new start();
                acc_pin.setText("");
                acc_name.setText("");
            });

            setSize(300,300);
            setTitle("Login");
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            setVisible(true);
            setResizable(false);
            setLocationRelativeTo(null);
            panel2.setLayout(null);
            panel2.add(ent_nm);
            ent_nm.setBounds(20,80,100,25);
            panel2.add(ent_pin);
            ent_pin.setBounds(20,100,100,25);
            panel2.add(acc_name);
            acc_name.setBounds(100,80,100,20);
            panel2.add(acc_pin);
            acc_pin.setBounds(100,105,100,20);
            panel2.add(submit);
            submit.setBounds(80,140,100,20);
            panel2.add(back);
            back.setBounds(80,170,100,20);
        }
    }
}