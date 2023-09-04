package com.labs.java.core;

public class CmdLineArgsDemo {

    public static void main(String[] args) {
        if (args.length == 0){
            System.out.println("no args are mentioned");

            System.exit(0);

        }

        for (String arg:args){
            System.out.println(arg);
//


//            System.out.println(args[1].toLowerCase());
//            String reverse = args[2];
//            for (int i=0; i==reverse.length(); i--){
//                System.out.println(reverse.charAt(i));
//
//            }
//            System.out.println();

        }
        System.out.println("Length of the first argument: " + args[0].length());
        System.out.println("lowercase of the second argument: " + args[1].toLowerCase());
        for (int i = 0; i<=args[3].length(); i++){

//            if (args[3] == 0);

        }


        // show length of the first argument value

// convert second argument to lower case
// print third argument in reverse
// skip the fourth arg
// show the sub string [4,11] of fifth argument
// split sixth argument by , and show the tokens

    }

}
