import javax.swing.*;

public class Lab309 {
    public static void main(String[] args) {
        int price = 0;
        int answer = JOptionPane.showConfirmDialog(null, "Do you want to order menu?",
                "Yakitori Shop",
                JOptionPane.YES_NO_OPTION);
        int order=0;
        if (answer==0){
            do {
                order = Integer.parseInt(JOptionPane.showInputDialog(null,"Yakitori Menu" +
                    "\n[1] Chicken Wing 99 B." +
                    "\n[2] Pork with leek 89 B." +
                    "\n[3] Beef Tongue 109 B." +
                    "\n[0] Exit and Calculate" +
                    "\nEnter menu number :"));
                switch (order) {
                    case 1:price+=99;break;
                    case 2:price+=89;break;
                    case 3:price+=109;break;
                    case 0:break;
                }
            }while(order!=0);
           JOptionPane.showMessageDialog(null,"Total price is " + price + "Baht.");
        }
    }
}
