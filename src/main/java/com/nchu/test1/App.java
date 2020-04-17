package com.nchu.test1;

import org.apache.commons.codec.digest.DigestUtils;

import java.io.*;
import java.util.Scanner;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) throws IOException {
        if (args.length < 1) {
            System.err.println("Please provide an input!");
            System.exit(0);
        }
        Scanner input = new Scanner(System.in);
        System.out.println("Input your Name");
        String name = input.nextLine();
        System.out.println("Input your Password");
        String pwd = input.nextLine();

        String str = readFile();
        str = str.replaceAll("\n", "");
        String[] str1 = str.split(";");
        String realName = str1[0].split(":")[1];
        String realPwd = str1[1].split(":")[1];

        String afterPwd = sha256hex(pwd);
        if (name.equals(realName) && afterPwd.equals(realPwd)) {
            System.out.println("Login Success!");
            System.exit(0);
        } else {
            System.out.println("userName or Password wrong!");
            System.exit(-1);
        }

//        System.out.println(sha256hex(args[0]));
    }

    public static String sha256hex(String input) {
        return DigestUtils.sha256Hex(input);
    }

    public static String readFile() throws IOException {
        File file = new File("F:\\login.txt");//定义一个file对象，用来初始化FileReader
        FileReader reader = new FileReader(file);//定义一个fileReader对象，用来初始化BufferedReader
        BufferedReader bReader = new BufferedReader(reader);//new一个BufferedReader对象，将文件内容读取到缓存
        StringBuilder sb = new StringBuilder();//定义一个字符串缓存，将字符串存放缓存中
        String s = "";
        while ((s = bReader.readLine()) != null) {//逐行读取文件内容，不读取换行符和末尾的空格
            sb.append(s + "\n");//将读取的字符串添加换行符后累加存放在缓存中
//            System.out.println(s);
        }
        bReader.close();
        String str = sb.toString();
//        System.out.println(str );
        return str;
    }

}
