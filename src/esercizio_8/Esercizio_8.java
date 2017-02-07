


/*private void detect_type_input(char crt, int index)
{
 
    tokenize_input(crt, index);
    
    if(index == (m_input.length() - 1))
    {
        
        
    }
    
};
*/

   /* 
    public String get_type_of_input(){
        if(is_valid())
        {
            if(integer_no_sign)
            {
                return type_of_input[0];
            }
            
            if(integer_no_sign_far)
            {
                return type_of_input[1];
            }
            
            if(integer_no_sign_cen)
            {
                return type_of_input[2];
            }
            
            if(integer_signed)
            {
                return type_of_input[3];
            }
            
            if(integer_signed_far)
            {
                return type_of_input[4];
            }
            
            if(integer_signed_cen)
            {
                return type_of_input[5];
            }
            
            if(float_no_sign)
            {
                return type_of_input[6];
            }
            
            if(float_no_sign_far)
            {
                return type_of_input[7];
            }
            
            if(float_no_sign_cen)
            {
                return type_of_input[8];
            }
            
            if(float_signed)
            {
                return type_of_input[9];
            }
            
            if(float_signed_far)
            {
                return type_of_input[10];
            }
            if(float_signed_cen)
            {
                return type_of_input[11];
            }
            
        }
            return "invalid";
            };
    
    public boolean is_valid()
    {
        int index = 0; //input index
        int lenght = m_input.length(); // lenght input
        if(lenght == 0)
        {
           return valid_input;
        }
                        
        
        
        
        
        return valid_input;
    };
    */

/*
private boolean detect_type_of_input()
{
    final int input_lenght = m_input_token.length;
     char temp; // f o c o ' ';
     char sign; // + - o ' ';
     String type_of_number = "integer";
    for(int i = 0; i < input_lenght; i++)
    {
      int number_of_sign = 0;
      int number_of_comma = 0;
      int number_of_temp = 0;
      
      switch(m_input_token[i].type)
      {
                        
          case CHARACTER:
              switch(m_input_token[i].crt)
              {
                  case '-':
                      sign = '-';
                      number_of_sign++;
                      if(number_of_sign > 1)
                      {
                          valid_input = false;
                          return true;
                      }
                      break;
                  case '+':
                      sign = '+';
                      number_of_sign++;
                      if(number_of_sign > 1)
                      {
                          valid_input = false;
                          return true;
                      }
                      break;
                  case ',':
                    type_of_number = "float";
                    number_of_comma++;
                    if(number_of_comma > 1)
                    {
                        valid_input = false;
                        return true;
                    }
                   break;
                  case 'f':
                  case 'F':
                      temp = 'f';
                      number_of_temp++;
                      if(number_of_temp > 1)
                      {
                          valid_input = false;
                          return true;
                      }
                  case 'c':
                  case 'C':
                      temp = 'c';
                      number_of_temp++;
                      if(number_of_temp > 1)
                      {
                          valid_input = false;
                          return true;
                      }
              }
      }
               
    }
    
}
*/

/*   
private boolean control_symbol()
{
    int index = 0;
    final int length_input = m_input.length();
    final int length_val_sib = m_valid_symbol.length();
    while(index < length_input)
    {
        for(int i = 0; i < length_val_sib; i++)
        {
          if(m_input.charAt(index) == m_valid_symbol.charAt(i))
          {
              break;
          }
          return false;
        }
                     
        index++;
    }
    return true;
};
*/



/*
8) Scrivere un programma che permetta l’inserimento di un insieme di 10 temperature, e calcolare e stampare la massima, la minima e la media
VARIANTE1: inserire temperature fin quando l'utente non inserisce ZERO
VARIANTE2: calcolare e stampare quante sono positive e quante sottozero

 */
package esercizio_8;
import java.io.*;
import Temperature.Temperature;
import valid_input.valid_input;
        
/**
 *
 * @author utente
 */




public class Esercizio_8 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
       
     complex_exercise();
        
    }
    
   static void simple_exercise() throws IOException
   {
        final int NUMBER = 10; // Numero di temperature
        double somma_temperature = 0;
        double temperatura_minima = 0;
        double temperatura_massima = 0;
               
        BufferedReader keyboard = new BufferedReader(new InputStreamReader(System.in));
        
        System.out.println("Digita la temparatura numero 1 :");
        temperatura_minima = temperatura_massima = Double.parseDouble(keyboard.readLine());
        somma_temperature = temperatura_minima;
        
        for(int i = 1; i < NUMBER; i++)
        {
            double temperatura = 0;
            System.out.println("Digita la temperatura numero " + (i+1) + ":");
            temperatura = Double.parseDouble(keyboard.readLine());
            somma_temperature += temperatura;
            if(temperatura_minima > temperatura)
            {
                temperatura_minima = temperatura;
            }else if( temperatura_massima < temperatura )
            {
                temperatura_massima = temperatura;
            }
                       
        }
        System.out.println("La temperatura minima digitata è  " + temperatura_minima);
        System.out.println("La temperatura massima digitata è " + temperatura_massima);// TODO code application logic here
        System.out.println("La temperatura media è " + somma_temperature / NUMBER );
       
   }
    
   static void complex_exercise() throws IOException
   {
        String input; // Numero di temperature
        double somma_temperature_celsius = 0;
        double somma_temperature_kelvin = 0;
        double somma_temperature_fahrenheit = 0;
        valid_input v_i;
        
        Temperature temperatura_minima; 
        Temperature temperatura_massima;
        
        boolean run = true;
        
        BufferedReader keyboard = new BufferedReader(new InputStreamReader(System.in));
        
        System.out.println("Digita la temparatura numero 1 :");
        input = keyboard.readLine();
        v_i = new valid_input(input);
        if(v_i.parse_input())
        {
           System.out.println("Error: Illegal expression.");
           return;
        }
        double power = v_i.parse_input(10, 2);
        
        temperatura_minima = new Temperature(v_i.get_unit(), v_i.get_number());
        //temperatura_minima.copy(temperatura_minima);
        temperatura_minima.print_temperature();
        
        //somma_temperature = temperatura_minima;
        
        /*
        for(int i = 1; run; i++)
        {
            double temperatura = 0;
            System.out.println("Digita la temperatura numero " + (i+1) + ":");
            
            temperatura = Double.parseDouble(keyboard.readLine());
            somma_temperature += temperatura;
            if(temperatura_minima > temperatura)
            {
                temperatura_minima = temperatura;
            }else if( temperatura_massima < temperatura )
            {
                temperatura_massima = temperatura;
            }
                       
        }
        System.out.println("La temperatura minima digitata è  " + temperatura_minima);
        System.out.println("La temperatura massima digitata è " + temperatura_massima);// TODO code application logic here
        System.out.println("La temperatura media è " + somma_temperature / NUMBER );
        */
    }
}

