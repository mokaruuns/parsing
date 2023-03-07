package my_gen;

import java.util.*;
import java.io.*;
import java.util.regex.*;

import my_gen.Tree;
import my_gen.Lexer;

public class Parser {
    private final String EPS = "EPSILON";
    private final String END = "END";
    Lexer lexer;

    public Tree parse(String input, Lexer lexer) {
        lexer = new Lexer(input);
        lexer.nextToken();
        Tree tree = expr();
        return tree;
    }

    private Tree expr() {
        Tree tree = new Tree("expr");
        switch (lexer.getToken()) {
            case OPEN:
            case NUMBER:
                term();
                exprPrime();


            default:
                throw new RuntimeException("Unexpected token: " + lexer.getToken());
        }
        return tree;
    }

    private Tree exprPrime() {
        Tree tree = new Tree("exprPrime");
        switch (lexer.getToken()) {
            case SUM:
                nextToken();
                term();
                exprPrime();

            case SUB:
                nextToken();
                term();
                exprPrime();

            case END:
            case CLOSE:
                nextToken();


            default:
                throw new RuntimeException("Unexpected token: " + lexer.getToken());
        }
        return tree;
    }

    private Tree term() {
        Tree tree = new Tree("term");
        switch (lexer.getToken()) {
            case OPEN:
            case NUMBER:
                factor();
                termPrime();


            default:
                throw new RuntimeException("Unexpected token: " + lexer.getToken());
        }
        return tree;
    }

    private Tree termPrime() {
        Tree tree = new Tree("termPrime");
        switch (lexer.getToken()) {
            case MUL:
                nextToken();
                factor();
                termPrime();

            case DIV:
                nextToken();
                factor();
                termPrime();

            case SUM:
            case SUB:
            case END:
            case CLOSE:
                nextToken();


            default:
                throw new RuntimeException("Unexpected token: " + lexer.getToken());
        }
        return tree;
    }

    private Tree factor() {
        Tree tree = new Tree("factor");
        switch (lexer.getToken()) {
            case OPEN:
                nextToken();
                expr();
                nextToken();

            case NUMBER:
                nextToken();


            default:
                throw new RuntimeException("Unexpected token: " + lexer.getToken());
        }
        return tree;
    }

}