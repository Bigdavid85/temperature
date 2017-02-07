/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Temperature;
import temp_unit.temp_unit;

/**
 *
 * @author davide
 */

public class Temperature
{
    public Temperature(){ m_unit = temp_unit.CELSIUS; m_temp = 0.0;}
    public Temperature(temp_unit unit, double temp)
    {
               
        m_unit = unit; 
        m_temp = temp;
        
    };
    
    public void make_celsius()
    {
        if(m_unit != temp_unit.CELSIUS)
        {
            switch(m_unit)
            {
                case KELVIN:
                    kelvin_to_celsius();
                    break;
                case FAHRENHEIT:
                    fahrenheit_to_celsius();
                    break;
            }
        }
    }
    
    public void make_fahrenheit()
    {
        if(m_unit != temp_unit.FAHRENHEIT)
        {
            switch(m_unit)
            {
                case CELSIUS:
                    celsius_to_fahrenheit();
                    break; 
                case KELVIN:
                    kelvin_to_fahrenheit();
                    break;
            }
        }
    }
    
    public void make_kelvin()
    {
        if(m_unit != temp_unit.KELVIN)
        {
            switch(m_unit)
            {
                case CELSIUS:
                    celsius_to_kelvin();
                    break;
                case FAHRENHEIT:
                    fahrenheit_to_kelvin();
                    break;
                            
            }
        }
    }
    
    public void kelvin_to_celsius()
    {
        if(m_unit == temp_unit.KELVIN)
        {
            m_unit = temp_unit.CELSIUS;
            m_temp -= 273.15;
        }
    }
        
    
    public void kelvin_to_fahrenheit()
    {
        if(m_unit == temp_unit.KELVIN)
        {
            m_unit = temp_unit.FAHRENHEIT;
            m_temp = (m_temp * 1.8) - 459.67;
        }
    }
        
    public void celsius_to_kelvin()
    {
        if(m_unit == temp_unit.CELSIUS)
        {
            m_unit = temp_unit.KELVIN;
            m_temp += 273.15;
        }
    }
    
    public void celsius_to_fahrenheit()
    {
        if(m_unit == temp_unit.CELSIUS)
        {
            m_unit = temp_unit.FAHRENHEIT;
            m_temp = (m_temp * 1.8) - 32;
        }
    }
    
    public void fahrenheit_to_celsius()
    {
        if(m_unit == temp_unit.FAHRENHEIT)
        {
            m_unit = temp_unit.CELSIUS;
            m_temp = (m_temp - 32) / 1.8; 
        }
    }
    
    public void fahrenheit_to_kelvin()
    {
        if(m_unit == temp_unit.FAHRENHEIT)
        {
            m_unit = temp_unit.KELVIN;
            m_temp = (m_temp + 459.67) / 1.8;
        }
    }
    
    public Temperature get_temperature_celsius()
    {   
        Temperature temp = new Temperature();
        
        switch(m_unit)
        {
            case CELSIUS:
                return this;
            case FAHRENHEIT:
                fahrenheit_to_celsius();
                temp = new Temperature(get_unit(), get_temp());
                celsius_to_fahrenheit();
                break;
            case KELVIN:
                kelvin_to_celsius();
                temp = new Temperature(get_unit(), get_temp());
                celsius_to_kelvin();
                break;
        }
        
        return temp;
    }
    
    public Temperature get_temperature_fahrenheit()
    {
        Temperature tmp = new Temperature();
        switch(m_unit)
        {
            case CELSIUS:
                celsius_to_fahrenheit();
                tmp = new Temperature(get_unit(), get_temp());
                fahrenheit_to_celsius();
                break;
            case FAHRENHEIT:
                return this;
            case KELVIN:
                kelvin_to_fahrenheit();
                tmp = new Temperature(get_unit(), get_temp());
                fahrenheit_to_kelvin();
                break;
        }
        return tmp;
    }
    
