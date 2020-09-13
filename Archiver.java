package com.javarush.task.task31.task3110;

import java.nio.file.Paths;

import static com.javarush.task.task31.task3110.ConsoleHelper.readString;
import static com.javarush.task.task31.task3110.ConsoleHelper.writeMessage;

public class Archiver {
    public static void main(String[] args) {
        writeMessage("Введите полный путь архива:");
        ZipFileManager zipFileManager = new ZipFileManager(Paths.get(readString()));
        writeMessage("Введите путь к файлу, который будем архивировать:");
        try {
            zipFileManager.createZip(Paths.get(readString()));
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }
}
