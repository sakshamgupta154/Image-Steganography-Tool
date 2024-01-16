/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package imageoperation;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.TextField;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author Saksham
 */
public class ImageOperation {

    
    
    
    public static void operate(int key){
        
        JFileChooser filechooser = new JFileChooser();
        filechooser.showOpenDialog(null);
        File file = filechooser.getSelectedFile();
        
        //file input stream
        
        try{
            
            FileInputStream fis = new FileInputStream(file);
            
            byte data[] = new byte[fis.available()]; 
            fis.read(data);
            
            int i = 0;
            for(byte b : data){
                System.out.println(b);
                data[i] = (byte)(b^key);
                i++;
            }
            
            FileOutputStream fos = new FileOutputStream(file);
            fos.write(data);
            fos.close();
            fis.close();
            
            JOptionPane.showMessageDialog(null, "Done");
            
            
            
        }
        catch(Exception e){
        e.printStackTrace();
        }
    }
        
        
    public static void main(String[] args) {
         
        
        JFrame f = new JFrame();
        
        f.setTitle("Image Encryptor/Decryptor");
        f.setSize(960,540);
        f.setLocationRelativeTo(null);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
         Font font = new Font("Roboto", Font.BOLD,16);
         
       
            //cereating button
            
            JButton button = new JButton();
            button.setText("Open Image");
            button.setFont(font);
            
            
           
            // creating text field 
            
            JTextField textfield = new JTextField(10);
            textfield.setFont(font);
             
            button.addActionListener(e->{
                
                String text = textfield.getText();
                
                int temp = Integer.parseInt(text);
                operate(temp);
                
            
            });
            
            
            
        f.setLayout(new FlowLayout());
        f.add(button);
        f.add(textfield);
        f.setVisible(true);
        f.setBackground(Color.darkGray);
        f.setForeground(Color.DARK_GRAY);
        
        
        
    }
    
}
