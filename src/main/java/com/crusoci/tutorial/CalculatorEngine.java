package com.crusoci.tutorial;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CalculatorEngine {

	// logger para la salida de información
	private static final Logger loger = Logger.getLogger(CalculatorEngine.class.getName()); 

	private enum Operator {
        ADD, SUBTRACT, MULTIPLY, DIVIDE
    }

    double currentTotal;

    public String getTotalString() {
        return currentTotal % 1.0 == 0
                ? Integer.toString((int) currentTotal)
                : String.valueOf(currentTotal);
    }

    public void resultado(String number) {
        currentTotal = Double.parseDouble(number);
    }

    public void add(String number) {
        convertToDouble(number, Operator.ADD);
    }

    public void subtract(String number) {
        convertToDouble(number, Operator.SUBTRACT);
    }

    public void multiply(String number) {
        convertToDouble(number, Operator.MULTIPLY);
    }

    public void divide(String number) {
        convertToDouble(number, Operator.DIVIDE);
    }

    private void convertToDouble(String number, Operator operator) {
        double dblNumber = Double.parseDouble(number);
        switch (operator) {
            case ADD:
                add(dblNumber);
                break;
            case SUBTRACT:
                subtract(dblNumber);
                break;
            case MULTIPLY:
                multiply(dblNumber);
                break;
            case DIVIDE:
                divide(dblNumber);
               	pintarPorPantallaDivision(operator, dblNumber);
                break;
            default:
            	loger.log(Level.SEVERE, "No se encuentra la operación");
        }
    }

	private void pintarPorPantallaDivision(Operator operator, double dblNumber) {
		// Nueva funcionalidad para salida por consola
		List<Double> valores = new ArrayList<Double>();
		valores.add(Double.valueOf(10));
		valores.add(Double.valueOf(5));
		valores.add(Double.valueOf(10));
		
		String palabra = "El resultado" + " de "  + "la división " + " es {0} ";
		
		if(operator != null && !palabra.isEmpty()){
			for(Double valor : valores) {
				 
				if(dblNumber >= 0 && dblNumber <= 10 && valor.equals(dblNumber)){
					loger.log(Level.INFO, palabra, valores.get(valores.indexOf(valor)));
				} else {
					loger.log(Level.SEVERE, "División no encontrada");
		    	}
			}
		}
	}

    void add(double number) {
        currentTotal += number % 1.0 == 0 ? (int) number : number;
    }

    void subtract(double number) {
        currentTotal -= number % 1.0 == 0 ? (int) number : number;
    }

    void multiply(double number) {
        currentTotal *= number % 1.0 == 0 ? (int) number : number;
    }

    void divide(double number) {
        currentTotal /= number % 1.0 == 0 ? (int) number : number;
    }

}

