package com.example.quiz;


import java.util.ArrayList;
import java.util.List;

public class QuestionSupply {
    private static List<QuestionList> pizzaQuiz() {
        final List<QuestionList> questionsList = new ArrayList<>();


        final QuestionList question1 = new QuestionList("В какой стране придумали пиццу?",
                "Италия","Испания","Греция","Албания", "Италия"," ");
        questionsList.add(question1);

        final QuestionList question2 = new QuestionList("На что похожа пицца Маргарита?",
                "На живтоное","На флаг Италии","На цветок","На пиццу", "На флаг Италии"," ");
        questionsList.add(question2);

        final QuestionList question3 = new QuestionList("Из какого теста делают пиццу?",
                "Заварное","Дрожжевое","Бездрожжевое","Песочное", "Бездрожжевое"," ");
        questionsList.add(question3);

        final QuestionList question4 = new QuestionList("Повар специализирующийся на приготовлении пиццы?",
                "Пекарь","Ле Пеппино","Пиццайоло","Кондитер", "Пиццайоло"," ");
        questionsList.add(question4);

        final QuestionList question5 = new QuestionList("Что добавляют в овощную пиццу?",
                "Свёкла","Капуста","Сельдерей","Шпинат", "Шпинат"," ");
        questionsList.add(question5);

        final QuestionList question6 = new QuestionList("В каком году придумали пиццу?",
                "1833г.","1522г.","1900г.","1980г.", "1522г."," ");
        questionsList.add(question6);

        final QuestionList question7 = new QuestionList("Что значит слово пицца в переводе с итальянского?",
                "Лепёшка","Кружка","Тарелка","Монета", "Тарелка"," ");
        questionsList.add(question7);

        final QuestionList question8 = new QuestionList("Пицца - тип блюда?",
                "Первое","Второе","Десерт","Третье", "Первое"," ");
        questionsList.add(question8);

        final QuestionList question9 = new QuestionList("В каком году в америке открылась первая пиццерия?",
                "1897г.","1905г.","1947г.","1980г.", "1905г."," ");
        questionsList.add(question9);

        final QuestionList question10 = new QuestionList("В каком году в россии открылась первая пиццерия?",
                "1880г.","1917г.","1990г.","2000г.", "1990г."," ");
        questionsList.add(question10);

        return questionsList;
    }

    private static List<QuestionList> pcQuiz() {
        final List<QuestionList> questionsList = new ArrayList<>();

        final QuestionList question1 = new QuestionList("В какой стране появился первый компьютер?",
                "США","СССР","Великобритания","Германия", "США"," ");
        questionsList.add(question1);

        final QuestionList question2 = new QuestionList("В каком году появился первый компьютер?",
                "1938г.","1941г.","1944г.","1956г.", "1941г."," ");
        questionsList.add(question2);

        final QuestionList question3 = new QuestionList("В каком году появился первый компьютер в СССР?",
                "1941г.","1944г.","1952г.","1964г.", "1952г."," ");
        questionsList.add(question3);

        final QuestionList question4 = new QuestionList("Как назывался первый полностью электронный компьютер?",
                "Берри","IBM PC 5150","Z1","Коллос", "Берри"," ");
        questionsList.add(question4);

        final QuestionList question5 = new QuestionList("Какой вирус считается самым опасным за десятилетие?",
                "ILoveYou","Brain","WannaCry","Zeus", "WannaCry"," ");
        questionsList.add(question5);

        final QuestionList question6 = new QuestionList("Для чего изначально предназначались компьютеры?",
                "Расчет простых данных","Расчёт математических уравнеий","Программирование","Военные цели", "Военные цели"," ");
        questionsList.add(question6);

        final QuestionList question7 = new QuestionList("Сколько оперативной памяти было в первом компьютере?",
                "32 байта","64 байта","32 килобайта","64 килобайта", "64 килобайта"," ");
        questionsList.add(question7);

        final QuestionList question8 = new QuestionList("Лучший язык программирования?",
                "C++","JavaScript","Python","Rust", "Python"," ");
        questionsList.add(question8);

        return questionsList;
    }

