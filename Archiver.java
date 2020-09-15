package com.javarush.task.task31.task3110;

import com.javarush.task.task31.task3110.command.ExitCommand;

import java.nio.file.Paths;

public class Archiver {
    public static void main(String[] args) {
        try {
            ConsoleHelper.writeMessage("Введите полный путь архива:");
            ZipFileManager zipFileManager = new ZipFileManager(Paths.get(ConsoleHelper.readString()));
            ConsoleHelper.writeMessage("Введите путь к файлу, который будем архивировать:");
            try {
                zipFileManager.createZip(Paths.get(ConsoleHelper.readString()));
            } catch (Exception exception) {
                exception.printStackTrace();
            }
            ExitCommand exitCommand = new ExitCommand();
            exitCommand.execute();
        } catch (Exception e) {
            ConsoleHelper.writeMessage("Ошибка");
        }
    }
}
