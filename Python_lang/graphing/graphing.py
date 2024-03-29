# В ячейке ниже представлен код генерирующий DataFrame, которая состоит всего из 1 столбца.
# Ваша задача перевести его в one hot вид. Сможете ли вы это сделать без get_dummies?

# Генерируем DataFrame (исходный код)
import pandas as pd
import random
lst = ['robot'] * 10
lst += ['human'] * 10
random.shuffle(lst)
data = pd.DataFrame({'whoAmI':lst})
# data.head()
#print(data)

# Преобразование one hot вид с помощью метода get_dummies
# print(pd.get_dummies(data['whoAmI']))

# Преобразование one hot вид с помощью метода встроенных функций pandas
# Создаём новые столбцы
data['is_robot'] = (data['whoAmI'] == 'robot')
data['is_human'] = (data['whoAmI'] == 'human')

# Удаляем исходный столбец 'whoAmI'
data.drop('whoAmI', axis=1, inplace=True)

print(data)