    private static List<QuestionList> burgerQuiz() {
        final List<QuestionList> questionsList = new ArrayList<>();

        final QuestionList question1 = new QuestionList("Из какой страны ушёл McDonald's?",
                "Австралия","Россия","Италия","США", "Россия"," ");
        questionsList.add(question1);

        final QuestionList question2 = new QuestionList("Что всегда добавляют в бургер?",
                "Сосиски","Котлета","Брокколли","Пластиковая бутылка", "Котлета"," ");
        questionsList.add(question2);

        final QuestionList question3 = new QuestionList("Какого размера в диаметре был самый большой бургер в мире?",
                "4 метра","5 метров","92 сантиметра","1 метр", "92 сантиметра"," ");
        questionsList.add(question3);

        final QuestionList question4 = new QuestionList("Человек специализирующийся на разработке новых видов бургеров?",
                "Бургеролог","Гамбургёр","Бургерист","Повар", "Бургеролог"," ");
        questionsList.add(question4);

        final QuestionList question5 = new QuestionList("В каком году появился первый бургер?",
                "1917г.","1887г.","1934г.","1999г.", "1934г."," ");
        questionsList.add(question5);

        final QuestionList question6 = new QuestionList("В какой стране появились первые бургеры?",
                "СССР","Косово","США","Сербия", "США"," ");
        questionsList.add(question6);

        final QuestionList question7 = new QuestionList("В каком году в СССР появились первые бургеры?",
                "1937г.","1928г.","1934г.","1992г.", "1937г."," ");
        questionsList.add(question7);

        final QuestionList question8 = new QuestionList("В честь чего назвали Гамбургер?",
                "В честь города Гамбург","В честь человека Гамбурга","Я не придумал","Я хочу пельменей", "В честь города Гамбург"," ");
        questionsList.add(question8);


        return questionsList;
    }

    private static List<QuestionList> idkQuiz() {
        final List<QuestionList> questionsList = new ArrayList<>();

        final QuestionList question1 = new QuestionList("Чей Крым?",
                "Косова","России","Украины","Крымкого ханства", "Крымкого ханства"," ");
        questionsList.add(question1);

        final QuestionList question2 = new QuestionList("1337-228 = ?",
                "666","1000-7","1109","777", "1109"," ");
        questionsList.add(question2);

        final QuestionList question3 = new QuestionList("Когда вайп?",
                "Когда-то","Сегодня","01.07.23","Завтра", "Завтра"," ");
        questionsList.add(question3);

        final QuestionList question4 = new QuestionList("Шёл медведь по лесу, видит машина горит, сел в неё",
                "И умер","И уехал","И поехал","И сгорел", "И сгорел"," ");
        questionsList.add(question4);

        final QuestionList question5 = new QuestionList(" - Надо гранату за пятёрку? - Гонишь? Давай!",
                "На держи! И убежал","На держи! А за кольцо гони две сотни","На держи!","На держи! Только гранату с чекой не переутай", "На держи! А за кольцо гони две сотни"," ");
        questionsList.add(question5);

        final QuestionList question6 = new QuestionList("Как тебе анекдоты?",
                "Смешно","Очень смешно","Хрень","Говно", "Говно"," ");
        questionsList.add(question6);

        final QuestionList question7 = new QuestionList("Проверь удачу",
                "1.","2.","3.","4.", "3."," ");
        questionsList.add(question7);

        final QuestionList question8 = new QuestionList("По мёду выпьем?",
                "Очень да","Да","Нет","Другое нет", "Очень да"," ");
        questionsList.add(question8);

        return questionsList;
    }


    public static List<QuestionList> getQuestions(String selectedTopicName) {
        switch (selectedTopicName) {
            case "Pizza":
                return pizzaQuiz();
            case "PC":
                return pcQuiz();
            case "Burger":
                return burgerQuiz();
            default: return idkQuiz();
        }
    }
}
