/*2. Написать класс домашнее животное. Свойствами класса будут вес, кличка и принадлежность к определённому типу
(коровы, гуси, собаки и так далее), нужно их написать в классе. В классе с главным методом создайте
свое домашнее животное. Выведите в консоль:
println("Домашнее животное: " + … +
"Кличка: " + …. +
"Вес: " + …);

3. Даны переменная с плавающей точкой, равная 5,87. Необходимо привести ее к целочисленному типу.*/

fun main(){
/*1. Создать класс вертолет со свойствами название(имя), взлетный вес, скорость полета, максимальная высота полета.
В классе с методом main создать экземпляр этого класса, например, alligator, свойствам задать конкретные значения.
Вывести в консоль строку: «Спроектировали вертолет с названием… скоростью полета… весом… высотой полета…»*/
val helAlligator = Helicopter()
helAlligator.name = "Ка-52 Alligator"
helAlligator.takeOffWeight = 10800
helAlligator.speed = 310
helAlligator.maxAltitude = 5500
println("1.\tСпроектировали вертолет с названием ${helAlligator.name} со скоростью полета ${helAlligator.speed} км/ч,\n\t" +
        "весом ${helAlligator.takeOffWeight} кг и высотой полета ${helAlligator.maxAltitude} м над уровнем моря")
}