    public Temperature get_temperature_kelvin()
    {
        Temperature tmp = new Temperature();
        switch(m_unit)
        {
            case CELSIUS:
                celsius_to_kelvin();
                tmp = new Temperature(get_unit(), get_temp());
                kelvin_to_celsius();
            case FAHRENHEIT:
                fahrenheit_to_kelvin();
                tmp = new Temperature(get_unit(), get_temp());
                kelvin_to_fahrenheit();
            case KELVIN:
                return this;
        }
        return tmp;
    }
    
    
    public void copy(Temperature tmp)
    {
        tmp = this;
    }
    
    public boolean high_than(Temperature tmp2)
    {
        if(m_unit == tmp2.get_unit())
        {
            if(m_temp >tmp2.get_temp())
                return true;
        }
        
        temp_unit t_objcet = this.get_unit();
        temp_unit t_temp2 = tmp2.get_unit();
        
        this.make_celsius();
        tmp2.make_celsius();
        boolean high;
        
        if(this.m_temp > tmp2.get_temp())
        {
            high = true;
        }
        else
        {
            high = false;
        }
        
        switch(t_objcet)
        {
            case FAHRENHEIT:
                this.make_fahrenheit();
                break;
            case KELVIN:
                this.make_kelvin();
                break;
        }
        
        switch(t_temp2)
        {
            case FAHRENHEIT:
                tmp2.make_fahrenheit();
                break;
            case KELVIN:
                tmp2.make_kelvin();
           
        }
        
        return high;
    }
    
     public boolean low_than(Temperature tmp2)
    {
        if(m_unit == tmp2.get_unit())
        {
            if(m_temp < tmp2.get_temp())
                return true;
        }
        
        temp_unit t_objcet = this.get_unit();
        temp_unit t_temp2 = tmp2.get_unit();
        
        this.make_celsius();
        tmp2.make_celsius();
        boolean low;
        
        if(this.m_temp < tmp2.get_temp())
        {
            low = true;
        }
        else
        {
            low = false;
        }
        
        switch(t_objcet)
        {
            case FAHRENHEIT:
                this.make_fahrenheit();
                break;
            case KELVIN:
                this.make_kelvin();
                break;
        }
        
        switch(t_temp2)
        {
            case FAHRENHEIT:
                tmp2.make_fahrenheit();
                break;
            case KELVIN:
                tmp2.make_kelvin();
           
        }
        
        return low;
    }
     
     public boolean equal(Temperature tmp2)
    {
        if(m_unit == tmp2.get_unit())
        {
            if(m_temp == tmp2.get_temp())
                return true;
        }
        
        temp_unit t_objcet = this.get_unit();
        temp_unit t_temp2 = tmp2.get_unit();
        
        this.make_celsius();
        tmp2.make_celsius();
        boolean equal;
        
        if(this.m_temp == tmp2.get_temp())
        {
            equal = true;
        }
        else
        {
           equal = false;
        }
        
        switch(t_objcet)
        {
            case FAHRENHEIT:
                this.make_fahrenheit();
                break;
            case KELVIN:
                this.make_kelvin();
                break;
        }
        
        switch(t_temp2)
        {
            case FAHRENHEIT:
                tmp2.make_fahrenheit();
                break;
            case KELVIN:
                tmp2.make_kelvin();
           
        }
        
        return equal;
    }
    
    public temp_unit get_unit()
    {
        return m_unit;
    }
    
    public double get_temp()
    {
        return m_temp;
    }
    
    public boolean set_temp(double temp)
    {
        m_temp = temp;
        return true;
    }
    
    public void print_temperature()
    {   
        
        System.out.print(m_temp);
        
        switch(m_unit)
        {
            case CELSIUS:
                System.out.println(" C° ");
                break;
            case FAHRENHEIT:
                System.out.println(" F° ");
            case KELVIN:
                System.out.println(" K ");
        }
    }
    
    private temp_unit m_unit;
    private Double m_temp;
}

