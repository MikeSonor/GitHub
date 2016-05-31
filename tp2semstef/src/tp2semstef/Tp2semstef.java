package tp2semstef; 

import java.io.IOException; //Импорт необходимых библиотек
import java.util.Scanner;   //

public class Tp2semstef {
    
    public static void main(String[] args) throws IOException {
        Scanner read = new Scanner(System.in); //Объявляем сканер для считывания ток которые ввел юзер.
        String sourceFilePath;  //Переменная в которую будет записан путь к исходному файлу.
        String resultFilePath1; //Переменная в которую будет записан путь к одному из выходный файлов.
        String resultFilePath2; //Переменная в которую будет записан путь к второму из выходных файлов.
        TextProcessor tp = new TextProcessor(); //Объявляем путь к второму классу программы.
        System.out.println("##############################################\n##-----------------Welcome!!----------------##\n##------------------------------------------##\n##----------Group 50IST---Work-№2-----------##\n##------------------------------------------##\n##--------Technology-Of-Programming---------##\n##------------------------------------------##\n##---Student:-Telegov-Mikhail-Alexeevich----##\n##-----------------------a.k.a.-Mike-Sonor--##\n##------------------------------------------##\n##---Code:--153210----------Data:-30.05.16--##\n##############################################");
        boolean ok = true; //Служебная переменная для последующего цикла.
        String s;   //Служебная переменная.
        while(ok){ //Цикл ввода и проверки путей.
            System.out.print("Please, enter source file path: ");
            sourceFilePath = read.nextLine();
            System.out.println();
            System.out.print("Please, enter result file path 1: ");
            resultFilePath1 = read.nextLine();
            System.out.println();
            System.out.print("Please, enter result file path 2: ");
            resultFilePath2 = read.nextLine();
            System.out.println();
            System.out.println("Youre configuration of path is: \n Source File: "+sourceFilePath+"\n Result File 1: "+resultFilePath1+"\n Result file 2: "+resultFilePath2+"\n this is correct? \n Yes||NO");
            s = read.nextLine();
            switch(s) { //Кейсы для проверки всех возможных вариантов утвердительного ответа.
                case "YES":
                    tp = new TextProcessor(sourceFilePath, resultFilePath1, resultFilePath2);
                    ok = false;
                    break;
                case "yes":
                    tp = new TextProcessor(sourceFilePath, resultFilePath1, resultFilePath2);
                    ok = false;
                    break;
                case "y":
                    tp = new TextProcessor(sourceFilePath, resultFilePath1, resultFilePath2);
                    ok = false;
                    break;
                default:
                    System.out.println("Ok... Let's try again!");
                    break;
            }
        } 
        tp.MakeTask(); //Передаем "эстафету" основной "лошадке"
        System.out.println("@#################################@\n@#----------Thank--You!----------#@\n@#-------------------------------#@\n@#--Contacts:--------------------#@\n@#-------------------------------#@\n@#-------E-Mail:dark@darkinc.ru--#@\n@#-------------------------------#@\n@#-------vk.com/mikesonor--------#@\n@#-------------------------------#@\n@#-------icq:--693445294---------#@\n@#-------------------------------#@\n@#-------Skype:--Himik291--------#@\n@#################################@\n");
    }
}
