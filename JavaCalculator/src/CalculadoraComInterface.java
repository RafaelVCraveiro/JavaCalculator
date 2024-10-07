
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class CalculadoraComInterface implements ActionListener {
    JFrame frame;
    JTextField textfield;
    JButton[] BotaoNumeros = new JButton[10];
    JButton[] BotaoFuncao = new JButton[8];
    JButton addBotao, subBotao, mulBotao, divBotao;
    JButton decBotao, equBotao, delBotao, clrBotao;
    JPanel panel;
    
    Font fonte = new Font("Dialog",Font.PLAIN,30);
    
    double num1 = 0 ;
    double num2 = 0;
    double resultado = 0;
    char operacao;
    
    
    
    
    
    CalculadoraComInterface(){
       
        
        frame = new JFrame("Calculadora");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(420, 550);
        frame.setLayout(null);
        frame.getContentPane().setBackground(Color.black);
        
        
        textfield = new JTextField();
        textfield.setBounds(50, 25, 300, 50);
        textfield.setFont(fonte);
        textfield.setEditable(false);
        
        addBotao = new JButton("+");
        subBotao = new JButton("-");
        mulBotao = new JButton("*");
        divBotao = new JButton("/");
        decBotao = new JButton(".");
        equBotao = new JButton("=");
        delBotao = new JButton("Deletar");
        clrBotao = new JButton("Limpar");
        
        BotaoFuncao[0] = addBotao;
        BotaoFuncao[1] = subBotao;
        BotaoFuncao[2] = mulBotao;
        BotaoFuncao[3] = divBotao;
        BotaoFuncao[4] = decBotao;
        BotaoFuncao[5] = equBotao;
        BotaoFuncao[6] = delBotao;
        BotaoFuncao[7] = clrBotao;
        
        for(int i = 0; i<8;i++){
            BotaoFuncao[i].addActionListener(this);
            BotaoFuncao[i].setFont(fonte);
            BotaoFuncao[i].setFocusable(false);
        }
        
        for(int i = 0; i<10;i++){
            BotaoNumeros[i] = new JButton(String.valueOf(i));
            BotaoNumeros[i].addActionListener(this);
            BotaoNumeros[i].setFont(fonte);
            BotaoNumeros[i].setFocusable(false);
        }
        
        delBotao.setBounds(50,430,145,50);
        clrBotao.setBounds(205,430,145,50);
        
        panel = new JPanel();
        panel.setBounds(50, 100, 300, 300);
        panel.setLayout(new GridLayout(4,4,10,10));
        
        
        panel.add(BotaoNumeros[1]);
        panel.add(BotaoNumeros[2]);
        panel.add(BotaoNumeros[3]);
        panel.add(addBotao);
        panel.add(BotaoNumeros[4]);
        panel.add(BotaoNumeros[5]);
        panel.add(BotaoNumeros[6]);
        panel.add(subBotao);
        panel.add(BotaoNumeros[7]);
        panel.add(BotaoNumeros[8]);
        panel.add(BotaoNumeros[9]);
        panel.add(mulBotao);
        panel.add(decBotao);
        panel.add(BotaoNumeros[0]);
        panel.add(equBotao);
        panel.add(divBotao);
        panel.setBackground(Color.black);
        
        
        
        
        frame.add(panel);
        frame.add(delBotao);
        frame.add(clrBotao);
        frame.add(textfield);
        frame.setVisible(true);
        
        
        
    }
    public static void main (String args[]){
        CalculadoraComInterface calc = new CalculadoraComInterface();
        
        
    }
    @Override
    public void actionPerformed(ActionEvent e) {
    
    
        
        
        
        
        
        
        
        for(int i=0;i<10;i++){
            if(e.getSource() == BotaoNumeros[i]){
                textfield.setText(textfield.getText().concat(String.valueOf(i)));
            }
            
        }
        
        if(e.getSource()==decBotao){
            textfield.setText(textfield.getText().concat("."));
        }
        
        if(e.getSource()==addBotao){
            num1 = Double.parseDouble(textfield.getText());
            operacao = '+';
            textfield.setText("");
        }
        if(e.getSource()==subBotao){
            num1 = Double.parseDouble(textfield.getText());
            operacao = '-';
            textfield.setText("");
        }
        if(e.getSource()==mulBotao){
            num1 = Double.parseDouble(textfield.getText());
            operacao = '*';
            textfield.setText("");
        } 
        if(e.getSource()==divBotao){
            num1 = Double.parseDouble(textfield.getText());
            operacao = '/';
            textfield.setText("");
        }
        if(e.getSource()==equBotao){
            num2=Double.parseDouble(textfield.getText());
            
            switch (operacao) {
            case '+':
                resultado = num1 + num2;
                break;
                
            case '-':
                resultado = num1 - num2;
                break;
                
            case '*':
                resultado = num1 * num2;
                break;
                
            case '/':
                resultado = num1 / num2;
                break;
                
            }
        textfield.setText(String.valueOf(resultado));
        num1 = resultado;
        }
        if(e.getSource()==clrBotao){
            textfield.setText("");
            
        }
        if(e.getSource()==delBotao){
            String string = textfield.getText();
            textfield.setText("");
            for(int i =0;i<string.length()-1;i++){
                textfield.setText(textfield.getText()+string.charAt(i));
                
                
                
            }
            
        }
    }
}
