## РС лабораторная 4
`src\main\java\rsLab4\ReadMessageMDB.java` - Message Driven Bean (MDB), который читает сообщение из заданной очереди (queue) и выводит в консоль.

`src\main\java\rsLab4\SendMessageServlet.java` - сервлет, который отправляет сообщение в заданную очередь (queue) используя заданный ConnectionFactory.

Отправка сообщения: в браузере открыть http://localhost:8080/rsLab4/SendMessageServlet?text=TEXT, где `TEXT` – текст сообщения.

Запускал на сервере WildFly 26.0.1. Должен подойти любой сервер, реализующий Java EE в полном объеме. 

Источники:
1. https://www.baeldung.com/ejb-message-driven-beans
2. https://github.com/eugenp/tutorials/tree/master/spring-ejb/wildfly/wildfly-mdb - репозиторий [1]