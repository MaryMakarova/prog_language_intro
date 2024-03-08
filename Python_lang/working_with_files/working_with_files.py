#Дополнить справочник возможностью копирования данных из одного файла в другой.
#Пользователь вводит номер строки, которую необходимо перенести из одного файла в другой.

import pandas as pd

# Получаем номер строки от пользователя
row_number = int(input("Enter the row number you want to copy: "))

# Загружаем данные из первого файла
data1 = pd.read_csv('file1.csv')

# Проверяем, что номер строки не превышает размер данных
if row_number < len(data1):
    # Выбираем строку по индексу
    row_to_copy = data1.iloc[row_number]
    
    # Загружаем данные из второго файла
    data2 = pd.read_csv('file2.csv')
    
    # Добавляем строку во второй файл
    data2 = data2._append(row_to_copy)
    
    # Сохраняем изменения во втором файле
    data2.to_csv('file2.csv', index=False)
    print(f"Row {row_number} has been successfully copied to the second file.")
else:
    print("Error: The row number is greater than the length of the data.")