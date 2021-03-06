package com.rxhui.designpattern.interpreter;

import java.util.StringTokenizer;

/**
 * @author ppgeneve
 * @Description:
 * @Date 2018/6/15 22:30
 */
abstract class Expression {
    public abstract boolean interpreter(String str);
}

class TerminalExpression extends Expression {
    private String literal = null;

    public TerminalExpression (String str) {
        literal = str;
    }

    @Override
    public boolean interpreter(String str) {
        StringTokenizer st = new StringTokenizer(str);
        while (st.hasMoreTokens()) {
            String test = st.nextToken();
            if (test.equals(literal)) {
                return true;
            }
        }
        return false;
    }
}


class AndExpression extends Expression {

    private Expression expression1 = null;
    private Expression expression2 = null;

    public AndExpression(Expression expression1, Expression expression2) {
        this.expression1 = expression1;
        this.expression2 = expression2;
    }

    @Override
    public boolean interpreter(String str) {
        return expression1.interpreter(str) && expression2.interpreter(str);
    }
}

class OrExpression extends Expression {
    private Expression expression1 = null;
    private Expression expression2 = null;

    public OrExpression(Expression expression1, Expression expression2) {
        this.expression1 = expression1;
        this.expression2 = expression2;
    }

    @Override
    public boolean interpreter(String str) {
        return expression1.interpreter(str) || expression2.interpreter(str);
    }
}

class Client {

    /**
     * 构建解析树
     */
    public static Expression buildInterpreterTree() {
        // Literal
        Expression terminal1 = new TerminalExpression("A");
        Expression terminal2 = new TerminalExpression("B");
        Expression terminal3 = new TerminalExpression("C");
        Expression terminal4 = new TerminalExpression("D");
        // B C
        Expression alternation1 = new OrExpression(terminal2, terminal3);
        // A Or (B C)
        Expression alternation2 = new OrExpression(terminal1, alternation1);
        // D And (A Or (B C))
        return new AndExpression(terminal4, alternation2);
    }

    public static void main(String[] args) {
        Expression define = buildInterpreterTree();
        String context1 = "D A";
        String context2 = "A B";
        System.out.println(define.interpreter(context1));
        System.out.println(define.interpreter(context2));
    }
}