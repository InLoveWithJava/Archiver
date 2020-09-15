package com.javarush.task.task31.task3110;

import com.javarush.task.task31.task3110.command.ExitCommand;
import com.javarush.task.task31.task3110.exception.WrongZipFileException;

import java.io.IOException;

public class Archiver {
    public static void main(String[] args) {
        Operation operation = null;
        do {
            try {
                operation = askOperation();
                CommandExecutor.execute(operation);
            } catch (WrongZipFileException e) {
                ConsoleHelper.writeMessage("Вы не выбрали файл архива или выбрали неверный файл.");
            } catch (Exception e) {
                ConsoleHelper.writeMessage("Произошла ошибка. Проверьте введенные данные.");
            }
        } while (operation != Operation.EXIT);
    }

    public static Operation askOperation() throws IOException {
        ConsoleHelper.writeMessage("Выберите операцию:");
        ConsoleHelper.writeMessage("" + Operation.CREATE.ordinal() + " - упаковать файлы в архив");
        ConsoleHelper.writeMessage("" + Operation.ADD.ordinal() + " - добавить файл в архив");
        ConsoleHelper.writeMessage("" + Operation.REMOVE.ordinal() + " - удалить файл из архива");
        ConsoleHelper.writeMessage("" + Operation.EXTRACT.ordinal() + " - распаковать архив");
        ConsoleHelper.writeMessage("" + Operation.CONTENT.ordinal() + " - посмотреть содержимое архива");
        ConsoleHelper.writeMessage("" + Operation.EXIT.ordinal() + " - выход");
        int number = ConsoleHelper.readInt();
        Operation operation = null;
        for (Operation o : Operation.values()) {
            if (o.ordinal() == number) {
                operation = o;
                break;
            }
        }
        return operation;
    }
}
