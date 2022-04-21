
# logs

The application checks the changes in the file (/var/log/auth.log) and writes the data to the blockchain.
Checking and receiving changes are implemented inside the Records class using two static methods:

- Check file checks the changes in the file.
Due to the peculiarity of this folder, all changes occur by adding new lines to the file.
Thus, this method determines the changes and their number.

- Get Last Records reads the last n recorded lines inside the file.

Changed the createAsset() and readAssetById() methods

Приложение проверяет изменения в файле (/var/log/auth.log) и пишет данные в блокчейн. 
Проверка и получение изменений реализованы внутри класса Records с помощью двух статических методов:

- СheckFile проверяет изменения в файле. 
В связи с особенностью данной папки, считаем что вся изменеия происходят за счет добавления в файл новых строк. 
Таким образом данный метод определяет изменеия и их количество.

- GetLastRecords считывает последнии n записанных строк внутри файла.

Изменены методы createAsset() и readAssetById()

Блокчейн сеть должна быть основана на HLF2(Hyperleger Fabric 2.0).
