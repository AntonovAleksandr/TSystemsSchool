package tasks.calculator;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Stack;

public class Calculator {

    /**
     * Evaluate statement represented as string.
     *
     * @param statement mathematical statement containing digits, '.' (dot) as decimal mark,
     *                  parentheses, operations signs '+', '-', '*', '/'<br>
     *                  Example: <code>(1 + 38) * 4.5 - 1 / 2.</code>
     * @return string value containing result of evaluation or null if statement is invalid
     */
    public String evaluate(String statement) {
        if(statement==null) return null;

         Double result = readPN(convertToPN(statement));
        return formatter(result);
    }

    private String formatter(Double doub){
        Locale.setDefault(Locale.US);
        if(doub == null){ return  null;}
        DecimalFormat decimalFormat = new DecimalFormat("#.####");
        if(doub == doub.intValue()) {
            return String.valueOf(doub.intValue());
        }
        return decimalFormat.format(doub);
    }

    private List<String> convertToPN(String statement){
        String[] strings = statement.split("");
        List<String> result = new ArrayList<String>();

        StringBuilder newOperand = new StringBuilder();
        Stack<String> stack = new Stack<String>();

        boolean isDabbleOp = false;
        int bracketsFlag = 0;

        for (String str:strings) {
            if(str.matches("[0-9]")){
                newOperand.append(str);
                isDabbleOp = false;

            } else  if(str.equals(".")) {
                if(isDabbleOp == true) return null;
                newOperand.append(str);
                isDabbleOp = true;

            } else if(str.matches("[-+*/]")){

                if(isDabbleOp == true) return null;

                result.add(newOperand.toString());
                newOperand.setLength(0);
                isDabbleOp = true;

                while (!stack.empty() && operationCompare(stack.peek(), str) >= 0){
                    result.add(stack.pop());
                }
                stack.push(str);

            } else if(str.equals("(")){
                stack.push(str);
                bracketsFlag++;
                result.add(newOperand.toString());
                newOperand.setLength(0);

            } else if(str.equals(")")){
                result.add(newOperand.toString());
                newOperand.setLength(0);
                bracketsFlag--;

                while (true){
                    if(stack.empty()){
                        return null;
                    }
                    String stackElement = stack.pop();
                    if(stackElement.equals("(")){
                        break;
                    }
                    result.add(stackElement);
                }
            } else return null;
        }
        if (bracketsFlag!=0){return null;}

        result.add(newOperand.toString());

        while (!stack.empty())
            result.add(stack.pop());
        return result;
    }

    private int operationCompare(String op1, String op2) {
        if(op1.matches("[*/]")  &&  op2.matches("[-+]")){
            return 1;
        } else if ((op1.matches("[*/]")  &&  op2.matches("[*/]")) ||(op1.matches("[-+]")  &&  op2.matches("[-+]"))){
            return 0;
        } else return  -1;
    }

    private Double readPN(List<String> statement){
        if(statement==null) return null;
        Stack<String> stack = new Stack<String>();

        for (String str:statement) {
            if (str.matches("\\d+.?\\d*")) {
                stack.push(str);
            } else if(str.matches("[-+*/]") && stack.capacity()>1) {
                double res;
                double y = Double.parseDouble(stack.pop());
                double x = Double.parseDouble(stack.pop());
                switch (str) {
                    case ("+"): {
                        res = x + y;
                        stack.push(String.valueOf(res));
                        break;
                    }
                    case ("-"): {
                        res =  x - y;
                        stack.push(String.valueOf(res));

                        break;
                    }
                    case ("*"): {
                        res = x * y;
                        stack.push(String.valueOf(res));
                        break;
                    }
                    case ("/"): {
                        if(y == 0){return null;}
                        res = x / y;
                        stack.push(String.valueOf(res));
                        break;
                    }
                }
            }
        }
        Double result = Double.valueOf(stack.pop());
        return result;
    }
}