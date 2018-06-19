package com.rxhui.designpattern.memento;

/**
 * @author ppgeneve
 * @Description:
 * @Date 2018/6/19 09:51
 */
interface PreviousCalculationToOriginator {
    int getFirstNumber();
    int getSecondNumber();
}

class PreviousCalculationToOriginatorImpl implements PreviousCalculationToOriginator, PreviousCalculationToCareTaker{
    private int firstNumber;
    private int secondNumber;

    public PreviousCalculationToOriginatorImpl(int firstNumber, int secondNumber) {
        this.firstNumber = firstNumber;
        this.secondNumber = secondNumber;
    }

    @Override
    public int getFirstNumber() {
        return firstNumber;
    }

    @Override
    public int getSecondNumber() {
        return secondNumber;
    }
}

/**
 *  Memento interface to CalculatorOperator (Caretaker)
 */
interface PreviousCalculationToCareTaker {
    // no operations permitted for the caretaker
}

interface Calculator {
    PreviousCalculationToCareTaker backupLastCalculation();

    void restorePreviousCalculation(PreviousCalculationToCareTaker memento);

    int getCalculationResult();

    void setFirstNumber(int firstNumber);

    void setSecondNumber(int secondNumber);
}

class CalculatorImpl implements Calculator {
    private int firstNumber;
    private int secondNumber;


    @Override
    public PreviousCalculationToCareTaker backupLastCalculation() {
        return new PreviousCalculationToOriginatorImpl(firstNumber, secondNumber);
    }

    @Override
    public void restorePreviousCalculation(PreviousCalculationToCareTaker memento) {
        this.firstNumber = ((PreviousCalculationToOriginator) memento).getFirstNumber();
        this.secondNumber = ((PreviousCalculationToOriginator) memento).getSecondNumber();
    }

    @Override
    public int getCalculationResult() {
        return firstNumber + secondNumber;
    }

    @Override
    public void setFirstNumber(int firstNumber) {
        this.firstNumber = firstNumber;
    }

    @Override
    public void setSecondNumber(int secondNumber) {
        this.secondNumber = secondNumber;
    }
}

public class Memento {
    public static void main(String[] args) {
        Calculator calculator = new CalculatorImpl();

        // assume user enters two numbers
        calculator.setFirstNumber(10);
        calculator.setSecondNumber(100);

        // find result
        System.out.println(calculator.getCalculationResult());

        // Store result of this calculation in case of error
        PreviousCalculationToCareTaker memento = calculator.backupLastCalculation();

        // user enters a number
        calculator.setFirstNumber(17);

        // user enters a wrong second number and calculates result
        calculator.setSecondNumber(-290);

        // calculate result
        System.out.println(calculator.getCalculationResult());

        // user hits CTRL + Z to undo last operation and see last result
        calculator.restorePreviousCalculation(memento);

        // result restored
        System.out.println(calculator.getCalculationResult());
    }
}
