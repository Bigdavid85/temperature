/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package valid_input;
import temp_unit.temp_unit;
/**
 *
 * @author davide
 */
public class valid_input
{
    public valid_input(String input)
    {
    
    m_input = input;
    m_input_token = new Token[input.length()];
    m_index = 0;
    // type_of_input = new String[12];
   // type_of_input[0] = "integer_no_sign";
   // type_of_input[1] = "integer_no_sign_far";
   // type_of_input[2] = "integer_no_sign_cen";
   // type_of_input[3] = "integer_signed";
   // type_of_input[4] = "integer_signed_far";
   // type_of_input[5] = "integer_signed_cen";
   // type_of_input[6] = "float_no_sign";
   // type_of_input[7] = "float_no_sign_far";
   // type_of_input[8] = "float_no_sing_cen";
   // type_of_input[9] = "float_signed";
   // type_of_input[10] = "float_signed_far";
   // type_of_input[11] = "float_singned_cen";
    
   // m_valid_symbol = valid_symbol;
   //integer_no_sign = false;
    //integer_no_sign_far = false;
    //integer_no_sign_cen = false;
    //integer_signed = false;
    //integer_signed_far = false;
    //integer_signed_cen = false;
    //float_no_sign = false;
    //float_no_sign_far = false;
    //float_no_sign_cen = false;
    //float_signed = false;
    //float_signed_far = false;
    //float_signed_cen = false;
    //valid_input = false;
       
    }





private void tokenize_input(char crt, int index)
{
    int m_input_token_length = m_input_token.length;
            
    
    if(index >= 0 && index < m_input_token_length)
    {
     
        int num_con = char_to_number(crt);
    
      if(num_con != -1)
        {
            //m_input_token[index].type = type_of_data.NUMBER;
            //m_input_token[index].num = num_con;
            m_input_token[index] = new Token(type_of_data.NUMBER, ' ', num_con);
        }
        else
        {
            //m_input_token[index].type = type_of_data.CHARACTER;
            //m_input_token[index].crt = crt;
            m_input_token[index] = new Token(type_of_data.CHARACTER, crt, -1);
        }
    }
}


public boolean parse_input()
{
    int input_lenght = m_input.length();
    for(int i = 0; i < input_lenght; i++)
    {
        tokenize_input(m_input.charAt(i), i);
    }
    
    if(parse_sign())
    {
        if(!parse_number())
        {
            return false;
        }
        
        if(parse_unit())
            {
               return true; 
            }
        else
        {
            m_unit = temp_unit.CELSIUS;
            return true;
        }
    }
    
    if(parse_unit())
    {
        if(parse_number())
        {
            m_sign = '+';
            return true;
                               
        }
        else if(parse_sign())
        {
            if(parse_number())
            {
                m_unit = temp_unit.CELSIUS;
                return true;
            }
        }
    }
    
    if( parse_number() )
    {
        if(parse_unit())
        {   
            m_sign = '+';
            return true;
        }
    }
    
    return false;
}


private boolean parse_unit()
{

   String unit_c ="celsius";
   String unit_f = "fahrenheit";
   String unit_k = "kelvin";
   String unit = new String(); 
     
   boolean run = true;

   while(run)
   {
       Token tk = get_next_token();
       switch(tk.type)
       {
           case NUMBER:
               decrease_index();
               run = false;
               break;
           case CHARACTER:
                if(tk.crt == ' ')
                {
                  tk = get_next_token();
                }else if (tk.crt == '+' || tk.crt == '-')
                {
                    run = false;
                    decrease_index();
                }
                else
                {
                    unit += tk.crt;
                }
                break;
        }
    }
   
   if(unit == unit_c)
   {
       m_unit = temp_unit.CELSIUS;
       return true;
   }
   if(unit == unit_f)
   {
      m_unit = temp_unit.FAHRENHEIT;
      return true;
   }
   if(unit == unit_k)
   {
       m_unit = temp_unit.CELSIUS;
       return true;
   }
   
   if(unit == "c" || unit == "C")
   {
      m_unit = temp_unit.CELSIUS;
      return true;
   }
   
   if(unit == "k" || unit == "k")
   {
       m_unit = temp_unit.KELVIN;
       return true;
   }
   
   if(unit == "F" || unit == "F")
   {
       m_unit = temp_unit.FAHRENHEIT;
       return true;
   }
   
   m_unit = temp_unit.CELSIUS;
   return false;
   
}

           
  

private boolean parse_sign()
{
    if(m_input_token[m_index].type == type_of_data.CHARACTER)
    {
        if(m_input_token[m_index].crt == '-')
        {
            m_sign = '-';
            m_index++;
            return true;
        }
        if(m_input_token[m_index].crt == '+')
        {
            m_sign = '+';
            m_index++;
            return true;
        }
        return false;
    }
    return false;
}

private boolean parse_number()
{
    int [] number = new int [m_input_token.length];
    int [] decimal = new int [m_input_token.length];
    int ite_n = 0;
    int ite_d = 0;
    
    Token tk = get_next_token();
    
    if(tk.type == type_of_data.NUMBER && tk.num == -1 )
    {
        return false;
    }
    
    
    if(tk.type == type_of_data.CHARACTER)
    {
        decrease_index();
        return false;
    }
    
    number[ite_n] = tk.num;
        
    boolean run = true;
    boolean d = false; //decimal ?
    
    while(run)
    {
        tk = get_next_token();
        
        
        switch(tk.type)
        {
            case NUMBER:
                if(tk.num == -1)
                {
                   run = false;      
                }
                break;
            case CHARACTER:
                if(tk.crt == ',')
                {
                    run = false;
                    d = true;
                }
                else
                {
                    run = false;
                    decrease_index();
                }
                break;
        }
        
        if(run)
        {                        
            ite_n++;
            number[ite_n] = tk.num; 
          
        }
       
    }
     
    if(d)
    {
        tk = get_next_token();
        if(tk.type == type_of_data.NUMBER && tk.num == -1)
        {
            System.out.println("After semicolon numbers ara aspected");
            return false;
            
        }
        
        if( tk.type == type_of_data.CHARACTER )
        {
            System.out.println("Wrong input");
            return false;
            
        }
        
        decimal[ite_d] = tk.num;
                
        for(boolean r = true; r;)
        {
            tk = get_next_token();
            
            switch(tk.type)
            {
                case NUMBER:
                    if(tk.num == -1)
                    {
                        r = false;
                        
                    }
                    break;
                case CHARACTER:
                    r = false;
                    decrease_index();
                    break;
            }
            
            if(r)
            {
                ite_d++;
                decimal[ite_d] = tk.num;
                
            }
        }
        
    }
    
    
      
    for(int i = 0; ite_n >= 0; ite_n--, i++)
    {
         int ten_power = (int) pow(10, ite_n);
         m_number += number[i] * ten_power;
      
    }
    
    if(d)
    {
    
        double dec = 0.0; 
        int div= (int) pow(10, ite_d);
    
    
        for(int i = 0; ite_d >= 0; ite_d--, i++)
        {
            int ten_power = (int) pow(10, ite_d);
            dec += decimal[i] * ten_power;
        }
    
        m_number += (dec / div);
        
    }    
    
    return true;
            
}

public double pow(int b , int n)
{
    double power = b;
    if(n == 0)
    {
        return 1;
    }
    
    if(n == 1)
    {
        return b;
    }
    
    for(int i = 0; i < n; i++)
    {
        power *= b;  
    }
    
    return power;
}

private int char_to_number( char crt ) // return -1 if he can't convert a character to number
{
    switch(crt)
    {
        case '0':
            return 0;
        case '1':
            return 1;
        case '2':
            return 2;
        case '3':
            return 3;
        case '4':
            return 4;
        case '5':
            return 5;
        case '6':
            return 6;
        case '7':
            return 7;
        case '8':
            return 8;
        case '9':
            return 9;
        default:
            return -1;
    }
};
    

public double get_number()
{
    if(m_sign == '-')
        return -(m_number);
    else
        return m_number;
}

public temp_unit get_unit()
{
    return m_unit;
}

public Token get_next_token()
{   
    int index = get_next_index();
    
    if(index == -1)
    {
        return new Token(type_of_data.NUMBER, ' ', -1);
    }
    
    return m_input_token[index];
}

public Token get_prev_token()
{
    int index = get_prev_index();
    if(index == -1)
    {
        return new Token(type_of_data.NUMBER, ' ', -1);
    }
    
    return m_input_token[index];
}

private boolean decrease_index()
{
    if(m_index > 0)
    {
        m_index--;
        return true;
    }
    return false;
}

private boolean increase_index()
{
   int lenght = m_input_token.length;
   if(m_index < lenght)
   {
       m_index++;
       return true;
   }
   return false;
}

private int get_next_index()
{
    
    int lenght = m_input_token.length;
    
    if(m_index < lenght)
    {
        int t_index = m_index;
        
        if(!increase_index())
        {
            return -1;
        }
        return t_index;
    }
    return -1;
    
}

private int get_prev_index()
{
           
    if(!decrease_index())
    {
        return -1;
    }
    return m_index;
}

    private String m_input;
    private Token [] m_input_token;
    private int m_index;
    private double m_number;
    private temp_unit m_unit;
    private char m_sign;
    //private boolean integer_no_sign;
    //private boolean integer_no_sign_far;
    //private boolean integer_no_sign_cen;
    //private boolean integer_signed;
    //private boolean integer_signed_far;
    //private boolean integer_signed_cen;
    //private boolean float_no_sign;
    //private boolean float_no_sign_far;
    //private boolean float_no_sign_cen;
    //private boolean float_signed;
    //private boolean float_signed_far;
    //private boolean float_signed_cen;
    //private boolean valid_input;
    //private String [] type_of_input;
    //private String m_valid_symbol;
       
}

class Token
{
    Token(type_of_data t_d, char c, int n ){ type = t_d; crt = c; num = n;}
    Token(){crt = ' '; num = 0; type = type_of_data.CHARACTER;}
    public type_of_data type; //character or number
    public char crt; //charcter
    public int num; // number
}


enum type_of_data
{
    CHARACTER,
    NUMBER
}