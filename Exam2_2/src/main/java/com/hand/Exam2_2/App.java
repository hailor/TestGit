package com.hand.Exam2_2;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        new Thread(new ServerListener()).start();
    }
}
