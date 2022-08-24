import java.util.LinkedList;
import java.util.Queue;

public class RecentCounter {
    //Гарантируется, что каждый вызов ping использует строго большее значение t,
    // чем предыдущий вызов.
    // - Значит можно использовать очередь, так "старые" вызовы будут ненужны
    LinkedList<Integer> queue;

    public RecentCounter() {
        queue = new LinkedList<>();
    }

    public int ping(int t) {
        /**
         * добавили в конец очереди
         */
        queue.addLast(t); // добавили. Так как в условиях -(и возвращает количество запросов, которые произошли за последние 3000 миллисекунд (включая новый запрос).)
        // удаляем все элементы которые были до 3000мс минус t
        // так как следующий запрос будет гарантируемо больше t и старые данные будут ненужны.
        int deleteIndex = t - 3000;
        while (queue.peek() < deleteIndex) {
            /**
             * удаляем с начала очереди
             */
            queue.removeFirst();
        }
        return queue.size();
    }
}
/*
Пример 1:

        Вход
        ['RecentCounter', 'пинг', 'пинг', 'пинг', 'пинг']
        [           [],     [1],   [100], [3001], [3002]]
        Выход
        [ноль, 1, 2, 3, 3]

        Объяснение
        RecentCounter RecentCounter = новый RecentCounter(); ,                            возврат 0
        недавнийСчетчик.ping(1); // запросы = [1], диапазон [-2999,1],                    возврат 1
        недавнийСчетчик.ping(100); // запросы = [1, 100], диапазон [-2900,100],           возврат 2
        недавнийСчетчик.ping(3001); // запросы = [1, 100, 3001], диапазон [1,3001],       возврат 3
        недавнийСчетчик.ping(3002); // запросы = [1, 100, 3001, 3002], диапазон [2,3002], возврат 3
*/