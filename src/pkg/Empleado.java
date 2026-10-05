package pkg;

public class Empleado {

    public float calculoNominaBruta(TipoEmpleado tipo, float ventasMes, float horasExtra) {
        float salarioBase = 0f;
        float primaVentas = 0f;
        float pagoHorasExtra = 0f;
        
        if (tipo == TipoEmpleado.vendedor) {
        	salarioBase = 2000f;
        } else if (tipo == TipoEmpleado.encargado) {
        	salarioBase = 2500f;
        }
        
        if (ventasMes >= 1500f) {
        	primaVentas = 200f;
        }else if (ventasMes >= 1000f) {
        	primaVentas = 100f;
        }
        
        pagoHorasExtra = horasExtra * 30f;
        return salarioBase + primaVentas + pagoHorasExtra;
    }
    
    public float calculoNominaNeta(float nominaBruta) {
        float retencion = 0f;

        if (nominaBruta >= 2500f) {
            retencion = 0.18f;
        } else if (nominaBruta >= 2100f) {
            retencion = 0.15f;
        } else {
            retencion = 0f;
        }

        return nominaBruta * (1 - retencion);
    }
}
        

      